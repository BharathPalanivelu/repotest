package com.google.android.exoplayer2.i.g;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.a;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.g.v;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.s.k;
import com.google.android.exoplayer2.s.l;
import com.path.android.jobqueue.JobManager;
import java.util.List;

public final class b implements h {

    /* renamed from: a  reason: collision with root package name */
    private final k f10232a;

    /* renamed from: b  reason: collision with root package name */
    private final l f10233b;

    /* renamed from: c  reason: collision with root package name */
    private final String f10234c;

    /* renamed from: d  reason: collision with root package name */
    private String f10235d;

    /* renamed from: e  reason: collision with root package name */
    private m f10236e;

    /* renamed from: f  reason: collision with root package name */
    private int f10237f;

    /* renamed from: g  reason: collision with root package name */
    private int f10238g;
    private boolean h;
    private long i;
    private Format j;
    private int k;
    private long l;

    public void b() {
    }

    public b() {
        this((String) null);
    }

    public b(String str) {
        this.f10232a = new k(new byte[8]);
        this.f10233b = new l(this.f10232a.f11418a);
        this.f10237f = 0;
        this.f10234c = str;
    }

    public void a() {
        this.f10237f = 0;
        this.f10238g = 0;
        this.h = false;
    }

    public void a(g gVar, v.d dVar) {
        dVar.a();
        this.f10235d = dVar.c();
        this.f10236e = gVar.a(dVar.b(), 1);
    }

    public void a(long j2, boolean z) {
        this.l = j2;
    }

    public void a(l lVar) {
        while (lVar.b() > 0) {
            int i2 = this.f10237f;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        int min = Math.min(lVar.b(), this.k - this.f10238g);
                        this.f10236e.a(lVar, min);
                        this.f10238g += min;
                        int i3 = this.f10238g;
                        int i4 = this.k;
                        if (i3 == i4) {
                            this.f10236e.a(this.l, 1, i4, 0, (m.a) null);
                            this.l += this.i;
                            this.f10237f = 0;
                        }
                    }
                } else if (a(lVar, this.f10233b.f11422a, 8)) {
                    c();
                    this.f10233b.c(0);
                    this.f10236e.a(this.f10233b, 8);
                    this.f10237f = 2;
                }
            } else if (b(lVar)) {
                this.f10237f = 1;
                this.f10233b.f11422a[0] = com.g.a.a.g.STRUCT_END;
                this.f10233b.f11422a[1] = 119;
                this.f10238g = 2;
            }
        }
    }

    private boolean a(l lVar, byte[] bArr, int i2) {
        int min = Math.min(lVar.b(), i2 - this.f10238g);
        lVar.a(bArr, this.f10238g, min);
        this.f10238g += min;
        return this.f10238g == i2;
    }

    private boolean b(l lVar) {
        while (true) {
            boolean z = false;
            if (lVar.b() <= 0) {
                return false;
            }
            if (!this.h) {
                if (lVar.g() == 11) {
                    z = true;
                }
                this.h = z;
            } else {
                int g2 = lVar.g();
                if (g2 == 119) {
                    this.h = false;
                    return true;
                }
                if (g2 == 11) {
                    z = true;
                }
                this.h = z;
            }
        }
    }

    private void c() {
        this.f10232a.a(0);
        a.C0157a a2 = a.a(this.f10232a);
        if (!(this.j != null && a2.f9149c == this.j.r && a2.f9148b == this.j.s && a2.f9147a == this.j.f8958f)) {
            this.j = Format.a(this.f10235d, a2.f9147a, (String) null, -1, -1, a2.f9149c, a2.f9148b, (List<byte[]>) null, (DrmInitData) null, 0, this.f10234c);
            this.f10236e.a(this.j);
        }
        this.k = a2.f9150d;
        this.i = (((long) a2.f9151e) * JobManager.NS_PER_MS) / ((long) this.j.s);
    }
}
