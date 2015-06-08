package com.wix.restaurants.authentication.exceptions;

public class NotFoundException extends AuthenticationException {
    private static final long serialVersionUID = 1L;

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(String message) {
        super(message);
    }
}
