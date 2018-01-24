package BadLibsCore

import Model.BadLibStory
import Model.WordBankTools.{GrammarTypeEnum, WordBank}
import RestAPI.{SimpleRequest, TwitterClient}

import scala.io.{BufferedSource, Source}

//Contains state and hardcoded test files
object BadLibsEngine {

  val TEST_NAMES: BufferedSource = Source.fromResource("testNames.txt")
  val BAD_LIB_STORY: BufferedSource = Source.fromResource("badLibStory.txt")

  def createBadLibStoryAndPrint(): Unit = {
    val story = new BadLibStory(BAD_LIB_STORY)
    story.log()
  }

  def createBadLibStoryFromTrumpAndPrint(): Unit = {
    //Retrieve random tweet and pick random word from tweet to add to wordbank
    val tweet = TwitterClient.getRandomTweet
    println(tweet)
    val randomTweetWord = TwitterClient.getRandomTweetWord(tweet)
    println(randomTweetWord)
    //Send get request with random word to find out part of word
    val request = SimpleRequest.getRequest(SimpleRequest.writeQuery(randomTweetWord))
    val partOfWord = (request \ 0 \ "tags").get.head.get
    println(randomTweetWord + " : " + partOfWord)
    //Add word to word bank
    WordBank addWordToWordBank(partOfWord.toString(), randomTweetWord)
    println()
    //Print story
    BadLibsEngine.createBadLibStoryAndPrint()

  }

}
