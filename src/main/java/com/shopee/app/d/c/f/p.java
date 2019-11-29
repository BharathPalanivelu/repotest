package com.shopee.app.d.c.f;

import b.a.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.av;
import com.shopee.app.data.store.bg;
import com.shopee.app.data.store.c.c;
import com.shopee.app.data.store.x;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class p implements b<o> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f17011a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<bg> f17012b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.shopee.app.data.store.p> f17013c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<UserInfo> f17014d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<ChatBadgeStore> f17015e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<ah> f17016f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<c> f17017g;
    private final Provider<x> h;
    private final Provider<av> i;

    /* renamed from: a */
    public o get() {
        return new o(this.f17011a.get(), this.f17012b.get(), this.f17013c.get(), this.f17014d.get(), this.f17015e.get(), this.f17016f.get(), this.f17017g.get(), this.h.get(), this.i.get());
    }

    public static o a(n nVar, bg bgVar, com.shopee.app.data.store.p pVar, UserInfo userInfo, ChatBadgeStore chatBadgeStore, ah ahVar, c cVar, x xVar, av avVar) {
        return new o(nVar, bgVar, pVar, userInfo, chatBadgeStore, ahVar, cVar, xVar, avVar);
    }
}
