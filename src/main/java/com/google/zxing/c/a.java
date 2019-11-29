package com.google.zxing.c;

import java.util.Arrays;

public final class a implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private int[] f14477a;

    /* renamed from: b  reason: collision with root package name */
    private int f14478b;

    public a() {
        this.f14478b = 0;
        this.f14477a = new int[1];
    }

    public a(int i) {
        this.f14478b = i;
        this.f14477a = f(i);
    }

    a(int[] iArr, int i) {
        this.f14477a = iArr;
        this.f14478b = i;
    }

    public int a() {
        return this.f14478b;
    }

    public int b() {
        return (this.f14478b + 7) / 8;
    }

    private void e(int i) {
        if (i > this.f14477a.length * 32) {
            int[] f2 = f(i);
            int[] iArr = this.f14477a;
            System.arraycopy(iArr, 0, f2, 0, iArr.length);
            this.f14477a = f2;
        }
    }

    public boolean a(int i) {
        return ((1 << (i & 31)) & this.f14477a[i / 32]) != 0;
    }

    public void b(int i) {
        int[] iArr = this.f14477a;
        int i2 = i / 32;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    public int c(int i) {
        int i2 = this.f14478b;
        if (i >= i2) {
            return i2;
        }
        int i3 = i / 32;
        int i4 = (((1 << (i & 31)) - 1) ^ -1) & this.f14477a[i3];
        while (i4 == 0) {
            i3++;
            int[] iArr = this.f14477a;
            if (i3 == iArr.length) {
                return this.f14478b;
            }
            i4 = iArr[i3];
        }
        int numberOfTrailingZeros = (i3 * 32) + Integer.numberOfTrailingZeros(i4);
        int i5 = this.f14478b;
        return numberOfTrailingZeros > i5 ? i5 : numberOfTrailingZeros;
    }

    public int d(int i) {
        int i2 = this.f14478b;
        if (i >= i2) {
            return i2;
        }
        int i3 = i / 32;
        int i4 = (((1 << (i & 31)) - 1) ^ -1) & (this.f14477a[i3] ^ -1);
        while (i4 == 0) {
            i3++;
            int[] iArr = this.f14477a;
            if (i3 == iArr.length) {
                return this.f14478b;
            }
            i4 = iArr[i3] ^ -1;
        }
        int numberOfTrailingZeros = (i3 * 32) + Integer.numberOfTrailingZeros(i4);
        int i5 = this.f14478b;
        return numberOfTrailingZeros > i5 ? i5 : numberOfTrailingZeros;
    }

    public void c() {
        int length = this.f14477a.length;
        for (int i = 0; i < length; i++) {
            this.f14477a[i] = 0;
        }
    }

    public boolean a(int i, int i2, boolean z) {
        int i3;
        if (i2 < i) {
            throw new IllegalArgumentException();
        } else if (i2 == i) {
            return true;
        } else {
            int i4 = i2 - 1;
            int i5 = i / 32;
            int i6 = i4 / 32;
            int i7 = i5;
            while (i7 <= i6) {
                int i8 = i7 > i5 ? 0 : i & 31;
                int i9 = i7 < i6 ? 31 : i4 & 31;
                if (i8 == 0 && i9 == 31) {
                    i3 = -1;
                } else {
                    i3 = 0;
                    while (i8 <= i9) {
                        i3 |= 1 << i8;
                        i8++;
                    }
                }
                int i10 = this.f14477a[i7] & i3;
                if (!z) {
                    i3 = 0;
                }
                if (i10 != i3) {
                    return false;
                }
                i7++;
            }
            return true;
        }
    }

    public void a(boolean z) {
        e(this.f14478b + 1);
        if (z) {
            int[] iArr = this.f14477a;
            int i = this.f14478b;
            int i2 = i / 32;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
        }
        this.f14478b++;
    }

    public void a(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        e(this.f14478b + i2);
        while (i2 > 0) {
            boolean z = true;
            if (((i >> (i2 - 1)) & 1) != 1) {
                z = false;
            }
            a(z);
            i2--;
        }
    }

    public void a(a aVar) {
        int i = aVar.f14478b;
        e(this.f14478b + i);
        for (int i2 = 0; i2 < i; i2++) {
            a(aVar.a(i2));
        }
    }

    public void b(a aVar) {
        if (this.f14477a.length == aVar.f14477a.length) {
            int i = 0;
            while (true) {
                int[] iArr = this.f14477a;
                if (i < iArr.length) {
                    iArr[i] = iArr[i] ^ aVar.f14477a[i];
                    i++;
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Sizes don't match");
        }
    }

    public void a(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        int i5 = 0;
        while (i5 < i3) {
            int i6 = i4;
            int i7 = 0;
            for (int i8 = 0; i8 < 8; i8++) {
                if (a(i6)) {
                    i7 |= 1 << (7 - i8);
                }
                i6++;
            }
            bArr[i2 + i5] = (byte) i7;
            i5++;
            i4 = i6;
        }
    }

    public void d() {
        int[] iArr = new int[this.f14477a.length];
        int i = (this.f14478b - 1) / 32;
        int i2 = i + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            long j = (long) this.f14477a[i3];
            long j2 = ((j & 1431655765) << 1) | ((j >> 1) & 1431655765);
            long j3 = ((j2 & 858993459) << 2) | ((j2 >> 2) & 858993459);
            long j4 = ((j3 & 252645135) << 4) | ((j3 >> 4) & 252645135);
            long j5 = ((j4 & 16711935) << 8) | ((j4 >> 8) & 16711935);
            iArr[i - i3] = (int) (((j5 & 65535) << 16) | ((j5 >> 16) & 65535));
        }
        int i4 = this.f14478b;
        int i5 = i2 * 32;
        if (i4 != i5) {
            int i6 = i5 - i4;
            int i7 = 1;
            for (int i8 = 0; i8 < 31 - i6; i8++) {
                i7 = (i7 << 1) | 1;
            }
            int i9 = (iArr[0] >> i6) & i7;
            for (int i10 = 1; i10 < i2; i10++) {
                int i11 = iArr[i10];
                iArr[i10 - 1] = i9 | (i11 << (32 - i6));
                i9 = (i11 >> i6) & i7;
            }
            iArr[i2 - 1] = i9;
        }
        this.f14477a = iArr;
    }

    private static int[] f(int i) {
        return new int[((i + 31) / 32)];
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f14478b != aVar.f14478b || !Arrays.equals(this.f14477a, aVar.f14477a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f14478b * 31) + Arrays.hashCode(this.f14477a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.f14478b);
        for (int i = 0; i < this.f14478b; i++) {
            if ((i & 7) == 0) {
                sb.append(' ');
            }
            sb.append(a(i) ? 'X' : '.');
        }
        return sb.toString();
    }

    /* renamed from: e */
    public a clone() {
        return new a((int[]) this.f14477a.clone(), this.f14478b);
    }
}
