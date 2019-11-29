package com.google.android.material.internal;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class a extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    final Paint f13367a = new Paint(1);

    /* renamed from: b  reason: collision with root package name */
    final Rect f13368b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    final RectF f13369c = new RectF();

    /* renamed from: d  reason: collision with root package name */
    final C0218a f13370d = new C0218a();

    /* renamed from: e  reason: collision with root package name */
    float f13371e;

    /* renamed from: f  reason: collision with root package name */
    private int f13372f;

    /* renamed from: g  reason: collision with root package name */
    private int f13373g;
    private int h;
    private int i;
    private ColorStateList j;
    private int k;
    private boolean l = true;
    private float m;

    public a() {
        this.f13367a.setStyle(Paint.Style.STROKE);
    }

    public Drawable.ConstantState getConstantState() {
        return this.f13370d;
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.f13372f = i2;
        this.f13373g = i3;
        this.h = i4;
        this.i = i5;
    }

    public void a(float f2) {
        if (this.f13371e != f2) {
            this.f13371e = f2;
            this.f13367a.setStrokeWidth(f2 * 1.3333f);
            this.l = true;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        if (this.l) {
            this.f13367a.setShader(a());
            this.l = false;
        }
        float strokeWidth = this.f13367a.getStrokeWidth() / 2.0f;
        RectF rectF = this.f13369c;
        copyBounds(this.f13368b);
        rectF.set(this.f13368b);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.m, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.f13367a);
        canvas.restore();
    }

    public boolean getPadding(Rect rect) {
        int round = Math.round(this.f13371e);
        rect.set(round, round, round, round);
        return true;
    }

    public void setAlpha(int i2) {
        this.f13367a.setAlpha(i2);
        invalidateSelf();
    }

    public void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.k = colorStateList.getColorForState(getState(), this.k);
        }
        this.j = colorStateList;
        this.l = true;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f13367a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getOpacity() {
        return this.f13371e > BitmapDescriptorFactory.HUE_RED ? -3 : -2;
    }

    public final void b(float f2) {
        if (f2 != this.m) {
            this.m = f2;
            invalidateSelf();
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.l = true;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.j;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.j;
        if (colorStateList != null) {
            int colorForState = colorStateList.getColorForState(iArr, this.k);
            if (colorForState != this.k) {
                this.l = true;
                this.k = colorForState;
            }
        }
        if (this.l) {
            invalidateSelf();
        }
        return this.l;
    }

    private Shader a() {
        Rect rect = this.f13368b;
        copyBounds(rect);
        float height = this.f13371e / ((float) rect.height());
        return new LinearGradient(BitmapDescriptorFactory.HUE_RED, (float) rect.top, BitmapDescriptorFactory.HUE_RED, (float) rect.bottom, new int[]{androidx.core.graphics.a.a(this.f13372f, this.k), androidx.core.graphics.a.a(this.f13373g, this.k), androidx.core.graphics.a.a(androidx.core.graphics.a.c(this.f13373g, 0), this.k), androidx.core.graphics.a.a(androidx.core.graphics.a.c(this.i, 0), this.k), androidx.core.graphics.a.a(this.i, this.k), androidx.core.graphics.a.a(this.h, this.k)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }

    /* renamed from: com.google.android.material.internal.a$a  reason: collision with other inner class name */
    private class C0218a extends Drawable.ConstantState {
        public int getChangingConfigurations() {
            return 0;
        }

        private C0218a() {
        }

        public Drawable newDrawable() {
            return a.this;
        }
    }
}
