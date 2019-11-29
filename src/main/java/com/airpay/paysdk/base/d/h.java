package com.airpay.paysdk.base.d;

import com.google.a.f;
import com.google.a.g;
import com.google.a.q;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private static volatile h f3803a;

    /* renamed from: b  reason: collision with root package name */
    private f f3804b = new g().d();

    /* renamed from: c  reason: collision with root package name */
    private q f3805c = new q();

    private h() {
    }

    public static h a() {
        if (f3803a == null) {
            synchronized (h.class) {
                if (f3803a == null) {
                    f3803a = new h();
                }
            }
        }
        return f3803a;
    }

    public f b() {
        return this.f3804b;
    }
}
