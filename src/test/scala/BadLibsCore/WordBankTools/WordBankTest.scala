package BadLibsCore.WordBankTools

import org.scalatest.FunSuite

class WordBankTest extends FunSuite {

  test("testGetFromTypeRandomly") {
    assert(!WordBank.getFromTypeRandomly(GrammarType.ADJECTIVE).isEmpty)
  }

  test("testGetAllFromType") {
    val allFromAdjectives = WordBank.getAllFromType(GrammarType.ADJECTIVE)
    assert(allFromAdjectives.lengthCompare(3) == 0)
  }

}
