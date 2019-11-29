package com.shopee.app.ui.follow.search;

import com.shopee.app.d.c.a;
import com.shopee.app.h.o;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.i.c;
import com.shopee.app.network.d.i.d;
import com.shopee.app.util.n;

public class j extends a {

    /* renamed from: c  reason: collision with root package name */
    private String f21792c;

    /* renamed from: d  reason: collision with root package name */
    private int f21793d;

    /* renamed from: e  reason: collision with root package name */
    private int f21794e;

    /* renamed from: f  reason: collision with root package name */
    private int f21795f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f21796g;

    /* access modifiers changed from: protected */
    public String d() {
        return "SearchUserInteractor";
    }

    public j(n nVar) {
        super(nVar);
    }

    /* access modifiers changed from: protected */
    public void c() {
        int i = this.f21795f;
        if (i == 0) {
            d dVar = new d();
            o.a().a((az) dVar);
            dVar.a(this.f21792c, this.f21793d, this.f21794e, this.f21796g);
        } else if (i == 1) {
            c cVar = new c();
            o.a().a((az) cVar);
            cVar.a(this.f21792c, this.f21793d, this.f21794e, this.f21796g);
        }
    }

    public void a(String str, int i, int i2, int i3, boolean z) {
        this.f21792c = str;
        this.f21793d = i;
        this.f21794e = i2;
        this.f21795f = i3;
        this.f21796g = z;
        a();
    }

    public void a(String str, int i, int i2, int i3) {
        a(str, i, i2, i3, false);
    }
}
