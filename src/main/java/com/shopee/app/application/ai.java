package com.shopee.app.application;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.bd;

public final class ai implements b<bd> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15856a;

    public ai(c cVar) {
        this.f15856a = cVar;
    }

    /* renamed from: a */
    public bd get() {
        return (bd) c.a(this.f15856a.k(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static ai a(c cVar) {
        return new ai(cVar);
    }
}
