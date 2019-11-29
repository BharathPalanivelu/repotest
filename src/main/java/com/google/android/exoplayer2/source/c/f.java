package com.google.android.exoplayer2.source.c;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.b;
import com.google.android.exoplayer2.i.e;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.g.c;
import com.google.android.exoplayer2.i.g.u;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.r.i;
import com.google.android.exoplayer2.s.s;
import com.google.android.exoplayer2.s.v;
import com.google.android.exoplayer2.source.b.l;
import com.google.android.exoplayer2.source.c.b.a;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class f extends l {
    private static final AtomicInteger m = new AtomicInteger();
    private e A;
    private int B;
    private int C;
    private boolean D;
    private j E;
    private volatile boolean F;
    private volatile boolean G;
    public final int j;
    public final int k;
    public final a.C0187a l;
    private final com.google.android.exoplayer2.r.f n;
    private final i o;
    private final boolean p = (this.h instanceof a);
    private final boolean q;
    private final s r;
    private final String s;
    private final e t;
    private final boolean u;
    private final boolean v;
    private final List<Format> w;
    private final boolean x;
    private final com.google.android.exoplayer2.metadata.id3.a y;
    private final com.google.android.exoplayer2.s.l z;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public f(com.google.android.exoplayer2.r.f r17, com.google.android.exoplayer2.r.i r18, com.google.android.exoplayer2.r.i r19, com.google.android.exoplayer2.source.c.b.a.C0187a r20, java.util.List<com.google.android.exoplayer2.Format> r21, int r22, java.lang.Object r23, long r24, long r26, int r28, int r29, boolean r30, com.google.android.exoplayer2.s.s r31, com.google.android.exoplayer2.source.c.f r32, byte[] r33, byte[] r34) {
        /*
            r16 = this;
            r11 = r16
            r12 = r17
            r13 = r20
            r14 = r29
            r15 = r32
            r0 = r33
            r1 = r34
            com.google.android.exoplayer2.r.f r1 = a(r12, r0, r1)
            com.google.android.exoplayer2.Format r3 = r13.f11643b
            r0 = r16
            r2 = r18
            r4 = r22
            r5 = r23
            r6 = r24
            r8 = r26
            r10 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10)
            r11.k = r14
            r0 = r19
            r11.o = r0
            r11.l = r13
            r0 = r21
            r11.w = r0
            r0 = r30
            r11.q = r0
            r0 = r31
            r11.r = r0
            com.google.android.exoplayer2.r.f r0 = r11.h
            boolean r0 = r0 instanceof com.google.android.exoplayer2.source.c.a
            r11.p = r0
            r0 = r18
            android.net.Uri r0 = r0.f11313a
            java.lang.String r0 = r0.getLastPathSegment()
            r11.s = r0
            java.lang.String r0 = r11.s
            java.lang.String r1 = ".aac"
            boolean r0 = r0.endsWith(r1)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0076
            java.lang.String r0 = r11.s
            java.lang.String r3 = ".ac3"
            boolean r0 = r0.endsWith(r3)
            if (r0 != 0) goto L_0x0076
            java.lang.String r0 = r11.s
            java.lang.String r3 = ".ec3"
            boolean r0 = r0.endsWith(r3)
            if (r0 != 0) goto L_0x0076
            java.lang.String r0 = r11.s
            java.lang.String r3 = ".mp3"
            boolean r0 = r0.endsWith(r3)
            if (r0 == 0) goto L_0x0074
            goto L_0x0076
        L_0x0074:
            r0 = 0
            goto L_0x0077
        L_0x0076:
            r0 = 1
        L_0x0077:
            r11.x = r0
            if (r15 == 0) goto L_0x009c
            com.google.android.exoplayer2.metadata.id3.a r0 = r15.y
            r11.y = r0
            com.google.android.exoplayer2.s.l r0 = r15.z
            r11.z = r0
            com.google.android.exoplayer2.i.e r0 = r15.A
            r11.t = r0
            com.google.android.exoplayer2.source.c.b.a$a r0 = r15.l
            if (r0 == r13) goto L_0x008d
            r0 = 1
            goto L_0x008e
        L_0x008d:
            r0 = 0
        L_0x008e:
            r11.u = r0
            int r0 = r15.k
            if (r0 != r14) goto L_0x0098
            boolean r0 = r11.u
            if (r0 == 0) goto L_0x0099
        L_0x0098:
            r1 = 1
        L_0x0099:
            r11.v = r1
            goto L_0x00bf
        L_0x009c:
            boolean r0 = r11.x
            r3 = 0
            if (r0 == 0) goto L_0x00a7
            com.google.android.exoplayer2.metadata.id3.a r0 = new com.google.android.exoplayer2.metadata.id3.a
            r0.<init>()
            goto L_0x00a8
        L_0x00a7:
            r0 = r3
        L_0x00a8:
            r11.y = r0
            boolean r0 = r11.x
            if (r0 == 0) goto L_0x00b6
            com.google.android.exoplayer2.s.l r0 = new com.google.android.exoplayer2.s.l
            r4 = 10
            r0.<init>((int) r4)
            goto L_0x00b7
        L_0x00b6:
            r0 = r3
        L_0x00b7:
            r11.z = r0
            r11.t = r3
            r11.u = r1
            r11.v = r2
        L_0x00bf:
            r11.n = r12
            java.util.concurrent.atomic.AtomicInteger r0 = m
            int r0 = r0.getAndIncrement()
            r11.j = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.c.f.<init>(com.google.android.exoplayer2.r.f, com.google.android.exoplayer2.r.i, com.google.android.exoplayer2.r.i, com.google.android.exoplayer2.source.c.b.a$a, java.util.List, int, java.lang.Object, long, long, int, int, boolean, com.google.android.exoplayer2.s.s, com.google.android.exoplayer2.source.c.f, byte[], byte[]):void");
    }

    public void a(j jVar) {
        this.E = jVar;
        jVar.a(this.j, this.u);
    }

    public boolean g() {
        return this.G;
    }

    public long e() {
        return (long) this.C;
    }

    public void a() {
        this.F = true;
    }

    public boolean b() {
        return this.F;
    }

    public void c() throws IOException, InterruptedException {
        if (this.A == null && !this.x) {
            this.A = i();
        }
        d();
        if (!this.F) {
            h();
        }
    }

    private void d() throws IOException, InterruptedException {
        b bVar;
        if (this.t != this.A && !this.D) {
            i iVar = this.o;
            if (iVar != null) {
                i a2 = iVar.a((long) this.B);
                try {
                    bVar = new b(this.n, a2.f11315c, this.n.a(a2));
                    int i = 0;
                    while (i == 0) {
                        if (this.F) {
                            break;
                        }
                        i = this.A.a((com.google.android.exoplayer2.i.f) bVar, (k) null);
                    }
                    this.B = (int) (bVar.c() - this.o.f11315c);
                    v.a(this.h);
                    this.D = true;
                } catch (Throwable th) {
                    v.a(this.h);
                    throw th;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004c A[Catch:{ all -> 0x007d, all -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006a A[Catch:{ all -> 0x007d, all -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0071 A[SYNTHETIC, Splitter:B:24:0x0071] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void h() throws java.io.IOException, java.lang.InterruptedException {
        /*
            r13 = this;
            boolean r0 = r13.p
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x000e
            com.google.android.exoplayer2.r.i r0 = r13.f11543a
            int r3 = r13.C
            if (r3 == 0) goto L_0x0017
            r3 = 1
            goto L_0x0018
        L_0x000e:
            com.google.android.exoplayer2.r.i r0 = r13.f11543a
            int r3 = r13.C
            long r3 = (long) r3
            com.google.android.exoplayer2.r.i r0 = r0.a((long) r3)
        L_0x0017:
            r3 = 0
        L_0x0018:
            boolean r4 = r13.q
            if (r4 != 0) goto L_0x0022
            com.google.android.exoplayer2.s.s r4 = r13.r
            r4.e()
            goto L_0x0038
        L_0x0022:
            com.google.android.exoplayer2.s.s r4 = r13.r
            long r4 = r4.a()
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0038
            com.google.android.exoplayer2.s.s r4 = r13.r
            long r5 = r13.f11548f
            r4.a(r5)
        L_0x0038:
            com.google.android.exoplayer2.i.b r4 = new com.google.android.exoplayer2.i.b     // Catch:{ all -> 0x009f }
            com.google.android.exoplayer2.r.f r8 = r13.h     // Catch:{ all -> 0x009f }
            long r9 = r0.f11315c     // Catch:{ all -> 0x009f }
            com.google.android.exoplayer2.r.f r5 = r13.h     // Catch:{ all -> 0x009f }
            long r11 = r5.a(r0)     // Catch:{ all -> 0x009f }
            r7 = r4
            r7.<init>(r8, r9, r11)     // Catch:{ all -> 0x009f }
            com.google.android.exoplayer2.i.e r0 = r13.A     // Catch:{ all -> 0x009f }
            if (r0 != 0) goto L_0x0068
            long r5 = r13.a((com.google.android.exoplayer2.i.f) r4)     // Catch:{ all -> 0x009f }
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x0060
            com.google.android.exoplayer2.s.s r0 = r13.r     // Catch:{ all -> 0x009f }
            long r5 = r0.b(r5)     // Catch:{ all -> 0x009f }
            goto L_0x0062
        L_0x0060:
            long r5 = r13.f11548f     // Catch:{ all -> 0x009f }
        L_0x0062:
            com.google.android.exoplayer2.i.e r0 = r13.a((long) r5)     // Catch:{ all -> 0x009f }
            r13.A = r0     // Catch:{ all -> 0x009f }
        L_0x0068:
            if (r3 == 0) goto L_0x006f
            int r0 = r13.C     // Catch:{ all -> 0x009f }
            r4.b(r0)     // Catch:{ all -> 0x009f }
        L_0x006f:
            if (r2 != 0) goto L_0x008b
            boolean r0 = r13.F     // Catch:{ all -> 0x007d }
            if (r0 != 0) goto L_0x008b
            com.google.android.exoplayer2.i.e r0 = r13.A     // Catch:{ all -> 0x007d }
            r2 = 0
            int r2 = r0.a((com.google.android.exoplayer2.i.f) r4, (com.google.android.exoplayer2.i.k) r2)     // Catch:{ all -> 0x007d }
            goto L_0x006f
        L_0x007d:
            r0 = move-exception
            long r1 = r4.c()     // Catch:{ all -> 0x009f }
            com.google.android.exoplayer2.r.i r3 = r13.f11543a     // Catch:{ all -> 0x009f }
            long r3 = r3.f11315c     // Catch:{ all -> 0x009f }
            long r1 = r1 - r3
            int r2 = (int) r1     // Catch:{ all -> 0x009f }
            r13.C = r2     // Catch:{ all -> 0x009f }
            throw r0     // Catch:{ all -> 0x009f }
        L_0x008b:
            long r2 = r4.c()     // Catch:{ all -> 0x009f }
            com.google.android.exoplayer2.r.i r0 = r13.f11543a     // Catch:{ all -> 0x009f }
            long r4 = r0.f11315c     // Catch:{ all -> 0x009f }
            long r2 = r2 - r4
            int r0 = (int) r2     // Catch:{ all -> 0x009f }
            r13.C = r0     // Catch:{ all -> 0x009f }
            com.google.android.exoplayer2.r.f r0 = r13.h
            com.google.android.exoplayer2.s.v.a((com.google.android.exoplayer2.r.f) r0)
            r13.G = r1
            return
        L_0x009f:
            r0 = move-exception
            com.google.android.exoplayer2.r.f r1 = r13.h
            com.google.android.exoplayer2.s.v.a((com.google.android.exoplayer2.r.f) r1)
            goto L_0x00a7
        L_0x00a6:
            throw r0
        L_0x00a7:
            goto L_0x00a6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.c.f.h():void");
    }

    private long a(com.google.android.exoplayer2.i.f fVar) throws IOException, InterruptedException {
        fVar.a();
        if (!fVar.b(this.z.f11422a, 0, 10, true)) {
            return -9223372036854775807L;
        }
        this.z.a(10);
        if (this.z.k() != com.google.android.exoplayer2.metadata.id3.a.f10880a) {
            return -9223372036854775807L;
        }
        this.z.d(3);
        int s2 = this.z.s();
        int i = s2 + 10;
        if (i > this.z.e()) {
            byte[] bArr = this.z.f11422a;
            this.z.a(i);
            System.arraycopy(bArr, 0, this.z.f11422a, 0, 10);
        }
        if (!fVar.b(this.z.f11422a, 10, s2, true)) {
            return -9223372036854775807L;
        }
        Metadata a2 = this.y.a(this.z.f11422a, s2);
        if (a2 == null) {
            return -9223372036854775807L;
        }
        int a3 = a2.a();
        for (int i2 = 0; i2 < a3; i2++) {
            Metadata.Entry a4 = a2.a(i2);
            if (a4 instanceof PrivFrame) {
                PrivFrame privFrame = (PrivFrame) a4;
                if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.f10874a)) {
                    System.arraycopy(privFrame.f10875b, 0, this.z.f11422a, 0, 8);
                    this.z.a(8);
                    return this.z.p();
                }
            }
        }
        return -9223372036854775807L;
    }

    private static com.google.android.exoplayer2.r.f a(com.google.android.exoplayer2.r.f fVar, byte[] bArr, byte[] bArr2) {
        return (bArr == null || bArr2 == null) ? fVar : new a(fVar, bArr, bArr2);
    }

    private e i() {
        e eVar;
        boolean z2 = true;
        if ("text/vtt".equals(this.l.f11643b.f8958f) || this.s.endsWith(".webvtt") || this.s.endsWith(".vtt")) {
            eVar = new l(this.f11545c.y, this.r);
        } else if (!this.v) {
            eVar = this.t;
            z2 = false;
        } else {
            if (!this.s.endsWith(".mp4")) {
                String str = this.s;
                if (!str.startsWith(".m4", str.length() - 4)) {
                    int i = 16;
                    List<Format> list = this.w;
                    if (list != null) {
                        i = 48;
                    } else {
                        list = Collections.emptyList();
                    }
                    String str2 = this.f11545c.f8955c;
                    if (!TextUtils.isEmpty(str2)) {
                        if (!"audio/mp4a-latm".equals(com.google.android.exoplayer2.s.i.e(str2))) {
                            i |= 2;
                        }
                        if (!"video/avc".equals(com.google.android.exoplayer2.s.i.d(str2))) {
                            i |= 4;
                        }
                    }
                    eVar = new u(2, this.r, new com.google.android.exoplayer2.i.g.e(i, list));
                }
            }
            eVar = new com.google.android.exoplayer2.i.d.e(0, this.r);
        }
        if (z2) {
            eVar.a((g) this.E);
        }
        return eVar;
    }

    private e a(long j2) {
        e eVar;
        if (this.s.endsWith(".aac")) {
            eVar = new c(j2);
        } else if (this.s.endsWith(".ac3") || this.s.endsWith(".ec3")) {
            eVar = new com.google.android.exoplayer2.i.g.a(j2);
        } else if (this.s.endsWith(".mp3")) {
            eVar = new com.google.android.exoplayer2.i.c.b(0, j2);
        } else {
            throw new IllegalArgumentException("Unknown extension for audio file: " + this.s);
        }
        eVar.a((g) this.E);
        return eVar;
    }
}
