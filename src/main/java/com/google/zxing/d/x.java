package com.google.zxing.d;

import com.google.zxing.c;
import com.google.zxing.c.a;
import com.google.zxing.g;
import com.google.zxing.j;
import com.google.zxing.m;
import com.google.zxing.q;
import com.google.zxing.v;
import com.google.zxing.w;
import com.google.zxing.y;
import com.google.zxing.z;
import java.util.Arrays;
import java.util.Map;

public abstract class x extends q {

    /* renamed from: b  reason: collision with root package name */
    static final int[] f14628b = {1, 1, 1};

    /* renamed from: c  reason: collision with root package name */
    static final int[] f14629c = {1, 1, 1, 1, 1};

    /* renamed from: d  reason: collision with root package name */
    static final int[][] f14630d = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};

    /* renamed from: e  reason: collision with root package name */
    static final int[][] f14631e = new int[20][];

    /* renamed from: a  reason: collision with root package name */
    private final StringBuilder f14632a = new StringBuilder(20);

    /* renamed from: f  reason: collision with root package name */
    private final w f14633f = new w();

    /* renamed from: g  reason: collision with root package name */
    private final l f14634g = new l();

    /* access modifiers changed from: protected */
    public abstract int a(a aVar, int[] iArr, StringBuilder sb) throws q;

    /* access modifiers changed from: package-private */
    public abstract c b();

    static {
        System.arraycopy(f14630d, 0, f14631e, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr = f14630d[i - 10];
            int[] iArr2 = new int[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr2[i2] = iArr[(iArr.length - i2) - 1];
            }
            f14631e[i] = iArr2;
        }
    }

    protected x() {
    }

    static int[] a(a aVar) throws q {
        int[] iArr = new int[f14628b.length];
        int[] iArr2 = null;
        boolean z = false;
        int i = 0;
        while (!z) {
            Arrays.fill(iArr, 0, f14628b.length, 0);
            iArr2 = a(aVar, i, false, f14628b, iArr);
            int i2 = iArr2[0];
            int i3 = iArr2[1];
            int i4 = i2 - (i3 - i2);
            if (i4 >= 0) {
                z = aVar.a(i4, i2, false);
            }
            i = i3;
        }
        return iArr2;
    }

    public w a(int i, a aVar, Map<j, ?> map) throws q, g, m {
        return a(i, aVar, a(aVar), map);
    }

    public w a(int i, a aVar, int[] iArr, Map<j, ?> map) throws q, g, m {
        int i2;
        int[] iArr2 = null;
        z zVar = map == null ? null : (z) map.get(j.NEED_RESULT_POINT_CALLBACK);
        boolean z = true;
        if (zVar != null) {
            zVar.a(new y(((float) (iArr[0] + iArr[1])) / 2.0f, (float) i));
        }
        StringBuilder sb = this.f14632a;
        sb.setLength(0);
        int a2 = a(aVar, iArr, sb);
        if (zVar != null) {
            zVar.a(new y((float) a2, (float) i));
        }
        int[] a3 = a(aVar, a2);
        if (zVar != null) {
            zVar.a(new y(((float) (a3[0] + a3[1])) / 2.0f, (float) i));
        }
        int i3 = a3[1];
        int i4 = (i3 - a3[0]) + i3;
        if (i4 >= aVar.a() || !aVar.a(i3, i4, false)) {
            throw q.a();
        }
        String sb2 = sb.toString();
        if (sb2.length() < 8) {
            throw m.a();
        } else if (a(sb2)) {
            c b2 = b();
            float f2 = (float) i;
            w wVar = new w(sb2, (byte[]) null, new y[]{new y(((float) (iArr[1] + iArr[0])) / 2.0f, f2), new y(((float) (a3[1] + a3[0])) / 2.0f, f2)}, b2);
            try {
                w a4 = this.f14633f.a(i, aVar, a3[1]);
                wVar.a(com.google.zxing.x.UPC_EAN_EXTENSION, a4.a());
                wVar.a(a4.e());
                wVar.a(a4.c());
                i2 = a4.a().length();
            } catch (v unused) {
                i2 = 0;
            }
            if (map != null) {
                iArr2 = (int[]) map.get(j.ALLOWED_EAN_EXTENSIONS);
            }
            if (iArr2 != null) {
                int length = iArr2.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        z = false;
                        break;
                    } else if (i2 == iArr2[i5]) {
                        break;
                    } else {
                        i5++;
                    }
                }
                if (!z) {
                    throw q.a();
                }
            }
            if (b2 == c.EAN_13 || b2 == c.UPC_A) {
                String a5 = this.f14634g.a(sb2);
                if (a5 != null) {
                    wVar.a(com.google.zxing.x.POSSIBLE_COUNTRY, a5);
                }
            }
            return wVar;
        } else {
            throw g.a();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str) throws m {
        return a((CharSequence) str);
    }

    static boolean a(CharSequence charSequence) throws m {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        for (int i2 = length - 2; i2 >= 0; i2 -= 2) {
            int charAt = charSequence.charAt(i2) - '0';
            if (charAt < 0 || charAt > 9) {
                throw m.a();
            }
            i += charAt;
        }
        int i3 = i * 3;
        for (int i4 = length - 1; i4 >= 0; i4 -= 2) {
            int charAt2 = charSequence.charAt(i4) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw m.a();
            }
            i3 += charAt2;
        }
        if (i3 % 10 == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int[] a(a aVar, int i) throws q {
        return a(aVar, i, false, f14628b);
    }

    static int[] a(a aVar, int i, boolean z, int[] iArr) throws q {
        return a(aVar, i, z, iArr, new int[iArr.length]);
    }

    private static int[] a(a aVar, int i, boolean z, int[] iArr, int[] iArr2) throws q {
        int length = iArr.length;
        int a2 = aVar.a();
        int d2 = z ? aVar.d(i) : aVar.c(i);
        int i2 = d2;
        int i3 = 0;
        while (d2 < a2) {
            boolean z2 = true;
            if (aVar.a(d2) ^ z) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                int i4 = length - 1;
                if (i3 != i4) {
                    i3++;
                } else if (a(iArr2, iArr, 0.7f) < 0.48f) {
                    return new int[]{i2, d2};
                } else {
                    i2 += iArr2[0] + iArr2[1];
                    int i5 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i4] = 0;
                    i3--;
                }
                iArr2[i3] = 1;
                if (z) {
                    z2 = false;
                }
                z = z2;
            }
            d2++;
        }
        throw q.a();
    }

    static int a(a aVar, int[] iArr, int i, int[][] iArr2) throws q {
        a(aVar, i, iArr);
        int length = iArr2.length;
        float f2 = 0.48f;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float a2 = a(iArr, iArr2[i3], 0.7f);
            if (a2 < f2) {
                i2 = i3;
                f2 = a2;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw q.a();
    }
}
