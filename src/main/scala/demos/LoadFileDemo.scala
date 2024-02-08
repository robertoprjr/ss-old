package demos

import libs.LoadFileLib._
import libs.StartLib._
import vars.DefaultVar

object LoadFileDemo {

  def show(): Unit = {

    val spark = buildSparkLocalSession(DefaultVar.appName, DefaultVar.coreNumbers)
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

    df.show(DefaultVar.showLines)
  }
}
