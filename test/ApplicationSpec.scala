import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
@RunWith(classOf[JUnitRunner])
class ApplicationSpec extends Specification {

  "Application" should {

    "send 404 on a bad request" in new WithApplication{
      val home = route(FakeRequest(GET, "/boum")).get

      contentAsString(home) must contain("Action Not Found")
    }

    "render the index page" in new WithApplication{
      val home = route(FakeRequest(GET, "/")).get

      status(home) must equalTo(OK)
      contentType(home) must beSome.which(_ == "text/html")
      contentAsString(home) must contain ("Welcome to Play")
    }

    "should return jim" in new WithApplication{
      val page = route(FakeRequest(GET, "/name")).get
      contentAsString(page) must be_==("Suzanne")

    }

    "should route succesfully if regex request < 10  chars" in new WithApplication{
      val succesPage = route(FakeRequest(GET, "/regex/test.jpg")).get
      contentAsString(succesPage) must contain ("Routing success")

      val errorPage = route(FakeRequest(GET, "/regex/testlongerthan10.jpg")).get
      contentAsString(errorPage) must contain ("Action Not Found")

    }

    "routing should fail if regex request > 10  chars" in new WithApplication{
      val errorPage = route(FakeRequest(GET, "/regex/testlongerthan10.jpg")).get
      contentAsString(errorPage) must contain ("Action Not Found")

    }

  }
}
