package com.shopee.livequiz.d.c;

import com.shopee.livequiz.c.d;
import com.shopee.livequiz.c.e;
import com.shopee.livequiz.d.a.a.b;

public class c extends com.shopee.livequiz.c.a<a, d<b>> {

    /* renamed from: c  reason: collision with root package name */
    private com.shopee.livequiz.d.b.b f29760c;

    public c(com.shopee.livequiz.c.c cVar, com.shopee.livequiz.d.b.b bVar) {
        super(cVar);
        this.f29760c = bVar;
    }

    /* access modifiers changed from: protected */
    public void a(a aVar, final d<b> dVar) {
        final com.shopee.livequiz.d.a.c<com.shopee.livequiz.d.a.a<b>> a2 = com.shopee.livequiz.d.b.a(this.f29760c.b(aVar.f29767a, aVar.f29768b));
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
        int f29767a;

        /* renamed from: b  reason: collision with root package name */
        int f29768b;

        public a(int i, int i2) {
            this.f29767a = i;
            this.f29768b = i2;
        }
    }
}
