package com.shopee.app.application;

import b.a.b;
import b.a.c;
import com.shopee.app.h.a.a;

public final class r implements b<a> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15903a;

    public r(c cVar) {
        this.f15903a = cVar;
    }

    /* renamed from: a */
    public a get() {
        return (a) c.a(this.f15903a.f(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static r a(c cVar) {
        return new r(cVar);
    }
}
