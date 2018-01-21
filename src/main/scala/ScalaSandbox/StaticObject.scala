package ScalaSandbox

import scala.annotation.switch

object StaticObject {

  def staticFunctionPlus4(a: Int): Int = {
    return a + 4
  }

  def noReturn(a: Int) = {
    a + 4
  }

  def simpleNoReturn(a: Int) = a + 4

  def simple(a: Int): Int = a + 4

  def printSimple(a: Int): Unit = {
    print("funky")
  }

  def printSimpleUnit(a: Int): Unit = {
    print("funky")
  }

  def procedure {println("fudgey")}

  val i = 10
  @switch
  val month = i match {
    case 1  => "January"
    case 2  => "February"
    case 3  => "March"
    case 4  => "April"
    case 5  => "May"
    case 6  => "June"
    case 7  => "July"
    case 8  => "August"
    case 9  => "September"
    case 10 => "October"
    case 11 => "November"
    case 12 => "December"
    case _  => "Invalid month"  // the default, catch-all
  }
}

