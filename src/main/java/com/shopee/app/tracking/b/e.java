package com.shopee.app.tracking.b;

import com.shopee.a.b.a;
import java.net.URL;

public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private final String f19156a;

    public boolean c() {
        return false;
    }

    public e(String str) {
        this.f19156a = str;
    }

    public String a() {
        return this.f19156a;
    }

    public String b() {
        try {
            return new URL(this.f19156a).getQuery();
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return "";
        }
    }
}
