package com.google.android.libraries.places.internal;

import java.io.Serializable;

final class hh implements Serializable {
    public static final long serialVersionUID = 0;

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f12650a;

    hh(Object[] objArr) {
        this.f12650a = objArr;
    }

    /* access modifiers changed from: package-private */
    public final Object readResolve() {
        return hg.a((E[]) this.f12650a);
    }
}
