package com.wix.restaurants.authentication.model;

public class Namespaces {
    private Namespaces() {}

    /**
     * Facebook users.
     * Identifier: Facebook user ID, e.g. "4" for Mark Zuckerberg.
     */
    public static final String facebook = "com.facebook";

    /**
     * Facebook pages.
     * Identifier: Facebook page ID, e.g. "20531316728" for Facebook's own facebook page.
     */
    public static final String facebookPages = "com.facebook.pages";

    /**
     * Wix users.
     * Identifier: Wix user ID (GUID).
     */
    public static final String wix = "com.wix";

    /**
     * Wix websites.
     * Identifier: Wix site ID (GUID).
     */
    public static final String wixSites = "com.wix.sites";

    /**
     * Wix app instances.
     * Identifier: Wix instance ID (GUID).
     */
    public static final String wixInstances = "com.wix.instances";

    /**
     * Owners (customers) of a Wix Restaurants order.
     * Identifier: order ID.
     */
    public static final String wixRestaurantsOrdersOwners = "com.wix.restaurants.orders.owners";

    /**
     * Recipients of Wix Restaurants order share.
     * Identifier: order ID.
     */
    public static final String wixRestaurantsOrdersShares = "com.wix.restaurants.orders.shares";

    /**
     * Owners (customers) of a Wix Restaurants reservation.
     * Identifier: reservation ID.
     */
    public static final String wixRestaurantsReservationsOwners = "com.wix.restaurants.reservations.owners";

    /**
     * Recipients of Wix Restaurants reservation share.
     * Identifier: reservation ID.
     */
    public static final String wixRestaurantsReservationsShares = "com.wix.restaurants.reservations.shares";

    /**
     * Legacy OpenRest users.
     * Identifier: the user's email in lowercase, e.g. "example@gmail.com".
     */
    public static final String openrest = "com.openrest";

    /**
     * Google OpenID Connect.
     * Identifier: Google user ID (email) in lowercase, e.g. "example@gmail.com".
     */
    public static final String google = "com.google";

    /**
     * Phone number owners.
     * Identifier: phone number in <a href="https://en.wikipedia.org/wiki/E.164">E.164 format</a>, e.g. "+12024561111".
     */
    public static final String phone = "tel";

    /**
     * Email address owners.
     * Identifier: email address in lowercase, e.g. "example@example.org".
     */
    public static final String email = "email";
}
