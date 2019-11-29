package com.shopee.app.application;

import b.a.b;
import b.a.c;
import com.shopee.app.util.bh;

public final class ah implements b<bh> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15855a;

    public ah(c cVar) {
        this.f15855a = cVar;
    }

    /* renamed from: a */
    public bh get() {
        return (bh) c.a(this.f15855a.e(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static ah a(c cVar) {
        return new ah(cVar);
    }
}
