package com.shopee.app.application;

import b.a.b;
import b.a.c;
import com.shopee.app.util.q;

public final class d implements b<q> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15876a;

    public d(c cVar) {
        this.f15876a = cVar;
    }

    /* renamed from: a */
    public q get() {
        return (q) c.a(this.f15876a.s(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static d a(c cVar) {
        return new d(cVar);
    }
}
