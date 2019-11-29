package com.google.android.exoplayer2.e.g;

import android.util.Pair;
import com.google.android.exoplayer2.e.g.v;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.n.k;
import java.util.Arrays;

public final class i implements h {

    /* renamed from: c  reason: collision with root package name */
    private static final double[] f9633c = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: a  reason: collision with root package name */
    private String f9634a;

    /* renamed from: b  reason: collision with root package name */
    private n f9635b;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9636d;

    /* renamed from: e  reason: collision with root package name */
    private long f9637e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean[] f9638f = new boolean[4];

    /* renamed from: g  reason: collision with root package name */
    private final a f9639g = new a(128);
    private boolean h;
    private long i;
    private long j;
    private boolean k;
    private boolean l;
    private long m;
    private long n;

    public void b() {
    }

    public void a() {
        com.google.android.exoplayer2.n.i.a(this.f9638f);
        this.f9639g.a();
        this.k = false;
        this.h = false;
        this.i = 0;
    }

    public void a(h hVar, v.d dVar) {
        dVar.a();
        this.f9634a = dVar.c();
        this.f9635b = hVar.a(dVar.b(), 2);
    }

    public void a(long j2, boolean z) {
        this.k = j2 != -9223372036854775807L;
        if (this.k) {
            this.j = j2;
        }
    }

    public void a(k kVar) {
        byte b2;
        k kVar2 = kVar;
        int d2 = kVar.d();
        int c2 = kVar.c();
        byte[] bArr = kVar2.f10948a;
        this.i += (long) kVar.b();
        this.f9635b.a(kVar2, kVar.b());
        int i2 = d2;
        while (true) {
            int a2 = com.google.android.exoplayer2.n.i.a(bArr, d2, c2, this.f9638f);
            if (a2 == c2) {
                break;
            }
            int i3 = a2 + 3;
            byte b3 = kVar2.f10948a[i3] & 255;
            if (!this.f9636d) {
                int i4 = a2 - i2;
                if (i4 > 0) {
                    this.f9639g.a(bArr, i2, a2);
                }
                if (this.f9639g.a(b3, i4 < 0 ? -i4 : 0)) {
                    Pair<j, Long> a3 = a(this.f9639g, this.f9634a);
                    this.f9635b.a((j) a3.first);
                    this.f9637e = ((Long) a3.second).longValue();
                    this.f9636d = true;
                }
            }
            if (this.f9636d && (b3 == 184 || b3 == 0)) {
                int i5 = c2 - a2;
                if (this.h) {
                    this.f9635b.a(this.n, this.l ? 1 : 0, ((int) (this.i - this.m)) - i5, i5, (byte[]) null);
                    this.l = false;
                    b2 = b3;
                } else {
                    b2 = b3;
                }
                if (b2 == 184) {
                    this.h = false;
                    this.l = true;
                } else {
                    this.n = this.k ? this.j : this.n + this.f9637e;
                    this.m = this.i - ((long) i5);
                    this.k = false;
                    this.h = true;
                }
            }
            i2 = a2;
            d2 = i3;
        }
        if (!this.f9636d) {
            this.f9639g.a(bArr, i2, c2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.util.Pair<com.google.android.exoplayer2.j, java.lang.Long> a(com.google.android.exoplayer2.e.g.i.a r20, java.lang.String r21) {
        /*
            r0 = r20
            byte[] r1 = r0.f9642c
            int r2 = r0.f9640a
            byte[] r1 = java.util.Arrays.copyOf(r1, r2)
            r2 = 4
            byte r3 = r1[r2]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r4 = 5
            byte r5 = r1[r4]
            r5 = r5 & 255(0xff, float:3.57E-43)
            r6 = 6
            byte r6 = r1[r6]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r3 = r3 << r2
            int r7 = r5 >> 4
            r13 = r3 | r7
            r3 = r5 & 15
            int r3 = r3 << 8
            r14 = r3 | r6
            r3 = 7
            byte r5 = r1[r3]
            r5 = r5 & 240(0xf0, float:3.36E-43)
            int r5 = r5 >> r2
            r6 = 2
            if (r5 == r6) goto L_0x0043
            r6 = 3
            if (r5 == r6) goto L_0x003d
            if (r5 == r2) goto L_0x0037
            r2 = 1065353216(0x3f800000, float:1.0)
            r18 = 1065353216(0x3f800000, float:1.0)
            goto L_0x004c
        L_0x0037:
            int r2 = r14 * 121
            float r2 = (float) r2
            int r5 = r13 * 100
            goto L_0x0048
        L_0x003d:
            int r2 = r14 * 16
            float r2 = (float) r2
            int r5 = r13 * 9
            goto L_0x0048
        L_0x0043:
            int r2 = r14 * 4
            float r2 = (float) r2
            int r5 = r13 * 3
        L_0x0048:
            float r5 = (float) r5
            float r2 = r2 / r5
            r18 = r2
        L_0x004c:
            r10 = 0
            r11 = -1
            r12 = -1
            r15 = -1082130432(0xffffffffbf800000, float:-1.0)
            java.util.List r16 = java.util.Collections.singletonList(r1)
            r17 = -1
            r19 = 0
            java.lang.String r9 = "video/mpeg2"
            r8 = r21
            com.google.android.exoplayer2.j r2 = com.google.android.exoplayer2.j.a((java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (int) r11, (int) r12, (int) r13, (int) r14, (float) r15, (java.util.List<byte[]>) r16, (int) r17, (float) r18, (com.google.android.exoplayer2.c.a) r19)
            r5 = 0
            byte r3 = r1[r3]
            r3 = r3 & 15
            int r3 = r3 + -1
            if (r3 < 0) goto L_0x0098
            double[] r7 = f9633c
            int r8 = r7.length
            if (r3 >= r8) goto L_0x0098
            r5 = r7[r3]
            int r0 = r0.f9641b
            int r0 = r0 + 9
            byte r3 = r1[r0]
            r3 = r3 & 96
            int r3 = r3 >> r4
            byte r0 = r1[r0]
            r0 = r0 & 31
            if (r3 == r0) goto L_0x0091
            double r3 = (double) r3
            r7 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            java.lang.Double.isNaN(r3)
            double r3 = r3 + r7
            int r0 = r0 + 1
            double r0 = (double) r0
            java.lang.Double.isNaN(r0)
            double r3 = r3 / r0
            double r5 = r5 * r3
        L_0x0091:
            r0 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r0 = r0 / r5
            long r5 = (long) r0
        L_0x0098:
            java.lang.Long r0 = java.lang.Long.valueOf(r5)
            android.util.Pair r0 = android.util.Pair.create(r2, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.g.i.a(com.google.android.exoplayer2.e.g.i$a, java.lang.String):android.util.Pair");
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f9640a;

        /* renamed from: b  reason: collision with root package name */
        public int f9641b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f9642c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f9643d;

        public a(int i) {
            this.f9642c = new byte[i];
        }

        public void a() {
            this.f9643d = false;
            this.f9640a = 0;
            this.f9641b = 0;
        }

        public boolean a(int i, int i2) {
            if (this.f9643d) {
                if (this.f9641b == 0 && i == 181) {
                    this.f9641b = this.f9640a;
                } else {
                    this.f9640a -= i2;
                    this.f9643d = false;
                    return true;
                }
            } else if (i == 179) {
                this.f9643d = true;
            }
            return false;
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.f9643d) {
                int i3 = i2 - i;
                byte[] bArr2 = this.f9642c;
                int length = bArr2.length;
                int i4 = this.f9640a;
                if (length < i4 + i3) {
                    this.f9642c = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.f9642c, this.f9640a, i3);
                this.f9640a += i3;
            }
        }
    }
}
