package com.shopee.app.data.store;

import android.content.SharedPreferences;
import com.facebook.appevents.UserDataStore;
import com.h.a.a;
import com.h.a.b;
import com.h.a.c;
import com.h.a.d;
import com.shopee.app.application.ar;

public class ak extends c<ak> {

    /* renamed from: a  reason: collision with root package name */
    private static ak f6942a;

    public static synchronized ak a() {
        ak akVar;
        synchronized (ak.class) {
            if (f6942a == null) {
                f6942a = new ak(ar.a().getSharedPreferences("login", 0));
            }
            akVar = f6942a;
        }
        return akVar;
    }

    public ak(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
    }

    public d<ak> b() {
        return a(UserDataStore.COUNTRY);
    }

    public d<ak> c() {
        return a("token");
    }

    public b<ak> d() {
        return b("userId");
    }

    public d<ak> e() {
        return a("phone");
    }

    public d<ak> f() {
        return a("avatar");
    }

    public d<ak> g() {
        return a("username");
    }

    public d<ak> h() {
        return a("password");
    }

    public b<ak> i() {
        return b("shopId");
    }

    public d<ak> j() {
        return a("email");
    }

    public d<ak> k() {
        return a("fbId");
    }

    public d<ak> l() {
        return a("lineId");
    }

    public a<ak> m() {
        return c("fbLogin");
    }

    public a<ak> n() {
        return c("lineLogin");
    }

    public d<ak> o() {
        return a("fbToken");
    }

    public d<ak> p() {
        return a("vCodeToken");
    }

    public a<ak> q() {
        return c("isSeller");
    }

    public void r() {
        ((ak) u()).v();
    }

    public d<ak> s() {
        return a("spcTID");
    }

    public d<ak> t() {
        return a("spcTIV");
    }
}
