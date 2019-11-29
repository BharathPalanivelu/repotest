package com.shopee.app.d.c;

import com.shopee.app.instagram.e;
import com.shopee.app.util.n;

public class cc extends a {

    /* renamed from: c  reason: collision with root package name */
    private final n f16668c;

    /* renamed from: d  reason: collision with root package name */
    private final e f16669d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f16670e;

    /* access modifiers changed from: protected */
    public String d() {
        return "LoadInstagramImageInteractor";
    }

    protected cc(n nVar, e eVar) {
        super(nVar);
        this.f16668c = nVar;
        this.f16669d = eVar;
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (this.f16670e) {
            this.f16669d.c();
        }
        this.f16668c.a().cP.a(this.f16669d.d()).a();
    }

    public void e() {
        this.f16670e = false;
        a();
    }

    public void f() {
        this.f16670e = true;
        a();
    }
}
