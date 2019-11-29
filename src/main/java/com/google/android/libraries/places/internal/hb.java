package com.google.android.libraries.places.internal;

import java.io.Serializable;

final class hb implements Serializable {
    public static final long serialVersionUID = 0;

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f12641a;

    hb(Object[] objArr) {
        this.f12641a = objArr;
    }

    /* access modifiers changed from: package-private */
    public final Object readResolve() {
        return ha.a((E[]) this.f12641a);
    }
}
