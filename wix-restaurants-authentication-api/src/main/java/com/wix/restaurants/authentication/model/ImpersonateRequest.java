package com.wix.restaurants.authentication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImpersonateRequest extends Request {
    public static final String TYPE = "impersonate";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public ImpersonateRequest() {}

    public ImpersonateRequest(String accessToken, User user) {
        this.accessToken = accessToken;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImpersonateRequest that = (ImpersonateRequest) o;
        return Objects.equals(accessToken, that.accessToken) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken, user);
    }

    @Override
    public String toString() {
        return "ImpersonateRequest{" +
                "accessToken='" + accessToken + '\'' +
                ", user=" + user +
                '}';
    }

    @JsonInclude(Include.NON_NULL)
    public String accessToken;

    @JsonInclude(Include.NON_NULL)
    public User user;
}
