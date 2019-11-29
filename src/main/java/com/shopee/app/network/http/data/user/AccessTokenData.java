package com.shopee.app.network.http.data.user;

import com.google.a.a.c;

public final class AccessTokenData {
    @c(a = "auth_code")
    private final String authCode;

    public AccessTokenData(String str) {
        this.authCode = str;
    }

    public final String getAuthCode() {
        return this.authCode;
    }
}
