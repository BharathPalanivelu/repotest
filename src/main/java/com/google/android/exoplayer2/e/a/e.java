package com.google.android.exoplayer2.e.a;

import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.e.a.d;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.k.a;
import com.google.android.exoplayer2.n.i;
import com.google.android.exoplayer2.n.k;

final class e extends d {

    /* renamed from: b  reason: collision with root package name */
    private final k f9323b = new k(i.f10930a);

    /* renamed from: c  reason: collision with root package name */
    private final k f9324c = new k(4);

    /* renamed from: d  reason: collision with root package name */
    private int f9325d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9326e;

    /* renamed from: f  reason: collision with root package name */
    private int f9327f;

    public e(n nVar) {
        super(nVar);
    }

    /* access modifiers changed from: protected */
    public boolean a(k kVar) throws d.a {
        int g2 = kVar.g();
        int i = (g2 >> 4) & 15;
        int i2 = g2 & 15;
        if (i2 == 7) {
            this.f9327f = i;
            return i != 5;
        }
        throw new d.a("Video format not supported: " + i2);
    }

    /* access modifiers changed from: protected */
    public void a(k kVar, long j) throws ak {
        int g2 = kVar.g();
        long k = j + (((long) kVar.k()) * 1000);
        if (g2 == 0 && !this.f9326e) {
            k kVar2 = new k(new byte[kVar.b()]);
            kVar.a(kVar2.f10948a, 0, kVar.b());
            a a2 = a.a(kVar2);
            this.f9325d = a2.f10634b;
            this.f9322a.a(j.a((String) null, "video/avc", (String) null, -1, -1, a2.f10635c, a2.f10636d, -1.0f, a2.f10633a, -1, a2.f10637e, (com.google.android.exoplayer2.c.a) null));
            this.f9326e = true;
        } else if (g2 == 1 && this.f9326e) {
            byte[] bArr = this.f9324c.f10948a;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i = 4 - this.f9325d;
            int i2 = 0;
            while (kVar.b() > 0) {
                kVar.a(this.f9324c.f10948a, i, this.f9325d);
                this.f9324c.c(0);
                int t = this.f9324c.t();
                this.f9323b.c(0);
                this.f9322a.a(this.f9323b, 4);
                this.f9322a.a(kVar, t);
                i2 = i2 + 4 + t;
            }
            this.f9322a.a(k, this.f9327f == 1 ? 1 : 0, i2, 0, (byte[]) null);
        }
    }
}
