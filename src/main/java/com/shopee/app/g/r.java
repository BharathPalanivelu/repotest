package com.shopee.app.g;

import com.h.a.a;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.ak;
import com.shopee.app.h.m;
import com.shopee.protocol.action.ResponseCommon;

public class r {
    public static boolean a(int i) {
        return (i == 3 || i == 0) ? false : true;
    }

    public static void a(ResponseCommon responseCommon, int i) {
        ak akVar = new ak(ar.a().getSharedPreferences("login", 0));
        b.a(responseCommon, akVar, i);
        boolean z = true;
        akVar.m().a(Boolean.valueOf(b.a(Boolean.valueOf(i == 0)))).v();
        a<ak> n = akVar.n();
        if (i != 3) {
            z = false;
        }
        n.a(Boolean.valueOf(b.a(Boolean.valueOf(z)))).v();
        m.c();
    }

    public static void a(ResponseCommon responseCommon) {
        b.a(responseCommon, new ak(ar.a().getSharedPreferences("login", 0)));
        m.c();
    }

    public static void b(ResponseCommon responseCommon) {
        b.b(responseCommon, new ak(ar.a().getSharedPreferences("login", 0)));
        m.c();
    }

    public static void c(ResponseCommon responseCommon) {
        b.c(responseCommon, new ak(ar.a().getSharedPreferences("login", 0)));
        m.c();
    }

    public static void d(ResponseCommon responseCommon) {
        b.d(responseCommon, new ak(ar.a().getSharedPreferences("login", 0)));
        m.c();
    }
}
