package com.google.android.exoplayer2.i.d;

import com.google.android.exoplayer2.s.a;
import com.google.android.exoplayer2.s.v;

final class m {

    /* renamed from: a  reason: collision with root package name */
    public final int f10137a;

    /* renamed from: b  reason: collision with root package name */
    public final long[] f10138b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f10139c;

    /* renamed from: d  reason: collision with root package name */
    public final int f10140d;

    /* renamed from: e  reason: collision with root package name */
    public final long[] f10141e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f10142f;

    public m(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        boolean z = true;
        a.a(iArr.length == jArr2.length);
        a.a(jArr.length == jArr2.length);
        a.a(iArr2.length != jArr2.length ? false : z);
        this.f10138b = jArr;
        this.f10139c = iArr;
        this.f10140d = i;
        this.f10141e = jArr2;
        this.f10142f = iArr2;
        this.f10137a = jArr.length;
    }

    public int a(long j) {
        for (int a2 = v.a(this.f10141e, j, true, false); a2 >= 0; a2--) {
            if ((this.f10142f[a2] & 1) != 0) {
                return a2;
            }
        }
        return -1;
    }

    public int b(long j) {
        for (int b2 = v.b(this.f10141e, j, true, false); b2 < this.f10141e.length; b2++) {
            if ((this.f10142f[b2] & 1) != 0) {
                return b2;
            }
        }
        return -1;
    }
}
