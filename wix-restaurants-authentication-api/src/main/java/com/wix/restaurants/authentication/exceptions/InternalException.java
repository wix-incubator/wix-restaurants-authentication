package com.wix.restaurants.authentication.exceptions;

public class InternalException extends AuthenticationException {
    private static final long serialVersionUID = 1L;

    public InternalException(String message, Throwable cause) {
        super(message, cause);
    }

    public InternalException(String message) {
        super(message);
    }
}
