package com.shopee.app.application;

import b.a.b;
import b.a.c;
import com.shopee.app.util.am;

public final class y implements b<am> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15913a;

    public y(c cVar) {
        this.f15913a = cVar;
    }

    /* renamed from: a */
    public am get() {
        return (am) c.a(this.f15913a.r(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static y a(c cVar) {
        return new y(cVar);
    }
}
