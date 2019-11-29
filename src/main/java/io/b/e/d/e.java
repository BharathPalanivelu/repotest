package io.b.e.d;

import io.b.b.b;
import io.b.c;
import io.b.e.h.d;
import io.b.e.h.f;
import io.b.h;
import io.b.s;
import java.util.concurrent.CountDownLatch;

public final class e<T> extends CountDownLatch implements c, h<T>, s<T> {

    /* renamed from: a  reason: collision with root package name */
    T f33343a;

    /* renamed from: b  reason: collision with root package name */
    Throwable f33344b;

    /* renamed from: c  reason: collision with root package name */
    b f33345c;

    /* renamed from: d  reason: collision with root package name */
    volatile boolean f33346d;

    public e() {
        super(1);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f33346d = true;
        b bVar = this.f33345c;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    public void a(b bVar) {
        this.f33345c = bVar;
        if (this.f33346d) {
            bVar.dispose();
        }
    }

    public void a(T t) {
        this.f33343a = t;
        countDown();
    }

    public void a(Throwable th) {
        this.f33344b = th;
        countDown();
    }

    public void a() {
        countDown();
    }

    public T c() {
        if (getCount() != 0) {
            try {
                d.a();
                await();
            } catch (InterruptedException e2) {
                b();
                throw f.a((Throwable) e2);
            }
        }
        Throwable th = this.f33344b;
        if (th == null) {
            return this.f33343a;
        }
        throw f.a(th);
    }
}
