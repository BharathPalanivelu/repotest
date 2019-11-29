package com.google.android.exoplayer2.e.d;

import com.google.android.exoplayer2.n.a;
import com.google.android.exoplayer2.n.t;

final class m {

    /* renamed from: a  reason: collision with root package name */
    public final int f9505a;

    /* renamed from: b  reason: collision with root package name */
    public final long[] f9506b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f9507c;

    /* renamed from: d  reason: collision with root package name */
    public final int f9508d;

    /* renamed from: e  reason: collision with root package name */
    public final long[] f9509e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f9510f;

    public m(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        boolean z = true;
        a.a(iArr.length == jArr2.length);
        a.a(jArr.length == jArr2.length);
        a.a(iArr2.length != jArr2.length ? false : z);
        this.f9506b = jArr;
        this.f9507c = iArr;
        this.f9508d = i;
        this.f9509e = jArr2;
        this.f9510f = iArr2;
        this.f9505a = jArr.length;
    }

    public int a(long j) {
        for (int a2 = t.a(this.f9509e, j, true, false); a2 >= 0; a2--) {
            if ((this.f9510f[a2] & 1) != 0) {
                return a2;
            }
        }
        return -1;
    }

    public int b(long j) {
        for (int b2 = t.b(this.f9509e, j, true, false); b2 < this.f9509e.length; b2++) {
            if ((this.f9510f[b2] & 1) != 0) {
                return b2;
            }
        }
        return -1;
    }
}
