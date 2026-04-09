package com.github.bjansen.gatling.blocking.javaapi.actions;

import io.gatling.javaapi.core.ActionBuilder;

public class BlockingActionBuilder implements ActionBuilder {
	
	private final String description;
	private final Runnable runnable;

	public BlockingActionBuilder(String description, Runnable runnable) {
		this.description = description;
		this.runnable = runnable;
	}

	@Override
	public io.gatling.core.action.builder.ActionBuilder asScala() {
		return new com.github.bjansen.gatling.blocking.actions.BlockingActionBuilder(description, runnable);
	}
}
