package com.google.zxing.d;

import cn.tongdun.android.BuildConfig;
import com.facebook.imageutils.JfifUtil;
import com.google.zxing.c;
import com.google.zxing.c.a;
import com.google.zxing.g;
import com.google.zxing.j;
import com.google.zxing.m;
import com.google.zxing.q;
import com.google.zxing.w;
import com.google.zxing.y;
import java.util.Arrays;
import java.util.Map;

public final class e extends q {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f14592a = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, BuildConfig.VERSION_CODE, 19, TiffUtil.TIFF_TAG_ORIENTATION, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, JfifUtil.MARKER_RST0, 133, 388, 196, 148, 168, 162, 138, 42};

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f14593b = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".toCharArray();

    /* renamed from: c  reason: collision with root package name */
    private static final int f14594c = f14592a[39];

    /* renamed from: d  reason: collision with root package name */
    private final boolean f14595d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f14596e;

    /* renamed from: f  reason: collision with root package name */
    private final StringBuilder f14597f;

    /* renamed from: g  reason: collision with root package name */
    private final int[] f14598g;

    public e() {
        this(false);
    }

    public e(boolean z) {
        this(z, false);
    }

    public e(boolean z, boolean z2) {
        this.f14595d = z;
        this.f14596e = z2;
        this.f14597f = new StringBuilder(20);
        this.f14598g = new int[9];
    }

    public w a(int i, a aVar, Map<j, ?> map) throws q, g, m {
        String str;
        int[] iArr = this.f14598g;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f14597f;
        sb.setLength(0);
        int[] a2 = a(aVar, iArr);
        int c2 = aVar.c(a2[1]);
        int a3 = aVar.a();
        while (true) {
            a(aVar, c2, iArr);
            int a4 = a(iArr);
            if (a4 >= 0) {
                char a5 = a(a4);
                sb.append(a5);
                int i2 = c2;
                for (int i3 : iArr) {
                    i2 += i3;
                }
                int c3 = aVar.c(i2);
                if (a5 == '*') {
                    sb.setLength(sb.length() - 1);
                    int i4 = 0;
                    for (int i5 : iArr) {
                        i4 += i5;
                    }
                    int i6 = (c3 - c2) - i4;
                    if (c3 == a3 || i6 * 2 >= i4) {
                        if (this.f14595d) {
                            int length = sb.length() - 1;
                            int i7 = 0;
                            for (int i8 = 0; i8 < length; i8++) {
                                i7 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(this.f14597f.charAt(i8));
                            }
                            if (sb.charAt(length) == f14593b[i7 % 43]) {
                                sb.setLength(length);
                            } else {
                                throw g.a();
                            }
                        }
                        if (sb.length() != 0) {
                            if (this.f14596e) {
                                str = a((CharSequence) sb);
                            } else {
                                str = sb.toString();
                            }
                            float f2 = (float) i;
                            return new w(str, (byte[]) null, new y[]{new y(((float) (a2[1] + a2[0])) / 2.0f, f2), new y(((float) c2) + (((float) i4) / 2.0f), f2)}, c.CODE_39);
                        }
                        throw q.a();
                    }
                    throw q.a();
                }
                c2 = c3;
            } else {
                throw q.a();
            }
        }
    }

    private static int[] a(a aVar, int[] iArr) throws q {
        int a2 = aVar.a();
        int c2 = aVar.c(0);
        int length = iArr.length;
        int i = c2;
        boolean z = false;
        int i2 = 0;
        while (c2 < a2) {
            if (aVar.a(c2) ^ z) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                int i3 = length - 1;
                if (i2 != i3) {
                    i2++;
                } else if (a(iArr) != f14594c || !aVar.a(Math.max(0, i - ((c2 - i) / 2)), i, false)) {
                    i += iArr[0] + iArr[1];
                    int i4 = length - 2;
                    System.arraycopy(iArr, 2, iArr, 0, i4);
                    iArr[i4] = 0;
                    iArr[i3] = 0;
                    i2--;
                } else {
                    return new int[]{i, c2};
                }
                iArr[i2] = 1;
                z = !z;
            }
            c2++;
        }
        throw q.a();
    }

    private static int a(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = Integer.MAX_VALUE;
            for (int i3 : iArr) {
                if (i3 < i2 && i3 > i) {
                    i2 = i3;
                }
            }
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = iArr[i7];
                if (i8 > i2) {
                    i5 |= 1 << ((length - 1) - i7);
                    i4++;
                    i6 += i8;
                }
            }
            if (i4 == 3) {
                for (int i9 = 0; i9 < length && i4 > 0; i9++) {
                    int i10 = iArr[i9];
                    if (i10 > i2) {
                        i4--;
                        if (i10 * 2 >= i6) {
                            return -1;
                        }
                    }
                }
                return i5;
            } else if (i4 <= 3) {
                return -1;
            } else {
                i = i2;
            }
        }
    }

    private static char a(int i) throws q {
        int i2 = 0;
        while (true) {
            int[] iArr = f14592a;
            if (i2 >= iArr.length) {
                throw q.a();
            } else if (iArr[i2] == i) {
                return f14593b[i2];
            } else {
                i2++;
            }
        }
    }

    private static String a(CharSequence charSequence) throws m {
        char c2;
        int i;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i2 = 0;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt == '+' || charAt == '$' || charAt == '%' || charAt == '/') {
                i2++;
                char charAt2 = charSequence.charAt(i2);
                if (charAt != '$') {
                    if (charAt != '%') {
                        if (charAt != '+') {
                            if (charAt != '/') {
                                c2 = 0;
                            } else if (charAt2 >= 'A' && charAt2 <= 'O') {
                                i = charAt2 - ' ';
                            } else if (charAt2 == 'Z') {
                                c2 = ':';
                            } else {
                                throw m.a();
                            }
                            sb.append(c2);
                        } else if (charAt2 < 'A' || charAt2 > 'Z') {
                            throw m.a();
                        } else {
                            i = charAt2 + ' ';
                        }
                    } else if (charAt2 >= 'A' && charAt2 <= 'E') {
                        i = charAt2 - '&';
                    } else if (charAt2 < 'F' || charAt2 > 'W') {
                        throw m.a();
                    } else {
                        i = charAt2 - 11;
                    }
                } else if (charAt2 < 'A' || charAt2 > 'Z') {
                    throw m.a();
                } else {
                    i = charAt2 - '@';
                }
                c2 = (char) i;
                sb.append(c2);
            } else {
                sb.append(charAt);
            }
            i2++;
        }
        return sb.toString();
    }
}
