package com.wix.restaurants.authentication.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable, Cloneable  {
	private static final long serialVersionUID = 1L;

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

	/** @see Namespaces */
    @JsonInclude(Include.NON_NULL)
	public String ns;
    
    @JsonInclude(Include.NON_NULL)
	public String id;
}
