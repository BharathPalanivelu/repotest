package com.google.zxing.d;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.zxing.c.a;
import com.google.zxing.e;
import com.google.zxing.g;
import com.google.zxing.j;
import com.google.zxing.m;
import com.google.zxing.u;
import com.google.zxing.v;
import com.google.zxing.w;
import com.google.zxing.x;
import com.google.zxing.y;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public abstract class q implements u {
    public abstract w a(int i, a aVar, Map<j, ?> map) throws com.google.zxing.q, g, m;

    public void a() {
    }

    public w a(e eVar, Map<j, ?> map) throws com.google.zxing.q, m {
        try {
            return b(eVar, map);
        } catch (com.google.zxing.q e2) {
            if (!(map != null && map.containsKey(j.TRY_HARDER)) || !eVar.d()) {
                throw e2;
            }
            e e3 = eVar.e();
            w b2 = b(e3, map);
            Map<x, Object> e4 = b2.e();
            int i = 270;
            if (e4 != null && e4.containsKey(x.ORIENTATION)) {
                i = (((Integer) e4.get(x.ORIENTATION)).intValue() + 270) % 360;
            }
            b2.a(x.ORIENTATION, Integer.valueOf(i));
            y[] c2 = b2.c();
            if (c2 != null) {
                int b3 = e3.b();
                for (int i2 = 0; i2 < c2.length; i2++) {
                    c2[i2] = new y((((float) b3) - c2[i2].b()) - 1.0f, c2[i2].a());
                }
            }
            return b2;
        }
    }

    private w b(e eVar, Map<j, ?> map) throws com.google.zxing.q {
        int i;
        int i2;
        Map<j, ?> map2 = map;
        int a2 = eVar.a();
        int b2 = eVar.b();
        a aVar = new a(a2);
        int i3 = b2 >> 1;
        char c2 = 0;
        int i4 = 1;
        boolean z = map2 != null && map2.containsKey(j.TRY_HARDER);
        int max = Math.max(1, b2 >> (z ? 8 : 5));
        int i5 = z ? b2 : 15;
        Map<j, ?> map3 = map2;
        int i6 = 0;
        while (i6 < i5) {
            int i7 = i6 + 1;
            int i8 = i7 / 2;
            if (!((i6 & 1) == 0)) {
                i8 = -i8;
            }
            int i9 = (i8 * max) + i3;
            if (i9 < 0 || i9 >= b2) {
                break;
            }
            try {
                aVar = eVar.a(i9, aVar);
                EnumMap enumMap = map3;
                int i10 = 0;
                while (i10 < 2) {
                    if (i10 == i4) {
                        aVar.d();
                        if (enumMap != null && enumMap.containsKey(j.NEED_RESULT_POINT_CALLBACK)) {
                            EnumMap enumMap2 = new EnumMap(j.class);
                            enumMap2.putAll(enumMap);
                            enumMap2.remove(j.NEED_RESULT_POINT_CALLBACK);
                            enumMap = enumMap2;
                        }
                    }
                    try {
                        w a3 = a(i9, aVar, enumMap);
                        if (i10 == i4) {
                            a3.a(x.ORIENTATION, 180);
                            y[] c3 = a3.c();
                            if (c3 != null) {
                                float f2 = (float) a2;
                                i2 = a2;
                                try {
                                    c3[0] = new y((f2 - c3[c2].a()) - 1.0f, c3[c2].b());
                                    try {
                                        c3[1] = new y((f2 - c3[1].a()) - 1.0f, c3[1].b());
                                    } catch (v unused) {
                                        continue;
                                    }
                                } catch (v unused2) {
                                    i10++;
                                    e eVar2 = eVar;
                                    a2 = i2;
                                    c2 = 0;
                                    i4 = 1;
                                }
                            }
                        }
                        return a3;
                    } catch (v unused3) {
                        i2 = a2;
                        i10++;
                        e eVar22 = eVar;
                        a2 = i2;
                        c2 = 0;
                        i4 = 1;
                    }
                }
                i = a2;
                map3 = enumMap;
            } catch (com.google.zxing.q unused4) {
                i = a2;
            }
            i6 = i7;
            a2 = i;
            c2 = 0;
            i4 = 1;
        }
        throw com.google.zxing.q.a();
    }

    protected static void a(a aVar, int i, int[] iArr) throws com.google.zxing.q {
        int length = iArr.length;
        Arrays.fill(iArr, 0, length, 0);
        int a2 = aVar.a();
        if (i < a2) {
            boolean z = !aVar.a(i);
            int i2 = 0;
            while (i < a2) {
                if (aVar.a(i) ^ z) {
                    iArr[i2] = iArr[i2] + 1;
                } else {
                    i2++;
                    if (i2 == length) {
                        break;
                    }
                    iArr[i2] = 1;
                    z = !z;
                }
                i++;
            }
            if (i2 == length) {
                return;
            }
            if (i2 != length - 1 || i != a2) {
                throw com.google.zxing.q.a();
            }
            return;
        }
        throw com.google.zxing.q.a();
    }

    protected static void b(a aVar, int i, int[] iArr) throws com.google.zxing.q {
        int length = iArr.length;
        boolean a2 = aVar.a(i);
        while (i > 0 && length >= 0) {
            i--;
            if (aVar.a(i) != a2) {
                length--;
                a2 = !a2;
            }
        }
        if (length < 0) {
            a(aVar, i + 1, iArr);
            return;
        }
        throw com.google.zxing.q.a();
    }

    protected static float a(int[] iArr, int[] iArr2, float f2) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f3 = (float) i;
        float f4 = f3 / ((float) i2);
        float f5 = f2 * f4;
        float f6 = BitmapDescriptorFactory.HUE_RED;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            float f7 = ((float) iArr2[i4]) * f4;
            float f8 = (float) i5;
            float f9 = f8 > f7 ? f8 - f7 : f7 - f8;
            if (f9 > f5) {
                return Float.POSITIVE_INFINITY;
            }
            f6 += f9;
        }
        return f6 / f3;
    }
}
