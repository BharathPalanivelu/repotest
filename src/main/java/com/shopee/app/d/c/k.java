package com.shopee.app.d.c;

import b.a.b;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.av;
import com.shopee.app.data.store.p;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class k implements b<j> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f17084a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<p> f17085b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<av> f17086c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ChatBadgeStore> f17087d;

    /* renamed from: a */
    public j get() {
        return new j(this.f17084a.get(), this.f17085b.get(), this.f17086c.get(), this.f17087d.get());
    }

    public static j a(n nVar, p pVar, av avVar, ChatBadgeStore chatBadgeStore) {
        return new j(nVar, pVar, avVar, chatBadgeStore);
    }
}
