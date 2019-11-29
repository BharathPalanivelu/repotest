package com.google.android.exoplayer2.i.g;

import com.google.android.exoplayer2.i.e;
import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.g.v;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.s.l;
import com.google.android.exoplayer2.s.v;
import java.io.IOException;

public final class c implements e {

    /* renamed from: a  reason: collision with root package name */
    public static final h f10239a = new h() {
        public e[] a() {
            return new e[]{new c()};
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final int f10240b = v.g("ID3");

    /* renamed from: c  reason: collision with root package name */
    private final long f10241c;

    /* renamed from: d  reason: collision with root package name */
    private final d f10242d;

    /* renamed from: e  reason: collision with root package name */
    private final l f10243e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10244f;

    public void c() {
    }

    public c() {
        this(0);
    }

    public c(long j) {
        this.f10241c = j;
        this.f10242d = new d(true);
        this.f10243e = new l(200);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003f, code lost:
        r11.a();
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0048, code lost:
        if ((r5 - r4) < 8192) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004a, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.google.android.exoplayer2.i.f r11) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r10 = this;
            com.google.android.exoplayer2.s.l r0 = new com.google.android.exoplayer2.s.l
            r1 = 10
            r0.<init>((int) r1)
            com.google.android.exoplayer2.s.k r2 = new com.google.android.exoplayer2.s.k
            byte[] r3 = r0.f11422a
            r2.<init>(r3)
            r3 = 0
            r4 = 0
        L_0x0010:
            byte[] r5 = r0.f11422a
            r11.c(r5, r3, r1)
            r0.c(r3)
            int r5 = r0.k()
            int r6 = f10240b
            if (r5 == r6) goto L_0x0074
            r11.a()
            r11.c(r4)
            r5 = r4
        L_0x0027:
            r1 = 0
            r6 = 0
        L_0x0029:
            byte[] r7 = r0.f11422a
            r8 = 2
            r11.c(r7, r3, r8)
            r0.c(r3)
            int r7 = r0.h()
            r8 = 65526(0xfff6, float:9.1821E-41)
            r7 = r7 & r8
            r8 = 65520(0xfff0, float:9.1813E-41)
            if (r7 == r8) goto L_0x004f
            r11.a()
            int r5 = r5 + 1
            int r1 = r5 - r4
            r6 = 8192(0x2000, float:1.14794E-41)
            if (r1 < r6) goto L_0x004b
            return r3
        L_0x004b:
            r11.c(r5)
            goto L_0x0027
        L_0x004f:
            r7 = 1
            int r1 = r1 + r7
            r8 = 4
            if (r1 < r8) goto L_0x0059
            r9 = 188(0xbc, float:2.63E-43)
            if (r6 <= r9) goto L_0x0059
            return r7
        L_0x0059:
            byte[] r7 = r0.f11422a
            r11.c(r7, r3, r8)
            r7 = 14
            r2.a(r7)
            r7 = 13
            int r7 = r2.c(r7)
            r8 = 6
            if (r7 > r8) goto L_0x006d
            return r3
        L_0x006d:
            int r8 = r7 + -6
            r11.c(r8)
            int r6 = r6 + r7
            goto L_0x0029
        L_0x0074:
            r5 = 3
            r0.d(r5)
            int r5 = r0.s()
            int r6 = r5 + 10
            int r4 = r4 + r6
            r11.c(r5)
            goto L_0x0010
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.i.g.c.a(com.google.android.exoplayer2.i.f):boolean");
    }

    public void a(g gVar) {
        this.f10242d.a(gVar, new v.d(0, 1));
        gVar.a();
        gVar.a(new l.a(-9223372036854775807L));
    }

    public void a(long j, long j2) {
        this.f10244f = false;
        this.f10242d.a();
    }

    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        int a2 = fVar.a(this.f10243e.f11422a, 0, 200);
        if (a2 == -1) {
            return -1;
        }
        this.f10243e.c(0);
        this.f10243e.b(a2);
        if (!this.f10244f) {
            this.f10242d.a(this.f10241c, true);
            this.f10244f = true;
        }
        this.f10242d.a(this.f10243e);
        return 0;
    }
}
