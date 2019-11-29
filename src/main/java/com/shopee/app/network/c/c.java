package com.shopee.app.network.c;

import com.beetalklib.network.a.c.a;
import com.beetalklib.network.a.c.b;
import com.shopee.app.h.o;
import com.shopee.app.network.d.az;
import java.io.IOException;
import java.util.Locale;

public abstract class c implements a, b {

    /* renamed from: a  reason: collision with root package name */
    private final com.shopee.app.util.n.c f17875a = new com.shopee.app.util.n.c(String.format(Locale.ENGLISH, "CMD:%03d | ", new Object[]{Integer.valueOf(a())}).concat(getClass().getSimpleName()));

    public void a(String str) {
    }

    public void c(byte[] bArr, int i) throws IOException {
    }

    @Deprecated
    public void a(byte[] bArr, int i) {
        this.f17875a.a();
        try {
            this.f17875a.b();
            c(bArr, i);
            this.f17875a.c();
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            this.f17875a.a(e2);
        }
    }

    public void b(byte[] bArr, int i) {
        try {
            a(new String(bArr));
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public final az b(String str) {
        return o.a().f(str);
    }

    public void c(String str) {
        com.beetalklib.network.a.c.c.a().a(str);
    }

    public int b() {
        return a();
    }
}
