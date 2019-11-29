package com.shopee.app.d.c;

import com.shopee.app.util.n;
import com.shopee.app.util.n.b;

public abstract class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    protected n f16402a;

    /* renamed from: b  reason: collision with root package name */
    protected b f16403b = new b(d());

    /* access modifiers changed from: protected */
    public String b() {
        return "use_case";
    }

    /* access modifiers changed from: protected */
    public abstract void c();

    /* access modifiers changed from: protected */
    public abstract String d();

    protected a(n nVar) {
        this.f16402a = nVar;
    }

    public void a() {
        org.a.a.a.a(this, d(), b());
    }

    public void run() {
        this.f16403b.a();
        try {
            this.f16403b.b();
            c();
            this.f16403b.c();
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            this.f16403b.a(e2);
        }
    }
}
