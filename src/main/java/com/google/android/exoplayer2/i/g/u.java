package com.google.android.exoplayer2.i.g;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.i.e;
import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.g.v;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.s.k;
import com.google.android.exoplayer2.s.l;
import com.google.android.exoplayer2.s.s;
import com.google.android.exoplayer2.s.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class u implements e {

    /* renamed from: a  reason: collision with root package name */
    public static final h f10364a = new h() {
        public e[] a() {
            return new e[]{new u()};
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final long f10365b = ((long) v.g("AC-3"));
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final long f10366c = ((long) v.g("EAC3"));
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final long f10367d = ((long) v.g("HEVC"));
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final int f10368e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final List<s> f10369f;

    /* renamed from: g  reason: collision with root package name */
    private final l f10370g;
    private final SparseIntArray h;
    /* access modifiers changed from: private */
    public final v.c i;
    /* access modifiers changed from: private */
    public final SparseArray<v> j;
    /* access modifiers changed from: private */
    public final SparseBooleanArray k;
    /* access modifiers changed from: private */
    public g l;
    /* access modifiers changed from: private */
    public int m;
    /* access modifiers changed from: private */
    public boolean n;
    /* access modifiers changed from: private */
    public v o;

    public void c() {
    }

    static /* synthetic */ int b(u uVar) {
        int i2 = uVar.m;
        uVar.m = i2 + 1;
        return i2;
    }

    public u() {
        this(0);
    }

    public u(int i2) {
        this(1, i2);
    }

    public u(int i2, int i3) {
        this(i2, new s(0), new e(i3));
    }

    public u(int i2, s sVar, v.c cVar) {
        this.i = (v.c) com.google.android.exoplayer2.s.a.a(cVar);
        this.f10368e = i2;
        if (i2 == 1 || i2 == 2) {
            this.f10369f = Collections.singletonList(sVar);
        } else {
            this.f10369f = new ArrayList();
            this.f10369f.add(sVar);
        }
        this.f10370g = new l(9400);
        this.k = new SparseBooleanArray();
        this.j = new SparseArray<>();
        this.h = new SparseIntArray();
        e();
    }

    public boolean a(f fVar) throws IOException, InterruptedException {
        byte[] bArr = this.f10370g.f11422a;
        fVar.c(bArr, 0, 940);
        int i2 = 0;
        while (i2 < 188) {
            int i3 = 0;
            while (i3 != 5) {
                if (bArr[(i3 * 188) + i2] != 71) {
                    i2++;
                } else {
                    i3++;
                }
            }
            fVar.b(i2);
            return true;
        }
        return false;
    }

    public void a(g gVar) {
        this.l = gVar;
        gVar.a(new l.a(-9223372036854775807L));
    }

    public void a(long j2, long j3) {
        int size = this.f10369f.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f10369f.get(i2).d();
        }
        this.f10370g.a();
        this.h.clear();
        e();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b5, code lost:
        if (r11 != ((r7 + 1) & 15)) goto L_0x00b9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(com.google.android.exoplayer2.i.f r10, com.google.android.exoplayer2.i.k r11) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r9 = this;
            com.google.android.exoplayer2.s.l r11 = r9.f10370g
            byte[] r11 = r11.f11422a
            com.google.android.exoplayer2.s.l r0 = r9.f10370g
            int r0 = r0.d()
            int r0 = 9400 - r0
            r1 = 188(0xbc, float:2.63E-43)
            r2 = 0
            if (r0 >= r1) goto L_0x0027
            com.google.android.exoplayer2.s.l r0 = r9.f10370g
            int r0 = r0.b()
            if (r0 <= 0) goto L_0x0022
            com.google.android.exoplayer2.s.l r3 = r9.f10370g
            int r3 = r3.d()
            java.lang.System.arraycopy(r11, r3, r11, r2, r0)
        L_0x0022:
            com.google.android.exoplayer2.s.l r3 = r9.f10370g
            r3.a((byte[]) r11, (int) r0)
        L_0x0027:
            com.google.android.exoplayer2.s.l r0 = r9.f10370g
            int r0 = r0.b()
            if (r0 >= r1) goto L_0x0046
            com.google.android.exoplayer2.s.l r0 = r9.f10370g
            int r0 = r0.c()
            int r3 = 9400 - r0
            int r3 = r10.a(r11, r0, r3)
            r4 = -1
            if (r3 != r4) goto L_0x003f
            return r4
        L_0x003f:
            com.google.android.exoplayer2.s.l r4 = r9.f10370g
            int r0 = r0 + r3
            r4.b(r0)
            goto L_0x0027
        L_0x0046:
            com.google.android.exoplayer2.s.l r10 = r9.f10370g
            int r10 = r10.c()
            com.google.android.exoplayer2.s.l r0 = r9.f10370g
            int r0 = r0.d()
        L_0x0052:
            if (r0 >= r10) goto L_0x005d
            byte r3 = r11[r0]
            r4 = 71
            if (r3 == r4) goto L_0x005d
            int r0 = r0 + 1
            goto L_0x0052
        L_0x005d:
            com.google.android.exoplayer2.s.l r11 = r9.f10370g
            r11.c(r0)
            int r0 = r0 + r1
            if (r0 <= r10) goto L_0x0066
            return r2
        L_0x0066:
            com.google.android.exoplayer2.s.l r11 = r9.f10370g
            int r11 = r11.n()
            r1 = 8388608(0x800000, float:1.17549435E-38)
            r1 = r1 & r11
            if (r1 == 0) goto L_0x0077
            com.google.android.exoplayer2.s.l r10 = r9.f10370g
            r10.c(r0)
            return r2
        L_0x0077:
            r1 = 4194304(0x400000, float:5.877472E-39)
            r1 = r1 & r11
            r3 = 1
            if (r1 == 0) goto L_0x007f
            r1 = 1
            goto L_0x0080
        L_0x007f:
            r1 = 0
        L_0x0080:
            r4 = 2096896(0x1fff00, float:2.938377E-39)
            r4 = r4 & r11
            int r4 = r4 >> 8
            r5 = r11 & 32
            if (r5 == 0) goto L_0x008c
            r5 = 1
            goto L_0x008d
        L_0x008c:
            r5 = 0
        L_0x008d:
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0093
            r6 = 1
            goto L_0x0094
        L_0x0093:
            r6 = 0
        L_0x0094:
            int r7 = r9.f10368e
            r8 = 2
            if (r7 == r8) goto L_0x00b8
            r11 = r11 & 15
            android.util.SparseIntArray r7 = r9.h
            int r8 = r11 + -1
            int r7 = r7.get(r4, r8)
            android.util.SparseIntArray r8 = r9.h
            r8.put(r4, r11)
            if (r7 != r11) goto L_0x00b2
            if (r6 == 0) goto L_0x00b8
            com.google.android.exoplayer2.s.l r10 = r9.f10370g
            r10.c(r0)
            return r2
        L_0x00b2:
            int r7 = r7 + r3
            r7 = r7 & 15
            if (r11 == r7) goto L_0x00b8
            goto L_0x00b9
        L_0x00b8:
            r3 = 0
        L_0x00b9:
            if (r5 == 0) goto L_0x00c6
            com.google.android.exoplayer2.s.l r11 = r9.f10370g
            int r11 = r11.g()
            com.google.android.exoplayer2.s.l r5 = r9.f10370g
            r5.d(r11)
        L_0x00c6:
            if (r6 == 0) goto L_0x00e6
            android.util.SparseArray<com.google.android.exoplayer2.i.g.v> r11 = r9.j
            java.lang.Object r11 = r11.get(r4)
            com.google.android.exoplayer2.i.g.v r11 = (com.google.android.exoplayer2.i.g.v) r11
            if (r11 == 0) goto L_0x00e6
            if (r3 == 0) goto L_0x00d7
            r11.a()
        L_0x00d7:
            com.google.android.exoplayer2.s.l r3 = r9.f10370g
            r3.b(r0)
            com.google.android.exoplayer2.s.l r3 = r9.f10370g
            r11.a(r3, r1)
            com.google.android.exoplayer2.s.l r11 = r9.f10370g
            r11.b(r10)
        L_0x00e6:
            com.google.android.exoplayer2.s.l r10 = r9.f10370g
            r10.c(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.i.g.u.a(com.google.android.exoplayer2.i.f, com.google.android.exoplayer2.i.k):int");
    }

    private void e() {
        this.k.clear();
        this.j.clear();
        SparseArray<v> a2 = this.i.a();
        int size = a2.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.j.put(a2.keyAt(i2), a2.valueAt(i2));
        }
        this.j.put(0, new r(new a()));
        this.o = null;
    }

    private class a implements q {

        /* renamed from: b  reason: collision with root package name */
        private final k f10372b = new k(new byte[4]);

        public void a(s sVar, g gVar, v.d dVar) {
        }

        public a() {
        }

        public void a(com.google.android.exoplayer2.s.l lVar) {
            if (lVar.g() == 0) {
                lVar.d(7);
                int b2 = lVar.b() / 4;
                for (int i = 0; i < b2; i++) {
                    lVar.a(this.f10372b, 4);
                    int c2 = this.f10372b.c(16);
                    this.f10372b.b(3);
                    if (c2 == 0) {
                        this.f10372b.b(13);
                    } else {
                        int c3 = this.f10372b.c(13);
                        u.this.j.put(c3, new r(new b(c3)));
                        u.b(u.this);
                    }
                }
                if (u.this.f10368e != 2) {
                    u.this.j.remove(0);
                }
            }
        }
    }

    private class b implements q {

        /* renamed from: b  reason: collision with root package name */
        private final k f10374b = new k(new byte[5]);

        /* renamed from: c  reason: collision with root package name */
        private final SparseArray<v> f10375c = new SparseArray<>();

        /* renamed from: d  reason: collision with root package name */
        private final SparseIntArray f10376d = new SparseIntArray();

        /* renamed from: e  reason: collision with root package name */
        private final int f10377e;

        public void a(s sVar, g gVar, v.d dVar) {
        }

        public b(int i) {
            this.f10377e = i;
        }

        public void a(com.google.android.exoplayer2.s.l lVar) {
            s sVar;
            v vVar;
            com.google.android.exoplayer2.s.l lVar2 = lVar;
            if (lVar.g() == 2) {
                int i = 0;
                if (u.this.f10368e == 1 || u.this.f10368e == 2 || u.this.m == 1) {
                    sVar = (s) u.this.f10369f.get(0);
                } else {
                    sVar = new s(((s) u.this.f10369f.get(0)).a());
                    u.this.f10369f.add(sVar);
                }
                lVar2.d(2);
                int h = lVar.h();
                int i2 = 5;
                lVar2.d(5);
                lVar2.a(this.f10374b, 2);
                int i3 = 4;
                this.f10374b.b(4);
                lVar2.d(this.f10374b.c(12));
                if (u.this.f10368e == 2 && u.this.o == null) {
                    v.b bVar = new v.b(21, (String) null, (List<v.a>) null, new byte[0]);
                    u uVar = u.this;
                    v unused = uVar.o = uVar.i.a(21, bVar);
                    u.this.o.a(sVar, u.this.l, new v.d(h, 21, 8192));
                }
                this.f10375c.clear();
                this.f10376d.clear();
                int b2 = lVar.b();
                while (b2 > 0) {
                    lVar2.a(this.f10374b, i2);
                    int c2 = this.f10374b.c(8);
                    this.f10374b.b(3);
                    int c3 = this.f10374b.c(13);
                    this.f10374b.b(i3);
                    int c4 = this.f10374b.c(12);
                    v.b a2 = a(lVar2, c4);
                    if (c2 == 6) {
                        c2 = a2.f10381a;
                    }
                    b2 -= c4 + 5;
                    int i4 = u.this.f10368e == 2 ? c2 : c3;
                    if (!u.this.k.get(i4)) {
                        if (u.this.f10368e == 2 && c2 == 21) {
                            vVar = u.this.o;
                        } else {
                            vVar = u.this.i.a(c2, a2);
                        }
                        if (u.this.f10368e != 2 || c3 < this.f10376d.get(i4, 8192)) {
                            this.f10376d.put(i4, c3);
                            this.f10375c.put(i4, vVar);
                        }
                    }
                    i2 = 5;
                    i3 = 4;
                }
                int size = this.f10376d.size();
                for (int i5 = 0; i5 < size; i5++) {
                    int keyAt = this.f10376d.keyAt(i5);
                    u.this.k.put(keyAt, true);
                    v valueAt = this.f10375c.valueAt(i5);
                    if (valueAt != null) {
                        if (valueAt != u.this.o) {
                            valueAt.a(sVar, u.this.l, new v.d(h, keyAt, 8192));
                        }
                        u.this.j.put(this.f10376d.valueAt(i5), valueAt);
                    }
                }
                if (u.this.f10368e != 2) {
                    u.this.j.remove(this.f10377e);
                    u uVar2 = u.this;
                    if (uVar2.f10368e != 1) {
                        i = u.this.m - 1;
                    }
                    int unused2 = uVar2.m = i;
                    if (u.this.m == 0) {
                        u.this.l.a();
                        boolean unused3 = u.this.n = true;
                    }
                } else if (!u.this.n) {
                    u.this.l.a();
                    int unused4 = u.this.m = 0;
                    boolean unused5 = u.this.n = true;
                }
            }
        }

        private v.b a(com.google.android.exoplayer2.s.l lVar, int i) {
            int d2 = lVar.d();
            int i2 = i + d2;
            String str = null;
            int i3 = -1;
            ArrayList arrayList = null;
            while (lVar.d() < i2) {
                int g2 = lVar.g();
                int d3 = lVar.d() + lVar.g();
                if (g2 == 5) {
                    long l = lVar.l();
                    if (l != u.f10365b) {
                        if (l != u.f10366c) {
                            if (l == u.f10367d) {
                                i3 = 36;
                            }
                            lVar.d(d3 - lVar.d());
                        }
                        i3 = 135;
                        lVar.d(d3 - lVar.d());
                    }
                } else if (g2 != 106) {
                    if (g2 != 122) {
                        if (g2 == 123) {
                            i3 = 138;
                        } else if (g2 == 10) {
                            str = lVar.e(3).trim();
                        } else if (g2 == 89) {
                            ArrayList arrayList2 = new ArrayList();
                            while (lVar.d() < d3) {
                                String trim = lVar.e(3).trim();
                                int g3 = lVar.g();
                                byte[] bArr = new byte[4];
                                lVar.a(bArr, 0, 4);
                                arrayList2.add(new v.a(trim, g3, bArr));
                            }
                            arrayList = arrayList2;
                            i3 = 89;
                        }
                        lVar.d(d3 - lVar.d());
                    }
                    i3 = 135;
                    lVar.d(d3 - lVar.d());
                }
                i3 = 129;
                lVar.d(d3 - lVar.d());
            }
            lVar.c(i2);
            return new v.b(i3, str, arrayList, Arrays.copyOfRange(lVar.f11422a, d2, i2));
        }
    }
}
