package com.google.c;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f13992a = false;

    /* renamed from: b  reason: collision with root package name */
    static final p f13993b = new p(true);

    /* renamed from: c  reason: collision with root package name */
    private static final Class<?> f13994c = b();

    /* renamed from: d  reason: collision with root package name */
    private final Map<Object, Object<?, ?>> f13995d;

    static Class<?> b() {
        try {
            return Class.forName("com.google.c.l");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static boolean c() {
        return f13992a;
    }

    public static p d() {
        return o.b();
    }

    public static p e() {
        return o.c();
    }

    p() {
        this.f13995d = new HashMap();
    }

    p(p pVar) {
        if (pVar == f13993b) {
            this.f13995d = Collections.emptyMap();
        } else {
            this.f13995d = Collections.unmodifiableMap(pVar.f13995d);
        }
    }

    p(boolean z) {
        this.f13995d = Collections.emptyMap();
    }
}
