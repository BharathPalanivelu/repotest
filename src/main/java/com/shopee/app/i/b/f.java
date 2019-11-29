package com.shopee.app.i.b;

import com.facebook.react.modules.network.OkHttpClientProvider;
import com.shopee.app.util.be;
import com.shopee.sdk.f.b;
import com.shopee.sdk.modules.app.c.a;
import java.util.Collections;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

public class f implements a {

    /* renamed from: a  reason: collision with root package name */
    private be f17723a = new be();

    public OkHttpClient a() {
        return OkHttpClientProvider.getOkHttpClient();
    }

    public void a(String str, b<List<Cookie>> bVar) {
        HttpUrl parse = HttpUrl.parse(str);
        if (parse != null) {
            bVar.b(this.f17723a.loadForRequest(parse));
        } else {
            bVar.b(1, "URL is Invalid");
        }
    }

    public void a(String str, Cookie cookie, b<Integer> bVar) {
        HttpUrl parse = HttpUrl.parse(str);
        if (parse != null) {
            this.f17723a.saveFromResponse(parse, Collections.singletonList(cookie));
            bVar.b(1);
            return;
        }
        bVar.b(1, "URL is Invalid");
    }
}
