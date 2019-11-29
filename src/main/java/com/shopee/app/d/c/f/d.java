package com.shopee.app.d.c.f;

import b.a.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.av;
import com.shopee.app.data.store.bg;
import com.shopee.app.data.store.c.c;
import com.shopee.app.data.store.p;
import com.shopee.app.data.store.x;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class d implements b<c> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16954a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<bg> f16955b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<p> f16956c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ChatBadgeStore> f16957d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<ah> f16958e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<c> f16959f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<x> f16960g;
    private final Provider<av> h;
    private final Provider<UserInfo> i;

    /* renamed from: a */
    public c get() {
        return new c(this.f16954a.get(), this.f16955b.get(), this.f16956c.get(), this.f16957d.get(), this.f16958e.get(), this.f16959f.get(), this.f16960g.get(), this.h.get(), this.i.get());
    }

    public static c a(n nVar, bg bgVar, p pVar, ChatBadgeStore chatBadgeStore, ah ahVar, c cVar, x xVar, av avVar, UserInfo userInfo) {
        return new c(nVar, bgVar, pVar, chatBadgeStore, ahVar, cVar, xVar, avVar, userInfo);
    }
}
