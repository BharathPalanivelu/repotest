package io.b;

import io.b.e.b.b;
import io.b.e.e.b.c;
import io.b.e.e.b.d;
import io.b.g.a;

public abstract class f<T> {

    /* renamed from: a  reason: collision with root package name */
    static final int f33565a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public static int a() {
        return f33565a;
    }

    public final f<T> b() {
        return a(a(), false, true);
    }

    public final f<T> a(int i, boolean z, boolean z2) {
        b.a(i, "bufferSize");
        return a.a(new c(this, i, z2, z, io.b.e.b.a.f33329c));
    }

    public final f<T> c() {
        return a.a(new d(this));
    }

    public final f<T> d() {
        return a.a(new io.b.e.e.b.f(this));
    }
}
