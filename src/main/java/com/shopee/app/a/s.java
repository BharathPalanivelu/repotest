package com.shopee.app.a;

import b.a.b;
import b.a.c;
import com.shopee.app.ui.common.i;

public final class s implements b<i> {

    /* renamed from: a  reason: collision with root package name */
    private final b f15782a;

    public s(b bVar) {
        this.f15782a = bVar;
    }

    /* renamed from: a */
    public i get() {
        return (i) c.a(this.f15782a.d(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static s a(b bVar) {
        return new s(bVar);
    }
}
