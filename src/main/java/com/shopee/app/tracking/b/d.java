package com.shopee.app.tracking.b;

import com.shopee.a.b.a;
import java.net.URL;

public class d implements a {

    /* renamed from: a  reason: collision with root package name */
    private final String f19155a;

    public boolean c() {
        return false;
    }

    public d(String str) {
        this.f19155a = str;
    }

    public String a() {
        return this.f19155a;
    }

    public String b() {
        try {
            return new URL(this.f19155a).getQuery();
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return "";
        }
    }
}
