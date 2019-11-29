package com.shopee.app.h;

import com.garena.android.appkit.d.a;
import java.util.ArrayList;
import java.util.List;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static e f17648a;

    /* renamed from: b  reason: collision with root package name */
    private List<c> f17649b = new ArrayList();

    public static e a() {
        if (f17648a == null) {
            f17648a = new e();
        }
        return f17648a;
    }

    private e() {
    }

    public void b() {
        a.e("onLowMemory called", new Object[0]);
        for (c a2 : this.f17649b) {
            a2.a();
        }
    }
}
