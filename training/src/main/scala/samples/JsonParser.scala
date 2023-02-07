package samples

import io.circe._, io.circe.parser._, io.circe.generic.auto._



object JsonParser extends App {

val jsonString =
"""
|{
|"id": "101010",
|"name": "product name",
| "image": {
| "url": "/public/images/xyz.png",
| "altText": "alternative text"
| },
|"available": true,
|"price": 10.8
|}
|""".stripMargin


val parseResult = parser.decode[Product](jsonString)

parseResult match {
  case Left(parsingError) =>
    throw new IllegalArgumentException(s"Invalid JSON object: ${parsingError}")
  case Right(product) => 
    println(product.id)
    println(product.image.url)
    println(product.price)
 }
}


case class Product(
  id: String,
  name: String,
  image: Image,
  available: Boolean,
  price: Float
)

case class Image(
  url: String,
  altText: String
)
