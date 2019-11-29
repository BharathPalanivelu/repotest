package com.google.android.exoplayer2;

import java.util.HashSet;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static final HashSet<String> f10631a = new HashSet<>();

    /* renamed from: b  reason: collision with root package name */
    private static String f10632b = "goog.exo.core";

    public static synchronized String a() {
        String str;
        synchronized (k.class) {
            str = f10632b;
        }
        return str;
    }

    public static synchronized void a(String str) {
        synchronized (k.class) {
            if (f10631a.add(str)) {
                f10632b += ", " + str;
            }
        }
    }
}
