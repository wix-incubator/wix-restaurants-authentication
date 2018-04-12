package com.wix.restaurants.authentication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WixInstanceLoginInstanceRequest extends Request {
    public static final String TYPE = "wix_instance.loginInstance";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public WixInstanceLoginInstanceRequest() {}

    public WixInstanceLoginInstanceRequest(String instance) {
        this.instance = instance;
    }

    @JsonInclude(Include.NON_NULL)
    public String instance;
}
