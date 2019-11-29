package com.shopee.app.network.http.a;

import com.shopee.app.network.http.data.JsonDataResponse;
import f.b;
import f.c.f;
import f.c.t;

public interface i {
    @f(a = "api/v2/content/me_page_config")
    b<JsonDataResponse> a(@t(a = "page_name") String str);
}
