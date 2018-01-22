package Model.BadLibTemplate

import Model.WordBankTools.GrammarTypeEnum
import Model.WordBankTools.GrammarTypeEnum.GrammarTypeEnum

import scala.io.BufferedSource

object CreateTokenUtils {

  def createSentenceTemplatesFromFile(fromFile: BufferedSource): List[SentenceTemplate] = {
    (for (line <- fromFile.getLines()) yield new SentenceTemplate(line)).toList
  }

  /**
    * Splits plaintext line along space char, then creates Token from each chunk
    *
    * @param line plaintext line
    * @return
    */
  def parseLineIntoSentenceTokens(line: String): List[SentenceToken] = {
    (for (token <- line.split(' ')) yield createSentenceToken(token)).toList
  }

  private def createSentenceToken(token: String) = {
    val libAndSuffix = "(\\{[ANV][A-Z]*\\})(.+)".r
    val onlyLib = "(\\{[ANV][A-Z]*\\})$".r

    token match {
      case libAndSuffix(lib, suffixWord) => new Lib(getMatchingLibType(lib), Option(new Word(suffixWord, false)))
      case onlyLib(lib) => new Lib(getMatchingLibType(lib))
      case _ => new Word(token)
    }
  }

  private def getMatchingLibType(token: String): GrammarTypeEnum = {
    val ADJ = GrammarTypeEnum.ADJECTIVE.toString
    val NOUN = GrammarTypeEnum.NOUN.toString
    val NUM = GrammarTypeEnum.NUMBER.toString
    val VERB = GrammarTypeEnum.VERB.toString

    token match {
      case ADJ => GrammarTypeEnum.ADJECTIVE
      case NOUN => GrammarTypeEnum.NOUN
      case NUM => GrammarTypeEnum.NUMBER
      case VERB => GrammarTypeEnum.VERB
      case _ => throw new IllegalArgumentException
    }
  }


}
