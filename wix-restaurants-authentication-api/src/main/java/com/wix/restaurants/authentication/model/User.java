package com.wix.restaurants.authentication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.Objects;

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
	public User clone() {
    	return new User(ns, id);
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(ns, user.ns) &&
                Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ns, id);
    }

    @Override
    public String toString() {
        return "User{" +
                "ns='" + ns + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

	/** @see Namespaces */
    @JsonInclude(Include.NON_NULL)
	public String ns;
    
    @JsonInclude(Include.NON_NULL)
	public String id;
}
