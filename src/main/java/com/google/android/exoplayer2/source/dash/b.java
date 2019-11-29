package com.google.android.exoplayer2.source.dash;

import android.util.Pair;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.r.s;
import com.google.android.exoplayer2.source.a;
import com.google.android.exoplayer2.source.b.f;
import com.google.android.exoplayer2.source.d;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.manifest.g;
import com.google.android.exoplayer2.source.e;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.p;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

final class b implements h, m.a<f<a>> {

    /* renamed from: a  reason: collision with root package name */
    final int f11896a;

    /* renamed from: b  reason: collision with root package name */
    private final a.C0193a f11897b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11898c;

    /* renamed from: d  reason: collision with root package name */
    private final a.C0185a f11899d;

    /* renamed from: e  reason: collision with root package name */
    private final long f11900e;

    /* renamed from: f  reason: collision with root package name */
    private final s f11901f;

    /* renamed from: g  reason: collision with root package name */
    private final com.google.android.exoplayer2.r.b f11902g;
    private final p h;
    private final a[] i;
    private h.a j;
    private f<a>[] k = a(0);
    private d l = new d(this.k);
    private com.google.android.exoplayer2.source.dash.manifest.b m;
    private int n;
    private List<com.google.android.exoplayer2.source.dash.manifest.a> o;

    public long c() {
        return -9223372036854775807L;
    }

    public b(int i2, com.google.android.exoplayer2.source.dash.manifest.b bVar, int i3, a.C0193a aVar, int i4, a.C0185a aVar2, long j2, s sVar, com.google.android.exoplayer2.r.b bVar2) {
        this.f11896a = i2;
        this.m = bVar;
        this.n = i3;
        this.f11897b = aVar;
        this.f11898c = i4;
        this.f11899d = aVar2;
        this.f11900e = j2;
        this.f11901f = sVar;
        this.f11902g = bVar2;
        this.o = bVar.a(i3).f12019c;
        Pair<p, a[]> a2 = a(this.o);
        this.h = (p) a2.first;
        this.i = (a[]) a2.second;
    }

    public void a(com.google.android.exoplayer2.source.dash.manifest.b bVar, int i2) {
        this.m = bVar;
        this.n = i2;
        this.o = bVar.a(i2).f12019c;
        f<a>[] fVarArr = this.k;
        if (fVarArr != null) {
            for (f<a> a2 : fVarArr) {
                a2.a().a(bVar, i2);
            }
            this.j.a(this);
        }
    }

    public void f() {
        for (f<a> b2 : this.k) {
            b2.b();
        }
    }

    public void a(h.a aVar, long j2) {
        this.j = aVar;
        aVar.a(this);
    }

    public void j_() throws IOException {
        this.f11901f.d();
    }

    public p b() {
        return this.h;
    }

    public long a(com.google.android.exoplayer2.q.f[] fVarArr, boolean[] zArr, l[] lVarArr, boolean[] zArr2, long j2) {
        l lVar;
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < fVarArr.length; i2++) {
            if (lVarArr[i2] instanceof f) {
                f fVar = lVarArr[i2];
                if (fVarArr[i2] == null || !zArr[i2]) {
                    fVar.b();
                    lVarArr[i2] = null;
                } else {
                    hashMap.put(Integer.valueOf(this.h.a(fVarArr[i2].d())), fVar);
                }
            }
            if (lVarArr[i2] == null && fVarArr[i2] != null) {
                int a2 = this.h.a(fVarArr[i2].d());
                a aVar = this.i[a2];
                if (aVar.f11905c) {
                    f<a> a3 = a(aVar, fVarArr[i2], j2);
                    hashMap.put(Integer.valueOf(a2), a3);
                    lVarArr[i2] = a3;
                    zArr2[i2] = true;
                }
            }
        }
        for (int i3 = 0; i3 < fVarArr.length; i3++) {
            if (((lVarArr[i3] instanceof f.a) || (lVarArr[i3] instanceof e)) && (fVarArr[i3] == null || !zArr[i3])) {
                a(lVarArr[i3]);
                lVarArr[i3] = null;
            }
            if (fVarArr[i3] != null) {
                a aVar2 = this.i[this.h.a(fVarArr[i3].d())];
                if (!aVar2.f11905c) {
                    f<T> fVar2 = (f) hashMap.get(Integer.valueOf(aVar2.f11906d));
                    f.a aVar3 = lVarArr[i3];
                    if (!(fVar2 == null ? aVar3 instanceof e : (aVar3 instanceof f.a) && aVar3.f11571a == fVar2)) {
                        a((l) aVar3);
                        if (fVar2 == null) {
                            lVar = new e();
                        } else {
                            lVar = fVar2.a(j2, aVar2.f11904b);
                        }
                        lVarArr[i3] = lVar;
                        zArr2[i3] = true;
                    }
                }
            }
        }
        this.k = a(hashMap.size());
        hashMap.values().toArray(this.k);
        this.l = new d(this.k);
        return j2;
    }

    public void a(long j2) {
        for (f<a> b2 : this.k) {
            b2.b(j2);
        }
    }

    public boolean c(long j2) {
        return this.l.c(j2);
    }

    public long e() {
        return this.l.e();
    }

    public long d() {
        return this.l.d();
    }

    public long b(long j2) {
        for (f<a> d2 : this.k) {
            d2.d(j2);
        }
        return j2;
    }

    public void a(f<a> fVar) {
        this.j.a(this);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [boolean, int], vars: [r8v0 ?, r8v1 ?, r8v3 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    private static android.util.Pair<com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.dash.b.a[]> a(java.util.List<com.google.android.exoplayer2.source.dash.manifest.a> r24) {
        /*
            r0 = r24
            int[][] r1 = b((java.util.List<com.google.android.exoplayer2.source.dash.manifest.a>) r24)
            int r2 = r1.length
            boolean[] r3 = new boolean[r2]
            boolean[] r4 = new boolean[r2]
            r5 = 0
            r7 = r2
            r6 = 0
        L_0x000e:
            r8 = 1
            if (r6 >= r2) goto L_0x002c
            r9 = r1[r6]
            boolean r9 = a((java.util.List<com.google.android.exoplayer2.source.dash.manifest.a>) r0, (int[]) r9)
            if (r9 == 0) goto L_0x001d
            r3[r6] = r8
            int r7 = r7 + 1
        L_0x001d:
            r9 = r1[r6]
            boolean r9 = b(r0, r9)
            if (r9 == 0) goto L_0x0029
            r4[r6] = r8
            int r7 = r7 + 1
        L_0x0029:
            int r6 = r6 + 1
            goto L_0x000e
        L_0x002c:
            com.google.android.exoplayer2.source.o[] r6 = new com.google.android.exoplayer2.source.o[r7]
            com.google.android.exoplayer2.source.dash.b$a[] r7 = new com.google.android.exoplayer2.source.dash.b.a[r7]
            r9 = 0
            r17 = 0
        L_0x0033:
            if (r9 >= r2) goto L_0x0133
            r15 = r1[r9]
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            int r11 = r15.length
            r12 = 0
        L_0x003e:
            if (r12 >= r11) goto L_0x0050
            r13 = r15[r12]
            java.lang.Object r13 = r0.get(r13)
            com.google.android.exoplayer2.source.dash.manifest.a r13 = (com.google.android.exoplayer2.source.dash.manifest.a) r13
            java.util.List<com.google.android.exoplayer2.source.dash.manifest.g> r13 = r13.f11994c
            r10.addAll(r13)
            int r12 = r12 + 1
            goto L_0x003e
        L_0x0050:
            int r11 = r10.size()
            com.google.android.exoplayer2.Format[] r11 = new com.google.android.exoplayer2.Format[r11]
            r12 = 0
        L_0x0057:
            int r13 = r11.length
            if (r12 >= r13) goto L_0x0067
            java.lang.Object r13 = r10.get(r12)
            com.google.android.exoplayer2.source.dash.manifest.g r13 = (com.google.android.exoplayer2.source.dash.manifest.g) r13
            com.google.android.exoplayer2.Format r13 = r13.f12026c
            r11[r12] = r13
            int r12 = r12 + 1
            goto L_0x0057
        L_0x0067:
            r10 = r15[r5]
            java.lang.Object r10 = r0.get(r10)
            r14 = r10
            com.google.android.exoplayer2.source.dash.manifest.a r14 = (com.google.android.exoplayer2.source.dash.manifest.a) r14
            boolean r18 = r3[r9]
            boolean r19 = r4[r9]
            com.google.android.exoplayer2.source.o r10 = new com.google.android.exoplayer2.source.o
            r10.<init>(r11)
            r6[r17] = r10
            int r20 = r17 + 1
            com.google.android.exoplayer2.source.dash.b$a r21 = new com.google.android.exoplayer2.source.dash.b$a
            int r11 = r14.f11993b
            r16 = 1
            r10 = r21
            r12 = r15
            r13 = r17
            r5 = r14
            r14 = r16
            r22 = r15
            r15 = r18
            r16 = r19
            r10.<init>(r11, r12, r13, r14, r15, r16)
            r7[r17] = r21
            r15 = 0
            if (r18 == 0) goto L_0x00da
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            int r11 = r5.f11992a
            r10.append(r11)
            java.lang.String r11 = ":emsg"
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r11 = -1
            java.lang.String r12 = "application/x-emsg"
            com.google.android.exoplayer2.Format r10 = com.google.android.exoplayer2.Format.a((java.lang.String) r10, (java.lang.String) r12, (java.lang.String) r15, (int) r11, (com.google.android.exoplayer2.drm.DrmInitData) r15)
            com.google.android.exoplayer2.source.o r11 = new com.google.android.exoplayer2.source.o
            com.google.android.exoplayer2.Format[] r12 = new com.google.android.exoplayer2.Format[r8]
            r13 = 0
            r12[r13] = r10
            r11.<init>(r12)
            r6[r20] = r11
            int r18 = r20 + 1
            com.google.android.exoplayer2.source.dash.b$a r21 = new com.google.android.exoplayer2.source.dash.b$a
            r11 = 4
            r14 = 0
            r16 = 0
            r23 = 0
            r10 = r21
            r12 = r22
            r13 = r17
            r8 = r15
            r15 = r16
            r16 = r23
            r10.<init>(r11, r12, r13, r14, r15, r16)
            r7[r20] = r21
            goto L_0x00dd
        L_0x00da:
            r8 = r15
            r18 = r20
        L_0x00dd:
            if (r19 == 0) goto L_0x0127
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            int r5 = r5.f11992a
            r10.append(r5)
            java.lang.String r5 = ":cea608"
            r10.append(r5)
            java.lang.String r5 = r10.toString()
            java.lang.String r10 = "application/cea-608"
            r15 = 0
            com.google.android.exoplayer2.Format r5 = com.google.android.exoplayer2.Format.a(r5, r10, r15, r8)
            com.google.android.exoplayer2.source.o r8 = new com.google.android.exoplayer2.source.o
            r14 = 1
            com.google.android.exoplayer2.Format[] r10 = new com.google.android.exoplayer2.Format[r14]
            r10[r15] = r5
            r8.<init>(r10)
            r6[r18] = r8
            int r5 = r18 + 1
            com.google.android.exoplayer2.source.dash.b$a r8 = new com.google.android.exoplayer2.source.dash.b$a
            r11 = 3
            r16 = 0
            r19 = 0
            r20 = 0
            r10 = r8
            r12 = r22
            r13 = r17
            r17 = 1
            r14 = r16
            r21 = 0
            r15 = r19
            r16 = r20
            r10.<init>(r11, r12, r13, r14, r15, r16)
            r7[r18] = r8
            r18 = r5
            goto L_0x012b
        L_0x0127:
            r17 = 1
            r21 = 0
        L_0x012b:
            int r9 = r9 + 1
            r17 = r18
            r5 = 0
            r8 = 1
            goto L_0x0033
        L_0x0133:
            com.google.android.exoplayer2.source.p r0 = new com.google.android.exoplayer2.source.p
            r0.<init>(r6)
            android.util.Pair r0 = android.util.Pair.create(r0, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.b.a(java.util.List):android.util.Pair");
    }

    private static int[][] b(List<com.google.android.exoplayer2.source.dash.manifest.a> list) {
        int size = list.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        for (int i2 = 0; i2 < size; i2++) {
            sparseIntArray.put(list.get(i2).f11992a, i2);
        }
        int[][] iArr = new int[size][];
        boolean[] zArr = new boolean[size];
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            if (!zArr[i4]) {
                zArr[i4] = true;
                com.google.android.exoplayer2.source.dash.manifest.d c2 = c(list.get(i4).f11996e);
                if (c2 == null) {
                    iArr[i3] = new int[]{i4};
                    i3++;
                } else {
                    String[] split = c2.f12015b.split(",");
                    int[] iArr2 = new int[(split.length + 1)];
                    iArr2[0] = i4;
                    int i5 = 0;
                    while (i5 < split.length) {
                        int i6 = sparseIntArray.get(Integer.parseInt(split[i5]));
                        zArr[i6] = true;
                        i5++;
                        iArr2[i5] = i6;
                    }
                    iArr[i3] = iArr2;
                    i3++;
                }
            }
        }
        return i3 < size ? (int[][]) Arrays.copyOf(iArr, i3) : iArr;
    }

    private f<a> a(a aVar, com.google.android.exoplayer2.q.f fVar, long j2) {
        a aVar2 = aVar;
        int[] iArr = new int[2];
        boolean z = aVar2.f11907e;
        int i2 = 0;
        if (z) {
            iArr[0] = 4;
            i2 = 1;
        }
        boolean z2 = aVar2.f11908f;
        if (z2) {
            iArr[i2] = 3;
            i2++;
        }
        if (i2 < iArr.length) {
            iArr = Arrays.copyOf(iArr, i2);
        }
        int[] iArr2 = iArr;
        a a2 = this.f11897b.a(this.f11901f, this.m, this.n, aVar2.f11903a, fVar, aVar2.f11904b, this.f11900e, z, z2);
        return new f(aVar2.f11904b, iArr2, a2, this, this.f11902g, j2, this.f11898c, this.f11899d);
    }

    private static com.google.android.exoplayer2.source.dash.manifest.d c(List<com.google.android.exoplayer2.source.dash.manifest.d> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.google.android.exoplayer2.source.dash.manifest.d dVar = list.get(i2);
            if ("urn:mpeg:dash:adaptation-set-switching:2016".equals(dVar.f12014a)) {
                return dVar;
            }
        }
        return null;
    }

    private static boolean a(List<com.google.android.exoplayer2.source.dash.manifest.a> list, int[] iArr) {
        for (int i2 : iArr) {
            List<g> list2 = list.get(i2).f11994c;
            for (int i3 = 0; i3 < list2.size(); i3++) {
                if (!list2.get(i3).f12029f.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean b(List<com.google.android.exoplayer2.source.dash.manifest.a> list, int[] iArr) {
        for (int i2 : iArr) {
            List<com.google.android.exoplayer2.source.dash.manifest.d> list2 = list.get(i2).f11995d;
            for (int i3 = 0; i3 < list2.size(); i3++) {
                if ("urn:scte:dash:cc:cea-608:2015".equals(list2.get(i3).f12014a)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static f<a>[] a(int i2) {
        return new f[i2];
    }

    private static void a(l lVar) {
        if (lVar instanceof f.a) {
            ((f.a) lVar).a();
        }
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f11903a;

        /* renamed from: b  reason: collision with root package name */
        public final int f11904b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f11905c;

        /* renamed from: d  reason: collision with root package name */
        public final int f11906d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f11907e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f11908f;

        public a(int i, int[] iArr, int i2, boolean z, boolean z2, boolean z3) {
            this.f11904b = i;
            this.f11903a = iArr;
            this.f11906d = i2;
            this.f11905c = z;
            this.f11907e = z2;
            this.f11908f = z3;
        }
    }
}
