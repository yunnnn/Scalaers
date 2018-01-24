package Model.BadLibTemplate

import scala.util.Random

object SentenceFormatGenerator {

//  val NOUN = "{NOUN}"
//  val ADJECTIVE = "{ADJ}"
//  val ADVERB = "{ADV}"
//  val VERB = "{VERB}"
//  val NUMBER = "{NUM}"
//  val PREPOSITION = "{PREP}"
//  val ARTICLE = "{ART}"
  val MIN_AMOUNT_OF_WORDS = 3
  val MAX_AMOUNT_OF_WORDS = 10
  val PARTS_OF_SPEECH = List[String]("{NOUN}","{ADJ}","{VERB}","{NUM}"  )

//  def createSentenceFormats(numberOfFormats: Int): List[String] = {
//
//  }


//  def createSentenceFormat(): String = {
//    val amountOfWords = MIN_AMOUNT_OF_WORDS + Random.nextInt((MAX_AMOUNT_OF_WORDS - MIN_AMOUNT_OF_WORDS) + 1)
//    var stringBuilder = StringBuilder
//    for (_ <- amountOfWords) stringBuilder += PARTS_OF_SPEECH(Random.nextInt(PARTS_OF_SPEECH.length))
//    stringBuilder.toString
//  }


}
