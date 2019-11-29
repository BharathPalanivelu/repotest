package com.google.android.exoplayer2.source;

import com.facebook.common.time.Clock;

public final class t implements aa {

    /* renamed from: a  reason: collision with root package name */
    private final aa[] f12158a;

    public t(aa[] aaVarArr) {
        this.f12158a = aaVarArr;
    }

    public long f() {
        long j = Long.MAX_VALUE;
        for (aa f2 : this.f12158a) {
            long f3 = f2.f();
            if (f3 != Long.MIN_VALUE) {
                j = Math.min(j, f3);
            }
        }
        if (j == Clock.MAX_TIME) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public boolean d(long j) {
        boolean z;
        boolean z2 = false;
        do {
            long f2 = f();
            if (f2 == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (aa aaVar : this.f12158a) {
                if (aaVar.f() == f2) {
                    z |= aaVar.d(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }
}
