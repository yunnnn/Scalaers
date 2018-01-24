package RestAPI

import org.scalatest.FunSuite

class SimpleRequestTest extends FunSuite {

  test("testGetRequest") {
    val testData = SimpleRequest.getRequest("http://api.datamuse.com/words?sp=sly&md=p&max=1")
    val word = (testData \ 0 \ "tags").get.head.get
    println(word)
  }

  test("testWriteQuery") {
    val query = SimpleRequest.writeQuery("sleep")
    val testData = SimpleRequest.getRequest(query)
    println( (testData \ 0 \ "tags").get.head.get)
  }

  test("testReadJSON") {
    val json = SimpleRequest.readJSON("y.json")
    val word = (json \ "headers" \ "host").get
    println(word)
  }

}
