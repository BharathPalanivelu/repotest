package com.google.android.exoplayer2.q;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.q.f;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.t;
import com.google.android.exoplayer2.u;
import java.util.Arrays;
import java.util.Map;

public abstract class e extends h {

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray<Map<p, b>> f11271a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private final SparseBooleanArray f11272b = new SparseBooleanArray();

    /* renamed from: c  reason: collision with root package name */
    private int f11273c = 0;

    /* renamed from: d  reason: collision with root package name */
    private a f11274d;

    /* access modifiers changed from: protected */
    public abstract f[] a(t[] tVarArr, p[] pVarArr, int[][][] iArr) throws com.google.android.exoplayer2.e;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f11275a;

        /* renamed from: b  reason: collision with root package name */
        private final int[] f11276b;

        /* renamed from: c  reason: collision with root package name */
        private final p[] f11277c;

        /* renamed from: d  reason: collision with root package name */
        private final int[] f11278d;

        /* renamed from: e  reason: collision with root package name */
        private final int[][][] f11279e;

        /* renamed from: f  reason: collision with root package name */
        private final p f11280f;

        a(int[] iArr, p[] pVarArr, int[] iArr2, int[][][] iArr3, p pVar) {
            this.f11276b = iArr;
            this.f11277c = pVarArr;
            this.f11279e = iArr3;
            this.f11278d = iArr2;
            this.f11280f = pVar;
            this.f11275a = pVarArr.length;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final f.a f11281a;

        /* renamed from: b  reason: collision with root package name */
        public final int f11282b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f11283c;

        public f a(p pVar) {
            return this.f11281a.b(pVar.a(this.f11282b), this.f11283c);
        }
    }

    public final boolean a(int i, p pVar) {
        Map map = this.f11271a.get(i);
        return map != null && map.containsKey(pVar);
    }

    public final i a(t[] tVarArr, p pVar) throws com.google.android.exoplayer2.e {
        int[] iArr;
        int[] iArr2 = new int[(tVarArr.length + 1)];
        o[][] oVarArr = new o[(tVarArr.length + 1)][];
        int[][][] iArr3 = new int[(tVarArr.length + 1)][][];
        for (int i = 0; i < oVarArr.length; i++) {
            oVarArr[i] = new o[pVar.f12118b];
            iArr3[i] = new int[pVar.f12118b][];
        }
        int[] a2 = a(tVarArr);
        for (int i2 = 0; i2 < pVar.f12118b; i2++) {
            o a3 = pVar.a(i2);
            int a4 = a(tVarArr, a3);
            if (a4 == tVarArr.length) {
                iArr = new int[a3.f12114a];
            } else {
                iArr = a(tVarArr[a4], a3);
            }
            int i3 = iArr2[a4];
            oVarArr[a4][i3] = a3;
            iArr3[a4][i3] = iArr;
            iArr2[a4] = iArr2[a4] + 1;
        }
        p[] pVarArr = new p[tVarArr.length];
        int[] iArr4 = new int[tVarArr.length];
        for (int i4 = 0; i4 < tVarArr.length; i4++) {
            int i5 = iArr2[i4];
            pVarArr[i4] = new p((o[]) Arrays.copyOf(oVarArr[i4], i5));
            iArr3[i4] = (int[][]) Arrays.copyOf(iArr3[i4], i5);
            iArr4[i4] = tVarArr[i4].a();
        }
        p pVar2 = new p((o[]) Arrays.copyOf(oVarArr[tVarArr.length], iArr2[tVarArr.length]));
        f[] a5 = a(tVarArr, pVarArr, iArr3);
        int i6 = 0;
        while (true) {
            f fVar = null;
            if (i6 >= tVarArr.length) {
                break;
            }
            if (this.f11272b.get(i6)) {
                a5[i6] = null;
            } else {
                p pVar3 = pVarArr[i6];
                if (a(i6, pVar3)) {
                    b bVar = (b) this.f11271a.get(i6).get(pVar3);
                    if (bVar != null) {
                        fVar = bVar.a(pVar3);
                    }
                    a5[i6] = fVar;
                }
            }
            i6++;
        }
        a aVar = new a(iArr4, pVarArr, a2, iArr3, pVar2);
        u[] uVarArr = new u[tVarArr.length];
        for (int i7 = 0; i7 < tVarArr.length; i7++) {
            uVarArr[i7] = a5[i7] != null ? u.f12191a : null;
        }
        a(tVarArr, pVarArr, iArr3, uVarArr, a5, this.f11273c);
        return new i(pVar, new g(a5), aVar, uVarArr);
    }

    public final void a(Object obj) {
        this.f11274d = (a) obj;
    }

    private static int a(t[] tVarArr, o oVar) throws com.google.android.exoplayer2.e {
        int length = tVarArr.length;
        int i = 0;
        int i2 = 0;
        while (i < tVarArr.length) {
            t tVar = tVarArr[i];
            int i3 = i2;
            int i4 = length;
            for (int i5 = 0; i5 < oVar.f12114a; i5++) {
                int a2 = tVar.a(oVar.a(i5)) & 7;
                if (a2 > i3) {
                    if (a2 == 4) {
                        return i;
                    }
                    i4 = i;
                    i3 = a2;
                }
            }
            i++;
            length = i4;
            i2 = i3;
        }
        return length;
    }

    private static int[] a(t tVar, o oVar) throws com.google.android.exoplayer2.e {
        int[] iArr = new int[oVar.f12114a];
        for (int i = 0; i < oVar.f12114a; i++) {
            iArr[i] = tVar.a(oVar.a(i));
        }
        return iArr;
    }

    private static int[] a(t[] tVarArr) throws com.google.android.exoplayer2.e {
        int[] iArr = new int[tVarArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = tVarArr[i].m();
        }
        return iArr;
    }

    private static void a(t[] tVarArr, p[] pVarArr, int[][][] iArr, u[] uVarArr, f[] fVarArr, int i) {
        boolean z;
        if (i != 0) {
            boolean z2 = false;
            int i2 = 0;
            int i3 = -1;
            int i4 = -1;
            while (true) {
                if (i2 >= tVarArr.length) {
                    z = true;
                    break;
                }
                int a2 = tVarArr[i2].a();
                f fVar = fVarArr[i2];
                if ((a2 == 1 || a2 == 2) && fVar != null && a(iArr[i2], pVarArr[i2], fVar)) {
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
                u uVar = new u(i);
                uVarArr[i4] = uVar;
                uVarArr[i3] = uVar;
            }
        }
    }

    private static boolean a(int[][] iArr, p pVar, f fVar) {
        if (fVar == null) {
            return false;
        }
        int a2 = pVar.a(fVar.d());
        for (int i = 0; i < fVar.e(); i++) {
            if ((iArr[a2][fVar.b(i)] & 32) != 32) {
                return false;
            }
        }
        return true;
    }
}
