package com.shopee.app.a;

import b.a.b;
import com.shopee.app.ui.actionbar.a;

public final class c implements b<a> {

    /* renamed from: a  reason: collision with root package name */
    private final b f15758a;

    public c(b bVar) {
        this.f15758a = bVar;
    }

    /* renamed from: a */
    public a get() {
        return (a) b.a.c.a(this.f15758a.c(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static c a(b bVar) {
        return new c(bVar);
    }
}
