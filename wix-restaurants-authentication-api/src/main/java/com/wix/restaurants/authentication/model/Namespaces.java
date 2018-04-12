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

    /** OpenRest users, id is the user's email. */
    public static final String openrest = "com.openrest";

    /** Google OpenID Connect, id is the user's email. */
    public static final String google = "com.google";
}
