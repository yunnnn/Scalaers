package Model.WordBankTools

import Model.WordBankTools.GrammarTypeEnum.{GrammarTypeEnum}

import scala.collection.mutable
import scala.util.Random

object WordBank {
  private val WORDBANK_MAP = {
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

}
