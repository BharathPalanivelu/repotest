package com.shopee.feeds.feedlibrary.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.airpay.paysdk.base.bean.BPOrderInfo;
import com.shopee.sdk.b;
import com.shopee.sdk.modules.app.e.a;

public class i {
    public static void a(String str) {
        if (!d.a(str)) {
            a a2 = b.a().d().a();
            Context c2 = com.shopee.feeds.feedlibrary.b.b().c();
            SharedPreferences sharedPreferences = c2.getSharedPreferences(String.valueOf(a2.a()) + "twitter", 0);
            sharedPreferences.edit().putString("instagram_token", str).commit();
            sharedPreferences.edit().putString(BPOrderInfo.FIELD_CREATE_TIME, String.valueOf(System.currentTimeMillis())).commit();
        }
    }

    public static String a() {
        a a2 = b.a().d().a();
        Context c2 = com.shopee.feeds.feedlibrary.b.b().c();
        return c2.getSharedPreferences(String.valueOf(a2.a()) + "twitter", 0).getString("instagram_token", "");
    }

    public static void b() {
        a a2 = b.a().d().a();
        Context c2 = com.shopee.feeds.feedlibrary.b.b().c();
        c2.getSharedPreferences(String.valueOf(a2.a()) + "twitter", 0).edit().clear().commit();
    }
}
