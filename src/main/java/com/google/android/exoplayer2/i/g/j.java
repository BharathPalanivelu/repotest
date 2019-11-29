package com.google.android.exoplayer2.i.g;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.g.v;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.s.j;
import com.google.android.exoplayer2.s.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class j implements h {

    /* renamed from: a  reason: collision with root package name */
    private final s f10279a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f10280b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f10281c;

    /* renamed from: d  reason: collision with root package name */
    private final n f10282d = new n(7, 128);

    /* renamed from: e  reason: collision with root package name */
    private final n f10283e = new n(8, 128);

    /* renamed from: f  reason: collision with root package name */
    private final n f10284f = new n(6, 128);

    /* renamed from: g  reason: collision with root package name */
    private long f10285g;
    private final boolean[] h = new boolean[3];
    private String i;
    private m j;
    private a k;
    private boolean l;
    private long m;
    private final l n = new l();

    public void b() {
    }

    public j(s sVar, boolean z, boolean z2) {
        this.f10279a = sVar;
        this.f10280b = z;
        this.f10281c = z2;
    }

    public void a() {
        com.google.android.exoplayer2.s.j.a(this.h);
        this.f10282d.a();
        this.f10283e.a();
        this.f10284f.a();
        this.k.b();
        this.f10285g = 0;
    }

    public void a(g gVar, v.d dVar) {
        dVar.a();
        this.i = dVar.c();
        this.j = gVar.a(dVar.b(), 2);
        this.k = new a(this.j, this.f10280b, this.f10281c);
        this.f10279a.a(gVar, dVar);
    }

    public void a(long j2, boolean z) {
        this.m = j2;
    }

    public void a(l lVar) {
        int d2 = lVar.d();
        int c2 = lVar.c();
        byte[] bArr = lVar.f11422a;
        this.f10285g += (long) lVar.b();
        this.j.a(lVar, lVar.b());
        while (true) {
            int a2 = com.google.android.exoplayer2.s.j.a(bArr, d2, c2, this.h);
            if (a2 == c2) {
                a(bArr, d2, c2);
                return;
            }
            int b2 = com.google.android.exoplayer2.s.j.b(bArr, a2);
            int i2 = a2 - d2;
            if (i2 > 0) {
                a(bArr, d2, a2);
            }
            int i3 = c2 - a2;
            long j2 = this.f10285g - ((long) i3);
            a(j2, i3, i2 < 0 ? -i2 : 0, this.m);
            a(j2, b2, this.m);
            d2 = a2 + 3;
        }
    }

    private void a(long j2, int i2, long j3) {
        if (!this.l || this.k.a()) {
            this.f10282d.a(i2);
            this.f10283e.a(i2);
        }
        this.f10284f.a(i2);
        this.k.a(j2, i2, j3);
    }

    private void a(byte[] bArr, int i2, int i3) {
        if (!this.l || this.k.a()) {
            this.f10282d.a(bArr, i2, i3);
            this.f10283e.a(bArr, i2, i3);
        }
        this.f10284f.a(bArr, i2, i3);
        this.k.a(bArr, i2, i3);
    }

    private void a(long j2, int i2, int i3, long j3) {
        int i4 = i3;
        if (!this.l || this.k.a()) {
            this.f10282d.b(i4);
            this.f10283e.b(i4);
            if (!this.l) {
                if (this.f10282d.b() && this.f10283e.b()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Arrays.copyOf(this.f10282d.f10327a, this.f10282d.f10328b));
                    arrayList.add(Arrays.copyOf(this.f10283e.f10327a, this.f10283e.f10328b));
                    j.b a2 = com.google.android.exoplayer2.s.j.a(this.f10282d.f10327a, 3, this.f10282d.f10328b);
                    j.a b2 = com.google.android.exoplayer2.s.j.b(this.f10283e.f10327a, 3, this.f10283e.f10328b);
                    this.j.a(Format.a(this.i, "video/avc", (String) null, -1, -1, a2.f11412b, a2.f11413c, -1.0f, (List<byte[]>) arrayList, -1, a2.f11414d, (DrmInitData) null));
                    this.l = true;
                    this.k.a(a2);
                    this.k.a(b2);
                    this.f10282d.a();
                    this.f10283e.a();
                }
            } else if (this.f10282d.b()) {
                this.k.a(com.google.android.exoplayer2.s.j.a(this.f10282d.f10327a, 3, this.f10282d.f10328b));
                this.f10282d.a();
            } else if (this.f10283e.b()) {
                this.k.a(com.google.android.exoplayer2.s.j.b(this.f10283e.f10327a, 3, this.f10283e.f10328b));
                this.f10283e.a();
            }
        }
        if (this.f10284f.b(i3)) {
            this.n.a(this.f10284f.f10327a, com.google.android.exoplayer2.s.j.a(this.f10284f.f10327a, this.f10284f.f10328b));
            this.n.c(4);
            this.f10279a.a(j3, this.n);
        }
        this.k.a(j2, i2);
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final m f10286a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f10287b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f10288c;

        /* renamed from: d  reason: collision with root package name */
        private final SparseArray<j.b> f10289d = new SparseArray<>();

        /* renamed from: e  reason: collision with root package name */
        private final SparseArray<j.a> f10290e = new SparseArray<>();

        /* renamed from: f  reason: collision with root package name */
        private final com.google.android.exoplayer2.s.m f10291f = new com.google.android.exoplayer2.s.m(this.f10292g, 0, 0);

        /* renamed from: g  reason: collision with root package name */
        private byte[] f10292g = new byte[128];
        private int h;
        private int i;
        private long j;
        private boolean k;
        private long l;
        private C0172a m = new C0172a();
        private C0172a n = new C0172a();
        private boolean o;
        private long p;
        private long q;
        private boolean r;

        public a(m mVar, boolean z, boolean z2) {
            this.f10286a = mVar;
            this.f10287b = z;
            this.f10288c = z2;
            b();
        }

        public boolean a() {
            return this.f10288c;
        }

        public void a(j.b bVar) {
            this.f10289d.append(bVar.f11411a, bVar);
        }

        public void a(j.a aVar) {
            this.f10290e.append(aVar.f11408a, aVar);
        }

        public void b() {
            this.k = false;
            this.o = false;
            this.n.a();
        }

        public void a(long j2, int i2, long j3) {
            this.i = i2;
            this.l = j3;
            this.j = j2;
            if (!this.f10287b || this.i != 1) {
                if (this.f10288c) {
                    int i3 = this.i;
                    if (!(i3 == 5 || i3 == 1 || i3 == 2)) {
                        return;
                    }
                } else {
                    return;
                }
            }
            C0172a aVar = this.m;
            this.m = this.n;
            this.n = aVar;
            this.n.a();
            this.h = 0;
            this.k = true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:51:0x0101  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0104  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x0108  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x011a  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x0120  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0150  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(byte[] r24, int r25, int r26) {
            /*
                r23 = this;
                r0 = r23
                r1 = r25
                boolean r2 = r0.k
                if (r2 != 0) goto L_0x0009
                return
            L_0x0009:
                int r2 = r26 - r1
                byte[] r3 = r0.f10292g
                int r4 = r3.length
                int r5 = r0.h
                int r6 = r5 + r2
                r7 = 2
                if (r4 >= r6) goto L_0x001e
                int r5 = r5 + r2
                int r5 = r5 * 2
                byte[] r3 = java.util.Arrays.copyOf(r3, r5)
                r0.f10292g = r3
            L_0x001e:
                byte[] r3 = r0.f10292g
                int r4 = r0.h
                r5 = r24
                java.lang.System.arraycopy(r5, r1, r3, r4, r2)
                int r1 = r0.h
                int r1 = r1 + r2
                r0.h = r1
                com.google.android.exoplayer2.s.m r1 = r0.f10291f
                byte[] r2 = r0.f10292g
                int r3 = r0.h
                r4 = 0
                r1.a(r2, r4, r3)
                com.google.android.exoplayer2.s.m r1 = r0.f10291f
                r2 = 8
                boolean r1 = r1.b(r2)
                if (r1 != 0) goto L_0x0041
                return
            L_0x0041:
                com.google.android.exoplayer2.s.m r1 = r0.f10291f
                r1.a()
                com.google.android.exoplayer2.s.m r1 = r0.f10291f
                int r10 = r1.c(r7)
                com.google.android.exoplayer2.s.m r1 = r0.f10291f
                r2 = 5
                r1.a(r2)
                com.google.android.exoplayer2.s.m r1 = r0.f10291f
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x005b
                return
            L_0x005b:
                com.google.android.exoplayer2.s.m r1 = r0.f10291f
                r1.d()
                com.google.android.exoplayer2.s.m r1 = r0.f10291f
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x0069
                return
            L_0x0069:
                com.google.android.exoplayer2.s.m r1 = r0.f10291f
                int r11 = r1.d()
                boolean r1 = r0.f10288c
                if (r1 != 0) goto L_0x007b
                r0.k = r4
                com.google.android.exoplayer2.i.g.j$a$a r1 = r0.n
                r1.a((int) r11)
                return
            L_0x007b:
                com.google.android.exoplayer2.s.m r1 = r0.f10291f
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x0084
                return
            L_0x0084:
                com.google.android.exoplayer2.s.m r1 = r0.f10291f
                int r13 = r1.d()
                android.util.SparseArray<com.google.android.exoplayer2.s.j$a> r1 = r0.f10290e
                int r1 = r1.indexOfKey(r13)
                if (r1 >= 0) goto L_0x0095
                r0.k = r4
                return
            L_0x0095:
                android.util.SparseArray<com.google.android.exoplayer2.s.j$a> r1 = r0.f10290e
                java.lang.Object r1 = r1.get(r13)
                com.google.android.exoplayer2.s.j$a r1 = (com.google.android.exoplayer2.s.j.a) r1
                android.util.SparseArray<com.google.android.exoplayer2.s.j$b> r3 = r0.f10289d
                int r5 = r1.f11409b
                java.lang.Object r3 = r3.get(r5)
                r9 = r3
                com.google.android.exoplayer2.s.j$b r9 = (com.google.android.exoplayer2.s.j.b) r9
                boolean r3 = r9.f11415e
                if (r3 == 0) goto L_0x00ba
                com.google.android.exoplayer2.s.m r3 = r0.f10291f
                boolean r3 = r3.b(r7)
                if (r3 != 0) goto L_0x00b5
                return
            L_0x00b5:
                com.google.android.exoplayer2.s.m r3 = r0.f10291f
                r3.a(r7)
            L_0x00ba:
                com.google.android.exoplayer2.s.m r3 = r0.f10291f
                int r5 = r9.f11417g
                boolean r3 = r3.b(r5)
                if (r3 != 0) goto L_0x00c5
                return
            L_0x00c5:
                com.google.android.exoplayer2.s.m r3 = r0.f10291f
                int r5 = r9.f11417g
                int r12 = r3.c(r5)
                boolean r3 = r9.f11416f
                r5 = 1
                if (r3 != 0) goto L_0x00f9
                com.google.android.exoplayer2.s.m r3 = r0.f10291f
                boolean r3 = r3.b(r5)
                if (r3 != 0) goto L_0x00db
                return
            L_0x00db:
                com.google.android.exoplayer2.s.m r3 = r0.f10291f
                boolean r3 = r3.b()
                if (r3 == 0) goto L_0x00f7
                com.google.android.exoplayer2.s.m r6 = r0.f10291f
                boolean r6 = r6.b(r5)
                if (r6 != 0) goto L_0x00ec
                return
            L_0x00ec:
                com.google.android.exoplayer2.s.m r6 = r0.f10291f
                boolean r6 = r6.b()
                r14 = r3
                r16 = r6
                r15 = 1
                goto L_0x00fd
            L_0x00f7:
                r14 = r3
                goto L_0x00fa
            L_0x00f9:
                r14 = 0
            L_0x00fa:
                r15 = 0
                r16 = 0
            L_0x00fd:
                int r3 = r0.i
                if (r3 != r2) goto L_0x0104
                r17 = 1
                goto L_0x0106
            L_0x0104:
                r17 = 0
            L_0x0106:
                if (r17 == 0) goto L_0x011a
                com.google.android.exoplayer2.s.m r2 = r0.f10291f
                boolean r2 = r2.c()
                if (r2 != 0) goto L_0x0111
                return
            L_0x0111:
                com.google.android.exoplayer2.s.m r2 = r0.f10291f
                int r2 = r2.d()
                r18 = r2
                goto L_0x011c
            L_0x011a:
                r18 = 0
            L_0x011c:
                int r2 = r9.h
                if (r2 != 0) goto L_0x0150
                com.google.android.exoplayer2.s.m r2 = r0.f10291f
                int r3 = r9.i
                boolean r2 = r2.b(r3)
                if (r2 != 0) goto L_0x012b
                return
            L_0x012b:
                com.google.android.exoplayer2.s.m r2 = r0.f10291f
                int r3 = r9.i
                int r2 = r2.c(r3)
                boolean r1 = r1.f11410c
                if (r1 == 0) goto L_0x014d
                if (r14 != 0) goto L_0x014d
                com.google.android.exoplayer2.s.m r1 = r0.f10291f
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x0142
                return
            L_0x0142:
                com.google.android.exoplayer2.s.m r1 = r0.f10291f
                int r1 = r1.e()
                r20 = r1
                r19 = r2
                goto L_0x0190
            L_0x014d:
                r19 = r2
                goto L_0x018e
            L_0x0150:
                int r2 = r9.h
                if (r2 != r5) goto L_0x018c
                boolean r2 = r9.j
                if (r2 != 0) goto L_0x018c
                com.google.android.exoplayer2.s.m r2 = r0.f10291f
                boolean r2 = r2.c()
                if (r2 != 0) goto L_0x0161
                return
            L_0x0161:
                com.google.android.exoplayer2.s.m r2 = r0.f10291f
                int r2 = r2.e()
                boolean r1 = r1.f11410c
                if (r1 == 0) goto L_0x0185
                if (r14 != 0) goto L_0x0185
                com.google.android.exoplayer2.s.m r1 = r0.f10291f
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x0176
                return
            L_0x0176:
                com.google.android.exoplayer2.s.m r1 = r0.f10291f
                int r1 = r1.e()
                r22 = r1
                r21 = r2
                r19 = 0
                r20 = 0
                goto L_0x0194
            L_0x0185:
                r21 = r2
                r19 = 0
                r20 = 0
                goto L_0x0192
            L_0x018c:
                r19 = 0
            L_0x018e:
                r20 = 0
            L_0x0190:
                r21 = 0
            L_0x0192:
                r22 = 0
            L_0x0194:
                com.google.android.exoplayer2.i.g.j$a$a r8 = r0.n
                r8.a(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
                r0.k = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.i.g.j.a.a(byte[], int, int):void");
        }

        public void a(long j2, int i2) {
            boolean z = false;
            if (this.i == 9 || (this.f10288c && this.n.a(this.m))) {
                if (this.o) {
                    a(i2 + ((int) (j2 - this.j)));
                }
                this.p = this.j;
                this.q = this.l;
                this.r = false;
                this.o = true;
            }
            boolean z2 = this.r;
            int i3 = this.i;
            if (i3 == 5 || (this.f10287b && i3 == 1 && this.n.b())) {
                z = true;
            }
            this.r = z2 | z;
        }

        private void a(int i2) {
            boolean z = this.r;
            int i3 = (int) (this.j - this.p);
            this.f10286a.a(this.q, z ? 1 : 0, i3, i2, (m.a) null);
        }

        /* renamed from: com.google.android.exoplayer2.i.g.j$a$a  reason: collision with other inner class name */
        private static final class C0172a {

            /* renamed from: a  reason: collision with root package name */
            private boolean f10293a;

            /* renamed from: b  reason: collision with root package name */
            private boolean f10294b;

            /* renamed from: c  reason: collision with root package name */
            private j.b f10295c;

            /* renamed from: d  reason: collision with root package name */
            private int f10296d;

            /* renamed from: e  reason: collision with root package name */
            private int f10297e;

            /* renamed from: f  reason: collision with root package name */
            private int f10298f;

            /* renamed from: g  reason: collision with root package name */
            private int f10299g;
            private boolean h;
            private boolean i;
            private boolean j;
            private boolean k;
            private int l;
            private int m;
            private int n;
            private int o;
            private int p;

            private C0172a() {
            }

            public void a() {
                this.f10294b = false;
                this.f10293a = false;
            }

            public void a(int i2) {
                this.f10297e = i2;
                this.f10294b = true;
            }

            public void a(j.b bVar, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, boolean z4, int i6, int i7, int i8, int i9, int i10) {
                this.f10295c = bVar;
                this.f10296d = i2;
                this.f10297e = i3;
                this.f10298f = i4;
                this.f10299g = i5;
                this.h = z;
                this.i = z2;
                this.j = z3;
                this.k = z4;
                this.l = i6;
                this.m = i7;
                this.n = i8;
                this.o = i9;
                this.p = i10;
                this.f10293a = true;
                this.f10294b = true;
            }

            public boolean b() {
                if (this.f10294b) {
                    int i2 = this.f10297e;
                    if (i2 == 7 || i2 == 2) {
                        return true;
                    }
                }
                return false;
            }

            /* access modifiers changed from: private */
            public boolean a(C0172a aVar) {
                if (this.f10293a) {
                    if (!aVar.f10293a || this.f10298f != aVar.f10298f || this.f10299g != aVar.f10299g || this.h != aVar.h) {
                        return true;
                    }
                    if (this.i && aVar.i && this.j != aVar.j) {
                        return true;
                    }
                    int i2 = this.f10296d;
                    int i3 = aVar.f10296d;
                    if (i2 != i3 && (i2 == 0 || i3 == 0)) {
                        return true;
                    }
                    if (this.f10295c.h == 0 && aVar.f10295c.h == 0 && (this.m != aVar.m || this.n != aVar.n)) {
                        return true;
                    }
                    if (this.f10295c.h == 1 && aVar.f10295c.h == 1 && (this.o != aVar.o || this.p != aVar.p)) {
                        return true;
                    }
                    boolean z = this.k;
                    boolean z2 = aVar.k;
                    if (z == z2) {
                        return z && z2 && this.l != aVar.l;
                    }
                    return true;
                }
            }
        }
    }
}
