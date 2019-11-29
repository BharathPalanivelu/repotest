package com.google.android.material.h;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.appcompat.b.a.c;
import androidx.core.content.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.a;

public class a extends c {

    /* renamed from: a  reason: collision with root package name */
    static final double f13322a = Math.cos(Math.toRadians(45.0d));

    /* renamed from: b  reason: collision with root package name */
    final Paint f13323b;

    /* renamed from: c  reason: collision with root package name */
    final Paint f13324c;

    /* renamed from: d  reason: collision with root package name */
    final RectF f13325d;

    /* renamed from: e  reason: collision with root package name */
    float f13326e;

    /* renamed from: f  reason: collision with root package name */
    Path f13327f;

    /* renamed from: g  reason: collision with root package name */
    float f13328g;
    float h;
    float i;
    float j;
    private boolean k = true;
    private final int l;
    private final int m;
    private final int n;
    private boolean o = true;
    private float p;
    private boolean q = false;

    public int getOpacity() {
        return -3;
    }

    public a(Context context, Drawable drawable, float f2, float f3, float f4) {
        super(drawable);
        this.l = b.c(context, a.c.design_fab_shadow_start_color);
        this.m = b.c(context, a.c.design_fab_shadow_mid_color);
        this.n = b.c(context, a.c.design_fab_shadow_end_color);
        this.f13323b = new Paint(5);
        this.f13323b.setStyle(Paint.Style.FILL);
        this.f13326e = (float) Math.round(f2);
        this.f13325d = new RectF();
        this.f13324c = new Paint(this.f13323b);
        this.f13324c.setAntiAlias(false);
        a(f3, f4);
    }

    private static int c(float f2) {
        int round = Math.round(f2);
        return round % 2 == 1 ? round - 1 : round;
    }

    public void a(boolean z) {
        this.o = z;
        invalidateSelf();
    }

    public void setAlpha(int i2) {
        super.setAlpha(i2);
        this.f13323b.setAlpha(i2);
        this.f13324c.setAlpha(i2);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.k = true;
    }

    public void a(float f2, float f3) {
        if (f2 < BitmapDescriptorFactory.HUE_RED || f3 < BitmapDescriptorFactory.HUE_RED) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float c2 = (float) c(f2);
        float c3 = (float) c(f3);
        if (c2 > c3) {
            if (!this.q) {
                this.q = true;
            }
            c2 = c3;
        }
        if (this.j != c2 || this.h != c3) {
            this.j = c2;
            this.h = c3;
            this.i = (float) Math.round(c2 * 1.5f);
            this.f13328g = c3;
            this.k = true;
            invalidateSelf();
        }
    }

    public void a(float f2) {
        a(f2, this.h);
    }

    public float b() {
        return this.j;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) a(this.h, this.f13326e, this.o));
        int ceil2 = (int) Math.ceil((double) b(this.h, this.f13326e, this.o));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public static float a(float f2, float f3, boolean z) {
        if (!z) {
            return f2 * 1.5f;
        }
        double d2 = (double) (f2 * 1.5f);
        double d3 = (double) f3;
        Double.isNaN(d3);
        Double.isNaN(d2);
        return (float) (d2 + ((1.0d - f13322a) * d3));
    }

    public static float b(float f2, float f3, boolean z) {
        if (!z) {
            return f2;
        }
        double d2 = (double) f2;
        double d3 = (double) f3;
        Double.isNaN(d3);
        Double.isNaN(d2);
        return (float) (d2 + ((1.0d - f13322a) * d3));
    }

    public void draw(Canvas canvas) {
        if (this.k) {
            a(getBounds());
            this.k = false;
        }
        a(canvas);
        super.draw(canvas);
    }

    public final void b(float f2) {
        if (this.p != f2) {
            this.p = f2;
            invalidateSelf();
        }
    }

    private void a(Canvas canvas) {
        float f2;
        int i2;
        int i3;
        float f3;
        float f4;
        float f5;
        Canvas canvas2 = canvas;
        int save = canvas.save();
        canvas2.rotate(this.p, this.f13325d.centerX(), this.f13325d.centerY());
        float f6 = this.f13326e;
        float f7 = (-f6) - this.i;
        float f8 = f6 * 2.0f;
        boolean z = this.f13325d.width() - f8 > BitmapDescriptorFactory.HUE_RED;
        boolean z2 = this.f13325d.height() - f8 > BitmapDescriptorFactory.HUE_RED;
        float f9 = this.j;
        float f10 = f6 / ((f9 - (0.5f * f9)) + f6);
        float f11 = f6 / ((f9 - (0.25f * f9)) + f6);
        float f12 = f6 / ((f9 - (f9 * 1.0f)) + f6);
        int save2 = canvas.save();
        canvas2.translate(this.f13325d.left + f6, this.f13325d.top + f6);
        canvas2.scale(f10, f11);
        canvas2.drawPath(this.f13327f, this.f13323b);
        if (z) {
            canvas2.scale(1.0f / f10, 1.0f);
            i3 = save2;
            f2 = f12;
            i2 = save;
            f3 = f11;
            canvas.drawRect(BitmapDescriptorFactory.HUE_RED, f7, this.f13325d.width() - f8, -this.f13326e, this.f13324c);
        } else {
            i3 = save2;
            f2 = f12;
            i2 = save;
            f3 = f11;
        }
        canvas2.restoreToCount(i3);
        int save3 = canvas.save();
        canvas2.translate(this.f13325d.right - f6, this.f13325d.bottom - f6);
        float f13 = f2;
        canvas2.scale(f10, f13);
        canvas2.rotate(180.0f);
        canvas2.drawPath(this.f13327f, this.f13323b);
        if (z) {
            canvas2.scale(1.0f / f10, 1.0f);
            f4 = f3;
            f5 = f13;
            canvas.drawRect(BitmapDescriptorFactory.HUE_RED, f7, this.f13325d.width() - f8, (-this.f13326e) + this.i, this.f13324c);
        } else {
            f4 = f3;
            f5 = f13;
        }
        canvas2.restoreToCount(save3);
        int save4 = canvas.save();
        canvas2.translate(this.f13325d.left + f6, this.f13325d.bottom - f6);
        canvas2.scale(f10, f5);
        canvas2.rotate(270.0f);
        canvas2.drawPath(this.f13327f, this.f13323b);
        if (z2) {
            canvas2.scale(1.0f / f5, 1.0f);
            canvas.drawRect(BitmapDescriptorFactory.HUE_RED, f7, this.f13325d.height() - f8, -this.f13326e, this.f13324c);
        }
        canvas2.restoreToCount(save4);
        int save5 = canvas.save();
        canvas2.translate(this.f13325d.right - f6, this.f13325d.top + f6);
        float f14 = f4;
        canvas2.scale(f10, f14);
        canvas2.rotate(90.0f);
        canvas2.drawPath(this.f13327f, this.f13323b);
        if (z2) {
            canvas2.scale(1.0f / f14, 1.0f);
            canvas.drawRect(BitmapDescriptorFactory.HUE_RED, f7, this.f13325d.height() - f8, -this.f13326e, this.f13324c);
        }
        canvas2.restoreToCount(save5);
        canvas2.restoreToCount(i2);
    }

    private void c() {
        float f2 = this.f13326e;
        RectF rectF = new RectF(-f2, -f2, f2, f2);
        RectF rectF2 = new RectF(rectF);
        float f3 = this.i;
        rectF2.inset(-f3, -f3);
        Path path = this.f13327f;
        if (path == null) {
            this.f13327f = new Path();
        } else {
            path.reset();
        }
        this.f13327f.setFillType(Path.FillType.EVEN_ODD);
        this.f13327f.moveTo(-this.f13326e, BitmapDescriptorFactory.HUE_RED);
        this.f13327f.rLineTo(-this.i, BitmapDescriptorFactory.HUE_RED);
        this.f13327f.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f13327f.arcTo(rectF, 270.0f, -90.0f, false);
        this.f13327f.close();
        float f4 = -rectF2.top;
        if (f4 > BitmapDescriptorFactory.HUE_RED) {
            float f5 = this.f13326e / f4;
            Paint paint = this.f13323b;
            RadialGradient radialGradient = r8;
            RadialGradient radialGradient2 = new RadialGradient(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, f4, new int[]{0, this.l, this.m, this.n}, new float[]{0.0f, f5, ((1.0f - f5) / 2.0f) + f5, 1.0f}, Shader.TileMode.CLAMP);
            paint.setShader(radialGradient);
        }
        this.f13324c.setShader(new LinearGradient(BitmapDescriptorFactory.HUE_RED, rectF.top, BitmapDescriptorFactory.HUE_RED, rectF2.top, new int[]{this.l, this.m, this.n}, new float[]{BitmapDescriptorFactory.HUE_RED, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f13324c.setAntiAlias(false);
    }

    private void a(Rect rect) {
        float f2 = this.h * 1.5f;
        this.f13325d.set(((float) rect.left) + this.h, ((float) rect.top) + f2, ((float) rect.right) - this.h, ((float) rect.bottom) - f2);
        a().setBounds((int) this.f13325d.left, (int) this.f13325d.top, (int) this.f13325d.right, (int) this.f13325d.bottom);
        c();
    }
}
