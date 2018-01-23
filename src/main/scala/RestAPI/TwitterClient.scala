package RestAPI

import java.util

import twitter4j.Twitter._
import twitter4j.{ResponseList, Status, Twitter, TwitterFactory}
import twitter4j.conf.ConfigurationBuilder


object TwitterClient {

//  val configurationBuilder = new ConfigurationBuilder()
//  configurationBuilder.setDebugEnabled(true)
//    .setOAuthConsumerKey(KeyReader.CONSUMER_KEY)
//    .setOAuthConsumerSecret(KeyReader.CONSUMER_SECRET)
//    .setOAuthAccessToken(KeyReader.ACCESS_TOKEN)
//    .setOAuthAccessTokenSecret(KeyReader.ACCESS_SECRET)
//
//  val twitterFactory = new TwitterFactory(configurationBuilder.build())
//  val twitter: Twitter = twitterFactory.getInstance()
//
//  val statuses: ResponseList[Status] = twitter.getUserTimeline("@realDonaldTrump")
//  System.out.println("Trump Tweets?")
//  val iterator: util.Iterator[Status] = statuses.iterator()
//  while (iterator.hasNext) {
//    val status = iterator.next()
//    println(status.getUser.getName + ":" + status.getText)
//  }

  def printTrumpTweet(): Unit = {
    val configurationBuilder = new ConfigurationBuilder()
    configurationBuilder.setDebugEnabled(true)
      .setOAuthConsumerKey(KeyReader.CONSUMER_KEY)
      .setOAuthConsumerSecret(KeyReader.CONSUMER_SECRET)
      .setOAuthAccessToken(KeyReader.ACCESS_TOKEN)
      .setOAuthAccessTokenSecret(KeyReader.ACCESS_SECRET)
      .setUseSSL(true)


    val twitterFactory = new TwitterFactory(configurationBuilder.build())
    val twitter: Twitter = twitterFactory.getInstance()

    val statuses: ResponseList[Status] = twitter.getUserTimeline("@realDonaldTrump")
    System.out.println("Trump Tweets?")
    val iterator: util.Iterator[Status] = statuses.iterator()
    while (iterator.hasNext) {
      val status = iterator.next()
      println(status.getCreatedAt + ":" + status.getText)
    }
  }


}
