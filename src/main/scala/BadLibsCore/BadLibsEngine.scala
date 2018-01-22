package BadLibsCore

import Model.BadLibStory

import scala.io.{BufferedSource, Source}

//Contains state and hardcoded test files
object BadLibsEngine {

  val TEST_NAMES: BufferedSource = Source.fromResource("testNames.txt")
  val BAD_LIB_STORY: BufferedSource = Source.fromResource("badLibStory.txt")

  def createBadLibStoryAndPrint(): Unit = {
    val story = new BadLibStory(BAD_LIB_STORY)
    story.log()
  }
}
