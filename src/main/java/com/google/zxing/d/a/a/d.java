package com.google.zxing.d.a.a;

import com.appsflyer.BuildConfig;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.zxing.c;
import com.google.zxing.d.a.a;
import com.google.zxing.d.a.b;
import com.google.zxing.d.a.f;
import com.google.zxing.j;
import com.google.zxing.m;
import com.google.zxing.q;
import com.google.zxing.w;
import com.google.zxing.y;
import com.tencent.ijk.media.player.IjkMediaMeta;
import com.tencent.qalsdk.im_open.http;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class d extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f14566a = {7, 5, 4, 3, 1};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f14567b = {4, 20, 52, 104, http.No_Content};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f14568c = {0, 348, 1388, 2948, 3988};

    /* renamed from: d  reason: collision with root package name */
    private static final int[][] f14569d = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};

    /* renamed from: e  reason: collision with root package name */
    private static final int[][] f14570e = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, BuildConfig.VERSION_CODE, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, 203, 187, 139, http.Partial_Content, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, 210, JfifUtil.MARKER_RST0, 202, 184, 130, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, http.No_Content, FacebookRequestErrorClassification.EC_INVALID_TOKEN}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, JfifUtil.MARKER_SOFn, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};

    /* renamed from: f  reason: collision with root package name */
    private static final int[][] f14571f = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    /* renamed from: g  reason: collision with root package name */
    private final List<b> f14572g = new ArrayList(11);
    private final List<c> h = new ArrayList();
    private final int[] i = new int[2];
    private boolean j = false;

    public w a(int i2, com.google.zxing.c.a aVar, Map<j, ?> map) throws q, m {
        this.f14572g.clear();
        this.j = false;
        try {
            return a(a(i2, aVar));
        } catch (q unused) {
            this.f14572g.clear();
            this.j = true;
            return a(a(i2, aVar));
        }
    }

    public void a() {
        this.f14572g.clear();
        this.h.clear();
    }

    /* access modifiers changed from: package-private */
    public List<b> a(int i2, com.google.zxing.c.a aVar) throws q {
        while (true) {
            try {
                this.f14572g.add(a(aVar, this.f14572g, i2));
            } catch (q e2) {
                if (this.f14572g.isEmpty()) {
                    throw e2;
                } else if (h()) {
                    return this.f14572g;
                } else {
                    boolean z = !this.h.isEmpty();
                    a(i2, false);
                    if (z) {
                        List<b> a2 = a(false);
                        if (a2 != null) {
                            return a2;
                        }
                        List<b> a3 = a(true);
                        if (a3 != null) {
                            return a3;
                        }
                    }
                    throw q.a();
                }
            }
        }
    }

    private List<b> a(boolean z) {
        List<b> list = null;
        if (this.h.size() > 25) {
            this.h.clear();
            return null;
        }
        this.f14572g.clear();
        if (z) {
            Collections.reverse(this.h);
        }
        try {
            list = a((List<c>) new ArrayList(), 0);
        } catch (q unused) {
        }
        if (z) {
            Collections.reverse(this.h);
        }
        return list;
    }

    private List<b> a(List<c> list, int i2) throws q {
        while (i2 < this.h.size()) {
            c cVar = this.h.get(i2);
            this.f14572g.clear();
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.f14572g.addAll(list.get(i3).a());
            }
            this.f14572g.addAll(cVar.a());
            if (b(this.f14572g)) {
                if (h()) {
                    return this.f14572g;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.add(cVar);
                try {
                    return a((List<c>) arrayList, i2 + 1);
                } catch (q unused) {
                }
            }
            i2++;
        }
        throw q.a();
    }

    private static boolean b(List<b> list) {
        boolean z;
        for (int[] iArr : f14571f) {
            if (list.size() <= iArr.length) {
                int i2 = 0;
                while (true) {
                    if (i2 >= list.size()) {
                        z = true;
                        break;
                    } else if (list.get(i2).c().a() != iArr[i2]) {
                        z = false;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(int i2, boolean z) {
        boolean z2 = false;
        int i3 = 0;
        boolean z3 = false;
        while (true) {
            if (i3 >= this.h.size()) {
                break;
            }
            c cVar = this.h.get(i3);
            if (cVar.b() > i2) {
                z2 = cVar.a(this.f14572g);
                break;
            } else {
                z3 = cVar.a(this.f14572g);
                i3++;
            }
        }
        if (!z2 && !z3 && !a((Iterable<b>) this.f14572g, (Iterable<c>) this.h)) {
            this.h.add(i3, new c(this.f14572g, i2, z));
            a(this.f14572g, this.h);
        }
    }

    private static void a(List<b> list, List<c> list2) {
        boolean z;
        Iterator<c> it = list2.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.a().size() != list.size()) {
                Iterator<b> it2 = next.a().iterator();
                while (true) {
                    z = false;
                    boolean z2 = true;
                    if (!it2.hasNext()) {
                        z = true;
                        break;
                    }
                    b next2 = it2.next();
                    Iterator<b> it3 = list.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (next2.equals(it3.next())) {
                                continue;
                                break;
                            }
                        } else {
                            z2 = false;
                            continue;
                            break;
                        }
                    }
                    if (!z2) {
                        break;
                    }
                }
                if (z) {
                    it.remove();
                }
            }
        }
    }

    private static boolean a(Iterable<b> iterable, Iterable<c> iterable2) {
        boolean z;
        boolean z2;
        Iterator<c> it = iterable2.iterator();
        do {
            z = false;
            if (it.hasNext()) {
                c next = it.next();
                Iterator<b> it2 = iterable.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z = true;
                        continue;
                        break;
                    }
                    b next2 = it2.next();
                    Iterator<b> it3 = next.a().iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (next2.equals(it3.next())) {
                                z2 = true;
                                continue;
                                break;
                            }
                        } else {
                            z2 = false;
                            continue;
                            break;
                        }
                    }
                    if (!z2) {
                        continue;
                        break;
                    }
                }
            } else {
                return false;
            }
        } while (!z);
        return true;
    }

    static w a(List<b> list) throws q, m {
        String a2 = com.google.zxing.d.a.a.a.j.a(a.a(list)).a();
        y[] c2 = list.get(0).c().c();
        y[] c3 = list.get(list.size() - 1).c().c();
        return new w(a2, (byte[]) null, new y[]{c2[0], c2[1], c3[0], c3[1]}, c.RSS_EXPANDED);
    }

    private boolean h() {
        b bVar = this.f14572g.get(0);
        b a2 = bVar.a();
        b b2 = bVar.b();
        if (b2 == null) {
            return false;
        }
        int b3 = b2.b();
        int i2 = 2;
        for (int i3 = 1; i3 < this.f14572g.size(); i3++) {
            b bVar2 = this.f14572g.get(i3);
            b3 += bVar2.a().b();
            i2++;
            b b4 = bVar2.b();
            if (b4 != null) {
                b3 += b4.b();
                i2++;
            }
        }
        if (((i2 - 4) * 211) + (b3 % 211) == a2.a()) {
            return true;
        }
        return false;
    }

    private static int a(com.google.zxing.c.a aVar, int i2) {
        if (aVar.a(i2)) {
            return aVar.c(aVar.d(i2));
        }
        return aVar.d(aVar.c(i2));
    }

    /* access modifiers changed from: package-private */
    public b a(com.google.zxing.c.a aVar, List<b> list, int i2) throws q {
        com.google.zxing.d.a.c a2;
        b bVar;
        boolean z = list.size() % 2 == 0;
        if (this.j) {
            z = !z;
        }
        int i3 = -1;
        boolean z2 = true;
        do {
            b(aVar, list, i3);
            a2 = a(aVar, i2, z);
            if (a2 == null) {
                i3 = a(aVar, this.i[0]);
                continue;
            } else {
                z2 = false;
                continue;
            }
        } while (z2);
        b a3 = a(aVar, a2, z, true);
        if (list.isEmpty() || !list.get(list.size() - 1).d()) {
            try {
                bVar = a(aVar, a2, z, false);
            } catch (q unused) {
                bVar = null;
            }
            return new b(a3, bVar, a2, true);
        }
        throw q.a();
    }

    private void b(com.google.zxing.c.a aVar, List<b> list, int i2) throws q {
        int[] b2 = b();
        b2[0] = 0;
        b2[1] = 0;
        b2[2] = 0;
        b2[3] = 0;
        int a2 = aVar.a();
        if (i2 < 0) {
            if (list.isEmpty()) {
                i2 = 0;
            } else {
                i2 = list.get(list.size() - 1).c().b()[1];
            }
        }
        boolean z = list.size() % 2 != 0;
        if (this.j) {
            z = !z;
        }
        boolean z2 = false;
        while (i2 < a2) {
            z2 = !aVar.a(i2);
            if (!z2) {
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
                if (i4 == 3) {
                    if (z) {
                        c(b2);
                    }
                    if (b(b2)) {
                        int[] iArr = this.i;
                        iArr[0] = i3;
                        iArr[1] = i2;
                        return;
                    }
                    if (z) {
                        c(b2);
                    }
                    i3 += b2[0] + b2[1];
                    b2[0] = b2[2];
                    b2[1] = b2[3];
                    b2[2] = 0;
                    b2[3] = 0;
                    i4--;
                } else {
                    i4++;
                }
                b2[i4] = 1;
                z2 = !z2;
            }
            i2++;
        }
        throw q.a();
    }

    private static void c(int[] iArr) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length / 2; i2++) {
            int i3 = iArr[i2];
            int i4 = (length - i2) - 1;
            iArr[i2] = iArr[i4];
            iArr[i4] = i3;
        }
    }

    private com.google.zxing.d.a.c a(com.google.zxing.c.a aVar, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        if (z) {
            int i6 = this.i[0] - 1;
            while (i6 >= 0 && !aVar.a(i6)) {
                i6--;
            }
            int i7 = i6 + 1;
            int[] iArr = this.i;
            i4 = iArr[1];
            i5 = i7;
            i3 = iArr[0] - i7;
        } else {
            int[] iArr2 = this.i;
            int i8 = iArr2[0];
            int d2 = aVar.d(iArr2[1] + 1);
            i3 = d2 - this.i[1];
            i4 = d2;
            i5 = i8;
        }
        int[] b2 = b();
        System.arraycopy(b2, 0, b2, 1, b2.length - 1);
        b2[0] = i3;
        try {
            return new com.google.zxing.d.a.c(a(b2, f14569d), new int[]{i5, i4}, i5, i4, i2);
        } catch (q unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public b a(com.google.zxing.c.a aVar, com.google.zxing.d.a.c cVar, boolean z, boolean z2) throws q {
        com.google.zxing.c.a aVar2 = aVar;
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
            a(aVar2, cVar.b()[1], c2);
            int i2 = 0;
            for (int length = c2.length - 1; i2 < length; length--) {
                int i3 = c2[i2];
                c2[i2] = c2[length];
                c2[length] = i3;
                i2++;
            }
        }
        float a2 = ((float) a(c2)) / ((float) 17);
        float f2 = ((float) (cVar.b()[1] - cVar.b()[0])) / 15.0f;
        if (Math.abs(a2 - f2) / f2 <= 0.3f) {
            int[] f3 = f();
            int[] g2 = g();
            float[] d2 = d();
            float[] e2 = e();
            for (int i4 = 0; i4 < c2.length; i4++) {
                float f4 = (((float) c2[i4]) * 1.0f) / a2;
                int i5 = (int) (0.5f + f4);
                if (i5 < 1) {
                    if (f4 >= 0.3f) {
                        i5 = 1;
                    } else {
                        throw q.a();
                    }
                } else if (i5 > 8) {
                    if (f4 <= 8.7f) {
                        i5 = 8;
                    } else {
                        throw q.a();
                    }
                }
                int i6 = i4 / 2;
                if ((i4 & 1) == 0) {
                    f3[i6] = i5;
                    d2[i6] = f4 - ((float) i5);
                } else {
                    g2[i6] = i5;
                    e2[i6] = f4 - ((float) i5);
                }
            }
            a(17);
            int a3 = (((cVar.a() * 4) + (z ? 0 : 2)) + (z2 ^ true ? 1 : 0)) - 1;
            int i7 = 0;
            int i8 = 0;
            for (int length2 = f3.length - 1; length2 >= 0; length2--) {
                if (a(cVar, z, z2)) {
                    i7 += f3[length2] * f14570e[a3][length2 * 2];
                }
                i8 += f3[length2];
            }
            int i9 = 0;
            for (int length3 = g2.length - 1; length3 >= 0; length3--) {
                if (a(cVar, z, z2)) {
                    i9 += g2[length3] * f14570e[a3][(length3 * 2) + 1];
                }
            }
            int i10 = i7 + i9;
            if ((i8 & 1) != 0 || i8 > 13 || i8 < 4) {
                throw q.a();
            }
            int i11 = (13 - i8) / 2;
            int i12 = f14566a[i11];
            return new b((f.a(f3, i12, true) * f14567b[i11]) + f.a(g2, 9 - i12, false) + f14568c[i11], i10);
        }
        throw q.a();
    }

    private static boolean a(com.google.zxing.d.a.c cVar, boolean z, boolean z2) {
        return cVar.a() != 0 || !z || !z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r11) throws com.google.zxing.q {
        /*
            r10 = this;
            int[] r0 = r10.f()
            int r0 = a(r0)
            int[] r1 = r10.g()
            int r1 = a(r1)
            int r2 = r0 + r1
            int r2 = r2 - r11
            r11 = r0 & 1
            r3 = 0
            r4 = 1
            if (r11 != r4) goto L_0x001b
            r11 = 1
            goto L_0x001c
        L_0x001b:
            r11 = 0
        L_0x001c:
            r5 = r1 & 1
            if (r5 != 0) goto L_0x0022
            r5 = 1
            goto L_0x0023
        L_0x0022:
            r5 = 0
        L_0x0023:
            r6 = 4
            r7 = 13
            if (r0 <= r7) goto L_0x002b
            r8 = 0
            r9 = 1
            goto L_0x0031
        L_0x002b:
            if (r0 >= r6) goto L_0x002f
            r8 = 1
            goto L_0x0030
        L_0x002f:
            r8 = 0
        L_0x0030:
            r9 = 0
        L_0x0031:
            if (r1 <= r7) goto L_0x0035
            r6 = 1
            goto L_0x0039
        L_0x0035:
            if (r1 >= r6) goto L_0x0038
            r3 = 1
        L_0x0038:
            r6 = 0
        L_0x0039:
            if (r2 != r4) goto L_0x004f
            if (r11 == 0) goto L_0x0046
            if (r5 != 0) goto L_0x0041
        L_0x003f:
            r9 = 1
            goto L_0x0079
        L_0x0041:
            com.google.zxing.q r11 = com.google.zxing.q.a()
            throw r11
        L_0x0046:
            if (r5 == 0) goto L_0x004a
            r6 = 1
            goto L_0x0079
        L_0x004a:
            com.google.zxing.q r11 = com.google.zxing.q.a()
            throw r11
        L_0x004f:
            r7 = -1
            if (r2 != r7) goto L_0x0066
            if (r11 == 0) goto L_0x005d
            if (r5 != 0) goto L_0x0058
        L_0x0056:
            r8 = 1
            goto L_0x0079
        L_0x0058:
            com.google.zxing.q r11 = com.google.zxing.q.a()
            throw r11
        L_0x005d:
            if (r5 == 0) goto L_0x0061
            r3 = 1
            goto L_0x0079
        L_0x0061:
            com.google.zxing.q r11 = com.google.zxing.q.a()
            throw r11
        L_0x0066:
            if (r2 != 0) goto L_0x00c3
            if (r11 == 0) goto L_0x0077
            if (r5 == 0) goto L_0x0072
            if (r0 >= r1) goto L_0x0070
            r6 = 1
            goto L_0x0056
        L_0x0070:
            r3 = 1
            goto L_0x003f
        L_0x0072:
            com.google.zxing.q r11 = com.google.zxing.q.a()
            throw r11
        L_0x0077:
            if (r5 != 0) goto L_0x00be
        L_0x0079:
            if (r8 == 0) goto L_0x008e
            if (r9 != 0) goto L_0x0089
            int[] r11 = r10.f()
            float[] r0 = r10.d()
            a((int[]) r11, (float[]) r0)
            goto L_0x008e
        L_0x0089:
            com.google.zxing.q r11 = com.google.zxing.q.a()
            throw r11
        L_0x008e:
            if (r9 == 0) goto L_0x009b
            int[] r11 = r10.f()
            float[] r0 = r10.d()
            b(r11, r0)
        L_0x009b:
            if (r3 == 0) goto L_0x00b0
            if (r6 != 0) goto L_0x00ab
            int[] r11 = r10.g()
            float[] r0 = r10.d()
            a((int[]) r11, (float[]) r0)
            goto L_0x00b0
        L_0x00ab:
            com.google.zxing.q r11 = com.google.zxing.q.a()
            throw r11
        L_0x00b0:
            if (r6 == 0) goto L_0x00bd
            int[] r11 = r10.g()
            float[] r0 = r10.e()
            b(r11, r0)
        L_0x00bd:
            return
        L_0x00be:
            com.google.zxing.q r11 = com.google.zxing.q.a()
            throw r11
        L_0x00c3:
            com.google.zxing.q r11 = com.google.zxing.q.a()
            goto L_0x00c9
        L_0x00c8:
            throw r11
        L_0x00c9:
            goto L_0x00c8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.d.a.a.d.a(int):void");
    }
}
