package com.google.android.libraries.places.internal;

final class jz {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f12859a = a("libcore.io.Memory");

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f12860b = (a("org.robolectric.Robolectric") != null);

    static boolean a() {
        return f12859a != null && !f12860b;
    }

    private static <T> Class<T> a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
