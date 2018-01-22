package BadLibsCore.WordBankTools

import BadLibsCore.WordBankTools.GrammarTypeEnum.{GrammarTypeEnum}

import scala.collection.mutable
import scala.util.Random

object WordBank {
  private val WORDBANK_MAP = {
    val wordBank = mutable.HashMap[GrammarTypeEnum, List[String]]()

    //Some hardcoded values
    wordBank += (GrammarTypeEnum.NOUN -> List("Krispy Kreme Donut", "Barfs", "Derpio"))
    wordBank += (GrammarTypeEnum.VERB -> List("Dreamed", "Slayed", "Barfed"))
    wordBank += (GrammarTypeEnum.ADJECTIVE -> List("Dreaded", "Typical", "Forlorn"))
    wordBank += (GrammarTypeEnum.NUMBER -> List("1", "500", "-5213", "6969"))

    wordBank
  }

  def getFromTypeRandomly(grammarType: GrammarTypeEnum): String = {
    val storedResults = WORDBANK_MAP(grammarType)
    storedResults(Random.nextInt(storedResults.length))
  }

  def getAllFromType(grammarType: GrammarTypeEnum) = WORDBANK_MAP(grammarType)

}
