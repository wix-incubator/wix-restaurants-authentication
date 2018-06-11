package com.wix.restaurants.authentication.exceptions;

public class AuthenticationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthenticationException(String message) {
        super(message);
    }
}
