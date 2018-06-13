package com.wix.restaurants.authentication

import akka.actor.ActorSystem
import akka.http.javadsl.model.headers.Authorization
import akka.http.scaladsl.client.RequestBuilding.{Get, Post}
import com.wix.rest.rfc7807.api.model.ErrorResponse
import com.wix.rest.rfc7807.client.AkkaRestClient
import com.wix.restaurants.authentication.exceptions._
import com.wix.restaurants.authentication.model._
import com.wix.restaurants.json.Json

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext}

class DefaultWixRestaurantsAuthenticationClient(endpoint: String = "https://auth.wixrestaurants.com/v2",
                                                readTimeout: Option[Duration] = None) extends WixRestaurantsAuthenticationClient {
  private val actualReadTimeout: Duration = readTimeout.getOrElse(Duration.Inf)

  private implicit val system: ActorSystem = ActorSystem("akka-wix-restaurants-client-system")
  private implicit val executionContext: ExecutionContext = system.dispatcher
  private val client: AkkaRestClient = new AkkaRestClient(errorResponseAsException = ExceptionTranslator.asException)


  override def loginWithFacebook(fbAccessToken: String): LoginResponse = {
    val request = Post(s"$endpoint/com.facebook/access_token", Json.stringify(FacebookLogin(fbAccessToken)))
    Await.result(client.execute(request) withResult[LoginResponse](), actualReadTimeout)
  }

  override def loginWithGoogle(clientId: String, idToken: String): LoginResponse = {
    val request = Post(s"$endpoint/com.google/access_token", Json.stringify(GoogleLogin(clientId, idToken)))
    Await.result(client.execute(request) withResult[LoginResponse](), actualReadTimeout)
  }

  override def loginWithOpenrest(username: String, password: String): LoginResponse = {
    val request = Post(s"$endpoint/com.openrest/access_token", Json.stringify(OpenrestLogin(username, password)))
    Await.result(client.execute(request) withResult[LoginResponse](), actualReadTimeout)
  }

  override def loginWithWixInstance(instance: String): LoginResponse = {
    val request = Post(s"$endpoint/com.wix/access_token", Json.stringify(WixLogin(instance)))
    Await.result(client.execute(request) withResult[LoginResponse](), actualReadTimeout)
  }

  override def loginInstanceWithWixInstance(instance: String): LoginResponse = {
    val request = Post(s"$endpoint/com.wix.instances/access_token", Json.stringify(WixLogin(instance)))
    Await.result(client.execute(request) withResult[LoginResponse](), actualReadTimeout)
  }

  override def impersonate(accessToken: String, user: User): LoginResponse = {
    val request = Post(s"$endpoint/impersonate", Json.stringify(user))
      .addHeader(Authorization.oauth2(accessToken))
    Await.result(client.execute(request) withResult[LoginResponse](), actualReadTimeout)
  }

  override def authenticate(accessToken: String): User = {
    val request = Get(s"$endpoint/me")
      .addHeader(Authorization.oauth2(accessToken))
    Await.result(client.execute(request) withResult[User](), actualReadTimeout)
  }
}

private object ExceptionTranslator {
  def asException(errorResponse: ErrorResponse): RuntimeException = {
    // TODO: use error type constants
    errorResponse.`type` match {
      case "https://www.wixrestaurants.com/errors/internal" => new InternalException(errorResponse.detail.orNull)
      case "https://www.wixrestaurants.com/errors/authentication" => new AuthenticationException(errorResponse.detail.orNull)
      case "https://www.wixrestaurants.com/errors/invalid_data" => new InvalidDataException(errorResponse.detail.orNull)
      case "https://www.wixrestaurants.com/errors/forbidden" => new ForbiddenException(errorResponse.detail.orNull)
      case "https://www.wixrestaurants.com/errors/not_secure" => new SecurityException(errorResponse.detail.orNull)
      case _ => new RuntimeException(s"Type: '${errorResponse.`type`}'${errorResponse.detail.map(detail => s", Detail: '$detail'").getOrElse("")}")
    }
  }
}
