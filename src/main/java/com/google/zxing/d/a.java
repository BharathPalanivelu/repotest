package com.google.zxing.d;

import com.google.zxing.c;
import com.google.zxing.j;
import com.google.zxing.q;
import com.google.zxing.w;
import com.google.zxing.y;
import java.util.Arrays;
import java.util.Map;

public final class a extends q {

    /* renamed from: a  reason: collision with root package name */
    static final char[] f14524a = "0123456789-$:/.+ABCD".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    static final int[] f14525b = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f14526c = {'A', 'B', 'C', 'D'};

    /* renamed from: d  reason: collision with root package name */
    private final StringBuilder f14527d = new StringBuilder(20);

    /* renamed from: e  reason: collision with root package name */
    private int[] f14528e = new int[80];

    /* renamed from: f  reason: collision with root package name */
    private int f14529f = 0;

    public w a(int i, com.google.zxing.c.a aVar, Map<j, ?> map) throws q {
        Arrays.fill(this.f14528e, 0);
        a(aVar);
        int b2 = b();
        this.f14527d.setLength(0);
        int i2 = b2;
        do {
            int c2 = c(i2);
            if (c2 != -1) {
                this.f14527d.append((char) c2);
                i2 += 8;
                if (this.f14527d.length() > 1 && a(f14526c, f14524a[c2])) {
                    break;
                }
            } else {
                throw q.a();
            }
        } while (i2 < this.f14529f);
        int i3 = i2 - 1;
        int i4 = this.f14528e[i3];
        int i5 = 0;
        for (int i6 = -8; i6 < -1; i6++) {
            i5 += this.f14528e[i2 + i6];
        }
        if (i2 >= this.f14529f || i4 >= i5 / 2) {
            a(b2);
            for (int i7 = 0; i7 < this.f14527d.length(); i7++) {
                StringBuilder sb = this.f14527d;
                sb.setCharAt(i7, f14524a[sb.charAt(i7)]);
            }
            if (a(f14526c, this.f14527d.charAt(0))) {
                StringBuilder sb2 = this.f14527d;
                if (!a(f14526c, sb2.charAt(sb2.length() - 1))) {
                    throw q.a();
                } else if (this.f14527d.length() > 3) {
                    if (map == null || !map.containsKey(j.RETURN_CODABAR_START_END)) {
                        StringBuilder sb3 = this.f14527d;
                        sb3.deleteCharAt(sb3.length() - 1);
                        this.f14527d.deleteCharAt(0);
                    }
                    int i8 = 0;
                    for (int i9 = 0; i9 < b2; i9++) {
                        i8 += this.f14528e[i9];
                    }
                    float f2 = (float) i8;
                    while (b2 < i3) {
                        i8 += this.f14528e[b2];
                        b2++;
                    }
                    float f3 = (float) i;
                    return new w(this.f14527d.toString(), (byte[]) null, new y[]{new y(f2, f3), new y((float) i8, f3)}, c.CODABAR);
                } else {
                    throw q.a();
                }
            } else {
                throw q.a();
            }
        } else {
            throw q.a();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i) throws q {
        int[] iArr = {0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0};
        int length = this.f14527d.length() - 1;
        int i2 = 0;
        int i3 = i;
        int i4 = 0;
        while (true) {
            int i5 = f14525b[this.f14527d.charAt(i4)];
            for (int i6 = 6; i6 >= 0; i6--) {
                int i7 = (i6 & 1) + ((i5 & 1) * 2);
                iArr[i7] = iArr[i7] + this.f14528e[i3 + i6];
                iArr2[i7] = iArr2[i7] + 1;
                i5 >>= 1;
            }
            if (i4 >= length) {
                break;
            }
            i3 += 8;
            i4++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i8 = 0; i8 < 2; i8++) {
            fArr2[i8] = 0.0f;
            int i9 = i8 + 2;
            fArr2[i9] = ((((float) iArr[i8]) / ((float) iArr2[i8])) + (((float) iArr[i9]) / ((float) iArr2[i9]))) / 2.0f;
            fArr[i8] = fArr2[i9];
            fArr[i9] = ((((float) iArr[i9]) * 2.0f) + 1.5f) / ((float) iArr2[i9]);
        }
        loop3:
        while (true) {
            int i10 = f14525b[this.f14527d.charAt(i2)];
            int i11 = 6;
            while (i11 >= 0) {
                int i12 = (i11 & 1) + ((i10 & 1) * 2);
                float f2 = (float) this.f14528e[i + i11];
                if (f2 >= fArr2[i12] && f2 <= fArr[i12]) {
                    i10 >>= 1;
                    i11--;
                }
            }
            if (i2 < length) {
                i += 8;
                i2++;
            } else {
                return;
            }
        }
        throw q.a();
    }

    private void a(com.google.zxing.c.a aVar) throws q {
        int i = 0;
        this.f14529f = 0;
        int d2 = aVar.d(0);
        int a2 = aVar.a();
        if (d2 < a2) {
            boolean z = true;
            while (d2 < a2) {
                if (aVar.a(d2) ^ z) {
                    i++;
                } else {
                    b(i);
                    z = !z;
                    i = 1;
                }
                d2++;
            }
            b(i);
            return;
        }
        throw q.a();
    }

    private void b(int i) {
        int[] iArr = this.f14528e;
        int i2 = this.f14529f;
        iArr[i2] = i;
        this.f14529f = i2 + 1;
        int i3 = this.f14529f;
        if (i3 >= iArr.length) {
            int[] iArr2 = new int[(i3 * 2)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f14528e = iArr2;
        }
    }

    private int b() throws q {
        for (int i = 1; i < this.f14529f; i += 2) {
            int c2 = c(i);
            if (c2 != -1 && a(f14526c, f14524a[c2])) {
                int i2 = 0;
                for (int i3 = i; i3 < i + 7; i3++) {
                    i2 += this.f14528e[i3];
                }
                if (i == 1 || this.f14528e[i - 1] >= i2 / 2) {
                    return i;
                }
            }
        }
        throw q.a();
    }

    static boolean a(char[] cArr, char c2) {
        if (cArr != null) {
            for (char c3 : cArr) {
                if (c3 == c2) {
                    return true;
                }
            }
        }
        return false;
    }

    private int c(int i) {
        int i2 = i + 7;
        if (i2 >= this.f14529f) {
            return -1;
        }
        int[] iArr = this.f14528e;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        int i5 = Integer.MAX_VALUE;
        int i6 = 0;
        for (int i7 = i; i7 < i2; i7 += 2) {
            int i8 = iArr[i7];
            if (i8 < i5) {
                i5 = i8;
            }
            if (i8 > i6) {
                i6 = i8;
            }
        }
        int i9 = (i5 + i6) / 2;
        int i10 = 0;
        for (int i11 = i + 1; i11 < i2; i11 += 2) {
            int i12 = iArr[i11];
            if (i12 < i3) {
                i3 = i12;
            }
            if (i12 > i10) {
                i10 = i12;
            }
        }
        int i13 = (i3 + i10) / 2;
        int i14 = 128;
        int i15 = 0;
        for (int i16 = 0; i16 < 7; i16++) {
            i14 >>= 1;
            if (iArr[i + i16] > ((i16 & 1) == 0 ? i9 : i13)) {
                i15 |= i14;
            }
        }
        while (true) {
            int[] iArr2 = f14525b;
            if (i4 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i4] == i15) {
                return i4;
            }
            i4++;
        }
    }
}
