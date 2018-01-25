package RestAPI

protected object KeyReader {

  val CONSUMER_KEY = scala.io.Source.fromResource("AccessKeys/consumerKey.txt").getLines().mkString
  val CONSUMER_SECRET = scala.io.Source.fromResource("AccessKeys/consumerSecret.txt").getLines().mkString
  val ACCESS_TOKEN = scala.io.Source.fromResource("AccessKeys/accessToken.txt").getLines().mkString
  val ACCESS_SECRET = scala.io.Source.fromResource("AccessKeys/accessSecret.txt").getLines().mkString

}
