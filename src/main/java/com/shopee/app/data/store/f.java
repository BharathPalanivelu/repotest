package com.shopee.app.data.store;

import android.content.Context;
import android.content.SharedPreferences;
import com.h.a.a;
import com.h.a.c;
import com.shopee.app.application.ar;

public class f extends c<f> {

    /* renamed from: a  reason: collision with root package name */
    private static f f17301a;

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (f17301a == null) {
                Context a2 = ar.a();
                f17301a = new f(a2.getSharedPreferences(ak.a().d().b(-1) + "addproduct", 0));
            }
            fVar = f17301a;
        }
        return fVar;
    }

    public f(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
    }

    public a<f> b() {
        return c("share_to_fb");
    }

    public a<f> c() {
        return c("share_to_twitter");
    }
}
