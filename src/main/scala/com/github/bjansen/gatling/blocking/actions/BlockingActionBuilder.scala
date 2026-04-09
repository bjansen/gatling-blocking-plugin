package com.github.bjansen.gatling.blocking.actions

import io.gatling.core.action.Action
import io.gatling.core.action.builder.ActionBuilder
import io.gatling.core.structure.ScenarioContext

class BlockingActionBuilder(description: String, runnable: Runnable) extends ActionBuilder {

  override def build(ctx: ScenarioContext, next: Action): Action = {
    new BlockingCodeAction(description, runnable, ctx, next)
  }
}
