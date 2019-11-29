package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.e;
import com.google.android.exoplayer2.r.b;
import com.google.android.exoplayer2.r.r;
import com.google.android.exoplayer2.source.a;
import com.google.android.exoplayer2.source.b.g;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class f<T extends g> implements r.a<c>, r.d, l, m {

    /* renamed from: a  reason: collision with root package name */
    long f11564a;

    /* renamed from: b  reason: collision with root package name */
    boolean f11565b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11566c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f11567d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final boolean[] f11568e;

    /* renamed from: f  reason: collision with root package name */
    private final T f11569f;

    /* renamed from: g  reason: collision with root package name */
    private final m.a<f<T>> f11570g;
    private final a.C0185a h;
    private final int i;
    private final r j = new r("Loader:ChunkSampleStream");
    private final e k = new e();
    private final LinkedList<a> l = new LinkedList<>();
    private final List<a> m = Collections.unmodifiableList(this.l);
    private final k n;
    private final k[] o;
    private final b p;
    private Format q;
    private long r;

    public f(int i2, int[] iArr, T t, m.a<f<T>> aVar, b bVar, long j2, int i3, a.C0185a aVar2) {
        int i4;
        this.f11566c = i2;
        this.f11567d = iArr;
        this.f11569f = t;
        this.f11570g = aVar;
        this.h = aVar2;
        this.i = i3;
        int i5 = 0;
        if (iArr == null) {
            i4 = 0;
        } else {
            i4 = iArr.length;
        }
        this.o = new k[i4];
        this.f11568e = new boolean[i4];
        int i6 = i4 + 1;
        int[] iArr2 = new int[i6];
        k[] kVarArr = new k[i6];
        this.n = new k(bVar);
        iArr2[0] = i2;
        kVarArr[0] = this.n;
        while (i5 < i4) {
            k kVar = new k(bVar);
            this.o[i5] = kVar;
            int i7 = i5 + 1;
            kVarArr[i7] = kVar;
            iArr2[i7] = iArr[i5];
            i5 = i7;
        }
        this.p = new b(iArr2, kVarArr);
        this.r = j2;
        this.f11564a = j2;
    }

    public void b(long j2) {
        int i2 = 0;
        while (true) {
            k[] kVarArr = this.o;
            if (i2 < kVarArr.length) {
                kVarArr[i2].a(j2, true, this.f11568e[i2]);
                i2++;
            } else {
                return;
            }
        }
    }

    public f<T>.a a(long j2, int i2) {
        for (int i3 = 0; i3 < this.o.length; i3++) {
            if (this.f11567d[i3] == i2) {
                com.google.android.exoplayer2.s.a.b(!this.f11568e[i3]);
                this.f11568e[i3] = true;
                this.o[i3].i();
                this.o[i3].b(j2, true, true);
                return new a(this, this.o[i3], i3);
            }
        }
        throw new IllegalStateException();
    }

    public T a() {
        return this.f11569f;
    }

    public long d() {
        if (this.f11565b) {
            return Long.MIN_VALUE;
        }
        if (f()) {
            return this.r;
        }
        long j2 = this.f11564a;
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
            j2 = Math.max(j2, last.f11549g);
        }
        return Math.max(j2, this.n.h());
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(long r7) {
        /*
            r6 = this;
            r6.f11564a = r7
            boolean r0 = r6.f()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x001f
            com.google.android.exoplayer2.source.k r0 = r6.n
            long r3 = r6.e()
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0016
            r3 = 1
            goto L_0x0017
        L_0x0016:
            r3 = 0
        L_0x0017:
            boolean r0 = r0.b(r7, r1, r3)
            if (r0 == 0) goto L_0x001f
            r0 = 1
            goto L_0x0020
        L_0x001f:
            r0 = 0
        L_0x0020:
            if (r0 == 0) goto L_0x0041
            com.google.android.exoplayer2.source.k r0 = r6.n
            int r0 = r0.e()
            r6.a((int) r0)
            com.google.android.exoplayer2.source.k r0 = r6.n
            r0.j()
            com.google.android.exoplayer2.source.k[] r0 = r6.o
            int r3 = r0.length
            r4 = 0
        L_0x0034:
            if (r4 >= r3) goto L_0x006a
            r5 = r0[r4]
            r5.i()
            r5.a((long) r7, (boolean) r1, (boolean) r2)
            int r4 = r4 + 1
            goto L_0x0034
        L_0x0041:
            r6.r = r7
            r6.f11565b = r2
            java.util.LinkedList<com.google.android.exoplayer2.source.b.a> r7 = r6.l
            r7.clear()
            com.google.android.exoplayer2.r.r r7 = r6.j
            boolean r7 = r7.a()
            if (r7 == 0) goto L_0x0058
            com.google.android.exoplayer2.r.r r7 = r6.j
            r7.b()
            goto L_0x006a
        L_0x0058:
            com.google.android.exoplayer2.source.k r7 = r6.n
            r7.a()
            com.google.android.exoplayer2.source.k[] r7 = r6.o
            int r8 = r7.length
        L_0x0060:
            if (r2 >= r8) goto L_0x006a
            r0 = r7[r2]
            r0.a()
            int r2 = r2 + 1
            goto L_0x0060
        L_0x006a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.b.f.d(long):void");
    }

    public void b() {
        if (!this.j.a((r.d) this)) {
            this.n.k();
            for (k k2 : this.o) {
                k2.k();
            }
        }
    }

    public void g() {
        this.n.a();
        for (k a2 : this.o) {
            a2.a();
        }
    }

    public boolean c() {
        return this.f11565b || (!f() && this.n.d());
    }

    public void k_() throws IOException {
        this.j.d();
        if (!this.j.a()) {
            this.f11569f.a();
        }
    }

    public int a(com.google.android.exoplayer2.l lVar, e eVar, boolean z) {
        if (f()) {
            return -3;
        }
        a(this.n.e());
        int a2 = this.n.a(lVar, eVar, z, this.f11565b, this.f11564a);
        if (a2 == -4) {
            this.n.j();
        }
        return a2;
    }

    public void a(long j2) {
        if (!this.f11565b || j2 <= this.n.h()) {
            this.n.b(j2, true, true);
        } else {
            this.n.l();
        }
        this.n.j();
    }

    public void a(c cVar, long j2, long j3) {
        c cVar2 = cVar;
        this.f11569f.a(cVar2);
        this.h.a(cVar2.f11543a, cVar2.f11544b, this.f11566c, cVar2.f11545c, cVar2.f11546d, cVar2.f11547e, cVar2.f11548f, cVar2.f11549g, j2, j3, cVar.e());
        this.f11570g.a(this);
    }

    public void a(c cVar, long j2, long j3, boolean z) {
        c cVar2 = cVar;
        this.h.b(cVar2.f11543a, cVar2.f11544b, this.f11566c, cVar2.f11545c, cVar2.f11546d, cVar2.f11547e, cVar2.f11548f, cVar2.f11549g, j2, j3, cVar.e());
        if (!z) {
            this.n.a();
            for (k a2 : this.o) {
                a2.a();
            }
            this.f11570g.a(this);
        }
    }

    public int a(c cVar, long j2, long j3, IOException iOException) {
        boolean z;
        c cVar2 = cVar;
        long e2 = cVar.e();
        boolean a2 = a(cVar);
        if (this.f11569f.a(cVar2, !a2 || e2 == 0 || this.l.size() > 1, (Exception) iOException)) {
            if (a2) {
                a removeLast = this.l.removeLast();
                com.google.android.exoplayer2.s.a.b(removeLast == cVar2);
                this.n.b(removeLast.a(0));
                int i2 = 0;
                while (true) {
                    k[] kVarArr = this.o;
                    if (i2 >= kVarArr.length) {
                        break;
                    }
                    k kVar = kVarArr[i2];
                    i2++;
                    kVar.b(removeLast.a(i2));
                }
                if (this.l.isEmpty()) {
                    this.r = this.f11564a;
                }
            }
            z = true;
        } else {
            z = false;
        }
        this.h.a(cVar2.f11543a, cVar2.f11544b, this.f11566c, cVar2.f11545c, cVar2.f11546d, cVar2.f11547e, cVar2.f11548f, cVar2.f11549g, j2, j3, e2, iOException, z);
        if (!z) {
            return 0;
        }
        this.f11570g.a(this);
        return 2;
    }

    public boolean c(long j2) {
        if (this.f11565b || this.j.a()) {
            return false;
        }
        T t = this.f11569f;
        a last = this.l.isEmpty() ? null : this.l.getLast();
        long j3 = this.r;
        if (j3 == -9223372036854775807L) {
            j3 = j2;
        }
        t.a((l) last, j3, this.k);
        boolean z = this.k.f11563b;
        c cVar = this.k.f11562a;
        this.k.a();
        if (z) {
            this.r = -9223372036854775807L;
            this.f11565b = true;
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
            this.h.a(cVar.f11543a, cVar.f11544b, this.f11566c, cVar.f11545c, cVar.f11546d, cVar.f11547e, cVar.f11548f, cVar.f11549g, this.j.a(cVar, this, this.i));
            return true;
        }
    }

    public long e() {
        if (f()) {
            return this.r;
        }
        if (this.f11565b) {
            return Long.MIN_VALUE;
        }
        return this.l.getLast().f11549g;
    }

    private boolean a(c cVar) {
        return cVar instanceof a;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return this.r != -9223372036854775807L;
    }

    private void a(int i2) {
        if (!this.l.isEmpty()) {
            while (this.l.size() > 1 && this.l.get(1).a(0) <= i2) {
                this.l.removeFirst();
            }
            a first = this.l.getFirst();
            Format format = first.f11545c;
            if (!format.equals(this.q)) {
                this.h.a(this.f11566c, format, first.f11546d, first.f11547e, first.f11548f);
            }
            this.q = format;
        }
    }

    public final class a implements l {

        /* renamed from: a  reason: collision with root package name */
        public final f<T> f11571a;

        /* renamed from: c  reason: collision with root package name */
        private final k f11573c;

        /* renamed from: d  reason: collision with root package name */
        private final int f11574d;

        public void k_() throws IOException {
        }

        public a(f<T> fVar, k kVar, int i) {
            this.f11571a = fVar;
            this.f11573c = kVar;
            this.f11574d = i;
        }

        public boolean c() {
            return f.this.f11565b || (!f.this.f() && this.f11573c.d());
        }

        public void a(long j) {
            if (!f.this.f11565b || j <= this.f11573c.h()) {
                this.f11573c.b(j, true, true);
            } else {
                this.f11573c.l();
            }
        }

        public int a(com.google.android.exoplayer2.l lVar, e eVar, boolean z) {
            if (f.this.f()) {
                return -3;
            }
            return this.f11573c.a(lVar, eVar, z, f.this.f11565b, f.this.f11564a);
        }

        public void a() {
            com.google.android.exoplayer2.s.a.b(f.this.f11568e[this.f11574d]);
            f.this.f11568e[this.f11574d] = false;
        }
    }
}
