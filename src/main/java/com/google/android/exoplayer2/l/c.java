package com.google.android.exoplayer2.l;

import android.graphics.Point;
import android.text.TextUtils;
import com.google.android.exoplayer2.ac;
import com.google.android.exoplayer2.an;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.l.f;
import com.google.android.exoplayer2.n.t;
import com.google.android.exoplayer2.source.ad;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class c extends e {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f10707a = new int[0];

    /* renamed from: b  reason: collision with root package name */
    private final f.a f10708b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicReference<b> f10709c;

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
        int i2 = i & 3;
        return i2 == 3 || (z && i2 == 2);
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f10713a;

        /* renamed from: b  reason: collision with root package name */
        public final String f10714b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f10715c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f10716d;

        /* renamed from: e  reason: collision with root package name */
        public final int f10717e;

        /* renamed from: f  reason: collision with root package name */
        public final int f10718f;

        /* renamed from: g  reason: collision with root package name */
        public final int f10719g;
        public final boolean h;
        public final boolean i;
        public final int j;
        public final int k;
        public final boolean l;

        public b() {
            this((String) null, (String) null, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public b(String str, String str2, boolean z, boolean z2, int i2, int i3, int i4, boolean z3, boolean z4, int i5, int i6, boolean z5) {
            this.f10713a = str;
            this.f10714b = str2;
            this.f10715c = z;
            this.f10716d = z2;
            this.f10717e = i2;
            this.f10718f = i3;
            this.f10719g = i4;
            this.h = z3;
            this.i = z4;
            this.j = i5;
            this.k = i6;
            this.l = z5;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f10715c == bVar.f10715c && this.f10716d == bVar.f10716d && this.f10717e == bVar.f10717e && this.f10718f == bVar.f10718f && this.h == bVar.h && this.i == bVar.i && this.l == bVar.l && this.j == bVar.j && this.k == bVar.k && this.f10719g == bVar.f10719g && TextUtils.equals(this.f10713a, bVar.f10713a) && TextUtils.equals(this.f10714b, bVar.f10714b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((((((((((((this.f10713a.hashCode() * 31) + this.f10714b.hashCode()) * 31) + (this.f10715c ? 1 : 0)) * 31) + (this.f10716d ? 1 : 0)) * 31) + this.f10717e) * 31) + this.f10718f) * 31) + this.f10719g) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0)) * 31) + (this.l ? 1 : 0)) * 31) + this.j) * 31) + this.k;
        }
    }

    public c() {
        this((f.a) null);
    }

    public c(f.a aVar) {
        this.f10708b = aVar;
        this.f10709c = new AtomicReference<>(new b());
    }

    /* access modifiers changed from: protected */
    public f[] a(an[] anVarArr, ad[] adVarArr, int[][][] iArr) throws ac {
        b bVar;
        int i;
        b bVar2;
        f[] fVarArr;
        int i2;
        c cVar = this;
        an[] anVarArr2 = anVarArr;
        int length = anVarArr2.length;
        f[] fVarArr2 = new f[length];
        b bVar3 = cVar.f10709c.get();
        int i3 = 0;
        boolean z = false;
        while (i3 < length) {
            if (2 == anVarArr2[i3].a()) {
                i2 = i3;
                fVarArr = fVarArr2;
                bVar2 = bVar3;
                i = length;
                fVarArr[i2] = a(anVarArr2[i3], adVarArr[i3], iArr[i3], bVar3.f10717e, bVar3.f10718f, bVar3.f10719g, bVar3.f10716d, bVar3.f10715c, bVar3.j, bVar3.k, bVar3.l, cVar.f10708b, bVar3.h, bVar3.i);
                z |= adVarArr[i2].f11538b > 0;
            } else {
                i2 = i3;
                bVar2 = bVar3;
                fVarArr = fVarArr2;
                i = length;
            }
            i3 = i2 + 1;
            cVar = this;
            anVarArr2 = anVarArr;
            fVarArr2 = fVarArr;
            bVar3 = bVar2;
            length = i;
        }
        b bVar4 = bVar3;
        f[] fVarArr3 = fVarArr2;
        int i4 = length;
        int i5 = 0;
        while (i5 < i4) {
            int a2 = anVarArr[i5].a();
            if (a2 == 1) {
                bVar = bVar4;
                fVarArr3[i5] = a(adVarArr[i5], iArr[i5], bVar.f10713a, bVar.i, bVar.f10715c, z ? null : this.f10708b);
            } else if (a2 == 2) {
                bVar = bVar4;
            } else if (a2 != 3) {
                bVar = bVar4;
                fVarArr3[i5] = a(anVarArr[i5].a(), adVarArr[i5], iArr[i5], bVar.i);
            } else {
                bVar = bVar4;
                fVarArr3[i5] = a(adVarArr[i5], iArr[i5], bVar.f10714b, bVar.f10713a, bVar.i);
            }
            i5++;
            bVar4 = bVar;
        }
        return fVarArr3;
    }

    /* access modifiers changed from: protected */
    public f a(an anVar, ad adVar, int[][] iArr, int i, int i2, int i3, boolean z, boolean z2, int i4, int i5, boolean z3, f.a aVar, boolean z4, boolean z5) throws ac {
        f a2 = aVar != null ? a(anVar, adVar, iArr, i, i2, i3, z, z2, i4, i5, z3, aVar) : null;
        return a2 == null ? a(adVar, iArr, i, i2, i3, i4, i5, z3, z4, z5) : a2;
    }

    private static f a(an anVar, ad adVar, int[][] iArr, int i, int i2, int i3, boolean z, boolean z2, int i4, int i5, boolean z3, f.a aVar) throws ac {
        ad adVar2 = adVar;
        int i6 = z ? 12 : 8;
        boolean z4 = z2 && (anVar.m() & i6) != 0;
        for (int i7 = 0; i7 < adVar2.f11538b; i7++) {
            com.google.android.exoplayer2.source.ac a2 = adVar2.a(i7);
            int[] a3 = a(a2, iArr[i7], z4, i6, i, i2, i3, i4, i5, z3);
            if (a3.length > 0) {
                return aVar.b(a2, a3);
            }
            f.a aVar2 = aVar;
        }
        return null;
    }

    private static int[] a(com.google.android.exoplayer2.source.ac acVar, int[] iArr, boolean z, int i, int i2, int i3, int i4, int i5, int i6, boolean z2) {
        String str;
        com.google.android.exoplayer2.source.ac acVar2 = acVar;
        if (acVar2.f11534a < 2) {
            return f10707a;
        }
        List<Integer> a2 = a(acVar2, i5, i6, z2);
        if (a2.size() < 2) {
            return f10707a;
        }
        if (!z) {
            HashSet hashSet = new HashSet();
            String str2 = null;
            int i7 = 0;
            for (int i8 = 0; i8 < a2.size(); i8++) {
                String str3 = acVar2.a(a2.get(i8).intValue()).f10427f;
                if (hashSet.add(str3)) {
                    int a3 = a(acVar, iArr, i, str3, i2, i3, i4, a2);
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
        b(acVar, iArr, i, str, i2, i3, i4, a2);
        return a2.size() < 2 ? f10707a : t.a(a2);
    }

    private static int a(com.google.android.exoplayer2.source.ac acVar, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            int intValue = list.get(i6).intValue();
            com.google.android.exoplayer2.source.ac acVar2 = acVar;
            if (a(acVar.a(intValue), str, iArr[intValue], i, i2, i3, i4)) {
                i5++;
            }
        }
        return i5;
    }

    private static void b(com.google.android.exoplayer2.source.ac acVar, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        List<Integer> list2 = list;
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = list2.get(size).intValue();
            com.google.android.exoplayer2.source.ac acVar2 = acVar;
            if (!a(acVar.a(intValue), str, iArr[intValue], i, i2, i3, i4)) {
                list2.remove(size);
            }
        }
    }

    private static boolean a(j jVar, String str, int i, int i2, int i3, int i4, int i5) {
        if (!a(i, false) || (i & i2) == 0) {
            return false;
        }
        if (str != null && !t.a((Object) jVar.f10427f, (Object) str)) {
            return false;
        }
        if (jVar.j != -1 && jVar.j > i3) {
            return false;
        }
        if (jVar.k != -1 && jVar.k > i4) {
            return false;
        }
        if (jVar.f10423b == -1 || jVar.f10423b <= i5) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0048, code lost:
        if (r3.j <= r22) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0056, code lost:
        if (r3.k <= r23) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0064, code lost:
        if (r3.f10423b <= r24) goto L_0x0069;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.l.f a(com.google.android.exoplayer2.source.ad r20, int[][] r21, int r22, int r23, int r24, int r25, int r26, boolean r27, boolean r28, boolean r29) {
        /*
            r0 = r20
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = -1
            r9 = -1
        L_0x0008:
            int r10 = r0.f11538b
            if (r4 >= r10) goto L_0x00dd
            com.google.android.exoplayer2.source.ac r10 = r0.a((int) r4)
            r11 = r25
            r12 = r26
            r13 = r27
            java.util.List r14 = a((com.google.android.exoplayer2.source.ac) r10, (int) r11, (int) r12, (boolean) r13)
            r15 = r21[r4]
            r1 = r9
            r9 = r8
            r8 = r7
            r7 = r5
            r5 = 0
        L_0x0021:
            int r3 = r10.f11534a
            if (r5 >= r3) goto L_0x00cd
            r3 = r15[r5]
            r2 = r29
            boolean r3 = a((int) r3, (boolean) r2)
            if (r3 == 0) goto L_0x00be
            com.google.android.exoplayer2.j r3 = r10.a((int) r5)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            boolean r0 = r14.contains(r0)
            r17 = 1
            if (r0 == 0) goto L_0x006b
            int r0 = r3.j
            r2 = -1
            if (r0 == r2) goto L_0x004b
            int r0 = r3.j
            r2 = r22
            if (r0 > r2) goto L_0x006b
            goto L_0x004d
        L_0x004b:
            r2 = r22
        L_0x004d:
            int r0 = r3.k
            r2 = -1
            if (r0 == r2) goto L_0x0059
            int r0 = r3.k
            r2 = r23
            if (r0 > r2) goto L_0x006b
            goto L_0x005b
        L_0x0059:
            r2 = r23
        L_0x005b:
            int r0 = r3.f10423b
            r2 = -1
            if (r0 == r2) goto L_0x0067
            int r0 = r3.f10423b
            r2 = r24
            if (r0 > r2) goto L_0x006d
            goto L_0x0069
        L_0x0067:
            r2 = r24
        L_0x0069:
            r0 = 1
            goto L_0x006e
        L_0x006b:
            r2 = r24
        L_0x006d:
            r0 = 0
        L_0x006e:
            if (r0 != 0) goto L_0x0073
            if (r28 != 0) goto L_0x0073
            goto L_0x00be
        L_0x0073:
            if (r0 == 0) goto L_0x007b
            r18 = 2
            r18 = r6
            r2 = 2
            goto L_0x007e
        L_0x007b:
            r18 = r6
            r2 = 1
        L_0x007e:
            r6 = r15[r5]
            r19 = r7
            r7 = 0
            boolean r6 = a((int) r6, (boolean) r7)
            if (r6 == 0) goto L_0x008b
            int r2 = r2 + 1000
        L_0x008b:
            if (r2 <= r8) goto L_0x008f
            r6 = 1
            goto L_0x0090
        L_0x008f:
            r6 = 0
        L_0x0090:
            if (r2 != r8) goto L_0x00b1
            int r6 = r3.a()
            if (r6 == r9) goto L_0x00a1
            int r6 = r3.a()
            int r6 = a((int) r6, (int) r9)
            goto L_0x00a7
        L_0x00a1:
            int r6 = r3.f10423b
            int r6 = a((int) r6, (int) r1)
        L_0x00a7:
            if (r0 == 0) goto L_0x00ac
            if (r6 <= 0) goto L_0x00b0
            goto L_0x00ae
        L_0x00ac:
            if (r6 >= 0) goto L_0x00b0
        L_0x00ae:
            r6 = 1
            goto L_0x00b1
        L_0x00b0:
            r6 = 0
        L_0x00b1:
            if (r6 == 0) goto L_0x00c3
            int r1 = r3.f10423b
            int r9 = r3.a()
            r8 = r2
            r6 = r5
            r19 = r10
            goto L_0x00c5
        L_0x00be:
            r18 = r6
            r19 = r7
            r7 = 0
        L_0x00c3:
            r6 = r18
        L_0x00c5:
            int r5 = r5 + 1
            r0 = r20
            r7 = r19
            goto L_0x0021
        L_0x00cd:
            r18 = r6
            r19 = r7
            r7 = 0
            int r4 = r4 + 1
            r0 = r20
            r7 = r8
            r8 = r9
            r5 = r19
            r9 = r1
            goto L_0x0008
        L_0x00dd:
            if (r5 != 0) goto L_0x00e2
            r16 = 0
            goto L_0x00e9
        L_0x00e2:
            com.google.android.exoplayer2.l.d r1 = new com.google.android.exoplayer2.l.d
            r1.<init>(r5, r6)
            r16 = r1
        L_0x00e9:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.l.c.a(com.google.android.exoplayer2.source.ad, int[][], int, int, int, int, int, boolean, boolean, boolean):com.google.android.exoplayer2.l.f");
    }

    /* access modifiers changed from: protected */
    public f a(ad adVar, int[][] iArr, String str, boolean z, boolean z2, f.a aVar) {
        ad adVar2 = adVar;
        f.a aVar2 = aVar;
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        int i4 = 0;
        while (i < adVar2.f11538b) {
            com.google.android.exoplayer2.source.ac a2 = adVar2.a(i);
            int[] iArr2 = iArr[i];
            int i5 = i4;
            int i6 = i3;
            int i7 = i2;
            for (int i8 = 0; i8 < a2.f11534a; i8++) {
                if (a(iArr2[i8], z)) {
                    int a3 = a(iArr2[i8], str, a2.a(i8));
                    if (a3 > i5) {
                        i7 = i;
                        i6 = i8;
                        i5 = a3;
                    }
                } else {
                    String str2 = str;
                }
            }
            String str3 = str;
            boolean z3 = z;
            i++;
            i2 = i7;
            i3 = i6;
            i4 = i5;
        }
        if (i2 == -1) {
            return null;
        }
        com.google.android.exoplayer2.source.ac a4 = adVar2.a(i2);
        if (aVar2 != null) {
            int[] a5 = a(a4, iArr[i2], z2);
            if (a5.length > 0) {
                return aVar2.b(a4, a5);
            }
        }
        return new d(a4, i3);
    }

    private static int a(int i, String str, j jVar) {
        int i2 = 1;
        boolean z = (jVar.x & 1) != 0;
        if (a(jVar, str)) {
            i2 = z ? 4 : 3;
        } else if (z) {
            i2 = 2;
        }
        return a(i, false) ? i2 + 1000 : i2;
    }

    private static int[] a(com.google.android.exoplayer2.source.ac acVar, int[] iArr, boolean z) {
        HashSet hashSet = new HashSet();
        a aVar = null;
        int i = 0;
        for (int i2 = 0; i2 < acVar.f11534a; i2++) {
            j a2 = acVar.a(i2);
            a aVar2 = new a(a2.r, a2.s, z ? null : a2.f10427f);
            if (hashSet.add(aVar2)) {
                int a3 = a(acVar, iArr, aVar2);
                if (a3 > i) {
                    i = a3;
                    aVar = aVar2;
                }
            }
        }
        if (i <= 1) {
            return f10707a;
        }
        int[] iArr2 = new int[i];
        int i3 = 0;
        for (int i4 = 0; i4 < acVar.f11534a; i4++) {
            if (a(acVar.a(i4), iArr[i4], aVar)) {
                iArr2[i3] = i4;
                i3++;
            }
        }
        return iArr2;
    }

    private static int a(com.google.android.exoplayer2.source.ac acVar, int[] iArr, a aVar) {
        int i = 0;
        for (int i2 = 0; i2 < acVar.f11534a; i2++) {
            if (a(acVar.a(i2), iArr[i2], aVar)) {
                i++;
            }
        }
        return i;
    }

    private static boolean a(j jVar, int i, a aVar) {
        if (!a(i, false) || jVar.r != aVar.f10710a || jVar.s != aVar.f10711b) {
            return false;
        }
        if (aVar.f10712c == null || TextUtils.equals(aVar.f10712c, jVar.f10427f)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0075 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.l.f a(com.google.android.exoplayer2.source.ad r19, int[][] r20, java.lang.String r21, java.lang.String r22, boolean r23) {
        /*
            r18 = this;
            r0 = r19
            r1 = 0
            r2 = 0
            r4 = r1
            r3 = 0
            r5 = 0
            r6 = 0
        L_0x0008:
            int r7 = r0.f11538b
            if (r3 >= r7) goto L_0x0084
            com.google.android.exoplayer2.source.ac r7 = r0.a((int) r3)
            r8 = r20[r3]
            r9 = r6
            r6 = r5
            r5 = r4
            r4 = 0
        L_0x0016:
            int r10 = r7.f11534a
            if (r4 >= r10) goto L_0x0078
            r10 = r8[r4]
            r11 = r23
            boolean r10 = a((int) r10, (boolean) r11)
            if (r10 == 0) goto L_0x0071
            com.google.android.exoplayer2.j r10 = r7.a((int) r4)
            int r12 = r10.x
            r13 = 1
            r12 = r12 & r13
            if (r12 == 0) goto L_0x0030
            r12 = 1
            goto L_0x0031
        L_0x0030:
            r12 = 0
        L_0x0031:
            int r14 = r10.x
            r15 = 2
            r14 = r14 & r15
            if (r14 == 0) goto L_0x003c
            r14 = r21
            r16 = 1
            goto L_0x0040
        L_0x003c:
            r14 = r21
            r16 = 0
        L_0x0040:
            boolean r17 = a((com.google.android.exoplayer2.j) r10, (java.lang.String) r14)
            if (r17 == 0) goto L_0x0050
            if (r12 == 0) goto L_0x004a
            r13 = 6
            goto L_0x0053
        L_0x004a:
            if (r16 != 0) goto L_0x004e
            r13 = 5
            goto L_0x0053
        L_0x004e:
            r13 = 4
            goto L_0x0053
        L_0x0050:
            if (r12 == 0) goto L_0x0056
            r13 = 3
        L_0x0053:
            r12 = r22
            goto L_0x0061
        L_0x0056:
            if (r16 == 0) goto L_0x0073
            r12 = r22
            boolean r10 = a((com.google.android.exoplayer2.j) r10, (java.lang.String) r12)
            if (r10 == 0) goto L_0x0061
            r13 = 2
        L_0x0061:
            r10 = r8[r4]
            boolean r10 = a((int) r10, (boolean) r2)
            if (r10 == 0) goto L_0x006b
            int r13 = r13 + 1000
        L_0x006b:
            if (r13 <= r9) goto L_0x0075
            r6 = r4
            r5 = r7
            r9 = r13
            goto L_0x0075
        L_0x0071:
            r14 = r21
        L_0x0073:
            r12 = r22
        L_0x0075:
            int r4 = r4 + 1
            goto L_0x0016
        L_0x0078:
            r14 = r21
            r12 = r22
            r11 = r23
            int r3 = r3 + 1
            r4 = r5
            r5 = r6
            r6 = r9
            goto L_0x0008
        L_0x0084:
            if (r4 != 0) goto L_0x0087
            goto L_0x008c
        L_0x0087:
            com.google.android.exoplayer2.l.d r1 = new com.google.android.exoplayer2.l.d
            r1.<init>(r4, r5)
        L_0x008c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.l.c.a(com.google.android.exoplayer2.source.ad, int[][], java.lang.String, java.lang.String, boolean):com.google.android.exoplayer2.l.f");
    }

    /* access modifiers changed from: protected */
    public f a(int i, ad adVar, int[][] iArr, boolean z) {
        com.google.android.exoplayer2.source.ac acVar = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < adVar.f11538b) {
            com.google.android.exoplayer2.source.ac a2 = adVar.a(i2);
            int[] iArr2 = iArr[i2];
            int i5 = i4;
            int i6 = i3;
            com.google.android.exoplayer2.source.ac acVar2 = acVar;
            for (int i7 = 0; i7 < a2.f11534a; i7++) {
                if (a(iArr2[i7], z)) {
                    int i8 = 1;
                    if ((a2.a(i7).x & 1) != 0) {
                        i8 = 2;
                    }
                    if (a(iArr2[i7], false)) {
                        i8 += 1000;
                    }
                    if (i8 > i5) {
                        i6 = i7;
                        acVar2 = a2;
                        i5 = i8;
                    }
                }
            }
            i2++;
            acVar = acVar2;
            i3 = i6;
            i4 = i5;
        }
        if (acVar == null) {
            return null;
        }
        return new d(acVar, i3);
    }

    protected static boolean a(j jVar, String str) {
        return str != null && TextUtils.equals(str, t.b(jVar.y));
    }

    private static List<Integer> a(com.google.android.exoplayer2.source.ac acVar, int i, int i2, boolean z) {
        ArrayList arrayList = new ArrayList(acVar.f11534a);
        for (int i3 = 0; i3 < acVar.f11534a; i3++) {
            arrayList.add(Integer.valueOf(i3));
        }
        if (!(i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE)) {
            int i4 = Integer.MAX_VALUE;
            for (int i5 = 0; i5 < acVar.f11534a; i5++) {
                j a2 = acVar.a(i5);
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
                    int a4 = acVar.a(((Integer) arrayList.get(size)).intValue()).a();
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
            int r4 = com.google.android.exoplayer2.n.t.a((int) r0, (int) r6)
            r3.<init>(r5, r4)
            return r3
        L_0x0023:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = com.google.android.exoplayer2.n.t.a((int) r3, (int) r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.l.c.a(boolean, int, int, int, int):android.graphics.Point");
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f10710a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10711b;

        /* renamed from: c  reason: collision with root package name */
        public final String f10712c;

        public a(int i, int i2, String str) {
            this.f10710a = i;
            this.f10711b = i2;
            this.f10712c = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f10710a == aVar.f10710a && this.f10711b == aVar.f10711b && TextUtils.equals(this.f10712c, aVar.f10712c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = ((this.f10710a * 31) + this.f10711b) * 31;
            String str = this.f10712c;
            return i + (str != null ? str.hashCode() : 0);
        }
    }
}
