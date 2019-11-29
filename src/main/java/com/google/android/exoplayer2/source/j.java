package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.s.v;

final class j {

    /* renamed from: a  reason: collision with root package name */
    private int f12086a = 1000;

    /* renamed from: b  reason: collision with root package name */
    private int[] f12087b;

    /* renamed from: c  reason: collision with root package name */
    private long[] f12088c;

    /* renamed from: d  reason: collision with root package name */
    private int[] f12089d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f12090e;

    /* renamed from: f  reason: collision with root package name */
    private long[] f12091f;

    /* renamed from: g  reason: collision with root package name */
    private m.a[] f12092g;
    private Format[] h;
    private int i;
    private int j;
    private int k;
    private int l;
    private long m;
    private long n;
    private boolean o;
    private boolean p;
    private Format q;
    private int r;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f12093a;

        /* renamed from: b  reason: collision with root package name */
        public long f12094b;

        /* renamed from: c  reason: collision with root package name */
        public m.a f12095c;
    }

    public j() {
        int i2 = this.f12086a;
        this.f12087b = new int[i2];
        this.f12088c = new long[i2];
        this.f12091f = new long[i2];
        this.f12090e = new int[i2];
        this.f12089d = new int[i2];
        this.f12092g = new m.a[i2];
        this.h = new Format[i2];
        this.m = Long.MIN_VALUE;
        this.n = Long.MIN_VALUE;
        this.p = true;
        this.o = true;
    }

    public void a(boolean z) {
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.o = true;
        this.m = Long.MIN_VALUE;
        this.n = Long.MIN_VALUE;
        if (z) {
            this.q = null;
            this.p = true;
        }
    }

    public int a() {
        return this.j + this.i;
    }

    public long a(int i2) {
        int a2 = a() - i2;
        com.google.android.exoplayer2.s.a.a(a2 >= 0 && a2 <= this.i - this.l);
        this.i -= a2;
        this.n = Math.max(this.m, d(this.i));
        int i3 = this.i;
        if (i3 == 0) {
            return 0;
        }
        int e2 = e(i3 - 1);
        return this.f12088c[e2] + ((long) this.f12089d[e2]);
    }

    public void b(int i2) {
        this.r = i2;
    }

    public int b() {
        return this.j + this.l;
    }

    public int c() {
        return d() ? this.f12087b[e(this.l)] : this.r;
    }

    public synchronized boolean d() {
        return this.l != this.i;
    }

    public synchronized Format e() {
        return this.p ? null : this.q;
    }

    public synchronized long f() {
        return this.n;
    }

    public synchronized void g() {
        this.l = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0023, code lost:
        return -3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int a(com.google.android.exoplayer2.l r5, com.google.android.exoplayer2.g.e r6, boolean r7, boolean r8, com.google.android.exoplayer2.Format r9, com.google.android.exoplayer2.source.j.a r10) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.d()     // Catch:{ all -> 0x006a }
            r1 = -5
            r2 = -3
            r3 = -4
            if (r0 != 0) goto L_0x0024
            if (r8 == 0) goto L_0x0012
            r5 = 4
            r6.b_(r5)     // Catch:{ all -> 0x006a }
            monitor-exit(r4)
            return r3
        L_0x0012:
            com.google.android.exoplayer2.Format r6 = r4.q     // Catch:{ all -> 0x006a }
            if (r6 == 0) goto L_0x0022
            if (r7 != 0) goto L_0x001c
            com.google.android.exoplayer2.Format r6 = r4.q     // Catch:{ all -> 0x006a }
            if (r6 == r9) goto L_0x0022
        L_0x001c:
            com.google.android.exoplayer2.Format r6 = r4.q     // Catch:{ all -> 0x006a }
            r5.f10690a = r6     // Catch:{ all -> 0x006a }
            monitor-exit(r4)
            return r1
        L_0x0022:
            monitor-exit(r4)
            return r2
        L_0x0024:
            int r8 = r4.l     // Catch:{ all -> 0x006a }
            int r8 = r4.e(r8)     // Catch:{ all -> 0x006a }
            if (r7 != 0) goto L_0x0062
            com.google.android.exoplayer2.Format[] r7 = r4.h     // Catch:{ all -> 0x006a }
            r7 = r7[r8]     // Catch:{ all -> 0x006a }
            if (r7 == r9) goto L_0x0033
            goto L_0x0062
        L_0x0033:
            boolean r5 = r6.f()     // Catch:{ all -> 0x006a }
            if (r5 == 0) goto L_0x003b
            monitor-exit(r4)
            return r2
        L_0x003b:
            long[] r5 = r4.f12091f     // Catch:{ all -> 0x006a }
            r0 = r5[r8]     // Catch:{ all -> 0x006a }
            r6.f9882c = r0     // Catch:{ all -> 0x006a }
            int[] r5 = r4.f12090e     // Catch:{ all -> 0x006a }
            r5 = r5[r8]     // Catch:{ all -> 0x006a }
            r6.b_(r5)     // Catch:{ all -> 0x006a }
            int[] r5 = r4.f12089d     // Catch:{ all -> 0x006a }
            r5 = r5[r8]     // Catch:{ all -> 0x006a }
            r10.f12093a = r5     // Catch:{ all -> 0x006a }
            long[] r5 = r4.f12088c     // Catch:{ all -> 0x006a }
            r6 = r5[r8]     // Catch:{ all -> 0x006a }
            r10.f12094b = r6     // Catch:{ all -> 0x006a }
            com.google.android.exoplayer2.i.m$a[] r5 = r4.f12092g     // Catch:{ all -> 0x006a }
            r5 = r5[r8]     // Catch:{ all -> 0x006a }
            r10.f12095c = r5     // Catch:{ all -> 0x006a }
            int r5 = r4.l     // Catch:{ all -> 0x006a }
            int r5 = r5 + 1
            r4.l = r5     // Catch:{ all -> 0x006a }
            monitor-exit(r4)
            return r3
        L_0x0062:
            com.google.android.exoplayer2.Format[] r6 = r4.h     // Catch:{ all -> 0x006a }
            r6 = r6[r8]     // Catch:{ all -> 0x006a }
            r5.f10690a = r6     // Catch:{ all -> 0x006a }
            monitor-exit(r4)
            return r1
        L_0x006a:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.j.a(com.google.android.exoplayer2.l, com.google.android.exoplayer2.g.e, boolean, boolean, com.google.android.exoplayer2.Format, com.google.android.exoplayer2.source.j$a):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean a(long r9, boolean r11, boolean r12) {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = r8.l     // Catch:{ all -> 0x003b }
            int r2 = r8.e(r0)     // Catch:{ all -> 0x003b }
            boolean r0 = r8.d()     // Catch:{ all -> 0x003b }
            r7 = 0
            if (r0 == 0) goto L_0x0039
            long[] r0 = r8.f12091f     // Catch:{ all -> 0x003b }
            r3 = r0[r2]     // Catch:{ all -> 0x003b }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x0039
            long r0 = r8.n     // Catch:{ all -> 0x003b }
            int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x001f
            if (r12 != 0) goto L_0x001f
            goto L_0x0039
        L_0x001f:
            int r12 = r8.i     // Catch:{ all -> 0x003b }
            int r0 = r8.l     // Catch:{ all -> 0x003b }
            int r3 = r12 - r0
            r1 = r8
            r4 = r9
            r6 = r11
            int r9 = r1.a(r2, r3, r4, r6)     // Catch:{ all -> 0x003b }
            r10 = -1
            if (r9 != r10) goto L_0x0031
            monitor-exit(r8)
            return r7
        L_0x0031:
            int r10 = r8.l     // Catch:{ all -> 0x003b }
            int r10 = r10 + r9
            r8.l = r10     // Catch:{ all -> 0x003b }
            r9 = 1
            monitor-exit(r8)
            return r9
        L_0x0039:
            monitor-exit(r8)
            return r7
        L_0x003b:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.j.a(long, boolean, boolean):boolean");
    }

    public synchronized void h() {
        if (d()) {
            this.l = this.i;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0037, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized long b(long r10, boolean r12, boolean r13) {
        /*
            r9 = this;
            monitor-enter(r9)
            int r0 = r9.i     // Catch:{ all -> 0x0038 }
            r1 = -1
            if (r0 == 0) goto L_0x0036
            long[] r0 = r9.f12091f     // Catch:{ all -> 0x0038 }
            int r3 = r9.k     // Catch:{ all -> 0x0038 }
            r3 = r0[r3]     // Catch:{ all -> 0x0038 }
            int r0 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0012
            goto L_0x0036
        L_0x0012:
            if (r13 == 0) goto L_0x001f
            int r13 = r9.l     // Catch:{ all -> 0x0038 }
            int r0 = r9.i     // Catch:{ all -> 0x0038 }
            if (r13 == r0) goto L_0x001f
            int r13 = r9.l     // Catch:{ all -> 0x0038 }
            int r13 = r13 + 1
            goto L_0x0021
        L_0x001f:
            int r13 = r9.i     // Catch:{ all -> 0x0038 }
        L_0x0021:
            r5 = r13
            int r4 = r9.k     // Catch:{ all -> 0x0038 }
            r3 = r9
            r6 = r10
            r8 = r12
            int r10 = r3.a(r4, r5, r6, r8)     // Catch:{ all -> 0x0038 }
            r11 = -1
            if (r10 != r11) goto L_0x0030
            monitor-exit(r9)
            return r1
        L_0x0030:
            long r10 = r9.c(r10)     // Catch:{ all -> 0x0038 }
            monitor-exit(r9)
            return r10
        L_0x0036:
            monitor-exit(r9)
            return r1
        L_0x0038:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.j.b(long, boolean, boolean):long");
    }

    public synchronized long i() {
        if (this.l == 0) {
            return -1;
        }
        return c(this.l);
    }

    public synchronized long j() {
        if (this.i == 0) {
            return -1;
        }
        return c(this.i);
    }

    public synchronized boolean a(Format format) {
        if (format == null) {
            this.p = true;
            return false;
        }
        this.p = false;
        if (v.a((Object) format, (Object) this.q)) {
            return false;
        }
        this.q = format;
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00d1, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(long r6, int r8, long r9, int r11, com.google.android.exoplayer2.i.m.a r12) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.o     // Catch:{ all -> 0x00d2 }
            r1 = 0
            if (r0 == 0) goto L_0x000e
            r0 = r8 & 1
            if (r0 != 0) goto L_0x000c
            monitor-exit(r5)
            return
        L_0x000c:
            r5.o = r1     // Catch:{ all -> 0x00d2 }
        L_0x000e:
            boolean r0 = r5.p     // Catch:{ all -> 0x00d2 }
            r2 = 1
            if (r0 != 0) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            com.google.android.exoplayer2.s.a.b(r0)     // Catch:{ all -> 0x00d2 }
            r5.a((long) r6)     // Catch:{ all -> 0x00d2 }
            int r0 = r5.i     // Catch:{ all -> 0x00d2 }
            int r0 = r5.e(r0)     // Catch:{ all -> 0x00d2 }
            long[] r3 = r5.f12091f     // Catch:{ all -> 0x00d2 }
            r3[r0] = r6     // Catch:{ all -> 0x00d2 }
            long[] r6 = r5.f12088c     // Catch:{ all -> 0x00d2 }
            r6[r0] = r9     // Catch:{ all -> 0x00d2 }
            int[] r6 = r5.f12089d     // Catch:{ all -> 0x00d2 }
            r6[r0] = r11     // Catch:{ all -> 0x00d2 }
            int[] r6 = r5.f12090e     // Catch:{ all -> 0x00d2 }
            r6[r0] = r8     // Catch:{ all -> 0x00d2 }
            com.google.android.exoplayer2.i.m$a[] r6 = r5.f12092g     // Catch:{ all -> 0x00d2 }
            r6[r0] = r12     // Catch:{ all -> 0x00d2 }
            com.google.android.exoplayer2.Format[] r6 = r5.h     // Catch:{ all -> 0x00d2 }
            com.google.android.exoplayer2.Format r7 = r5.q     // Catch:{ all -> 0x00d2 }
            r6[r0] = r7     // Catch:{ all -> 0x00d2 }
            int[] r6 = r5.f12087b     // Catch:{ all -> 0x00d2 }
            int r7 = r5.r     // Catch:{ all -> 0x00d2 }
            r6[r0] = r7     // Catch:{ all -> 0x00d2 }
            int r6 = r5.i     // Catch:{ all -> 0x00d2 }
            int r6 = r6 + r2
            r5.i = r6     // Catch:{ all -> 0x00d2 }
            int r6 = r5.i     // Catch:{ all -> 0x00d2 }
            int r7 = r5.f12086a     // Catch:{ all -> 0x00d2 }
            if (r6 != r7) goto L_0x00d0
            int r6 = r5.f12086a     // Catch:{ all -> 0x00d2 }
            int r6 = r6 + 1000
            int[] r7 = new int[r6]     // Catch:{ all -> 0x00d2 }
            long[] r8 = new long[r6]     // Catch:{ all -> 0x00d2 }
            long[] r9 = new long[r6]     // Catch:{ all -> 0x00d2 }
            int[] r10 = new int[r6]     // Catch:{ all -> 0x00d2 }
            int[] r11 = new int[r6]     // Catch:{ all -> 0x00d2 }
            com.google.android.exoplayer2.i.m$a[] r12 = new com.google.android.exoplayer2.i.m.a[r6]     // Catch:{ all -> 0x00d2 }
            com.google.android.exoplayer2.Format[] r0 = new com.google.android.exoplayer2.Format[r6]     // Catch:{ all -> 0x00d2 }
            int r2 = r5.f12086a     // Catch:{ all -> 0x00d2 }
            int r3 = r5.k     // Catch:{ all -> 0x00d2 }
            int r2 = r2 - r3
            long[] r3 = r5.f12088c     // Catch:{ all -> 0x00d2 }
            int r4 = r5.k     // Catch:{ all -> 0x00d2 }
            java.lang.System.arraycopy(r3, r4, r8, r1, r2)     // Catch:{ all -> 0x00d2 }
            long[] r3 = r5.f12091f     // Catch:{ all -> 0x00d2 }
            int r4 = r5.k     // Catch:{ all -> 0x00d2 }
            java.lang.System.arraycopy(r3, r4, r9, r1, r2)     // Catch:{ all -> 0x00d2 }
            int[] r3 = r5.f12090e     // Catch:{ all -> 0x00d2 }
            int r4 = r5.k     // Catch:{ all -> 0x00d2 }
            java.lang.System.arraycopy(r3, r4, r10, r1, r2)     // Catch:{ all -> 0x00d2 }
            int[] r3 = r5.f12089d     // Catch:{ all -> 0x00d2 }
            int r4 = r5.k     // Catch:{ all -> 0x00d2 }
            java.lang.System.arraycopy(r3, r4, r11, r1, r2)     // Catch:{ all -> 0x00d2 }
            com.google.android.exoplayer2.i.m$a[] r3 = r5.f12092g     // Catch:{ all -> 0x00d2 }
            int r4 = r5.k     // Catch:{ all -> 0x00d2 }
            java.lang.System.arraycopy(r3, r4, r12, r1, r2)     // Catch:{ all -> 0x00d2 }
            com.google.android.exoplayer2.Format[] r3 = r5.h     // Catch:{ all -> 0x00d2 }
            int r4 = r5.k     // Catch:{ all -> 0x00d2 }
            java.lang.System.arraycopy(r3, r4, r0, r1, r2)     // Catch:{ all -> 0x00d2 }
            int[] r3 = r5.f12087b     // Catch:{ all -> 0x00d2 }
            int r4 = r5.k     // Catch:{ all -> 0x00d2 }
            java.lang.System.arraycopy(r3, r4, r7, r1, r2)     // Catch:{ all -> 0x00d2 }
            int r3 = r5.k     // Catch:{ all -> 0x00d2 }
            long[] r4 = r5.f12088c     // Catch:{ all -> 0x00d2 }
            java.lang.System.arraycopy(r4, r1, r8, r2, r3)     // Catch:{ all -> 0x00d2 }
            long[] r4 = r5.f12091f     // Catch:{ all -> 0x00d2 }
            java.lang.System.arraycopy(r4, r1, r9, r2, r3)     // Catch:{ all -> 0x00d2 }
            int[] r4 = r5.f12090e     // Catch:{ all -> 0x00d2 }
            java.lang.System.arraycopy(r4, r1, r10, r2, r3)     // Catch:{ all -> 0x00d2 }
            int[] r4 = r5.f12089d     // Catch:{ all -> 0x00d2 }
            java.lang.System.arraycopy(r4, r1, r11, r2, r3)     // Catch:{ all -> 0x00d2 }
            com.google.android.exoplayer2.i.m$a[] r4 = r5.f12092g     // Catch:{ all -> 0x00d2 }
            java.lang.System.arraycopy(r4, r1, r12, r2, r3)     // Catch:{ all -> 0x00d2 }
            com.google.android.exoplayer2.Format[] r4 = r5.h     // Catch:{ all -> 0x00d2 }
            java.lang.System.arraycopy(r4, r1, r0, r2, r3)     // Catch:{ all -> 0x00d2 }
            int[] r4 = r5.f12087b     // Catch:{ all -> 0x00d2 }
            java.lang.System.arraycopy(r4, r1, r7, r2, r3)     // Catch:{ all -> 0x00d2 }
            r5.f12088c = r8     // Catch:{ all -> 0x00d2 }
            r5.f12091f = r9     // Catch:{ all -> 0x00d2 }
            r5.f12090e = r10     // Catch:{ all -> 0x00d2 }
            r5.f12089d = r11     // Catch:{ all -> 0x00d2 }
            r5.f12092g = r12     // Catch:{ all -> 0x00d2 }
            r5.h = r0     // Catch:{ all -> 0x00d2 }
            r5.f12087b = r7     // Catch:{ all -> 0x00d2 }
            r5.k = r1     // Catch:{ all -> 0x00d2 }
            int r7 = r5.f12086a     // Catch:{ all -> 0x00d2 }
            r5.i = r7     // Catch:{ all -> 0x00d2 }
            r5.f12086a = r6     // Catch:{ all -> 0x00d2 }
        L_0x00d0:
            monitor-exit(r5)
            return
        L_0x00d2:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.j.a(long, int, long, int, com.google.android.exoplayer2.i.m$a):void");
    }

    public synchronized void a(long j2) {
        this.n = Math.max(this.n, j2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean b(long r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            int r0 = r7.i     // Catch:{ all -> 0x004a }
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0010
            long r3 = r7.m     // Catch:{ all -> 0x004a }
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x000e
            r1 = 1
        L_0x000e:
            monitor-exit(r7)
            return r1
        L_0x0010:
            long r3 = r7.m     // Catch:{ all -> 0x004a }
            int r0 = r7.l     // Catch:{ all -> 0x004a }
            long r5 = r7.d(r0)     // Catch:{ all -> 0x004a }
            long r3 = java.lang.Math.max(r3, r5)     // Catch:{ all -> 0x004a }
            int r0 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r0 < 0) goto L_0x0022
            monitor-exit(r7)
            return r1
        L_0x0022:
            int r0 = r7.i     // Catch:{ all -> 0x004a }
            int r1 = r7.i     // Catch:{ all -> 0x004a }
            int r1 = r1 - r2
            int r1 = r7.e(r1)     // Catch:{ all -> 0x004a }
        L_0x002b:
            int r3 = r7.l     // Catch:{ all -> 0x004a }
            if (r0 <= r3) goto L_0x0042
            long[] r3 = r7.f12091f     // Catch:{ all -> 0x004a }
            r4 = r3[r1]     // Catch:{ all -> 0x004a }
            int r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r3 < 0) goto L_0x0042
            int r0 = r0 + -1
            int r1 = r1 + -1
            r3 = -1
            if (r1 != r3) goto L_0x002b
            int r1 = r7.f12086a     // Catch:{ all -> 0x004a }
            int r1 = r1 - r2
            goto L_0x002b
        L_0x0042:
            int r8 = r7.j     // Catch:{ all -> 0x004a }
            int r8 = r8 + r0
            r7.a((int) r8)     // Catch:{ all -> 0x004a }
            monitor-exit(r7)
            return r2
        L_0x004a:
            r8 = move-exception
            monitor-exit(r7)
            goto L_0x004e
        L_0x004d:
            throw r8
        L_0x004e:
            goto L_0x004d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.j.b(long):boolean");
    }

    private int a(int i2, int i3, long j2, boolean z) {
        int i4 = i2;
        int i5 = -1;
        for (int i6 = 0; i6 < i3 && this.f12091f[i4] <= j2; i6++) {
            if (!z || (this.f12090e[i4] & 1) != 0) {
                i5 = i6;
            }
            i4++;
            if (i4 == this.f12086a) {
                i4 = 0;
            }
        }
        return i5;
    }

    private long c(int i2) {
        this.m = Math.max(this.m, d(i2));
        this.i -= i2;
        this.j += i2;
        this.k += i2;
        int i3 = this.k;
        int i4 = this.f12086a;
        if (i3 >= i4) {
            this.k = i3 - i4;
        }
        this.l -= i2;
        if (this.l < 0) {
            this.l = 0;
        }
        if (this.i != 0) {
            return this.f12088c[this.k];
        }
        int i5 = this.k;
        if (i5 == 0) {
            i5 = this.f12086a;
        }
        int i6 = i5 - 1;
        return this.f12088c[i6] + ((long) this.f12089d[i6]);
    }

    private long d(int i2) {
        long j2 = Long.MIN_VALUE;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int e2 = e(i2 - 1);
        for (int i3 = 0; i3 < i2; i3++) {
            j2 = Math.max(j2, this.f12091f[e2]);
            if ((this.f12090e[e2] & 1) != 0) {
                break;
            }
            e2--;
            if (e2 == -1) {
                e2 = this.f12086a - 1;
            }
        }
        return j2;
    }

    private int e(int i2) {
        int i3 = this.k + i2;
        int i4 = this.f12086a;
        return i3 < i4 ? i3 : i3 - i4;
    }
}
