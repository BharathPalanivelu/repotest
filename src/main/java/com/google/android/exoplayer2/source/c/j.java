package com.google.android.exoplayer2.source.c;

import android.os.Handler;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.e;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.r.b;
import com.google.android.exoplayer2.r.r;
import com.google.android.exoplayer2.s.i;
import com.google.android.exoplayer2.source.a;
import com.google.android.exoplayer2.source.b.c;
import com.google.android.exoplayer2.source.c.b.a;
import com.google.android.exoplayer2.source.c.c;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

final class j implements g, r.a<c>, r.d, k.b, m {
    private long A;
    private boolean B;
    private boolean C;
    private boolean D;

    /* renamed from: a  reason: collision with root package name */
    private final int f11710a;

    /* renamed from: b  reason: collision with root package name */
    private final a f11711b;

    /* renamed from: c  reason: collision with root package name */
    private final c f11712c;

    /* renamed from: d  reason: collision with root package name */
    private final b f11713d;

    /* renamed from: e  reason: collision with root package name */
    private final Format f11714e;

    /* renamed from: f  reason: collision with root package name */
    private final int f11715f;

    /* renamed from: g  reason: collision with root package name */
    private final r f11716g = new r("Loader:HlsSampleStreamWrapper");
    private final a.C0185a h;
    private final c.b i = new c.b();
    private final LinkedList<f> j = new LinkedList<>();
    private final Runnable k = new Runnable() {
        public void run() {
            j.this.k();
        }
    };
    private final Handler l = new Handler();
    private k[] m = new k[0];
    private int[] n = new int[0];
    private boolean o;
    private boolean p;
    private int q;
    private Format r;
    private int s;
    private boolean t;
    private p u;
    private int v;
    private boolean w;
    private boolean[] x;
    private boolean[] y;
    private long z;

    public interface a extends m.a<j> {
        void a(a.C0187a aVar);

        void g();
    }

    public void a(l lVar) {
    }

    public j(int i2, a aVar, c cVar, b bVar, long j2, Format format, int i3, a.C0185a aVar2) {
        this.f11710a = i2;
        this.f11711b = aVar;
        this.f11712c = cVar;
        this.f11713d = bVar;
        this.f11714e = format;
        this.f11715f = i3;
        this.h = aVar2;
        this.z = j2;
        this.A = j2;
    }

    public void b() {
        if (!this.p) {
            c(this.z);
        }
    }

    public void b(Format format) {
        a(0, -1).a(format);
        this.o = true;
        k();
    }

    public void c() throws IOException {
        i();
    }

    public p f() {
        return this.u;
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0102  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.google.android.exoplayer2.q.f[] r16, boolean[] r17, com.google.android.exoplayer2.source.l[] r18, boolean[] r19, long r20, boolean r22) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r2 = r18
            r3 = r20
            boolean r5 = r0.p
            com.google.android.exoplayer2.s.a.b(r5)
            int r5 = r0.q
            r6 = 0
            r7 = 0
        L_0x0010:
            int r8 = r1.length
            r9 = 0
            if (r7 >= r8) goto L_0x002e
            r8 = r2[r7]
            if (r8 == 0) goto L_0x002b
            r8 = r1[r7]
            if (r8 == 0) goto L_0x0020
            boolean r8 = r17[r7]
            if (r8 != 0) goto L_0x002b
        L_0x0020:
            r8 = r2[r7]
            com.google.android.exoplayer2.source.c.i r8 = (com.google.android.exoplayer2.source.c.i) r8
            int r8 = r8.f11708a
            r15.b((int) r8, (boolean) r6)
            r2[r7] = r9
        L_0x002b:
            int r7 = r7 + 1
            goto L_0x0010
        L_0x002e:
            r7 = 1
            if (r22 != 0) goto L_0x0041
            boolean r8 = r0.C
            if (r8 == 0) goto L_0x0038
            if (r5 != 0) goto L_0x003f
            goto L_0x0041
        L_0x0038:
            long r10 = r0.z
            int r5 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x003f
            goto L_0x0041
        L_0x003f:
            r5 = 0
            goto L_0x0042
        L_0x0041:
            r5 = 1
        L_0x0042:
            com.google.android.exoplayer2.source.c.c r8 = r0.f11712c
            com.google.android.exoplayer2.q.f r8 = r8.c()
            r11 = r5
            r10 = r8
            r5 = 0
        L_0x004b:
            int r12 = r1.length
            if (r5 >= r12) goto L_0x0093
            r12 = r2[r5]
            if (r12 != 0) goto L_0x0090
            r12 = r1[r5]
            if (r12 == 0) goto L_0x0090
            r12 = r1[r5]
            com.google.android.exoplayer2.source.p r13 = r0.u
            com.google.android.exoplayer2.source.o r14 = r12.d()
            int r13 = r13.a((com.google.android.exoplayer2.source.o) r14)
            r15.b((int) r13, (boolean) r7)
            int r14 = r0.v
            if (r13 != r14) goto L_0x006f
            com.google.android.exoplayer2.source.c.c r10 = r0.f11712c
            r10.a((com.google.android.exoplayer2.q.f) r12)
            r10 = r12
        L_0x006f:
            com.google.android.exoplayer2.source.c.i r12 = new com.google.android.exoplayer2.source.c.i
            r12.<init>(r15, r13)
            r2[r5] = r12
            r19[r5] = r7
            if (r11 != 0) goto L_0x0090
            com.google.android.exoplayer2.source.k[] r11 = r0.m
            r11 = r11[r13]
            r11.i()
            boolean r12 = r11.b(r3, r7, r7)
            if (r12 != 0) goto L_0x008f
            int r11 = r11.e()
            if (r11 == 0) goto L_0x008f
            r11 = 1
            goto L_0x0090
        L_0x008f:
            r11 = 0
        L_0x0090:
            int r5 = r5 + 1
            goto L_0x004b
        L_0x0093:
            int r1 = r0.q
            if (r1 != 0) goto L_0x00c2
            com.google.android.exoplayer2.source.c.c r1 = r0.f11712c
            r1.d()
            r0.r = r9
            java.util.LinkedList<com.google.android.exoplayer2.source.c.f> r1 = r0.j
            r1.clear()
            com.google.android.exoplayer2.r.r r1 = r0.f11716g
            boolean r1 = r1.a()
            if (r1 == 0) goto L_0x00be
            com.google.android.exoplayer2.source.k[] r1 = r0.m
            int r2 = r1.length
        L_0x00ae:
            if (r6 >= r2) goto L_0x00b8
            r3 = r1[r6]
            r3.k()
            int r6 = r6 + 1
            goto L_0x00ae
        L_0x00b8:
            com.google.android.exoplayer2.r.r r1 = r0.f11716g
            r1.b()
            goto L_0x0111
        L_0x00be:
            r15.j()
            goto L_0x0111
        L_0x00c2:
            java.util.LinkedList<com.google.android.exoplayer2.source.c.f> r1 = r0.j
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x00fe
            boolean r1 = com.google.android.exoplayer2.s.v.a((java.lang.Object) r10, (java.lang.Object) r8)
            if (r1 != 0) goto L_0x00fe
            boolean r1 = r0.C
            if (r1 != 0) goto L_0x00f6
            r8 = 0
            r10.a((long) r8)
            com.google.android.exoplayer2.source.c.c r1 = r0.f11712c
            com.google.android.exoplayer2.source.o r1 = r1.b()
            java.util.LinkedList<com.google.android.exoplayer2.source.c.f> r5 = r0.j
            java.lang.Object r5 = r5.getLast()
            com.google.android.exoplayer2.source.c.f r5 = (com.google.android.exoplayer2.source.c.f) r5
            com.google.android.exoplayer2.Format r5 = r5.f11545c
            int r1 = r1.a((com.google.android.exoplayer2.Format) r5)
            int r5 = r10.g()
            if (r5 == r1) goto L_0x00f4
            goto L_0x00f6
        L_0x00f4:
            r1 = 0
            goto L_0x00f7
        L_0x00f6:
            r1 = 1
        L_0x00f7:
            if (r1 == 0) goto L_0x00fe
            r0.B = r7
            r1 = 1
            r11 = 1
            goto L_0x0100
        L_0x00fe:
            r1 = r22
        L_0x0100:
            if (r11 == 0) goto L_0x0111
            r15.a((long) r3, (boolean) r1)
        L_0x0105:
            int r1 = r2.length
            if (r6 >= r1) goto L_0x0111
            r1 = r2[r6]
            if (r1 == 0) goto L_0x010e
            r19[r6] = r7
        L_0x010e:
            int r6 = r6 + 1
            goto L_0x0105
        L_0x0111:
            r0.C = r7
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.c.j.a(com.google.android.exoplayer2.q.f[], boolean[], com.google.android.exoplayer2.source.l[], boolean[], long, boolean):boolean");
    }

    public void a(long j2) {
        int length = this.m.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.m[i2].a(j2, false, this.x[i2]);
        }
    }

    public boolean a(long j2, boolean z2) {
        this.z = j2;
        if (!z2 && !m() && b(j2)) {
            return false;
        }
        this.A = j2;
        this.D = false;
        this.j.clear();
        if (this.f11716g.a()) {
            this.f11716g.b();
            return true;
        }
        j();
        return true;
    }

    public long d() {
        if (this.D) {
            return Long.MIN_VALUE;
        }
        if (m()) {
            return this.A;
        }
        long j2 = this.z;
        f last = this.j.getLast();
        if (!last.g()) {
            if (this.j.size() > 1) {
                LinkedList<f> linkedList = this.j;
                last = linkedList.get(linkedList.size() - 2);
            } else {
                last = null;
            }
        }
        if (last != null) {
            j2 = Math.max(j2, last.f11549g);
        }
        for (k h2 : this.m) {
            j2 = Math.max(j2, h2.h());
        }
        return j2;
    }

    public void h() {
        boolean a2 = this.f11716g.a((r.d) this);
        if (this.p && !a2) {
            for (k k2 : this.m) {
                k2.k();
            }
        }
        this.l.removeCallbacksAndMessages((Object) null);
        this.t = true;
    }

    public void g() {
        j();
    }

    public void a(boolean z2) {
        this.f11712c.a(z2);
    }

    public void a(a.C0187a aVar, long j2) {
        this.f11712c.a(aVar, j2);
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2) {
        return this.D || (!m() && this.m[i2].d());
    }

    /* access modifiers changed from: package-private */
    public void i() throws IOException {
        this.f11716g.d();
        this.f11712c.a();
    }

    /* access modifiers changed from: package-private */
    public int a(int i2, com.google.android.exoplayer2.l lVar, e eVar, boolean z2) {
        if (m()) {
            return -3;
        }
        if (!this.j.isEmpty()) {
            while (this.j.size() > 1 && a(this.j.getFirst())) {
                this.j.removeFirst();
            }
            f first = this.j.getFirst();
            Format format = first.f11545c;
            if (!format.equals(this.r)) {
                this.h.a(this.f11710a, format, first.f11546d, first.f11547e, first.f11548f);
            }
            this.r = format;
        }
        return this.m[i2].a(lVar, eVar, z2, this.D, this.z);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, long j2) {
        k kVar = this.m[i2];
        if (!this.D || j2 <= kVar.h()) {
            kVar.b(j2, true, true);
        } else {
            kVar.l();
        }
    }

    private boolean a(f fVar) {
        int i2 = fVar.j;
        int i3 = 0;
        while (true) {
            k[] kVarArr = this.m;
            if (i3 >= kVarArr.length) {
                return true;
            }
            if (this.x[i3] && kVarArr[i3].f() == i2) {
                return false;
            }
            i3++;
        }
    }

    private void j() {
        for (k a2 : this.m) {
            a2.a(this.B);
        }
        this.B = false;
    }

    public boolean c(long j2) {
        if (this.D || this.f11716g.a()) {
            return false;
        }
        c cVar = this.f11712c;
        f last = this.j.isEmpty() ? null : this.j.getLast();
        long j3 = this.A;
        if (j3 == -9223372036854775807L) {
            j3 = j2;
        }
        cVar.a(last, j3, this.i);
        boolean z2 = this.i.f11690b;
        com.google.android.exoplayer2.source.b.c cVar2 = this.i.f11689a;
        a.C0187a aVar = this.i.f11691c;
        this.i.a();
        if (z2) {
            this.A = -9223372036854775807L;
            this.D = true;
            return true;
        } else if (cVar2 == null) {
            if (aVar != null) {
                this.f11711b.a(aVar);
            }
            return false;
        } else {
            if (a(cVar2)) {
                this.A = -9223372036854775807L;
                f fVar = (f) cVar2;
                fVar.a(this);
                this.j.add(fVar);
            }
            this.h.a(cVar2.f11543a, cVar2.f11544b, this.f11710a, cVar2.f11545c, cVar2.f11546d, cVar2.f11547e, cVar2.f11548f, cVar2.f11549g, this.f11716g.a(cVar2, this, this.f11715f));
            return true;
        }
    }

    public long e() {
        if (m()) {
            return this.A;
        }
        if (this.D) {
            return Long.MIN_VALUE;
        }
        return this.j.getLast().f11549g;
    }

    public void a(com.google.android.exoplayer2.source.b.c cVar, long j2, long j3) {
        com.google.android.exoplayer2.source.b.c cVar2 = cVar;
        this.f11712c.a(cVar2);
        this.h.a(cVar2.f11543a, cVar2.f11544b, this.f11710a, cVar2.f11545c, cVar2.f11546d, cVar2.f11547e, cVar2.f11548f, cVar2.f11549g, j2, j3, cVar.e());
        if (!this.p) {
            c(this.z);
        } else {
            this.f11711b.a(this);
        }
    }

    public void a(com.google.android.exoplayer2.source.b.c cVar, long j2, long j3, boolean z2) {
        com.google.android.exoplayer2.source.b.c cVar2 = cVar;
        this.h.b(cVar2.f11543a, cVar2.f11544b, this.f11710a, cVar2.f11545c, cVar2.f11546d, cVar2.f11547e, cVar2.f11548f, cVar2.f11549g, j2, j3, cVar.e());
        if (!z2) {
            j();
            if (this.q > 0) {
                this.f11711b.a(this);
            }
        }
    }

    public int a(com.google.android.exoplayer2.source.b.c cVar, long j2, long j3, IOException iOException) {
        com.google.android.exoplayer2.source.b.c cVar2 = cVar;
        long e2 = cVar.e();
        boolean a2 = a(cVar);
        boolean z2 = true;
        if (!this.f11712c.a(cVar2, !a2 || e2 == 0, iOException)) {
            z2 = false;
        } else if (a2) {
            com.google.android.exoplayer2.s.a.b(this.j.removeLast() == cVar2);
            if (this.j.isEmpty()) {
                this.A = this.z;
            }
        }
        this.h.a(cVar2.f11543a, cVar2.f11544b, this.f11710a, cVar2.f11545c, cVar2.f11546d, cVar2.f11547e, cVar2.f11548f, cVar2.f11549g, j2, j3, cVar.e(), iOException, z2);
        if (!z2) {
            return 0;
        }
        if (!this.p) {
            c(this.z);
            return 2;
        }
        this.f11711b.a(this);
        return 2;
    }

    public void a(int i2, boolean z2) {
        this.s = i2;
        for (k a2 : this.m) {
            a2.a(i2);
        }
        if (z2) {
            for (k b2 : this.m) {
                b2.b();
            }
        }
    }

    /* renamed from: b */
    public k a(int i2, int i3) {
        int length = this.m.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (this.n[i4] == i2) {
                return this.m[i4];
            }
        }
        k kVar = new k(this.f11713d);
        kVar.a((k.b) this);
        int i5 = length + 1;
        this.n = Arrays.copyOf(this.n, i5);
        this.n[length] = i2;
        this.m = (k[]) Arrays.copyOf(this.m, i5);
        this.m[length] = kVar;
        return kVar;
    }

    public void a() {
        this.o = true;
        this.l.post(this.k);
    }

    public void a(Format format) {
        this.l.post(this.k);
    }

    /* access modifiers changed from: private */
    public void k() {
        if (!this.t && !this.p && this.o) {
            k[] kVarArr = this.m;
            int length = kVarArr.length;
            int i2 = 0;
            while (i2 < length) {
                if (kVarArr[i2].g() != null) {
                    i2++;
                } else {
                    return;
                }
            }
            l();
            this.p = true;
            this.f11711b.g();
        }
    }

    private void l() {
        int length = this.m.length;
        int i2 = 0;
        char c2 = 0;
        int i3 = -1;
        while (true) {
            char c3 = 3;
            if (i2 >= length) {
                break;
            }
            String str = this.m[i2].g().f8958f;
            if (!i.b(str)) {
                if (i.a(str)) {
                    c3 = 2;
                } else {
                    c3 = i.c(str) ? (char) 1 : 0;
                }
            }
            if (c3 > c2) {
                i3 = i2;
                c2 = c3;
            } else if (c3 == c2 && i3 != -1) {
                i3 = -1;
            }
            i2++;
        }
        o b2 = this.f11712c.b();
        int i4 = b2.f12114a;
        this.v = -1;
        this.x = new boolean[length];
        this.y = new boolean[length];
        o[] oVarArr = new o[length];
        for (int i5 = 0; i5 < length; i5++) {
            Format g2 = this.m[i5].g();
            String str2 = g2.f8958f;
            boolean z2 = i.b(str2) || i.a(str2);
            this.y[i5] = z2;
            this.w = z2 | this.w;
            if (i5 == i3) {
                Format[] formatArr = new Format[i4];
                for (int i6 = 0; i6 < i4; i6++) {
                    formatArr[i6] = a(b2.a(i6), g2);
                }
                oVarArr[i5] = new o(formatArr);
                this.v = i5;
            } else {
                oVarArr[i5] = new o(a((c2 != 3 || !i.a(g2.f8958f)) ? null : this.f11714e, g2));
            }
        }
        this.u = new p(oVarArr);
    }

    private void b(int i2, boolean z2) {
        int i3 = 1;
        com.google.android.exoplayer2.s.a.b(this.x[i2] != z2);
        this.x[i2] = z2;
        int i4 = this.q;
        if (!z2) {
            i3 = -1;
        }
        this.q = i4 + i3;
    }

    private static Format a(Format format, Format format2) {
        if (format == null) {
            return format2;
        }
        String str = null;
        int g2 = i.g(format2.f8958f);
        if (g2 == 1) {
            str = a(format.f8955c);
        } else if (g2 == 2) {
            str = b(format.f8955c);
        }
        return format2.a(format.f8953a, str, format.f8954b, format.j, format.k, format.x, format.y);
    }

    private boolean a(com.google.android.exoplayer2.source.b.c cVar) {
        return cVar instanceof f;
    }

    private boolean m() {
        return this.A != -9223372036854775807L;
    }

    private boolean b(long j2) {
        int length = this.m.length;
        for (int i2 = 0; i2 < length; i2++) {
            k kVar = this.m[i2];
            kVar.i();
            if (!kVar.b(j2, true, false) && (this.y[i2] || !this.w)) {
                return false;
            }
            kVar.j();
        }
        return true;
    }

    private static String a(String str) {
        return a(str, 1);
    }

    private static String b(String str) {
        return a(str, 2);
    }

    private static String a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("(\\s*,\\s*)|(\\s*$)");
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            if (i2 == i.h(str2)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }
}
