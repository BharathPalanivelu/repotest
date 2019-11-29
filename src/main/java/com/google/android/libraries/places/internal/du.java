package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.dw;

final class du extends dw.a {

    /* renamed from: a  reason: collision with root package name */
    private String f12478a;

    /* renamed from: b  reason: collision with root package name */
    private Integer f12479b;

    /* renamed from: c  reason: collision with root package name */
    private dw.b f12480c;

    du() {
    }

    /* access modifiers changed from: package-private */
    public final dw.a a(String str) {
        if (str != null) {
            this.f12478a = str;
            return this;
        }
        throw new NullPointerException("Null packageName");
    }

    /* access modifiers changed from: package-private */
    public final dw.a a(int i) {
        this.f12479b = Integer.valueOf(i);
        return this;
    }

    public final dw.a a(dw.b bVar) {
        if (bVar != null) {
            this.f12480c = bVar;
            return this;
        }
        throw new NullPointerException("Null requestSource");
    }

    /* access modifiers changed from: package-private */
    public final dw a() {
        String str = "";
        if (this.f12478a == null) {
            str = str.concat(" packageName");
        }
        if (this.f12479b == null) {
            str = String.valueOf(str).concat(" versionCode");
        }
        if (this.f12480c == null) {
            str = String.valueOf(str).concat(" requestSource");
        }
        if (str.isEmpty()) {
            return new dt(this.f12478a, this.f12479b.intValue(), this.f12480c);
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
    }
}
