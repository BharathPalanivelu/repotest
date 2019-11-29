package com.google.android.exoplayer2.e.c;

import com.google.android.exoplayer2.e.c.b;
import com.google.android.exoplayer2.e.k;
import com.google.android.exoplayer2.n.t;
import com.path.android.jobqueue.JobManager;

final class c implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private final long[] f9381a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f9382b;

    /* renamed from: c  reason: collision with root package name */
    private final long f9383c;

    public boolean a() {
        return true;
    }

    public static c a(k kVar, com.google.android.exoplayer2.n.k kVar2, long j, long j2) {
        int i;
        long j3;
        k kVar3 = kVar;
        com.google.android.exoplayer2.n.k kVar4 = kVar2;
        long j4 = j2;
        kVar4.d(10);
        int n = kVar2.n();
        c cVar = null;
        if (n <= 0) {
            return null;
        }
        int i2 = kVar3.f9775d;
        long a2 = t.a((long) n, JobManager.NS_PER_MS * ((long) (i2 >= 32000 ? 1152 : 576)), (long) i2);
        int h = kVar2.h();
        int h2 = kVar2.h();
        int h3 = kVar2.h();
        kVar4.d(2);
        long j5 = j + ((long) kVar3.f9774c);
        int i3 = h + 1;
        long[] jArr = new long[i3];
        long[] jArr2 = new long[i3];
        jArr[0] = 0;
        jArr2[0] = j5;
        int i4 = 1;
        long j6 = j5;
        int i5 = 1;
        while (i5 < jArr.length) {
            if (h3 == i4) {
                i = kVar2.g();
            } else if (h3 == 2) {
                i = kVar2.h();
            } else if (h3 == 3) {
                i = kVar2.k();
            } else if (h3 != 4) {
                return cVar;
            } else {
                i = kVar2.t();
            }
            long j7 = a2;
            long j8 = ((long) (i * h2)) + j6;
            int i6 = h2;
            jArr[i5] = (((long) i5) * j7) / ((long) h);
            if (j4 == -1) {
                j3 = j8;
            } else {
                j3 = Math.min(j4, j8);
            }
            jArr2[i5] = j3;
            i5++;
            j6 = j8;
            h2 = i6;
            a2 = j7;
            cVar = null;
            i4 = 1;
        }
        return new c(jArr, jArr2, a2);
    }

    private c(long[] jArr, long[] jArr2, long j) {
        this.f9381a = jArr;
        this.f9382b = jArr2;
        this.f9383c = j;
    }

    public long b(long j) {
        return this.f9382b[t.a(this.f9381a, j, true, true)];
    }

    public long a(long j) {
        return this.f9381a[t.a(this.f9382b, j, true, true)];
    }

    public long b() {
        return this.f9383c;
    }
}
