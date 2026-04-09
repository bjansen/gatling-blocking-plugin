package com.github.bjansen.gatling.blocking.protocol

import io.gatling.core.protocol.ProtocolComponents
import io.gatling.core.session.Session

class BlockingCodeProtocolComponents(var blockingCodeProtocol: BlockingCodeProtocol) extends ProtocolComponents {

  override def onStart: Session => Session = Session.Identity

  override def onExit: Session => Unit = ProtocolComponents.NoopOnExit
}
