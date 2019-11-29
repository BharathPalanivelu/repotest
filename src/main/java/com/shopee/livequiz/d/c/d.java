package com.shopee.livequiz.d.c;

import com.shopee.livequiz.c.c;
import com.shopee.livequiz.c.e;
import com.shopee.livequiz.c.f;

public class d extends com.shopee.livequiz.c.a<b, com.shopee.livequiz.c.d<String>> {

    /* renamed from: c  reason: collision with root package name */
    private com.shopee.livequiz.d.b.b f29769c;

    /* renamed from: d  reason: collision with root package name */
    private long f29770d = 10000;

    public d(c cVar, com.shopee.livequiz.d.b.b bVar) {
        super(cVar);
        this.f29769c = bVar;
    }

    public void a(long j) {
        if (j > 0) {
            this.f29770d = j;
        }
    }

    /* access modifiers changed from: protected */
    public void a(b bVar, final com.shopee.livequiz.c.d<String> dVar) {
        a aVar = new a(this.f29769c.c(bVar.f29779a, bVar.f29780b));
        f.a(aVar, this.f29770d, "loop_thread");
        long currentTimeMillis = System.currentTimeMillis();
        final com.shopee.livequiz.d.a.c<com.shopee.livequiz.d.a.b<String>> c2 = com.shopee.livequiz.d.b.c(aVar.f29777a);
        if (System.currentTimeMillis() - currentTimeMillis < this.f29770d) {
            f.a((e) aVar, "loop_thread");
        }
        if (dVar != null) {
            if (c2.a()) {
                a(new e() {
                    public void a() {
                        dVar.a(c2.f29728a, c2.f29729b);
                    }
                });
            } else {
                a(new e() {
                    public void a() {
                        dVar.a(c2.f29730c);
                    }
                });
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        int f29779a;

        /* renamed from: b  reason: collision with root package name */
        int f29780b;

        public b(int i, int i2) {
            this.f29779a = i;
            this.f29780b = i2;
        }
    }

    private class a extends e {

        /* renamed from: a  reason: collision with root package name */
        f.b<com.shopee.livequiz.d.a.b<String>> f29777a;

        public a(f.b<com.shopee.livequiz.d.a.b<String>> bVar) {
            this.f29777a = bVar;
        }

        public void a() throws Exception {
            f.b<com.shopee.livequiz.d.a.b<String>> bVar = this.f29777a;
            if (bVar != null && !bVar.c()) {
                this.f29777a.b();
            }
        }
    }
}
