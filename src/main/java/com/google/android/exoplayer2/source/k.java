package com.google.android.exoplayer2.source;

import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.e;
import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.s.l;
import com.google.android.exoplayer2.source.j;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class k implements m {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.exoplayer2.r.b f12096a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12097b;

    /* renamed from: c  reason: collision with root package name */
    private final j f12098c = new j();

    /* renamed from: d  reason: collision with root package name */
    private final j.a f12099d = new j.a();

    /* renamed from: e  reason: collision with root package name */
    private final l f12100e = new l(32);

    /* renamed from: f  reason: collision with root package name */
    private a f12101f = new a(0, this.f12097b);

    /* renamed from: g  reason: collision with root package name */
    private a f12102g;
    private a h;
    private Format i;
    private boolean j;
    private Format k;
    private long l;
    private long m;
    private boolean n;
    private b o;

    public interface b {
        void a(Format format);
    }

    public k(com.google.android.exoplayer2.r.b bVar) {
        this.f12096a = bVar;
        this.f12097b = bVar.c();
        a aVar = this.f12101f;
        this.f12102g = aVar;
        this.h = aVar;
    }

    public void a() {
        a(false);
    }

    public void a(boolean z) {
        this.f12098c.a(z);
        a(this.f12101f);
        this.f12101f = new a(0, this.f12097b);
        a aVar = this.f12101f;
        this.f12102g = aVar;
        this.h = aVar;
        this.m = 0;
        this.f12096a.b();
    }

    public void a(int i2) {
        this.f12098c.b(i2);
    }

    public void b() {
        this.n = true;
    }

    public int c() {
        return this.f12098c.a();
    }

    public void b(int i2) {
        this.m = this.f12098c.a(i2);
        long j2 = this.m;
        if (j2 == 0 || j2 == this.f12101f.f12103a) {
            a(this.f12101f);
            this.f12101f = new a(this.m, this.f12097b);
            a aVar = this.f12101f;
            this.f12102g = aVar;
            this.h = aVar;
            return;
        }
        a aVar2 = this.f12101f;
        while (this.m > aVar2.f12104b) {
            aVar2 = aVar2.f12107e;
        }
        a aVar3 = aVar2.f12107e;
        a(aVar3);
        aVar2.f12107e = new a(aVar2.f12104b, this.f12097b);
        this.h = this.m == aVar2.f12104b ? aVar2.f12107e : aVar2;
        if (this.f12102g == aVar3) {
            this.f12102g = aVar2.f12107e;
        }
    }

    public boolean d() {
        return this.f12098c.d();
    }

    public int e() {
        return this.f12098c.b();
    }

    public int f() {
        return this.f12098c.c();
    }

    public Format g() {
        return this.f12098c.e();
    }

    public long h() {
        return this.f12098c.f();
    }

    public void i() {
        this.f12098c.g();
        this.f12102g = this.f12101f;
    }

    public void a(long j2, boolean z, boolean z2) {
        c(this.f12098c.b(j2, z, z2));
    }

    public void j() {
        c(this.f12098c.i());
    }

    public void k() {
        c(this.f12098c.j());
    }

    public void l() {
        this.f12098c.h();
    }

    public boolean b(long j2, boolean z, boolean z2) {
        return this.f12098c.a(j2, z, z2);
    }

    public int a(com.google.android.exoplayer2.l lVar, e eVar, boolean z, boolean z2, long j2) {
        int a2 = this.f12098c.a(lVar, eVar, z, z2, this.i, this.f12099d);
        if (a2 == -5) {
            this.i = lVar.f10690a;
            return -5;
        } else if (a2 == -4) {
            if (!eVar.c()) {
                if (eVar.f9882c < j2) {
                    eVar.b(RNCartPanelDataEntity.NULL_VALUE);
                }
                if (eVar.g()) {
                    a(eVar, this.f12099d);
                }
                eVar.e(this.f12099d.f12093a);
                a(this.f12099d.f12094b, eVar.f9881b, this.f12099d.f12093a);
            }
            return -4;
        } else if (a2 == -3) {
            return -3;
        } else {
            throw new IllegalStateException();
        }
    }

    private void a(e eVar, j.a aVar) {
        int i2;
        e eVar2 = eVar;
        j.a aVar2 = aVar;
        long j2 = aVar2.f12094b;
        this.f12100e.a(1);
        a(j2, this.f12100e.f11422a, 1);
        long j3 = j2 + 1;
        byte b2 = this.f12100e.f11422a[0];
        boolean z = (b2 & 128) != 0;
        byte b3 = b2 & Byte.MAX_VALUE;
        if (eVar2.f9880a.f9864a == null) {
            eVar2.f9880a.f9864a = new byte[16];
        }
        a(j3, eVar2.f9880a.f9864a, (int) b3);
        long j4 = j3 + ((long) b3);
        if (z) {
            this.f12100e.a(2);
            a(j4, this.f12100e.f11422a, 2);
            j4 += 2;
            i2 = this.f12100e.h();
        } else {
            i2 = 1;
        }
        int[] iArr = eVar2.f9880a.f9867d;
        if (iArr == null || iArr.length < i2) {
            iArr = new int[i2];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = eVar2.f9880a.f9868e;
        if (iArr3 == null || iArr3.length < i2) {
            iArr3 = new int[i2];
        }
        int[] iArr4 = iArr3;
        if (z) {
            int i3 = i2 * 6;
            this.f12100e.a(i3);
            a(j4, this.f12100e.f11422a, i3);
            j4 += (long) i3;
            this.f12100e.c(0);
            for (int i4 = 0; i4 < i2; i4++) {
                iArr2[i4] = this.f12100e.h();
                iArr4[i4] = this.f12100e.t();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = aVar2.f12093a - ((int) (j4 - aVar2.f12094b));
        }
        m.a aVar3 = aVar2.f12095c;
        eVar2.f9880a.a(i2, iArr2, iArr4, aVar3.f10419b, eVar2.f9880a.f9864a, aVar3.f10418a, aVar3.f10420c, aVar3.f10421d);
        int i5 = (int) (j4 - aVar2.f12094b);
        aVar2.f12094b += (long) i5;
        aVar2.f12093a -= i5;
    }

    private void a(long j2, ByteBuffer byteBuffer, int i2) {
        b(j2);
        while (i2 > 0) {
            int min = Math.min(i2, (int) (this.f12102g.f12104b - j2));
            byteBuffer.put(this.f12102g.f12106d.f11292a, this.f12102g.a(j2), min);
            i2 -= min;
            j2 += (long) min;
            if (j2 == this.f12102g.f12104b) {
                this.f12102g = this.f12102g.f12107e;
            }
        }
    }

    private void a(long j2, byte[] bArr, int i2) {
        b(j2);
        long j3 = j2;
        int i3 = i2;
        while (i3 > 0) {
            int min = Math.min(i3, (int) (this.f12102g.f12104b - j3));
            System.arraycopy(this.f12102g.f12106d.f11292a, this.f12102g.a(j3), bArr, i2 - i3, min);
            i3 -= min;
            j3 += (long) min;
            if (j3 == this.f12102g.f12104b) {
                this.f12102g = this.f12102g.f12107e;
            }
        }
    }

    private void b(long j2) {
        while (j2 >= this.f12102g.f12104b) {
            this.f12102g = this.f12102g.f12107e;
        }
    }

    private void c(long j2) {
        if (j2 != -1) {
            while (j2 >= this.f12101f.f12104b) {
                this.f12096a.a(this.f12101f.f12106d);
                this.f12101f = this.f12101f.a();
            }
            if (this.f12102g.f12103a < this.f12101f.f12103a) {
                this.f12102g = this.f12101f;
            }
        }
    }

    public void a(b bVar) {
        this.o = bVar;
    }

    public void a(long j2) {
        if (this.l != j2) {
            this.l = j2;
            this.j = true;
        }
    }

    public void a(Format format) {
        Format a2 = a(format, this.l);
        boolean a3 = this.f12098c.a(a2);
        this.k = format;
        this.j = false;
        b bVar = this.o;
        if (bVar != null && a3) {
            bVar.a(a2);
        }
    }

    public int a(f fVar, int i2, boolean z) throws IOException, InterruptedException {
        int a2 = fVar.a(this.h.f12106d.f11292a, this.h.a(this.m), c(i2));
        if (a2 != -1) {
            d(a2);
            return a2;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public void a(l lVar, int i2) {
        while (i2 > 0) {
            int c2 = c(i2);
            lVar.a(this.h.f12106d.f11292a, this.h.a(this.m), c2);
            i2 -= c2;
            d(c2);
        }
    }

    public void a(long j2, int i2, int i3, int i4, m.a aVar) {
        long j3 = j2;
        if (this.j) {
            a(this.k);
        }
        if (this.n) {
            if ((i2 & 1) != 0 && this.f12098c.b(j2)) {
                this.n = false;
            } else {
                return;
            }
        }
        this.f12098c.a(j3 + this.l, i2, (this.m - ((long) i3)) - ((long) i4), i3, aVar);
    }

    private void a(a aVar) {
        if (aVar.f12105c) {
            com.google.android.exoplayer2.r.a[] aVarArr = new com.google.android.exoplayer2.r.a[((this.h.f12105c ? 1 : 0) + (((int) (this.h.f12103a - aVar.f12103a)) / this.f12097b))];
            for (int i2 = 0; i2 < aVarArr.length; i2++) {
                aVarArr[i2] = aVar.f12106d;
                aVar = aVar.a();
            }
            this.f12096a.a(aVarArr);
        }
    }

    private int c(int i2) {
        if (!this.h.f12105c) {
            this.h.a(this.f12096a.a(), new a(this.h.f12104b, this.f12097b));
        }
        return Math.min(i2, (int) (this.h.f12104b - this.m));
    }

    private void d(int i2) {
        this.m += (long) i2;
        if (this.m == this.h.f12104b) {
            this.h = this.h.f12107e;
        }
    }

    private static Format a(Format format, long j2) {
        if (format == null) {
            return null;
        }
        return (j2 == 0 || format.w == Clock.MAX_TIME) ? format : format.a(format.w + j2);
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final long f12103a;

        /* renamed from: b  reason: collision with root package name */
        public final long f12104b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f12105c;

        /* renamed from: d  reason: collision with root package name */
        public com.google.android.exoplayer2.r.a f12106d;

        /* renamed from: e  reason: collision with root package name */
        public a f12107e;

        public a(long j, int i) {
            this.f12103a = j;
            this.f12104b = j + ((long) i);
        }

        public void a(com.google.android.exoplayer2.r.a aVar, a aVar2) {
            this.f12106d = aVar;
            this.f12107e = aVar2;
            this.f12105c = true;
        }

        public int a(long j) {
            return ((int) (j - this.f12103a)) + this.f12106d.f11293b;
        }

        public a a() {
            this.f12106d = null;
            a aVar = this.f12107e;
            this.f12107e = null;
            return aVar;
        }
    }
}
