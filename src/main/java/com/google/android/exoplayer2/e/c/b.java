package com.google.android.exoplayer2.e.c;

import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.e.f;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.e.i;
import com.google.android.exoplayer2.e.j;
import com.google.android.exoplayer2.e.l;
import com.google.android.exoplayer2.e.m;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.t;
import com.path.android.jobqueue.JobManager;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;

public final class b implements f {

    /* renamed from: a  reason: collision with root package name */
    public static final i f9374a = new i() {
        public f[] a() {
            return new f[]{new b()};
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final int f9375b = t.g("Xing");

    /* renamed from: c  reason: collision with root package name */
    private static final int f9376c = t.g("Info");

    /* renamed from: d  reason: collision with root package name */
    private static final int f9377d = t.g("VBRI");

    /* renamed from: e  reason: collision with root package name */
    private final int f9378e;

    /* renamed from: f  reason: collision with root package name */
    private final long f9379f;

    /* renamed from: g  reason: collision with root package name */
    private final k f9380g;
    private final com.google.android.exoplayer2.e.k h;
    private final j i;
    private h j;
    private n k;
    private int l;
    private com.google.android.exoplayer2.f.a m;
    private a n;
    private long o;
    private long p;
    private int q;

    interface a extends m {
        long a(long j);
    }

    public void c() {
    }

    public b() {
        this(0);
    }

    public b(int i2) {
        this(i2, -9223372036854775807L);
    }

    public b(int i2, long j2) {
        this.f9378e = i2;
        this.f9379f = j2;
        this.f9380g = new k(10);
        this.h = new com.google.android.exoplayer2.e.k();
        this.i = new j();
        this.o = -9223372036854775807L;
    }

    public boolean a(g gVar) throws IOException, InterruptedException {
        return a(gVar, true);
    }

    public void a(h hVar) {
        this.j = hVar;
        this.k = this.j.a(0, 1);
        this.j.a();
    }

    public void a(long j2, long j3) {
        this.l = 0;
        this.o = -9223372036854775807L;
        this.p = 0;
        this.q = 0;
    }

    public int a(g gVar, l lVar) throws IOException, InterruptedException {
        if (this.l == 0) {
            try {
                a(gVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        } else {
            g gVar2 = gVar;
        }
        if (this.n == null) {
            this.n = d(gVar);
            this.j.a(this.n);
            this.k.a(com.google.android.exoplayer2.j.a((String) null, this.h.f9773b, (String) null, -1, 4096, this.h.f9776e, this.h.f9775d, -1, this.i.f9770b, this.i.f9771c, (List<byte[]>) null, (com.google.android.exoplayer2.c.a) null, 0, (String) null, (this.f9378e & 2) != 0 ? null : this.m));
        }
        return b(gVar);
    }

    private int b(g gVar) throws IOException, InterruptedException {
        if (this.q == 0) {
            gVar.a();
            if (!gVar.b(this.f9380g.f10948a, 0, 4, true)) {
                return -1;
            }
            this.f9380g.c(0);
            int n2 = this.f9380g.n();
            if ((n2 & -128000) != (-128000 & this.l) || com.google.android.exoplayer2.e.k.a(n2) == -1) {
                gVar.b(1);
                this.l = 0;
                return 0;
            }
            com.google.android.exoplayer2.e.k.a(n2, this.h);
            if (this.o == -9223372036854775807L) {
                this.o = this.n.a(gVar.c());
                if (this.f9379f != -9223372036854775807L) {
                    this.o += this.f9379f - this.n.a(0);
                }
            }
            this.q = this.h.f9774c;
        }
        int a2 = this.k.a(gVar, this.q, true);
        if (a2 == -1) {
            return -1;
        }
        this.q -= a2;
        if (this.q > 0) {
            return 0;
        }
        this.k.a(this.o + ((this.p * JobManager.NS_PER_MS) / ((long) this.h.f9775d)), 1, this.h.f9774c, 0, (byte[]) null);
        this.p += (long) this.h.f9778g;
        this.q = 0;
        return 0;
    }

    private boolean a(g gVar, boolean z) throws IOException, InterruptedException {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = z ? 4096 : 131072;
        gVar.a();
        if (gVar.c() == 0) {
            c(gVar);
            int b2 = (int) gVar.b();
            if (!z) {
                gVar.b(b2);
            }
            i2 = b2;
            i5 = 0;
            i4 = 0;
            i3 = 0;
        } else {
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
        }
        while (true) {
            if (!gVar.b(this.f9380g.f10948a, 0, 4, i5 > 0)) {
                break;
            }
            this.f9380g.c(0);
            int n2 = this.f9380g.n();
            if (i4 == 0 || (n2 & -128000) == (-128000 & i4)) {
                int a2 = com.google.android.exoplayer2.e.k.a(n2);
                if (a2 != -1) {
                    i6 = i5 + 1;
                    if (i6 != 1) {
                        if (i6 == 4) {
                            break;
                        }
                    } else {
                        com.google.android.exoplayer2.e.k.a(n2, this.h);
                        i4 = n2;
                    }
                    gVar.c(a2 - 4);
                }
            }
            int i8 = i3 + 1;
            if (i3 != i7) {
                if (z) {
                    gVar.a();
                    gVar.c(i2 + i8);
                } else {
                    gVar.b(1);
                }
                i3 = i8;
                i6 = 0;
                i4 = 0;
            } else if (z) {
                return false;
            } else {
                throw new ak("Searched too many bytes.");
            }
        }
        if (z) {
            gVar.b(i2 + i3);
        } else {
            gVar.a();
        }
        this.l = i4;
        return true;
    }

    private void c(g gVar) throws IOException, InterruptedException {
        int i2 = 0;
        while (true) {
            gVar.c(this.f9380g.f10948a, 0, 10);
            this.f9380g.c(0);
            if (this.f9380g.k() != com.google.android.exoplayer2.f.b.g.f9814a) {
                gVar.a();
                gVar.c(i2);
                return;
            }
            this.f9380g.d(3);
            int s = this.f9380g.s();
            int i3 = s + 10;
            if (this.m == null) {
                byte[] bArr = new byte[i3];
                System.arraycopy(this.f9380g.f10948a, 0, bArr, 0, 10);
                gVar.c(bArr, 10, s);
                this.m = new com.google.android.exoplayer2.f.b.g((this.f9378e & 2) != 0 ? j.f9768a : null).a(bArr, i3);
                com.google.android.exoplayer2.f.a aVar = this.m;
                if (aVar != null) {
                    this.i.a(aVar);
                }
            } else {
                gVar.c(s);
            }
            i2 += i3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.exoplayer2.e.c.b.a d(com.google.android.exoplayer2.e.g r14) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r13 = this;
            com.google.android.exoplayer2.n.k r1 = new com.google.android.exoplayer2.n.k
            com.google.android.exoplayer2.e.k r0 = r13.h
            int r0 = r0.f9774c
            r1.<init>((int) r0)
            byte[] r0 = r1.f10948a
            com.google.android.exoplayer2.e.k r2 = r13.h
            int r2 = r2.f9774c
            r6 = 0
            r14.c(r0, r6, r2)
            long r2 = r14.c()
            long r11 = r14.d()
            com.google.android.exoplayer2.e.k r0 = r13.h
            int r0 = r0.f9772a
            r7 = 1
            r0 = r0 & r7
            r4 = 36
            r5 = 21
            if (r0 == 0) goto L_0x0030
            com.google.android.exoplayer2.e.k r0 = r13.h
            int r0 = r0.f9776e
            if (r0 == r7) goto L_0x0036
            r8 = 36
            goto L_0x003d
        L_0x0030:
            com.google.android.exoplayer2.e.k r0 = r13.h
            int r0 = r0.f9776e
            if (r0 == r7) goto L_0x0039
        L_0x0036:
            r8 = 21
            goto L_0x003d
        L_0x0039:
            r0 = 13
            r8 = 13
        L_0x003d:
            int r0 = r1.c()
            int r5 = r8 + 4
            if (r0 < r5) goto L_0x004d
            r1.c(r8)
            int r0 = r1.n()
            goto L_0x004e
        L_0x004d:
            r0 = 0
        L_0x004e:
            int r5 = f9375b
            if (r0 == r5) goto L_0x007b
            int r5 = f9376c
            if (r0 != r5) goto L_0x0057
            goto L_0x007b
        L_0x0057:
            int r0 = r1.c()
            r5 = 40
            if (r0 < r5) goto L_0x0079
            r1.c(r4)
            int r0 = r1.n()
            int r4 = f9377d
            if (r0 != r4) goto L_0x0079
            com.google.android.exoplayer2.e.k r0 = r13.h
            r4 = r11
            com.google.android.exoplayer2.e.c.c r0 = com.google.android.exoplayer2.e.c.c.a(r0, r1, r2, r4)
            com.google.android.exoplayer2.e.k r1 = r13.h
            int r1 = r1.f9774c
            r14.b(r1)
            goto L_0x00b3
        L_0x0079:
            r0 = 0
            goto L_0x00b3
        L_0x007b:
            com.google.android.exoplayer2.e.k r0 = r13.h
            r4 = r11
            com.google.android.exoplayer2.e.c.d r0 = com.google.android.exoplayer2.e.c.d.a(r0, r1, r2, r4)
            if (r0 == 0) goto L_0x00ac
            com.google.android.exoplayer2.e.j r1 = r13.i
            boolean r1 = r1.a()
            if (r1 != 0) goto L_0x00ac
            r14.a()
            int r8 = r8 + 141
            r14.c(r8)
            com.google.android.exoplayer2.n.k r1 = r13.f9380g
            byte[] r1 = r1.f10948a
            r2 = 3
            r14.c(r1, r6, r2)
            com.google.android.exoplayer2.n.k r1 = r13.f9380g
            r1.c(r6)
            com.google.android.exoplayer2.e.j r1 = r13.i
            com.google.android.exoplayer2.n.k r2 = r13.f9380g
            int r2 = r2.k()
            r1.a((int) r2)
        L_0x00ac:
            com.google.android.exoplayer2.e.k r1 = r13.h
            int r1 = r1.f9774c
            r14.b(r1)
        L_0x00b3:
            if (r0 == 0) goto L_0x00c0
            boolean r1 = r0.a()
            if (r1 != 0) goto L_0x00e9
            int r1 = r13.f9378e
            r1 = r1 & r7
            if (r1 == 0) goto L_0x00e9
        L_0x00c0:
            r14.a()
            com.google.android.exoplayer2.n.k r0 = r13.f9380g
            byte[] r0 = r0.f10948a
            r1 = 4
            r14.c(r0, r6, r1)
            com.google.android.exoplayer2.n.k r0 = r13.f9380g
            r0.c(r6)
            com.google.android.exoplayer2.n.k r0 = r13.f9380g
            int r0 = r0.n()
            com.google.android.exoplayer2.e.k r1 = r13.h
            com.google.android.exoplayer2.e.k.a(r0, r1)
            com.google.android.exoplayer2.e.c.a r0 = new com.google.android.exoplayer2.e.c.a
            long r8 = r14.c()
            com.google.android.exoplayer2.e.k r14 = r13.h
            int r10 = r14.f9777f
            r7 = r0
            r7.<init>(r8, r10, r11)
        L_0x00e9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.c.b.d(com.google.android.exoplayer2.e.g):com.google.android.exoplayer2.e.c.b$a");
    }
}
