package com.google.android.exoplayer2.i.g;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.g.v;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.s.l;
import com.path.android.jobqueue.JobManager;
import java.util.List;

public final class m implements h {

    /* renamed from: a  reason: collision with root package name */
    private final l f10320a;

    /* renamed from: b  reason: collision with root package name */
    private final j f10321b;

    /* renamed from: c  reason: collision with root package name */
    private final String f10322c;

    /* renamed from: d  reason: collision with root package name */
    private String f10323d;

    /* renamed from: e  reason: collision with root package name */
    private com.google.android.exoplayer2.i.m f10324e;

    /* renamed from: f  reason: collision with root package name */
    private int f10325f;

    /* renamed from: g  reason: collision with root package name */
    private int f10326g;
    private boolean h;
    private boolean i;
    private long j;
    private int k;
    private long l;

    public void b() {
    }

    public m() {
        this((String) null);
    }

    public m(String str) {
        this.f10325f = 0;
        this.f10320a = new l(4);
        this.f10320a.f11422a[0] = -1;
        this.f10321b = new j();
        this.f10322c = str;
    }

    public void a() {
        this.f10325f = 0;
        this.f10326g = 0;
        this.i = false;
    }

    public void a(g gVar, v.d dVar) {
        dVar.a();
        this.f10323d = dVar.c();
        this.f10324e = gVar.a(dVar.b(), 1);
    }

    public void a(long j2, boolean z) {
        this.l = j2;
    }

    public void a(l lVar) {
        while (lVar.b() > 0) {
            int i2 = this.f10325f;
            if (i2 == 0) {
                b(lVar);
            } else if (i2 == 1) {
                c(lVar);
            } else if (i2 == 2) {
                d(lVar);
            }
        }
    }

    private void b(l lVar) {
        byte[] bArr = lVar.f11422a;
        int c2 = lVar.c();
        for (int d2 = lVar.d(); d2 < c2; d2++) {
            boolean z = (bArr[d2] & 255) == 255;
            boolean z2 = this.i && (bArr[d2] & 224) == 224;
            this.i = z;
            if (z2) {
                lVar.c(d2 + 1);
                this.i = false;
                this.f10320a.f11422a[1] = bArr[d2];
                this.f10326g = 2;
                this.f10325f = 1;
                return;
            }
        }
        lVar.c(c2);
    }

    private void c(l lVar) {
        int min = Math.min(lVar.b(), 4 - this.f10326g);
        lVar.a(this.f10320a.f11422a, this.f10326g, min);
        this.f10326g += min;
        if (this.f10326g >= 4) {
            this.f10320a.c(0);
            if (!j.a(this.f10320a.n(), this.f10321b)) {
                this.f10326g = 0;
                this.f10325f = 1;
                return;
            }
            this.k = this.f10321b.f10411c;
            if (!this.h) {
                this.j = (((long) this.f10321b.f10415g) * JobManager.NS_PER_MS) / ((long) this.f10321b.f10412d);
                this.f10324e.a(Format.a(this.f10323d, this.f10321b.f10410b, (String) null, -1, 4096, this.f10321b.f10413e, this.f10321b.f10412d, (List<byte[]>) null, (DrmInitData) null, 0, this.f10322c));
                this.h = true;
            }
            this.f10320a.c(0);
            this.f10324e.a(this.f10320a, 4);
            this.f10325f = 2;
        }
    }

    private void d(l lVar) {
        int min = Math.min(lVar.b(), this.k - this.f10326g);
        this.f10324e.a(lVar, min);
        this.f10326g += min;
        int i2 = this.f10326g;
        int i3 = this.k;
        if (i2 >= i3) {
            this.f10324e.a(this.l, 1, i3, 0, (m.a) null);
            this.l += this.j;
            this.f10326g = 0;
            this.f10325f = 0;
        }
    }
}
