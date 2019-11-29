package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.g.e;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.q.f;
import com.google.android.exoplayer2.s.i;
import com.google.android.exoplayer2.source.h;
import java.io.IOException;

public final class c implements h, h.a {

    /* renamed from: a  reason: collision with root package name */
    public final h f11575a;

    /* renamed from: b  reason: collision with root package name */
    private h.a f11576b;

    /* renamed from: c  reason: collision with root package name */
    private long f11577c = -9223372036854775807L;

    /* renamed from: d  reason: collision with root package name */
    private long f11578d = -9223372036854775807L;

    /* renamed from: e  reason: collision with root package name */
    private a[] f11579e = new a[0];

    /* renamed from: f  reason: collision with root package name */
    private boolean f11580f;

    public c(h hVar, boolean z) {
        this.f11575a = hVar;
        this.f11580f = z;
    }

    public void a(long j, long j2) {
        this.f11577c = j;
        this.f11578d = j2;
    }

    public void a(h.a aVar, long j) {
        this.f11576b = aVar;
        this.f11575a.a(this, this.f11577c + j);
    }

    public void j_() throws IOException {
        this.f11575a.j_();
    }

    public p b() {
        return this.f11575a.b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0068, code lost:
        if (r12 > r3) goto L_0x006b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long a(com.google.android.exoplayer2.q.f[] r18, boolean[] r19, com.google.android.exoplayer2.source.l[] r20, boolean[] r21, long r22) {
        /*
            r17 = this;
            r8 = r17
            r9 = r20
            int r0 = r9.length
            com.google.android.exoplayer2.source.c$a[] r0 = new com.google.android.exoplayer2.source.c.a[r0]
            r8.f11579e = r0
            int r0 = r9.length
            com.google.android.exoplayer2.source.l[] r10 = new com.google.android.exoplayer2.source.l[r0]
            r0 = 0
            r1 = 0
        L_0x000e:
            int r2 = r9.length
            r11 = 0
            if (r1 >= r2) goto L_0x0029
            com.google.android.exoplayer2.source.c$a[] r2 = r8.f11579e
            r3 = r9[r1]
            com.google.android.exoplayer2.source.c$a r3 = (com.google.android.exoplayer2.source.c.a) r3
            r2[r1] = r3
            r3 = r2[r1]
            if (r3 == 0) goto L_0x0024
            r2 = r2[r1]
            com.google.android.exoplayer2.source.l r11 = r2.f11582b
        L_0x0024:
            r10[r1] = r11
            int r1 = r1 + 1
            goto L_0x000e
        L_0x0029:
            com.google.android.exoplayer2.source.h r1 = r8.f11575a
            long r2 = r8.f11577c
            long r6 = r22 + r2
            r2 = r18
            r3 = r19
            r4 = r10
            r5 = r21
            long r12 = r1.a(r2, r3, r4, r5, r6)
            boolean r1 = r8.f11580f
            r2 = 1
            if (r1 == 0) goto L_0x0052
            long r3 = r8.f11577c
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x004f
            boolean r1 = a((com.google.android.exoplayer2.q.f[]) r18)
            if (r1 == 0) goto L_0x004f
            r1 = 1
            goto L_0x0050
        L_0x004f:
            r1 = 0
        L_0x0050:
            r8.f11580f = r1
        L_0x0052:
            long r3 = r8.f11577c
            long r5 = r22 + r3
            int r1 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x006c
            int r1 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x006b
            long r3 = r8.f11578d
            r5 = -9223372036854775808
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x006c
            int r1 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x006b
            goto L_0x006c
        L_0x006b:
            r2 = 0
        L_0x006c:
            com.google.android.exoplayer2.s.a.b(r2)
            r14 = 0
        L_0x0070:
            int r0 = r9.length
            if (r14 >= r0) goto L_0x00aa
            r0 = r10[r14]
            if (r0 != 0) goto L_0x007c
            com.google.android.exoplayer2.source.c$a[] r0 = r8.f11579e
            r0[r14] = r11
            goto L_0x00a1
        L_0x007c:
            r0 = r9[r14]
            if (r0 == 0) goto L_0x008c
            com.google.android.exoplayer2.source.c$a[] r0 = r8.f11579e
            r0 = r0[r14]
            com.google.android.exoplayer2.source.l r0 = r0.f11582b
            r1 = r10[r14]
            if (r0 == r1) goto L_0x00a1
        L_0x008c:
            com.google.android.exoplayer2.source.c$a[] r15 = r8.f11579e
            com.google.android.exoplayer2.source.c$a r16 = new com.google.android.exoplayer2.source.c$a
            r2 = r10[r14]
            long r3 = r8.f11577c
            long r5 = r8.f11578d
            boolean r7 = r8.f11580f
            r0 = r16
            r1 = r17
            r0.<init>(r1, r2, r3, r5, r7)
            r15[r14] = r16
        L_0x00a1:
            com.google.android.exoplayer2.source.c$a[] r0 = r8.f11579e
            r0 = r0[r14]
            r9[r14] = r0
            int r14 = r14 + 1
            goto L_0x0070
        L_0x00aa:
            long r0 = r8.f11577c
            long r12 = r12 - r0
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.c.a(com.google.android.exoplayer2.q.f[], boolean[], com.google.android.exoplayer2.source.l[], boolean[], long):long");
    }

    public void a(long j) {
        this.f11575a.a(j + this.f11577c);
    }

    public long c() {
        if (this.f11580f) {
            for (a aVar : this.f11579e) {
                if (aVar != null) {
                    aVar.a();
                }
            }
            this.f11580f = false;
            long c2 = c();
            if (c2 != -9223372036854775807L) {
                return c2;
            }
            return 0;
        }
        long c3 = this.f11575a.c();
        if (c3 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z = true;
        com.google.android.exoplayer2.s.a.b(c3 >= this.f11577c);
        long j = this.f11578d;
        if (j != Long.MIN_VALUE && c3 > j) {
            z = false;
        }
        com.google.android.exoplayer2.s.a.b(z);
        return c3 - this.f11577c;
    }

    public long d() {
        long d2 = this.f11575a.d();
        if (d2 != Long.MIN_VALUE) {
            long j = this.f11578d;
            if (j == Long.MIN_VALUE || d2 < j) {
                return Math.max(0, d2 - this.f11577c);
            }
        }
        return Long.MIN_VALUE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        if (r0 > r7) goto L_0x0032;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long b(long r7) {
        /*
            r6 = this;
            com.google.android.exoplayer2.source.c$a[] r0 = r6.f11579e
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x0005:
            if (r3 >= r1) goto L_0x0011
            r4 = r0[r3]
            if (r4 == 0) goto L_0x000e
            r4.b()
        L_0x000e:
            int r3 = r3 + 1
            goto L_0x0005
        L_0x0011:
            com.google.android.exoplayer2.source.h r0 = r6.f11575a
            long r3 = r6.f11577c
            long r3 = r3 + r7
            long r0 = r0.b(r3)
            long r3 = r6.f11577c
            long r7 = r7 + r3
            int r5 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r5 == 0) goto L_0x0031
            int r7 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r7 < 0) goto L_0x0032
            long r7 = r6.f11578d
            r3 = -9223372036854775808
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0031
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 > 0) goto L_0x0032
        L_0x0031:
            r2 = 1
        L_0x0032:
            com.google.android.exoplayer2.s.a.b(r2)
            long r7 = r6.f11577c
            long r0 = r0 - r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.c.b(long):long");
    }

    public long e() {
        long e2 = this.f11575a.e();
        if (e2 != Long.MIN_VALUE) {
            long j = this.f11578d;
            if (j == Long.MIN_VALUE || e2 < j) {
                return e2 - this.f11577c;
            }
        }
        return Long.MIN_VALUE;
    }

    public boolean c(long j) {
        return this.f11575a.c(j + this.f11577c);
    }

    public void a(h hVar) {
        com.google.android.exoplayer2.s.a.b((this.f11577c == -9223372036854775807L || this.f11578d == -9223372036854775807L) ? false : true);
        this.f11576b.a(this);
    }

    /* renamed from: b */
    public void a(h hVar) {
        this.f11576b.a(this);
    }

    private static boolean a(f[] fVarArr) {
        for (f fVar : fVarArr) {
            if (fVar != null && !i.a(fVar.f().f8958f)) {
                return true;
            }
        }
        return false;
    }

    private static final class a implements l {

        /* renamed from: a  reason: collision with root package name */
        private final h f11581a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final l f11582b;

        /* renamed from: c  reason: collision with root package name */
        private final long f11583c;

        /* renamed from: d  reason: collision with root package name */
        private final long f11584d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f11585e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f11586f;

        public a(h hVar, l lVar, long j, long j2, boolean z) {
            this.f11581a = hVar;
            this.f11582b = lVar;
            this.f11583c = j;
            this.f11584d = j2;
            this.f11585e = z;
        }

        public void a() {
            this.f11585e = false;
        }

        public void b() {
            this.f11586f = false;
        }

        public boolean c() {
            return this.f11582b.c();
        }

        public void k_() throws IOException {
            this.f11582b.k_();
        }

        public int a(l lVar, e eVar, boolean z) {
            if (this.f11585e) {
                return -3;
            }
            if (this.f11586f) {
                eVar.b_(4);
                return -4;
            }
            int a2 = this.f11582b.a(lVar, eVar, z);
            if (this.f11584d == Long.MIN_VALUE || ((a2 != -4 || eVar.f9882c < this.f11584d) && !(a2 == -3 && this.f11581a.d() == Long.MIN_VALUE))) {
                if (a2 == -4 && !eVar.c()) {
                    eVar.f9882c -= this.f11583c;
                }
                return a2;
            }
            eVar.a();
            eVar.b_(4);
            this.f11586f = true;
            return -4;
        }

        public void a(long j) {
            this.f11582b.a(this.f11583c + j);
        }
    }
}
