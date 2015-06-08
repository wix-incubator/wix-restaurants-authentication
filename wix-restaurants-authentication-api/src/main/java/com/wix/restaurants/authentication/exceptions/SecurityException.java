package com.wix.restaurants.authentication.exceptions;

public class SecurityException extends AuthenticationException {
    private static final long serialVersionUID = 1L;

    public SecurityException(String message, Throwable cause) {
        super(message, cause);
    }

    public SecurityException(String message) {
        super(message);
    }
}
