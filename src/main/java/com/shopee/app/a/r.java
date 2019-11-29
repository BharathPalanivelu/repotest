package com.shopee.app.a;

import b.a.b;
import b.a.c;
import com.shopee.app.util.bc;

public final class r implements b<bc> {

    /* renamed from: a  reason: collision with root package name */
    private final b f15781a;

    public r(b bVar) {
        this.f15781a = bVar;
    }

    /* renamed from: a */
    public bc get() {
        return (bc) c.a(this.f15781a.e(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static r a(b bVar) {
        return new r(bVar);
    }
}
