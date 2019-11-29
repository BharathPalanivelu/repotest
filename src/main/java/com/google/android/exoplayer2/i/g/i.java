package com.google.android.exoplayer2.i.g;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.g.v;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.s.j;
import com.google.android.exoplayer2.s.l;
import java.util.Arrays;

public final class i implements h {

    /* renamed from: c  reason: collision with root package name */
    private static final double[] f10267c = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: a  reason: collision with root package name */
    private String f10268a;

    /* renamed from: b  reason: collision with root package name */
    private m f10269b;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10270d;

    /* renamed from: e  reason: collision with root package name */
    private long f10271e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean[] f10272f = new boolean[4];

    /* renamed from: g  reason: collision with root package name */
    private final a f10273g = new a(128);
    private long h;
    private boolean i;
    private long j;
    private long k;
    private long l;
    private boolean m;
    private boolean n;

    public void b() {
    }

    public void a() {
        j.a(this.f10272f);
        this.f10273g.a();
        this.h = 0;
        this.i = false;
    }

    public void a(g gVar, v.d dVar) {
        dVar.a();
        this.f10268a = dVar.c();
        this.f10269b = gVar.a(dVar.b(), 2);
    }

    public void a(long j2, boolean z) {
        this.j = j2;
    }

    public void a(l lVar) {
        boolean z;
        l lVar2 = lVar;
        int d2 = lVar.d();
        int c2 = lVar.c();
        byte[] bArr = lVar2.f11422a;
        this.h += (long) lVar.b();
        this.f10269b.a(lVar2, lVar.b());
        while (true) {
            int a2 = j.a(bArr, d2, c2, this.f10272f);
            if (a2 == c2) {
                break;
            }
            int i2 = a2 + 3;
            byte b2 = lVar2.f11422a[i2] & 255;
            if (!this.f10270d) {
                int i3 = a2 - d2;
                if (i3 > 0) {
                    this.f10273g.a(bArr, d2, a2);
                }
                if (this.f10273g.a(b2, i3 < 0 ? -i3 : 0)) {
                    Pair<Format, Long> a3 = a(this.f10273g, this.f10268a);
                    this.f10269b.a((Format) a3.first);
                    this.f10271e = ((Long) a3.second).longValue();
                    this.f10270d = true;
                }
            }
            if (b2 == 0 || b2 == 179) {
                int i4 = c2 - a2;
                if (this.i && this.n && this.f10270d) {
                    this.f10269b.a(this.l, this.m ? 1 : 0, ((int) (this.h - this.k)) - i4, i4, (m.a) null);
                }
                if (!this.i || this.n) {
                    this.k = this.h - ((long) i4);
                    long j2 = this.j;
                    if (j2 == -9223372036854775807L) {
                        j2 = this.i ? this.l + this.f10271e : 0;
                    }
                    this.l = j2;
                    z = false;
                    this.m = false;
                    this.j = -9223372036854775807L;
                    this.i = true;
                } else {
                    z = false;
                }
                if (b2 == 0) {
                    z = true;
                }
                this.n = z;
            } else if (b2 == 184) {
                this.m = true;
            }
            d2 = i2;
        }
        if (!this.f10270d) {
            this.f10273g.a(bArr, d2, c2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.util.Pair<com.google.android.exoplayer2.Format, java.lang.Long> a(com.google.android.exoplayer2.i.g.i.a r20, java.lang.String r21) {
        /*
            r0 = r20
            byte[] r1 = r0.f10277c
            int r2 = r0.f10275a
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
            com.google.android.exoplayer2.Format r2 = com.google.android.exoplayer2.Format.a((java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (int) r11, (int) r12, (int) r13, (int) r14, (float) r15, (java.util.List<byte[]>) r16, (int) r17, (float) r18, (com.google.android.exoplayer2.drm.DrmInitData) r19)
            r5 = 0
            byte r3 = r1[r3]
            r3 = r3 & 15
            int r3 = r3 + -1
            if (r3 < 0) goto L_0x0098
            double[] r7 = f10267c
            int r8 = r7.length
            if (r3 >= r8) goto L_0x0098
            r5 = r7[r3]
            int r0 = r0.f10276b
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.i.g.i.a(com.google.android.exoplayer2.i.g.i$a, java.lang.String):android.util.Pair");
    }

    private static final class a {

        /* renamed from: d  reason: collision with root package name */
        private static final byte[] f10274d = {0, 0, 1};

        /* renamed from: a  reason: collision with root package name */
        public int f10275a;

        /* renamed from: b  reason: collision with root package name */
        public int f10276b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f10277c;

        /* renamed from: e  reason: collision with root package name */
        private boolean f10278e;

        public a(int i) {
            this.f10277c = new byte[i];
        }

        public void a() {
            this.f10278e = false;
            this.f10275a = 0;
            this.f10276b = 0;
        }

        public boolean a(int i, int i2) {
            if (this.f10278e) {
                this.f10275a -= i2;
                if (this.f10276b == 0 && i == 181) {
                    this.f10276b = this.f10275a;
                } else {
                    this.f10278e = false;
                    return true;
                }
            } else if (i == 179) {
                this.f10278e = true;
            }
            byte[] bArr = f10274d;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.f10278e) {
                int i3 = i2 - i;
                byte[] bArr2 = this.f10277c;
                int length = bArr2.length;
                int i4 = this.f10275a;
                if (length < i4 + i3) {
                    this.f10277c = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.f10277c, this.f10275a, i3);
                this.f10275a += i3;
            }
        }
    }
}
