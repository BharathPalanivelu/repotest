package com.shopee.app.a;

import b.a.b;
import b.a.c;
import com.shopee.app.util.ak;

public final class o implements b<ak> {

    /* renamed from: a  reason: collision with root package name */
    private final b f15777a;

    public o(b bVar) {
        this.f15777a = bVar;
    }

    /* renamed from: a */
    public ak get() {
        return (ak) c.a(this.f15777a.f(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static o a(b bVar) {
        return new o(bVar);
    }
}
