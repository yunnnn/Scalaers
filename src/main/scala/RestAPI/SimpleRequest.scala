package RestAPI
import java.io.FileInputStream

import play.api.libs.json.{JsValue, Json, __}
import scala.io.{BufferedSource, Source}



object SimpleRequest extends App {

  def getRequest(url: String): JsValue = {
    val data = scala.io.Source.fromURL(url).mkString
    val json = Json.parse(data)
    json
  }

  def readJSON(filename: String): JsValue = {

    val file: BufferedSource = Source.fromResource(filename)
    val lines: String = file.getLines().mkString
    val json = Json.parse(lines)

    json
  }

//  val json: JsValue = Json.parse("""
//  {
//    "name" : "Watership Down",
//    "location" : {
//      "lat" : 51.235685,
//      "long" : -1.309197
//    },
//    "residents" : [ {
//      "name" : "Fiver",
//      "age" : 4,
//      "role" : null
//    }, {
//      "name" : "Bigwig",
//      "age" : 6,
//      "role" : "Owsla"
//    } ]
//  }
//  """)


}
