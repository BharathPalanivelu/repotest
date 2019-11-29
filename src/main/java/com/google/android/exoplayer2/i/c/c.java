package com.google.android.exoplayer2.i.c;

import com.google.android.exoplayer2.i.c.b;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.s.l;
import com.google.android.exoplayer2.s.v;
import com.path.android.jobqueue.JobManager;

final class c implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private final long[] f10025a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f10026b;

    /* renamed from: c  reason: collision with root package name */
    private final long f10027c;

    public boolean a() {
        return true;
    }

    public static c a(j jVar, l lVar, long j, long j2) {
        int i;
        long j3;
        j jVar2 = jVar;
        l lVar2 = lVar;
        long j4 = j2;
        lVar2.d(10);
        int n = lVar.n();
        c cVar = null;
        if (n <= 0) {
            return null;
        }
        int i2 = jVar2.f10412d;
        long b2 = v.b((long) n, JobManager.NS_PER_MS * ((long) (i2 >= 32000 ? 1152 : 576)), (long) i2);
        int h = lVar.h();
        int h2 = lVar.h();
        int h3 = lVar.h();
        lVar2.d(2);
        long j5 = j + ((long) jVar2.f10411c);
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
                i = lVar.g();
            } else if (h3 == 2) {
                i = lVar.h();
            } else if (h3 == 3) {
                i = lVar.k();
            } else if (h3 != 4) {
                return cVar;
            } else {
                i = lVar.t();
            }
            long j7 = b2;
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
            b2 = j7;
            cVar = null;
            i4 = 1;
        }
        return new c(jArr, jArr2, b2);
    }

    private c(long[] jArr, long[] jArr2, long j) {
        this.f10025a = jArr;
        this.f10026b = jArr2;
        this.f10027c = j;
    }

    public long b(long j) {
        return this.f10026b[v.a(this.f10025a, j, true, true)];
    }

    public long a(long j) {
        return this.f10025a[v.a(this.f10026b, j, true, true)];
    }

    public long b() {
        return this.f10027c;
    }
}
