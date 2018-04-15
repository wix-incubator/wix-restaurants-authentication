package com.wix.restaurants.authentication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Error implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String ERROR_INVALID_REQUEST = "invalid_request";
	public static final String ERROR_INVALID_DATA = "invalid_data";
	public static final String ERROR_INTERNAL = "internal";
	public static final String ERROR_SECURITY = "security";
	public static final String ERROR_TIMEOUT = "timeout";
	public static final String ERROR_NOT_FOUND = "not_found";
	public static final String ERROR_NO_PERMISSION = "no_permission";
	
    /** Default constructor for JSON deserialization. */
    public Error() {}
    
    public Error(String code, String message) {
    	this.code = code;
    	this.message = message;
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Error error = (Error) o;
		return Objects.equals(code, error.code) &&
				Objects.equals(message, error.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, message);
	}

	@Override
	public String toString() {
		return "Error{" +
				"code='" + code + '\'' +
				", message='" + message + '\'' +
				'}';
	}

    /** Error code, one of the above. */
    @JsonInclude(Include.NON_NULL)
    public String code;

    /** Detailed error information for debugging. */
    @JsonInclude(Include.NON_NULL)
    public String message;
}