package com.shopee.app.a;

import b.a.b;
import com.shopee.app.util.i.c;

public final class p implements b<c> {

    /* renamed from: a  reason: collision with root package name */
    private final b f15778a;

    public p(b bVar) {
        this.f15778a = bVar;
    }

    /* renamed from: a */
    public c get() {
        return (c) b.a.c.a(this.f15778a.j(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static p a(b bVar) {
        return new p(bVar);
    }
}
