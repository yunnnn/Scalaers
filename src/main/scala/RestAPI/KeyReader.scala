package RestAPI

object KeyReader {

  val CONSUMER_KEY = scala.io.Source.fromResource("consumerKey.txt").getLines().mkString
  val CONSUMER_SECRET = scala.io.Source.fromResource("consumerSecret.txt").getLines().mkString
  val ACCESS_TOKEN = scala.io.Source.fromResource("accessToken.txt").getLines().mkString
  val ACCESS_SECRET = scala.io.Source.fromResource("accessSecret.txt").getLines().mkString


}
