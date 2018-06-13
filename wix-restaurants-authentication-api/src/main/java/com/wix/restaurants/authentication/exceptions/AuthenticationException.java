package com.wix.restaurants.authentication.exceptions;

/** User is unauthenticated: not authenticated at all, or authenticated incorrectly. */
public class AuthenticationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthenticationException(String message) {
        super(message);
    }
}
