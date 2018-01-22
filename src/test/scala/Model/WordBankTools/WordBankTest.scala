package Model.WordBankTools

import org.scalatest.FunSuite

class WordBankTest extends FunSuite {

  //prints em all
  WordBank.getAllFromType(GrammarTypeEnum.ADJECTIVE).foreach(word => println(word))

  //prints a random one
  println("Random word:" + WordBank.getFromTypeRandomly(GrammarTypeEnum.ADJECTIVE))

  test("testGetFromTypeRandomly") {
    assert(!WordBank.getFromTypeRandomly(GrammarTypeEnum.ADJECTIVE).isEmpty)
  }

  test("testGetAllFromType") {
    val allFromAdjectives = WordBank.getAllFromType(GrammarTypeEnum.ADJECTIVE)
    assert(allFromAdjectives.lengthCompare(3) == 0)
  }

}
