package com.shopee.app.react.b;

import b.a.b;
import b.a.c;
import com.garena.reactpush.c.d;

public final class f implements b<d> {

    /* renamed from: a  reason: collision with root package name */
    private final e f18600a;

    public f(e eVar) {
        this.f18600a = eVar;
    }

    /* renamed from: a */
    public d get() {
        return (d) c.a(this.f18600a.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static f a(e eVar) {
        return new f(eVar);
    }

    public static d b(e eVar) {
        return (d) c.a(eVar.b(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
