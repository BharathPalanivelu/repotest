package com.salesforce.android.service.common.http.okhttp;

import com.salesforce.android.service.common.http.Challenge;

public class SalesforceHttpChallenge implements Challenge {
    private final okhttp3.Challenge mChallenge;

    public SalesforceHttpChallenge(okhttp3.Challenge challenge) {
        this.mChallenge = challenge;
    }

    public static Challenge wrap(okhttp3.Challenge challenge) {
        return new SalesforceHttpChallenge(challenge);
    }

    public String getRealm() {
        return this.mChallenge.realm();
    }

    public String getScheme() {
        return this.mChallenge.scheme();
    }
}
