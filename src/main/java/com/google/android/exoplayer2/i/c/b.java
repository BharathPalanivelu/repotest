package com.google.android.exoplayer2.i.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.e;
import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.s.l;
import com.google.android.exoplayer2.s.v;
import com.path.android.jobqueue.JobManager;
import com.tencent.imsdk.TIMGroupManager;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;

public final class b implements e {

    /* renamed from: a  reason: collision with root package name */
    public static final h f10018a = new h() {
        public e[] a() {
            return new e[]{new b()};
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final int f10019b = v.g("Xing");

    /* renamed from: c  reason: collision with root package name */
    private static final int f10020c = v.g("Info");

    /* renamed from: d  reason: collision with root package name */
    private static final int f10021d = v.g("VBRI");

    /* renamed from: e  reason: collision with root package name */
    private final int f10022e;

    /* renamed from: f  reason: collision with root package name */
    private final long f10023f;

    /* renamed from: g  reason: collision with root package name */
    private final l f10024g;
    private final j h;
    private final i i;
    private g j;
    private m k;
    private int l;
    private Metadata m;
    private a n;
    private long o;
    private long p;
    private int q;

    interface a extends com.google.android.exoplayer2.i.l {
        long a(long j);
    }

    private static boolean a(int i2, long j2) {
        return ((long) (i2 & -128000)) == (j2 & -128000);
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
        this.f10022e = i2;
        this.f10023f = j2;
        this.f10024g = new l(10);
        this.h = new j();
        this.i = new i();
        this.o = -9223372036854775807L;
    }

    public boolean a(f fVar) throws IOException, InterruptedException {
        return a(fVar, true);
    }

    public void a(g gVar) {
        this.j = gVar;
        this.k = this.j.a(0, 1);
        this.j.a();
    }

    public void a(long j2, long j3) {
        this.l = 0;
        this.o = -9223372036854775807L;
        this.p = 0;
        this.q = 0;
    }

    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        if (this.l == 0) {
            try {
                a(fVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        } else {
            f fVar2 = fVar;
        }
        if (this.n == null) {
            this.n = d(fVar);
            a aVar = this.n;
            if (aVar == null || (!aVar.a() && (this.f10022e & 1) != 0)) {
                this.n = e(fVar);
            }
            this.j.a(this.n);
            this.k.a(Format.a((String) null, this.h.f10410b, (String) null, -1, 4096, this.h.f10413e, this.h.f10412d, -1, this.i.f10407b, this.i.f10408c, (List<byte[]>) null, (DrmInitData) null, 0, (String) null, (this.f10022e & 2) != 0 ? null : this.m));
        }
        return b(fVar);
    }

    private int b(f fVar) throws IOException, InterruptedException {
        if (this.q == 0) {
            fVar.a();
            if (!fVar.b(this.f10024g.f11422a, 0, 4, true)) {
                return -1;
            }
            this.f10024g.c(0);
            int n2 = this.f10024g.n();
            if (!a(n2, (long) this.l) || j.a(n2) == -1) {
                fVar.b(1);
                this.l = 0;
                return 0;
            }
            j.a(n2, this.h);
            if (this.o == -9223372036854775807L) {
                this.o = this.n.a(fVar.c());
                if (this.f10023f != -9223372036854775807L) {
                    this.o += this.f10023f - this.n.a(0);
                }
            }
            this.q = this.h.f10411c;
        }
        int a2 = this.k.a(fVar, this.q, true);
        if (a2 == -1) {
            return -1;
        }
        this.q -= a2;
        if (this.q > 0) {
            return 0;
        }
        this.k.a(this.o + ((this.p * JobManager.NS_PER_MS) / ((long) this.h.f10412d)), 1, this.h.f10411c, 0, (m.a) null);
        this.p += (long) this.h.f10415g;
        this.q = 0;
        return 0;
    }

    private boolean a(f fVar, boolean z) throws IOException, InterruptedException {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = z ? TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE : 131072;
        fVar.a();
        if (fVar.c() == 0) {
            c(fVar);
            int b2 = (int) fVar.b();
            if (!z) {
                fVar.b(b2);
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
            if (!fVar.b(this.f10024g.f11422a, 0, 4, i5 > 0)) {
                break;
            }
            this.f10024g.c(0);
            int n2 = this.f10024g.n();
            if (i4 == 0 || a(n2, (long) i4)) {
                int a2 = j.a(n2);
                if (a2 != -1) {
                    i6 = i5 + 1;
                    if (i6 != 1) {
                        if (i6 == 4) {
                            break;
                        }
                    } else {
                        j.a(n2, this.h);
                        i4 = n2;
                    }
                    fVar.c(a2 - 4);
                }
            }
            int i8 = i3 + 1;
            if (i3 != i7) {
                if (z) {
                    fVar.a();
                    fVar.c(i2 + i8);
                } else {
                    fVar.b(1);
                }
                i3 = i8;
                i6 = 0;
                i4 = 0;
            } else if (z) {
                return false;
            } else {
                throw new p("Searched too many bytes.");
            }
        }
        if (z) {
            fVar.b(i2 + i3);
        } else {
            fVar.a();
        }
        this.l = i4;
        return true;
    }

    private void c(f fVar) throws IOException, InterruptedException {
        int i2 = 0;
        while (true) {
            fVar.c(this.f10024g.f11422a, 0, 10);
            this.f10024g.c(0);
            if (this.f10024g.k() != com.google.android.exoplayer2.metadata.id3.a.f10880a) {
                fVar.a();
                fVar.c(i2);
                return;
            }
            this.f10024g.d(3);
            int s = this.f10024g.s();
            int i3 = s + 10;
            if (this.m == null) {
                byte[] bArr = new byte[i3];
                System.arraycopy(this.f10024g.f11422a, 0, bArr, 0, 10);
                fVar.c(bArr, 10, s);
                this.m = new com.google.android.exoplayer2.metadata.id3.a((this.f10022e & 2) != 0 ? i.f10405a : null).a(bArr, i3);
                Metadata metadata = this.m;
                if (metadata != null) {
                    this.i.a(metadata);
                }
            } else {
                fVar.c(s);
            }
            i2 += i3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.exoplayer2.i.c.b.a d(com.google.android.exoplayer2.i.f r10) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r9 = this;
            com.google.android.exoplayer2.s.l r1 = new com.google.android.exoplayer2.s.l
            com.google.android.exoplayer2.i.j r0 = r9.h
            int r0 = r0.f10411c
            r1.<init>((int) r0)
            byte[] r0 = r1.f11422a
            com.google.android.exoplayer2.i.j r2 = r9.h
            int r2 = r2.f10411c
            r6 = 0
            r10.c(r0, r6, r2)
            com.google.android.exoplayer2.i.j r0 = r9.h
            int r0 = r0.f10409a
            r2 = 1
            r0 = r0 & r2
            r3 = 21
            if (r0 == 0) goto L_0x0028
            com.google.android.exoplayer2.i.j r0 = r9.h
            int r0 = r0.f10413e
            if (r0 == r2) goto L_0x002e
            r3 = 36
            r7 = 36
            goto L_0x0035
        L_0x0028:
            com.google.android.exoplayer2.i.j r0 = r9.h
            int r0 = r0.f10413e
            if (r0 == r2) goto L_0x0031
        L_0x002e:
            r7 = 21
            goto L_0x0035
        L_0x0031:
            r3 = 13
            r7 = 13
        L_0x0035:
            int r8 = a((com.google.android.exoplayer2.s.l) r1, (int) r7)
            int r0 = f10019b
            if (r8 == r0) goto L_0x0061
            int r0 = f10020c
            if (r8 != r0) goto L_0x0042
            goto L_0x0061
        L_0x0042:
            int r0 = f10021d
            if (r8 != r0) goto L_0x005c
            com.google.android.exoplayer2.i.j r0 = r9.h
            long r2 = r10.c()
            long r4 = r10.d()
            com.google.android.exoplayer2.i.c.c r0 = com.google.android.exoplayer2.i.c.c.a(r0, r1, r2, r4)
            com.google.android.exoplayer2.i.j r1 = r9.h
            int r1 = r1.f10411c
            r10.b(r1)
            goto L_0x00b1
        L_0x005c:
            r0 = 0
            r10.a()
            goto L_0x00b1
        L_0x0061:
            com.google.android.exoplayer2.i.j r0 = r9.h
            long r2 = r10.c()
            long r4 = r10.d()
            com.google.android.exoplayer2.i.c.d r0 = com.google.android.exoplayer2.i.c.d.a(r0, r1, r2, r4)
            if (r0 == 0) goto L_0x0099
            com.google.android.exoplayer2.i.i r1 = r9.i
            boolean r1 = r1.a()
            if (r1 != 0) goto L_0x0099
            r10.a()
            int r7 = r7 + 141
            r10.c(r7)
            com.google.android.exoplayer2.s.l r1 = r9.f10024g
            byte[] r1 = r1.f11422a
            r2 = 3
            r10.c(r1, r6, r2)
            com.google.android.exoplayer2.s.l r1 = r9.f10024g
            r1.c(r6)
            com.google.android.exoplayer2.i.i r1 = r9.i
            com.google.android.exoplayer2.s.l r2 = r9.f10024g
            int r2 = r2.k()
            r1.a((int) r2)
        L_0x0099:
            com.google.android.exoplayer2.i.j r1 = r9.h
            int r1 = r1.f10411c
            r10.b(r1)
            if (r0 == 0) goto L_0x00b1
            boolean r1 = r0.a()
            if (r1 != 0) goto L_0x00b1
            int r1 = f10020c
            if (r8 != r1) goto L_0x00b1
            com.google.android.exoplayer2.i.c.b$a r10 = r9.e(r10)
            return r10
        L_0x00b1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.i.c.b.d(com.google.android.exoplayer2.i.f):com.google.android.exoplayer2.i.c.b$a");
    }

    private a e(f fVar) throws IOException, InterruptedException {
        fVar.c(this.f10024g.f11422a, 0, 4);
        this.f10024g.c(0);
        j.a(this.f10024g.n(), this.h);
        return new a(fVar.c(), this.h.f10414f, fVar.d());
    }

    private static int a(l lVar, int i2) {
        if (lVar.c() >= i2 + 4) {
            lVar.c(i2);
            int n2 = lVar.n();
            if (n2 == f10019b || n2 == f10020c) {
                return n2;
            }
        }
        if (lVar.c() < 40) {
            return 0;
        }
        lVar.c(36);
        int n3 = lVar.n();
        int i3 = f10021d;
        if (n3 == i3) {
            return i3;
        }
        return 0;
    }
}
