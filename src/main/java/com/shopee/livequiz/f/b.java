package com.shopee.livequiz.f;

import com.shopee.livequiz.c.c;
import com.shopee.livequiz.c.e;
import com.shopee.livequiz.data.bean.GameModel;

public class b extends com.shopee.livequiz.c.a<C0458b, a> {

    public interface a {
        void a();
    }

    public b(c cVar) {
        super(cVar);
    }

    /* access modifiers changed from: protected */
    public void a(C0458b bVar, final a aVar) {
        com.shopee.livequiz.b.a().a().a(bVar.f29834a);
        a(new e() {
            public void a() {
                a aVar = aVar;
                if (aVar != null) {
                    aVar.a();
                }
            }
        });
    }

    /* renamed from: com.shopee.livequiz.f.b$b  reason: collision with other inner class name */
    public static class C0458b {

        /* renamed from: a  reason: collision with root package name */
        GameModel f29834a;

        public C0458b(GameModel gameModel) {
            this.f29834a = gameModel;
        }
    }
}
