package io.b.e.d;

import io.b.b.b;
import io.b.s;
import java.util.concurrent.atomic.AtomicReference;

public final class i<T> implements s<T> {

    /* renamed from: a  reason: collision with root package name */
    final AtomicReference<b> f33347a;

    /* renamed from: b  reason: collision with root package name */
    final s<? super T> f33348b;

    public i(AtomicReference<b> atomicReference, s<? super T> sVar) {
        this.f33347a = atomicReference;
        this.f33348b = sVar;
    }

    public void a(b bVar) {
        io.b.e.a.b.replace(this.f33347a, bVar);
    }

    public void a(T t) {
        this.f33348b.a(t);
    }

    public void a(Throwable th) {
        this.f33348b.a(th);
    }
}
