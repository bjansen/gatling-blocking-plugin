package com.github.bjansen.gatling.blocking

import com.github.bjansen.gatling.blocking.actions.BlockingActionBuilder
import io.gatling.core.action.builder.ActionBuilder

class BlockingCode(description: String) {

	def run(method: Runnable): ActionBuilder =
		new BlockingActionBuilder(description, method)

}




