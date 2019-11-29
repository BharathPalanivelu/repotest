package com.shopee.app.d.c.c;

import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.util.n;

public class a extends com.shopee.app.d.c.a.a<C0254a> {

    /* renamed from: d  reason: collision with root package name */
    private final ChatBadgeStore f16657d;

    protected a(n nVar, ChatBadgeStore chatBadgeStore) {
        super(nVar);
        this.f16657d = chatBadgeStore;
    }

    public void a() {
        super.b(new C0254a());
    }

    /* access modifiers changed from: protected */
    public void a(C0254a aVar) {
        this.f16405a.a().bG.a(Integer.valueOf(this.f16657d.getTotalCount())).a();
    }

    /* renamed from: com.shopee.app.d.c.c.a$a  reason: collision with other inner class name */
    public static class C0254a extends a.C0253a {
        public C0254a() {
            super("GetChatBadgeCountInteractor", "use_case99", 1000, true);
        }
    }
}
