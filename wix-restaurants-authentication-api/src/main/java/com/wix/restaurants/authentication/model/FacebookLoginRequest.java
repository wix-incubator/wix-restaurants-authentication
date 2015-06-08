package com.wix.restaurants.authentication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FacebookLoginRequest extends Request {
    public static final String TYPE = "facebook.login";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public FacebookLoginRequest() {}
    
    public FacebookLoginRequest(String accessToken) {
    	this.accessToken = accessToken;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
}
