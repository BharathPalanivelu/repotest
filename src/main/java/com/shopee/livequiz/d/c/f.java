package com.shopee.livequiz.d.c;

import com.shopee.livequiz.c.c;
import com.shopee.livequiz.c.e;

public class f extends com.shopee.livequiz.c.a<b, a> {

    /* renamed from: c  reason: collision with root package name */
    private com.shopee.livequiz.d.b.b f29789c;

    public interface a {
        void a(int i, int i2);

        void a(int i, String str);
    }

    public f(c cVar, com.shopee.livequiz.d.b.b bVar) {
        super(cVar);
        this.f29789c = bVar;
    }

    /* access modifiers changed from: protected */
    public void a(final b bVar, final a aVar) {
        final com.shopee.livequiz.d.a.c<com.shopee.livequiz.d.a.a<Object>> a2 = com.shopee.livequiz.d.b.a(this.f29789c.a(bVar.f29796a, bVar.f29797b, bVar.f29798c, bVar.f29799d));
        if (aVar != null) {
            if (a2.f29728a == 0 || a2.f29728a == 103) {
                a(new e() {
                    public void a() {
                        aVar.a(bVar.f29798c, bVar.f29799d.answer_id);
                    }
                });
            } else {
                a(new e() {
                    public void a() {
                        aVar.a(a2.f29728a, a2.f29729b);
                    }
                });
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        int f29796a;

        /* renamed from: b  reason: collision with root package name */
        int f29797b;

        /* renamed from: c  reason: collision with root package name */
        int f29798c;

        /* renamed from: d  reason: collision with root package name */
        com.shopee.livequiz.d.a.b.a f29799d;

        public b(int i, int i2, int i3, com.shopee.livequiz.d.a.b.a aVar) {
            this.f29796a = i;
            this.f29797b = i2;
            this.f29798c = i3;
            this.f29799d = aVar;
        }
    }
}
