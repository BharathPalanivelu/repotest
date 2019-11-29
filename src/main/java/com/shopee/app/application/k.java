package com.shopee.app.application;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.z;

public final class k implements b<z> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15884a;

    public k(c cVar) {
        this.f15884a = cVar;
    }

    /* renamed from: a */
    public z get() {
        return (z) c.a(this.f15884a.o(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static k a(c cVar) {
        return new k(cVar);
    }
}
