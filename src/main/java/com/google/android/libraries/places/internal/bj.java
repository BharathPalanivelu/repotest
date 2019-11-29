package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.LocalTime;

public final class bj extends LocalTime.a {

    /* renamed from: a  reason: collision with root package name */
    private Integer f12383a;

    /* renamed from: b  reason: collision with root package name */
    private Integer f12384b;

    /* access modifiers changed from: package-private */
    public final LocalTime.a a(int i) {
        this.f12383a = Integer.valueOf(i);
        return this;
    }

    /* access modifiers changed from: package-private */
    public final LocalTime.a b(int i) {
        this.f12384b = Integer.valueOf(i);
        return this;
    }

    /* access modifiers changed from: package-private */
    public final LocalTime a() {
        String str = "";
        if (this.f12383a == null) {
            str = str.concat(" hours");
        }
        if (this.f12384b == null) {
            str = String.valueOf(str).concat(" minutes");
        }
        if (str.isEmpty()) {
            return new ci(this.f12383a.intValue(), this.f12384b.intValue());
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
    }
}
