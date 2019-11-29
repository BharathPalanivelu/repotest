package com.google.android.exoplayer2.i.g;

import android.util.SparseArray;
import com.google.android.exoplayer2.i.e;
import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.g.v;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.s.l;
import com.google.android.exoplayer2.s.s;
import com.tencent.imsdk.BaseConstants;
import java.io.IOException;

public final class p implements e {

    /* renamed from: a  reason: collision with root package name */
    public static final h f10339a = new h() {
        public e[] a() {
            return new e[]{new p()};
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final s f10340b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<a> f10341c;

    /* renamed from: d  reason: collision with root package name */
    private final l f10342d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10343e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10344f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10345g;
    private g h;

    public void c() {
    }

    public p() {
        this(new s(0));
    }

    public p(s sVar) {
        this.f10340b = sVar;
        this.f10342d = new l(4096);
        this.f10341c = new SparseArray<>();
    }

    public boolean a(f fVar) throws IOException, InterruptedException {
        byte[] bArr = new byte[14];
        fVar.c(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        fVar.c(bArr[13] & 7);
        fVar.c(bArr, 0, 3);
        if (1 == (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8) | (bArr[2] & 255))) {
            return true;
        }
        return false;
    }

    public void a(g gVar) {
        this.h = gVar;
        gVar.a(new l.a(-9223372036854775807L));
    }

    public void a(long j, long j2) {
        this.f10340b.d();
        for (int i = 0; i < this.f10341c.size(); i++) {
            this.f10341c.valueAt(i).a();
        }
    }

    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        if (!fVar.b(this.f10342d.f11422a, 0, 4, true)) {
            return -1;
        }
        this.f10342d.c(0);
        int n = this.f10342d.n();
        if (n == 441) {
            return -1;
        }
        if (n == 442) {
            fVar.c(this.f10342d.f11422a, 0, 10);
            this.f10342d.c(9);
            fVar.b((this.f10342d.g() & 7) + 14);
            return 0;
        } else if (n == 443) {
            fVar.c(this.f10342d.f11422a, 0, 2);
            this.f10342d.c(0);
            fVar.b(this.f10342d.h() + 6);
            return 0;
        } else if (((n & -256) >> 8) != 1) {
            fVar.b(1);
            return 0;
        } else {
            int i = n & 255;
            a aVar = this.f10341c.get(i);
            if (!this.f10343e) {
                if (aVar == null) {
                    h hVar = null;
                    if (!this.f10344f && i == 189) {
                        hVar = new b();
                        this.f10344f = true;
                    } else if (!this.f10344f && (i & 224) == 192) {
                        hVar = new m();
                        this.f10344f = true;
                    } else if (!this.f10345g && (i & 240) == 224) {
                        hVar = new i();
                        this.f10345g = true;
                    }
                    if (hVar != null) {
                        hVar.a(this.h, new v.d(i, 256));
                        aVar = new a(hVar, this.f10340b);
                        this.f10341c.put(i, aVar);
                    }
                }
                if ((this.f10344f && this.f10345g) || fVar.c() > BaseConstants.MEGA) {
                    this.f10343e = true;
                    this.h.a();
                }
            }
            fVar.c(this.f10342d.f11422a, 0, 2);
            this.f10342d.c(0);
            int h2 = this.f10342d.h() + 6;
            if (aVar == null) {
                fVar.b(h2);
            } else {
                this.f10342d.a(h2);
                fVar.b(this.f10342d.f11422a, 0, h2);
                this.f10342d.c(6);
                aVar.a(this.f10342d);
                com.google.android.exoplayer2.s.l lVar = this.f10342d;
                lVar.b(lVar.e());
            }
            return 0;
        }
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final h f10346a;

        /* renamed from: b  reason: collision with root package name */
        private final s f10347b;

        /* renamed from: c  reason: collision with root package name */
        private final com.google.android.exoplayer2.s.k f10348c = new com.google.android.exoplayer2.s.k(new byte[64]);

        /* renamed from: d  reason: collision with root package name */
        private boolean f10349d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f10350e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f10351f;

        /* renamed from: g  reason: collision with root package name */
        private int f10352g;
        private long h;

        public a(h hVar, s sVar) {
            this.f10346a = hVar;
            this.f10347b = sVar;
        }

        public void a() {
            this.f10351f = false;
            this.f10346a.a();
        }

        public void a(com.google.android.exoplayer2.s.l lVar) {
            lVar.a(this.f10348c.f11418a, 0, 3);
            this.f10348c.a(0);
            b();
            lVar.a(this.f10348c.f11418a, 0, this.f10352g);
            this.f10348c.a(0);
            c();
            this.f10346a.a(this.h, true);
            this.f10346a.a(lVar);
            this.f10346a.b();
        }

        private void b() {
            this.f10348c.b(8);
            this.f10349d = this.f10348c.e();
            this.f10350e = this.f10348c.e();
            this.f10348c.b(6);
            this.f10352g = this.f10348c.c(8);
        }

        private void c() {
            this.h = 0;
            if (this.f10349d) {
                this.f10348c.b(4);
                this.f10348c.b(1);
                this.f10348c.b(1);
                long c2 = (((long) this.f10348c.c(3)) << 30) | ((long) (this.f10348c.c(15) << 15)) | ((long) this.f10348c.c(15));
                this.f10348c.b(1);
                if (!this.f10351f && this.f10350e) {
                    this.f10348c.b(4);
                    this.f10348c.b(1);
                    this.f10348c.b(1);
                    this.f10348c.b(1);
                    this.f10347b.b((((long) this.f10348c.c(3)) << 30) | ((long) (this.f10348c.c(15) << 15)) | ((long) this.f10348c.c(15)));
                    this.f10351f = true;
                }
                this.h = this.f10347b.b(c2);
            }
        }
    }
}
