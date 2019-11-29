package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public final class n {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f6872a;

    /* renamed from: b  reason: collision with root package name */
    private final int f6873b;

    /* renamed from: c  reason: collision with root package name */
    private final int f6874c;

    private n(Class<?> cls, int i, int i2) {
        this.f6872a = (Class) Preconditions.checkNotNull(cls, "Null dependency anInterface.");
        this.f6873b = i;
        this.f6874c = i2;
    }

    @KeepForSdk
    public static n a(Class<?> cls) {
        return new n(cls, 0, 0);
    }

    @KeepForSdk
    public static n b(Class<?> cls) {
        return new n(cls, 1, 0);
    }

    @KeepForSdk
    public static n c(Class<?> cls) {
        return new n(cls, 2, 0);
    }

    public Class<?> a() {
        return this.f6872a;
    }

    public boolean b() {
        return this.f6873b == 1;
    }

    public boolean c() {
        return this.f6873b == 2;
    }

    public boolean d() {
        return this.f6874c == 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (this.f6872a == nVar.f6872a && this.f6873b == nVar.f6873b && this.f6874c == nVar.f6874c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f6872a.hashCode() ^ 1000003) * 1000003) ^ this.f6873b) * 1000003) ^ this.f6874c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f6872a);
        sb.append(", type=");
        int i = this.f6873b;
        boolean z = true;
        sb.append(i == 1 ? "required" : i == 0 ? "optional" : "set");
        sb.append(", direct=");
        if (this.f6874c != 0) {
            z = false;
        }
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }
}
