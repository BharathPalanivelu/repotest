package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.av;
import com.shopee.app.data.store.p;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class cf implements b<ce> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16677a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<p> f16678b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<av> f16679c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ChatBadgeStore> f16680d;

    /* renamed from: a */
    public ce get() {
        return new ce(this.f16677a.get(), this.f16678b.get(), this.f16679c.get(), this.f16680d.get());
    }

    public static ce a(n nVar, p pVar, av avVar, ChatBadgeStore chatBadgeStore) {
        return new ce(nVar, pVar, avVar, chatBadgeStore);
    }
}
