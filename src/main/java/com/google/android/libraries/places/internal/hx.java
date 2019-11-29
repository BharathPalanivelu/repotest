package com.google.android.libraries.places.internal;

import java.math.RoundingMode;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class hx {

    /* renamed from: a  reason: collision with root package name */
    public final char[] f6737a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6738b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6739c;

    /* renamed from: d  reason: collision with root package name */
    public final int f6740d;

    /* renamed from: e  reason: collision with root package name */
    public final int f6741e;

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f6742f;

    /* renamed from: g  reason: collision with root package name */
    private final String f6743g;

    hx(String str, char[] cArr) {
        this.f6743g = (String) go.a(str);
        this.f6737a = (char[]) go.a(cArr);
        try {
            this.f6739c = jq.a(cArr.length, RoundingMode.UNNECESSARY);
            int min = Math.min(8, Integer.lowestOneBit(this.f6739c));
            try {
                this.f6740d = 8 / min;
                this.f6741e = this.f6739c / min;
                this.f6738b = cArr.length - 1;
                byte[] bArr = new byte[128];
                Arrays.fill(bArr, (byte) -1);
                for (int i = 0; i < cArr.length; i++) {
                    char c2 = cArr[i];
                    go.a(c2 < 128, "Non-ASCII character: %s", c2);
                    go.a(bArr[c2] == -1, "Duplicate character: %s", c2);
                    bArr[c2] = (byte) i;
                }
                this.f6742f = bArr;
                for (int i2 = 0; i2 < this.f6741e; i2++) {
                    jq.a(i2 << 3, this.f6739c, RoundingMode.CEILING);
                }
            } catch (ArithmeticException e2) {
                String str2 = new String(cArr);
                throw new IllegalArgumentException(str2.length() != 0 ? "Illegal alphabet ".concat(str2) : new String("Illegal alphabet "), e2);
            }
        } catch (ArithmeticException e3) {
            int length = cArr.length;
            StringBuilder sb = new StringBuilder(35);
            sb.append("Illegal alphabet length ");
            sb.append(length);
            throw new IllegalArgumentException(sb.toString(), e3);
        }
    }

    public final String toString() {
        return this.f6743g;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof hx) {
            return Arrays.equals(this.f6737a, ((hx) obj).f6737a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f6737a);
    }
}
