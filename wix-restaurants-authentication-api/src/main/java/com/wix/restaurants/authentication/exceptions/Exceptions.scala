package com.wix.restaurants.authentication.exceptions

/** User is unauthenticated: not authenticated at all, or authenticated incorrectly. */
case class AuthenticationException(message: String, cause: Throwable) extends RuntimeException(message, cause)
object AuthenticationException {
  def apply(message: String): AuthenticationException = this(message, null)
  def apply(cause: Throwable): AuthenticationException = this(null, cause)
  def apply(): AuthenticationException = this(null, null)
}

/** User is authenticated correctly, but is forbidden from accessing this resource. */
case class ForbiddenException(message: String, cause: Throwable) extends RuntimeException(message, cause)
object ForbiddenException {
  def apply(message: String): ForbiddenException = this(message, null)
  def apply(cause: Throwable): ForbiddenException = this(null, cause)
  def apply(): ForbiddenException = this(null, null)
}

case class InternalException(message: String, cause: Throwable) extends RuntimeException(message, cause)
object InternalException {
  def apply(message: String): InternalException = this(message, null)
  def apply(cause: Throwable): InternalException = this(null, cause)
  def apply(): InternalException = this(null, null)
}

case class InvalidDataException(message: String, cause: Throwable) extends RuntimeException(message, cause)
object InvalidDataException {
  def apply(message: String): InvalidDataException = this(message, null)
  def apply(cause: Throwable): InvalidDataException = this(null, cause)
  def apply(): InvalidDataException = this(null, null)
}

case class NotSecureException(message: String, cause: Throwable) extends RuntimeException(message, cause)
object NotSecureException {
  def apply(message: String): NotSecureException = this(message, null)
  def apply(cause: Throwable): NotSecureException = this(null, cause)
  def apply(): NotSecureException = this(null, null)
}

case class TemporarilyUnavailableException(message: String, cause: Throwable) extends RuntimeException(message, cause)
object TemporarilyUnavailableException {
  def apply(message: String): TemporarilyUnavailableException = this(message, null)
  def apply(cause: Throwable): TemporarilyUnavailableException = this(null, cause)
  def apply(): TemporarilyUnavailableException = this(null, null)
}