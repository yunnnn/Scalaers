package ScalaSandbox

object HelloWorld{
  def main(args: Array[String]) {
    println("Hello, world!")
    println(StaticObject.staticFunctionPlus4(5))
    println(StaticObject.noReturn(5))
    println(StaticObject.simple(5))
    println(StaticObject.simpleNoReturn(5))

    val sample = new Sample(4)
    println(sample instMeth 5)
    require(sample.instMeth(5) == 9, "gotta be 9")

    val sample2 = new Sample(4,10)
    println(sample2.instMeth2)

    println("should be less than 10: " + sample2.fun2returns(1))
    println("self: " + sample2.fun2returns(100))
  }

}