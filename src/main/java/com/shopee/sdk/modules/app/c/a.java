package com.shopee.sdk.modules.app.c;

import com.shopee.sdk.f.b;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.OkHttpClient;

public interface a {
    OkHttpClient a();

    void a(String str, b<List<Cookie>> bVar);

    void a(String str, Cookie cookie, b<Integer> bVar);
}
