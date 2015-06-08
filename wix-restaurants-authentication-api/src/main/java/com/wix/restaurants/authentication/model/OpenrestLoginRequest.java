package com.wix.restaurants.authentication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenrestLoginRequest extends Request {
    public static final String TYPE = "openrest.login";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public OpenrestLoginRequest() {}

    public OpenrestLoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @JsonInclude(Include.NON_NULL)
    public String username;

    @JsonInclude(Include.NON_NULL)
    public String password;
}
