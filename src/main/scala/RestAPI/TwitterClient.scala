package RestAPI

import java.util
import java.util.{Calendar}

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


  /**
    * GetTrumpTweets
    * Retrieves the last 20 tweets by Donald trump and puts them into a list of strings
    * @return tweets
    */
  def getTrumpTweets: List[String] = {
    val tweetList: util.Iterator[Status] = twitter.getUserTimeline("@realDonaldTrump").iterator()

    val textTweets = new ListBuffer[String]()
    tweetList.forEachRemaining(tweet => textTweets += tweet.getText)
    textTweets.toList
  }

  def getTrumpTweetTime: Calendar = {
    val tweetList: util.Iterator[Status] = twitter.getUserTimeline("@realDonaldTrump").iterator()
    val calendar = Calendar.getInstance()
    val rawDate = tweetList.next().getCreatedAt
    calendar.setTime(rawDate)
    calendar
  }

  /**
    * CleanUpTrumpTweet
    * removes any links from tweet and converts it into a list of individual words
    * @param tweet
    * @return
    */
  def cleanUpTrumpTweet(tweet: String): List[String] = {
    val words = tweet.split(" ").toList
    words.filter(!_.contains("https://"))
  }

  def cleanUpAllTrumpTweets(tweets: List[String]): List[String] = {
    var listBuffer = new ListBuffer[String]
    for (tweet <- tweets) {
      val tweetWords = cleanUpTrumpTweet(tweet)
      val cleanedUpTweet = tweetWords.mkString(" ")
      listBuffer += cleanedUpTweet
    }
    listBuffer.toList
  }

  /**
    * GetRandomTrumpTweet
    * Grabs a tweet randomly from the last 20 Trump tweets and returns a string
    * @return
    */
  def getRandomTrumpTweet: String = {
  val tweets = getTrumpTweets
    tweets(Random.nextInt(tweets.length))
  }

  /**
    * GetRandomTweetWord
    * takes a string of tweets, filters it to remove any hotlinks, and grabs a random word
    * @param tweet
    * @return
    */
  def getRandomTweetWord(tweet: String): String = {
    val randomTweetWords: List[String] = cleanUpTrumpTweet(tweet)
    val randomTweetWord = randomTweetWords(Random.nextInt(randomTweetWords.length))
    randomTweetWord
    }

  def parseDateFromString(dateString: String): Calendar = {
    val date = Calendar.getInstance()
    date.setTimeInMillis(dateString.toLong)
    date
  }
}

//  def getTwitterJSON(query: String): JsValue = {
//    val twitterFactory = new TwitterFactory(configurationBuilder.build())
//    val twitter = twitterFactory.getInstance()
//    val query = new Query("fam")
//    val queryResult = twitter.search(query)
//    for (tweet : T <- queryResult.getTweets) {
//      println(tweet)
//    }
//  }