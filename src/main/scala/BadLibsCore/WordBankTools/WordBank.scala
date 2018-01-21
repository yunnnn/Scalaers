package BadLibsCore.WordBankTools

import BadLibsCore.WordBankTools.GrammarType.GrammarType

import scala.collection.mutable
import scala.util.Random

object WordBank {
  private val WORDBANK_MAP = {
    val wordBank = mutable.HashMap[GrammarType, List[String]]()

    //Some hardcoded values
    wordBank += (GrammarType.Noun -> List("Krispy Kreme Donut", "Barfs", "Derpio"))
    wordBank += (GrammarType.Verb -> List("Dreamed", "Slayed", "Barfed"))
    wordBank += (GrammarType.Adjective -> List("Dreaded", "Typical", "Forlorn"))
    wordBank += (GrammarType.Number -> List("1", "500", "-5213", "6969"))

    wordBank
  }

  def getFromTypeRandomly(grammarType: GrammarType): String = {
    val storedResults = WORDBANK_MAP(grammarType)
    storedResults(Random.nextInt(storedResults.length))
  }

  def getAllFromType(grammarType: GrammarType) = WORDBANK_MAP(grammarType)

}
