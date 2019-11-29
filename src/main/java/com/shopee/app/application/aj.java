package com.shopee.app.application;

import b.a.b;
import b.a.c;
import com.shopee.app.util.bi;

public final class aj implements b<bi> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15857a;

    public aj(c cVar) {
        this.f15857a = cVar;
    }

    /* renamed from: a */
    public bi get() {
        return (bi) c.a(this.f15857a.c(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static aj a(c cVar) {
        return new aj(cVar);
    }
}
