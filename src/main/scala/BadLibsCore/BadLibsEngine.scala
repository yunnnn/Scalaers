package BadLibsCore

import Model.BadLibStory
import Model.WordBankTools.WordBank
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
    for (i <- 1 to 50) {
      getRandomWordAndAddToBank()
    }

    println()
    println()
    println("Results! " )
    println()

    //Print story
    BadLibsEngine.createBadLibStoryAndPrint()

    println()
    println()
    println("Map! " )
    println()

    //TODO: Print out the new set of words in wordbank

  }

  def getRandomWordAndAddToBank() = {
    //Retrieve random tweet and pick random word from tweet to add to wordbank
    val tweet = TwitterClient.getRandomTrumpTweet
    val randomTweetWord = TwitterClient.getRandomTweetWord(tweet)

    //Send get request with random word to find out part of word
    val request = SimpleRequest.getRequest(SimpleRequest.writeDictionaryQuery(randomTweetWord))
    val tags = request \ 0 \ "tags"
    if (request != null && tags != null && !tags.isEmpty && tags.get != null && tags.get.head != null && !tags.get.head.isEmpty) {
      val partOfWord = tags.get.head.get
      println(randomTweetWord + " : " + partOfWord)
      //Add word to word bank
      WordBank addWordToWordBank(partOfWord.toString(), randomTweetWord)
    }
  }

}
