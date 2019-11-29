package com.shopee.app.network.c.i;

import b.a.b;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.network.c.i.b;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class c implements b<b.a> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f17961a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.shopee.app.data.store.b> f17962b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ActionRequiredCounter> f17963c;

    /* renamed from: a */
    public b.a get() {
        return new b.a(this.f17961a.get(), this.f17962b.get(), this.f17963c.get());
    }

    public static b.a a(n nVar, com.shopee.app.data.store.b bVar, ActionRequiredCounter actionRequiredCounter) {
        return new b.a(nVar, bVar, actionRequiredCounter);
    }
}
