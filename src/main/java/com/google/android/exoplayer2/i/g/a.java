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

public final class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public static final h f10226a = new h() {
        public e[] a() {
            return new e[]{new a()};
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final int f10227b = v.g("ID3");

    /* renamed from: c  reason: collision with root package name */
    private final long f10228c;

    /* renamed from: d  reason: collision with root package name */
    private final b f10229d;

    /* renamed from: e  reason: collision with root package name */
    private final l f10230e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10231f;

    public void c() {
    }

    public a() {
        this(0);
    }

    public a(long j) {
        this.f10228c = j;
        this.f10229d = new b();
        this.f10230e = new l(2786);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0032, code lost:
        r8.a();
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003b, code lost:
        if ((r4 - r3) < 8192) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003d, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.google.android.exoplayer2.i.f r8) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r7 = this;
            com.google.android.exoplayer2.s.l r0 = new com.google.android.exoplayer2.s.l
            r1 = 10
            r0.<init>((int) r1)
            r2 = 0
            r3 = 0
        L_0x0009:
            byte[] r4 = r0.f11422a
            r8.c(r4, r2, r1)
            r0.c(r2)
            int r4 = r0.k()
            int r5 = f10227b
            if (r4 == r5) goto L_0x0058
            r8.a()
            r8.c(r3)
            r4 = r3
        L_0x0020:
            r1 = 0
        L_0x0021:
            byte[] r5 = r0.f11422a
            r6 = 5
            r8.c(r5, r2, r6)
            r0.c(r2)
            int r5 = r0.h()
            r6 = 2935(0xb77, float:4.113E-42)
            if (r5 == r6) goto L_0x0042
            r8.a()
            int r4 = r4 + 1
            int r1 = r4 - r3
            r5 = 8192(0x2000, float:1.14794E-41)
            if (r1 < r5) goto L_0x003e
            return r2
        L_0x003e:
            r8.c(r4)
            goto L_0x0020
        L_0x0042:
            r5 = 1
            int r1 = r1 + r5
            r6 = 4
            if (r1 < r6) goto L_0x0048
            return r5
        L_0x0048:
            byte[] r5 = r0.f11422a
            int r5 = com.google.android.exoplayer2.b.a.a((byte[]) r5)
            r6 = -1
            if (r5 != r6) goto L_0x0052
            return r2
        L_0x0052:
            int r5 = r5 + -5
            r8.c(r5)
            goto L_0x0021
        L_0x0058:
            r4 = 3
            r0.d(r4)
            int r4 = r0.s()
            int r5 = r4 + 10
            int r3 = r3 + r5
            r8.c(r4)
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.i.g.a.a(com.google.android.exoplayer2.i.f):boolean");
    }

    public void a(g gVar) {
        this.f10229d.a(gVar, new v.d(0, 1));
        gVar.a();
        gVar.a(new l.a(-9223372036854775807L));
    }

    public void a(long j, long j2) {
        this.f10231f = false;
        this.f10229d.a();
    }

    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        int a2 = fVar.a(this.f10230e.f11422a, 0, 2786);
        if (a2 == -1) {
            return -1;
        }
        this.f10230e.c(0);
        this.f10230e.b(a2);
        if (!this.f10231f) {
            this.f10229d.a(this.f10228c, true);
            this.f10231f = true;
        }
        this.f10229d.a(this.f10230e);
        return 0;
    }
}
