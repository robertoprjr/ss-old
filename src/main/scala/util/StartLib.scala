package util

import org.apache.spark.sql.SparkSession
import util.LogLib.showInfo

object StartLib {

  private val commonSparkConfigVars: Map[String, String] = Map(
    "spark.sql.shuffle.partitions" -> "30",
    "spark.shuffle.compress" -> "true",
    "spark.eventLog.enabled" -> "false"
  )

  private def getSparkConfigVarsForLocalSession: Map[String, String] = {
    commonSparkConfigVars
  }

  def buildSparkLocalSession(appName: String,
                               cors: Int = 1): SparkSession = {

    val sparkBuilder: SparkSession.Builder = SparkSession.builder()
      .master(s"local[$cors]")
      .appName(appName)

    for (configVar <- getSparkConfigVarsForLocalSession) {
      sparkBuilder.config(configVar._1, configVar._2)
    }

    val spark = sparkBuilder.getOrCreate()
    showInfo(s"Spark app ${spark.conf.get("spark.app.name")} started...")

    spark
  }
}
