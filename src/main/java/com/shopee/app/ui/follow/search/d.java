package com.shopee.app.ui.follow.search;

import com.shopee.app.d.c.a;
import com.shopee.app.h.o;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.i.b;
import com.shopee.app.util.n;

public class d extends a {

    /* renamed from: c  reason: collision with root package name */
    private String f21780c;

    /* renamed from: d  reason: collision with root package name */
    private int f21781d;

    /* renamed from: e  reason: collision with root package name */
    private int f21782e;

    /* renamed from: f  reason: collision with root package name */
    private int f21783f;

    /* renamed from: g  reason: collision with root package name */
    private int f21784g;
    private String h;

    /* access modifiers changed from: protected */
    public String d() {
        return "SearchHintInteractor";
    }

    public d(n nVar) {
        super(nVar);
    }

    /* access modifiers changed from: protected */
    public void c() {
        b bVar = new b();
        o.a().a((az) bVar);
        bVar.a(this.f21780c, this.f21782e, this.f21781d, this.f21783f, this.f21784g, this.h);
    }

    public void a(String str, int i, int i2, int i3, int i4, String str2) {
        this.f21780c = str;
        this.f21781d = i;
        this.f21782e = i2;
        this.f21783f = i3;
        this.f21784g = i4;
        this.h = str2;
        a();
    }
}
