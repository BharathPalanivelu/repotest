package com.shopee.livequiz.d.c;

import com.shopee.livequiz.c.c;
import com.shopee.livequiz.c.d;
import com.shopee.livequiz.d.b.b;

public class e extends com.shopee.livequiz.c.a<a, d<String>> {

    /* renamed from: c  reason: collision with root package name */
    private b f29781c;

    public e(c cVar, b bVar) {
        super(cVar);
        this.f29781c = bVar;
    }

    /* access modifiers changed from: protected */
    public void a(a aVar, final d<String> dVar) {
        final com.shopee.livequiz.d.a.c<com.shopee.livequiz.d.a.a<com.shopee.livequiz.d.a.a.c>> a2 = com.shopee.livequiz.d.b.a(this.f29781c.a(aVar.f29788a));
        if (a2.a()) {
            a(new com.shopee.livequiz.c.e() {
                public void a() {
                    d dVar = dVar;
                    if (dVar != null) {
                        dVar.a(a2.f29728a, a2.f29729b);
                    }
                }
            });
        } else {
            a(new com.shopee.livequiz.c.e() {
                public void a() {
                    d dVar = dVar;
                    if (dVar != null) {
                        dVar.a(((com.shopee.livequiz.d.a.a.c) a2.f29730c).f29722a);
                    }
                }
            });
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f29788a;

        public a(int i) {
            this.f29788a = i;
        }
    }
}
