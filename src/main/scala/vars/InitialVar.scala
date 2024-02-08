package vars

object InitialVar {

  val commonSparkConfigVars: Map[String, String] = Map(
    "spark.sql.shuffle.partitions" -> "30",
    "spark.shuffle.compress" -> "true",
    "spark.eventLog.enabled" -> "false"
  )
}
