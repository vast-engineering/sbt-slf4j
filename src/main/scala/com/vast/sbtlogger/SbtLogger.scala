package com.vast.sbtlogger

import org.slf4j.Logger
import org.slf4j.helpers.{MessageFormatter, MarkerIgnoringBase}

import scala.util.DynamicVariable

object SbtLogger {
  val currentSbtLogger: DynamicVariable[Option[sbt.Logger]] = new DynamicVariable(None)

  def withLogger[T](l: sbt.Logger)(f: => T): T = {
    currentSbtLogger.withValue(Some(l))(f)
  }
}

class SbtLogger(sbtLogger: sbt.Logger) extends MarkerIgnoringBase with Logger {

  import LogLevels._

  override def isErrorEnabled: Boolean = true
  override def isWarnEnabled: Boolean = true
  override def isInfoEnabled: Boolean = true
  override def isDebugEnabled: Boolean = false
  override def isTraceEnabled: Boolean = false

  override def warn(msg: String): Unit = writeLogMessage(WARN, Some(msg))
  override def warn(format: String, arg: scala.Any): Unit = formatAndLog(WARN, format, arg)
  override def warn(format: String, arg1: scala.Any, arg2: scala.Any): Unit = formatAndLog(WARN, format, arg1, arg2)
  override def warn(format: String, arguments: AnyRef*): Unit = formatAndLog(WARN, format, arguments)
  override def warn(msg: String, t: Throwable): Unit = writeLogMessage(WARN, Some(msg), Some(t))

  override def error(msg: String): Unit = writeLogMessage(ERROR, Some(msg))
  override def error(format: String, arg: scala.Any): Unit = formatAndLog(ERROR, format, arg)
  override def error(format: String, arg1: scala.Any, arg2: scala.Any): Unit = formatAndLog(ERROR, format, arg1, arg2)
  override def error(format: String, arguments: AnyRef*): Unit = formatAndLog(ERROR, format, arguments)
  override def error(msg: String, t: Throwable): Unit = writeLogMessage(ERROR, Some(msg), Some(t))

  override def debug(msg: String): Unit = writeLogMessage(DEBUG, Some(msg))
  override def debug(format: String, arg: scala.Any): Unit = formatAndLog(DEBUG, format, arg)
  override def debug(format: String, arg1: scala.Any, arg2: scala.Any): Unit = formatAndLog(DEBUG, format, arg1, arg2)
  override def debug(format: String, arguments: AnyRef*): Unit = formatAndLog(DEBUG, format, arguments)
  override def debug(msg: String, t: Throwable): Unit = writeLogMessage(DEBUG, Some(msg), Some(t))

  override def trace(msg: String): Unit = writeLogMessage(TRACE, Some(msg))
  override def trace(format: String, arg: scala.Any): Unit = formatAndLog(TRACE, format, arg)
  override def trace(format: String, arg1: scala.Any, arg2: scala.Any): Unit = formatAndLog(TRACE, format, arg1, arg2)
  override def trace(format: String, arguments: AnyRef*): Unit = formatAndLog(TRACE, format, arguments)
  override def trace(msg: String, t: Throwable): Unit = writeLogMessage(TRACE, Some(msg), Some(t))

  override def info(msg: String): Unit = writeLogMessage(INFO, Some(msg))
  override def info(format: String, arg: scala.Any): Unit = formatAndLog(INFO, format, arg)
  override def info(format: String, arg1: scala.Any, arg2: scala.Any): Unit = formatAndLog(INFO, format, arg1, arg2)
  override def info(format: String, arguments: AnyRef*): Unit = formatAndLog(INFO, format, arguments)
  override def info(msg: String, t: Throwable): Unit = writeLogMessage(INFO, Some(msg), Some(t))

  private def formatAndLog(level: LogLevels, format: String, arg: Any) {
    val tuple = MessageFormatter.format(format, arg)
    writeLogMessage(level, Option(tuple.getMessage), Option(tuple.getThrowable))
  }

  private def formatAndLog(level: LogLevels, format: String, arg1: Any, arg2: Any) {
    val tuple = MessageFormatter.format(format, arg1, arg2)
    writeLogMessage(level, Option(tuple.getMessage), Option(tuple.getThrowable))
  }

  private def formatAndLog(level: LogLevels, format: String, arguments: AnyRef*) {
    val tuple = MessageFormatter.arrayFormat(format, arguments.toArray)
    writeLogMessage(level, Option(tuple.getMessage), Option(tuple.getThrowable))
  }

  private def writeLogMessage(level: LogLevels, message: Option[String], t: Option[Throwable] = None) {

    message.foreach { m =>
      level match {
        case TRACE => sbtLogger.debug(m)
        case DEBUG => sbtLogger.debug(m)
        case INFO => sbtLogger.info(m)
        case WARN => sbtLogger.warn(m)
        case ERROR => sbtLogger.error(m)
      }
    }
    t.foreach((t: Throwable) => sbtLogger.trace(t))
  }


}