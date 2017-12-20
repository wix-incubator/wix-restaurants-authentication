package com.wix.restaurants.authentication;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.wix.restaurants.authentication.exceptions.ExceptionsTranslator;
import com.wix.restaurants.authentication.exceptions.InternalException;
import com.wix.restaurants.authentication.model.*;
import com.wix.restaurants.jsonclient.JsonClient;

import java.io.IOException;

public class DefaultWixRestaurantsAuthenticationClient implements WixRestaurantsAuthenticationClient {
    private final ExceptionsTranslator exceptionsTranslator = new ExceptionsTranslator();
    private final JsonClient jsonClient;
    private final String endpointUrl;

    public static class Builder {
        private HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory();
        private int connectTimeout = 0;
        private int readTimeout = 0;
        private int numberOfRetries = 0;
        private String endpointUrl = Endpoints.PRODUCTION;

        public Builder setRequestFactory(HttpRequestFactory requestFactory) {
            this.requestFactory = requestFactory;
            return this;
        }

        public Builder setConnectTimeout(int connectTimeout) {
            this.connectTimeout = connectTimeout;
            return this;
        }

        public Builder setReadTimeout(int readTimeout) {
            this.readTimeout = readTimeout;
            return this;
        }

        public Builder setNumberOfRetries(int numberOfRetries) {
            this.numberOfRetries = numberOfRetries;
            return this;
        }

        public Builder setEndpointUrl(String endpointUrl) {
            this.endpointUrl = endpointUrl;
            return this;
        }

        public DefaultWixRestaurantsAuthenticationClient build() {
            return new DefaultWixRestaurantsAuthenticationClient(
                    requestFactory, connectTimeout, readTimeout, numberOfRetries, endpointUrl);
        }
    }

    public DefaultWixRestaurantsAuthenticationClient(HttpRequestFactory requestFactory, Integer connectTimeout,
                                                     Integer readTimeout, Integer numberOfRetries, String endpointUrl) {
        jsonClient = new JsonClient(requestFactory, connectTimeout, readTimeout, numberOfRetries);
        this.endpointUrl = endpointUrl;
    }

    @Override
    public LoginResponse loginWithFacebook(String fbAccessToken) {
        final FacebookLoginRequest facebookLoginRequest = new FacebookLoginRequest();
        facebookLoginRequest.accessToken = fbAccessToken;

        final LoginResponse facebookLoginResponse = request(
                facebookLoginRequest, new TypeReference<Response<LoginResponse>>() {});

        return facebookLoginResponse;
    }

    @Override
    public LoginResponse loginWithOpenrest(String username, String password) {
        final OpenrestLoginRequest openrestLoginRequest = new OpenrestLoginRequest();
        openrestLoginRequest.username = username;
        openrestLoginRequest.password = password;

        final LoginResponse openrestLoginResponse = request(
                openrestLoginRequest, new TypeReference<Response<LoginResponse>>() {});

        return openrestLoginResponse;
    }

    @Override
    public LoginResponse loginWithWixInstance(String instance) {
        final WixLoginInstanceRequest wixLoginInstanceRequest = new WixLoginInstanceRequest();
        wixLoginInstanceRequest.instance = instance;

        final LoginResponse wixLoginInstanceResponse = request(
                wixLoginInstanceRequest, new TypeReference<Response<LoginResponse>>() {});

        return wixLoginInstanceResponse;
    }

    @Override
    public User authenticate(String accessToken) {
        final AuthenticateRequest authenticateRequest = new AuthenticateRequest();
        authenticateRequest.accessToken = accessToken;

        final User authenticateResponse = request(
                authenticateRequest, new TypeReference<Response<User>>() {});

        return authenticateResponse;
    }

    private <T> T request(Request request, TypeReference<Response<T>> responseType) {
        try {
            final Response<T> response = jsonClient.post(endpointUrl, request, responseType);

            if (response.error != null) {
                throw exceptionsTranslator.translateError(response.error);
            }

            return response.value;
        } catch (IOException e) {
            throw new InternalException(e.getMessage(), e);
        }
    }
}