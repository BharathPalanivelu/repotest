package com.google.android.exoplayer2.source.c;

import android.os.Handler;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.r.b;
import com.google.android.exoplayer2.source.a;
import com.google.android.exoplayer2.source.c.b.a;
import com.google.android.exoplayer2.source.c.b.e;
import com.google.android.exoplayer2.source.c.j;
import com.google.android.exoplayer2.source.d;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

public final class g implements e.b, j.a, h {

    /* renamed from: a  reason: collision with root package name */
    private final e f11695a;

    /* renamed from: b  reason: collision with root package name */
    private final d f11696b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11697c;

    /* renamed from: d  reason: collision with root package name */
    private final a.C0185a f11698d;

    /* renamed from: e  reason: collision with root package name */
    private final b f11699e;

    /* renamed from: f  reason: collision with root package name */
    private final IdentityHashMap<l, Integer> f11700f = new IdentityHashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private final k f11701g = new k();
    private final Handler h = new Handler();
    private h.a i;
    private int j;
    private p k;
    private j[] l = new j[0];
    private j[] m = new j[0];
    private d n;

    public long c() {
        return -9223372036854775807L;
    }

    public g(e eVar, d dVar, int i2, a.C0185a aVar, b bVar) {
        this.f11695a = eVar;
        this.f11696b = dVar;
        this.f11697c = i2;
        this.f11698d = aVar;
        this.f11699e = bVar;
    }

    public void f() {
        this.f11695a.b((e.b) this);
        this.h.removeCallbacksAndMessages((Object) null);
        for (j h2 : this.l) {
            h2.h();
        }
    }

    public void a(h.a aVar, long j2) {
        this.i = aVar;
        this.f11695a.a((e.b) this);
        d(j2);
    }

    public void j_() throws IOException {
        for (j c2 : this.l) {
            c2.c();
        }
    }

    public p b() {
        return this.k;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ea, code lost:
        if (r5 != r8[0]) goto L_0x00ee;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long a(com.google.android.exoplayer2.q.f[] r21, boolean[] r22, com.google.android.exoplayer2.source.l[] r23, boolean[] r24, long r25) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r23
            int r3 = r1.length
            int[] r3 = new int[r3]
            int r4 = r1.length
            int[] r4 = new int[r4]
            r6 = 0
        L_0x000d:
            int r7 = r1.length
            if (r6 >= r7) goto L_0x004e
            r7 = r2[r6]
            r8 = -1
            if (r7 != 0) goto L_0x0017
            r7 = -1
            goto L_0x0025
        L_0x0017:
            java.util.IdentityHashMap<com.google.android.exoplayer2.source.l, java.lang.Integer> r7 = r0.f11700f
            r9 = r2[r6]
            java.lang.Object r7 = r7.get(r9)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
        L_0x0025:
            r3[r6] = r7
            r4[r6] = r8
            r7 = r1[r6]
            if (r7 == 0) goto L_0x004b
            r7 = r1[r6]
            com.google.android.exoplayer2.source.o r7 = r7.d()
            r9 = 0
        L_0x0034:
            com.google.android.exoplayer2.source.c.j[] r10 = r0.l
            int r11 = r10.length
            if (r9 >= r11) goto L_0x004b
            r10 = r10[r9]
            com.google.android.exoplayer2.source.p r10 = r10.f()
            int r10 = r10.a((com.google.android.exoplayer2.source.o) r7)
            if (r10 == r8) goto L_0x0048
            r4[r6] = r9
            goto L_0x004b
        L_0x0048:
            int r9 = r9 + 1
            goto L_0x0034
        L_0x004b:
            int r6 = r6 + 1
            goto L_0x000d
        L_0x004e:
            java.util.IdentityHashMap<com.google.android.exoplayer2.source.l, java.lang.Integer> r6 = r0.f11700f
            r6.clear()
            int r6 = r1.length
            com.google.android.exoplayer2.source.l[] r6 = new com.google.android.exoplayer2.source.l[r6]
            int r7 = r1.length
            com.google.android.exoplayer2.source.l[] r7 = new com.google.android.exoplayer2.source.l[r7]
            int r8 = r1.length
            com.google.android.exoplayer2.q.f[] r15 = new com.google.android.exoplayer2.q.f[r8]
            com.google.android.exoplayer2.source.c.j[] r8 = r0.l
            int r8 = r8.length
            com.google.android.exoplayer2.source.c.j[] r13 = new com.google.android.exoplayer2.source.c.j[r8]
            r12 = 0
            r14 = 0
            r16 = 0
        L_0x0065:
            com.google.android.exoplayer2.source.c.j[] r8 = r0.l
            int r8 = r8.length
            if (r14 >= r8) goto L_0x010a
            r8 = 0
        L_0x006b:
            int r9 = r1.length
            if (r8 >= r9) goto L_0x0084
            r9 = r3[r8]
            r10 = 0
            if (r9 != r14) goto L_0x0076
            r9 = r2[r8]
            goto L_0x0077
        L_0x0076:
            r9 = r10
        L_0x0077:
            r7[r8] = r9
            r9 = r4[r8]
            if (r9 != r14) goto L_0x007f
            r10 = r1[r8]
        L_0x007f:
            r15[r8] = r10
            int r8 = r8 + 1
            goto L_0x006b
        L_0x0084:
            com.google.android.exoplayer2.source.c.j[] r8 = r0.l
            r11 = r8[r14]
            r8 = r11
            r9 = r15
            r10 = r22
            r5 = r11
            r11 = r7
            r2 = r12
            r12 = r24
            r17 = r2
            r18 = r13
            r2 = r14
            r13 = r25
            r19 = r15
            r15 = r16
            boolean r8 = r8.a(r9, r10, r11, r12, r13, r15)
            r9 = 0
            r10 = 0
        L_0x00a2:
            int r11 = r1.length
            r12 = 1
            if (r9 >= r11) goto L_0x00d5
            r11 = r4[r9]
            if (r11 != r2) goto L_0x00c5
            r10 = r7[r9]
            if (r10 == 0) goto L_0x00b0
            r10 = 1
            goto L_0x00b1
        L_0x00b0:
            r10 = 0
        L_0x00b1:
            com.google.android.exoplayer2.s.a.b(r10)
            r10 = r7[r9]
            r6[r9] = r10
            java.util.IdentityHashMap<com.google.android.exoplayer2.source.l, java.lang.Integer> r10 = r0.f11700f
            r11 = r7[r9]
            java.lang.Integer r13 = java.lang.Integer.valueOf(r2)
            r10.put(r11, r13)
            r10 = 1
            goto L_0x00d2
        L_0x00c5:
            r11 = r3[r9]
            if (r11 != r2) goto L_0x00d2
            r11 = r7[r9]
            if (r11 != 0) goto L_0x00ce
            goto L_0x00cf
        L_0x00ce:
            r12 = 0
        L_0x00cf:
            com.google.android.exoplayer2.s.a.b(r12)
        L_0x00d2:
            int r9 = r9 + 1
            goto L_0x00a2
        L_0x00d5:
            if (r10 == 0) goto L_0x00fd
            r18[r17] = r5
            int r9 = r17 + 1
            if (r17 != 0) goto L_0x00f7
            r5.a((boolean) r12)
            if (r8 != 0) goto L_0x00ed
            com.google.android.exoplayer2.source.c.j[] r8 = r0.m
            int r10 = r8.length
            if (r10 == 0) goto L_0x00ed
            r10 = 0
            r8 = r8[r10]
            if (r5 == r8) goto L_0x00fb
            goto L_0x00ee
        L_0x00ed:
            r10 = 0
        L_0x00ee:
            com.google.android.exoplayer2.source.c.k r5 = r0.f11701g
            r5.a()
            r12 = r9
            r16 = 1
            goto L_0x0100
        L_0x00f7:
            r10 = 0
            r5.a((boolean) r10)
        L_0x00fb:
            r12 = r9
            goto L_0x0100
        L_0x00fd:
            r10 = 0
            r12 = r17
        L_0x0100:
            int r14 = r2 + 1
            r2 = r23
            r13 = r18
            r15 = r19
            goto L_0x0065
        L_0x010a:
            r17 = r12
            r18 = r13
            r10 = 0
            int r1 = r6.length
            r2 = r23
            java.lang.System.arraycopy(r6, r10, r2, r10, r1)
            r1 = r18
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r12)
            com.google.android.exoplayer2.source.c.j[] r1 = (com.google.android.exoplayer2.source.c.j[]) r1
            r0.m = r1
            com.google.android.exoplayer2.source.d r1 = new com.google.android.exoplayer2.source.d
            com.google.android.exoplayer2.source.c.j[] r2 = r0.m
            r1.<init>(r2)
            r0.n = r1
            return r25
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.c.g.a(com.google.android.exoplayer2.q.f[], boolean[], com.google.android.exoplayer2.source.l[], boolean[], long):long");
    }

    public void a(long j2) {
        for (j a2 : this.m) {
            a2.a(j2);
        }
    }

    public boolean c(long j2) {
        return this.n.c(j2);
    }

    public long e() {
        return this.n.e();
    }

    public long d() {
        return this.n.d();
    }

    public long b(long j2) {
        j[] jVarArr = this.m;
        if (jVarArr.length > 0) {
            boolean a2 = jVarArr[0].a(j2, false);
            int i2 = 1;
            while (true) {
                j[] jVarArr2 = this.m;
                if (i2 >= jVarArr2.length) {
                    break;
                }
                jVarArr2[i2].a(j2, a2);
                i2++;
            }
            if (a2) {
                this.f11701g.a();
            }
        }
        return j2;
    }

    public void g() {
        int i2 = this.j - 1;
        this.j = i2;
        if (i2 <= 0) {
            int i3 = 0;
            for (j f2 : this.l) {
                i3 += f2.f().f12118b;
            }
            o[] oVarArr = new o[i3];
            j[] jVarArr = this.l;
            int length = jVarArr.length;
            int i4 = 0;
            int i5 = 0;
            while (i4 < length) {
                j jVar = jVarArr[i4];
                int i6 = jVar.f().f12118b;
                int i7 = i5;
                int i8 = 0;
                while (i8 < i6) {
                    oVarArr[i7] = jVar.f().a(i8);
                    i8++;
                    i7++;
                }
                i4++;
                i5 = i7;
            }
            this.k = new p(oVarArr);
            this.i.a(this);
        }
    }

    public void a(a.C0187a aVar) {
        this.f11695a.d(aVar);
    }

    public void a(j jVar) {
        if (this.k != null) {
            this.i.a(this);
        }
    }

    public void h() {
        i();
    }

    public void a(a.C0187a aVar, long j2) {
        for (j a2 : this.l) {
            a2.a(aVar, j2);
        }
        i();
    }

    private void d(long j2) {
        com.google.android.exoplayer2.source.c.b.a b2 = this.f11695a.b();
        ArrayList arrayList = new ArrayList(b2.f11637a);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            a.C0187a aVar = (a.C0187a) arrayList.get(i2);
            if (aVar.f11643b.k > 0 || a(aVar, "avc")) {
                arrayList2.add(aVar);
            } else if (a(aVar, "mp4a")) {
                arrayList3.add(aVar);
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList = arrayList2;
        } else if (arrayList3.size() < arrayList.size()) {
            arrayList.removeAll(arrayList3);
        }
        List<a.C0187a> list = b2.f11638b;
        List<a.C0187a> list2 = b2.f11639c;
        this.l = new j[(list.size() + 1 + list2.size())];
        this.j = this.l.length;
        com.google.android.exoplayer2.s.a.a(!arrayList.isEmpty());
        a.C0187a[] aVarArr = new a.C0187a[arrayList.size()];
        arrayList.toArray(aVarArr);
        j a2 = a(0, aVarArr, b2.f11640d, b2.f11641e, j2);
        this.l[0] = a2;
        a2.a(true);
        a2.b();
        int i3 = 0;
        int i4 = 1;
        while (i3 < list.size()) {
            j a3 = a(1, new a.C0187a[]{list.get(i3)}, (Format) null, (List<Format>) Collections.emptyList(), j2);
            this.l[i4] = a3;
            a3.b();
            i3++;
            i4++;
        }
        int i5 = 0;
        while (i5 < list2.size()) {
            a.C0187a aVar2 = list2.get(i5);
            j a4 = a(3, new a.C0187a[]{aVar2}, (Format) null, (List<Format>) Collections.emptyList(), j2);
            a4.b(aVar2.f11643b);
            this.l[i4] = a4;
            i5++;
            i4++;
        }
        this.m = this.l;
    }

    private j a(int i2, a.C0187a[] aVarArr, Format format, List<Format> list, long j2) {
        c cVar = new c(this.f11695a, aVarArr, this.f11696b, this.f11701g, list);
        return new j(i2, this, cVar, this.f11699e, j2, format, this.f11697c, this.f11698d);
    }

    private void i() {
        if (this.k != null) {
            this.i.a(this);
            return;
        }
        for (j b2 : this.l) {
            b2.b();
        }
    }

    private static boolean a(a.C0187a aVar, String str) {
        String str2 = aVar.f11643b.f8955c;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        for (String startsWith : str2.split("(\\s*,\\s*)|(\\s*$)")) {
            if (startsWith.startsWith(str)) {
                return true;
            }
        }
        return false;
    }
}
