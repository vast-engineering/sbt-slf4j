package org.slf4j.impl

import org.slf4j.ILoggerFactory
import org.slf4j.Logger

import com.vast.sbtlogger._

class SbtLoggerFactory extends ILoggerFactory {
  override def getLogger(name: String): Logger = {
    SbtLogger.currentSbtLogger.value match {
      case Some(sbtLogger) => new SbtLogger(sbtLogger)
      case None => new NullLogger
    }
  }
}

