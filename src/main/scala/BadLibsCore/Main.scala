package BadLibsCore

import BadLibsCore.WordBankTools.{GrammarType, WordBank}

object Main {
  def main(args: Array[String]): Unit = {

    //prints em all
    WordBank.getAllFromType(GrammarType.Adjective).foreach(word => println(word))

    //prints a random one
    println("Random word:" + WordBank.getFromTypeRandomly(GrammarType.Adjective))
  }
}
