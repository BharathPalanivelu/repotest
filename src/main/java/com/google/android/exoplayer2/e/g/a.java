package com.google.android.exoplayer2.e.g;

import com.google.android.exoplayer2.e.f;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.e.g.v;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.e.i;
import com.google.android.exoplayer2.e.l;
import com.google.android.exoplayer2.e.m;
import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.t;
import java.io.IOException;

public final class a implements f {

    /* renamed from: a  reason: collision with root package name */
    public static final i f9592a = new i() {
        public f[] a() {
            return new f[]{new a()};
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final int f9593b = t.g("ID3");

    /* renamed from: c  reason: collision with root package name */
    private final long f9594c;

    /* renamed from: d  reason: collision with root package name */
    private final k f9595d;

    /* renamed from: e  reason: collision with root package name */
    private b f9596e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9597f;

    public void c() {
    }

    public a() {
        this(0);
    }

    public a(long j) {
        this.f9594c = j;
        this.f9595d = new k(2786);
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
    public boolean a(com.google.android.exoplayer2.e.g r8) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r7 = this;
            com.google.android.exoplayer2.n.k r0 = new com.google.android.exoplayer2.n.k
            r1 = 10
            r0.<init>((int) r1)
            r2 = 0
            r3 = 0
        L_0x0009:
            byte[] r4 = r0.f10948a
            r8.c(r4, r2, r1)
            r0.c(r2)
            int r4 = r0.k()
            int r5 = f9593b
            if (r4 == r5) goto L_0x0058
            r8.a()
            r8.c(r3)
            r4 = r3
        L_0x0020:
            r1 = 0
        L_0x0021:
            byte[] r5 = r0.f10948a
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
            byte[] r5 = r0.f10948a
            int r5 = com.google.android.exoplayer2.a.a.a((byte[]) r5)
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.g.a.a(com.google.android.exoplayer2.e.g):boolean");
    }

    public void a(h hVar) {
        this.f9596e = new b();
        this.f9596e.a(hVar, new v.d(0, 1));
        hVar.a();
        hVar.a(new m.a(-9223372036854775807L));
    }

    public void a(long j, long j2) {
        this.f9597f = false;
        this.f9596e.a();
    }

    public int a(g gVar, l lVar) throws IOException, InterruptedException {
        int a2 = gVar.a(this.f9595d.f10948a, 0, 2786);
        if (a2 == -1) {
            return -1;
        }
        this.f9595d.c(0);
        this.f9595d.b(a2);
        if (!this.f9597f) {
            this.f9596e.a(this.f9594c, true);
            this.f9597f = true;
        }
        this.f9596e.a(this.f9595d);
        return 0;
    }
}
