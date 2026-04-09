package com.github.bjansen.gatling.blocking.javaapi;

public class BlockingCodeDsl {
	
	public static BlockingCode blocking(String description) {
		return new BlockingCode(description);
	}

}
