package com.shopee.app.application;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.theme.ThemeStore;

public final class ag implements b<ThemeStore> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15854a;

    public ag(c cVar) {
        this.f15854a = cVar;
    }

    /* renamed from: a */
    public ThemeStore get() {
        return (ThemeStore) c.a(this.f15854a.q(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static ag a(c cVar) {
        return new ag(cVar);
    }
}
