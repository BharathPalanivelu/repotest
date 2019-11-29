package com.c.a.c.b;

import android.os.Looper;
import com.c.a.c.h;

class n<Z> implements s<Z> {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f5850a;

    /* renamed from: b  reason: collision with root package name */
    private a f5851b;

    /* renamed from: c  reason: collision with root package name */
    private h f5852c;

    /* renamed from: d  reason: collision with root package name */
    private int f5853d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5854e;

    /* renamed from: f  reason: collision with root package name */
    private final s<Z> f5855f;

    interface a {
        void b(h hVar, n<?> nVar);
    }

    n(s<Z> sVar, boolean z) {
        this.f5855f = (s) com.c.a.i.h.a(sVar);
        this.f5850a = z;
    }

    /* access modifiers changed from: package-private */
    public void a(h hVar, a aVar) {
        this.f5852c = hVar;
        this.f5851b = aVar;
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f5850a;
    }

    public Class<Z> b() {
        return this.f5855f.b();
    }

    public Z c() {
        return this.f5855f.c();
    }

    public int d() {
        return this.f5855f.d();
    }

    public void e() {
        if (this.f5853d > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (!this.f5854e) {
            this.f5854e = true;
            this.f5855f.e();
        } else {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (this.f5854e) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            this.f5853d++;
        } else {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (this.f5853d <= 0) {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            int i = this.f5853d - 1;
            this.f5853d = i;
            if (i == 0) {
                this.f5851b.b(this.f5852c, this);
            }
        } else {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
    }

    public String toString() {
        return "EngineResource{isCacheable=" + this.f5850a + ", listener=" + this.f5851b + ", key=" + this.f5852c + ", acquired=" + this.f5853d + ", isRecycled=" + this.f5854e + ", resource=" + this.f5855f + '}';
    }
}
