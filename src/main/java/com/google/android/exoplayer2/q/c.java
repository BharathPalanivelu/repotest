package com.google.android.exoplayer2.q;

import android.graphics.Point;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.q.f;
import com.google.android.exoplayer2.s.v;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class c extends e {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f11256a = new int[0];

    /* renamed from: b  reason: collision with root package name */
    private final f.a f11257b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicReference<b> f11258c;

    private static int a(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    protected static boolean a(int i, boolean z) {
        int i2 = i & 7;
        return i2 == 4 || (z && i2 == 3);
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f11262a;

        /* renamed from: b  reason: collision with root package name */
        public final String f11263b;

        /* renamed from: c  reason: collision with root package name */
        public final int f11264c;

        /* renamed from: d  reason: collision with root package name */
        public final int f11265d;

        /* renamed from: e  reason: collision with root package name */
        public final int f11266e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f11267f;

        /* renamed from: g  reason: collision with root package name */
        public final int f11268g;
        public final int h;
        public final boolean i;
        public final boolean j;
        public final boolean k;
        public final boolean l;

        public b() {
            this((String) null, (String) null, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public b(String str, String str2, boolean z, boolean z2, int i2, int i3, int i4, boolean z3, boolean z4, int i5, int i6, boolean z5) {
            this.f11262a = str;
            this.f11263b = str2;
            this.j = z;
            this.k = z2;
            this.f11264c = i2;
            this.f11265d = i3;
            this.f11266e = i4;
            this.f11267f = z3;
            this.l = z4;
            this.f11268g = i5;
            this.h = i6;
            this.i = z5;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.j == bVar.j && this.k == bVar.k && this.f11264c == bVar.f11264c && this.f11265d == bVar.f11265d && this.f11267f == bVar.f11267f && this.l == bVar.l && this.i == bVar.i && this.f11268g == bVar.f11268g && this.h == bVar.h && this.f11266e == bVar.f11266e && TextUtils.equals(this.f11262a, bVar.f11262a) && TextUtils.equals(this.f11263b, bVar.f11263b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((((((((((((this.f11262a.hashCode() * 31) + this.f11263b.hashCode()) * 31) + (this.j ? 1 : 0)) * 31) + (this.k ? 1 : 0)) * 31) + this.f11264c) * 31) + this.f11265d) * 31) + this.f11266e) * 31) + (this.f11267f ? 1 : 0)) * 31) + (this.l ? 1 : 0)) * 31) + (this.i ? 1 : 0)) * 31) + this.f11268g) * 31) + this.h;
        }
    }

    public c() {
        this((f.a) null);
    }

    public c(f.a aVar) {
        this.f11257b = aVar;
        this.f11258c = new AtomicReference<>(new b());
    }

    /* access modifiers changed from: protected */
    public f[] a(t[] tVarArr, p[] pVarArr, int[][][] iArr) throws e {
        t[] tVarArr2 = tVarArr;
        int length = tVarArr2.length;
        f[] fVarArr = new f[length];
        b bVar = this.f11258c.get();
        boolean z = false;
        int i = 0;
        boolean z2 = false;
        while (true) {
            boolean z3 = true;
            if (i >= length) {
                break;
            }
            if (2 == tVarArr2[i].a()) {
                if (!z) {
                    fVarArr[i] = a(tVarArr2[i], pVarArr[i], iArr[i], bVar, this.f11257b);
                    z = fVarArr[i] != null;
                }
                if (pVarArr[i].f12118b <= 0) {
                    z3 = false;
                }
                z2 |= z3;
            }
            i++;
        }
        boolean z4 = false;
        boolean z5 = false;
        for (int i2 = 0; i2 < length; i2++) {
            int a2 = tVarArr2[i2].a();
            if (a2 != 1) {
                if (a2 != 2) {
                    if (a2 != 3) {
                        fVarArr[i2] = a(tVarArr2[i2].a(), pVarArr[i2], iArr[i2], bVar);
                    } else if (!z5) {
                        fVarArr[i2] = a(pVarArr[i2], iArr[i2], bVar);
                        z5 = fVarArr[i2] != null;
                    }
                }
            } else if (!z4) {
                fVarArr[i2] = a(pVarArr[i2], iArr[i2], bVar, z2 ? null : this.f11257b);
                z4 = fVarArr[i2] != null;
            }
        }
        return fVarArr;
    }

    /* access modifiers changed from: protected */
    public f a(t tVar, p pVar, int[][] iArr, b bVar, f.a aVar) throws e {
        f b2 = aVar != null ? b(tVar, pVar, iArr, bVar, aVar) : null;
        return b2 == null ? b(pVar, iArr, bVar) : b2;
    }

    private static f b(t tVar, p pVar, int[][] iArr, b bVar, f.a aVar) throws e {
        p pVar2 = pVar;
        b bVar2 = bVar;
        int i = bVar2.k ? 24 : 16;
        boolean z = bVar2.j && (tVar.m() & i) != 0;
        for (int i2 = 0; i2 < pVar2.f12118b; i2++) {
            o a2 = pVar2.a(i2);
            int[] a3 = a(a2, iArr[i2], z, i, bVar2.f11264c, bVar2.f11265d, bVar2.f11266e, bVar2.f11268g, bVar2.h, bVar2.i);
            if (a3.length > 0) {
                return aVar.b(a2, a3);
            }
            f.a aVar2 = aVar;
        }
        return null;
    }

    private static int[] a(o oVar, int[] iArr, boolean z, int i, int i2, int i3, int i4, int i5, int i6, boolean z2) {
        String str;
        o oVar2 = oVar;
        if (oVar2.f12114a < 2) {
            return f11256a;
        }
        List<Integer> a2 = a(oVar2, i5, i6, z2);
        if (a2.size() < 2) {
            return f11256a;
        }
        if (!z) {
            HashSet hashSet = new HashSet();
            String str2 = null;
            int i7 = 0;
            for (int i8 = 0; i8 < a2.size(); i8++) {
                String str3 = oVar2.a(a2.get(i8).intValue()).f8958f;
                if (hashSet.add(str3)) {
                    int a3 = a(oVar, iArr, i, str3, i2, i3, i4, a2);
                    if (a3 > i7) {
                        i7 = a3;
                        str2 = str3;
                    }
                }
            }
            str = str2;
        } else {
            str = null;
        }
        b(oVar, iArr, i, str, i2, i3, i4, a2);
        return a2.size() < 2 ? f11256a : v.a(a2);
    }

    private static int a(o oVar, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            int intValue = list.get(i6).intValue();
            o oVar2 = oVar;
            if (a(oVar.a(intValue), str, iArr[intValue], i, i2, i3, i4)) {
                i5++;
            }
        }
        return i5;
    }

    private static void b(o oVar, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        List<Integer> list2 = list;
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = list2.get(size).intValue();
            o oVar2 = oVar;
            if (!a(oVar.a(intValue), str, iArr[intValue], i, i2, i3, i4)) {
                list2.remove(size);
            }
        }
    }

    private static boolean a(Format format, String str, int i, int i2, int i3, int i4, int i5) {
        if (!a(i, false) || (i & i2) == 0) {
            return false;
        }
        if (str != null && !v.a((Object) format.f8958f, (Object) str)) {
            return false;
        }
        if (format.j != -1 && format.j > i3) {
            return false;
        }
        if (format.k != -1 && format.k > i4) {
            return false;
        }
        if (format.f8954b == -1 || format.f8954b <= i5) {
            return true;
        }
        return false;
    }

    private static f b(p pVar, int[][] iArr, b bVar) {
        int i;
        p pVar2 = pVar;
        b bVar2 = bVar;
        int i2 = -1;
        int i3 = 0;
        o oVar = null;
        int i4 = 0;
        int i5 = 0;
        int i6 = -1;
        int i7 = -1;
        while (i3 < pVar2.f12118b) {
            o a2 = pVar2.a(i3);
            List<Integer> a3 = a(a2, bVar2.f11268g, bVar2.h, bVar2.i);
            int[] iArr2 = iArr[i3];
            int i8 = i7;
            int i9 = i6;
            int i10 = i5;
            int i11 = i4;
            o oVar2 = oVar;
            int i12 = 0;
            while (i12 < a2.f12114a) {
                if (a(iArr2[i12], bVar2.l)) {
                    Format a4 = a2.a(i12);
                    boolean z = a3.contains(Integer.valueOf(i12)) && (a4.j == i2 || a4.j <= bVar2.f11264c) && ((a4.k == i2 || a4.k <= bVar2.f11265d) && (a4.f8954b == i2 || a4.f8954b <= bVar2.f11266e));
                    if (z || bVar2.f11267f) {
                        int i13 = z ? 2 : 1;
                        boolean a5 = a(iArr2[i12], false);
                        if (a5) {
                            i13 += 1000;
                        }
                        boolean z2 = i13 > i10;
                        if (i13 == i10) {
                            if (a4.a() != i9) {
                                i = a(a4.a(), i9);
                            } else {
                                i = a(a4.f8954b, i8);
                            }
                            z2 = !a5 || !z ? i < 0 : i > 0;
                        }
                        if (z2) {
                            i8 = a4.f8954b;
                            i9 = a4.a();
                            i11 = i12;
                            oVar2 = a2;
                            i10 = i13;
                        }
                    }
                }
                i12++;
                i2 = -1;
                p pVar3 = pVar;
            }
            i3++;
            i2 = -1;
            pVar2 = pVar;
            oVar = oVar2;
            i4 = i11;
            i5 = i10;
            i6 = i9;
            i7 = i8;
        }
        if (oVar == null) {
            return null;
        }
        return new d(oVar, i4);
    }

    /* access modifiers changed from: protected */
    public f a(p pVar, int[][] iArr, b bVar, f.a aVar) {
        p pVar2 = pVar;
        b bVar2 = bVar;
        f.a aVar2 = aVar;
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        int i4 = 0;
        while (i < pVar2.f12118b) {
            o a2 = pVar2.a(i);
            int[] iArr2 = iArr[i];
            int i5 = i4;
            int i6 = i3;
            int i7 = i2;
            for (int i8 = 0; i8 < a2.f12114a; i8++) {
                if (a(iArr2[i8], bVar2.l)) {
                    int a3 = a(iArr2[i8], bVar2.f11262a, a2.a(i8));
                    if (a3 > i5) {
                        i7 = i;
                        i6 = i8;
                        i5 = a3;
                    }
                }
            }
            i++;
            i2 = i7;
            i3 = i6;
            i4 = i5;
        }
        if (i2 == -1) {
            return null;
        }
        o a4 = pVar2.a(i2);
        if (aVar2 != null) {
            int[] a5 = a(a4, iArr[i2], bVar2.j);
            if (a5.length > 0) {
                return aVar2.b(a4, a5);
            }
        }
        return new d(a4, i3);
    }

    private static int a(int i, String str, Format format) {
        int i2 = 1;
        boolean z = (format.x & 1) != 0;
        if (a(format, str)) {
            i2 = z ? 4 : 3;
        } else if (z) {
            i2 = 2;
        }
        return a(i, false) ? i2 + 1000 : i2;
    }

    private static int[] a(o oVar, int[] iArr, boolean z) {
        HashSet hashSet = new HashSet();
        a aVar = null;
        int i = 0;
        for (int i2 = 0; i2 < oVar.f12114a; i2++) {
            Format a2 = oVar.a(i2);
            a aVar2 = new a(a2.r, a2.s, z ? null : a2.f8958f);
            if (hashSet.add(aVar2)) {
                int a3 = a(oVar, iArr, aVar2);
                if (a3 > i) {
                    i = a3;
                    aVar = aVar2;
                }
            }
        }
        if (i <= 1) {
            return f11256a;
        }
        int[] iArr2 = new int[i];
        int i3 = 0;
        for (int i4 = 0; i4 < oVar.f12114a; i4++) {
            if (a(oVar.a(i4), iArr[i4], aVar)) {
                iArr2[i3] = i4;
                i3++;
            }
        }
        return iArr2;
    }

    private static int a(o oVar, int[] iArr, a aVar) {
        int i = 0;
        for (int i2 = 0; i2 < oVar.f12114a; i2++) {
            if (a(oVar.a(i2), iArr[i2], aVar)) {
                i++;
            }
        }
        return i;
    }

    private static boolean a(Format format, int i, a aVar) {
        if (!a(i, false) || format.r != aVar.f11259a || format.s != aVar.f11260b) {
            return false;
        }
        if (aVar.f11261c == null || TextUtils.equals(aVar.f11261c, format.f8958f)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public f a(p pVar, int[][] iArr, b bVar) {
        p pVar2 = pVar;
        b bVar2 = bVar;
        int i = 0;
        o oVar = null;
        int i2 = 0;
        int i3 = 0;
        while (i < pVar2.f12118b) {
            o a2 = pVar2.a(i);
            int[] iArr2 = iArr[i];
            int i4 = i3;
            int i5 = i2;
            o oVar2 = oVar;
            for (int i6 = 0; i6 < a2.f12114a; i6++) {
                if (a(iArr2[i6], bVar2.l)) {
                    Format a3 = a2.a(i6);
                    int i7 = 1;
                    boolean z = (a3.x & 1) != 0;
                    boolean z2 = (a3.x & 2) != 0;
                    if (a(a3, bVar2.f11263b)) {
                        i7 = z ? 6 : !z2 ? 5 : 4;
                    } else if (z) {
                        i7 = 3;
                    } else if (z2) {
                        if (a(a3, bVar2.f11262a)) {
                            i7 = 2;
                        }
                    }
                    if (a(iArr2[i6], false)) {
                        i7 += 1000;
                    }
                    if (i7 > i4) {
                        i5 = i6;
                        oVar2 = a2;
                        i4 = i7;
                    }
                }
            }
            i++;
            oVar = oVar2;
            i2 = i5;
            i3 = i4;
        }
        if (oVar == null) {
            return null;
        }
        return new d(oVar, i2);
    }

    /* access modifiers changed from: protected */
    public f a(int i, p pVar, int[][] iArr, b bVar) {
        o oVar = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < pVar.f12118b) {
            o a2 = pVar.a(i2);
            int[] iArr2 = iArr[i2];
            int i5 = i4;
            int i6 = i3;
            o oVar2 = oVar;
            for (int i7 = 0; i7 < a2.f12114a; i7++) {
                if (a(iArr2[i7], bVar.l)) {
                    int i8 = 1;
                    if ((a2.a(i7).x & 1) != 0) {
                        i8 = 2;
                    }
                    if (a(iArr2[i7], false)) {
                        i8 += 1000;
                    }
                    if (i8 > i5) {
                        i6 = i7;
                        oVar2 = a2;
                        i5 = i8;
                    }
                }
            }
            i2++;
            oVar = oVar2;
            i3 = i6;
            i4 = i5;
        }
        if (oVar == null) {
            return null;
        }
        return new d(oVar, i3);
    }

    protected static boolean a(Format format, String str) {
        return str != null && TextUtils.equals(str, v.b(format.y));
    }

    private static List<Integer> a(o oVar, int i, int i2, boolean z) {
        ArrayList arrayList = new ArrayList(oVar.f12114a);
        for (int i3 = 0; i3 < oVar.f12114a; i3++) {
            arrayList.add(Integer.valueOf(i3));
        }
        if (!(i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE)) {
            int i4 = Integer.MAX_VALUE;
            for (int i5 = 0; i5 < oVar.f12114a; i5++) {
                Format a2 = oVar.a(i5);
                if (a2.j > 0 && a2.k > 0) {
                    Point a3 = a(z, i, i2, a2.j, a2.k);
                    int i6 = a2.j * a2.k;
                    if (a2.j >= ((int) (((float) a3.x) * 0.98f)) && a2.k >= ((int) (((float) a3.y) * 0.98f)) && i6 < i4) {
                        i4 = i6;
                    }
                }
            }
            if (i4 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int a4 = oVar.a(((Integer) arrayList.get(size)).intValue()).a();
                    if (a4 == -1 || a4 > i4) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000d, code lost:
        if (r1 != r3) goto L_0x0013;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Point a(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto L_0x0010
            r3 = 1
            r0 = 0
            if (r6 <= r7) goto L_0x0008
            r1 = 1
            goto L_0x0009
        L_0x0008:
            r1 = 0
        L_0x0009:
            if (r4 <= r5) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r3 = 0
        L_0x000d:
            if (r1 == r3) goto L_0x0010
            goto L_0x0013
        L_0x0010:
            r2 = r5
            r5 = r4
            r4 = r2
        L_0x0013:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L_0x0023
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = com.google.android.exoplayer2.s.v.a((int) r0, (int) r6)
            r3.<init>(r5, r4)
            return r3
        L_0x0023:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = com.google.android.exoplayer2.s.v.a((int) r3, (int) r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.q.c.a(boolean, int, int, int, int):android.graphics.Point");
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f11259a;

        /* renamed from: b  reason: collision with root package name */
        public final int f11260b;

        /* renamed from: c  reason: collision with root package name */
        public final String f11261c;

        public a(int i, int i2, String str) {
            this.f11259a = i;
            this.f11260b = i2;
            this.f11261c = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f11259a == aVar.f11259a && this.f11260b == aVar.f11260b && TextUtils.equals(this.f11261c, aVar.f11261c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = ((this.f11259a * 31) + this.f11260b) * 31;
            String str = this.f11261c;
            return i + (str != null ? str.hashCode() : 0);
        }
    }
}
