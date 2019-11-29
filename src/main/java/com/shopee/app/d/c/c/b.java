package com.shopee.app.d.c.c;

import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class b implements b.a.b<a> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16658a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ChatBadgeStore> f16659b;

    /* renamed from: a */
    public a get() {
        return new a(this.f16658a.get(), this.f16659b.get());
    }

    public static a a(n nVar, ChatBadgeStore chatBadgeStore) {
        return new a(nVar, chatBadgeStore);
    }
}
