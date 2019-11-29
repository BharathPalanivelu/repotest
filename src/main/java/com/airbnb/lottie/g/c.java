package com.airbnb.lottie.g;

import com.airbnb.lottie.a.b.a;

public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    protected T f3748a = null;

    /* renamed from: b  reason: collision with root package name */
    private final b<T> f3749b = new b<>();

    /* renamed from: c  reason: collision with root package name */
    private a<?, ?> f3750c;

    public c() {
    }

    public c(T t) {
        this.f3748a = t;
    }

    public T a(b<T> bVar) {
        return this.f3748a;
    }

    public final T a(float f2, float f3, T t, T t2, float f4, float f5, float f6) {
        return a(this.f3749b.a(f2, f3, t, t2, f4, f5, f6));
    }

    public final void a(a<?, ?> aVar) {
        this.f3750c = aVar;
    }
}
