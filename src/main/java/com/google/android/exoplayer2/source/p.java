package com.google.android.exoplayer2.source;

import java.util.Arrays;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final p f12117a = new p(new o[0]);

    /* renamed from: b  reason: collision with root package name */
    public final int f12118b;

    /* renamed from: c  reason: collision with root package name */
    private final o[] f12119c;

    /* renamed from: d  reason: collision with root package name */
    private int f12120d;

    public p(o... oVarArr) {
        this.f12119c = oVarArr;
        this.f12118b = oVarArr.length;
    }

    public o a(int i) {
        return this.f12119c[i];
    }

    public int a(o oVar) {
        for (int i = 0; i < this.f12118b; i++) {
            if (this.f12119c[i] == oVar) {
                return i;
            }
        }
        return -1;
    }

    public int hashCode() {
        if (this.f12120d == 0) {
            this.f12120d = Arrays.hashCode(this.f12119c);
        }
        return this.f12120d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f12118b != pVar.f12118b || !Arrays.equals(this.f12119c, pVar.f12119c)) {
            return false;
        }
        return true;
    }
}
