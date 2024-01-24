package util

import util.types.LogType
import util.types.LogType._

import java.util.Calendar
import java.text.SimpleDateFormat

object LogLib {

  private val infoOn: Boolean = true
  private val infoTag: LogType = LogType.Info

  private val warnOn: Boolean = true
  private val warnTag: LogType = LogType.Warn

  private val dateFormatMask: String = "yy/MM/dd hh:mm:ss"

  def showInfo(message: String): Unit = {
    printValue(message, infoTag, infoOn)
  }

  def showWarn(message: String): Unit = {
    printValue(message, warnTag, warnOn)
  }

  private def printValue(message: String, tag: LogType, on: Boolean) : Unit = {
    if (on) {
      val dateFormat = new SimpleDateFormat(dateFormatMask)
      val timeOfNow = Calendar.getInstance().getTime

      println(s"${dateFormat.format(timeOfNow)} ${tag.toString} $message")
    }
  }
}
