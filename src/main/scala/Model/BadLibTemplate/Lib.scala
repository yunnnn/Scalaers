package Model.BadLibTemplate

import Model.WordBankTools.GrammarTypeEnum.GrammarTypeEnum
import Model.WordBankTools.WordBank

protected class Lib(val grammarType: GrammarTypeEnum, val suffixWord: Option[Word]) extends SentenceToken {

  def this(grammarTypeEnum: GrammarTypeEnum) {
    this(grammarTypeEnum, Option.empty)
  }

  override def log(): Unit = {
    if (this.spaceBeforeToken)
      print(' ')

    print(WordBank.getFromTypeRandomly(grammarType))

    if (suffixWord.isDefined)
      suffixWord.get.log()
  }
}
