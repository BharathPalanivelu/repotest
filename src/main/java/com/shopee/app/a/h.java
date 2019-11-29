package com.shopee.app.a;

import android.content.Context;
import b.a.b;
import b.a.c;

public final class h implements b<Context> {

    /* renamed from: a  reason: collision with root package name */
    private final b f15765a;

    public h(b bVar) {
        this.f15765a = bVar;
    }

    /* renamed from: a */
    public Context get() {
        return (Context) c.a(this.f15765a.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static h a(b bVar) {
        return new h(bVar);
    }
}
