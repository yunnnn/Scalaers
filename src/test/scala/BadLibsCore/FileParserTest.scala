package BadLibsCore

import org.scalatest.FunSuite

class FileParserTest extends FunSuite {


    val testSeq = Seq("joe", "maria", "kevin")
    test("testLines")(assert(testSeq.equals(FileParser.readLines("/Users/Malia/IdeaProjects/Scala2/Scalaers/resource/names.txt"))))
}
