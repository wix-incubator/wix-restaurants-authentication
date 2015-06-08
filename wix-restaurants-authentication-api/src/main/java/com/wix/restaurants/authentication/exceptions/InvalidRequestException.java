package com.wix.restaurants.authentication.exceptions;

public class InvalidRequestException  extends AuthenticationException {
    private static final long serialVersionUID = 1L;

    public InvalidRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRequestException(String message) {
        super(message);
    }
}
