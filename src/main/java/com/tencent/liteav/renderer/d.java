package com.tencent.liteav.renderer;

import android.graphics.Matrix;
import android.os.Handler;
import android.view.TextureView;
import com.tencent.liteav.basic.log.TXCLog;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private TextureView f31926a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f31927b;

    /* renamed from: c  reason: collision with root package name */
    private int f31928c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f31929d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f31930e = 640;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f31931f = 480;

    /* renamed from: g  reason: collision with root package name */
    private int f31932g = 0;
    private int h = 0;
    /* access modifiers changed from: private */
    public int i = 1;
    /* access modifiers changed from: private */
    public int j = 0;
    private float k = 1.0f;
    private int l = 0;

    public d(TextureView textureView) {
        this.f31926a = textureView;
        this.f31928c = textureView.getWidth();
        this.f31929d = textureView.getHeight();
        this.f31927b = new Handler(textureView.getContext().getMainLooper());
    }

    public void a(final int i2) {
        try {
            this.f31927b.post(new Runnable() {
                public void run() {
                    d.this.b(i2);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
        if (r6 < r0) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0073, code lost:
        if (r6 < r0) goto L_0x0061;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(int r6) {
        /*
            r5 = this;
            r5.i = r6
            android.view.TextureView r0 = r5.f31926a
            if (r0 == 0) goto L_0x008f
            r0 = 1
            r1 = 90
            r2 = 270(0x10e, float:3.78E-43)
            r3 = 180(0xb4, float:2.52E-43)
            r4 = 1065353216(0x3f800000, float:1.0)
            if (r6 != r0) goto L_0x0039
            int r6 = r5.j
            if (r6 == 0) goto L_0x0077
            if (r6 != r3) goto L_0x0019
            goto L_0x0077
        L_0x0019:
            if (r6 == r2) goto L_0x001d
            if (r6 != r1) goto L_0x0077
        L_0x001d:
            int r6 = r5.f31932g
            if (r6 == 0) goto L_0x0038
            int r0 = r5.h
            if (r0 != 0) goto L_0x0026
            goto L_0x0038
        L_0x0026:
            int r1 = r5.f31929d
            float r1 = (float) r1
            float r6 = (float) r6
            float r1 = r1 / r6
            int r6 = r5.f31928c
            float r6 = (float) r6
            float r0 = (float) r0
            float r6 = r6 / r0
            int r0 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0036
        L_0x0034:
            r4 = r6
            goto L_0x0077
        L_0x0036:
            r4 = r1
            goto L_0x0077
        L_0x0038:
            return
        L_0x0039:
            if (r6 != 0) goto L_0x0077
            int r6 = r5.f31932g
            if (r6 == 0) goto L_0x0076
            int r6 = r5.h
            if (r6 != 0) goto L_0x0044
            goto L_0x0076
        L_0x0044:
            int r6 = r5.j
            if (r6 == 0) goto L_0x0063
            if (r6 != r3) goto L_0x004b
            goto L_0x0063
        L_0x004b:
            if (r6 == r2) goto L_0x004f
            if (r6 != r1) goto L_0x0077
        L_0x004f:
            int r6 = r5.f31929d
            float r6 = (float) r6
            int r0 = r5.f31932g
            float r0 = (float) r0
            float r6 = r6 / r0
            int r0 = r5.f31928c
            float r0 = (float) r0
            int r1 = r5.h
            float r1 = (float) r1
            float r0 = r0 / r1
            int r1 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r1 >= 0) goto L_0x0034
        L_0x0061:
            r4 = r0
            goto L_0x0077
        L_0x0063:
            int r6 = r5.f31929d
            float r6 = (float) r6
            int r0 = r5.h
            float r0 = (float) r0
            float r6 = r6 / r0
            int r0 = r5.f31928c
            float r0 = (float) r0
            int r1 = r5.f31932g
            float r1 = (float) r1
            float r0 = r0 / r1
            int r1 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r1 >= 0) goto L_0x0034
            goto L_0x0061
        L_0x0076:
            return
        L_0x0077:
            float r6 = r5.k
            r0 = 0
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 >= 0) goto L_0x007f
            float r4 = -r4
        L_0x007f:
            android.view.TextureView r6 = r5.f31926a
            r6.setScaleX(r4)
            android.view.TextureView r6 = r5.f31926a
            float r0 = java.lang.Math.abs(r4)
            r6.setScaleY(r0)
            r5.k = r4
        L_0x008f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.renderer.d.b(int):void");
    }

    public void c(final int i2) {
        try {
            this.f31927b.post(new Runnable() {
                public void run() {
                    d.this.d(i2);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        if (r5 > r2) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0043, code lost:
        r1 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0049, code lost:
        if (r5 < r2) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(int r5) {
        /*
            r4 = this;
            int r5 = r5 % 360
            r4.j = r5
            android.view.TextureView r0 = r4.f31926a
            if (r0 == 0) goto L_0x008e
            r0 = 1
            r1 = 1065353216(0x3f800000, float:1.0)
            if (r5 == 0) goto L_0x004d
            r2 = 180(0xb4, float:2.52E-43)
            if (r5 != r2) goto L_0x0012
            goto L_0x004d
        L_0x0012:
            r2 = 270(0x10e, float:3.78E-43)
            if (r5 == r2) goto L_0x001a
            r2 = 90
            if (r5 != r2) goto L_0x0076
        L_0x001a:
            int r2 = r4.f31932g
            if (r2 == 0) goto L_0x004c
            int r2 = r4.h
            if (r2 != 0) goto L_0x0023
            goto L_0x004c
        L_0x0023:
            android.view.TextureView r2 = r4.f31926a
            int r5 = 360 - r5
            float r5 = (float) r5
            r2.setRotation(r5)
            int r5 = r4.f31929d
            float r5 = (float) r5
            int r2 = r4.f31932g
            float r2 = (float) r2
            float r5 = r5 / r2
            int r2 = r4.f31928c
            float r2 = (float) r2
            int r3 = r4.h
            float r3 = (float) r3
            float r2 = r2 / r3
            int r3 = r4.i
            if (r3 != r0) goto L_0x0045
            int r0 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0043
        L_0x0041:
            r1 = r2
            goto L_0x0076
        L_0x0043:
            r1 = r5
            goto L_0x0076
        L_0x0045:
            if (r3 != 0) goto L_0x0076
            int r0 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x0043
            goto L_0x0041
        L_0x004c:
            return
        L_0x004d:
            android.view.TextureView r2 = r4.f31926a
            int r5 = 360 - r5
            float r5 = (float) r5
            r2.setRotation(r5)
            int r5 = r4.i
            if (r5 != r0) goto L_0x005a
            goto L_0x0076
        L_0x005a:
            if (r5 != 0) goto L_0x0076
            int r5 = r4.f31932g
            if (r5 == 0) goto L_0x0075
            int r0 = r4.h
            if (r0 != 0) goto L_0x0065
            goto L_0x0075
        L_0x0065:
            int r1 = r4.f31929d
            float r1 = (float) r1
            float r0 = (float) r0
            float r1 = r1 / r0
            int r0 = r4.f31928c
            float r0 = (float) r0
            float r5 = (float) r5
            float r0 = r0 / r5
            int r5 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r5 >= 0) goto L_0x0076
            r1 = r0
            goto L_0x0076
        L_0x0075:
            return
        L_0x0076:
            float r5 = r4.k
            r0 = 0
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 >= 0) goto L_0x007e
            float r1 = -r1
        L_0x007e:
            android.view.TextureView r5 = r4.f31926a
            r5.setScaleX(r1)
            android.view.TextureView r5 = r4.f31926a
            float r0 = java.lang.Math.abs(r1)
            r5.setScaleY(r0)
            r4.k = r1
        L_0x008e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.renderer.d.d(int):void");
    }

    private void a() {
        try {
            this.f31927b.post(new Runnable() {
                public void run() {
                    d dVar = d.this;
                    dVar.c(dVar.f31930e, d.this.f31931f);
                    d dVar2 = d.this;
                    dVar2.b(dVar2.i);
                    d dVar3 = d.this;
                    dVar3.d(dVar3.j);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void c(int i2, int i3) {
        if (this.f31926a != null && i2 != 0 && i3 != 0) {
            int i4 = this.f31928c;
            if (i4 != 0) {
                int i5 = this.f31929d;
                if (i5 != 0) {
                    double d2 = (double) i3;
                    double d3 = (double) i2;
                    Double.isNaN(d2);
                    Double.isNaN(d3);
                    double d4 = d2 / d3;
                    double d5 = (double) i4;
                    Double.isNaN(d5);
                    if (i5 > ((int) (d5 * d4))) {
                        this.f31932g = i4;
                        double d6 = (double) i4;
                        Double.isNaN(d6);
                        this.h = (int) (d6 * d4);
                    } else {
                        double d7 = (double) i5;
                        Double.isNaN(d7);
                        this.f31932g = (int) (d7 / d4);
                        this.h = i5;
                    }
                    int i6 = this.f31928c;
                    int i7 = this.f31932g;
                    int i8 = this.f31929d;
                    int i9 = this.h;
                    Matrix matrix = new Matrix();
                    this.f31926a.getTransform(matrix);
                    matrix.setScale(((float) i7) / ((float) i6), ((float) i9) / ((float) i8));
                    matrix.postTranslate(((float) (i6 - i7)) / 2.0f, ((float) (i8 - i9)) / 2.0f);
                    this.f31926a.setTransform(matrix);
                    this.f31926a.requestLayout();
                }
            }
        }
    }

    public void a(int i2, int i3) {
        TXCLog.w("TXCTextureViewWrapper", "vrender: set view size:" + i2 + "," + i3);
        this.f31928c = i2;
        this.f31929d = i3;
        a();
    }

    public void b(int i2, int i3) {
        TXCLog.w("TXCTextureViewWrapper", "vrender: set video size:" + i2 + "," + i3);
        this.f31930e = i2;
        this.f31931f = i3;
        a();
    }
}
