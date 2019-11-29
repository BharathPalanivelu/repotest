package com.shopee.app.d.c;

import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.av;
import com.shopee.app.data.store.p;
import com.shopee.app.database.orm.bean.chatP2P.DBChat;
import com.shopee.app.network.d.bg;
import com.shopee.app.util.n;

public class j extends com.shopee.app.d.c.a.a<a> {

    /* renamed from: d  reason: collision with root package name */
    private final ChatBadgeStore f17056d;

    /* renamed from: e  reason: collision with root package name */
    private final p f17057e;

    /* renamed from: f  reason: collision with root package name */
    private final av f17058f;

    protected j(n nVar, p pVar, av avVar, ChatBadgeStore chatBadgeStore) {
        super(nVar);
        this.f17056d = chatBadgeStore;
        this.f17057e = pVar;
        this.f17058f = avVar;
    }

    public void a(int i) {
        b(new a(i));
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        DBChat a2 = this.f17058f.a(aVar.f17059a);
        if (a2 != null) {
            this.f17056d.setLocalSeen(aVar.f17059a, a2.h());
            new bg().a(aVar.f17059a, a2.h());
        }
        this.f16405a.a().bH.a(Integer.valueOf(this.f17056d.getTotalCount())).a();
    }

    public static class a extends a.C0253a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f17059a;

        public a(int i) {
            super("ClearUnreadCountInteractor", "use_case5", 0, false);
            this.f17059a = i;
        }
    }
}
