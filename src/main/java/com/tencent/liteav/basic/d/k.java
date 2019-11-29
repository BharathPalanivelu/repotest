package com.tencent.liteav.basic.d;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class k {

    /* renamed from: a  reason: collision with root package name */
    public static final float[] f31347a = {BitmapDescriptorFactory.HUE_RED, 1.0f, 1.0f, 1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED};

    /* renamed from: b  reason: collision with root package name */
    public static final float[] f31348b = {1.0f, 1.0f, 1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};

    /* renamed from: c  reason: collision with root package name */
    public static final float[] f31349c = {1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, 1.0f, BitmapDescriptorFactory.HUE_RED, 1.0f};

    /* renamed from: d  reason: collision with root package name */
    public static final float[] f31350d = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, 1.0f, BitmapDescriptorFactory.HUE_RED, 1.0f, 1.0f};

    /* renamed from: e  reason: collision with root package name */
    public static final float[] f31351e = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    private static float a(float f2) {
        if (f2 == BitmapDescriptorFactory.HUE_RED) {
            return 1.0f;
        }
        return BitmapDescriptorFactory.HUE_RED;
    }

    /* renamed from: com.tencent.liteav.basic.d.k$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31352a = new int[j.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.tencent.liteav.basic.d.j[] r0 = com.tencent.liteav.basic.d.j.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31352a = r0
                int[] r0 = f31352a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.tencent.liteav.basic.d.j r1 = com.tencent.liteav.basic.d.j.ROTATION_90     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f31352a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.tencent.liteav.basic.d.j r1 = com.tencent.liteav.basic.d.j.ROTATION_180     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f31352a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.tencent.liteav.basic.d.j r1 = com.tencent.liteav.basic.d.j.ROTATION_270     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f31352a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.tencent.liteav.basic.d.j r1 = com.tencent.liteav.basic.d.j.NORMAL     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.basic.d.k.AnonymousClass1.<clinit>():void");
        }
    }

    public static float[] a(j jVar, boolean z, boolean z2) {
        float[] fArr;
        int i = AnonymousClass1.f31352a[jVar.ordinal()];
        if (i == 1) {
            fArr = (float[]) f31348b.clone();
        } else if (i == 2) {
            fArr = (float[]) f31349c.clone();
        } else if (i != 3) {
            fArr = (float[]) f31347a.clone();
        } else {
            fArr = (float[]) f31350d.clone();
        }
        if (z) {
            fArr = new float[]{a(fArr[0]), fArr[1], a(fArr[2]), fArr[3], a(fArr[4]), fArr[5], a(fArr[6]), fArr[7]};
        }
        if (!z2) {
            return fArr;
        }
        return new float[]{fArr[0], a(fArr[1]), fArr[2], a(fArr[3]), fArr[4], a(fArr[5]), fArr[6], a(fArr[7])};
    }
}
