package org.scalatra.example.swagger

import org.scalatra._

// Swagger-specific Scalatra imports
import org.scalatra.swagger._

// JSON-related libraries
import org.json4s.{DefaultFormats, Formats}

// JSON handling support from Scalatra
import org.scalatra.json._



class FlowersController(implicit val swagger: Swagger) extends ScalatraServlet with JacksonJsonSupport with SwaggerSupport  {

  // Sets up automatic case class to JSON output serialization, required by
  // the JValueResult trait.
  protected implicit val jsonFormats: Formats = DefaultFormats

  // The name of our application. This will show up in the Swagger docs.
  override protected val applicationName = Some("flowers")

  // A description of our application. This will show up in the Swagger docs.
  protected val applicationDescription = "The flowershop API. It exposes operations for browing and searching lists of flowers"

  // Before every action runs, set the content type to be in JSON format.
  before() {
    contentType = formats("json")
  }

  // An API description about retrieving flowers.
  val getFlowers =
    (apiOperation[List[Flower]]("getFlowers")
      summary "Show all flowers"
      notes "Shows all the flowers in the flower shop. You can search it too."
      parameter queryParam[Option[String]]("name").description("A name to search for"))

  // An API description about finding flowers using a slug.
  val findBySlug =
    (apiOperation[Flower]("findBySlug")
      summary "Find by slug"
      parameters (
      pathParam[String]("slug").description("Slug of flower that needs to be fetched")))


  /**
   * Retrieve a list of flowers
   */
  get("/", operation(getFlowers)){
    params.get("name") match {
      case Some(name) => FlowerData.all filter (_.name.toLowerCase contains name.toLowerCase())
      case None => FlowerData.all
    }
  }

  get("/:slug", operation(findBySlug)) {
    FlowerData.all find (_.slug == params("slug")) match {
      case Some(b) => b
      case None => halt(404)
    }
  }


}


// A Flower object to use as a faked-out data model
case class Flower(slug: String, name: String)

// An amazing datastore!
object FlowerData {

  /**
   * Some fake flowers data so we can simulate retrievals.
   */
  var all = List(
    Flower("yellow-tulip", "Yellow Tulip"),
    Flower("red-rose", "Red Rose"),
    Flower("black-rose", "Black Rose"))
}