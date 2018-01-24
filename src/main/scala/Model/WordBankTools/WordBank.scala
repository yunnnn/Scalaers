package Model.WordBankTools

import Model.WordBankTools.GrammarTypeEnum.GrammarTypeEnum

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.Random

//TODO: Write Notes When I can't Solve a Problem
//TODO: Create more wordbanks for different parts of word
//TODO: Create exception handling for when things can't be done
//TODO: Create more sentence templates, both prewritten and randomly generated
object WordBank {
   val WORDBANK_MAP = {
    val wordBank = mutable.HashMap[GrammarTypeEnum, Set[String]]()

    //Some hardcoded values
//    wordBank += (GrammarTypeEnum.NOUN -> List("Krispy Kreme Donut", "barf", "Derpio"))
//    wordBank += (GrammarTypeEnum.VERB -> List("dream", "slay", "barf"))
//    wordBank += (GrammarTypeEnum.ADJECTIVE -> List("dreaded", "typical", "forlorn"))
//    wordBank += (GrammarTypeEnum.NUMBER -> List("1", "500", "-5213", "6969"))
         wordBank += (GrammarTypeEnum.NOUN -> Set())
         wordBank += (GrammarTypeEnum.VERB -> Set("sucked"))
         wordBank += (GrammarTypeEnum.ADJECTIVE -> Set("shitty", "flacid"))
         wordBank += (GrammarTypeEnum.NUMBER -> Set("1", "500", "-5213", "6969"))


    wordBank
  }

  def getFromTypeRandomly(grammarType: GrammarTypeEnum): String = {
    val storedResults = WORDBANK_MAP(grammarType)
    storedResults.toList(Random.nextInt(storedResults.size))
  }

  def getAllFromType(grammarType: GrammarTypeEnum) = WORDBANK_MAP(grammarType)

  def addWordToWordBank(grammarType: String, newWord: String): Unit = {

    val enum = grammarType match {
      case "\"\"adj\"\"" => GrammarTypeEnum.ADJECTIVE
      case "\"n\"" => GrammarTypeEnum.NOUN
      case "\"v\"" => GrammarTypeEnum.VERB
      case "{[0-9]}" => GrammarTypeEnum.NUMBER
      case _ => GrammarTypeEnum.NUMBER //todo support adv and maybe error checking
    }

    WORDBANK_MAP.update(enum, WORDBANK_MAP(enum) ++ Set(newWord))
  }

}
