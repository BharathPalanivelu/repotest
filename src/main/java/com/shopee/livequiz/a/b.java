package com.shopee.livequiz.a;

import com.shopee.livequiz.a.c;
import java.lang.ref.WeakReference;

public class b<V extends c> {

    /* renamed from: a  reason: collision with root package name */
    protected WeakReference<V> f29674a;

    public void a(V v) {
        if (this.f29674a == null) {
            this.f29674a = new WeakReference<>(v);
        }
    }

    public void a() {
        WeakReference<V> weakReference = this.f29674a;
        if (weakReference != null) {
            weakReference.clear();
        }
    }

    public V b() {
        return (c) this.f29674a.get();
    }
}
