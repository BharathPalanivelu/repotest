package com.google.android.exoplayer2.source;

import java.util.Arrays;

public final class ad {

    /* renamed from: a  reason: collision with root package name */
    public static final ad f11537a = new ad(new ac[0]);

    /* renamed from: b  reason: collision with root package name */
    public final int f11538b;

    /* renamed from: c  reason: collision with root package name */
    private final ac[] f11539c;

    /* renamed from: d  reason: collision with root package name */
    private int f11540d;

    public ad(ac... acVarArr) {
        this.f11539c = acVarArr;
        this.f11538b = acVarArr.length;
    }

    public ac a(int i) {
        return this.f11539c[i];
    }

    public int a(ac acVar) {
        for (int i = 0; i < this.f11538b; i++) {
            if (this.f11539c[i] == acVar) {
                return i;
            }
        }
        return -1;
    }

    public int hashCode() {
        if (this.f11540d == 0) {
            this.f11540d = Arrays.hashCode(this.f11539c);
        }
        return this.f11540d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ad adVar = (ad) obj;
        if (this.f11538b != adVar.f11538b || !Arrays.equals(this.f11539c, adVar.f11539c)) {
            return false;
        }
        return true;
    }
}
