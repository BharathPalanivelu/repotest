package com.shopee.app.network;

import com.beetalklib.network.a.b.b;
import com.garena.android.appkit.d.a;

public class h implements b {

    /* renamed from: a  reason: collision with root package name */
    private final int f18489a = 50;

    /* renamed from: b  reason: collision with root package name */
    private final int f18490b = 2;

    /* renamed from: c  reason: collision with root package name */
    private final int f18491c = 15000;

    public int a() {
        return 50;
    }

    public int b() {
        return 2;
    }

    public int a(int i) {
        if (!a.a()) {
            return 6000;
        }
        if (i > 2) {
            i = 2;
        }
        int i2 = (i * i * i * 300) + 1000;
        int i3 = 15000;
        if (i2 <= 15000) {
            i3 = i2;
        }
        a.a("connection-tcp-retry: " + i3, new Object[0]);
        return i3;
    }
}
