package com.c.a.c.b;

import androidx.core.util.Pools;
import com.c.a.i.a.a;
import com.c.a.i.a.b;

final class r<Z> implements s<Z>, a.c {

    /* renamed from: a  reason: collision with root package name */
    private static final Pools.a<r<?>> f5863a = a.b(20, new a.C0112a<r<?>>() {
        /* renamed from: a */
        public r<?> b() {
            return new r<>();
        }
    });

    /* renamed from: b  reason: collision with root package name */
    private final b f5864b = b.a();

    /* renamed from: c  reason: collision with root package name */
    private s<Z> f5865c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5866d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5867e;

    static <Z> r<Z> a(s<Z> sVar) {
        r<Z> acquire = f5863a.acquire();
        acquire.b(sVar);
        return acquire;
    }

    r() {
    }

    private void b(s<Z> sVar) {
        this.f5867e = false;
        this.f5866d = true;
        this.f5865c = sVar;
    }

    private void f() {
        this.f5865c = null;
        f5863a.release(this);
    }

    public synchronized void a() {
        this.f5864b.b();
        if (this.f5866d) {
            this.f5866d = false;
            if (this.f5867e) {
                e();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    public Class<Z> b() {
        return this.f5865c.b();
    }

    public Z c() {
        return this.f5865c.c();
    }

    public int d() {
        return this.f5865c.d();
    }

    public synchronized void e() {
        this.f5864b.b();
        this.f5867e = true;
        if (!this.f5866d) {
            this.f5865c.e();
            f();
        }
    }

    public b f_() {
        return this.f5864b;
    }
}
