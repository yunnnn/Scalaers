package ScalaSandbox

class Sample(x: Int) {
  var y = 10

  def this(x: Int, y: Int) = {
    this(x)
    this.y = y
  }

  def instMeth2 = x + y

  def instMeth(y: Int) = x + y

  def fun2returns(y: Int) = {
    if (y < 10) {
      "less than 10"
    } else {
      this
    }
  }
}
