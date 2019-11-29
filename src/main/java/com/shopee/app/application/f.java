package com.shopee.app.application;

import b.a.b;
import b.a.c;

public final class f implements b<com.shopee.app.application.a.b> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15879a;

    public f(c cVar) {
        this.f15879a = cVar;
    }

    /* renamed from: a */
    public com.shopee.app.application.a.b get() {
        return (com.shopee.app.application.a.b) c.a(this.f15879a.l(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static f a(c cVar) {
        return new f(cVar);
    }
}
