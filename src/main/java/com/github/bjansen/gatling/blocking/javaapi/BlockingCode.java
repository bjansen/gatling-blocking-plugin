package com.github.bjansen.gatling.blocking.javaapi;

import com.github.bjansen.gatling.blocking.javaapi.actions.BlockingActionBuilder;

public class BlockingCode {
	private final String description;

	public BlockingCode(String description) {
		this.description = description;
	}
	
	public BlockingActionBuilder run(Runnable runnable) {
		return new BlockingActionBuilder(description, runnable);
	}
}
