package libs

import libs.LogLib._
import org.apache.spark.sql.{DataFrame, SparkSession}

object LoadFileLib {

  def loadCSVFileToDF(spark: SparkSession,
                      filePath: String,
                      headerOn: Boolean = false,
                      printSchemaOn: Boolean = false): DataFrame = {

    val headerOption = "header"
    val df = spark.read.option(headerOption, headerOn).csv(filePath)

    showInfo(s"File $filePath loaded...")
    if (printSchemaOn) df.printSchema()

    df
  }
}
