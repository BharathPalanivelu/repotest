package com.shopee.app.a;

import b.a.b;
import b.a.c;
import com.shopee.app.ui.common.r;

public final class m implements b<r> {

    /* renamed from: a  reason: collision with root package name */
    private final b f15774a;

    public m(b bVar) {
        this.f15774a = bVar;
    }

    /* renamed from: a */
    public r get() {
        return (r) c.a(this.f15774a.g(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static m a(b bVar) {
        return new m(bVar);
    }
}
