package RestAPI

import java.util.Calendar

import org.scalatest.FunSuite

class TwitterCacheTest extends FunSuite {

  test("testReadTimeFromCache") {
    val time = TwitterCache.readTimeFromCache
    println(time)
  }

  test("testWriteTweetsIntoCache") {
    TwitterCache.writeTweetsIntoCache(TwitterClient.getTrumpTweets, Calendar.getInstance())
  }

  test("testGetTweetsFromCache") {
    val tweets = TwitterCache.getTweetsFromCache
    val cleanedTweets = TwitterClient.cleanUpAllTrumpTweets(tweets)
    cleanedTweets.foreach(println(_))
  }

  test("testIsTimeToReloadCache") {
    val time: Calendar = Calendar.getInstance()
    time.set(2018, 0, 24, 15, 38)
    assert(TwitterCache.isTimeToReloadCache(time) == true)
  }

}
