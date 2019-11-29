package com.google.zxing.d.a;

import com.google.zxing.d.q;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;

public abstract class a extends q {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f14530a = new int[4];

    /* renamed from: b  reason: collision with root package name */
    private final int[] f14531b = new int[8];

    /* renamed from: c  reason: collision with root package name */
    private final float[] f14532c = new float[4];

    /* renamed from: d  reason: collision with root package name */
    private final float[] f14533d = new float[4];

    /* renamed from: e  reason: collision with root package name */
    private final int[] f14534e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f14535f;

    protected a() {
        int[] iArr = this.f14531b;
        this.f14534e = new int[(iArr.length / 2)];
        this.f14535f = new int[(iArr.length / 2)];
    }

    /* access modifiers changed from: protected */
    public final int[] b() {
        return this.f14530a;
    }

    /* access modifiers changed from: protected */
    public final int[] c() {
        return this.f14531b;
    }

    /* access modifiers changed from: protected */
    public final float[] d() {
        return this.f14532c;
    }

    /* access modifiers changed from: protected */
    public final float[] e() {
        return this.f14533d;
    }

    /* access modifiers changed from: protected */
    public final int[] f() {
        return this.f14534e;
    }

    /* access modifiers changed from: protected */
    public final int[] g() {
        return this.f14535f;
    }

    protected static int a(int[] iArr, int[][] iArr2) throws com.google.zxing.q {
        for (int i = 0; i < iArr2.length; i++) {
            if (a(iArr, iArr2[i], 0.45f) < 0.2f) {
                return i;
            }
        }
        throw com.google.zxing.q.a();
    }

    protected static int a(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        return i;
    }

    protected static void a(int[] iArr, float[] fArr) {
        float f2 = fArr[0];
        int i = 0;
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] > f2) {
                f2 = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] + 1;
    }

    protected static void b(int[] iArr, float[] fArr) {
        float f2 = fArr[0];
        int i = 0;
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] < f2) {
                f2 = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] - 1;
    }

    protected static boolean b(int[] iArr) {
        int i = iArr[0] + iArr[1];
        float f2 = ((float) i) / ((float) ((iArr[2] + i) + iArr[3]));
        if (f2 < 0.7916667f || f2 > 0.89285713f) {
            return false;
        }
        int i2 = RNCartPanelDataEntity.NULL_VALUE;
        int i3 = Integer.MAX_VALUE;
        for (int i4 : iArr) {
            if (i4 > i2) {
                i2 = i4;
            }
            if (i4 < i3) {
                i3 = i4;
            }
        }
        if (i2 < i3 * 10) {
            return true;
        }
        return false;
    }
}
