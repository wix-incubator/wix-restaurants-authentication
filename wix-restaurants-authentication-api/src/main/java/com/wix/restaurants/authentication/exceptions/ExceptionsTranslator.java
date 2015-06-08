package com.wix.restaurants.authentication.exceptions;

import com.wix.restaurants.authentication.model.Error;

public class ExceptionsTranslator {
    public AuthenticationException translateError(Error error) {
        switch (error.code) {
            case Error.ERROR_INVALID_REQUEST:
                return new InvalidRequestException(error.message);
            case Error.ERROR_INVALID_DATA:
                return new InvalidDataException(error.message);
            case Error.ERROR_INTERNAL:
                return new InternalException(error.message);
            case Error.ERROR_SECURITY:
                return new SecurityException(error.message);
            case Error.ERROR_TIMEOUT:
                return new TimeoutException(error.message);
            case Error.ERROR_NOT_FOUND:
                return new NotFoundException(error.message);
            case Error.ERROR_NO_PERMISSION:
                return new NoPermissionException(error.message);
            default:
                return new AuthenticationException(error.code + "|" + error.message);
        }
    }

    public Error translateException(AuthenticationException e) {
        if (e instanceof InvalidRequestException) {
            return new Error(Error.ERROR_INVALID_REQUEST, e.getMessage());
        } else if (e instanceof InvalidDataException) {
            return new Error(Error.ERROR_INVALID_DATA, e.getMessage());
        } else if (e instanceof InternalException) {
            return new Error(Error.ERROR_INTERNAL, e.getMessage());
        } else if (e instanceof SecurityException) {
            return new Error(Error.ERROR_SECURITY, e.getMessage());
        } else if (e instanceof TimeoutException) {
            return new Error(Error.ERROR_TIMEOUT, e.getMessage());
        } else if (e instanceof NotFoundException) {
            return new Error(Error.ERROR_NOT_FOUND, e.getMessage());
        } else if (e instanceof NoPermissionException) {
            return new Error(Error.ERROR_NO_PERMISSION, e.getMessage());
        } else {
            final String[] parts = e.getMessage().split("\\|");
            return new Error(parts[0], parts[1]);
        }
    }
}
