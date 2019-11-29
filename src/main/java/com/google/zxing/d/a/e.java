package com.google.zxing.d.a;

import com.google.zxing.c;
import com.google.zxing.c.a;
import com.google.zxing.j;
import com.google.zxing.q;
import com.google.zxing.w;
import com.google.zxing.y;
import com.google.zxing.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class e extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f14580a = {1, 10, 34, 70, 126};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f14581b = {4, 20, 48, 81};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f14582c = {0, 161, 961, 2015, 2715};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f14583d = {0, 336, 1036, 1516};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f14584e = {8, 6, 4, 3, 1};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f14585f = {2, 4, 6, 8};

    /* renamed from: g  reason: collision with root package name */
    private static final int[][] f14586g = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    private final List<d> h = new ArrayList();
    private final List<d> i = new ArrayList();

    public w a(int i2, a aVar, Map<j, ?> map) throws q {
        a((Collection<d>) this.h, a(aVar, false, i2, map));
        aVar.d();
        a((Collection<d>) this.i, a(aVar, true, i2, map));
        aVar.d();
        int size = this.h.size();
        for (int i3 = 0; i3 < size; i3++) {
            d dVar = this.h.get(i3);
            if (dVar.d() > 1) {
                int size2 = this.i.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    d dVar2 = this.i.get(i4);
                    if (dVar2.d() > 1 && b(dVar, dVar2)) {
                        return a(dVar, dVar2);
                    }
                }
                continue;
            }
        }
        throw q.a();
    }

    private static void a(Collection<d> collection, d dVar) {
        if (dVar != null) {
            boolean z = false;
            Iterator<d> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d next = it.next();
                if (next.a() == dVar.a()) {
                    next.e();
                    z = true;
                    break;
                }
            }
            if (!z) {
                collection.add(dVar);
            }
        }
    }

    public void a() {
        this.h.clear();
        this.i.clear();
    }

    private static w a(d dVar, d dVar2) {
        String valueOf = String.valueOf((((long) dVar.a()) * 4537077) + ((long) dVar2.a()));
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - valueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(valueOf);
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            int charAt = sb.charAt(i3) - '0';
            if ((i3 & 1) == 0) {
                charAt *= 3;
            }
            i2 += charAt;
        }
        int i4 = 10 - (i2 % 10);
        if (i4 == 10) {
            i4 = 0;
        }
        sb.append(i4);
        y[] c2 = dVar.c().c();
        y[] c3 = dVar2.c().c();
        return new w(String.valueOf(sb.toString()), (byte[]) null, new y[]{c2[0], c2[1], c3[0], c3[1]}, c.RSS_14);
    }

    private static boolean b(d dVar, d dVar2) {
        int b2 = (dVar.b() + (dVar2.b() * 16)) % 79;
        int a2 = (dVar.c().a() * 9) + dVar2.c().a();
        if (a2 > 72) {
            a2--;
        }
        if (a2 > 8) {
            a2--;
        }
        return b2 == a2;
    }

    private d a(a aVar, boolean z, int i2, Map<j, ?> map) {
        z zVar;
        try {
            int[] a2 = a(aVar, 0, z);
            c a3 = a(aVar, i2, z, a2);
            if (map == null) {
                zVar = null;
            } else {
                zVar = (z) map.get(j.NEED_RESULT_POINT_CALLBACK);
            }
            if (zVar != null) {
                float f2 = ((float) (a2[0] + a2[1])) / 2.0f;
                if (z) {
                    f2 = ((float) (aVar.a() - 1)) - f2;
                }
                zVar.a(new y(f2, (float) i2));
            }
            b a4 = a(aVar, a3, true);
            b a5 = a(aVar, a3, false);
            return new d((a4.a() * 1597) + a5.a(), a4.b() + (a5.b() * 4), a3);
        } catch (q unused) {
            return null;
        }
    }

    private b a(a aVar, c cVar, boolean z) throws q {
        a aVar2 = aVar;
        boolean z2 = z;
        int[] c2 = c();
        c2[0] = 0;
        c2[1] = 0;
        c2[2] = 0;
        c2[3] = 0;
        c2[4] = 0;
        c2[5] = 0;
        c2[6] = 0;
        c2[7] = 0;
        if (z2) {
            b(aVar2, cVar.b()[0], c2);
        } else {
            a(aVar2, cVar.b()[1] + 1, c2);
            int i2 = 0;
            for (int length = c2.length - 1; i2 < length; length--) {
                int i3 = c2[i2];
                c2[i2] = c2[length];
                c2[length] = i3;
                i2++;
            }
        }
        int i4 = z2 ? 16 : 15;
        float a2 = ((float) a(c2)) / ((float) i4);
        int[] f2 = f();
        int[] g2 = g();
        float[] d2 = d();
        float[] e2 = e();
        for (int i5 = 0; i5 < c2.length; i5++) {
            float f3 = ((float) c2[i5]) / a2;
            int i6 = (int) (0.5f + f3);
            if (i6 < 1) {
                i6 = 1;
            } else if (i6 > 8) {
                i6 = 8;
            }
            int i7 = i5 / 2;
            if ((i5 & 1) == 0) {
                f2[i7] = i6;
                d2[i7] = f3 - ((float) i6);
            } else {
                g2[i7] = i6;
                e2[i7] = f3 - ((float) i6);
            }
        }
        a(z2, i4);
        int i8 = 0;
        int i9 = 0;
        for (int length2 = f2.length - 1; length2 >= 0; length2--) {
            i8 = (i8 * 9) + f2[length2];
            i9 += f2[length2];
        }
        int i10 = 0;
        int i11 = 0;
        for (int length3 = g2.length - 1; length3 >= 0; length3--) {
            i10 = (i10 * 9) + g2[length3];
            i11 += g2[length3];
        }
        int i12 = i8 + (i10 * 3);
        if (z2) {
            if ((i9 & 1) != 0 || i9 > 12 || i9 < 4) {
                throw q.a();
            }
            int i13 = (12 - i9) / 2;
            int i14 = f14584e[i13];
            return new b((f.a(f2, i14, false) * f14580a[i13]) + f.a(g2, 9 - i14, true) + f14582c[i13], i12);
        } else if ((i11 & 1) != 0 || i11 > 10 || i11 < 4) {
            throw q.a();
        } else {
            int i15 = (10 - i11) / 2;
            int i16 = f14585f[i15];
            return new b((f.a(g2, 9 - i16, false) * f14581b[i15]) + f.a(f2, i16, true) + f14583d[i15], i12);
        }
    }

    private int[] a(a aVar, int i2, boolean z) throws q {
        int[] b2 = b();
        b2[0] = 0;
        b2[1] = 0;
        b2[2] = 0;
        b2[3] = 0;
        int a2 = aVar.a();
        boolean z2 = false;
        while (i2 < a2) {
            z2 = !aVar.a(i2);
            if (z == z2) {
                break;
            }
            i2++;
        }
        int i3 = i2;
        int i4 = 0;
        while (i2 < a2) {
            if (aVar.a(i2) ^ z2) {
                b2[i4] = b2[i4] + 1;
            } else {
                if (i4 != 3) {
                    i4++;
                } else if (b(b2)) {
                    return new int[]{i3, i2};
                } else {
                    i3 += b2[0] + b2[1];
                    b2[0] = b2[2];
                    b2[1] = b2[3];
                    b2[2] = 0;
                    b2[3] = 0;
                    i4--;
                }
                b2[i4] = 1;
                z2 = !z2;
            }
            i2++;
        }
        throw q.a();
    }

    private c a(a aVar, int i2, boolean z, int[] iArr) throws q {
        int i3;
        int i4;
        boolean a2 = aVar.a(iArr[0]);
        int i5 = iArr[0] - 1;
        while (i5 >= 0 && (aVar.a(i5) ^ a2)) {
            i5--;
        }
        int i6 = i5 + 1;
        int[] b2 = b();
        System.arraycopy(b2, 0, b2, 1, b2.length - 1);
        b2[0] = iArr[0] - i6;
        int a3 = a(b2, f14586g);
        int i7 = iArr[1];
        if (z) {
            i3 = (aVar.a() - 1) - i7;
            i4 = (aVar.a() - 1) - i6;
        } else {
            i3 = i7;
            i4 = i6;
        }
        return new c(a3, new int[]{i6, iArr[1]}, i4, i3, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0054, code lost:
        if (r1 < 4) goto L_0x0056;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(boolean r10, int r11) throws com.google.zxing.q {
        /*
            r9 = this;
            int[] r0 = r9.f()
            int r0 = a(r0)
            int[] r1 = r9.g()
            int r1 = a(r1)
            int r2 = r0 + r1
            int r2 = r2 - r11
            r11 = r0 & 1
            r3 = 0
            r4 = 1
            if (r11 != r10) goto L_0x001b
            r11 = 1
            goto L_0x001c
        L_0x001b:
            r11 = 0
        L_0x001c:
            r5 = r1 & 1
            if (r5 != r4) goto L_0x0022
            r5 = 1
            goto L_0x0023
        L_0x0022:
            r5 = 0
        L_0x0023:
            r6 = 4
            if (r10 == 0) goto L_0x0040
            r10 = 12
            if (r0 <= r10) goto L_0x002d
            r7 = 0
            r8 = 1
            goto L_0x0033
        L_0x002d:
            if (r0 >= r6) goto L_0x0031
            r7 = 1
            goto L_0x0032
        L_0x0031:
            r7 = 0
        L_0x0032:
            r8 = 0
        L_0x0033:
            if (r1 <= r10) goto L_0x0038
            r10 = r7
            r7 = r8
            goto L_0x0052
        L_0x0038:
            if (r1 >= r6) goto L_0x003d
            r10 = r7
            r7 = r8
            goto L_0x0056
        L_0x003d:
            r10 = r7
            r7 = r8
            goto L_0x0057
        L_0x0040:
            r10 = 11
            if (r0 <= r10) goto L_0x0047
            r10 = 0
            r7 = 1
            goto L_0x004e
        L_0x0047:
            r10 = 5
            if (r0 >= r10) goto L_0x004c
            r10 = 1
            goto L_0x004d
        L_0x004c:
            r10 = 0
        L_0x004d:
            r7 = 0
        L_0x004e:
            r8 = 10
            if (r1 <= r8) goto L_0x0054
        L_0x0052:
            r6 = 1
            goto L_0x0058
        L_0x0054:
            if (r1 >= r6) goto L_0x0057
        L_0x0056:
            r3 = 1
        L_0x0057:
            r6 = 0
        L_0x0058:
            if (r2 != r4) goto L_0x006e
            if (r11 == 0) goto L_0x0065
            if (r5 != 0) goto L_0x0060
        L_0x005e:
            r7 = 1
            goto L_0x0098
        L_0x0060:
            com.google.zxing.q r10 = com.google.zxing.q.a()
            throw r10
        L_0x0065:
            if (r5 == 0) goto L_0x0069
        L_0x0067:
            r6 = 1
            goto L_0x0098
        L_0x0069:
            com.google.zxing.q r10 = com.google.zxing.q.a()
            throw r10
        L_0x006e:
            r8 = -1
            if (r2 != r8) goto L_0x0085
            if (r11 == 0) goto L_0x007c
            if (r5 != 0) goto L_0x0077
            r10 = 1
            goto L_0x0098
        L_0x0077:
            com.google.zxing.q r10 = com.google.zxing.q.a()
            throw r10
        L_0x007c:
            if (r5 == 0) goto L_0x0080
            r3 = 1
            goto L_0x0098
        L_0x0080:
            com.google.zxing.q r10 = com.google.zxing.q.a()
            throw r10
        L_0x0085:
            if (r2 != 0) goto L_0x00e2
            if (r11 == 0) goto L_0x0096
            if (r5 == 0) goto L_0x0091
            if (r0 >= r1) goto L_0x008f
            r10 = 1
            goto L_0x0067
        L_0x008f:
            r3 = 1
            goto L_0x005e
        L_0x0091:
            com.google.zxing.q r10 = com.google.zxing.q.a()
            throw r10
        L_0x0096:
            if (r5 != 0) goto L_0x00dd
        L_0x0098:
            if (r10 == 0) goto L_0x00ad
            if (r7 != 0) goto L_0x00a8
            int[] r10 = r9.f()
            float[] r11 = r9.d()
            a((int[]) r10, (float[]) r11)
            goto L_0x00ad
        L_0x00a8:
            com.google.zxing.q r10 = com.google.zxing.q.a()
            throw r10
        L_0x00ad:
            if (r7 == 0) goto L_0x00ba
            int[] r10 = r9.f()
            float[] r11 = r9.d()
            b(r10, r11)
        L_0x00ba:
            if (r3 == 0) goto L_0x00cf
            if (r6 != 0) goto L_0x00ca
            int[] r10 = r9.g()
            float[] r11 = r9.d()
            a((int[]) r10, (float[]) r11)
            goto L_0x00cf
        L_0x00ca:
            com.google.zxing.q r10 = com.google.zxing.q.a()
            throw r10
        L_0x00cf:
            if (r6 == 0) goto L_0x00dc
            int[] r10 = r9.g()
            float[] r11 = r9.e()
            b(r10, r11)
        L_0x00dc:
            return
        L_0x00dd:
            com.google.zxing.q r10 = com.google.zxing.q.a()
            throw r10
        L_0x00e2:
            com.google.zxing.q r10 = com.google.zxing.q.a()
            goto L_0x00e8
        L_0x00e7:
            throw r10
        L_0x00e8:
            goto L_0x00e7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.d.a.e.a(boolean, int):void");
    }
}
