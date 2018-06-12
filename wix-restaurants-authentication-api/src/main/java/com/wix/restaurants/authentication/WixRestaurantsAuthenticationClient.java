package com.wix.restaurants.authentication;

import com.wix.restaurants.authentication.model.LoginResponse;
import com.wix.restaurants.authentication.model.User;

public interface WixRestaurantsAuthenticationClient {
    LoginResponse loginWithFacebook(String fbAccessToken);
    LoginResponse loginWithGoogle(String clientId, String idToken);
    LoginResponse loginWithOpenrest(String username, String password);
    LoginResponse loginWithWixInstance(String instance);
    LoginResponse loginInstanceWithWixInstance(String instance);
    LoginResponse impersonate(String accessToken, User user);

    User authenticate(String accessToken);
}
