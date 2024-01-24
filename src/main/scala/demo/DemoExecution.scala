package demo

import util.LoadFileLib._
import util.StartLib._

object DemoExecution {

  def show(): Unit = {

    val appName: String = "rprjTest.com"
    val cors: Int = 4

    val spark = buildSparkLocalSession(appName, cors)
    import spark.implicits._

    val demo01FilePath: String = "data/countries-table.csv"
    val demo01HeaderOn: Boolean = true
    val demo01PrintSchemaOn: Boolean = true

    val df = loadCSVFileToDF(
      spark,
      filePath = demo01FilePath,
      headerOn = demo01HeaderOn,
      printSchemaOn = demo01PrintSchemaOn
    )

    df.show(10)
  }
}
