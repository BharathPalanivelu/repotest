package com.google.android.libraries.places.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class km {

    /* renamed from: a  reason: collision with root package name */
    public static final km f12878a = new km((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f12879b = false;

    /* renamed from: c  reason: collision with root package name */
    private static volatile km f12880c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Object, Object> f12881d;

    private static Class<?> b() {
        try {
            return Class.forName("com.google.c.l");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static km a() {
        km kmVar = f12880c;
        if (kmVar == null) {
            synchronized (km.class) {
                kmVar = f12880c;
                if (kmVar == null) {
                    kmVar = kl.a();
                    f12880c = kmVar;
                }
            }
        }
        return kmVar;
    }

    km() {
        this.f12881d = new HashMap();
    }

    private km(byte b2) {
        this.f12881d = Collections.emptyMap();
    }

    static {
        b();
    }
}
