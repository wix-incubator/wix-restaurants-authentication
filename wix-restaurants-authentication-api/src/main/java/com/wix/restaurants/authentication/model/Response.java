package com.wix.restaurants.authentication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** The error value, if one occurred. */
    @JsonInclude(Include.NON_NULL)
    public Error error;

    /** The return value, if no error occurred. */
    @JsonInclude(Include.NON_NULL)
    public T value;

    public Response(T value) {
        this.value = value;
    }
    
    public Response(Error error) {
        this.error = error;
    }

    /** Default constructor for JSON deserialization. */
    public Response() {}

    @SuppressWarnings("rawtypes")
	public static Response fromNullValue() {
        return new Response();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response<?> response = (Response<?>) o;
        return Objects.equals(error, response.error) &&
                Objects.equals(value, response.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(error, value);
    }

    @Override
    public String toString() {
        return "Response{" +
                "error=" + error +
                ", value=" + value +
                '}';
    }
}
