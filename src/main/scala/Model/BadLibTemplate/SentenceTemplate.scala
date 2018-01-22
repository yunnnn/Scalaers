package Model.BadLibTemplate


class SentenceTemplate(val sentenceTokens: List[SentenceToken]) {

  //Second constructor that can create a Template from a normal sentence String
  def this(plaintextSentence: String) {
    this(CreateTokenUtils.parseLineIntoSentenceTokens(plaintextSentence))
  }

  def log(): Unit = {
    for (sentenceToken <- sentenceTokens) {
      sentenceToken.log()
    }
    println()
  }
}
