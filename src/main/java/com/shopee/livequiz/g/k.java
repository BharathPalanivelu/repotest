package com.shopee.livequiz.g;

import com.shopee.livequiz.c.e;
import com.shopee.livequiz.c.f;
import java.util.Random;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private e f29869a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f29870b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public long f29871c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public long f29872d = 0;

    public interface a {
        void a();
    }

    public k(a aVar, long j) {
        this.f29871c = j;
        this.f29870b = aVar;
        this.f29869a = new e() {
            public void a() {
                if (k.this.f29870b != null) {
                    k.this.f29870b.a();
                    f.a(this, k.this.f29871c, "loop_thread");
                }
            }
        };
    }

    public k(a aVar, long j, long j2) {
        this.f29871c = j;
        this.f29872d = j2;
        this.f29870b = aVar;
        this.f29869a = new e() {
            public void a() {
                if (k.this.f29870b != null) {
                    k.this.f29870b.a();
                    if (k.this.f29872d != 0) {
                        f.a(this, k.this.f29872d, "loop_thread");
                        long unused = k.this.f29872d = 0;
                        return;
                    }
                    f.a(this, k.this.f29871c, "loop_thread");
                }
            }
        };
    }

    public void a() {
        f.a(this.f29869a, (long) (new Random().nextInt(4) * 1000), "loop_thread");
    }

    public void b() {
        f.a(this.f29869a, this.f29871c, "loop_thread");
    }

    public void c() {
        f.a(this.f29869a, "loop_thread");
    }

    public void d() {
        f.a(this.f29869a, "loop_thread");
        this.f29870b = null;
    }
}
