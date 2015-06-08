package com.wix.restaurants.authentication.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
	public LoginResponse() {}
	
	public LoginResponse(User user, String accessToken) {
		this.user = user;
		this.accessToken = accessToken;
	}
	
    @JsonInclude(Include.NON_NULL)
	public User user;
    
    @JsonInclude(Include.NON_NULL)
	public String accessToken;
}
