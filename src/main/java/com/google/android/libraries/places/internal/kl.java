package com.google.android.libraries.places.internal;

final class kl {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f12877a = b();

    private static Class<?> b() {
        try {
            return Class.forName("com.google.c.n");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static km a() {
        Class<?> cls = f12877a;
        if (cls != null) {
            try {
                return (km) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke((Object) null, new Object[0]);
            } catch (Exception unused) {
            }
        }
        return km.f12878a;
    }
}
