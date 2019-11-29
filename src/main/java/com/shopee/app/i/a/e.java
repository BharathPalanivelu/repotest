package com.shopee.app.i.a;

import b.a.b;
import b.a.c;

public final class e implements b<com.shopee.sdk.modules.ui.navigator.b> {

    /* renamed from: a  reason: collision with root package name */
    private final c f17718a;

    public e(c cVar) {
        this.f17718a = cVar;
    }

    /* renamed from: a */
    public com.shopee.sdk.modules.ui.navigator.b get() {
        return (com.shopee.sdk.modules.ui.navigator.b) c.a(this.f17718a.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static e a(c cVar) {
        return new e(cVar);
    }
}
