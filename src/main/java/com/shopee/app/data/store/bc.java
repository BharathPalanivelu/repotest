package com.shopee.app.data.store;

import android.content.Context;
import android.content.SharedPreferences;
import com.h.a.a;
import com.h.a.c;
import com.h.a.d;
import com.shopee.app.application.ar;

public class bc extends c<bc> {

    /* renamed from: a  reason: collision with root package name */
    private static bc f17247a;

    public static synchronized bc a() {
        bc bcVar;
        synchronized (bc.class) {
            if (f17247a == null) {
                Context a2 = ar.a();
                f17247a = new bc(a2.getSharedPreferences(String.valueOf(ak.a().d().b(-1)) + "twitter", 0));
            }
            bcVar = f17247a;
        }
        return bcVar;
    }

    public bc(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
    }

    public d<bc> b() {
        return a("twitter_secret");
    }

    public d<bc> c() {
        return a("twitter_token");
    }

    public a<bc> d() {
        return c("is_twitter_authorized");
    }

    public d<bc> e() {
        return a("instagram_token");
    }
}
