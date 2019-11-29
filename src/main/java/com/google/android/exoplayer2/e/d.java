package com.google.android.exoplayer2.e;

import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.ah;
import com.google.android.exoplayer2.d.e;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.t;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public final class d implements n {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.exoplayer2.m.b f9390a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9391b;

    /* renamed from: c  reason: collision with root package name */
    private final b f9392c = new b();

    /* renamed from: d  reason: collision with root package name */
    private final LinkedBlockingDeque<com.google.android.exoplayer2.m.a> f9393d = new LinkedBlockingDeque<>();

    /* renamed from: e  reason: collision with root package name */
    private final a f9394e = new a();

    /* renamed from: f  reason: collision with root package name */
    private final k f9395f = new k(32);

    /* renamed from: g  reason: collision with root package name */
    private final AtomicInteger f9396g = new AtomicInteger();
    private long h;
    private j i;
    private boolean j;
    private j k;
    private long l;
    private long m;
    private com.google.android.exoplayer2.m.a n;
    private int o = this.f9391b;
    private boolean p;
    private c q;

    public interface c {
        void a(j jVar);
    }

    public d(com.google.android.exoplayer2.m.b bVar) {
        this.f9390a = bVar;
        this.f9391b = bVar.c();
    }

    public void a(boolean z) {
        int andSet = this.f9396g.getAndSet(z ? 0 : 2);
        l();
        this.f9392c.b();
        if (andSet == 2) {
            this.i = null;
        }
    }

    public void a(int i2) {
        this.f9392c.b(i2);
    }

    public void a() {
        this.p = true;
    }

    public int b() {
        return this.f9392c.c();
    }

    public void b(int i2) {
        this.m = this.f9392c.a(i2);
        b(this.m);
    }

    private void b(long j2) {
        int i2 = (int) (j2 - this.h);
        int i3 = this.f9391b;
        int i4 = i2 / i3;
        int i5 = i2 % i3;
        int size = (this.f9393d.size() - i4) - 1;
        if (i5 == 0) {
            size++;
        }
        for (int i6 = 0; i6 < size; i6++) {
            this.f9390a.a(this.f9393d.removeLast());
        }
        this.n = this.f9393d.peekLast();
        if (i5 == 0) {
            i5 = this.f9391b;
        }
        this.o = i5;
    }

    public void c() {
        if (this.f9396g.getAndSet(2) == 0) {
            l();
        }
    }

    public boolean d() {
        return this.f9392c.f();
    }

    public int e() {
        return this.f9392c.d();
    }

    public int f() {
        return this.f9392c.e();
    }

    public j g() {
        return this.f9392c.g();
    }

    public long h() {
        return this.f9392c.h();
    }

    public void i() {
        long i2 = this.f9392c.i();
        if (i2 != -1) {
            c(i2);
        }
    }

    public boolean a(long j2, boolean z) {
        long a2 = this.f9392c.a(j2, z);
        if (a2 == -1) {
            return false;
        }
        c(a2);
        return true;
    }

    public int a(ah ahVar, e eVar, boolean z, boolean z2, long j2) {
        int a2 = this.f9392c.a(ahVar, eVar, z, z2, this.i, this.f9394e);
        if (a2 == -5) {
            this.i = ahVar.f9107a;
            return -5;
        } else if (a2 == -4) {
            if (!eVar.c()) {
                if (eVar.f9281c < j2) {
                    eVar.b(RNCartPanelDataEntity.NULL_VALUE);
                }
                if (eVar.g()) {
                    a(eVar, this.f9394e);
                }
                eVar.e(this.f9394e.f9397a);
                a(this.f9394e.f9398b, eVar.f9280b, this.f9394e.f9397a);
                c(this.f9394e.f9399c);
            }
            return -4;
        } else if (a2 == -3) {
            return -3;
        } else {
            throw new IllegalStateException();
        }
    }

    private void a(e eVar, a aVar) {
        int i2;
        long j2 = aVar.f9398b;
        this.f9395f.a(1);
        a(j2, this.f9395f.f10948a, 1);
        long j3 = j2 + 1;
        byte b2 = this.f9395f.f10948a[0];
        boolean z = (b2 & 128) != 0;
        byte b3 = b2 & Byte.MAX_VALUE;
        if (eVar.f9279a.f9263a == null) {
            eVar.f9279a.f9263a = new byte[16];
        }
        a(j3, eVar.f9279a.f9263a, (int) b3);
        long j4 = j3 + ((long) b3);
        if (z) {
            this.f9395f.a(2);
            a(j4, this.f9395f.f10948a, 2);
            j4 += 2;
            i2 = this.f9395f.h();
        } else {
            i2 = 1;
        }
        int[] iArr = eVar.f9279a.f9266d;
        if (iArr == null || iArr.length < i2) {
            iArr = new int[i2];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = eVar.f9279a.f9267e;
        if (iArr3 == null || iArr3.length < i2) {
            iArr3 = new int[i2];
        }
        int[] iArr4 = iArr3;
        if (z) {
            int i3 = i2 * 6;
            this.f9395f.a(i3);
            a(j4, this.f9395f.f10948a, i3);
            j4 += (long) i3;
            this.f9395f.c(0);
            for (int i4 = 0; i4 < i2; i4++) {
                iArr2[i4] = this.f9395f.h();
                iArr4[i4] = this.f9395f.t();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = aVar.f9397a - ((int) (j4 - aVar.f9398b));
        }
        eVar.f9279a.a(i2, iArr2, iArr4, aVar.f9400d, eVar.f9279a.f9263a, 1);
        int i5 = (int) (j4 - aVar.f9398b);
        aVar.f9398b += (long) i5;
        aVar.f9397a -= i5;
    }

    private void a(long j2, ByteBuffer byteBuffer, int i2) {
        while (i2 > 0) {
            c(j2);
            int i3 = (int) (j2 - this.h);
            int min = Math.min(i2, this.f9391b - i3);
            com.google.android.exoplayer2.m.a peek = this.f9393d.peek();
            byteBuffer.put(peek.f10743a, peek.a(i3), min);
            j2 += (long) min;
            i2 -= min;
        }
    }

    private void a(long j2, byte[] bArr, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            c(j2);
            int i4 = (int) (j2 - this.h);
            int min = Math.min(i2 - i3, this.f9391b - i4);
            com.google.android.exoplayer2.m.a peek = this.f9393d.peek();
            System.arraycopy(peek.f10743a, peek.a(i4), bArr, i3, min);
            j2 += (long) min;
            i3 += min;
        }
    }

    private void c(long j2) {
        int i2 = ((int) (j2 - this.h)) / this.f9391b;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f9390a.a(this.f9393d.remove());
            this.h += (long) this.f9391b;
        }
    }

    public void a(c cVar) {
        this.q = cVar;
    }

    public void a(long j2) {
        if (this.l != j2) {
            this.l = j2;
            this.j = true;
        }
    }

    public void a(j jVar) {
        j a2 = a(jVar, this.l);
        boolean a3 = this.f9392c.a(a2);
        this.k = jVar;
        this.j = false;
        c cVar = this.q;
        if (cVar != null && a3) {
            cVar.a(a2);
        }
    }

    public int a(g gVar, int i2, boolean z) throws IOException, InterruptedException {
        if (!j()) {
            int a2 = gVar.a(i2);
            if (a2 != -1) {
                return a2;
            }
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        try {
            int a3 = gVar.a(this.n.f10743a, this.n.a(this.o), c(i2));
            if (a3 != -1) {
                this.o += a3;
                this.m += (long) a3;
                k();
                return a3;
            } else if (z) {
                return -1;
            } else {
                throw new EOFException();
            }
        } finally {
            k();
        }
    }

    public void a(k kVar, int i2) {
        if (!j()) {
            kVar.d(i2);
            return;
        }
        while (i2 > 0) {
            int c2 = c(i2);
            kVar.a(this.n.f10743a, this.n.a(this.o), c2);
            this.o += c2;
            this.m += (long) c2;
            i2 -= c2;
        }
        k();
    }

    public void a(long j2, int i2, int i3, int i4, byte[] bArr) {
        long j3 = j2;
        if (this.j) {
            a(this.k);
        }
        if (!j()) {
            this.f9392c.a(j2);
            return;
        }
        try {
            if (this.p) {
                if ((i2 & 1) != 0) {
                    if (this.f9392c.b(j2)) {
                        this.p = false;
                    }
                }
                return;
            }
            this.f9392c.a(this.l + j3, i2, (this.m - ((long) i3)) - ((long) i4), i3, bArr);
            k();
        } finally {
            k();
        }
    }

    private boolean j() {
        return this.f9396g.compareAndSet(0, 1);
    }

    private void k() {
        if (!this.f9396g.compareAndSet(1, 0)) {
            l();
        }
    }

    private void l() {
        this.f9392c.a();
        com.google.android.exoplayer2.m.b bVar = this.f9390a;
        LinkedBlockingDeque<com.google.android.exoplayer2.m.a> linkedBlockingDeque = this.f9393d;
        bVar.a((com.google.android.exoplayer2.m.a[]) linkedBlockingDeque.toArray(new com.google.android.exoplayer2.m.a[linkedBlockingDeque.size()]));
        this.f9393d.clear();
        this.f9390a.b();
        this.h = 0;
        this.m = 0;
        this.n = null;
        this.o = this.f9391b;
    }

    private int c(int i2) {
        if (this.o == this.f9391b) {
            this.o = 0;
            this.n = this.f9390a.a();
            this.f9393d.add(this.n);
        }
        return Math.min(i2, this.f9391b - this.o);
    }

    private static j a(j jVar, long j2) {
        if (jVar == null) {
            return null;
        }
        return (j2 == 0 || jVar.w == Clock.MAX_TIME) ? jVar : jVar.a(jVar.w + j2);
    }

    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        private int f9408a = 1000;

        /* renamed from: b  reason: collision with root package name */
        private int[] f9409b;

        /* renamed from: c  reason: collision with root package name */
        private long[] f9410c;

        /* renamed from: d  reason: collision with root package name */
        private int[] f9411d;

        /* renamed from: e  reason: collision with root package name */
        private int[] f9412e;

        /* renamed from: f  reason: collision with root package name */
        private long[] f9413f;

        /* renamed from: g  reason: collision with root package name */
        private byte[][] f9414g;
        private j[] h;
        private int i;
        private int j;
        private int k;
        private int l;
        private long m;
        private long n;
        private boolean o;
        private boolean p;
        private j q;
        private int r;

        public b() {
            int i2 = this.f9408a;
            this.f9409b = new int[i2];
            this.f9410c = new long[i2];
            this.f9413f = new long[i2];
            this.f9412e = new int[i2];
            this.f9411d = new int[i2];
            this.f9414g = new byte[i2][];
            this.h = new j[i2];
            this.m = Long.MIN_VALUE;
            this.n = Long.MIN_VALUE;
            this.p = true;
            this.o = true;
        }

        public void a() {
            this.j = 0;
            this.k = 0;
            this.l = 0;
            this.i = 0;
            this.o = true;
        }

        public void b() {
            this.m = Long.MIN_VALUE;
            this.n = Long.MIN_VALUE;
        }

        public int c() {
            return this.j + this.i;
        }

        public long a(int i2) {
            int c2 = c() - i2;
            com.google.android.exoplayer2.n.a.a(c2 >= 0 && c2 <= this.i);
            if (c2 != 0) {
                this.i -= c2;
                int i3 = this.l;
                int i4 = this.f9408a;
                this.l = ((i3 + i4) - c2) % i4;
                this.n = Long.MIN_VALUE;
                for (int i5 = this.i - 1; i5 >= 0; i5--) {
                    int i6 = (this.k + i5) % this.f9408a;
                    this.n = Math.max(this.n, this.f9413f[i6]);
                    if ((this.f9412e[i6] & 1) != 0) {
                        break;
                    }
                }
                return this.f9410c[this.l];
            } else if (this.j == 0) {
                return 0;
            } else {
                int i7 = this.l;
                if (i7 == 0) {
                    i7 = this.f9408a;
                }
                int i8 = i7 - 1;
                return this.f9410c[i8] + ((long) this.f9411d[i8]);
            }
        }

        public void b(int i2) {
            this.r = i2;
        }

        public int d() {
            return this.j;
        }

        public int e() {
            return this.i == 0 ? this.r : this.f9409b[this.k];
        }

        public synchronized boolean f() {
            return this.i == 0;
        }

        public synchronized j g() {
            return this.p ? null : this.q;
        }

        public synchronized long h() {
            return Math.max(this.m, this.n);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0021, code lost:
            return -3;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized int a(com.google.android.exoplayer2.ah r5, com.google.android.exoplayer2.d.e r6, boolean r7, boolean r8, com.google.android.exoplayer2.j r9, com.google.android.exoplayer2.e.d.a r10) {
            /*
                r4 = this;
                monitor-enter(r4)
                int r0 = r4.i     // Catch:{ all -> 0x00a3 }
                r1 = -5
                r2 = -3
                r3 = -4
                if (r0 != 0) goto L_0x0022
                if (r8 == 0) goto L_0x0010
                r5 = 4
                r6.a_(r5)     // Catch:{ all -> 0x00a3 }
                monitor-exit(r4)
                return r3
            L_0x0010:
                com.google.android.exoplayer2.j r6 = r4.q     // Catch:{ all -> 0x00a3 }
                if (r6 == 0) goto L_0x0020
                if (r7 != 0) goto L_0x001a
                com.google.android.exoplayer2.j r6 = r4.q     // Catch:{ all -> 0x00a3 }
                if (r6 == r9) goto L_0x0020
            L_0x001a:
                com.google.android.exoplayer2.j r6 = r4.q     // Catch:{ all -> 0x00a3 }
                r5.f9107a = r6     // Catch:{ all -> 0x00a3 }
                monitor-exit(r4)
                return r1
            L_0x0020:
                monitor-exit(r4)
                return r2
            L_0x0022:
                if (r7 != 0) goto L_0x0099
                com.google.android.exoplayer2.j[] r7 = r4.h     // Catch:{ all -> 0x00a3 }
                int r8 = r4.k     // Catch:{ all -> 0x00a3 }
                r7 = r7[r8]     // Catch:{ all -> 0x00a3 }
                if (r7 == r9) goto L_0x002d
                goto L_0x0099
            L_0x002d:
                boolean r5 = r6.f()     // Catch:{ all -> 0x00a3 }
                if (r5 == 0) goto L_0x0035
                monitor-exit(r4)
                return r2
            L_0x0035:
                long[] r5 = r4.f9413f     // Catch:{ all -> 0x00a3 }
                int r7 = r4.k     // Catch:{ all -> 0x00a3 }
                r7 = r5[r7]     // Catch:{ all -> 0x00a3 }
                r6.f9281c = r7     // Catch:{ all -> 0x00a3 }
                int[] r5 = r4.f9412e     // Catch:{ all -> 0x00a3 }
                int r7 = r4.k     // Catch:{ all -> 0x00a3 }
                r5 = r5[r7]     // Catch:{ all -> 0x00a3 }
                r6.a_(r5)     // Catch:{ all -> 0x00a3 }
                int[] r5 = r4.f9411d     // Catch:{ all -> 0x00a3 }
                int r7 = r4.k     // Catch:{ all -> 0x00a3 }
                r5 = r5[r7]     // Catch:{ all -> 0x00a3 }
                r10.f9397a = r5     // Catch:{ all -> 0x00a3 }
                long[] r5 = r4.f9410c     // Catch:{ all -> 0x00a3 }
                int r7 = r4.k     // Catch:{ all -> 0x00a3 }
                r7 = r5[r7]     // Catch:{ all -> 0x00a3 }
                r10.f9398b = r7     // Catch:{ all -> 0x00a3 }
                byte[][] r5 = r4.f9414g     // Catch:{ all -> 0x00a3 }
                int r7 = r4.k     // Catch:{ all -> 0x00a3 }
                r5 = r5[r7]     // Catch:{ all -> 0x00a3 }
                r10.f9400d = r5     // Catch:{ all -> 0x00a3 }
                long r7 = r4.m     // Catch:{ all -> 0x00a3 }
                long r5 = r6.f9281c     // Catch:{ all -> 0x00a3 }
                long r5 = java.lang.Math.max(r7, r5)     // Catch:{ all -> 0x00a3 }
                r4.m = r5     // Catch:{ all -> 0x00a3 }
                int r5 = r4.i     // Catch:{ all -> 0x00a3 }
                int r5 = r5 + -1
                r4.i = r5     // Catch:{ all -> 0x00a3 }
                int r5 = r4.k     // Catch:{ all -> 0x00a3 }
                int r5 = r5 + 1
                r4.k = r5     // Catch:{ all -> 0x00a3 }
                int r5 = r4.j     // Catch:{ all -> 0x00a3 }
                int r5 = r5 + 1
                r4.j = r5     // Catch:{ all -> 0x00a3 }
                int r5 = r4.k     // Catch:{ all -> 0x00a3 }
                int r6 = r4.f9408a     // Catch:{ all -> 0x00a3 }
                if (r5 != r6) goto L_0x0083
                r5 = 0
                r4.k = r5     // Catch:{ all -> 0x00a3 }
            L_0x0083:
                int r5 = r4.i     // Catch:{ all -> 0x00a3 }
                if (r5 <= 0) goto L_0x008f
                long[] r5 = r4.f9410c     // Catch:{ all -> 0x00a3 }
                int r6 = r4.k     // Catch:{ all -> 0x00a3 }
                r6 = r5[r6]     // Catch:{ all -> 0x00a3 }
                r5 = r6
                goto L_0x0095
            L_0x008f:
                long r5 = r10.f9398b     // Catch:{ all -> 0x00a3 }
                int r7 = r10.f9397a     // Catch:{ all -> 0x00a3 }
                long r7 = (long) r7     // Catch:{ all -> 0x00a3 }
                long r5 = r5 + r7
            L_0x0095:
                r10.f9399c = r5     // Catch:{ all -> 0x00a3 }
                monitor-exit(r4)
                return r3
            L_0x0099:
                com.google.android.exoplayer2.j[] r6 = r4.h     // Catch:{ all -> 0x00a3 }
                int r7 = r4.k     // Catch:{ all -> 0x00a3 }
                r6 = r6[r7]     // Catch:{ all -> 0x00a3 }
                r5.f9107a = r6     // Catch:{ all -> 0x00a3 }
                monitor-exit(r4)
                return r1
            L_0x00a3:
                r5 = move-exception
                monitor-exit(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.d.b.a(com.google.android.exoplayer2.ah, com.google.android.exoplayer2.d.e, boolean, boolean, com.google.android.exoplayer2.j, com.google.android.exoplayer2.e.d$a):int");
        }

        public synchronized long i() {
            if (this.i == 0) {
                return -1;
            }
            int i2 = ((this.k + this.i) - 1) % this.f9408a;
            this.k = (this.k + this.i) % this.f9408a;
            this.j += this.i;
            this.i = 0;
            return this.f9410c[i2] + ((long) this.f9411d[i2]);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:34:0x005f, code lost:
            return -1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized long a(long r9, boolean r11) {
            /*
                r8 = this;
                monitor-enter(r8)
                int r0 = r8.i     // Catch:{ all -> 0x0060 }
                r1 = -1
                if (r0 == 0) goto L_0x005e
                long[] r0 = r8.f9413f     // Catch:{ all -> 0x0060 }
                int r3 = r8.k     // Catch:{ all -> 0x0060 }
                r3 = r0[r3]     // Catch:{ all -> 0x0060 }
                int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
                if (r0 >= 0) goto L_0x0012
                goto L_0x005e
            L_0x0012:
                long r3 = r8.n     // Catch:{ all -> 0x0060 }
                int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
                if (r0 <= 0) goto L_0x001c
                if (r11 != 0) goto L_0x001c
                monitor-exit(r8)
                return r1
            L_0x001c:
                r11 = 0
                int r0 = r8.k     // Catch:{ all -> 0x0060 }
                r3 = -1
                r11 = -1
                r4 = 0
            L_0x0022:
                int r5 = r8.l     // Catch:{ all -> 0x0060 }
                if (r0 == r5) goto L_0x0040
                long[] r5 = r8.f9413f     // Catch:{ all -> 0x0060 }
                r6 = r5[r0]     // Catch:{ all -> 0x0060 }
                int r5 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
                if (r5 <= 0) goto L_0x002f
                goto L_0x0040
            L_0x002f:
                int[] r5 = r8.f9412e     // Catch:{ all -> 0x0060 }
                r5 = r5[r0]     // Catch:{ all -> 0x0060 }
                r5 = r5 & 1
                if (r5 == 0) goto L_0x0038
                r11 = r4
            L_0x0038:
                int r0 = r0 + 1
                int r5 = r8.f9408a     // Catch:{ all -> 0x0060 }
                int r0 = r0 % r5
                int r4 = r4 + 1
                goto L_0x0022
            L_0x0040:
                if (r11 != r3) goto L_0x0044
                monitor-exit(r8)
                return r1
            L_0x0044:
                int r9 = r8.k     // Catch:{ all -> 0x0060 }
                int r9 = r9 + r11
                int r10 = r8.f9408a     // Catch:{ all -> 0x0060 }
                int r9 = r9 % r10
                r8.k = r9     // Catch:{ all -> 0x0060 }
                int r9 = r8.j     // Catch:{ all -> 0x0060 }
                int r9 = r9 + r11
                r8.j = r9     // Catch:{ all -> 0x0060 }
                int r9 = r8.i     // Catch:{ all -> 0x0060 }
                int r9 = r9 - r11
                r8.i = r9     // Catch:{ all -> 0x0060 }
                long[] r9 = r8.f9410c     // Catch:{ all -> 0x0060 }
                int r10 = r8.k     // Catch:{ all -> 0x0060 }
                r10 = r9[r10]     // Catch:{ all -> 0x0060 }
                monitor-exit(r8)
                return r10
            L_0x005e:
                monitor-exit(r8)
                return r1
            L_0x0060:
                r9 = move-exception
                monitor-exit(r8)
                goto L_0x0064
            L_0x0063:
                throw r9
            L_0x0064:
                goto L_0x0063
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.d.b.a(long, boolean):long");
        }

        public synchronized boolean a(j jVar) {
            if (jVar == null) {
                this.p = true;
                return false;
            }
            this.p = false;
            if (t.a((Object) jVar, (Object) this.q)) {
                return false;
            }
            this.q = jVar;
            return true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00eb, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void a(long r6, int r8, long r9, int r11, byte[] r12) {
            /*
                r5 = this;
                monitor-enter(r5)
                boolean r0 = r5.o     // Catch:{ all -> 0x00ec }
                r1 = 0
                if (r0 == 0) goto L_0x000e
                r0 = r8 & 1
                if (r0 != 0) goto L_0x000c
                monitor-exit(r5)
                return
            L_0x000c:
                r5.o = r1     // Catch:{ all -> 0x00ec }
            L_0x000e:
                boolean r0 = r5.p     // Catch:{ all -> 0x00ec }
                r2 = 1
                if (r0 != 0) goto L_0x0015
                r0 = 1
                goto L_0x0016
            L_0x0015:
                r0 = 0
            L_0x0016:
                com.google.android.exoplayer2.n.a.b(r0)     // Catch:{ all -> 0x00ec }
                r5.a((long) r6)     // Catch:{ all -> 0x00ec }
                long[] r0 = r5.f9413f     // Catch:{ all -> 0x00ec }
                int r3 = r5.l     // Catch:{ all -> 0x00ec }
                r0[r3] = r6     // Catch:{ all -> 0x00ec }
                long[] r6 = r5.f9410c     // Catch:{ all -> 0x00ec }
                int r7 = r5.l     // Catch:{ all -> 0x00ec }
                r6[r7] = r9     // Catch:{ all -> 0x00ec }
                int[] r6 = r5.f9411d     // Catch:{ all -> 0x00ec }
                int r7 = r5.l     // Catch:{ all -> 0x00ec }
                r6[r7] = r11     // Catch:{ all -> 0x00ec }
                int[] r6 = r5.f9412e     // Catch:{ all -> 0x00ec }
                int r7 = r5.l     // Catch:{ all -> 0x00ec }
                r6[r7] = r8     // Catch:{ all -> 0x00ec }
                byte[][] r6 = r5.f9414g     // Catch:{ all -> 0x00ec }
                int r7 = r5.l     // Catch:{ all -> 0x00ec }
                r6[r7] = r12     // Catch:{ all -> 0x00ec }
                com.google.android.exoplayer2.j[] r6 = r5.h     // Catch:{ all -> 0x00ec }
                int r7 = r5.l     // Catch:{ all -> 0x00ec }
                com.google.android.exoplayer2.j r8 = r5.q     // Catch:{ all -> 0x00ec }
                r6[r7] = r8     // Catch:{ all -> 0x00ec }
                int[] r6 = r5.f9409b     // Catch:{ all -> 0x00ec }
                int r7 = r5.l     // Catch:{ all -> 0x00ec }
                int r8 = r5.r     // Catch:{ all -> 0x00ec }
                r6[r7] = r8     // Catch:{ all -> 0x00ec }
                int r6 = r5.i     // Catch:{ all -> 0x00ec }
                int r6 = r6 + r2
                r5.i = r6     // Catch:{ all -> 0x00ec }
                int r6 = r5.i     // Catch:{ all -> 0x00ec }
                int r7 = r5.f9408a     // Catch:{ all -> 0x00ec }
                if (r6 != r7) goto L_0x00dd
                int r6 = r5.f9408a     // Catch:{ all -> 0x00ec }
                int r6 = r6 + 1000
                int[] r7 = new int[r6]     // Catch:{ all -> 0x00ec }
                long[] r8 = new long[r6]     // Catch:{ all -> 0x00ec }
                long[] r9 = new long[r6]     // Catch:{ all -> 0x00ec }
                int[] r10 = new int[r6]     // Catch:{ all -> 0x00ec }
                int[] r11 = new int[r6]     // Catch:{ all -> 0x00ec }
                byte[][] r12 = new byte[r6][]     // Catch:{ all -> 0x00ec }
                com.google.android.exoplayer2.j[] r0 = new com.google.android.exoplayer2.j[r6]     // Catch:{ all -> 0x00ec }
                int r2 = r5.f9408a     // Catch:{ all -> 0x00ec }
                int r3 = r5.k     // Catch:{ all -> 0x00ec }
                int r2 = r2 - r3
                long[] r3 = r5.f9410c     // Catch:{ all -> 0x00ec }
                int r4 = r5.k     // Catch:{ all -> 0x00ec }
                java.lang.System.arraycopy(r3, r4, r8, r1, r2)     // Catch:{ all -> 0x00ec }
                long[] r3 = r5.f9413f     // Catch:{ all -> 0x00ec }
                int r4 = r5.k     // Catch:{ all -> 0x00ec }
                java.lang.System.arraycopy(r3, r4, r9, r1, r2)     // Catch:{ all -> 0x00ec }
                int[] r3 = r5.f9412e     // Catch:{ all -> 0x00ec }
                int r4 = r5.k     // Catch:{ all -> 0x00ec }
                java.lang.System.arraycopy(r3, r4, r10, r1, r2)     // Catch:{ all -> 0x00ec }
                int[] r3 = r5.f9411d     // Catch:{ all -> 0x00ec }
                int r4 = r5.k     // Catch:{ all -> 0x00ec }
                java.lang.System.arraycopy(r3, r4, r11, r1, r2)     // Catch:{ all -> 0x00ec }
                byte[][] r3 = r5.f9414g     // Catch:{ all -> 0x00ec }
                int r4 = r5.k     // Catch:{ all -> 0x00ec }
                java.lang.System.arraycopy(r3, r4, r12, r1, r2)     // Catch:{ all -> 0x00ec }
                com.google.android.exoplayer2.j[] r3 = r5.h     // Catch:{ all -> 0x00ec }
                int r4 = r5.k     // Catch:{ all -> 0x00ec }
                java.lang.System.arraycopy(r3, r4, r0, r1, r2)     // Catch:{ all -> 0x00ec }
                int[] r3 = r5.f9409b     // Catch:{ all -> 0x00ec }
                int r4 = r5.k     // Catch:{ all -> 0x00ec }
                java.lang.System.arraycopy(r3, r4, r7, r1, r2)     // Catch:{ all -> 0x00ec }
                int r3 = r5.k     // Catch:{ all -> 0x00ec }
                long[] r4 = r5.f9410c     // Catch:{ all -> 0x00ec }
                java.lang.System.arraycopy(r4, r1, r8, r2, r3)     // Catch:{ all -> 0x00ec }
                long[] r4 = r5.f9413f     // Catch:{ all -> 0x00ec }
                java.lang.System.arraycopy(r4, r1, r9, r2, r3)     // Catch:{ all -> 0x00ec }
                int[] r4 = r5.f9412e     // Catch:{ all -> 0x00ec }
                java.lang.System.arraycopy(r4, r1, r10, r2, r3)     // Catch:{ all -> 0x00ec }
                int[] r4 = r5.f9411d     // Catch:{ all -> 0x00ec }
                java.lang.System.arraycopy(r4, r1, r11, r2, r3)     // Catch:{ all -> 0x00ec }
                byte[][] r4 = r5.f9414g     // Catch:{ all -> 0x00ec }
                java.lang.System.arraycopy(r4, r1, r12, r2, r3)     // Catch:{ all -> 0x00ec }
                com.google.android.exoplayer2.j[] r4 = r5.h     // Catch:{ all -> 0x00ec }
                java.lang.System.arraycopy(r4, r1, r0, r2, r3)     // Catch:{ all -> 0x00ec }
                int[] r4 = r5.f9409b     // Catch:{ all -> 0x00ec }
                java.lang.System.arraycopy(r4, r1, r7, r2, r3)     // Catch:{ all -> 0x00ec }
                r5.f9410c = r8     // Catch:{ all -> 0x00ec }
                r5.f9413f = r9     // Catch:{ all -> 0x00ec }
                r5.f9412e = r10     // Catch:{ all -> 0x00ec }
                r5.f9411d = r11     // Catch:{ all -> 0x00ec }
                r5.f9414g = r12     // Catch:{ all -> 0x00ec }
                r5.h = r0     // Catch:{ all -> 0x00ec }
                r5.f9409b = r7     // Catch:{ all -> 0x00ec }
                r5.k = r1     // Catch:{ all -> 0x00ec }
                int r7 = r5.f9408a     // Catch:{ all -> 0x00ec }
                r5.l = r7     // Catch:{ all -> 0x00ec }
                int r7 = r5.f9408a     // Catch:{ all -> 0x00ec }
                r5.i = r7     // Catch:{ all -> 0x00ec }
                r5.f9408a = r6     // Catch:{ all -> 0x00ec }
                goto L_0x00ea
            L_0x00dd:
                int r6 = r5.l     // Catch:{ all -> 0x00ec }
                int r6 = r6 + r2
                r5.l = r6     // Catch:{ all -> 0x00ec }
                int r6 = r5.l     // Catch:{ all -> 0x00ec }
                int r7 = r5.f9408a     // Catch:{ all -> 0x00ec }
                if (r6 != r7) goto L_0x00ea
                r5.l = r1     // Catch:{ all -> 0x00ec }
            L_0x00ea:
                monitor-exit(r5)
                return
            L_0x00ec:
                r6 = move-exception
                monitor-exit(r5)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.d.b.a(long, int, long, int, byte[]):void");
        }

        public synchronized void a(long j2) {
            this.n = Math.max(this.n, j2);
        }

        public synchronized boolean b(long j2) {
            if (this.m >= j2) {
                return false;
            }
            int i2 = this.i;
            while (i2 > 0 && this.f9413f[((this.k + i2) - 1) % this.f9408a] >= j2) {
                i2--;
            }
            a(this.j + i2);
            return true;
        }
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f9397a;

        /* renamed from: b  reason: collision with root package name */
        public long f9398b;

        /* renamed from: c  reason: collision with root package name */
        public long f9399c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f9400d;

        private a() {
        }
    }
}
