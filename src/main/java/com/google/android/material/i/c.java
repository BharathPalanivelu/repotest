package com.google.android.material.i;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.e;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class c extends Drawable implements e {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f13329a;

    /* renamed from: b  reason: collision with root package name */
    private final Matrix[] f13330b;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix[] f13331c;

    /* renamed from: d  reason: collision with root package name */
    private final d[] f13332d;

    /* renamed from: e  reason: collision with root package name */
    private final Matrix f13333e;

    /* renamed from: f  reason: collision with root package name */
    private final Path f13334f;

    /* renamed from: g  reason: collision with root package name */
    private final PointF f13335g;
    private final d h;
    private final Region i;
    private final Region j;
    private final float[] k;
    private final float[] l;
    private e m;
    private boolean n;
    private boolean o;
    private float p;
    private int q;
    private int r;
    private int s;
    private int t;
    private float u;
    private float v;
    private Paint.Style w;
    private PorterDuffColorFilter x;
    private PorterDuff.Mode y;
    private ColorStateList z;

    private static int a(int i2, int i3) {
        return (i2 * (i3 + (i3 >>> 7))) >>> 8;
    }

    public int getOpacity() {
        return -3;
    }

    public ColorStateList a() {
        return this.z;
    }

    public void setTintList(ColorStateList colorStateList) {
        this.z = colorStateList;
        b();
        invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.y = mode;
        b();
        invalidateSelf();
    }

    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    public void setAlpha(int i2) {
        this.t = i2;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f13329a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public Region getTransparentRegion() {
        Rect bounds = getBounds();
        this.i.set(bounds);
        b(bounds.width(), bounds.height(), this.f13334f);
        this.j.setPath(this.f13334f, this.i);
        this.i.op(this.j, Region.Op.DIFFERENCE);
        return this.i;
    }

    public void a(float f2) {
        this.p = f2;
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        this.f13329a.setColorFilter(this.x);
        int alpha = this.f13329a.getAlpha();
        this.f13329a.setAlpha(a(alpha, this.t));
        this.f13329a.setStrokeWidth(this.v);
        this.f13329a.setStyle(this.w);
        int i2 = this.r;
        if (i2 > 0 && this.n) {
            this.f13329a.setShadowLayer((float) this.s, BitmapDescriptorFactory.HUE_RED, (float) i2, this.q);
        }
        if (this.m != null) {
            b(canvas.getWidth(), canvas.getHeight(), this.f13334f);
            canvas.drawPath(this.f13334f, this.f13329a);
        } else {
            canvas.drawRect(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) canvas.getWidth(), (float) canvas.getHeight(), this.f13329a);
        }
        this.f13329a.setAlpha(alpha);
    }

    public void a(int i2, int i3, Path path) {
        path.rewind();
        if (this.m != null) {
            for (int i4 = 0; i4 < 4; i4++) {
                a(i4, i2, i3);
                b(i4, i2, i3);
            }
            for (int i5 = 0; i5 < 4; i5++) {
                a(i5, path);
                b(i5, path);
            }
            path.close();
        }
    }

    private void a(int i2, int i3, int i4) {
        a(i2, i3, i4, this.f13335g);
        a(i2).a(c(i2, i3, i4), this.p, this.f13332d[i2]);
        this.f13330b[i2].reset();
        this.f13330b[i2].setTranslate(this.f13335g.x, this.f13335g.y);
        this.f13330b[i2].preRotate((float) Math.toDegrees((double) (d(((i2 - 1) + 4) % 4, i3, i4) + 1.5707964f)));
    }

    private void b(int i2, int i3, int i4) {
        this.k[0] = this.f13332d[i2].f13338c;
        this.k[1] = this.f13332d[i2].f13339d;
        this.f13330b[i2].mapPoints(this.k);
        float d2 = d(i2, i3, i4);
        this.f13331c[i2].reset();
        Matrix matrix = this.f13331c[i2];
        float[] fArr = this.k;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f13331c[i2].preRotate((float) Math.toDegrees((double) d2));
    }

    private void a(int i2, Path path) {
        this.k[0] = this.f13332d[i2].f13336a;
        this.k[1] = this.f13332d[i2].f13337b;
        this.f13330b[i2].mapPoints(this.k);
        if (i2 == 0) {
            float[] fArr = this.k;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            float[] fArr2 = this.k;
            path.lineTo(fArr2[0], fArr2[1]);
        }
        this.f13332d[i2].a(this.f13330b[i2], path);
    }

    private void b(int i2, Path path) {
        int i3 = (i2 + 1) % 4;
        this.k[0] = this.f13332d[i2].f13338c;
        this.k[1] = this.f13332d[i2].f13339d;
        this.f13330b[i2].mapPoints(this.k);
        this.l[0] = this.f13332d[i3].f13336a;
        this.l[1] = this.f13332d[i3].f13337b;
        this.f13330b[i3].mapPoints(this.l);
        float[] fArr = this.k;
        float f2 = fArr[0];
        float[] fArr2 = this.l;
        this.h.a((float) BitmapDescriptorFactory.HUE_RED, (float) BitmapDescriptorFactory.HUE_RED);
        b(i2).a((float) Math.hypot((double) (f2 - fArr2[0]), (double) (fArr[1] - fArr2[1])), this.p, this.h);
        this.h.a(this.f13331c[i2], path);
    }

    private a a(int i2) {
        if (i2 == 1) {
            return this.m.b();
        }
        if (i2 == 2) {
            return this.m.c();
        }
        if (i2 != 3) {
            return this.m.a();
        }
        return this.m.d();
    }

    private b b(int i2) {
        if (i2 == 1) {
            return this.m.f();
        }
        if (i2 == 2) {
            return this.m.g();
        }
        if (i2 != 3) {
            return this.m.e();
        }
        return this.m.h();
    }

    private void a(int i2, int i3, int i4, PointF pointF) {
        if (i2 == 1) {
            pointF.set((float) i3, BitmapDescriptorFactory.HUE_RED);
        } else if (i2 == 2) {
            pointF.set((float) i3, (float) i4);
        } else if (i2 != 3) {
            pointF.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        } else {
            pointF.set(BitmapDescriptorFactory.HUE_RED, (float) i4);
        }
    }

    private float c(int i2, int i3, int i4) {
        a(((i2 - 1) + 4) % 4, i3, i4, this.f13335g);
        float f2 = this.f13335g.x;
        float f3 = this.f13335g.y;
        a((i2 + 1) % 4, i3, i4, this.f13335g);
        float f4 = this.f13335g.x;
        float f5 = this.f13335g.y;
        a(i2, i3, i4, this.f13335g);
        float f6 = this.f13335g.x;
        float f7 = this.f13335g.y;
        float atan2 = ((float) Math.atan2((double) (f3 - f7), (double) (f2 - f6))) - ((float) Math.atan2((double) (f5 - f7), (double) (f4 - f6)));
        if (atan2 >= BitmapDescriptorFactory.HUE_RED) {
            return atan2;
        }
        double d2 = (double) atan2;
        Double.isNaN(d2);
        return (float) (d2 + 6.283185307179586d);
    }

    private float d(int i2, int i3, int i4) {
        a(i2, i3, i4, this.f13335g);
        float f2 = this.f13335g.x;
        float f3 = this.f13335g.y;
        a((i2 + 1) % 4, i3, i4, this.f13335g);
        return (float) Math.atan2((double) (this.f13335g.y - f3), (double) (this.f13335g.x - f2));
    }

    private void b(int i2, int i3, Path path) {
        a(i2, i3, path);
        if (this.u != 1.0f) {
            this.f13333e.reset();
            Matrix matrix = this.f13333e;
            float f2 = this.u;
            matrix.setScale(f2, f2, (float) (i2 / 2), (float) (i3 / 2));
            path.transform(this.f13333e);
        }
    }

    private void b() {
        ColorStateList colorStateList = this.z;
        if (colorStateList == null || this.y == null) {
            this.x = null;
            return;
        }
        int colorForState = colorStateList.getColorForState(getState(), 0);
        this.x = new PorterDuffColorFilter(colorForState, this.y);
        if (this.o) {
            this.q = colorForState;
        }
    }
}
