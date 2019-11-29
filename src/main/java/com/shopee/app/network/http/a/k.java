package com.shopee.app.network.http.a;

import com.shopee.app.network.http.data.user.UserAccessTokenRequest;
import com.shopee.app.network.http.data.user.UserAccessTokenResponse;
import f.c.a;
import f.c.i;
import f.c.o;
import io.b.j;

public interface k {
    @o(a = "api/v2/user/access_token/get/")
    j<UserAccessTokenResponse> a(@i(a = "X-CSRFToken") String str, @i(a = "Referer") String str2, @a UserAccessTokenRequest userAccessTokenRequest);
}
