package RestAPI

import java.util.Calendar

import BadLibsCore.BadLibsEngine
import Model.WordBankTools.{GrammarTypeEnum, WordBank}
import org.scalatest.FunSuite

class TwitterClientTest extends FunSuite {

  test("testGetTrumpTweet") {
    TwitterClient.getTrumpTweets.foreach(println(_))
  }

  test("test mashup") {
    BadLibsEngine.createBadLibStoryFromTrumpAndPrint()
//    BadLibsEngine.createBadLibStoryFromTrumpAndPrint()
//    BadLibsEngine.createBadLibStoryFromTrumpAndPrint()
//    BadLibsEngine.createBadLibStoryFromTrumpAndPrint()
//    BadLibsEngine.createBadLibStoryFromTrumpAndPrint()

  }

  test("printTime") {
    val timedate = Calendar.getInstance()
    val timedateMilli = timedate.getTimeInMillis
    val timedateString: String = timedateMilli.toString
    val timedateAgain: Calendar = Calendar.getInstance()
    timedateAgain.setTimeInMillis(timedateString.toLong)
    assert(timedate == timedateAgain)
  }

  test("checkTime") {
    val time: Calendar = Calendar.getInstance()
    time.set(2018, 0, 24, 15, 38)
    assert(TwitterClient.isTimeToReloadCache(time) == true)
  }

  test("writeTweetsIntoCache") {
    TwitterClient.writeTweetsIntoCache(TwitterClient.getTrumpTweets, Calendar.getInstance())
  }

  test("readTimeFromCache") {
    val time = TwitterClient.readTimeFromCache
    println(time)
  }

  test("getTweetsFromCache") {
    val tweets = TwitterClient.getTweetsFromCache
    val cleanedTweets = TwitterClient.cleanUpAllTrumpTweets(tweets)
    cleanedTweets.foreach(println(_))

  }

  test("CacheMashUp") {
    if (TwitterClient.isTimeToReloadCache(TwitterClient.readTimeFromCache))
      TwitterClient.getTrumpTweets else TwitterClient.getTweetsFromCache

  }
}


