package com.BV.LinearGradient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.PixelUtil;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class b extends View {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f3089a = new Paint(1);

    /* renamed from: b  reason: collision with root package name */
    private Path f3090b;

    /* renamed from: c  reason: collision with root package name */
    private RectF f3091c;

    /* renamed from: d  reason: collision with root package name */
    private LinearGradient f3092d;

    /* renamed from: e  reason: collision with root package name */
    private float[] f3093e;

    /* renamed from: f  reason: collision with root package name */
    private float[] f3094f = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};

    /* renamed from: g  reason: collision with root package name */
    private float[] f3095g = {BitmapDescriptorFactory.HUE_RED, 1.0f};
    private int[] h;
    private boolean i = false;
    private float[] j = {0.5f, 0.5f};
    private float k = 45.0f;
    private int[] l = {0, 0};
    private float[] m = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};

    public b(Context context) {
        super(context);
    }

    public void setStartPosition(ReadableArray readableArray) {
        this.f3094f = new float[]{(float) readableArray.getDouble(0), (float) readableArray.getDouble(1)};
        a();
    }

    public void setEndPosition(ReadableArray readableArray) {
        this.f3095g = new float[]{(float) readableArray.getDouble(0), (float) readableArray.getDouble(1)};
        a();
    }

    public void setColors(ReadableArray readableArray) {
        int[] iArr = new int[readableArray.size()];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = readableArray.getInt(i2);
        }
        this.h = iArr;
        a();
    }

    public void setLocations(ReadableArray readableArray) {
        float[] fArr = new float[readableArray.size()];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr[i2] = (float) readableArray.getDouble(i2);
        }
        this.f3093e = fArr;
        a();
    }

    public void setUseAngle(boolean z) {
        this.i = z;
        a();
    }

    public void setAngleCenter(ReadableArray readableArray) {
        this.j = new float[]{(float) readableArray.getDouble(0), (float) readableArray.getDouble(1)};
        a();
    }

    public void setAngle(float f2) {
        this.k = f2;
        a();
    }

    public void setBorderRadii(ReadableArray readableArray) {
        float[] fArr = new float[readableArray.size()];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr[i2] = PixelUtil.toPixelFromDIP((float) readableArray.getDouble(i2));
        }
        this.m = fArr;
        b();
        a();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.l = new int[]{i2, i3};
        b();
        a();
    }

    private float[] a(float f2) {
        float sqrt = (float) Math.sqrt(2.0d);
        double d2 = (double) ((f2 - 90.0f) * 0.017453292f);
        return new float[]{((float) Math.cos(d2)) * sqrt, ((float) Math.sin(d2)) * sqrt};
    }

    private void a() {
        int[] iArr = this.h;
        if (iArr != null) {
            float[] fArr = this.f3093e;
            if (fArr == null || iArr.length == fArr.length) {
                float[] fArr2 = this.f3094f;
                float[] fArr3 = this.f3095g;
                if (this.i && this.j != null) {
                    float[] a2 = a(this.k);
                    float[] fArr4 = this.j;
                    float[] fArr5 = {fArr4[0] - (a2[0] / 2.0f), fArr4[1] - (a2[1] / 2.0f)};
                    fArr3 = new float[]{fArr4[0] + (a2[0] / 2.0f), fArr4[1] + (a2[1] / 2.0f)};
                    fArr2 = fArr5;
                }
                float f2 = fArr2[0];
                int[] iArr2 = this.l;
                float f3 = ((float) iArr2[0]) * f2;
                float f4 = fArr2[1] * ((float) iArr2[1]);
                this.f3092d = new LinearGradient(f3, f4, fArr3[0] * ((float) iArr2[0]), fArr3[1] * ((float) iArr2[1]), this.h, this.f3093e, Shader.TileMode.CLAMP);
                this.f3089a.setShader(this.f3092d);
                invalidate();
            }
        }
    }

    private void b() {
        if (this.f3090b == null) {
            this.f3090b = new Path();
            this.f3091c = new RectF();
        }
        this.f3090b.reset();
        RectF rectF = this.f3091c;
        int[] iArr = this.l;
        rectF.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) iArr[0], (float) iArr[1]);
        this.f3090b.addRoundRect(this.f3091c, this.m, Path.Direction.CW);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = this.f3090b;
        if (path == null) {
            canvas.drawPaint(this.f3089a);
        } else {
            canvas.drawPath(path, this.f3089a);
        }
    }
}
