package com.google.android.exoplayer2.q;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.q.f;
import com.google.android.exoplayer2.r.d;
import com.google.android.exoplayer2.source.o;

public class a extends b {

    /* renamed from: d  reason: collision with root package name */
    private final d f11240d;

    /* renamed from: e  reason: collision with root package name */
    private final int f11241e;

    /* renamed from: f  reason: collision with root package name */
    private final long f11242f;

    /* renamed from: g  reason: collision with root package name */
    private final long f11243g;
    private final long h;
    private final float i;
    private int j = b(Long.MIN_VALUE);
    private int k = 1;

    public Object c() {
        return null;
    }

    /* renamed from: com.google.android.exoplayer2.q.a$a  reason: collision with other inner class name */
    public static final class C0184a implements f.a {

        /* renamed from: a  reason: collision with root package name */
        private final d f11244a;

        /* renamed from: b  reason: collision with root package name */
        private final int f11245b;

        /* renamed from: c  reason: collision with root package name */
        private final int f11246c;

        /* renamed from: d  reason: collision with root package name */
        private final int f11247d;

        /* renamed from: e  reason: collision with root package name */
        private final int f11248e;

        /* renamed from: f  reason: collision with root package name */
        private final float f11249f;

        public C0184a(d dVar) {
            this(dVar, 800000, 10000, 25000, 25000, 0.75f);
        }

        public C0184a(d dVar, int i, int i2, int i3, int i4, float f2) {
            this.f11244a = dVar;
            this.f11245b = i;
            this.f11246c = i2;
            this.f11247d = i3;
            this.f11248e = i4;
            this.f11249f = f2;
        }

        /* renamed from: a */
        public a b(o oVar, int... iArr) {
            return new a(oVar, iArr, this.f11244a, this.f11245b, (long) this.f11246c, (long) this.f11247d, (long) this.f11248e, this.f11249f);
        }
    }

    public a(o oVar, int[] iArr, d dVar, int i2, long j2, long j3, long j4, float f2) {
        super(oVar, iArr);
        this.f11240d = dVar;
        this.f11241e = i2;
        this.f11242f = j2 * 1000;
        this.f11243g = j3 * 1000;
        this.h = j4 * 1000;
        this.i = f2;
    }

    public void a(long j2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i2 = this.j;
        this.j = b(elapsedRealtime);
        if (this.j != i2) {
            if (!b(i2, elapsedRealtime)) {
                Format a2 = a(i2);
                Format a3 = a(this.j);
                if (a3.f8954b > a2.f8954b && j2 < this.f11242f) {
                    this.j = i2;
                } else if (a3.f8954b < a2.f8954b && j2 >= this.f11243g) {
                    this.j = i2;
                }
            }
            if (this.j != i2) {
                this.k = 3;
            }
        }
    }

    public int a() {
        return this.j;
    }

    public int b() {
        return this.k;
    }

    private int b(long j2) {
        long a2 = this.f11240d.a();
        long j3 = a2 == -1 ? (long) this.f11241e : (long) (((float) a2) * this.i);
        int i2 = 0;
        for (int i3 = 0; i3 < this.f11251b; i3++) {
            if (j2 == Long.MIN_VALUE || !b(i3, j2)) {
                if (((long) a(i3).f8954b) <= j3) {
                    return i3;
                }
                i2 = i3;
            }
        }
        return i2;
    }
}
