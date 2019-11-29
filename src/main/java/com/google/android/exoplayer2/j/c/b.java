package com.google.android.exoplayer2.j.c;

import com.google.android.exoplayer2.j.a;
import com.google.android.exoplayer2.j.d;
import com.google.android.exoplayer2.n.t;
import java.util.Collections;
import java.util.List;

final class b implements d {

    /* renamed from: a  reason: collision with root package name */
    private final a[] f10531a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f10532b;

    public b(a[] aVarArr, long[] jArr) {
        this.f10531a = aVarArr;
        this.f10532b = jArr;
    }

    public int a(long j) {
        int b2 = t.b(this.f10532b, j, false, false);
        if (b2 < this.f10532b.length) {
            return b2;
        }
        return -1;
    }

    public int i_() {
        return this.f10532b.length;
    }

    public long a(int i) {
        boolean z = true;
        com.google.android.exoplayer2.n.a.a(i >= 0);
        if (i >= this.f10532b.length) {
            z = false;
        }
        com.google.android.exoplayer2.n.a.a(z);
        return this.f10532b[i];
    }

    public List<a> b(long j) {
        int a2 = t.a(this.f10532b, j, true, false);
        if (a2 != -1) {
            a[] aVarArr = this.f10531a;
            if (aVarArr[a2] != null) {
                return Collections.singletonList(aVarArr[a2]);
            }
        }
        return Collections.emptyList();
    }
}
