package BadLibsCore

object FileParser {

  def readLines(filename:String): List[String] = {
    val bufferedSource = io.Source.fromFile(filename)
    val lines = (for (line <- bufferedSource.getLines()) yield line).toList
    bufferedSource.close
    lines
  }
//
//  def parseLine(line: List[String]) = {
//    line.split(" ").toList
//  }




}
