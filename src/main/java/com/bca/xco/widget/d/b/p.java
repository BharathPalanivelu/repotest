package com.bca.xco.widget.d.b;

final class p {

    /* renamed from: a  reason: collision with root package name */
    final byte[] f5244a;

    /* renamed from: b  reason: collision with root package name */
    int f5245b;

    /* renamed from: c  reason: collision with root package name */
    int f5246c;

    /* renamed from: d  reason: collision with root package name */
    boolean f5247d;

    /* renamed from: e  reason: collision with root package name */
    boolean f5248e;

    /* renamed from: f  reason: collision with root package name */
    p f5249f;

    /* renamed from: g  reason: collision with root package name */
    p f5250g;

    p() {
        this.f5244a = new byte[8192];
        this.f5248e = true;
        this.f5247d = false;
    }

    p(p pVar) {
        this(pVar.f5244a, pVar.f5245b, pVar.f5246c);
        pVar.f5247d = true;
    }

    p(byte[] bArr, int i, int i2) {
        this.f5244a = bArr;
        this.f5245b = i;
        this.f5246c = i2;
        this.f5248e = false;
        this.f5247d = true;
    }

    public p a() {
        p pVar = this.f5249f;
        if (pVar == this) {
            pVar = null;
        }
        p pVar2 = this.f5250g;
        pVar2.f5249f = this.f5249f;
        this.f5249f.f5250g = pVar2;
        this.f5249f = null;
        this.f5250g = null;
        return pVar;
    }

    public p a(p pVar) {
        pVar.f5250g = this;
        pVar.f5249f = this.f5249f;
        this.f5249f.f5250g = pVar;
        this.f5249f = pVar;
        return pVar;
    }

    public p a(int i) {
        p pVar;
        if (i <= 0 || i > this.f5246c - this.f5245b) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            pVar = new p(this);
        } else {
            pVar = q.a();
            System.arraycopy(this.f5244a, this.f5245b, pVar.f5244a, 0, i);
        }
        pVar.f5246c = pVar.f5245b + i;
        this.f5245b += i;
        this.f5250g.a(pVar);
        return pVar;
    }

    public void b() {
        p pVar = this.f5250g;
        if (pVar == this) {
            throw new IllegalStateException();
        } else if (pVar.f5248e) {
            int i = this.f5246c - this.f5245b;
            if (i <= (8192 - pVar.f5246c) + (pVar.f5247d ? 0 : pVar.f5245b)) {
                a(this.f5250g, i);
                a();
                q.a(this);
            }
        }
    }

    public void a(p pVar, int i) {
        if (pVar.f5248e) {
            int i2 = pVar.f5246c;
            if (i2 + i > 8192) {
                if (!pVar.f5247d) {
                    int i3 = pVar.f5245b;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = pVar.f5244a;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        pVar.f5246c -= pVar.f5245b;
                        pVar.f5245b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f5244a, this.f5245b, pVar.f5244a, pVar.f5246c, i);
            pVar.f5246c += i;
            this.f5245b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
