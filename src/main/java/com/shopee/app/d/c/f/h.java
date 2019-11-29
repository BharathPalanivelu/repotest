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

public final class h implements b<g> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16981a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<bg> f16982b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<p> f16983c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ChatBadgeStore> f16984d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<ah> f16985e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<c> f16986f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<x> f16987g;
    private final Provider<av> h;
    private final Provider<UserInfo> i;

    /* renamed from: a */
    public g get() {
        return new g(this.f16981a.get(), this.f16982b.get(), this.f16983c.get(), this.f16984d.get(), this.f16985e.get(), this.f16986f.get(), this.f16987g.get(), this.h.get(), this.i.get());
    }

    public static g a(n nVar, bg bgVar, p pVar, ChatBadgeStore chatBadgeStore, ah ahVar, c cVar, x xVar, av avVar, UserInfo userInfo) {
        return new g(nVar, bgVar, pVar, chatBadgeStore, ahVar, cVar, xVar, avVar, userInfo);
    }
}
