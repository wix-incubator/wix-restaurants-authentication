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

/**
 * 	public static final String ERROR_INVALID_REQUEST = "invalid_request";
 public static final String ERROR_INVALID_DATA = "invalid_data";
 public static final String ERROR_INTERNAL = "internal";
 public static final String ERROR_SECURITY = "security";
 public static final String ERROR_TIMEOUT = "timeout";
 public static final String ERROR_NOT_FOUND = "not_found";
 public static final String ERROR_NO_PERMISSION = "no_permission";

 */
