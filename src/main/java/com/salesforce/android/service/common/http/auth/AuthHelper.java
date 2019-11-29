package com.salesforce.android.service.common.http.auth;

import com.salesforce.android.service.common.http.AuthTokenProvider;

class AuthHelper {
    private static final String AUTHORIZATION = "Authorization";

    static String getAuthHeaderKey() {
        return "Authorization";
    }

    private AuthHelper() {
    }

    static String getAuthHeaderValue(AuthTokenProvider authTokenProvider) {
        return String.format("%s %s", new Object[]{authTokenProvider.getTokenType(), authTokenProvider.getToken()});
    }
}
