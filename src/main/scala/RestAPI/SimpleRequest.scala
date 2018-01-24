package RestAPI
import play.api.libs.json.{JsValue, Json, __}
import scala.io.{BufferedSource, Source}



object SimpleRequest extends App {

  /**
    * Simple Request makes a call to an API and returns a JSValue which represents a JSON file
    * Is unable to deal with timeouts.
    * @param url API string for request
    * @return JSValue
    */

  def getRequest(url: String): JsValue = {
    val data = scala.io.Source.fromURL(url).mkString
    val json = Json.parse(data)
    json
  }

  /**
    * WriteDictionaryQuery takes a word and crafts a query for datamuse's dictionary api to determine part of speech
    * @param wordNeedingPartOfSpeech
    * @return
    */

  def writeDictionaryQuery(wordNeedingPartOfSpeech: String): String = {
    "http://api.datamuse.com/words?sp=" +  wordNeedingPartOfSpeech + "&md=p&max=1"
  }

  /**
    * ReadJSON takes a JSON filename, retrieves the file, and converts it into a JSValue to be manipulated
    * @param filename
    * @return
    */

  def readJSON(filename: String): JsValue = {

    val file: BufferedSource = Source.fromResource(filename)
    val lines: String = file.getLines().mkString
    val json = Json.parse(lines)

    json
  }
  


}
