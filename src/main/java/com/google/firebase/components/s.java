package com.google.firebase.components;

import com.google.firebase.b.a;

class s<T> implements a<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f6880a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f6881b = f6880a;

    /* renamed from: c  reason: collision with root package name */
    private volatile a<T> f6882c;

    s(a<T> aVar) {
        this.f6882c = aVar;
    }

    public T a() {
        T t = this.f6881b;
        if (t == f6880a) {
            synchronized (this) {
                t = this.f6881b;
                if (t == f6880a) {
                    t = this.f6882c.a();
                    this.f6881b = t;
                    this.f6882c = null;
                }
            }
        }
        return t;
    }
}
