package com.shopee.feeds.feedlibrary.b;

import com.shopee.feeds.feedlibrary.view.a.b;
import java.lang.ref.WeakReference;

public class a<V extends b> {

    /* renamed from: a  reason: collision with root package name */
    protected WeakReference<V> f27571a;

    public void a(V v) {
        if (this.f27571a == null) {
            this.f27571a = new WeakReference<>(v);
        }
        v.h();
    }

    public V a() {
        return (b) this.f27571a.get();
    }
}
