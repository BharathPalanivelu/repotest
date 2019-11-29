package com.google.zxing.c.b;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private final a f14490a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f14491b;

    b(a aVar, int[] iArr) {
        if (iArr.length != 0) {
            this.f14490a = aVar;
            int length = iArr.length;
            if (length <= 1 || iArr[0] != 0) {
                this.f14491b = iArr;
                return;
            }
            int i = 1;
            while (i < length && iArr[i] == 0) {
                i++;
            }
            if (i == length) {
                this.f14491b = new int[]{0};
                return;
            }
            this.f14491b = new int[(length - i)];
            int[] iArr2 = this.f14491b;
            System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
            return;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public int[] a() {
        return this.f14491b;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f14491b.length - 1;
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.f14491b[0] == 0;
    }

    /* access modifiers changed from: package-private */
    public int a(int i) {
        int[] iArr = this.f14491b;
        return iArr[(iArr.length - 1) - i];
    }

    /* access modifiers changed from: package-private */
    public int b(int i) {
        if (i == 0) {
            return a(0);
        }
        int[] iArr = this.f14491b;
        int length = iArr.length;
        if (i == 1) {
            int i2 = 0;
            for (int b2 : iArr) {
                i2 = a.b(i2, b2);
            }
            return i2;
        }
        int i3 = iArr[0];
        for (int i4 = 1; i4 < length; i4++) {
            i3 = a.b(this.f14490a.c(i, i3), this.f14491b[i4]);
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    public b a(b bVar) {
        if (!this.f14490a.equals(bVar.f14490a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (c()) {
            return bVar;
        } else {
            if (bVar.c()) {
                return this;
            }
            int[] iArr = this.f14491b;
            int[] iArr2 = bVar.f14491b;
            if (iArr.length > iArr2.length) {
                int[] iArr3 = iArr;
                iArr = iArr2;
                iArr2 = iArr3;
            }
            int[] iArr4 = new int[iArr2.length];
            int length = iArr2.length - iArr.length;
            System.arraycopy(iArr2, 0, iArr4, 0, length);
            for (int i = length; i < iArr2.length; i++) {
                iArr4[i] = a.b(iArr[i - length], iArr2[i]);
            }
            return new b(this.f14490a, iArr4);
        }
    }

    /* access modifiers changed from: package-private */
    public b b(b bVar) {
        if (!this.f14490a.equals(bVar.f14490a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (c() || bVar.c()) {
            return this.f14490a.a();
        } else {
            int[] iArr = this.f14491b;
            int length = iArr.length;
            int[] iArr2 = bVar.f14491b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    int i4 = i + i3;
                    iArr3[i4] = a.b(iArr3[i4], this.f14490a.c(i2, iArr2[i3]));
                }
            }
            return new b(this.f14490a, iArr3);
        }
    }

    /* access modifiers changed from: package-private */
    public b c(int i) {
        if (i == 0) {
            return this.f14490a.a();
        }
        if (i == 1) {
            return this;
        }
        int length = this.f14491b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f14490a.c(this.f14491b[i2], i);
        }
        return new b(this.f14490a, iArr);
    }

    /* access modifiers changed from: package-private */
    public b a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f14490a.a();
        } else {
            int length = this.f14491b.length;
            int[] iArr = new int[(i + length)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.f14490a.c(this.f14491b[i3], i2);
            }
            return new b(this.f14490a, iArr);
        }
    }

    /* access modifiers changed from: package-private */
    public b[] c(b bVar) {
        if (!this.f14490a.equals(bVar.f14490a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (!bVar.c()) {
            b a2 = this.f14490a.a();
            int c2 = this.f14490a.c(bVar.a(bVar.b()));
            b bVar2 = a2;
            b bVar3 = this;
            while (bVar3.b() >= bVar.b() && !bVar3.c()) {
                int b2 = bVar3.b() - bVar.b();
                int c3 = this.f14490a.c(bVar3.a(bVar3.b()), c2);
                b a3 = bVar.a(b2, c3);
                bVar2 = bVar2.a(this.f14490a.a(b2, c3));
                bVar3 = bVar3.a(a3);
            }
            return new b[]{bVar2, bVar3};
        } else {
            throw new IllegalArgumentException("Divide by 0");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(b() * 8);
        for (int b2 = b(); b2 >= 0; b2--) {
            int a2 = a(b2);
            if (a2 != 0) {
                if (a2 < 0) {
                    sb.append(" - ");
                    a2 = -a2;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (b2 == 0 || a2 != 1) {
                    int b3 = this.f14490a.b(a2);
                    if (b3 == 0) {
                        sb.append('1');
                    } else if (b3 == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(b3);
                    }
                }
                if (b2 != 0) {
                    if (b2 == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(b2);
                    }
                }
            }
        }
        return sb.toString();
    }
}
