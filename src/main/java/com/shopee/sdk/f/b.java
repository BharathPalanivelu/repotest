package com.shopee.sdk.f;

public abstract class b<T> {

    /* renamed from: a  reason: collision with root package name */
    private boolean f30360a = false;

    public abstract void a(int i, String str);

    public abstract void a(T t);

    public void b(T t) {
        if (!this.f30360a) {
            this.f30360a = true;
            a(t);
        }
    }

    public void b(int i, String str) {
        if (!this.f30360a) {
            this.f30360a = true;
            a(i, str);
        }
    }
}
