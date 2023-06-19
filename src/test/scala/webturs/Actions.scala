package webturs

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Actions {

  val getRoot: HttpRequestBuilder = http("getRoot")
    .get("/webtours/")
    .headers(headers_root)
    .resources(
      http("request_1")
        .get("/webtours/header.html")
        .headers(headers_static_1),
      http("request_2")
        .get("/webtours/images/hp_logo.png"),
      http("request_3")
        .get("/webtours/images/webtours.png"),
      http("request_4")
        .get("/cgi-bin/welcome.pl?signOff=true")
        .headers(headers_pl),
      http("request_5")
        .get("/WebTours/home.html")
        .headers(headers_static_1),
    )
    .check(
      status.not(404),
      status.not(500)
    )

  val getUserSession = http("getUserSession")
    .get("/cgi-bin/nav.pl?in=home")
    .headers(headers_pl)
    .resources(
      http("request_7")
        .get("/WebTours/images/mer_login.gif")
    )
    .check(regex("""name="userSession" value="([^"]+)"""").saveAs("USER_SESSION")
    )

  val postLogin: HttpRequestBuilder = http("postLogin #{USER_SESSION}")
    .post("/cgi-bin/login.pl")
    .headers(headers_reservation)
    .formParam("userSession", "#{USER_SESSION}")
    .formParam("username", "libin")
    .formParam("password", "1234")
    .formParam("login.x", "66")
    .formParam("login.y", "9")
    .formParam("JSFormSubmit", "off")
    .resources(
      http("request_9")
        .get("/cgi-bin/login.pl?intro=true")
        .headers(headers_pl),
      http("request_10")
        .get("/cgi-bin/nav.pl?page=menu&in=home")
        .headers(headers_pl),
      http("request_11")
        .get("/WebTours/images/itinerary.gif")
        .headers(headers_img),
      http("request_12")
        .get("/WebTours/images/flights.gif")
        .headers(headers_img),
      http("request_13")
        .get("/WebTours/images/signoff.gif")
        .headers(headers_img),
      http("request_14")
        .get("/WebTours/images/in_home.gif")
        .headers(headers_img)
    )
    .check(
      status.not(404),
      status.not(500)
    )

  val getFlights: HttpRequestBuilder = http("getFlights")
    .get("/cgi-bin/welcome.pl?page=search")
    .headers(headers_pl)
    .resources(
      http("request_16")
        .get("/cgi-bin/nav.pl?page=menu&in=flights")
        .headers(headers_pl),
      http("request_17")
        .get("/WebTours/images/itinerary.gif"),
      http("request_18")
        .get("/WebTours/images/signoff.gif"),
      http("request_19")
        .get("/WebTours/images/home.gif")
        .headers(headers_img),
      http("request_20")
        .get("/cgi-bin/reservations.pl?page=welcome")
        .headers(headers_pl),
      http("request_21")
        .get("/WebTours/images/in_flights.gif")
        .headers(headers_img),
      http("request_22")
        .get("/WebTours/images/button_next.gif")
        .headers(headers_img)
    )
    .check(
      status.not(404),
      status.not(500)
    )


  val postSelectFlight: HttpRequestBuilder = http("postSelectFlight #{cityDepart} to #{cityArrive}")
    .post("/cgi-bin/reservations.pl")
    .headers(headers_reservation)
    .formParam("advanceDiscount", "0")
    .formParam("depart", "#{cityDepart}")
    .formParam("departDate", "06/19/2023")
    .formParam("arrive", "#{cityArrive}")
    .formParam("returnDate", "06/20/2023")
    .formParam("numPassengers", "1")
    .formParam("seatPref", "None")
    .formParam("seatType", "Coach")
    .formParam("findFlights.x", "68")
    .formParam("findFlights.y", "10")
    .formParam(".cgifields", "roundtrip")
    .formParam(".cgifields", "seatType")
    .formParam(".cgifields", "seatPref")
    .check(regex("""name="outboundFlight" value="(.*?)"""").findRandom.saveAs("OUTBOUND_FLIGHT"))
    .check(
      status.not(404),
      status.not(500)
    )

  val postSelectFrom4th: HttpRequestBuilder = http("postSelectFrom4th #{OUTBOUND_FLIGHT}")
    .post("/cgi-bin/reservations.pl")
    .headers(headers_reservation)
    .formParam("outboundFlight", "#{OUTBOUND_FLIGHT}")
    .formParam("numPassengers", "1")
    .formParam("advanceDiscount", "0")
    .formParam("seatType", "Coach")
    .formParam("seatPref", "None")
    .formParam("reserveFlights.x", "29")
    .formParam("reserveFlights.y", "14")
    .check(
      status.not(404),
      status.not(500)

    )

  val postCreditCardInfo: HttpRequestBuilder = http("postCreditCardInfo")
    .post("/cgi-bin/reservations.pl")
    .headers(headers_reservation)
    .formParam("firstName", "libin")
    .formParam("lastName", "seregey")
    .formParam("address1", "papanina")
    .formParam("address2", "Moskow")
    .formParam("pass1", "libin seregey")
    .formParam("creditCard", "9923232332323323")
    .formParam("expDate", "123")
    .formParam("oldCCOption", "")
    .formParam("numPassengers", "1")
    .formParam("seatType", "Coach")
    .formParam("seatPref", "None")
    .formParam("outboundFlight", "#{OUTBOUND_FLIGHT}")
    .formParam("advanceDiscount", "0")
    .formParam("returnFlight", "")
    .formParam("JSFormSubmit", "off")
    .formParam("buyFlights.x", "34")
    .formParam("buyFlights.y", "7")
    .formParam(".cgifields", "saveCC")
    .check(
      status.not(404),
      status.not(500)
    )

  val getInvoice: HttpRequestBuilder = http("getInvoice")
    .get("/cgi-bin/welcome.pl?page=menus")
    .headers(headers_pl)
    .resources(
      http("request_27")
        .get("/cgi-bin/nav.pl?page=menu&in=home")
        .headers(headers_pl),
      http("request_28")
        .get("/WebTours/images/itinerary.gif"),
      http("request_29")
        .get("/WebTours/images/signoff.gif"),
      http("request_30")
        .get("/WebTours/images/flights.gif"),
      http("request_31")
        .get("/WebTours/images/in_home.gif"),
      http("request_32")
        .get("/cgi-bin/login.pl?intro=true")
        .headers(headers_pl)
    )
    .check(
      status.not(404),
      status.not(500)
    )
}
