package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.bg;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.store.c.c;
import com.shopee.app.data.store.w;
import com.shopee.app.data.store.x;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class m implements b<l> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f17093a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<bh> f17094b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<bg> f17095c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<x> f17096d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<w> f17097e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<ao> f17098f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<ah> f17099g;
    private final Provider<c> h;

    /* renamed from: a */
    public l get() {
        return new l(this.f17093a.get(), this.f17094b.get(), this.f17095c.get(), this.f17096d.get(), this.f17097e.get(), this.f17098f.get(), this.f17099g.get(), this.h.get());
    }

    public static l a(n nVar, bh bhVar, bg bgVar, x xVar, w wVar, ao aoVar, ah ahVar, c cVar) {
        return new l(nVar, bhVar, bgVar, xVar, wVar, aoVar, ahVar, cVar);
    }
}
