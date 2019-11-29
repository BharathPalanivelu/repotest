package com.airpay.paysdk.base.b;

import com.airpay.paysdk.b;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private volatile b f3793a;

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final d f3794a = new d();
    }

    public static d a() {
        return a.f3794a;
    }

    private d() {
    }

    public String b() {
        if (this.f3793a == null) {
            return null;
        }
        return this.f3793a.a();
    }

    public void a(b bVar) {
        this.f3793a = bVar;
    }

    public void c() {
        this.f3793a = null;
    }
}
