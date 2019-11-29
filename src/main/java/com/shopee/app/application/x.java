package com.shopee.app.application;

import b.a.b;
import b.a.c;
import com.shopee.navigator.e;

public final class x implements b<e> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15912a;

    public x(c cVar) {
        this.f15912a = cVar;
    }

    /* renamed from: a */
    public e get() {
        return (e) c.a(this.f15912a.u(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static x a(c cVar) {
        return new x(cVar);
    }
}
