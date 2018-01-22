package Model.BadLibTemplate

protected class Word(val wordString: String, override val spaceBeforeToken: Boolean = true) extends SentenceToken {

  override def log(): Unit = {
    if (spaceBeforeToken)
      print(' ')
    print(wordString)
  }
}
