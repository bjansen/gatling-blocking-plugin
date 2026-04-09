package com.github.bjansen.gatling.blocking.actions

import com.github.bjansen.gatling.blocking.protocol.BlockingCodeProtocolKey
import io.gatling.commons.stats.{KO, OK}
import io.gatling.commons.util.Clock
import io.gatling.commons.validation.Validation
import io.gatling.core.Predef.value2Success
import io.gatling.core.action.{Action, RequestAction}
import io.gatling.core.controller.throttle.Throttler
import io.gatling.core.session.{Expression, Session}
import io.gatling.core.stats.StatsEngine
import io.gatling.core.structure.ScenarioContext

class BlockingCodeAction(_name: String, runnable: Runnable, ctx: ScenarioContext, _next: Action) extends RequestAction {

  override def requestName: Expression[String] =
    session => value2Success("hello")

  override def sendRequest(session: Session): Validation[Unit] = {
    ctx.coreComponents.throttler match {
      case Some(th) => th ! Throttler.Command.ThrottledRequest(session.scenario, () => runInExecutor(session))
      case _ => runInExecutor(session)
    }

    Validation.unit
  }

  private def runInExecutor(session: Session): Unit = {
    val components = ctx.protocolComponentsRegistry.components(BlockingCodeProtocolKey)

    components.blockingCodeProtocol.executor.submit(new Runnable {
      override def run(): Unit = {
        doRun(session)
      }
    })
  }

  private def doRun(session: Session): Unit = {
    val start = clock.nowMillis
    var ex: Throwable = null

    try {
      runnable.run()
    } catch {
      case t: Throwable => {

        ex = t
      }
    }

    val stop = clock.nowMillis

    if (ex == null) {
      ctx.coreComponents.statsEngine.logResponse(session.scenario, session.groups, _name, start, stop, OK, None, None)
    } else {
      ctx.coreComponents.statsEngine.logResponse(session.scenario, session.groups, _name, start, stop, KO, Some("Error"), Some(ex.getMessage))
    }

    next ! session
  }

  override def clock: Clock = ctx.coreComponents.clock

  override def statsEngine: StatsEngine = ctx.coreComponents.statsEngine

  override def next: Action = _next

  override def name: String = _name
}
