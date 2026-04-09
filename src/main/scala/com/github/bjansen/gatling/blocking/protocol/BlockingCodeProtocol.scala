package com.github.bjansen.gatling.blocking.protocol

import io.gatling.core.CoreComponents
import io.gatling.core.config.GatlingConfiguration
import io.gatling.core.protocol.{Protocol, ProtocolKey}

import java.util.concurrent.ExecutorService

class BlockingCodeProtocol(var executor: ExecutorService) extends Protocol {

}

object BlockingCodeProtocolKey extends ProtocolKey[BlockingCodeProtocol, BlockingCodeProtocolComponents] {
  override def protocolClass: Class[Protocol] = classOf[BlockingCodeProtocol].asInstanceOf[Class[Protocol]]

  override def defaultProtocolValue(configuration: GatlingConfiguration): BlockingCodeProtocol =
    throw new IllegalStateException("Can't provide a default value for BlockingCodeProtocol")

  override def newComponents(coreComponents: CoreComponents): BlockingCodeProtocol => BlockingCodeProtocolComponents =
    blocking => new BlockingCodeProtocolComponents(blocking)
}


