package com.shopee.app.application;

import b.a.b;
import com.shopee.app.react.modules.app.data.c;

public final class h implements b<c> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15881a;

    public h(c cVar) {
        this.f15881a = cVar;
    }

    /* renamed from: a */
    public c get() {
        return (c) b.a.c.a(this.f15881a.t(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static h a(c cVar) {
        return new h(cVar);
    }
}
