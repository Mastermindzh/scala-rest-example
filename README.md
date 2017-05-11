# Scala-rest example
Simple test project for a scala-play project including advanced routing, json to instance handling and tests.
The application lives under the "app" folder. In there you'll find a standard MVC structure.

## Running the project
The project includes a makefile with a couple of commands:

| Command | result |
|--------|--------|
|run| Starts the application with dynamic compilation|
|prod| Starts the application without dynamic compilation|
|test| Runs the tests|

## Adding a new route
Declare a route in "conf/routes", make sure to follow the following convention:
`GET		/route				controllers.Controller.Method`


Create the controller in the folder `app/controllers` using the following stub:

```$xslt
package controllers

import play.api.mvc._
import models.AgendaItem

class FirstController extends Controller {
    def firstMethod = Action {
        Ok("Woohoo! it works!")
    }
}

```

Thats it! We're all done for now!


