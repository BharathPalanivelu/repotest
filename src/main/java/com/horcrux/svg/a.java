package com.horcrux.svg;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.ReactConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

class a {

    /* renamed from: a  reason: collision with root package name */
    private final C0241a f14816a;

    /* renamed from: b  reason: collision with root package name */
    private final u[] f14817b;

    /* renamed from: c  reason: collision with root package name */
    private ReadableArray f14818c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f14819d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f14820e;

    /* renamed from: f  reason: collision with root package name */
    private Matrix f14821f;

    /* renamed from: g  reason: collision with root package name */
    private Rect f14822g;
    private p h;

    /* renamed from: com.horcrux.svg.a$a  reason: collision with other inner class name */
    enum C0241a {
        LINEAR_GRADIENT,
        RADIAL_GRADIENT,
        PATTERN
    }

    enum b {
        OBJECT_BOUNDING_BOX,
        USER_SPACE_ON_USE
    }

    a(C0241a aVar, u[] uVarArr, b bVar) {
        this.f14816a = aVar;
        this.f14817b = uVarArr;
        this.f14819d = bVar == b.OBJECT_BOUNDING_BOX;
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        this.f14820e = bVar == b.OBJECT_BOUNDING_BOX;
    }

    /* access modifiers changed from: package-private */
    public void a(p pVar) {
        this.h = pVar;
    }

    private static void a(ReadableArray readableArray, int i, float[] fArr, int[] iArr, float f2) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * 2;
            fArr[i2] = (float) readableArray.getDouble(i3);
            int i4 = readableArray.getInt(i3 + 1);
            iArr[i2] = (i4 & 16777215) | (Math.round(((float) (i4 >>> 24)) * f2) << 24);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Rect rect) {
        this.f14822g = rect;
    }

    /* access modifiers changed from: package-private */
    public void a(ReadableArray readableArray) {
        this.f14818c = readableArray;
    }

    /* access modifiers changed from: package-private */
    public void a(Matrix matrix) {
        this.f14821f = matrix;
    }

    private RectF a(RectF rectF) {
        float f2;
        if (!this.f14819d) {
            rectF = new RectF(this.f14822g);
        }
        float width = rectF.width();
        float height = rectF.height();
        boolean z = this.f14819d;
        float f3 = BitmapDescriptorFactory.HUE_RED;
        if (z) {
            f3 = rectF.left;
            f2 = rectF.top;
        } else {
            f2 = BitmapDescriptorFactory.HUE_RED;
        }
        return new RectF(f3, f2, width + f3, height + f2);
    }

    private double a(u uVar, double d2, float f2, float f3) {
        double d3;
        if (!this.f14819d) {
            u uVar2 = uVar;
        } else if (uVar.f14914b == v.SVG_LENGTHTYPE_NUMBER) {
            d3 = d2;
            return q.a(uVar, d2, 0.0d, d3, (double) f3);
        }
        d3 = (double) f2;
        return q.a(uVar, d2, 0.0d, d3, (double) f3);
    }

    /* access modifiers changed from: package-private */
    public void a(Paint paint, RectF rectF, float f2, float f3) {
        float[] fArr;
        int[] iArr;
        Paint paint2 = paint;
        float f4 = f2;
        float f5 = f3;
        RectF a2 = a(rectF);
        float width = a2.width();
        float height = a2.height();
        float f6 = a2.left;
        float f7 = a2.top;
        float textSize = paint.getTextSize();
        if (this.f14816a == C0241a.PATTERN) {
            double d2 = (double) width;
            double d3 = d2;
            double a3 = a(this.f14817b[0], d2, f2, textSize);
            double d4 = (double) height;
            double d5 = a3;
            double a4 = a(this.f14817b[1], d4, f2, textSize);
            double d6 = a4;
            double a5 = a(this.f14817b[2], d3, f2, textSize);
            u uVar = this.f14817b[3];
            double d7 = a5;
            double a6 = a(uVar, d4, f2, textSize);
            if (d7 > 1.0d && a6 > 1.0d) {
                Bitmap createBitmap = Bitmap.createBitmap((int) d7, (int) a6, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                RectF e2 = this.h.e();
                if (e2 != null && e2.width() > BitmapDescriptorFactory.HUE_RED && e2.height() > BitmapDescriptorFactory.HUE_RED) {
                    canvas.concat(ac.a(e2, new RectF((float) d5, (float) d6, (float) d7, (float) a6), this.h.f14886b, this.h.f14887c));
                }
                if (this.f14820e) {
                    float f8 = f2;
                    canvas.scale(width / f8, height / f8);
                }
                this.h.draw(canvas, new Paint(), f5);
                Matrix matrix = new Matrix();
                Matrix matrix2 = this.f14821f;
                if (matrix2 != null) {
                    matrix.preConcat(matrix2);
                }
                BitmapShader bitmapShader = new BitmapShader(createBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                bitmapShader.setLocalMatrix(matrix);
                paint.setShader(bitmapShader);
                return;
            }
            return;
        }
        Paint paint3 = paint2;
        float f9 = f4;
        int size = this.f14818c.size() / 2;
        int[] iArr2 = new int[size];
        float[] fArr2 = new float[size];
        a(this.f14818c, size, fArr2, iArr2, f5);
        if (fArr2.length == 1) {
            iArr = new int[]{iArr2[0], iArr2[0]};
            fArr = new float[]{fArr2[0], fArr2[0]};
            FLog.w(ReactConstants.TAG, "Gradient contains only on stop");
        } else {
            iArr = iArr2;
            fArr = fArr2;
        }
        if (this.f14816a == C0241a.LINEAR_GRADIENT) {
            double d8 = (double) width;
            double d9 = (double) f9;
            double d10 = (double) f6;
            double d11 = (double) textSize;
            double a7 = q.a(this.f14817b[0], d8, d10, d9, d11);
            double d12 = (double) height;
            double d13 = a7;
            double d14 = (double) f7;
            double d15 = d9;
            double d16 = d11;
            double d17 = d14;
            double a8 = q.a(this.f14817b[1], d12, d14, d15, d16);
            LinearGradient linearGradient = new LinearGradient((float) d13, (float) a8, (float) q.a(this.f14817b[2], d8, d10, d15, d16), (float) q.a(this.f14817b[3], d12, d17, d15, d16), iArr, fArr, Shader.TileMode.CLAMP);
            if (this.f14821f != null) {
                Matrix matrix3 = new Matrix();
                matrix3.preConcat(this.f14821f);
                linearGradient.setLocalMatrix(matrix3);
            }
            paint.setShader(linearGradient);
            return;
        }
        Paint paint4 = paint3;
        float f10 = height;
        if (this.f14816a == C0241a.RADIAL_GRADIENT) {
            double d18 = (double) width;
            double d19 = (double) f9;
            double d20 = (double) textSize;
            double a9 = q.a(this.f14817b[2], d18, 0.0d, d19, d20);
            double d21 = (double) f10;
            double d22 = d19;
            double d23 = d20;
            double a10 = q.a(this.f14817b[3], d21, 0.0d, d22, d23);
            double a11 = q.a(this.f14817b[4], d18, (double) f6, d19, d20);
            double d24 = a10 / a9;
            RadialGradient radialGradient = new RadialGradient((float) a11, (float) (q.a(this.f14817b[5], d21, (double) f7, d22, d23) / d24), (float) a9, iArr, fArr, Shader.TileMode.CLAMP);
            Matrix matrix4 = new Matrix();
            matrix4.preScale(1.0f, (float) d24);
            Matrix matrix5 = this.f14821f;
            if (matrix5 != null) {
                matrix4.preConcat(matrix5);
            }
            radialGradient.setLocalMatrix(matrix4);
            paint.setShader(radialGradient);
        }
    }
}
