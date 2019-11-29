package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<e> f2875a = new Comparator<e>() {
        /* renamed from: a */
        public int compare(e eVar, e eVar2) {
            int i = eVar.f2890a - eVar2.f2890a;
            return i == 0 ? eVar.f2891b - eVar2.f2891b : i;
        }
    };

    public static abstract class a {
        public abstract int a();

        public abstract boolean a(int i, int i2);

        public abstract int b();

        public abstract boolean b(int i, int i2);

        public Object c(int i, int i2) {
            return null;
        }
    }

    public static b a(a aVar) {
        return a(aVar, true);
    }

    public static b a(a aVar, boolean z) {
        int a2 = aVar.a();
        int b2 = aVar.b();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new d(0, a2, 0, b2));
        int abs = Math.abs(a2 - b2) + a2 + b2;
        int i = abs * 2;
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            d dVar = (d) arrayList2.remove(arrayList2.size() - 1);
            e a3 = a(aVar, dVar.f2886a, dVar.f2887b, dVar.f2888c, dVar.f2889d, iArr, iArr2, abs);
            if (a3 != null) {
                if (a3.f2892c > 0) {
                    arrayList.add(a3);
                }
                a3.f2890a += dVar.f2886a;
                a3.f2891b += dVar.f2888c;
                d dVar2 = arrayList3.isEmpty() ? new d() : (d) arrayList3.remove(arrayList3.size() - 1);
                dVar2.f2886a = dVar.f2886a;
                dVar2.f2888c = dVar.f2888c;
                if (a3.f2894e) {
                    dVar2.f2887b = a3.f2890a;
                    dVar2.f2889d = a3.f2891b;
                } else if (a3.f2893d) {
                    dVar2.f2887b = a3.f2890a - 1;
                    dVar2.f2889d = a3.f2891b;
                } else {
                    dVar2.f2887b = a3.f2890a;
                    dVar2.f2889d = a3.f2891b - 1;
                }
                arrayList2.add(dVar2);
                if (!a3.f2894e) {
                    dVar.f2886a = a3.f2890a + a3.f2892c;
                    dVar.f2888c = a3.f2891b + a3.f2892c;
                } else if (a3.f2893d) {
                    dVar.f2886a = a3.f2890a + a3.f2892c + 1;
                    dVar.f2888c = a3.f2891b + a3.f2892c;
                } else {
                    dVar.f2886a = a3.f2890a + a3.f2892c;
                    dVar.f2888c = a3.f2891b + a3.f2892c + 1;
                }
                arrayList2.add(dVar);
            } else {
                arrayList3.add(dVar);
            }
        }
        Collections.sort(arrayList, f2875a);
        return new b(aVar, arrayList, iArr, iArr2, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        if (r1[r13 - 1] < r1[r13 + r5]) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ba, code lost:
        if (r2[r13 - 1] < r2[r13 + 1]) goto L_0x00c7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.recyclerview.widget.f.e a(androidx.recyclerview.widget.f.a r19, int r20, int r21, int r22, int r23, int[] r24, int[] r25, int r26) {
        /*
            r0 = r19
            r1 = r24
            r2 = r25
            int r3 = r21 - r20
            int r4 = r23 - r22
            r5 = 1
            if (r3 < r5) goto L_0x0133
            if (r4 >= r5) goto L_0x0011
            goto L_0x0133
        L_0x0011:
            int r6 = r3 - r4
            int r7 = r3 + r4
            int r7 = r7 + r5
            int r7 = r7 / 2
            int r8 = r26 - r7
            int r8 = r8 - r5
            int r9 = r26 + r7
            int r9 = r9 + r5
            r10 = 0
            java.util.Arrays.fill(r1, r8, r9, r10)
            int r8 = r8 + r6
            int r9 = r9 + r6
            java.util.Arrays.fill(r2, r8, r9, r3)
            int r8 = r6 % 2
            if (r8 == 0) goto L_0x002d
            r8 = 1
            goto L_0x002e
        L_0x002d:
            r8 = 0
        L_0x002e:
            r9 = 0
        L_0x002f:
            if (r9 > r7) goto L_0x012b
            int r11 = -r9
            r12 = r11
        L_0x0033:
            if (r12 > r9) goto L_0x00a2
            if (r12 == r11) goto L_0x004d
            if (r12 == r9) goto L_0x0045
            int r13 = r26 + r12
            int r14 = r13 + -1
            r14 = r1[r14]
            int r13 = r13 + r5
            r13 = r1[r13]
            if (r14 >= r13) goto L_0x0045
            goto L_0x004d
        L_0x0045:
            int r13 = r26 + r12
            int r13 = r13 - r5
            r13 = r1[r13]
            int r13 = r13 + r5
            r14 = 1
            goto L_0x0053
        L_0x004d:
            int r13 = r26 + r12
            int r13 = r13 + r5
            r13 = r1[r13]
            r14 = 0
        L_0x0053:
            int r15 = r13 - r12
        L_0x0055:
            if (r13 >= r3) goto L_0x006a
            if (r15 >= r4) goto L_0x006a
            int r10 = r20 + r13
            int r5 = r22 + r15
            boolean r5 = r0.a(r10, r5)
            if (r5 == 0) goto L_0x006a
            int r13 = r13 + 1
            int r15 = r15 + 1
            r5 = 1
            r10 = 0
            goto L_0x0055
        L_0x006a:
            int r5 = r26 + r12
            r1[r5] = r13
            if (r8 == 0) goto L_0x009c
            int r10 = r6 - r9
            r13 = 1
            int r10 = r10 + r13
            if (r12 < r10) goto L_0x009c
            int r10 = r6 + r9
            int r10 = r10 - r13
            if (r12 > r10) goto L_0x009c
            r10 = r1[r5]
            r13 = r2[r5]
            if (r10 < r13) goto L_0x009c
            androidx.recyclerview.widget.f$e r0 = new androidx.recyclerview.widget.f$e
            r0.<init>()
            r3 = r2[r5]
            r0.f2890a = r3
            int r3 = r0.f2890a
            int r3 = r3 - r12
            r0.f2891b = r3
            r1 = r1[r5]
            r2 = r2[r5]
            int r1 = r1 - r2
            r0.f2892c = r1
            r0.f2893d = r14
            r5 = 0
            r0.f2894e = r5
            return r0
        L_0x009c:
            r5 = 0
            int r12 = r12 + 2
            r5 = 1
            r10 = 0
            goto L_0x0033
        L_0x00a2:
            r5 = 0
            r10 = r11
        L_0x00a4:
            if (r10 > r9) goto L_0x0120
            int r12 = r10 + r6
            int r13 = r9 + r6
            if (r12 == r13) goto L_0x00c6
            int r13 = r11 + r6
            if (r12 == r13) goto L_0x00bd
            int r13 = r26 + r12
            int r14 = r13 + -1
            r14 = r2[r14]
            r15 = 1
            int r13 = r13 + r15
            r13 = r2[r13]
            if (r14 >= r13) goto L_0x00be
            goto L_0x00c7
        L_0x00bd:
            r15 = 1
        L_0x00be:
            int r13 = r26 + r12
            int r13 = r13 + r15
            r13 = r2[r13]
            int r13 = r13 - r15
            r14 = 1
            goto L_0x00cd
        L_0x00c6:
            r15 = 1
        L_0x00c7:
            int r13 = r26 + r12
            int r13 = r13 - r15
            r13 = r2[r13]
            r14 = 0
        L_0x00cd:
            int r16 = r13 - r12
        L_0x00cf:
            if (r13 <= 0) goto L_0x00ec
            if (r16 <= 0) goto L_0x00ec
            int r17 = r20 + r13
            int r5 = r17 + -1
            int r17 = r22 + r16
            r18 = r3
            int r3 = r17 + -1
            boolean r3 = r0.a(r5, r3)
            if (r3 == 0) goto L_0x00ee
            int r13 = r13 + -1
            int r16 = r16 + -1
            r3 = r18
            r5 = 0
            r15 = 1
            goto L_0x00cf
        L_0x00ec:
            r18 = r3
        L_0x00ee:
            int r3 = r26 + r12
            r2[r3] = r13
            if (r8 != 0) goto L_0x0119
            if (r12 < r11) goto L_0x0119
            if (r12 > r9) goto L_0x0119
            r5 = r1[r3]
            r13 = r2[r3]
            if (r5 < r13) goto L_0x0119
            androidx.recyclerview.widget.f$e r0 = new androidx.recyclerview.widget.f$e
            r0.<init>()
            r4 = r2[r3]
            r0.f2890a = r4
            int r4 = r0.f2890a
            int r4 = r4 - r12
            r0.f2891b = r4
            r1 = r1[r3]
            r2 = r2[r3]
            int r1 = r1 - r2
            r0.f2892c = r1
            r0.f2893d = r14
            r3 = 1
            r0.f2894e = r3
            return r0
        L_0x0119:
            r3 = 1
            int r10 = r10 + 2
            r3 = r18
            r5 = 0
            goto L_0x00a4
        L_0x0120:
            r18 = r3
            r3 = 1
            int r9 = r9 + 1
            r3 = r18
            r5 = 1
            r10 = 0
            goto L_0x002f
        L_0x012b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation."
            r0.<init>(r1)
            throw r0
        L_0x0133:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.f.a(androidx.recyclerview.widget.f$a, int, int, int, int, int[], int[], int):androidx.recyclerview.widget.f$e");
    }

    static class e {

        /* renamed from: a  reason: collision with root package name */
        int f2890a;

        /* renamed from: b  reason: collision with root package name */
        int f2891b;

        /* renamed from: c  reason: collision with root package name */
        int f2892c;

        /* renamed from: d  reason: collision with root package name */
        boolean f2893d;

        /* renamed from: e  reason: collision with root package name */
        boolean f2894e;

        e() {
        }
    }

    static class d {

        /* renamed from: a  reason: collision with root package name */
        int f2886a;

        /* renamed from: b  reason: collision with root package name */
        int f2887b;

        /* renamed from: c  reason: collision with root package name */
        int f2888c;

        /* renamed from: d  reason: collision with root package name */
        int f2889d;

        public d() {
        }

        public d(int i, int i2, int i3, int i4) {
            this.f2886a = i;
            this.f2887b = i2;
            this.f2888c = i3;
            this.f2889d = i4;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final List<e> f2876a;

        /* renamed from: b  reason: collision with root package name */
        private final int[] f2877b;

        /* renamed from: c  reason: collision with root package name */
        private final int[] f2878c;

        /* renamed from: d  reason: collision with root package name */
        private final a f2879d;

        /* renamed from: e  reason: collision with root package name */
        private final int f2880e;

        /* renamed from: f  reason: collision with root package name */
        private final int f2881f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f2882g;

        b(a aVar, List<e> list, int[] iArr, int[] iArr2, boolean z) {
            this.f2876a = list;
            this.f2877b = iArr;
            this.f2878c = iArr2;
            Arrays.fill(this.f2877b, 0);
            Arrays.fill(this.f2878c, 0);
            this.f2879d = aVar;
            this.f2880e = aVar.a();
            this.f2881f = aVar.b();
            this.f2882g = z;
            a();
            b();
        }

        private void a() {
            e eVar = this.f2876a.isEmpty() ? null : this.f2876a.get(0);
            if (eVar == null || eVar.f2890a != 0 || eVar.f2891b != 0) {
                e eVar2 = new e();
                eVar2.f2890a = 0;
                eVar2.f2891b = 0;
                eVar2.f2893d = false;
                eVar2.f2892c = 0;
                eVar2.f2894e = false;
                this.f2876a.add(0, eVar2);
            }
        }

        private void b() {
            int i = this.f2880e;
            int i2 = this.f2881f;
            for (int size = this.f2876a.size() - 1; size >= 0; size--) {
                e eVar = this.f2876a.get(size);
                int i3 = eVar.f2890a + eVar.f2892c;
                int i4 = eVar.f2891b + eVar.f2892c;
                if (this.f2882g) {
                    while (i > i3) {
                        a(i, i2, size);
                        i--;
                    }
                    while (i2 > i4) {
                        b(i, i2, size);
                        i2--;
                    }
                }
                for (int i5 = 0; i5 < eVar.f2892c; i5++) {
                    int i6 = eVar.f2890a + i5;
                    int i7 = eVar.f2891b + i5;
                    int i8 = this.f2879d.b(i6, i7) ? 1 : 2;
                    this.f2877b[i6] = (i7 << 5) | i8;
                    this.f2878c[i7] = (i6 << 5) | i8;
                }
                i = eVar.f2890a;
                i2 = eVar.f2891b;
            }
        }

        private void a(int i, int i2, int i3) {
            if (this.f2877b[i - 1] == 0) {
                a(i, i2, i3, false);
            }
        }

        private void b(int i, int i2, int i3) {
            if (this.f2878c[i2 - 1] == 0) {
                a(i, i2, i3, true);
            }
        }

        private boolean a(int i, int i2, int i3, boolean z) {
            int i4;
            int i5;
            if (z) {
                i2--;
                i5 = i;
                i4 = i2;
            } else {
                i5 = i - 1;
                i4 = i5;
            }
            while (i3 >= 0) {
                e eVar = this.f2876a.get(i3);
                int i6 = eVar.f2890a + eVar.f2892c;
                int i7 = eVar.f2891b + eVar.f2892c;
                int i8 = 8;
                if (z) {
                    for (int i9 = i5 - 1; i9 >= i6; i9--) {
                        if (this.f2879d.a(i9, i4)) {
                            if (!this.f2879d.b(i9, i4)) {
                                i8 = 4;
                            }
                            this.f2878c[i4] = (i9 << 5) | 16;
                            this.f2877b[i9] = (i4 << 5) | i8;
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (int i10 = i2 - 1; i10 >= i7; i10--) {
                        if (this.f2879d.a(i4, i10)) {
                            if (!this.f2879d.b(i4, i10)) {
                                i8 = 4;
                            }
                            int i11 = i - 1;
                            this.f2877b[i11] = (i10 << 5) | 16;
                            this.f2878c[i10] = (i11 << 5) | i8;
                            return true;
                        }
                    }
                    continue;
                }
                i5 = eVar.f2890a;
                i2 = eVar.f2891b;
                i3--;
            }
            return false;
        }

        public void a(RecyclerView.a aVar) {
            a((n) new b(aVar));
        }

        public void a(n nVar) {
            c cVar;
            if (nVar instanceof c) {
                cVar = (c) nVar;
            } else {
                cVar = new c(nVar);
            }
            ArrayList arrayList = new ArrayList();
            int i = this.f2880e;
            int i2 = this.f2881f;
            for (int size = this.f2876a.size() - 1; size >= 0; size--) {
                e eVar = this.f2876a.get(size);
                int i3 = eVar.f2892c;
                int i4 = eVar.f2890a + i3;
                int i5 = eVar.f2891b + i3;
                if (i4 < i) {
                    b(arrayList, cVar, i4, i - i4, i4);
                }
                if (i5 < i2) {
                    a(arrayList, cVar, i4, i2 - i5, i5);
                }
                for (int i6 = i3 - 1; i6 >= 0; i6--) {
                    if ((this.f2877b[eVar.f2890a + i6] & 31) == 2) {
                        cVar.a(eVar.f2890a + i6, 1, this.f2879d.c(eVar.f2890a + i6, eVar.f2891b + i6));
                    }
                }
                i = eVar.f2890a;
                i2 = eVar.f2891b;
            }
            cVar.a();
        }

        private static c a(List<c> list, int i, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                c cVar = list.get(size);
                if (cVar.f2883a == i && cVar.f2885c == z) {
                    list.remove(size);
                    while (size < list.size()) {
                        list.get(size).f2884b += z ? 1 : -1;
                        size++;
                    }
                    return cVar;
                }
                size--;
            }
            return null;
        }

        private void a(List<c> list, n nVar, int i, int i2, int i3) {
            if (!this.f2882g) {
                nVar.a(i, i2);
                return;
            }
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                int i5 = i3 + i4;
                int i6 = this.f2878c[i5] & 31;
                if (i6 == 0) {
                    nVar.a(i, 1);
                    for (c cVar : list) {
                        cVar.f2884b++;
                    }
                } else if (i6 == 4 || i6 == 8) {
                    int i7 = this.f2878c[i5] >> 5;
                    nVar.c(a(list, i7, true).f2884b, i);
                    if (i6 == 4) {
                        nVar.a(i, 1, this.f2879d.c(i7, i5));
                    }
                } else if (i6 == 16) {
                    list.add(new c(i5, i, false));
                } else {
                    throw new IllegalStateException("unknown flag for pos " + i5 + SQLBuilder.BLANK + Long.toBinaryString((long) i6));
                }
            }
        }

        private void b(List<c> list, n nVar, int i, int i2, int i3) {
            if (!this.f2882g) {
                nVar.b(i, i2);
                return;
            }
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                int i5 = i3 + i4;
                int i6 = this.f2877b[i5] & 31;
                if (i6 == 0) {
                    nVar.b(i + i4, 1);
                    for (c cVar : list) {
                        cVar.f2884b--;
                    }
                } else if (i6 == 4 || i6 == 8) {
                    int i7 = this.f2877b[i5] >> 5;
                    c a2 = a(list, i7, false);
                    nVar.c(i + i4, a2.f2884b - 1);
                    if (i6 == 4) {
                        nVar.a(a2.f2884b - 1, 1, this.f2879d.c(i5, i7));
                    }
                } else if (i6 == 16) {
                    list.add(new c(i5, i + i4, true));
                } else {
                    throw new IllegalStateException("unknown flag for pos " + i5 + SQLBuilder.BLANK + Long.toBinaryString((long) i6));
                }
            }
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        int f2883a;

        /* renamed from: b  reason: collision with root package name */
        int f2884b;

        /* renamed from: c  reason: collision with root package name */
        boolean f2885c;

        public c(int i, int i2, boolean z) {
            this.f2883a = i;
            this.f2884b = i2;
            this.f2885c = z;
        }
    }
}
