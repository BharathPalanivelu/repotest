package com.google.zxing.e;

import com.google.zxing.c.b;
import com.google.zxing.e.a.e;
import com.google.zxing.e.a.i;
import com.google.zxing.e.b.c;
import com.google.zxing.g;
import com.google.zxing.j;
import com.google.zxing.m;
import com.google.zxing.q;
import com.google.zxing.u;
import com.google.zxing.w;
import com.google.zxing.x;
import com.google.zxing.y;
import java.util.List;
import java.util.Map;

public class a implements u {

    /* renamed from: a  reason: collision with root package name */
    private static final y[] f14640a = new y[0];

    /* renamed from: b  reason: collision with root package name */
    private final e f14641b = new e();

    public void a() {
    }

    public final w a(com.google.zxing.e eVar, Map<j, ?> map) throws q, g, m {
        y[] yVarArr;
        com.google.zxing.c.e eVar2;
        if (map == null || !map.containsKey(j.PURE_BARCODE)) {
            com.google.zxing.c.g a2 = new c(eVar.c()).a(map);
            com.google.zxing.c.e a3 = this.f14641b.a(a2.a(), map);
            yVarArr = a2.b();
            eVar2 = a3;
        } else {
            eVar2 = this.f14641b.a(a(eVar.c()), map);
            yVarArr = f14640a;
        }
        if (eVar2.e() instanceof i) {
            ((i) eVar2.e()).a(yVarArr);
        }
        w wVar = new w(eVar2.b(), eVar2.a(), yVarArr, com.google.zxing.c.QR_CODE);
        List<byte[]> c2 = eVar2.c();
        if (c2 != null) {
            wVar.a(x.BYTE_SEGMENTS, c2);
        }
        String d2 = eVar2.d();
        if (d2 != null) {
            wVar.a(x.ERROR_CORRECTION_LEVEL, d2);
        }
        if (eVar2.f()) {
            wVar.a(x.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(eVar2.h()));
            wVar.a(x.STRUCTURED_APPEND_PARITY, Integer.valueOf(eVar2.g()));
        }
        return wVar;
    }

    private static b a(b bVar) throws q {
        int[] a2 = bVar.a();
        int[] b2 = bVar.b();
        if (a2 == null || b2 == null) {
            throw q.a();
        }
        float a3 = a(a2, bVar);
        int i = a2[1];
        int i2 = b2[1];
        int i3 = a2[0];
        int i4 = b2[0];
        if (i3 >= i4 || i >= i2) {
            throw q.a();
        }
        int i5 = i2 - i;
        if (i5 != i4 - i3) {
            i4 = i3 + i5;
        }
        int round = Math.round(((float) ((i4 - i3) + 1)) / a3);
        int round2 = Math.round(((float) (i5 + 1)) / a3);
        if (round <= 0 || round2 <= 0) {
            throw q.a();
        } else if (round2 == round) {
            int i6 = (int) (a3 / 2.0f);
            int i7 = i + i6;
            int i8 = i3 + i6;
            int i9 = (((int) (((float) (round - 1)) * a3)) + i8) - i4;
            if (i9 > 0) {
                if (i9 <= i6) {
                    i8 -= i9;
                } else {
                    throw q.a();
                }
            }
            int i10 = (((int) (((float) (round2 - 1)) * a3)) + i7) - i2;
            if (i10 > 0) {
                if (i10 <= i6) {
                    i7 -= i10;
                } else {
                    throw q.a();
                }
            }
            b bVar2 = new b(round, round2);
            for (int i11 = 0; i11 < round2; i11++) {
                int i12 = ((int) (((float) i11) * a3)) + i7;
                for (int i13 = 0; i13 < round; i13++) {
                    if (bVar.a(((int) (((float) i13) * a3)) + i8, i12)) {
                        bVar2.b(i13, i11);
                    }
                }
            }
            return bVar2;
        } else {
            throw q.a();
        }
    }

    private static float a(int[] iArr, b bVar) throws q {
        int d2 = bVar.d();
        int c2 = bVar.c();
        int i = iArr[0];
        boolean z = true;
        int i2 = iArr[1];
        int i3 = 0;
        while (i < c2 && i2 < d2) {
            if (z != bVar.a(i, i2)) {
                i3++;
                if (i3 == 5) {
                    break;
                }
                z = !z;
            }
            i++;
            i2++;
        }
        if (i != c2 && i2 != d2) {
            return ((float) (i - iArr[0])) / 7.0f;
        }
        throw q.a();
    }
}
