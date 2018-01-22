package BadLibsCore.WordBankTools

import org.scalatest.FunSuite

class WordBankTest extends FunSuite {

  test("testGetFromTypeRandomly") {
    assert(!WordBank.getFromTypeRandomly(GrammarTypeEnum.ADJECTIVE).isEmpty)
  }

  test("testGetAllFromType") {
    val allFromAdjectives = WordBank.getAllFromType(GrammarTypeEnum.ADJECTIVE)
    assert(allFromAdjectives.lengthCompare(3) == 0)
  }

}
