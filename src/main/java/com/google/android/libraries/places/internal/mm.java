package com.google.android.libraries.places.internal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class mm {

    /* renamed from: a  reason: collision with root package name */
    public static final mm f12971a = new mm();

    /* renamed from: b  reason: collision with root package name */
    private final mq f12972b = new lq();

    /* renamed from: c  reason: collision with root package name */
    private final ConcurrentMap<Class<?>, mp<?>> f12973c = new ConcurrentHashMap();

    public final <T> mp<T> a(Class<T> cls) {
        kx.a(cls, "messageType");
        mp<T> mpVar = (mp) this.f12973c.get(cls);
        if (mpVar != null) {
            return mpVar;
        }
        mp<T> a2 = this.f12972b.a(cls);
        kx.a(cls, "messageType");
        kx.a(a2, "schema");
        mp<T> putIfAbsent = this.f12973c.putIfAbsent(cls, a2);
        return putIfAbsent != null ? putIfAbsent : a2;
    }

    public final <T> mp<T> a(T t) {
        return a(t.getClass());
    }

    private mm() {
    }
}
