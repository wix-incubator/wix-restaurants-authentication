package com.wix.restaurants.authentication.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,  
	    include = JsonTypeInfo.As.PROPERTY,  
	    property = "type")  
@JsonSubTypes({
	@Type(value = AuthenticateRequest.class, name = AuthenticateRequest.TYPE),
	@Type(value = FacebookLoginRequest.class, name = FacebookLoginRequest.TYPE),
	@Type(value = WixLoginInstanceRequest.class, name = WixLoginInstanceRequest.TYPE),
	@Type(value = OpenrestLoginRequest.class, name = OpenrestLoginRequest.TYPE)
})
public abstract class Request implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public Request() {}
}