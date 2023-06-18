package webturs

import io.gatling.core.Predef._
import io.gatling.core.feeder.BatchableFeederBuilder
import io.gatling.http.Predef._

object Feeders {

  val cityDepart= csv("cityDepart.csv").random.eager

  val cityArrive = csv("cityArrive.csv").random.eager

}
