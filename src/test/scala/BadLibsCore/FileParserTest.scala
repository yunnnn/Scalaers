package BadLibsCore

import BadLibsCore.WordBankTools.GrammarTypeEnum
import Model.{Lib, Word}
import org.scalatest.FunSuite

class FileParserTest extends FunSuite {

  test("testReadLines") {
    val testSeq = Seq("joe", "maria", "kevin")
    assert(testSeq.equals(FileParser.readLines("/Users/Malia/IdeaProjects/Scala2/Scalaers/resource/testNames.txt")))
  }

  test("testCreateWord") {
    val testToken = new Word("A")
    val createdToken = FileParser.createToken("A")
    assert(testToken.wordString equals createdToken.asInstanceOf[Word].wordString)
  }

  test("testCreateLib") {
    val testToken = new Lib(GrammarTypeEnum.NOUN)
    val createdToken = FileParser.createToken("{NOUN}")
    assert(testToken.grammarType equals createdToken.asInstanceOf[Lib].grammarType)
  }

}
