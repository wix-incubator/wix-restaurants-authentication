package com.wix.restaurants.authentication.exceptions;

public class NoPermissionException  extends AuthenticationException {
    private static final long serialVersionUID = 1L;

    public NoPermissionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoPermissionException(String message) {
        super(message);
    }
}
