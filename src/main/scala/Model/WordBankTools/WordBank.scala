package Model.WordBankTools

import java.io.{BufferedWriter, FileWriter}
import java.nio.channels.Pipe.SourceChannel

import Model.WordBankTools.GrammarTypeEnum.GrammarTypeEnum

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.io.Source
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
         wordBank += (GrammarTypeEnum.NOUN -> Set("word"))
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
      case "\"adj\"" => GrammarTypeEnum.ADJECTIVE
      case "\"n\"" => GrammarTypeEnum.NOUN
      case "\"v\"" => GrammarTypeEnum.VERB
      case "{[0-9]}" => GrammarTypeEnum.NUMBER
      case _ => GrammarTypeEnum.NUMBER //todo support adv and maybe error checking
    }

    WORDBANK_MAP.update(enum, WORDBANK_MAP(enum) ++ Set(newWord))
  }

  def writeWordBankToSeededWordBank(wordBank: mutable.HashMap[GrammarTypeEnum, Set[String]]): Unit = {
    val fileWriter = new FileWriter("./src/main/resources/seededWordBank.txt")
    val bufferedWriter = new BufferedWriter(fileWriter)

    val adjectives: Set[String] = wordBank(GrammarTypeEnum.ADJECTIVE)
    val nouns: Set[String] = wordBank(GrammarTypeEnum.NOUN)
    val numbers: Set[String] = wordBank(GrammarTypeEnum.NUMBER)
    val verbs: Set[String] = wordBank(GrammarTypeEnum.VERB)

    writeSetOfStrings(bufferedWriter, adjectives)
    writeSetOfStrings(bufferedWriter, nouns)
    writeSetOfStrings(bufferedWriter, numbers)
    writeSetOfStrings(bufferedWriter, verbs)

    bufferedWriter.close()
  }

  def readSeededWordBank(): Unit = {
    val wordBankText = Source.fromResource("seededWordBank.txt").getLines().toList
    val adjectives = wordBankText(0).split(",")
    val nouns = wordBankText(1).split(",")
    val numbers = wordBankText(2).split(",")
    val verbs = wordBankText(3).split(",")

    WORDBANK_MAP.update(GrammarTypeEnum.ADJECTIVE, WORDBANK_MAP(GrammarTypeEnum.ADJECTIVE) ++ adjectives)
    WORDBANK_MAP.update(GrammarTypeEnum.NOUN, WORDBANK_MAP(GrammarTypeEnum.NOUN) ++ nouns)
    WORDBANK_MAP.update(GrammarTypeEnum.NUMBER, WORDBANK_MAP(GrammarTypeEnum.NUMBER) ++ numbers)
    WORDBANK_MAP.update(GrammarTypeEnum.VERB, WORDBANK_MAP(GrammarTypeEnum.VERB) ++ verbs)


  }

  def writeSetOfStrings(bufferedWriter: BufferedWriter, words: Set[String]) {
    for (adjective <- words) {
      bufferedWriter.write(adjective + ",")
    }
    bufferedWriter.write("\n")
  }

  def printWordBank(): Unit = {
    for (word <- WORDBANK_MAP) println(word)
  }



//  val fileWriter = new FileWriter("./src/main/resources/tweetCache.txt")
//  val bufferedWriter = new BufferedWriter(fileWriter)
//  bufferedWriter.write(tweetTime.getTimeInMillis.toString + "\n")
//  for (tweet <- tweets) {
//    bufferedWriter.write(tweet + "\n")
//  }
//  bufferedWriter.close()

}
