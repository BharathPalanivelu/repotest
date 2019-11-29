package com.google.android.exoplayer2.p.d;

import com.google.android.exoplayer2.p.e;
import com.google.android.exoplayer2.s.a;
import com.google.android.exoplayer2.s.v;
import java.util.Collections;
import java.util.List;

final class b implements e {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.exoplayer2.p.b[] f11136a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f11137b;

    public b(com.google.android.exoplayer2.p.b[] bVarArr, long[] jArr) {
        this.f11136a = bVarArr;
        this.f11137b = jArr;
    }

    public int a(long j) {
        int b2 = v.b(this.f11137b, j, false, false);
        if (b2 < this.f11137b.length) {
            return b2;
        }
        return -1;
    }

    public int b() {
        return this.f11137b.length;
    }

    public long a(int i) {
        boolean z = true;
        a.a(i >= 0);
        if (i >= this.f11137b.length) {
            z = false;
        }
        a.a(z);
        return this.f11137b[i];
    }

    public List<com.google.android.exoplayer2.p.b> b(long j) {
        int a2 = v.a(this.f11137b, j, true, false);
        if (a2 != -1) {
            com.google.android.exoplayer2.p.b[] bVarArr = this.f11136a;
            if (bVarArr[a2] != null) {
                return Collections.singletonList(bVarArr[a2]);
            }
        }
        return Collections.emptyList();
    }
}
