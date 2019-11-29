package com.shopee.app.d.c;

import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.av;
import com.shopee.app.data.store.p;
import com.shopee.app.network.d.bg;
import com.shopee.app.util.n;

public class ce extends com.shopee.app.d.c.a.a<a> {

    /* renamed from: d  reason: collision with root package name */
    private final ChatBadgeStore f16673d;

    /* renamed from: e  reason: collision with root package name */
    private final p f16674e;

    /* renamed from: f  reason: collision with root package name */
    private final av f16675f;

    protected ce(n nVar, p pVar, av avVar, ChatBadgeStore chatBadgeStore) {
        super(nVar);
        this.f16673d = chatBadgeStore;
        this.f16674e = pVar;
        this.f16675f = avVar;
    }

    public void a(int i) {
        b(new a(i));
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        this.f16673d.setChatUnreadLocal(aVar.f16676a);
        new bg().a(aVar.f16676a, -1);
        this.f16405a.a().bH.a(Integer.valueOf(this.f16673d.getTotalCount())).a();
    }

    public static class a extends a.C0253a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f16676a;

        public a(int i) {
            super("MarkAsUnreadCountData", "use_case5", 0, false);
            this.f16676a = i;
        }
    }
}
