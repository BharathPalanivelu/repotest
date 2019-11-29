package com.shopee.app.ui.setting.account;

import com.shopee.app.instagram.e;
import com.shopee.app.util.n;

public class a extends com.shopee.app.d.c.a {

    /* renamed from: c  reason: collision with root package name */
    private final n f25155c;

    /* renamed from: d  reason: collision with root package name */
    private e f25156d;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetInstagramInfoInteractor";
    }

    public a(n nVar) {
        super(nVar);
        this.f25155c = nVar;
    }

    public void a(e eVar) {
        this.f25156d = eVar;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        this.f25155c.a("INSTAGRAM_NAME", new com.garena.android.appkit.b.a(this.f25156d.h()));
    }
}
