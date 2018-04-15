package com.wix.restaurants.authentication.model;

import java.io.Serializable;
import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LoginResponse that = (LoginResponse) o;
		return Objects.equals(user, that.user) &&
				Objects.equals(accessToken, that.accessToken);
	}

	@Override
	public int hashCode() {
		return Objects.hash(user, accessToken);
	}

	@Override
	public String toString() {
		return "LoginResponse{" +
				"user=" + user +
				", accessToken='" + accessToken + '\'' +
				'}';
	}

    @JsonInclude(Include.NON_NULL)
	public User user;
    
    @JsonInclude(Include.NON_NULL)
	public String accessToken;
}
