package com.wix.restaurants.authentication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthenticateRequest extends Request {
	public static final String TYPE = "authenticate";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public AuthenticateRequest() {}
    
    public AuthenticateRequest(String accessToken) {
    	this.accessToken = accessToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthenticateRequest that = (AuthenticateRequest) o;
        return Objects.equals(accessToken, that.accessToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken);
    }

    @Override
    public String toString() {
        return "AuthenticateRequest{" +
                "accessToken='" + accessToken + '\'' +
                '}';
    }

    @JsonInclude(Include.NON_NULL)
    public String accessToken;
}
