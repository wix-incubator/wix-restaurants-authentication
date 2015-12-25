package com.wix.restaurants.authentication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleLoginRequest extends Request {
    public static final String TYPE = "google.login";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public GoogleLoginRequest() {}

    public GoogleLoginRequest(String clientId, String idToken) {
        this.clientId = clientId;
        this.idToken = idToken;
    }

    /** @see <a href="https://developers.google.com/identity/protocols/OpenIDConnect">OpenID Connect</a> */
    @JsonInclude(Include.NON_NULL)
    public String clientId;

    /** @see <a href="https://developers.google.com/identity/protocols/OpenIDConnect">OpenID Connect</a> */
    @JsonInclude(Include.NON_NULL)
    public String idToken;
}
