package com.shopee.app.application;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.v;

public final class i implements b<v> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15882a;

    public i(c cVar) {
        this.f15882a = cVar;
    }

    /* renamed from: a */
    public v get() {
        return (v) c.a(this.f15882a.m(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static i a(c cVar) {
        return new i(cVar);
    }
}
