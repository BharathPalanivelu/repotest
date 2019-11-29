package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.ah;
import com.google.android.exoplayer2.d.e;
import com.google.android.exoplayer2.e.d;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.m.b;
import com.google.android.exoplayer2.m.r;
import com.google.android.exoplayer2.source.a.g;
import com.google.android.exoplayer2.source.aa;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.source.z;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class f<T extends g> implements r.a<c>, aa, z {

    /* renamed from: a  reason: collision with root package name */
    long f11517a;

    /* renamed from: b  reason: collision with root package name */
    boolean f11518b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11519c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f11520d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final boolean[] f11521e;

    /* renamed from: f  reason: collision with root package name */
    private final T f11522f;

    /* renamed from: g  reason: collision with root package name */
    private final aa.a<f<T>> f11523g;
    private final r.a h;
    private final int i;
    private final com.google.android.exoplayer2.m.r j = new com.google.android.exoplayer2.m.r("Loader:ChunkSampleStream");
    private final e k = new e();
    private final LinkedList<a> l = new LinkedList<>();
    private final List<a> m = Collections.unmodifiableList(this.l);
    private final d n;
    private final d[] o;
    private final b p;
    private j q;
    private long r;

    public f(int i2, int[] iArr, T t, aa.a<f<T>> aVar, b bVar, long j2, int i3, r.a aVar2) {
        int i4;
        this.f11519c = i2;
        this.f11520d = iArr;
        this.f11522f = t;
        this.f11523g = aVar;
        this.h = aVar2;
        this.i = i3;
        int i5 = 0;
        if (iArr == null) {
            i4 = 0;
        } else {
            i4 = iArr.length;
        }
        this.o = new d[i4];
        this.f11521e = new boolean[i4];
        int i6 = i4 + 1;
        int[] iArr2 = new int[i6];
        d[] dVarArr = new d[i6];
        this.n = new d(bVar);
        iArr2[0] = i2;
        dVarArr[0] = this.n;
        while (i5 < i4) {
            d dVar = new d(bVar);
            this.o[i5] = dVar;
            int i7 = i5 + 1;
            dVarArr[i7] = dVar;
            iArr2[i7] = iArr[i5];
            i5 = i7;
        }
        this.p = new b(iArr2, dVarArr);
        this.r = j2;
        this.f11517a = j2;
    }

    public void a(long j2) {
        int i2 = 0;
        while (true) {
            d[] dVarArr = this.o;
            if (i2 < dVarArr.length) {
                if (!this.f11521e[i2]) {
                    dVarArr[i2].a(j2, true);
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public f<T>.a a(long j2, int i2) {
        for (int i3 = 0; i3 < this.o.length; i3++) {
            if (this.f11520d[i3] == i2) {
                com.google.android.exoplayer2.n.a.b(!this.f11521e[i3]);
                this.f11521e[i3] = true;
                this.o[i3].a(j2, true);
                return new a(this, this.o[i3], i3);
            }
        }
        throw new IllegalStateException();
    }

    public T a() {
        return this.f11522f;
    }

    public long b() {
        if (this.f11518b) {
            return Long.MIN_VALUE;
        }
        if (g()) {
            return this.r;
        }
        long j2 = this.f11517a;
        a last = this.l.getLast();
        if (!last.g()) {
            if (this.l.size() > 1) {
                LinkedList<a> linkedList = this.l;
                last = linkedList.get(linkedList.size() - 2);
            } else {
                last = null;
            }
        }
        if (last != null) {
            j2 = Math.max(j2, last.f11502g);
        }
        return Math.max(j2, this.n.h());
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0022 A[LOOP:0: B:11:0x0022->B:15:0x003e, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(long r7) {
        /*
            r6 = this;
            r6.f11517a = r7
            boolean r0 = r6.g()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x001f
            com.google.android.exoplayer2.e.d r0 = r6.n
            long r3 = r6.f()
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0016
            r3 = 1
            goto L_0x0017
        L_0x0016:
            r3 = 0
        L_0x0017:
            boolean r0 = r0.a((long) r7, (boolean) r3)
            if (r0 == 0) goto L_0x001f
            r0 = 1
            goto L_0x0020
        L_0x001f:
            r0 = 0
        L_0x0020:
            if (r0 == 0) goto L_0x0051
        L_0x0022:
            java.util.LinkedList<com.google.android.exoplayer2.source.a.a> r0 = r6.l
            int r0 = r0.size()
            if (r0 <= r2) goto L_0x0044
            java.util.LinkedList<com.google.android.exoplayer2.source.a.a> r0 = r6.l
            java.lang.Object r0 = r0.get(r2)
            com.google.android.exoplayer2.source.a.a r0 = (com.google.android.exoplayer2.source.a.a) r0
            int r0 = r0.a((int) r1)
            com.google.android.exoplayer2.e.d r3 = r6.n
            int r3 = r3.e()
            if (r0 > r3) goto L_0x0044
            java.util.LinkedList<com.google.android.exoplayer2.source.a.a> r0 = r6.l
            r0.removeFirst()
            goto L_0x0022
        L_0x0044:
            com.google.android.exoplayer2.e.d[] r0 = r6.o
            int r3 = r0.length
        L_0x0047:
            if (r1 >= r3) goto L_0x007a
            r4 = r0[r1]
            r4.a((long) r7, (boolean) r2)
            int r1 = r1 + 1
            goto L_0x0047
        L_0x0051:
            r6.r = r7
            r6.f11518b = r1
            java.util.LinkedList<com.google.android.exoplayer2.source.a.a> r7 = r6.l
            r7.clear()
            com.google.android.exoplayer2.m.r r7 = r6.j
            boolean r7 = r7.a()
            if (r7 == 0) goto L_0x0068
            com.google.android.exoplayer2.m.r r7 = r6.j
            r7.b()
            goto L_0x007a
        L_0x0068:
            com.google.android.exoplayer2.e.d r7 = r6.n
            r7.a((boolean) r2)
            com.google.android.exoplayer2.e.d[] r7 = r6.o
            int r8 = r7.length
        L_0x0070:
            if (r1 >= r8) goto L_0x007a
            r0 = r7[r1]
            r0.a((boolean) r2)
            int r1 = r1 + 1
            goto L_0x0070
        L_0x007a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.a.f.b(long):void");
    }

    public void c() {
        this.n.c();
        for (d c2 : this.o) {
            c2.c();
        }
        this.j.c();
    }

    public boolean d() {
        return this.f11518b || (!g() && !this.n.d());
    }

    public void e() throws IOException {
        this.j.d();
        if (!this.j.a()) {
            this.f11522f.a();
        }
    }

    public int a(ah ahVar, e eVar, boolean z) {
        if (g()) {
            return -3;
        }
        a(this.n.e());
        return this.n.a(ahVar, eVar, z, this.f11518b, this.f11517a);
    }

    public void c(long j2) {
        if (!this.f11518b || j2 <= this.n.h()) {
            this.n.a(j2, true);
        } else {
            this.n.i();
        }
    }

    public void a(c cVar, long j2, long j3) {
        c cVar2 = cVar;
        this.f11522f.a(cVar2);
        this.h.a(cVar2.f11496a, cVar2.f11497b, this.f11519c, cVar2.f11498c, cVar2.f11499d, cVar2.f11500e, cVar2.f11501f, cVar2.f11502g, j2, j3, cVar.e());
        this.f11523g.a(this);
    }

    public void a(c cVar, long j2, long j3, boolean z) {
        c cVar2 = cVar;
        this.h.b(cVar2.f11496a, cVar2.f11497b, this.f11519c, cVar2.f11498c, cVar2.f11499d, cVar2.f11500e, cVar2.f11501f, cVar2.f11502g, j2, j3, cVar.e());
        if (!z) {
            this.n.a(true);
            for (d a2 : this.o) {
                a2.a(true);
            }
            this.f11523g.a(this);
        }
    }

    public int a(c cVar, long j2, long j3, IOException iOException) {
        boolean z;
        c cVar2 = cVar;
        long e2 = cVar.e();
        boolean a2 = a(cVar);
        if (this.f11522f.a(cVar2, !a2 || e2 == 0 || this.l.size() > 1, (Exception) iOException)) {
            if (a2) {
                a removeLast = this.l.removeLast();
                com.google.android.exoplayer2.n.a.b(removeLast == cVar2);
                this.n.b(removeLast.a(0));
                int i2 = 0;
                while (true) {
                    d[] dVarArr = this.o;
                    if (i2 >= dVarArr.length) {
                        break;
                    }
                    d dVar = dVarArr[i2];
                    i2++;
                    dVar.b(removeLast.a(i2));
                }
                if (this.l.isEmpty()) {
                    this.r = this.f11517a;
                }
            }
            z = true;
        } else {
            z = false;
        }
        this.h.a(cVar2.f11496a, cVar2.f11497b, this.f11519c, cVar2.f11498c, cVar2.f11499d, cVar2.f11500e, cVar2.f11501f, cVar2.f11502g, j2, j3, e2, iOException, z);
        if (!z) {
            return 0;
        }
        this.f11523g.a(this);
        return 2;
    }

    public boolean d(long j2) {
        if (this.f11518b || this.j.a()) {
            return false;
        }
        T t = this.f11522f;
        a last = this.l.isEmpty() ? null : this.l.getLast();
        long j3 = this.r;
        if (j3 == -9223372036854775807L) {
            j3 = j2;
        }
        t.a((l) last, j3, this.k);
        boolean z = this.k.f11516b;
        c cVar = this.k.f11515a;
        this.k.a();
        if (z) {
            this.f11518b = true;
            return true;
        } else if (cVar == null) {
            return false;
        } else {
            if (a(cVar)) {
                this.r = -9223372036854775807L;
                a aVar = (a) cVar;
                aVar.a(this.p);
                this.l.add(aVar);
            }
            this.h.a(cVar.f11496a, cVar.f11497b, this.f11519c, cVar.f11498c, cVar.f11499d, cVar.f11500e, cVar.f11501f, cVar.f11502g, this.j.a(cVar, this, this.i));
            return true;
        }
    }

    public long f() {
        if (g()) {
            return this.r;
        }
        if (this.f11518b) {
            return Long.MIN_VALUE;
        }
        return this.l.getLast().f11502g;
    }

    private boolean a(c cVar) {
        return cVar instanceof a;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return this.r != -9223372036854775807L;
    }

    private void a(int i2) {
        while (this.l.size() > 1 && this.l.get(1).a(0) <= i2) {
            this.l.removeFirst();
        }
        a first = this.l.getFirst();
        j jVar = first.f11498c;
        if (!jVar.equals(this.q)) {
            this.h.a(this.f11519c, jVar, first.f11499d, first.f11500e, first.f11501f);
        }
        this.q = jVar;
    }

    public final class a implements z {

        /* renamed from: a  reason: collision with root package name */
        public final f<T> f11524a;

        /* renamed from: c  reason: collision with root package name */
        private final d f11526c;

        /* renamed from: d  reason: collision with root package name */
        private final int f11527d;

        public void e() throws IOException {
        }

        public a(f<T> fVar, d dVar, int i) {
            this.f11524a = fVar;
            this.f11526c = dVar;
            this.f11527d = i;
        }

        public boolean d() {
            return f.this.f11518b || (!f.this.g() && !this.f11526c.d());
        }

        public void c(long j) {
            if (!f.this.f11518b || j <= this.f11526c.h()) {
                this.f11526c.a(j, true);
            } else {
                this.f11526c.i();
            }
        }

        public int a(ah ahVar, e eVar, boolean z) {
            if (f.this.g()) {
                return -3;
            }
            return this.f11526c.a(ahVar, eVar, z, f.this.f11518b, f.this.f11517a);
        }

        public void a() {
            com.google.android.exoplayer2.n.a.b(f.this.f11521e[this.f11527d]);
            f.this.f11521e[this.f11527d] = false;
        }
    }
}
