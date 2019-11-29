package com.google.android.exoplayer2.q;

import java.util.Arrays;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final int f11284a;

    /* renamed from: b  reason: collision with root package name */
    private final f[] f11285b;

    /* renamed from: c  reason: collision with root package name */
    private int f11286c;

    public g(f... fVarArr) {
        this.f11285b = fVarArr;
        this.f11284a = fVarArr.length;
    }

    public f a(int i) {
        return this.f11285b[i];
    }

    public f[] a() {
        return (f[]) this.f11285b.clone();
    }

    public int hashCode() {
        if (this.f11286c == 0) {
            this.f11286c = 527 + Arrays.hashCode(this.f11285b);
        }
        return this.f11286c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f11285b, ((g) obj).f11285b);
    }
}
