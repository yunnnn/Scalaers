package BadLibsCore

import BadLibsCore.WordBankTools.GrammarTypeEnum
import Model.{Lib, SentenceToken, Word}


object FileParser {

  def readLines(filename:String): List[String] = {
    val bufferedSource = io.Source.fromFile(filename)
    val lines = (for (line <- bufferedSource.getLines()) yield line).toList
    bufferedSource.close
    lines
  }

  def parseLine(line: String): List[String] = {
    line.split(" ").toList
  }

  def createToken(token: String): SentenceToken = {
    val adj = GrammarTypeEnum.ADJECTIVE.toString
    val noun = GrammarTypeEnum.NOUN.toString
    val num = GrammarTypeEnum.NUMBER.toString
    val verb = GrammarTypeEnum.VERB.toString

    token match {
      case `adj` => new Lib(GrammarTypeEnum.ADJECTIVE)
      case `noun` => new Lib(GrammarTypeEnum.NOUN)
      case `num` => new Lib(GrammarTypeEnum.NUMBER)
      case `verb` => new Lib(GrammarTypeEnum.VERB)
      case _ => new Word(token)
    }
  }

}
