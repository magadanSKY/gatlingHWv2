import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import scala.concurrent.duration._
import io.gatling.jdbc.Predef._

package object webturs {

  val httpProtocol = http
    .baseUrl("http://webtours.load-test.ru:1080")
    .inferHtmlResources()
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36")

   val headers_root = Map(
    "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
    "Accept-Encoding" -> "gzip, deflate",
    "Accept-Language" -> "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7",
    "Cache-Control" -> "max-age=0",
    "If-Modified-Since" -> "Mon, 27 May 2013 12:20:22 GMT",
    "If-None-Match" -> "900000001a214-16e-4ddb22c2e6d80",
    "Upgrade-Insecure-Requests" -> "1"
  )

   val headers_static_1 = Map("Upgrade-Insecure-Requests" -> "1")

   val headers_pl = Map(
    "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
    "Accept-Encoding" -> "gzip, deflate",
    "Accept-Language" -> "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7",
    "Upgrade-Insecure-Requests" -> "1"
  )

   val headers_reservation = Map(
    "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
    "Accept-Encoding" -> "gzip, deflate",
    "Accept-Language" -> "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7",
    "Cache-Control" -> "max-age=0",
    "Origin" -> "http://webtours.load-test.ru:1080",
    "Upgrade-Insecure-Requests" -> "1"
  )

    val headers_img = Map(
    "Accept" -> "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8",
    "Accept-Encoding" -> "gzip, deflate",
    "Accept-Language" -> "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7"
  )
}