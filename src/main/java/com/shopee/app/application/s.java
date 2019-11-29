package com.shopee.app.application;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.ae;

public final class s implements b<ae> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15904a;

    public s(c cVar) {
        this.f15904a = cVar;
    }

    /* renamed from: a */
    public ae get() {
        return (ae) c.a(this.f15904a.n(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static s a(c cVar) {
        return new s(cVar);
    }
}
