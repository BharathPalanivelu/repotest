package com.google.android.exoplayer2.e.g;

import com.google.android.exoplayer2.c.a;
import com.google.android.exoplayer2.e.g.v;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.n.k;
import com.path.android.jobqueue.JobManager;
import java.util.List;

public final class m implements h {

    /* renamed from: a  reason: collision with root package name */
    private final k f9685a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.exoplayer2.e.k f9686b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9687c;

    /* renamed from: d  reason: collision with root package name */
    private String f9688d;

    /* renamed from: e  reason: collision with root package name */
    private n f9689e;

    /* renamed from: f  reason: collision with root package name */
    private int f9690f;

    /* renamed from: g  reason: collision with root package name */
    private int f9691g;
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
        this.f9690f = 0;
        this.f9685a = new k(4);
        this.f9685a.f10948a[0] = -1;
        this.f9686b = new com.google.android.exoplayer2.e.k();
        this.f9687c = str;
    }

    public void a() {
        this.f9690f = 0;
        this.f9691g = 0;
        this.i = false;
    }

    public void a(h hVar, v.d dVar) {
        dVar.a();
        this.f9688d = dVar.c();
        this.f9689e = hVar.a(dVar.b(), 1);
    }

    public void a(long j2, boolean z) {
        this.l = j2;
    }

    public void a(k kVar) {
        while (kVar.b() > 0) {
            int i2 = this.f9690f;
            if (i2 == 0) {
                b(kVar);
            } else if (i2 == 1) {
                c(kVar);
            } else if (i2 == 2) {
                d(kVar);
            }
        }
    }

    private void b(k kVar) {
        byte[] bArr = kVar.f10948a;
        int c2 = kVar.c();
        for (int d2 = kVar.d(); d2 < c2; d2++) {
            boolean z = (bArr[d2] & 255) == 255;
            boolean z2 = this.i && (bArr[d2] & 224) == 224;
            this.i = z;
            if (z2) {
                kVar.c(d2 + 1);
                this.i = false;
                this.f9685a.f10948a[1] = bArr[d2];
                this.f9691g = 2;
                this.f9690f = 1;
                return;
            }
        }
        kVar.c(c2);
    }

    private void c(k kVar) {
        int min = Math.min(kVar.b(), 4 - this.f9691g);
        kVar.a(this.f9685a.f10948a, this.f9691g, min);
        this.f9691g += min;
        if (this.f9691g >= 4) {
            this.f9685a.c(0);
            if (!com.google.android.exoplayer2.e.k.a(this.f9685a.n(), this.f9686b)) {
                this.f9691g = 0;
                this.f9690f = 1;
                return;
            }
            this.k = this.f9686b.f9774c;
            if (!this.h) {
                this.j = (((long) this.f9686b.f9778g) * JobManager.NS_PER_MS) / ((long) this.f9686b.f9775d);
                this.f9689e.a(j.a(this.f9688d, this.f9686b.f9773b, (String) null, -1, 4096, this.f9686b.f9776e, this.f9686b.f9775d, (List<byte[]>) null, (a) null, 0, this.f9687c));
                this.h = true;
            }
            this.f9685a.c(0);
            this.f9689e.a(this.f9685a, 4);
            this.f9690f = 2;
        }
    }

    private void d(k kVar) {
        int min = Math.min(kVar.b(), this.k - this.f9691g);
        this.f9689e.a(kVar, min);
        this.f9691g += min;
        int i2 = this.f9691g;
        int i3 = this.k;
        if (i2 >= i3) {
            this.f9689e.a(this.l, 1, i3, 0, (byte[]) null);
            this.l += this.j;
            this.f9691g = 0;
            this.f9690f = 0;
        }
    }
}
