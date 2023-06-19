package webturs

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
import scala.concurrent.duration._

class Debug extends Simulation{
  setUp(CommonScenario().inject(
    //0-100 - раскомментить все нижние
    //stressPeakUsers(0).during(60.seconds),
    //stressPeakUsers(15).during(120.seconds),
    //stressPeakUsers(30).during(120.seconds),
    //stressPeakUsers(45).during(120.seconds),
    //stressPeakUsers(60).during(120.seconds),
    //stressPeakUsers(75).during(120.seconds),
    //stressPeakUsers(90).during(120.seconds),
    //stressPeakUsers(105).during(120.seconds),
    //stressPeakUsers(120).during(120.seconds),
    //stressPeakUsers(135).during(120.seconds),
    //stressPeakUsers(150).during(120.seconds),
    
    //80% в течении 1 часа
    //constantConcurrentUsers(2).during(3600.seconds)
    atOnceUsers(1)
  )
  )

    .protocols(httpProtocol)
    .assertions(global.responseTime.max.lt(1200))//sla = 1200
}
