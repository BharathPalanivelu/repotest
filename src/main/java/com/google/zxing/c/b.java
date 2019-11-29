package com.google.zxing.c;

import java.util.Arrays;

public final class b implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private final int f14479a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14480b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14481c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f14482d;

    public b(int i) {
        this(i, i);
    }

    public b(int i, int i2) {
        if (i < 1 || i2 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f14479a = i;
        this.f14480b = i2;
        this.f14481c = (i + 31) / 32;
        this.f14482d = new int[(this.f14481c * i2)];
    }

    private b(int i, int i2, int i3, int[] iArr) {
        this.f14479a = i;
        this.f14480b = i2;
        this.f14481c = i3;
        this.f14482d = iArr;
    }

    public boolean a(int i, int i2) {
        return ((this.f14482d[(i2 * this.f14481c) + (i / 32)] >>> (i & 31)) & 1) != 0;
    }

    public void b(int i, int i2) {
        int i3 = (i2 * this.f14481c) + (i / 32);
        int[] iArr = this.f14482d;
        iArr[i3] = (1 << (i & 31)) | iArr[i3];
    }

    public void c(int i, int i2) {
        int i3 = (i2 * this.f14481c) + (i / 32);
        int[] iArr = this.f14482d;
        iArr[i3] = (1 << (i & 31)) ^ iArr[i3];
    }

    public void a(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i4 < 1 || i3 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            int i5 = i3 + i;
            int i6 = i4 + i2;
            if (i6 > this.f14480b || i5 > this.f14479a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i2 < i6) {
                int i7 = this.f14481c * i2;
                for (int i8 = i; i8 < i5; i8++) {
                    int[] iArr = this.f14482d;
                    int i9 = (i8 / 32) + i7;
                    iArr[i9] = iArr[i9] | (1 << (i8 & 31));
                }
                i2++;
            }
        }
    }

    public int[] a() {
        int i = 0;
        while (true) {
            int[] iArr = this.f14482d;
            if (i >= iArr.length || iArr[i] != 0) {
                int[] iArr2 = this.f14482d;
            } else {
                i++;
            }
        }
        int[] iArr22 = this.f14482d;
        if (i == iArr22.length) {
            return null;
        }
        int i2 = this.f14481c;
        int i3 = i / i2;
        int i4 = (i % i2) * 32;
        int i5 = iArr22[i];
        int i6 = 0;
        while ((i5 << (31 - i6)) == 0) {
            i6++;
        }
        return new int[]{i4 + i6, i3};
    }

    public int[] b() {
        int length = this.f14482d.length - 1;
        while (length >= 0 && this.f14482d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i = this.f14481c;
        int i2 = length / i;
        int i3 = (length % i) * 32;
        int i4 = 31;
        while ((this.f14482d[length] >>> i4) == 0) {
            i4--;
        }
        return new int[]{i3 + i4, i2};
    }

    public int c() {
        return this.f14479a;
    }

    public int d() {
        return this.f14480b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f14479a == bVar.f14479a && this.f14480b == bVar.f14480b && this.f14481c == bVar.f14481c && Arrays.equals(this.f14482d, bVar.f14482d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.f14479a;
        return (((((((i * 31) + i) * 31) + this.f14480b) * 31) + this.f14481c) * 31) + Arrays.hashCode(this.f14482d);
    }

    public String toString() {
        return a("X ", "  ");
    }

    public String a(String str, String str2) {
        return a(str, str2, "\n");
    }

    @Deprecated
    public String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.f14480b * (this.f14479a + 1));
        for (int i = 0; i < this.f14480b; i++) {
            for (int i2 = 0; i2 < this.f14479a; i2++) {
                sb.append(a(i2, i) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    /* renamed from: e */
    public b clone() {
        return new b(this.f14479a, this.f14480b, this.f14481c, (int[]) this.f14482d.clone());
    }
}
