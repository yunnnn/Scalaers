package RestAPI

import java.io.{BufferedWriter, FileWriter}
import java.util.Calendar
import java.util.concurrent.TimeUnit

import RestAPI.TwitterClient.parseDateFromString

import scala.io.Source

object TwitterCache {

  def writeTweetsIntoCache(tweets: List[String], tweetTime: Calendar): Unit = {
    val fileWriter = new FileWriter("./src/main/resources/tweetCache.txt")
    val bufferedWriter = new BufferedWriter(fileWriter)
    bufferedWriter.write(tweetTime.getTimeInMillis.toString + "\n")
    for (tweet <- tweets) {
      bufferedWriter.write(tweet + "\n")
    }
    bufferedWriter.close()
  }

  def isTimeToReloadCache(tweetTime: Calendar): Boolean = {
    val currentTime = Calendar.getInstance()
    val timeSinceLastTweetInMilliseconds = currentTime.getTimeInMillis - tweetTime.getTimeInMillis
    if (TimeUnit.MILLISECONDS.toHours(timeSinceLastTweetInMilliseconds) > 1) return true else false
  }

  def readTimeFromCache: Calendar  = {
    val file = Source.fromResource("tweetCache.txt")
    if  (file.isEmpty){
      val emptyTime = Calendar.getInstance()
      emptyTime.set(2001, 1, 1, 0, 0 , 0)
      emptyTime
    }
    else {
      val line = file.getLines().next()
      parseDateFromString(line)
    }
  }

  def getTweetsFromCache: List[String] = {
    val linesPlusDate = Source.fromResource("tweetCache.txt").getLines().toList
    linesPlusDate.drop(1)
  }
}
