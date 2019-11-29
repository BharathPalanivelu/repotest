package com.google.android.exoplayer2.e.c;

import com.google.android.exoplayer2.e.c.b;
import com.google.android.exoplayer2.e.k;
import com.google.android.exoplayer2.n.t;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.path.android.jobqueue.JobManager;

final class d implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private final long f9384a;

    /* renamed from: b  reason: collision with root package name */
    private final long f9385b;

    /* renamed from: c  reason: collision with root package name */
    private final long f9386c;

    /* renamed from: d  reason: collision with root package name */
    private final long[] f9387d;

    /* renamed from: e  reason: collision with root package name */
    private final long f9388e;

    /* renamed from: f  reason: collision with root package name */
    private final int f9389f;

    public static d a(k kVar, com.google.android.exoplayer2.n.k kVar2, long j, long j2) {
        k kVar3 = kVar;
        int i = kVar3.f9778g;
        int i2 = kVar3.f9775d;
        long j3 = j + ((long) kVar3.f9774c);
        int n = kVar2.n();
        if ((n & 1) != 1) {
            return null;
        }
        int t = kVar2.t();
        if (t == 0) {
            return null;
        }
        long a2 = t.a((long) t, ((long) i) * JobManager.NS_PER_MS, (long) i2);
        if ((n & 6) != 6) {
            return new d(j3, a2, j2);
        }
        long t2 = (long) kVar2.t();
        kVar2.d(1);
        long[] jArr = new long[99];
        for (int i3 = 0; i3 < 99; i3++) {
            jArr[i3] = (long) kVar2.g();
        }
        return new d(j3, a2, j2, jArr, t2, kVar3.f9774c);
    }

    private d(long j, long j2, long j3) {
        this(j, j2, j3, (long[]) null, 0, 0);
    }

    private d(long j, long j2, long j3, long[] jArr, long j4, int i) {
        this.f9384a = j;
        this.f9385b = j2;
        this.f9386c = j3;
        this.f9387d = jArr;
        this.f9388e = j4;
        this.f9389f = i;
    }

    public boolean a() {
        return this.f9387d != null;
    }

    public long b(long j) {
        if (!a()) {
            return this.f9384a;
        }
        float f2 = (((float) j) * 100.0f) / ((float) this.f9385b);
        float f3 = 256.0f;
        float f4 = BitmapDescriptorFactory.HUE_RED;
        if (f2 <= BitmapDescriptorFactory.HUE_RED) {
            f3 = BitmapDescriptorFactory.HUE_RED;
        } else if (f2 < 100.0f) {
            int i = (int) f2;
            if (i != 0) {
                f4 = (float) this.f9387d[i - 1];
            }
            if (i < 99) {
                f3 = (float) this.f9387d[i];
            }
            f3 = ((f3 - f4) * (f2 - ((float) i))) + f4;
        }
        double d2 = (double) f3;
        Double.isNaN(d2);
        double d3 = (double) this.f9388e;
        Double.isNaN(d3);
        long round = Math.round(d2 * 0.00390625d * d3);
        long j2 = this.f9384a;
        long j3 = round + j2;
        long j4 = this.f9386c;
        return Math.min(j3, j4 != -1 ? j4 - 1 : ((j2 - ((long) this.f9389f)) + this.f9388e) - 1);
    }

    public long a(long j) {
        long j2;
        long j3;
        long j4 = 0;
        if (a()) {
            long j5 = this.f9384a;
            if (j >= j5) {
                double d2 = (double) (j - j5);
                Double.isNaN(d2);
                double d3 = (double) this.f9388e;
                Double.isNaN(d3);
                double d4 = (d2 * 256.0d) / d3;
                int a2 = t.a(this.f9387d, (long) d4, true, false) + 1;
                long a3 = a(a2);
                if (a2 == 0) {
                    j2 = 0;
                } else {
                    j2 = this.f9387d[a2 - 1];
                }
                if (a2 == 99) {
                    j3 = 256;
                } else {
                    j3 = this.f9387d[a2];
                }
                long a4 = a(a2 + 1);
                if (j3 != j2) {
                    double d5 = (double) (a4 - a3);
                    double d6 = (double) j2;
                    Double.isNaN(d6);
                    Double.isNaN(d5);
                    double d7 = d5 * (d4 - d6);
                    double d8 = (double) (j3 - j2);
                    Double.isNaN(d8);
                    j4 = (long) (d7 / d8);
                }
                return a3 + j4;
            }
        }
        return 0;
    }

    public long b() {
        return this.f9385b;
    }

    private long a(int i) {
        return (this.f9385b * ((long) i)) / 100;
    }
}
