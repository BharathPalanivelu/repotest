package com.google.android.exoplayer2.e.g;

import android.util.SparseArray;
import com.google.android.exoplayer2.e.f;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.e.g.v;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.e.i;
import com.google.android.exoplayer2.e.l;
import com.google.android.exoplayer2.e.m;
import com.google.android.exoplayer2.n.j;
import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.q;
import com.tencent.imsdk.BaseConstants;
import java.io.IOException;

public final class p implements f {

    /* renamed from: a  reason: collision with root package name */
    public static final i f9704a = new i() {
        public f[] a() {
            return new f[]{new p()};
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final q f9705b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<a> f9706c;

    /* renamed from: d  reason: collision with root package name */
    private final k f9707d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9708e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9709f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9710g;
    private h h;

    public void c() {
    }

    public p() {
        this(new q(0));
    }

    public p(q qVar) {
        this.f9705b = qVar;
        this.f9707d = new k(4096);
        this.f9706c = new SparseArray<>();
    }

    public boolean a(g gVar) throws IOException, InterruptedException {
        byte[] bArr = new byte[14];
        gVar.c(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        gVar.c(bArr[13] & 7);
        gVar.c(bArr, 0, 3);
        if (1 == (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8) | (bArr[2] & 255))) {
            return true;
        }
        return false;
    }

    public void a(h hVar) {
        this.h = hVar;
        hVar.a(new m.a(-9223372036854775807L));
    }

    public void a(long j, long j2) {
        this.f9705b.d();
        for (int i = 0; i < this.f9706c.size(); i++) {
            this.f9706c.valueAt(i).a();
        }
    }

    public int a(g gVar, l lVar) throws IOException, InterruptedException {
        if (!gVar.b(this.f9707d.f10948a, 0, 4, true)) {
            return -1;
        }
        this.f9707d.c(0);
        int n = this.f9707d.n();
        if (n == 441) {
            return -1;
        }
        if (n == 442) {
            gVar.c(this.f9707d.f10948a, 0, 10);
            this.f9707d.c(9);
            gVar.b((this.f9707d.g() & 7) + 14);
            return 0;
        } else if (n == 443) {
            gVar.c(this.f9707d.f10948a, 0, 2);
            this.f9707d.c(0);
            gVar.b(this.f9707d.h() + 6);
            return 0;
        } else if (((n & -256) >> 8) != 1) {
            gVar.b(1);
            return 0;
        } else {
            int i = n & 255;
            a aVar = this.f9706c.get(i);
            if (!this.f9708e) {
                if (aVar == null) {
                    h hVar = null;
                    if (!this.f9709f && i == 189) {
                        hVar = new b();
                        this.f9709f = true;
                    } else if (!this.f9709f && (i & 224) == 192) {
                        hVar = new m();
                        this.f9709f = true;
                    } else if (!this.f9710g && (i & 240) == 224) {
                        hVar = new i();
                        this.f9710g = true;
                    }
                    if (hVar != null) {
                        hVar.a(this.h, new v.d(i, 256));
                        aVar = new a(hVar, this.f9705b);
                        this.f9706c.put(i, aVar);
                    }
                }
                if ((this.f9709f && this.f9710g) || gVar.c() > BaseConstants.MEGA) {
                    this.f9708e = true;
                    this.h.a();
                }
            }
            gVar.c(this.f9707d.f10948a, 0, 2);
            this.f9707d.c(0);
            int h2 = this.f9707d.h() + 6;
            if (aVar == null) {
                gVar.b(h2);
            } else {
                this.f9707d.a(h2);
                gVar.b(this.f9707d.f10948a, 0, h2);
                this.f9707d.c(6);
                aVar.a(this.f9707d);
                k kVar = this.f9707d;
                kVar.b(kVar.e());
            }
            return 0;
        }
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final h f9711a;

        /* renamed from: b  reason: collision with root package name */
        private final q f9712b;

        /* renamed from: c  reason: collision with root package name */
        private final j f9713c = new j(new byte[64]);

        /* renamed from: d  reason: collision with root package name */
        private boolean f9714d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f9715e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f9716f;

        /* renamed from: g  reason: collision with root package name */
        private int f9717g;
        private long h;

        public a(h hVar, q qVar) {
            this.f9711a = hVar;
            this.f9712b = qVar;
        }

        public void a() {
            this.f9716f = false;
            this.f9711a.a();
        }

        public void a(k kVar) {
            kVar.a(this.f9713c.f10944a, 0, 3);
            this.f9713c.a(0);
            b();
            kVar.a(this.f9713c.f10944a, 0, this.f9717g);
            this.f9713c.a(0);
            c();
            this.f9711a.a(this.h, true);
            this.f9711a.a(kVar);
            this.f9711a.b();
        }

        private void b() {
            this.f9713c.b(8);
            this.f9714d = this.f9713c.d();
            this.f9715e = this.f9713c.d();
            this.f9713c.b(6);
            this.f9717g = this.f9713c.c(8);
        }

        private void c() {
            this.h = 0;
            if (this.f9714d) {
                this.f9713c.b(4);
                this.f9713c.b(1);
                this.f9713c.b(1);
                long c2 = (((long) this.f9713c.c(3)) << 30) | ((long) (this.f9713c.c(15) << 15)) | ((long) this.f9713c.c(15));
                this.f9713c.b(1);
                if (!this.f9716f && this.f9715e) {
                    this.f9713c.b(4);
                    this.f9713c.b(1);
                    this.f9713c.b(1);
                    this.f9713c.b(1);
                    this.f9712b.b((((long) this.f9713c.c(3)) << 30) | ((long) (this.f9713c.c(15) << 15)) | ((long) this.f9713c.c(15)));
                    this.f9716f = true;
                }
                this.h = this.f9712b.b(c2);
            }
        }
    }
}
