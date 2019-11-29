package com.shopee.app.network.http.b;

import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.react.g;
import com.shopee.app.util.bm;
import com.shopee.app.util.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Cookie;
import okhttp3.HttpUrl;

public class a {
    public static String a() {
        HttpUrl parse = HttpUrl.parse(i.f7040c);
        if (parse == null) {
            return "";
        }
        for (Cookie next : ar.f().e().okHttpClient().cookieJar().loadForRequest(parse)) {
            if ("csrftoken".equals(next.name())) {
                return next.value();
            }
        }
        return "";
    }

    public static List<Cookie> b() {
        HttpUrl parse = HttpUrl.parse("https://mall.test.shopee.sg/");
        if (parse == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Cookie next : ar.f().e().okHttpClient().cookieJar().loadForRequest(parse)) {
            if ("SPC_PFB_RN_STATIC".equals(next.name())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static void a(List<Cookie> list) {
        if (list != null) {
            for (Cookie next : list) {
                CookieManager instance = CookieManager.getInstance();
                instance.setCookie("https://mall.test.shopee.sg/", next.name() + SimpleComparison.EQUAL_TO_OPERATION + next.value() + ";");
            }
        }
        CookieSyncManager.getInstance().sync();
    }

    public static void c() {
        try {
            UserInfo loggedInUser = ar.f().e().loggedInUser();
            CookieManager instance = CookieManager.getInstance();
            instance.setAcceptCookie(true);
            String str = "userid=" + loggedInUser.getUserId() + "; shopid=" + loggedInUser.getShopId() + "; shopee_token=" + loggedInUser.getToken() + "; domain=" + i.f7042e + "; path=/;";
            String str2 = "shopee_token=" + loggedInUser.getToken() + "; domain=" + i.f7042e + "; path=/;";
            instance.setCookie(i.f7042e, str);
            instance.setCookie(i.f7042e, str2);
            instance.setCookie(i.f7042e, "username=" + loggedInUser.getUsername() + "; domain=" + i.f7042e + "; path=/;");
            instance.setCookie(i.f7042e, "UA=" + bm.a(e()) + "; domain=" + i.f7042e + "; path=/;");
            instance.setCookie(i.f7042e, "SPC_AFTID=" + com.shopee.app.react.modules.app.appmanager.a.i() + "; domain=" + i.f7042e + "; path=/;");
            d();
            CookieSyncManager.getInstance().sync();
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    private static void d() {
        HashMap hashMap = new HashMap();
        hashMap.put("shopee_app_version", com.shopee.app.react.modules.app.appmanager.a.b());
        hashMap.put("shopee_rn_version", String.valueOf(g.a().i()));
        try {
            for (Map.Entry entry : hashMap.entrySet()) {
                CookieManager.getInstance().setCookie(i.f7042e, ((String) entry.getKey()) + SimpleComparison.EQUAL_TO_OPERATION + ((String) entry.getValue()) + "; domain=" + i.f7042e + "; path=/;");
            }
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    private static String e() {
        return (("Shopee Android Beeshop" + " locale/" + ar.f().e().deviceStore().b()) + " version=297") + " appver=" + com.shopee.app.react.modules.app.appmanager.a.b();
    }
}
