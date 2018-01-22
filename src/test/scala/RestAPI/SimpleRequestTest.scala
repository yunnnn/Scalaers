package RestAPI

import org.scalatest.FunSuite
import play.api.libs.json

class SimpleRequestTest extends FunSuite {

  test("testGetRequest") {
    val testData = SimpleRequest.getRequest("http://postman-echo.com/get ")
    val word = (testData \ "headers" \ "host").get
    println(word)
  }

  test("testReadJSON") {
    val json = SimpleRequest.readJSON("y.json")
    val word = (json \ "headers" \ "host").get
    println(word)
  }

}
