package com.wix.restaurants.authentication.exceptions;

public class InvalidDataException  extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InvalidDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDataException(String message) {
        super(message);
    }
}
