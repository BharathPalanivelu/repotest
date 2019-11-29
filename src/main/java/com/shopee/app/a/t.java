package com.shopee.app.a;

import b.a.b;
import b.a.c;
import com.shopee.app.util.m.a;

public final class t implements b<a> {

    /* renamed from: a  reason: collision with root package name */
    private final b f15783a;

    public t(b bVar) {
        this.f15783a = bVar;
    }

    /* renamed from: a */
    public a get() {
        return (a) c.a(this.f15783a.i(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static t a(b bVar) {
        return new t(bVar);
    }
}
