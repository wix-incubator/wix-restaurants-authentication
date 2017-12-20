package com.wix.restaurants.authentication;

import com.wix.restaurants.authentication.model.LoginResponse;
import com.wix.restaurants.authentication.model.User;

public interface WixRestaurantsAuthenticationClient {
    LoginResponse loginWithFacebook(String fbAccessToken);
    LoginResponse loginWithOpenrest(String username, String password);
    LoginResponse loginWithWixInstance(String instance);

    User authenticate(String accessToken);
}
