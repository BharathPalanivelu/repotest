package com.google.android.exoplayer2.i.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.a.d;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.s.j;
import com.google.android.exoplayer2.s.l;
import com.google.android.exoplayer2.video.a;

final class e extends d {

    /* renamed from: b  reason: collision with root package name */
    private final l f9959b = new l(j.f11404a);

    /* renamed from: c  reason: collision with root package name */
    private final l f9960c = new l(4);

    /* renamed from: d  reason: collision with root package name */
    private int f9961d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9962e;

    /* renamed from: f  reason: collision with root package name */
    private int f9963f;

    public e(m mVar) {
        super(mVar);
    }

    /* access modifiers changed from: protected */
    public boolean a(l lVar) throws d.a {
        int g2 = lVar.g();
        int i = (g2 >> 4) & 15;
        int i2 = g2 & 15;
        if (i2 == 7) {
            this.f9963f = i;
            return i != 5;
        }
        throw new d.a("Video format not supported: " + i2);
    }

    /* access modifiers changed from: protected */
    public void a(l lVar, long j) throws p {
        int g2 = lVar.g();
        long k = j + (((long) lVar.k()) * 1000);
        if (g2 == 0 && !this.f9962e) {
            l lVar2 = new l(new byte[lVar.b()]);
            lVar.a(lVar2.f11422a, 0, lVar.b());
            a a2 = a.a(lVar2);
            this.f9961d = a2.f12234b;
            this.f9958a.a(Format.a((String) null, "video/avc", (String) null, -1, -1, a2.f12235c, a2.f12236d, -1.0f, a2.f12233a, -1, a2.f12237e, (DrmInitData) null));
            this.f9962e = true;
        } else if (g2 == 1 && this.f9962e) {
            byte[] bArr = this.f9960c.f11422a;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i = 4 - this.f9961d;
            int i2 = 0;
            while (lVar.b() > 0) {
                lVar.a(this.f9960c.f11422a, i, this.f9961d);
                this.f9960c.c(0);
                int t = this.f9960c.t();
                this.f9959b.c(0);
                this.f9958a.a(this.f9959b, 4);
                this.f9958a.a(lVar, t);
                i2 = i2 + 4 + t;
            }
            this.f9958a.a(k, this.f9963f == 1 ? 1 : 0, i2, 0, (m.a) null);
        }
    }
}
