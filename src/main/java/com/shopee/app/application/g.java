package com.shopee.app.application;

import b.a.b;
import b.a.c;

public final class g implements b<ar> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15880a;

    public g(c cVar) {
        this.f15880a = cVar;
    }

    /* renamed from: a */
    public ar get() {
        return (ar) c.a(this.f15880a.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static g a(c cVar) {
        return new g(cVar);
    }
}
