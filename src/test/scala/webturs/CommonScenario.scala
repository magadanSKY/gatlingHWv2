package webturs

import io.gatling.core.Predef._
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}
import io.gatling.http.Predef._
import webturs.Feeders._
import io.gatling.jdbc.Predef._
import scala.concurrent.duration._

object CommonScenario{
  def apply(): ScenarioBuilder = new CommonScenario().scn
}

class CommonScenario {

  val root = group("rootPage"){
  exec(Actions.getRoot)
}

  val login = group("login"){
    exec(Actions.postLogin)
  }

  val flights = group("flights"){
    exec(Actions.getFlights)
  }

  val selectFlight = group("selectFlights") {
    exec(Actions.postSelectFlight)
  }

  val selectFrom4th = group("SelectFrom4th") {
    exec(Actions.postSelectFrom4th)
  }

  val creditCardInfo = group("creditCardInfo") {
    exec(Actions.postCreditCardInfo)
  }

  val invoice = group("invoice") {
    exec(Actions.getInvoice)
  }

  val getUserSession = group("UserSession"){
    exec(Actions.getUserSession)
  }


  val scn = scenario("webTours")
    .feed(cityDepart)
    .feed(cityArrive)
    .exec(root)
    .exec(getUserSession)
    .exec(login)
    .exec(flights)
    .exec(selectFlight)
    .exec(selectFrom4th)
    .exec(creditCardInfo)
    .exec(invoice)

}
