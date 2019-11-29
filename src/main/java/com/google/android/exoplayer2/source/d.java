package com.google.android.exoplayer2.source;

import com.facebook.common.time.Clock;

public final class d implements m {

    /* renamed from: a  reason: collision with root package name */
    private final m[] f11775a;

    public d(m[] mVarArr) {
        this.f11775a = mVarArr;
    }

    public final long d() {
        long j = Long.MAX_VALUE;
        for (m d2 : this.f11775a) {
            long d3 = d2.d();
            if (d3 != Long.MIN_VALUE) {
                j = Math.min(j, d3);
            }
        }
        if (j == Clock.MAX_TIME) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public final long e() {
        long j = Long.MAX_VALUE;
        for (m e2 : this.f11775a) {
            long e3 = e2.e();
            if (e3 != Long.MIN_VALUE) {
                j = Math.min(j, e3);
            }
        }
        if (j == Clock.MAX_TIME) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public final boolean c(long j) {
        boolean z;
        boolean z2 = false;
        do {
            long e2 = e();
            if (e2 == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (m mVar : this.f11775a) {
                if (mVar.e() == e2) {
                    z |= mVar.c(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }
}
