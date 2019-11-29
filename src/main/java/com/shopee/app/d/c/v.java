package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.bb;
import com.shopee.app.data.store.c;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class v implements b<u> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f17128a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<c> f17129b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.shopee.app.data.store.b> f17130c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ActionRequiredCounter> f17131d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<bb> f17132e;

    /* renamed from: a */
    public u get() {
        return new u(this.f17128a.get(), this.f17129b.get(), this.f17130c.get(), this.f17131d.get(), this.f17132e.get());
    }

    public static u a(n nVar, c cVar, com.shopee.app.data.store.b bVar, ActionRequiredCounter actionRequiredCounter, bb bbVar) {
        return new u(nVar, cVar, bVar, actionRequiredCounter, bbVar);
    }
}
