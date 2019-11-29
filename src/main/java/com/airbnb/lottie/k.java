package com.airbnb.lottie;

import java.util.Arrays;

public final class k<V> {

    /* renamed from: a  reason: collision with root package name */
    private final V f3760a;

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f3761b;

    public k(V v) {
        this.f3760a = v;
        this.f3761b = null;
    }

    public k(Throwable th) {
        this.f3761b = th;
        this.f3760a = null;
    }

    public V a() {
        return this.f3760a;
    }

    public Throwable b() {
        return this.f3761b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (a() != null && a().equals(kVar.a())) {
            return true;
        }
        if (b() == null || kVar.b() == null) {
            return false;
        }
        return b().toString().equals(b().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{a(), b()});
    }
}
