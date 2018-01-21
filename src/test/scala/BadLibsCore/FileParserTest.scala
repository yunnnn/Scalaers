package BadLibsCore

import org.scalatest.FunSuite

class FileParserTest extends FunSuite {


    val testSeq = Seq("joe", "maria", "kevin")
    test("testReadBadLibsLines")(assert(testSeq.equals(FileParser.readBadLibsLines("/Users/Malia/IdeaProjects/Scala2/Scalaers/resource/names.txt"))))
}
