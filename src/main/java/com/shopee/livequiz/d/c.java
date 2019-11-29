package com.shopee.livequiz.d;

import com.shopee.livequiz.c.e;
import com.shopee.livequiz.d.c.f;

public class c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public f f29733a = com.shopee.livequiz.d.b.a.g();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public b f29734b;

    public interface a {
        void a();

        void b();
    }

    private class b extends e {

        /* renamed from: a  reason: collision with root package name */
        int f29743a;

        /* renamed from: b  reason: collision with root package name */
        int f29744b;

        /* renamed from: c  reason: collision with root package name */
        int f29745c;

        /* renamed from: d  reason: collision with root package name */
        boolean f29746d;

        /* renamed from: e  reason: collision with root package name */
        int f29747e = 3;

        /* renamed from: f  reason: collision with root package name */
        a f29748f;

        b(int i, int i2, int i3, boolean z) {
            this.f29743a = i;
            this.f29744b = i2;
            this.f29745c = i3;
            this.f29746d = z;
        }

        /* access modifiers changed from: package-private */
        public void a(int i) {
            this.f29747e = i;
        }

        /* access modifiers changed from: package-private */
        public void a(a aVar) {
            this.f29748f = aVar;
        }

        public void a() {
            synchronized (b.class) {
                c.this.f29733a.b(new f.b(com.shopee.livequiz.data.b.a().b().eventId, com.shopee.livequiz.data.b.a().b().sessionId, this.f29743a, new com.shopee.livequiz.d.a.b.a(this.f29745c, this.f29746d)), new f.a() {
                    public void a(int i, int i2) {
                        synchronized (b.class) {
                            b.this.f29747e = 0;
                            if (b.this.f29748f != null) {
                                b.this.f29748f.a();
                                com.shopee.livequiz.c.f.a((e) c.this.f29734b, "loop_thread");
                                com.shopee.livequiz.b.e.b(b.this.f29744b);
                            }
                        }
                    }

                    public void a(int i, String str) {
                        synchronized (b.class) {
                            b bVar = b.this;
                            bVar.f29747e--;
                            if (b.this.f29747e == 0 && b.this.f29748f != null) {
                                b.this.f29748f.b();
                            }
                            if (i < 100 || i >= 200) {
                                com.shopee.livequiz.b.e.g(b.this.f29744b, i);
                            } else {
                                com.shopee.livequiz.b.e.h(b.this.f29744b, i);
                            }
                        }
                    }
                });
            }
        }
    }

    public c(int i, int i2, int i3, boolean z) {
        this.f29734b = new b(i, i2, i3, z);
    }

    public void a(a aVar) {
        int i = com.shopee.livequiz.data.b.a().b().answerPostRetryTimes > 0 ? com.shopee.livequiz.data.b.a().b().answerPostRetryTimes : 3;
        this.f29734b.a(i);
        this.f29734b.a(aVar);
        int i2 = com.shopee.livequiz.data.b.a().b().answerPostTimeInterval > 0 ? com.shopee.livequiz.data.b.a().b().answerPostTimeInterval : 2;
        for (int i3 = 0; i3 < i; i3++) {
            com.shopee.livequiz.c.f.a(this.f29734b, (long) (i3 * i2 * 1000), "loop_thread");
        }
    }
}
