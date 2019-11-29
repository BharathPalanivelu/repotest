package com.google.android.exoplayer2.e.g;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.e.f;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.e.g.v;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.e.i;
import com.google.android.exoplayer2.e.m;
import com.google.android.exoplayer2.n.j;
import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.q;
import com.google.android.exoplayer2.n.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class u implements f {

    /* renamed from: a  reason: collision with root package name */
    public static final i f9729a = new i() {
        public f[] a() {
            return new f[]{new u()};
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final long f9730b = ((long) t.g("AC-3"));
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final long f9731c = ((long) t.g("EAC3"));
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final long f9732d = ((long) t.g("HEVC"));
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final int f9733e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final List<q> f9734f;

    /* renamed from: g  reason: collision with root package name */
    private final k f9735g;
    private final j h;
    private final SparseIntArray i;
    /* access modifiers changed from: private */
    public final v.c j;
    /* access modifiers changed from: private */
    public final SparseArray<v> k;
    /* access modifiers changed from: private */
    public final SparseBooleanArray l;
    /* access modifiers changed from: private */
    public h m;
    /* access modifiers changed from: private */
    public int n;
    /* access modifiers changed from: private */
    public boolean o;
    /* access modifiers changed from: private */
    public v p;

    public void c() {
    }

    static /* synthetic */ int b(u uVar) {
        int i2 = uVar.n;
        uVar.n = i2 + 1;
        return i2;
    }

    public u() {
        this(0);
    }

    public u(int i2) {
        this(1, i2);
    }

    public u(int i2, int i3) {
        this(i2, new q(0), new e(i3));
    }

    public u(int i2, q qVar, v.c cVar) {
        this.j = (v.c) com.google.android.exoplayer2.n.a.a(cVar);
        this.f9733e = i2;
        if (i2 == 1 || i2 == 2) {
            this.f9734f = Collections.singletonList(qVar);
        } else {
            this.f9734f = new ArrayList();
            this.f9734f.add(qVar);
        }
        this.f9735g = new k(940);
        this.h = new j(new byte[3]);
        this.l = new SparseBooleanArray();
        this.k = new SparseArray<>();
        this.i = new SparseIntArray();
        e();
    }

    public boolean a(g gVar) throws IOException, InterruptedException {
        byte[] bArr = this.f9735g.f10948a;
        gVar.c(bArr, 0, 940);
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
            gVar.b(i2);
            return true;
        }
        return false;
    }

    public void a(h hVar) {
        this.m = hVar;
        hVar.a(new m.a(-9223372036854775807L));
    }

    public void a(long j2, long j3) {
        int size = this.f9734f.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f9734f.get(i2).d();
        }
        this.f9735g.a();
        this.i.clear();
        e();
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(com.google.android.exoplayer2.e.g r10, com.google.android.exoplayer2.e.l r11) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r9 = this;
            com.google.android.exoplayer2.n.k r11 = r9.f9735g
            byte[] r11 = r11.f10948a
            com.google.android.exoplayer2.n.k r0 = r9.f9735g
            int r0 = r0.d()
            int r0 = 940 - r0
            r1 = 188(0xbc, float:2.63E-43)
            r2 = 0
            if (r0 >= r1) goto L_0x0027
            com.google.android.exoplayer2.n.k r0 = r9.f9735g
            int r0 = r0.b()
            if (r0 <= 0) goto L_0x0022
            com.google.android.exoplayer2.n.k r3 = r9.f9735g
            int r3 = r3.d()
            java.lang.System.arraycopy(r11, r3, r11, r2, r0)
        L_0x0022:
            com.google.android.exoplayer2.n.k r3 = r9.f9735g
            r3.a((byte[]) r11, (int) r0)
        L_0x0027:
            com.google.android.exoplayer2.n.k r0 = r9.f9735g
            int r0 = r0.b()
            if (r0 >= r1) goto L_0x0046
            com.google.android.exoplayer2.n.k r0 = r9.f9735g
            int r0 = r0.c()
            int r3 = 940 - r0
            int r3 = r10.a(r11, r0, r3)
            r4 = -1
            if (r3 != r4) goto L_0x003f
            return r4
        L_0x003f:
            com.google.android.exoplayer2.n.k r4 = r9.f9735g
            int r0 = r0 + r3
            r4.b(r0)
            goto L_0x0027
        L_0x0046:
            com.google.android.exoplayer2.n.k r10 = r9.f9735g
            int r10 = r10.c()
            com.google.android.exoplayer2.n.k r0 = r9.f9735g
            int r0 = r0.d()
        L_0x0052:
            if (r0 >= r10) goto L_0x005d
            byte r3 = r11[r0]
            r4 = 71
            if (r3 == r4) goto L_0x005d
            int r0 = r0 + 1
            goto L_0x0052
        L_0x005d:
            com.google.android.exoplayer2.n.k r11 = r9.f9735g
            r11.c(r0)
            int r0 = r0 + r1
            if (r0 <= r10) goto L_0x0066
            return r2
        L_0x0066:
            com.google.android.exoplayer2.n.k r11 = r9.f9735g
            r1 = 1
            r11.d(r1)
            com.google.android.exoplayer2.n.k r11 = r9.f9735g
            com.google.android.exoplayer2.n.j r3 = r9.h
            r4 = 3
            r11.a((com.google.android.exoplayer2.n.j) r3, (int) r4)
            com.google.android.exoplayer2.n.j r11 = r9.h
            boolean r11 = r11.d()
            if (r11 == 0) goto L_0x0082
            com.google.android.exoplayer2.n.k r10 = r9.f9735g
            r10.c(r0)
            return r2
        L_0x0082:
            com.google.android.exoplayer2.n.j r11 = r9.h
            boolean r11 = r11.d()
            com.google.android.exoplayer2.n.j r3 = r9.h
            r3.b(r1)
            com.google.android.exoplayer2.n.j r3 = r9.h
            r4 = 13
            int r3 = r3.c(r4)
            com.google.android.exoplayer2.n.j r4 = r9.h
            r5 = 2
            r4.b(r5)
            com.google.android.exoplayer2.n.j r4 = r9.h
            boolean r4 = r4.d()
            com.google.android.exoplayer2.n.j r6 = r9.h
            boolean r6 = r6.d()
            com.google.android.exoplayer2.n.j r7 = r9.h
            r8 = 4
            int r7 = r7.c(r8)
            int r8 = r9.f9733e
            if (r8 == r5) goto L_0x00d0
            android.util.SparseIntArray r5 = r9.i
            int r8 = r7 + -1
            int r5 = r5.get(r3, r8)
            android.util.SparseIntArray r8 = r9.i
            r8.put(r3, r7)
            if (r5 != r7) goto L_0x00c9
            if (r6 == 0) goto L_0x00d0
            com.google.android.exoplayer2.n.k r10 = r9.f9735g
            r10.c(r0)
            return r2
        L_0x00c9:
            int r5 = r5 + r1
            int r5 = r5 % 16
            if (r7 == r5) goto L_0x00d0
            r5 = 1
            goto L_0x00d1
        L_0x00d0:
            r5 = 0
        L_0x00d1:
            if (r4 == 0) goto L_0x00de
            com.google.android.exoplayer2.n.k r4 = r9.f9735g
            int r4 = r4.g()
            com.google.android.exoplayer2.n.k r7 = r9.f9735g
            r7.d(r4)
        L_0x00de:
            if (r6 == 0) goto L_0x010b
            android.util.SparseArray<com.google.android.exoplayer2.e.g.v> r4 = r9.k
            java.lang.Object r3 = r4.get(r3)
            com.google.android.exoplayer2.e.g.v r3 = (com.google.android.exoplayer2.e.g.v) r3
            if (r3 == 0) goto L_0x010b
            if (r5 == 0) goto L_0x00ef
            r3.a()
        L_0x00ef:
            com.google.android.exoplayer2.n.k r4 = r9.f9735g
            r4.b(r0)
            com.google.android.exoplayer2.n.k r4 = r9.f9735g
            r3.a(r4, r11)
            com.google.android.exoplayer2.n.k r11 = r9.f9735g
            int r11 = r11.d()
            if (r11 > r0) goto L_0x0102
            goto L_0x0103
        L_0x0102:
            r1 = 0
        L_0x0103:
            com.google.android.exoplayer2.n.a.b(r1)
            com.google.android.exoplayer2.n.k r11 = r9.f9735g
            r11.b(r10)
        L_0x010b:
            com.google.android.exoplayer2.n.k r10 = r9.f9735g
            r10.c(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.g.u.a(com.google.android.exoplayer2.e.g, com.google.android.exoplayer2.e.l):int");
    }

    private void e() {
        this.l.clear();
        this.k.clear();
        SparseArray<v> a2 = this.j.a();
        int size = a2.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.k.put(a2.keyAt(i2), a2.valueAt(i2));
        }
        this.k.put(0, new r(new a()));
        this.p = null;
    }

    private class a implements q {

        /* renamed from: b  reason: collision with root package name */
        private final j f9737b = new j(new byte[4]);

        public void a(q qVar, h hVar, v.d dVar) {
        }

        public a() {
        }

        public void a(k kVar) {
            if (kVar.g() == 0) {
                kVar.d(7);
                int b2 = kVar.b() / 4;
                for (int i = 0; i < b2; i++) {
                    kVar.a(this.f9737b, 4);
                    int c2 = this.f9737b.c(16);
                    this.f9737b.b(3);
                    if (c2 == 0) {
                        this.f9737b.b(13);
                    } else {
                        int c3 = this.f9737b.c(13);
                        u.this.k.put(c3, new r(new b(c3)));
                        u.b(u.this);
                    }
                }
                if (u.this.f9733e != 2) {
                    u.this.k.remove(0);
                }
            }
        }
    }

    private class b implements q {

        /* renamed from: b  reason: collision with root package name */
        private final j f9739b = new j(new byte[5]);

        /* renamed from: c  reason: collision with root package name */
        private final int f9740c;

        public void a(q qVar, h hVar, v.d dVar) {
        }

        public b(int i) {
            this.f9740c = i;
        }

        public void a(k kVar) {
            q qVar;
            v vVar;
            k kVar2 = kVar;
            if (kVar.g() == 2) {
                int i = 0;
                if (u.this.f9733e == 1 || u.this.f9733e == 2 || u.this.n == 1) {
                    qVar = (q) u.this.f9734f.get(0);
                } else {
                    qVar = new q(((q) u.this.f9734f.get(0)).a());
                    u.this.f9734f.add(qVar);
                }
                kVar2.d(2);
                int h = kVar.h();
                int i2 = 5;
                kVar2.d(5);
                kVar2.a(this.f9739b, 2);
                int i3 = 4;
                this.f9739b.b(4);
                kVar2.d(this.f9739b.c(12));
                if (u.this.f9733e == 2 && u.this.p == null) {
                    v.b bVar = new v.b(21, (String) null, (List<v.a>) null, new byte[0]);
                    u uVar = u.this;
                    v unused = uVar.p = uVar.j.a(21, bVar);
                    u.this.p.a(qVar, u.this.m, new v.d(h, 21, 8192));
                }
                int b2 = kVar.b();
                while (b2 > 0) {
                    kVar2.a(this.f9739b, i2);
                    int c2 = this.f9739b.c(8);
                    this.f9739b.b(3);
                    int c3 = this.f9739b.c(13);
                    this.f9739b.b(i3);
                    int c4 = this.f9739b.c(12);
                    v.b a2 = a(kVar2, c4);
                    if (c2 == 6) {
                        c2 = a2.f9744a;
                    }
                    b2 -= c4 + 5;
                    int i4 = u.this.f9733e == 2 ? c2 : c3;
                    if (!u.this.l.get(i4)) {
                        u.this.l.put(i4, true);
                        if (u.this.f9733e == 2 && c2 == 21) {
                            vVar = u.this.p;
                        } else {
                            vVar = u.this.j.a(c2, a2);
                            if (vVar != null) {
                                vVar.a(qVar, u.this.m, new v.d(h, i4, 8192));
                            }
                        }
                        if (vVar != null) {
                            u.this.k.put(c3, vVar);
                        }
                    }
                    i2 = 5;
                    i3 = 4;
                }
                if (u.this.f9733e != 2) {
                    u.this.k.remove(this.f9740c);
                    u uVar2 = u.this;
                    if (uVar2.f9733e != 1) {
                        i = u.this.n - 1;
                    }
                    int unused2 = uVar2.n = i;
                    if (u.this.n == 0) {
                        u.this.m.a();
                        boolean unused3 = u.this.o = true;
                    }
                } else if (!u.this.o) {
                    u.this.m.a();
                    int unused4 = u.this.n = 0;
                    boolean unused5 = u.this.o = true;
                }
            }
        }

        private v.b a(k kVar, int i) {
            int d2 = kVar.d();
            int i2 = i + d2;
            String str = null;
            int i3 = -1;
            ArrayList arrayList = null;
            while (kVar.d() < i2) {
                int g2 = kVar.g();
                int d3 = kVar.d() + kVar.g();
                if (g2 == 5) {
                    long l = kVar.l();
                    if (l != u.f9730b) {
                        if (l != u.f9731c) {
                            if (l == u.f9732d) {
                                i3 = 36;
                            }
                            kVar.d(d3 - kVar.d());
                        }
                        i3 = 135;
                        kVar.d(d3 - kVar.d());
                    }
                } else if (g2 != 106) {
                    if (g2 != 122) {
                        if (g2 == 123) {
                            i3 = 138;
                        } else if (g2 == 10) {
                            str = kVar.e(3).trim();
                        } else if (g2 == 89) {
                            ArrayList arrayList2 = new ArrayList();
                            while (kVar.d() < d3) {
                                String trim = kVar.e(3).trim();
                                int g3 = kVar.g();
                                byte[] bArr = new byte[4];
                                kVar.a(bArr, 0, 4);
                                arrayList2.add(new v.a(trim, g3, bArr));
                            }
                            arrayList = arrayList2;
                            i3 = 89;
                        }
                        kVar.d(d3 - kVar.d());
                    }
                    i3 = 135;
                    kVar.d(d3 - kVar.d());
                }
                i3 = 129;
                kVar.d(d3 - kVar.d());
            }
            kVar.c(i2);
            return new v.b(i3, str, arrayList, Arrays.copyOfRange(kVar.f10948a, d2, i2));
        }
    }
}
