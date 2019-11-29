package com.shopee.app.application;

import b.a.b;
import b.a.c;
import com.shopee.app.data.store.ShareConfigStore;

public final class af implements b<ShareConfigStore> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15853a;

    public af(c cVar) {
        this.f15853a = cVar;
    }

    /* renamed from: a */
    public ShareConfigStore get() {
        return (ShareConfigStore) c.a(this.f15853a.g(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static af a(c cVar) {
        return new af(cVar);
    }
}
