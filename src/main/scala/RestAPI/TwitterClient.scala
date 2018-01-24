package RestAPI

import java.util

import twitter4j.{Status, Twitter, TwitterFactory}
import twitter4j.conf.ConfigurationBuilder

import scala.collection.mutable.ListBuffer
import scala.util.Random


object TwitterClient {

  val configurationBuilder = new ConfigurationBuilder()
  configurationBuilder.setDebugEnabled(true)
    .setOAuthConsumerKey(KeyReader.CONSUMER_KEY)
    .setOAuthConsumerSecret(KeyReader.CONSUMER_SECRET)
    .setOAuthAccessToken(KeyReader.ACCESS_TOKEN)
    .setOAuthAccessTokenSecret(KeyReader.ACCESS_SECRET)
    .setUseSSL(true)

  val twitterFactory = new TwitterFactory(configurationBuilder.build())
  val twitter: Twitter = twitterFactory.getInstance()


  def getTrumpTweets: List[String] = {
    println("Trump Tweets")
    val tweetList: util.Iterator[Status] = twitter.getUserTimeline("@realDonaldTrump").iterator()

    val textTweets = new ListBuffer[String]()
    tweetList.forEachRemaining(tweet => textTweets += tweet.getText)
    textTweets.toList
  }

  def cleanUpTrumpTweet(tweet: String): List[String] = {
    val words = tweet.split(" ").toList
    words.filter(!_.contains("https://"))
  }

  def getRandomTweet: String = {
  val tweets = getTrumpTweets
    tweets(Random.nextInt(tweets.length))
  }

  def getRandomTweetWord(tweet: String): String = {
    val randomTweetWords: List[String] = cleanUpTrumpTweet(tweet)
    val randomTweetWord = randomTweetWords(Random.nextInt(randomTweetWords.length))
    randomTweetWord
    }




//
//  def getTwitterJSON(query: String): JsValue = {
//    val twitterFactory = new TwitterFactory(configurationBuilder.build())
//    val twitter = twitterFactory.getInstance()
//    val query = new Query("fam")
//    val queryResult = twitter.search(query)
//    for (tweet : T <- queryResult.getTweets) {
//      println(tweet)
//    }
//  }


}
