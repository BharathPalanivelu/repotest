package com.google.android.exoplayer2.l;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.ac;
import com.google.android.exoplayer2.an;
import com.google.android.exoplayer2.ao;
import com.google.android.exoplayer2.l.f;
import com.google.android.exoplayer2.n.t;
import com.google.android.exoplayer2.source.ad;
import java.util.Arrays;
import java.util.Map;

public abstract class e extends h {

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray<Map<ad, b>> f10722a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private final SparseBooleanArray f10723b = new SparseBooleanArray();

    /* renamed from: c  reason: collision with root package name */
    private int f10724c = 0;

    /* renamed from: d  reason: collision with root package name */
    private a f10725d;

    /* access modifiers changed from: protected */
    public abstract f[] a(an[] anVarArr, ad[] adVarArr, int[][][] iArr) throws ac;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final f.a f10732a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10733b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f10734c;

        public f a(ad adVar) {
            return this.f10732a.b(adVar.a(this.f10733b), this.f10734c);
        }
    }

    public final a a() {
        return this.f10725d;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: com.google.android.exoplayer2.l.e$b} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.exoplayer2.l.i a(com.google.android.exoplayer2.an[] r14, com.google.android.exoplayer2.source.ad r15) throws com.google.android.exoplayer2.ac {
        /*
            r13 = this;
            int r0 = r14.length
            int r0 = r0 + 1
            int[] r0 = new int[r0]
            int r1 = r14.length
            int r1 = r1 + 1
            com.google.android.exoplayer2.source.ac[][] r1 = new com.google.android.exoplayer2.source.ac[r1][]
            int r2 = r14.length
            int r2 = r2 + 1
            int[][][] r2 = new int[r2][][]
            r9 = 0
            r3 = 0
        L_0x0011:
            int r4 = r1.length
            if (r3 >= r4) goto L_0x0023
            int r4 = r15.f11538b
            com.google.android.exoplayer2.source.ac[] r4 = new com.google.android.exoplayer2.source.ac[r4]
            r1[r3] = r4
            int r4 = r15.f11538b
            int[][] r4 = new int[r4][]
            r2[r3] = r4
            int r3 = r3 + 1
            goto L_0x0011
        L_0x0023:
            int[] r6 = a((com.google.android.exoplayer2.an[]) r14)
            r3 = 0
        L_0x0028:
            int r4 = r15.f11538b
            if (r3 >= r4) goto L_0x0055
            com.google.android.exoplayer2.source.ac r4 = r15.a((int) r3)
            int r5 = a((com.google.android.exoplayer2.an[]) r14, (com.google.android.exoplayer2.source.ac) r4)
            int r7 = r14.length
            if (r5 != r7) goto L_0x003c
            int r7 = r4.f11534a
            int[] r7 = new int[r7]
            goto L_0x0042
        L_0x003c:
            r7 = r14[r5]
            int[] r7 = a((com.google.android.exoplayer2.an) r7, (com.google.android.exoplayer2.source.ac) r4)
        L_0x0042:
            r8 = r0[r5]
            r10 = r1[r5]
            r10[r8] = r4
            r4 = r2[r5]
            r4[r8] = r7
            r4 = r0[r5]
            int r4 = r4 + 1
            r0[r5] = r4
            int r3 = r3 + 1
            goto L_0x0028
        L_0x0055:
            int r3 = r14.length
            com.google.android.exoplayer2.source.ad[] r10 = new com.google.android.exoplayer2.source.ad[r3]
            int r3 = r14.length
            int[] r4 = new int[r3]
            r3 = 0
        L_0x005c:
            int r5 = r14.length
            if (r3 >= r5) goto L_0x0085
            r5 = r0[r3]
            com.google.android.exoplayer2.source.ad r7 = new com.google.android.exoplayer2.source.ad
            r8 = r1[r3]
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r5)
            com.google.android.exoplayer2.source.ac[] r8 = (com.google.android.exoplayer2.source.ac[]) r8
            r7.<init>(r8)
            r10[r3] = r7
            r7 = r2[r3]
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r7, r5)
            int[][] r5 = (int[][]) r5
            r2[r3] = r5
            r5 = r14[r3]
            int r5 = r5.a()
            r4[r3] = r5
            int r3 = r3 + 1
            goto L_0x005c
        L_0x0085:
            int r3 = r14.length
            r0 = r0[r3]
            com.google.android.exoplayer2.source.ad r8 = new com.google.android.exoplayer2.source.ad
            int r3 = r14.length
            r1 = r1[r3]
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r1, r0)
            com.google.android.exoplayer2.source.ac[] r0 = (com.google.android.exoplayer2.source.ac[]) r0
            r8.<init>(r0)
            com.google.android.exoplayer2.l.f[] r0 = r13.a((com.google.android.exoplayer2.an[]) r14, (com.google.android.exoplayer2.source.ad[]) r10, (int[][][]) r2)
            r1 = 0
        L_0x009b:
            int r3 = r14.length
            r11 = 0
            if (r1 >= r3) goto L_0x00c9
            android.util.SparseBooleanArray r3 = r13.f10723b
            boolean r3 = r3.get(r1)
            if (r3 == 0) goto L_0x00aa
            r0[r1] = r11
            goto L_0x00c6
        L_0x00aa:
            r3 = r10[r1]
            android.util.SparseArray<java.util.Map<com.google.android.exoplayer2.source.ad, com.google.android.exoplayer2.l.e$b>> r5 = r13.f10722a
            java.lang.Object r5 = r5.get(r1)
            java.util.Map r5 = (java.util.Map) r5
            if (r5 != 0) goto L_0x00b7
            goto L_0x00be
        L_0x00b7:
            java.lang.Object r5 = r5.get(r3)
            r11 = r5
            com.google.android.exoplayer2.l.e$b r11 = (com.google.android.exoplayer2.l.e.b) r11
        L_0x00be:
            if (r11 == 0) goto L_0x00c6
            com.google.android.exoplayer2.l.f r3 = r11.a(r3)
            r0[r1] = r3
        L_0x00c6:
            int r1 = r1 + 1
            goto L_0x009b
        L_0x00c9:
            com.google.android.exoplayer2.l.e$a r1 = new com.google.android.exoplayer2.l.e$a
            r3 = r1
            r5 = r10
            r7 = r2
            r3.<init>(r4, r5, r6, r7, r8)
            int r3 = r14.length
            com.google.android.exoplayer2.ao[] r12 = new com.google.android.exoplayer2.ao[r3]
        L_0x00d4:
            int r3 = r14.length
            if (r9 >= r3) goto L_0x00e4
            r3 = r0[r9]
            if (r3 == 0) goto L_0x00de
            com.google.android.exoplayer2.ao r3 = com.google.android.exoplayer2.ao.f9112a
            goto L_0x00df
        L_0x00de:
            r3 = r11
        L_0x00df:
            r12[r9] = r3
            int r9 = r9 + 1
            goto L_0x00d4
        L_0x00e4:
            int r8 = r13.f10724c
            r3 = r14
            r4 = r10
            r5 = r2
            r6 = r12
            r7 = r0
            a(r3, r4, r5, r6, r7, r8)
            com.google.android.exoplayer2.l.i r14 = new com.google.android.exoplayer2.l.i
            com.google.android.exoplayer2.l.g r2 = new com.google.android.exoplayer2.l.g
            r2.<init>(r0)
            r14.<init>(r15, r2, r1, r12)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.l.e.a(com.google.android.exoplayer2.an[], com.google.android.exoplayer2.source.ad):com.google.android.exoplayer2.l.i");
    }

    public final void a(Object obj) {
        this.f10725d = (a) obj;
    }

    private static int a(an[] anVarArr, com.google.android.exoplayer2.source.ac acVar) throws ac {
        int length = anVarArr.length;
        int i = 0;
        int i2 = 0;
        while (i < anVarArr.length) {
            an anVar = anVarArr[i];
            int i3 = i2;
            int i4 = length;
            for (int i5 = 0; i5 < acVar.f11534a; i5++) {
                int b2 = anVar.b(acVar.a(i5)) & 3;
                if (b2 > i3) {
                    if (b2 == 3) {
                        return i;
                    }
                    i4 = i;
                    i3 = b2;
                }
            }
            i++;
            length = i4;
            i2 = i3;
        }
        return length;
    }

    private static int[] a(an anVar, com.google.android.exoplayer2.source.ac acVar) throws ac {
        int[] iArr = new int[acVar.f11534a];
        for (int i = 0; i < acVar.f11534a; i++) {
            iArr[i] = anVar.b(acVar.a(i));
        }
        return iArr;
    }

    private static int[] a(an[] anVarArr) throws ac {
        int[] iArr = new int[anVarArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = anVarArr[i].m();
        }
        return iArr;
    }

    private static void a(an[] anVarArr, ad[] adVarArr, int[][][] iArr, ao[] aoVarArr, f[] fVarArr, int i) {
        boolean z;
        if (i != 0) {
            boolean z2 = false;
            int i2 = 0;
            int i3 = -1;
            int i4 = -1;
            while (true) {
                if (i2 >= anVarArr.length) {
                    z = true;
                    break;
                }
                int a2 = anVarArr[i2].a();
                f fVar = fVarArr[i2];
                if ((a2 == 1 || a2 == 2) && fVar != null && a(iArr[i2], adVarArr[i2], fVar)) {
                    if (a2 == 1) {
                        if (i4 != -1) {
                            break;
                        }
                        i4 = i2;
                    } else if (i3 != -1) {
                        break;
                    } else {
                        i3 = i2;
                    }
                }
                i2++;
            }
            z = false;
            if (!(i4 == -1 || i3 == -1)) {
                z2 = true;
            }
            if (z && z2) {
                ao aoVar = new ao(i);
                aoVarArr[i4] = aoVar;
                aoVarArr[i3] = aoVar;
            }
        }
    }

    private static boolean a(int[][] iArr, ad adVar, f fVar) {
        if (fVar == null) {
            return false;
        }
        int a2 = adVar.a(fVar.d());
        for (int i = 0; i < fVar.e(); i++) {
            if ((iArr[a2][fVar.b(i)] & 16) != 16) {
                return false;
            }
        }
        return true;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f10726a;

        /* renamed from: b  reason: collision with root package name */
        private final int[] f10727b;

        /* renamed from: c  reason: collision with root package name */
        private final ad[] f10728c;

        /* renamed from: d  reason: collision with root package name */
        private final int[] f10729d;

        /* renamed from: e  reason: collision with root package name */
        private final int[][][] f10730e;

        /* renamed from: f  reason: collision with root package name */
        private final ad f10731f;

        a(int[] iArr, ad[] adVarArr, int[] iArr2, int[][][] iArr3, ad adVar) {
            this.f10727b = iArr;
            this.f10728c = adVarArr;
            this.f10730e = iArr3;
            this.f10729d = iArr2;
            this.f10731f = adVar;
            this.f10726a = adVarArr.length;
        }

        public ad a(int i) {
            return this.f10728c[i];
        }

        public int a(int i, int i2, int i3) {
            return this.f10730e[i][i2][i3] & 3;
        }

        public int a(int i, int i2, boolean z) {
            int i3 = this.f10728c[i].a(i2).f11534a;
            int[] iArr = new int[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                int a2 = a(i, i2, i5);
                if (a2 == 3 || (z && a2 == 2)) {
                    iArr[i4] = i5;
                    i4++;
                }
            }
            return a(i, i2, Arrays.copyOf(iArr, i4));
        }

        public int a(int i, int i2, int[] iArr) {
            int i3 = 0;
            String str = null;
            boolean z = false;
            int i4 = 0;
            int i5 = 8;
            while (i3 < iArr.length) {
                String str2 = this.f10728c[i].a(i2).a(iArr[i3]).f10427f;
                int i6 = i4 + 1;
                if (i4 == 0) {
                    str = str2;
                } else {
                    z |= !t.a((Object) str, (Object) str2);
                }
                i5 = Math.min(i5, this.f10730e[i][i2][i3] & 12);
                i3++;
                i4 = i6;
            }
            return z ? Math.min(i5, this.f10729d[i]) : i5;
        }

        public ad a() {
            return this.f10731f;
        }
    }
}
