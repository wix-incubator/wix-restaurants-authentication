package com.wix.restaurants.authentication.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable, Cloneable  {
	private static final long serialVersionUID = 1L;

    /** Facebook users, id is the Facebook user id. */
	public static final String NS_FACEBOOK = "com.facebook";
    /** Wix users, id is the Wix user id. */
	public static final String NS_WIX = "com.wix";
    /** Wix websites, id is the Wix site id. */
    public static final String NS_WIX_SITE = "com.wix.sites";
    /** OpenRest users, id is the user's email. */
	public static final String NS_OPENREST = "com.openrest";
	/** Google OpenID Connect, id is the user's email. */
	public static final String NS_GOOGLE = "com.google";

    /** Default constructor for JSON deserialization. */
	public User() {}
	
	public User(String ns, String id) {
		this.ns = ns;
		this.id = id;
	}
	
    @Override
	public Object clone() {
    	return new User(ns, id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (ns != null ? !ns.equals(user.ns) : user.ns != null) return false;
		return !(id != null ? !id.equals(user.id) : user.id != null);

	}

	@Override
	public int hashCode() {
		int result = ns != null ? ns.hashCode() : 0;
		result = 31 * result + (id != null ? id.hashCode() : 0);
		return result;
	}

    @JsonInclude(Include.NON_NULL)
	public String ns;
    
    @JsonInclude(Include.NON_NULL)
	public String id;
}
