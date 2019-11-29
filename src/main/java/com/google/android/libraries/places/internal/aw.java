package com.google.android.libraries.places.internal;

import java.util.Locale;

public final class aw implements ax, dz {

    /* renamed from: a  reason: collision with root package name */
    private volatile String f12352a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Locale f12353b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f12354c;

    public final synchronized void a(String str, Locale locale, boolean z) {
        go.a(str, (Object) "API Key must not be null.");
        go.a(!str.isEmpty(), (Object) "API Key must not be empty.");
        this.f12352a = str;
        this.f12353b = locale;
        this.f12354c = z;
    }

    public final synchronized boolean a() {
        return this.f12352a != null;
    }

    public final synchronized String b() {
        go.b(a(), (Object) "ApiConfig must be initialized.");
        return this.f12352a;
    }

    public final synchronized Locale c() {
        go.b(a(), (Object) "ApiConfig must be initialized.");
        if (this.f12353b == null) {
            return Locale.getDefault();
        }
        return this.f12353b;
    }

    public final boolean d() {
        return this.f12354c;
    }
}
