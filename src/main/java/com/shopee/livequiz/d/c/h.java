package com.shopee.livequiz.d.c;

import com.shopee.livequiz.c.c;
import com.shopee.livequiz.c.d;
import com.shopee.livequiz.d.a.a.e;
import com.shopee.livequiz.d.b.b;

public class h extends com.shopee.livequiz.c.a<a, d<e>> {

    /* renamed from: c  reason: collision with root package name */
    private b f29808c;

    public h(c cVar, b bVar) {
        super(cVar);
        this.f29808c = bVar;
    }

    /* access modifiers changed from: protected */
    public void a(a aVar, final d<e> dVar) {
        final com.shopee.livequiz.d.a.c<com.shopee.livequiz.d.a.d<e>> b2 = com.shopee.livequiz.d.b.b(this.f29808c.a(aVar.f29815a));
        if (dVar != null) {
            if (b2.a()) {
                a(new com.shopee.livequiz.c.e() {
                    public void a() {
                        dVar.a(b2.f29728a, b2.f29729b);
                    }
                });
            } else {
                a(new com.shopee.livequiz.c.e() {
                    public void a() {
                        dVar.a(b2.f29730c);
                    }
                });
            }
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        com.shopee.livequiz.d.a.b.b f29815a;

        public a(com.shopee.livequiz.d.a.b.b bVar) {
            this.f29815a = bVar;
        }
    }
}
