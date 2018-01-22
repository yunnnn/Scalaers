package BadLibsCore

import BadLibsCore.WordBankTools.{GrammarTypeEnum, WordBank}

object Main {
  def main(args: Array[String]): Unit = {

    //prints em all
    WordBank.getAllFromType(GrammarTypeEnum.ADJECTIVE).foreach(word => println(word))

    //prints a random one
    println("Random word:" + WordBank.getFromTypeRandomly(GrammarTypeEnum.ADJECTIVE))
  }
}
