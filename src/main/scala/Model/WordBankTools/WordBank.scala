package Model.WordBankTools

import Model.WordBankTools.GrammarTypeEnum.GrammarTypeEnum

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.Random

//TODO: Write Notes When I can't Solve a Problem

object WordBank {
   val WORDBANK_MAP = {
    val wordBank = mutable.HashMap[GrammarTypeEnum, List[String]]()

    //Some hardcoded values
    wordBank += (GrammarTypeEnum.NOUN -> List("Krispy Kreme Donut", "barf", "Derpio"))
    wordBank += (GrammarTypeEnum.VERB -> List("dream", "slay", "barf"))
    wordBank += (GrammarTypeEnum.ADJECTIVE -> List("dreaded", "typical", "forlorn"))
    wordBank += (GrammarTypeEnum.NUMBER -> List("1", "500", "-5213", "6969"))

    wordBank
  }

  def getFromTypeRandomly(grammarType: GrammarTypeEnum): String = {
    val storedResults = WORDBANK_MAP(grammarType)
    storedResults(Random.nextInt(storedResults.length))
  }

  def getAllFromType(grammarType: GrammarTypeEnum) = WORDBANK_MAP(grammarType)

  //addWord

  def addWordToWordBank(grammarType: String, word: String): Unit = {

    val enum = grammarType match {
      case "\"adj\"" => GrammarTypeEnum.ADJECTIVE
      case "\"n\"" => GrammarTypeEnum.NOUN
      case "\"v\"" => GrammarTypeEnum.VERB
      case "{[0-9]}" => GrammarTypeEnum.NUMBER
    }

    val listBuffer = new ListBuffer[String]
    for ( werd <- WORDBANK_MAP(enum)) { listBuffer += werd}
    listBuffer += word
    val updatedList = listBuffer.toList
    WORDBANK_MAP(enum) = updatedList

  }

}
