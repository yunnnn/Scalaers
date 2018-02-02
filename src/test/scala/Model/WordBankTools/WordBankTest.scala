package Model.WordBankTools

import java.util.Calendar

import org.scalatest.FunSuite

//TODO: WHAT DOES BEING COMPLETE MEAN
//TODO: BEING ABLE TO INSPIRE CONFIDENCE VERBALLY THAT YOU SOLVED THE BIG PROBLEMS
//TODO: BIG PROBLEM = HOW ARE WE GONNA REACH THE END OF ISSUE
//TODO: IF I DON'T ASK QUESTIONS, I'M BEING PRESUMPTIVE AND RUDE

class WordBankTest extends FunSuite {

  //prints em all
  WordBank.getAllFromType(GrammarTypeEnum.ADJECTIVE).foreach(word => println(word))

  //prints a random one
  println("Random word:" + WordBank.getFromTypeRandomly(GrammarTypeEnum.ADJECTIVE))

  test("testGetFromTypeRandomly") {
    assert(!WordBank.getFromTypeRandomly(GrammarTypeEnum.ADJECTIVE).isEmpty)
  }

  test("testGetAllFromType") {
//    val allFromAdjectives = WordBank.getAllFromType(GrammarTypeEnum.ADJECTIVE)
//    assert(allFromAdjectives.lengthCompare(3) == 0)
  }

  test("writeToSeededWordBank") {
    WordBank.writeWordBankToSeededWordBank(WordBank.WORDBANK_MAP)
  }

  test("readFromSeededWordBank") {
    WordBank.readSeededWordBank()
    WordBank.printWordBank()
    println()

  }

  test("printWordBank") {
    println("0")
    WordBank.printWordBank()
    println("1")
    WordBank.readSeededWordBank()
    println("2")
    WordBank.printWordBank()
    println()

  }

  test("wordBankMashUp") {

    //
    val timedate = Calendar.getInstance()
    val timedateMilli = timedate.getTimeInMillis
    val timedateString: String = timedateMilli.toString
    val timedateAgain: Calendar = Calendar.getInstance()
    println(timedateAgain.setTimeInMillis(timedateString.toLong))


    WordBank.printWordBank()
    println("1")
    WordBank.readSeededWordBank()
    BadLibsCore.BadLibsEngine.createBadLibStoryFromTrumpAndPrint()
    WordBank.writeWordBankToSeededWordBank(WordBank.WORDBANK_MAP)
    WordBank.readSeededWordBank()
    WordBank.printWordBank()
    println("3")
  }
}
