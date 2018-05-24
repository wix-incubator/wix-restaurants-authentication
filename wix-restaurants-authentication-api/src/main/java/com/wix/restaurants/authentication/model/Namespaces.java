package com.wix.restaurants.authentication.model;

public class Namespaces {
    private Namespaces() {}

    /** Facebook users, id is the Facebook user id. */
    public static final String facebook = "com.facebook";

    /** Wix users, id is the Wix user id. */
    public static final String wix = "com.wix";

    /** Wix websites, id is the Wix site id. */
    public static final String wixSites = "com.wix.sites";

    /** Wix app instances, id is the Wix instance id. */
    public static final String wixInstances = "com.wix.instances";

    /** Owner (customer) of a Wix Restaurants order, id is the order id. */
    public static final String wixRestaurantsOrdersOwners = "com.wix.restaurants.orders.owners";

    /** Recipient of Wix Restaurants order share, id is the order id. */
    public static final String wixRestaurantsOrdersShares = "com.wix.restaurants.orders.shares";

    /** Owner (customer) of a Wix Restaurants reservation, id is the reservation id. */
    public static final String wixRestaurantsReservationsOwners = "com.wix.restaurants.reservations.owners";

    /** Recipient of Wix Restaurants reservation share, id is the reservation id. */
    public static final String wixRestaurantsReservationsShares = "com.wix.restaurants.reservations.shares";

    /** OpenRest users, id is the user's email. */
    public static final String openrest = "com.openrest";

    /** Google OpenID Connect, id is the user's email. */
    public static final String google = "com.google";

    /** Phone number owner, id is the phone in <a href="https://en.wikipedia.org/wiki/E.164">E.164 format</a>. */
    public static final String phone = "tel";

    /** Email address owner, id is the email address in lowercase. */
    public static final String email = "email";
}
