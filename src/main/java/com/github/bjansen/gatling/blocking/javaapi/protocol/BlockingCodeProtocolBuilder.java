package com.github.bjansen.gatling.blocking.javaapi.protocol;

import com.github.bjansen.gatling.blocking.protocol.BlockingCodeProtocol;
import io.gatling.core.protocol.Protocol;
import io.gatling.javaapi.core.ProtocolBuilder;

import java.util.concurrent.ExecutorService;

public class BlockingCodeProtocolBuilder implements ProtocolBuilder {

	private final ExecutorService executor;

	public BlockingCodeProtocolBuilder(ExecutorService executor) {
		this.executor = executor;
	}

	@Override
	public Protocol protocol() {
		return new BlockingCodeProtocol(executor);
	}
}
