package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient
import javax.inject.Inject
import org.sedis.Pool

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() (sedisPool: Pool) extends Controller {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action {
    Ok(Json.obj("payload" -> ""))
  }

  def expire(sellerid: String, lkgt: String) = Action {
    val cts: String = sedisPool.withJedisClient(client => client.get(sellerid))
    Ok(Json.obj("sellerid" -> sellerid, "cts" -> cts, "lkgt" -> lkgt, "action" -> "expire"))
  }

}
