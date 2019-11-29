package com.bca.xco.widget.d.b;

import java.util.Arrays;

final class r extends h {

    /* renamed from: f  reason: collision with root package name */
    final transient byte[][] f5253f;

    /* renamed from: g  reason: collision with root package name */
    final transient int[] f5254g;

    r(g gVar, int i) {
        super((byte[]) null);
        t.a(gVar.f5215b, 0, (long) i);
        int i2 = 0;
        p pVar = gVar.f5214a;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (pVar.f5246c != pVar.f5245b) {
                i3 += pVar.f5246c - pVar.f5245b;
                i4++;
                pVar = pVar.f5249f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f5253f = new byte[i4][];
        this.f5254g = new int[(i4 * 2)];
        p pVar2 = gVar.f5214a;
        int i5 = 0;
        while (i2 < i) {
            this.f5253f[i5] = pVar2.f5244a;
            i2 += pVar2.f5246c - pVar2.f5245b;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.f5254g;
            iArr[i5] = i2;
            iArr[this.f5253f.length + i5] = pVar2.f5245b;
            pVar2.f5247d = true;
            i5++;
            pVar2 = pVar2.f5249f;
        }
    }

    public String a() {
        return g().a();
    }

    public String b() {
        return g().b();
    }

    public String c() {
        return g().c();
    }

    public h d() {
        return g().d();
    }

    public h a(int i, int i2) {
        return g().a(i, i2);
    }

    public byte a(int i) {
        int i2;
        t.a((long) this.f5254g[this.f5253f.length - 1], (long) i, 1);
        int b2 = b(i);
        if (b2 == 0) {
            i2 = 0;
        } else {
            i2 = this.f5254g[b2 - 1];
        }
        int[] iArr = this.f5254g;
        byte[][] bArr = this.f5253f;
        return bArr[b2][(i - i2) + iArr[bArr.length + b2]];
    }

    private int b(int i) {
        int binarySearch = Arrays.binarySearch(this.f5254g, 0, this.f5253f.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ -1;
    }

    public int e() {
        return this.f5254g[this.f5253f.length - 1];
    }

    public byte[] f() {
        int[] iArr = this.f5254g;
        byte[][] bArr = this.f5253f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.f5254g;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.f5253f[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    /* access modifiers changed from: package-private */
    public void a(g gVar) {
        int length = this.f5253f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.f5254g;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            p pVar = new p(this.f5253f[i], i3, (i3 + i4) - i2);
            if (gVar.f5214a == null) {
                pVar.f5250g = pVar;
                pVar.f5249f = pVar;
                gVar.f5214a = pVar;
            } else {
                gVar.f5214a.f5250g.a(pVar);
            }
            i++;
            i2 = i4;
        }
        gVar.f5215b += (long) i2;
    }

    public boolean a(int i, h hVar, int i2, int i3) {
        int i4;
        if (i < 0 || i > e() - i3) {
            return false;
        }
        int b2 = b(i);
        while (i3 > 0) {
            if (b2 == 0) {
                i4 = 0;
            } else {
                i4 = this.f5254g[b2 - 1];
            }
            int min = Math.min(i3, ((this.f5254g[b2] - i4) + i4) - i);
            int[] iArr = this.f5254g;
            byte[][] bArr = this.f5253f;
            if (!hVar.a(i2, bArr[b2], (i - i4) + iArr[bArr.length + b2], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b2++;
        }
        return true;
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        int i4;
        if (i < 0 || i > e() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int b2 = b(i);
        while (i3 > 0) {
            if (b2 == 0) {
                i4 = 0;
            } else {
                i4 = this.f5254g[b2 - 1];
            }
            int min = Math.min(i3, ((this.f5254g[b2] - i4) + i4) - i);
            int[] iArr = this.f5254g;
            byte[][] bArr2 = this.f5253f;
            if (!t.a(bArr2[b2], (i - i4) + iArr[bArr2.length + b2], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b2++;
        }
        return true;
    }

    private h g() {
        return new h(f());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (hVar.e() != e() || !a(0, hVar, 0, e())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.f5219d;
        if (i != 0) {
            return i;
        }
        int length = this.f5253f.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.f5253f[i2];
            int[] iArr = this.f5254g;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.f5219d = i3;
        return i3;
    }

    public String toString() {
        return g().toString();
    }

    private Object writeReplace() {
        return g();
    }
}
