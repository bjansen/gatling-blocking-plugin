package com.github.bjansen.gatling.blocking

object BlockingCodeDsl {

  def blocking(description: String) = new BlockingCode(description)
  
}
