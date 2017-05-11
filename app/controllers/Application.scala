package controllers

import play.api.mvc._
import models.AgendaItem

class Application extends Controller {

  // returns default play page
  def index = Action {
    Ok(views.html.index("Stuff works!"))
  }

  // regular route
  def getName = Action {
    Ok("Suzanne")
  }

  // route with regex constraint and !
  def getRegex(name: String) = Action {
    Ok("Return: Regex val - Routing success")
  }

  // post with json
  def getAgendaItem = Action { implicit request =>
    val json = request.body.asJson.get

    val agendaItem = AgendaItem.getInstance(json)
    Ok("title: " + agendaItem.title)
  }
}