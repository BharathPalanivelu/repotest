package com.shopee.app.application;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.aa;

public final class q implements b<aa> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15902a;

    public q(c cVar) {
        this.f15902a = cVar;
    }

    /* renamed from: a */
    public aa get() {
        return (aa) c.a(this.f15902a.j(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static q a(c cVar) {
        return new q(cVar);
    }
}
