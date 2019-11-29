package com.shopee.app.application;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.am;

public final class w implements b<am> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15911a;

    public w(c cVar) {
        this.f15911a = cVar;
    }

    /* renamed from: a */
    public am get() {
        return (am) c.a(this.f15911a.h(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static w a(c cVar) {
        return new w(cVar);
    }
}
