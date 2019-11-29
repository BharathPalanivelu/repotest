package com.shopee.app.application;

import b.a.b;
import b.a.c;
import com.shopee.app.util.n;

public final class j implements b<n> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15883a;

    public j(c cVar) {
        this.f15883a = cVar;
    }

    /* renamed from: a */
    public n get() {
        return (n) c.a(this.f15883a.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static j a(c cVar) {
        return new j(cVar);
    }
}
