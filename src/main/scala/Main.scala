import demo._

object Main {
  def main(args: Array[String]): Unit = {
    println("--- BEGIN :: Main Execute ----")
    DemoExecution.show()

    Console.in.read()
    println("--- END :: Main Execute ------")
  }
}