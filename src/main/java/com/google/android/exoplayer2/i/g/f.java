package com.google.android.exoplayer2.i.g;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.h;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.g.v;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.s.l;
import com.path.android.jobqueue.JobManager;

public final class f implements h {

    /* renamed from: a  reason: collision with root package name */
    private final l f10254a = new l(new byte[15]);

    /* renamed from: b  reason: collision with root package name */
    private final String f10255b;

    /* renamed from: c  reason: collision with root package name */
    private String f10256c;

    /* renamed from: d  reason: collision with root package name */
    private m f10257d;

    /* renamed from: e  reason: collision with root package name */
    private int f10258e;

    /* renamed from: f  reason: collision with root package name */
    private int f10259f;

    /* renamed from: g  reason: collision with root package name */
    private int f10260g;
    private long h;
    private Format i;
    private int j;
    private long k;

    public void b() {
    }

    public f(String str) {
        this.f10254a.f11422a[0] = Byte.MAX_VALUE;
        this.f10254a.f11422a[1] = -2;
        this.f10254a.f11422a[2] = Byte.MIN_VALUE;
        this.f10254a.f11422a[3] = 1;
        this.f10258e = 0;
        this.f10255b = str;
    }

    public void a() {
        this.f10258e = 0;
        this.f10259f = 0;
        this.f10260g = 0;
    }

    public void a(g gVar, v.d dVar) {
        dVar.a();
        this.f10256c = dVar.c();
        this.f10257d = gVar.a(dVar.b(), 1);
    }

    public void a(long j2, boolean z) {
        this.k = j2;
    }

    public void a(l lVar) {
        while (lVar.b() > 0) {
            int i2 = this.f10258e;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        int min = Math.min(lVar.b(), this.j - this.f10259f);
                        this.f10257d.a(lVar, min);
                        this.f10259f += min;
                        int i3 = this.f10259f;
                        int i4 = this.j;
                        if (i3 == i4) {
                            this.f10257d.a(this.k, 1, i4, 0, (m.a) null);
                            this.k += this.h;
                            this.f10258e = 0;
                        }
                    }
                } else if (a(lVar, this.f10254a.f11422a, 15)) {
                    c();
                    this.f10254a.c(0);
                    this.f10257d.a(this.f10254a, 15);
                    this.f10258e = 2;
                }
            } else if (b(lVar)) {
                this.f10259f = 4;
                this.f10258e = 1;
            }
        }
    }

    private boolean a(l lVar, byte[] bArr, int i2) {
        int min = Math.min(lVar.b(), i2 - this.f10259f);
        lVar.a(bArr, this.f10259f, min);
        this.f10259f += min;
        return this.f10259f == i2;
    }

    private boolean b(l lVar) {
        while (lVar.b() > 0) {
            this.f10260g <<= 8;
            this.f10260g |= lVar.g();
            if (this.f10260g == 2147385345) {
                this.f10260g = 0;
                return true;
            }
        }
        return false;
    }

    private void c() {
        byte[] bArr = this.f10254a.f11422a;
        if (this.i == null) {
            this.i = h.a(bArr, this.f10256c, this.f10255b, (DrmInitData) null);
            this.f10257d.a(this.i);
        }
        this.j = h.b(bArr);
        this.h = (long) ((int) ((((long) h.a(bArr)) * JobManager.NS_PER_MS) / ((long) this.i.s)));
    }
}
