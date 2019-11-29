package com.shopee.livequiz.d.c;

import com.shopee.livequiz.c.c;
import com.shopee.livequiz.c.d;
import com.shopee.livequiz.c.e;

public class b extends com.shopee.livequiz.c.a<a, d<com.shopee.livequiz.d.a.a.a>> {

    /* renamed from: c  reason: collision with root package name */
    private com.shopee.livequiz.d.b.b f29750c;

    public b(c cVar, com.shopee.livequiz.d.b.b bVar) {
        super(cVar);
        this.f29750c = bVar;
    }

    /* access modifiers changed from: protected */
    public void a(a aVar, final d<com.shopee.livequiz.d.a.a.a> dVar) {
        final com.shopee.livequiz.d.a.c<com.shopee.livequiz.d.a.a<com.shopee.livequiz.d.a.a.a>> a2 = com.shopee.livequiz.d.b.a(this.f29750c.a(aVar.f29758a, aVar.f29759b));
        if (dVar != null) {
            if (a2.a()) {
                a(new e() {
                    public void a() {
                        dVar.a(a2.f29728a, a2.f29729b);
                    }
                });
            } else {
                a(new e() {
                    public void a() {
                        dVar.a(a2.f29730c);
                    }
                });
            }
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f29758a;

        /* renamed from: b  reason: collision with root package name */
        int f29759b;

        public a(int i, int i2) {
            this.f29758a = i;
            this.f29759b = i2;
        }
    }
}
