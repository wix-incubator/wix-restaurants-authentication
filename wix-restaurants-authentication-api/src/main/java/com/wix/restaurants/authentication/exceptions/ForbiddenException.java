package com.wix.restaurants.authentication.exceptions;

/** User is authenticated correctly, but is forbidden from accessing this resource. */
public class ForbiddenException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    public ForbiddenException(String message) {
        super(message);
    }
}
