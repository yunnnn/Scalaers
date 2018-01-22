package Model

import Model.BadLibTemplate.{CreateTokenUtils, SentenceTemplate}

import scala.io.BufferedSource

class BadLibStory(val sentenceTemplates: List[SentenceTemplate]) {

  def this(fromFile: BufferedSource) {
    this(CreateTokenUtils.createSentenceTemplatesFromFile(fromFile))
  }

  def log(): Unit = {
    for (sentenceTemplate <- sentenceTemplates) sentenceTemplate.log()
  }

}
