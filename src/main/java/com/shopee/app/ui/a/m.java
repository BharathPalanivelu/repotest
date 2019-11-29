package com.shopee.app.ui.a;

import android.content.Context;
import android.view.View;

public abstract class m<V extends View, T> {

    /* renamed from: a  reason: collision with root package name */
    private T f19218a;

    /* renamed from: b  reason: collision with root package name */
    private Object f19219b;

    public abstract V a(Context context, T t, int i);

    public abstract void a(V v, T t);

    public abstract int b();

    public void a(T t) {
        this.f19218a = t;
    }

    public void b(Object obj) {
        this.f19219b = obj;
    }

    public Object a() {
        return this.f19219b;
    }

    public T c() {
        return this.f19218a;
    }
}
