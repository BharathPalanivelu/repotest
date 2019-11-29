package com.shopee.app.network.http.data.user;

import com.google.a.a.c;
import com.shopee.app.network.http.data.BaseResponse;

public final class UserAccessTokenResponse extends BaseResponse {
    @c(a = "data")
    private final AccessTokenData data;

    public final AccessTokenData getData() {
        return this.data;
    }

    public UserAccessTokenResponse(AccessTokenData accessTokenData) {
        this.data = accessTokenData;
    }
}
