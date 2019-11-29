package com.shopee.app.application;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.al;

public final class v implements b<al> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15910a;

    public v(c cVar) {
        this.f15910a = cVar;
    }

    /* renamed from: a */
    public al get() {
        return (al) c.a(this.f15910a.d(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static v a(c cVar) {
        return new v(cVar);
    }
}
