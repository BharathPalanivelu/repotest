package e;

import java.util.Arrays;

final class t extends f {

    /* renamed from: e  reason: collision with root package name */
    final transient byte[][] f32790e;

    /* renamed from: f  reason: collision with root package name */
    final transient int[] f32791f;

    t(c cVar, int i) {
        super((byte[]) null);
        x.a(cVar.f32725b, 0, (long) i);
        int i2 = 0;
        r rVar = cVar.f32724a;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (rVar.f32783c != rVar.f32782b) {
                i3 += rVar.f32783c - rVar.f32782b;
                i4++;
                rVar = rVar.f32786f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f32790e = new byte[i4][];
        this.f32791f = new int[(i4 * 2)];
        r rVar2 = cVar.f32724a;
        int i5 = 0;
        while (i2 < i) {
            this.f32790e[i5] = rVar2.f32781a;
            i2 += rVar2.f32783c - rVar2.f32782b;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.f32791f;
            iArr[i5] = i2;
            iArr[this.f32790e.length + i5] = rVar2.f32782b;
            rVar2.f32784d = true;
            i5++;
            rVar2 = rVar2.f32786f;
        }
    }

    public String a() {
        return k().a();
    }

    public String b() {
        return k().b();
    }

    public String f() {
        return k().f();
    }

    public f g() {
        return k().g();
    }

    public f c() {
        return k().c();
    }

    public f d() {
        return k().d();
    }

    public f e() {
        return k().e();
    }

    public f a(int i, int i2) {
        return k().a(i, i2);
    }

    public byte a(int i) {
        int i2;
        x.a((long) this.f32791f[this.f32790e.length - 1], (long) i, 1);
        int b2 = b(i);
        if (b2 == 0) {
            i2 = 0;
        } else {
            i2 = this.f32791f[b2 - 1];
        }
        int[] iArr = this.f32791f;
        byte[][] bArr = this.f32790e;
        return bArr[b2][(i - i2) + iArr[bArr.length + b2]];
    }

    private int b(int i) {
        int binarySearch = Arrays.binarySearch(this.f32791f, 0, this.f32790e.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ -1;
    }

    public int h() {
        return this.f32791f[this.f32790e.length - 1];
    }

    public byte[] i() {
        int[] iArr = this.f32791f;
        byte[][] bArr = this.f32790e;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.f32791f;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.f32790e[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    /* access modifiers changed from: package-private */
    public void a(c cVar) {
        int length = this.f32790e.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.f32791f;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            r rVar = new r(this.f32790e[i], i3, (i3 + i4) - i2, true, false);
            if (cVar.f32724a == null) {
                rVar.f32787g = rVar;
                rVar.f32786f = rVar;
                cVar.f32724a = rVar;
            } else {
                cVar.f32724a.f32787g.a(rVar);
            }
            i++;
            i2 = i4;
        }
        cVar.f32725b += (long) i2;
    }

    public boolean a(int i, f fVar, int i2, int i3) {
        int i4;
        if (i < 0 || i > h() - i3) {
            return false;
        }
        int b2 = b(i);
        while (i3 > 0) {
            if (b2 == 0) {
                i4 = 0;
            } else {
                i4 = this.f32791f[b2 - 1];
            }
            int min = Math.min(i3, ((this.f32791f[b2] - i4) + i4) - i);
            int[] iArr = this.f32791f;
            byte[][] bArr = this.f32790e;
            if (!fVar.a(i2, bArr[b2], (i - i4) + iArr[bArr.length + b2], min)) {
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
        if (i < 0 || i > h() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int b2 = b(i);
        while (i3 > 0) {
            if (b2 == 0) {
                i4 = 0;
            } else {
                i4 = this.f32791f[b2 - 1];
            }
            int min = Math.min(i3, ((this.f32791f[b2] - i4) + i4) - i);
            int[] iArr = this.f32791f;
            byte[][] bArr2 = this.f32790e;
            if (!x.a(bArr2[b2], (i - i4) + iArr[bArr2.length + b2], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b2++;
        }
        return true;
    }

    private f k() {
        return new f(i());
    }

    /* access modifiers changed from: package-private */
    public byte[] j() {
        return i();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (fVar.h() != h() || !a(0, fVar, 0, h())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.f32737c;
        if (i != 0) {
            return i;
        }
        int length = this.f32790e.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.f32790e[i2];
            int[] iArr = this.f32791f;
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
        this.f32737c = i3;
        return i3;
    }

    public String toString() {
        return k().toString();
    }

    private Object writeReplace() {
        return k();
    }
}
