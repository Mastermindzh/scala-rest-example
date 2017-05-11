package models

import play.api.libs.json._

/**
  * Created by mastermindzh on 5/11/17.
  */
case class AgendaItem(title: String, event: String)

object AgendaItem {

  def getInstance(input: JsValue): AgendaItem ={
    val title = (input \ "title").as[String]
    val event = (input \ "event").as[String]
    AgendaItem(title,event)
  }

}