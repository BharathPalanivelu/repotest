package com.google.android.exoplayer2.l;

import java.util.Arrays;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final int f10735a;

    /* renamed from: b  reason: collision with root package name */
    private final f[] f10736b;

    /* renamed from: c  reason: collision with root package name */
    private int f10737c;

    public g(f... fVarArr) {
        this.f10736b = fVarArr;
        this.f10735a = fVarArr.length;
    }

    public f a(int i) {
        return this.f10736b[i];
    }

    public f[] a() {
        return (f[]) this.f10736b.clone();
    }

    public int hashCode() {
        if (this.f10737c == 0) {
            this.f10737c = 527 + Arrays.hashCode(this.f10736b);
        }
        return this.f10737c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f10736b, ((g) obj).f10736b);
    }
}
