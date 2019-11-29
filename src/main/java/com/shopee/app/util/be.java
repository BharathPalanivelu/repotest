package com.shopee.app.util;

import android.webkit.CookieManager;
import com.shopee.app.network.http.b.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

public class be implements CookieJar {

    /* renamed from: a  reason: collision with root package name */
    private boolean f26240a = true;

    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        CookieManager a2 = a();
        if (a2 != null) {
            String httpUrl2 = httpUrl.toString();
            for (Cookie cookie : list) {
                a2.setCookie(httpUrl2, cookie.toString());
            }
        }
    }

    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        if (this.f26240a) {
            this.f26240a = false;
            a.c();
        }
        CookieManager a2 = a();
        if (a2 != null) {
            String cookie = a2.getCookie(httpUrl.toString());
            if (cookie != null && !cookie.isEmpty()) {
                String[] split = cookie.split(";");
                ArrayList arrayList = new ArrayList();
                for (String parse : split) {
                    Cookie parse2 = Cookie.parse(httpUrl, parse);
                    if (parse2 != null) {
                        arrayList.add(parse2);
                    }
                }
                return arrayList;
            }
        }
        return Collections.emptyList();
    }

    private CookieManager a() {
        try {
            return CookieManager.getInstance();
        } catch (Exception unused) {
            return null;
        }
    }
}
