package com.shopee.livequiz.d.c;

import com.shopee.livequiz.c.c;
import com.shopee.livequiz.c.d;
import com.shopee.livequiz.c.e;
import com.shopee.livequiz.d.b.b;

public class g extends com.shopee.livequiz.c.a<a, d<com.shopee.livequiz.d.a.a.d>> {

    /* renamed from: c  reason: collision with root package name */
    private b f29800c;

    public g(c cVar, b bVar) {
        super(cVar);
        this.f29800c = bVar;
    }

    /* access modifiers changed from: protected */
    public void a(a aVar, final d<com.shopee.livequiz.d.a.a.d> dVar) {
        final com.shopee.livequiz.d.a.c<com.shopee.livequiz.d.a.d<com.shopee.livequiz.d.a.a.d>> b2 = com.shopee.livequiz.d.b.b(this.f29800c.a(aVar.f29807a));
        if (dVar != null) {
            if (b2.a()) {
                a(new e() {
                    public void a() {
                        dVar.a(b2.f29728a, b2.f29729b);
                    }
                });
            } else {
                a(new e() {
                    public void a() {
                        dVar.a(b2.f29730c);
                    }
                });
            }
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        String f29807a;

        public a(String str) {
            this.f29807a = str;
        }
    }
}
