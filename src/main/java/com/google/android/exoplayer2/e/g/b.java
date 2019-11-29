package com.google.android.exoplayer2.e.g;

import com.g.a.a.g;
import com.google.android.exoplayer2.a.a;
import com.google.android.exoplayer2.e.g.v;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.n.j;
import com.google.android.exoplayer2.n.k;
import com.path.android.jobqueue.JobManager;
import java.util.List;

public final class b implements h {

    /* renamed from: a  reason: collision with root package name */
    private final j f9598a;

    /* renamed from: b  reason: collision with root package name */
    private final k f9599b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9600c;

    /* renamed from: d  reason: collision with root package name */
    private String f9601d;

    /* renamed from: e  reason: collision with root package name */
    private n f9602e;

    /* renamed from: f  reason: collision with root package name */
    private int f9603f;

    /* renamed from: g  reason: collision with root package name */
    private int f9604g;
    private boolean h;
    private long i;
    private com.google.android.exoplayer2.j j;
    private int k;
    private long l;

    public void b() {
    }

    public b() {
        this((String) null);
    }

    public b(String str) {
        this.f9598a = new j(new byte[8]);
        this.f9599b = new k(this.f9598a.f10944a);
        this.f9603f = 0;
        this.f9600c = str;
    }

    public void a() {
        this.f9603f = 0;
        this.f9604g = 0;
        this.h = false;
    }

    public void a(h hVar, v.d dVar) {
        dVar.a();
        this.f9601d = dVar.c();
        this.f9602e = hVar.a(dVar.b(), 1);
    }

    public void a(long j2, boolean z) {
        this.l = j2;
    }

    public void a(k kVar) {
        while (kVar.b() > 0) {
            int i2 = this.f9603f;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        int min = Math.min(kVar.b(), this.k - this.f9604g);
                        this.f9602e.a(kVar, min);
                        this.f9604g += min;
                        int i3 = this.f9604g;
                        int i4 = this.k;
                        if (i3 == i4) {
                            this.f9602e.a(this.l, 1, i4, 0, (byte[]) null);
                            this.l += this.i;
                            this.f9603f = 0;
                        }
                    }
                } else if (a(kVar, this.f9599b.f10948a, 8)) {
                    c();
                    this.f9599b.c(0);
                    this.f9602e.a(this.f9599b, 8);
                    this.f9603f = 2;
                }
            } else if (b(kVar)) {
                this.f9603f = 1;
                this.f9599b.f10948a[0] = g.STRUCT_END;
                this.f9599b.f10948a[1] = 119;
                this.f9604g = 2;
            }
        }
    }

    private boolean a(k kVar, byte[] bArr, int i2) {
        int min = Math.min(kVar.b(), i2 - this.f9604g);
        kVar.a(bArr, this.f9604g, min);
        this.f9604g += min;
        return this.f9604g == i2;
    }

    private boolean b(k kVar) {
        while (true) {
            boolean z = false;
            if (kVar.b() <= 0) {
                return false;
            }
            if (!this.h) {
                if (kVar.g() == 11) {
                    z = true;
                }
                this.h = z;
            } else {
                int g2 = kVar.g();
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
        this.f9598a.a(0);
        a.C0155a a2 = a.a(this.f9598a);
        if (!(this.j != null && a2.f8975c == this.j.r && a2.f8974b == this.j.s && a2.f8973a == this.j.f10427f)) {
            this.j = com.google.android.exoplayer2.j.a(this.f9601d, a2.f8973a, (String) null, -1, -1, a2.f8975c, a2.f8974b, (List<byte[]>) null, (com.google.android.exoplayer2.c.a) null, 0, this.f9600c);
            this.f9602e.a(this.j);
        }
        this.k = a2.f8976d;
        this.i = (((long) a2.f8977e) * JobManager.NS_PER_MS) / ((long) this.j.s);
    }
}
