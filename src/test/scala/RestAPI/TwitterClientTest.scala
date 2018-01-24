package RestAPI

import BadLibsCore.BadLibsEngine
import Model.WordBankTools.{GrammarTypeEnum, WordBank}
import org.scalatest.FunSuite

class TwitterClientTest extends FunSuite {

  test("testGetTrumpTweet") {
    TwitterClient.getTrumpTweets.foreach(println(_))
  }

  test("test mashup") {
    BadLibsEngine.createBadLibStoryFromTrumpAndPrint()
  }
}
