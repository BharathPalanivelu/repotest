package com.google.android.exoplayer2.l;

import android.os.SystemClock;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.l.f;
import com.google.android.exoplayer2.m.d;
import com.google.android.exoplayer2.source.ac;

public class a extends b {

    /* renamed from: d  reason: collision with root package name */
    private final d f10691d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10692e;

    /* renamed from: f  reason: collision with root package name */
    private final long f10693f;

    /* renamed from: g  reason: collision with root package name */
    private final long f10694g;
    private final long h;
    private final float i;
    private int j = b(Long.MIN_VALUE);
    private int k = 1;

    public Object c() {
        return null;
    }

    /* renamed from: com.google.android.exoplayer2.l.a$a  reason: collision with other inner class name */
    public static final class C0177a implements f.a {

        /* renamed from: a  reason: collision with root package name */
        private final d f10695a;

        /* renamed from: b  reason: collision with root package name */
        private final int f10696b;

        /* renamed from: c  reason: collision with root package name */
        private final int f10697c;

        /* renamed from: d  reason: collision with root package name */
        private final int f10698d;

        /* renamed from: e  reason: collision with root package name */
        private final int f10699e;

        /* renamed from: f  reason: collision with root package name */
        private final float f10700f;

        public C0177a(d dVar) {
            this(dVar, 800000, 10000, 25000, 25000, 0.75f);
        }

        public C0177a(d dVar, int i, int i2, int i3, int i4, float f2) {
            this.f10695a = dVar;
            this.f10696b = i;
            this.f10697c = i2;
            this.f10698d = i3;
            this.f10699e = i4;
            this.f10700f = f2;
        }

        /* renamed from: a */
        public a b(ac acVar, int... iArr) {
            return new a(acVar, iArr, this.f10695a, this.f10696b, (long) this.f10697c, (long) this.f10698d, (long) this.f10699e, this.f10700f);
        }
    }

    public a(ac acVar, int[] iArr, d dVar, int i2, long j2, long j3, long j4, float f2) {
        super(acVar, iArr);
        this.f10691d = dVar;
        this.f10692e = i2;
        this.f10693f = j2 * 1000;
        this.f10694g = j3 * 1000;
        this.h = j4 * 1000;
        this.i = f2;
    }

    public void a(long j2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i2 = this.j;
        j f2 = f();
        int b2 = b(elapsedRealtime);
        j a2 = a(b2);
        this.j = b2;
        if (f2 != null && !b(this.j, elapsedRealtime)) {
            if (a2.f10423b > f2.f10423b && j2 < this.f10693f) {
                this.j = i2;
            } else if (a2.f10423b < f2.f10423b && j2 >= this.f10694g) {
                this.j = i2;
            }
        }
        if (this.j != i2) {
            this.k = 3;
        }
    }

    public int a() {
        return this.j;
    }

    public int b() {
        return this.k;
    }

    private int b(long j2) {
        long a2 = this.f10691d.a();
        long j3 = a2 == -1 ? (long) this.f10692e : (long) (((float) a2) * this.i);
        int i2 = 0;
        for (int i3 = 0; i3 < this.f10702b; i3++) {
            if (j2 == Long.MIN_VALUE || !b(i3, j2)) {
                if (((long) a(i3).f10423b) <= j3) {
                    return i3;
                }
                i2 = i3;
            }
        }
        return i2;
    }
}
