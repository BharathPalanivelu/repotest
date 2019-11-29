package com.shopee.app.d.c.f;

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

public final class b implements b.a.b<a> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16941a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<bg> f16942b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<p> f16943c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ChatBadgeStore> f16944d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<ah> f16945e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<c> f16946f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<x> f16947g;
    private final Provider<av> h;
    private final Provider<UserInfo> i;

    /* renamed from: a */
    public a get() {
        return new a(this.f16941a.get(), this.f16942b.get(), this.f16943c.get(), this.f16944d.get(), this.f16945e.get(), this.f16946f.get(), this.f16947g.get(), this.h.get(), this.i.get());
    }

    public static a a(n nVar, bg bgVar, p pVar, ChatBadgeStore chatBadgeStore, ah ahVar, c cVar, x xVar, av avVar, UserInfo userInfo) {
        return new a(nVar, bgVar, pVar, chatBadgeStore, ahVar, cVar, xVar, avVar, userInfo);
    }
}
