package com.github.bjansen.gatling.blocking

import com.github.bjansen.gatling.blocking.BlockingCodeDsl.blocking
import com.github.bjansen.gatling.blocking.protocol.BlockingCodeProtocol
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation

import java.util.concurrent.Executors
import scala.concurrent.duration._

class ScalaDemo extends Simulation {

  private val scn = scenario("test")
    .exec(
      blocking("my blocking code")
        .run(() => runBlockingCode())
    )

  private val blockingCodeProtocol = new BlockingCodeProtocol(Executors.newVirtualThreadPerTaskExecutor())

  def runBlockingCode(): Unit = {
    // Your blocking code here
    Thread.sleep(1000)
  }

  setUp(
    scn.inject(
      rampUsersPerSec(2).to(100_000).during(10.seconds)
    ).protocols(blockingCodeProtocol)
  )
}
