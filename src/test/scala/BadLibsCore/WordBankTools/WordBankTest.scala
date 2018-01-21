package BadLibsCore.WordBankTools

import org.scalatest.FunSuite

class WordBankTest extends FunSuite {

  test("testGetFromTypeRandomly") {
    assert(!WordBank.getFromTypeRandomly(GrammarType.Adjective).isEmpty)
  }

  test("testGetAllFromType") {
    val allFromAdjectives = WordBank.getAllFromType(GrammarType.Adjective)
    assert(allFromAdjectives.lengthCompare(3) == 0)
  }

}
