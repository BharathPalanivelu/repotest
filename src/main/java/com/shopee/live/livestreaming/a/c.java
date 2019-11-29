package com.shopee.live.livestreaming.a;

import com.shopee.live.livestreaming.a.g;
import java.lang.ref.WeakReference;

public class c<V extends g> {

    /* renamed from: a  reason: collision with root package name */
    protected WeakReference<V> f28750a;

    public void a(V v) {
        if (this.f28750a == null) {
            this.f28750a = new WeakReference<>(v);
        }
        v.z_();
    }

    public void a() {
        b().b();
    }

    public V b() {
        return (g) this.f28750a.get();
    }
}
