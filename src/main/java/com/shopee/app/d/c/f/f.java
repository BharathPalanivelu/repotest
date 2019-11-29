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

public final class f implements b<e> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16967a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<bg> f16968b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<p> f16969c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ChatBadgeStore> f16970d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<ah> f16971e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<c> f16972f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<x> f16973g;
    private final Provider<av> h;
    private final Provider<UserInfo> i;

    /* renamed from: a */
    public e get() {
        return new e(this.f16967a.get(), this.f16968b.get(), this.f16969c.get(), this.f16970d.get(), this.f16971e.get(), this.f16972f.get(), this.f16973g.get(), this.h.get(), this.i.get());
    }

    public static e a(n nVar, bg bgVar, p pVar, ChatBadgeStore chatBadgeStore, ah ahVar, c cVar, x xVar, av avVar, UserInfo userInfo) {
        return new e(nVar, bgVar, pVar, chatBadgeStore, ahVar, cVar, xVar, avVar, userInfo);
    }
}
