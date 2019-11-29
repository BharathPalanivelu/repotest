package com.afollestad.materialdialogs.internal.progress;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.afollestad.materialdialogs.a.a;
import com.afollestad.materialdialogs.g;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

@TargetApi(14)
abstract class h extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private Paint f3223a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f3224b = true;

    /* renamed from: c  reason: collision with root package name */
    protected int f3225c = 255;

    /* renamed from: d  reason: collision with root package name */
    protected ColorFilter f3226d;

    /* renamed from: e  reason: collision with root package name */
    protected ColorStateList f3227e;

    /* renamed from: f  reason: collision with root package name */
    protected PorterDuff.Mode f3228f = PorterDuff.Mode.SRC_IN;

    /* renamed from: g  reason: collision with root package name */
    protected PorterDuffColorFilter f3229g;
    protected boolean h = true;

    private boolean a() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract void a(Canvas canvas, int i, int i2, Paint paint);

    /* access modifiers changed from: protected */
    public abstract void a(Paint paint);

    public h(Context context) {
        setTint(a.b(context, g.a.colorControlActivated));
    }

    public void setAlpha(int i) {
        if (this.f3225c != i) {
            this.f3225c = i;
            invalidateSelf();
        }
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public ColorFilter getColorFilter() {
        return this.f3226d;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f3226d = colorFilter;
        invalidateSelf();
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f3227e = colorStateList;
        this.f3229g = a(colorStateList, this.f3228f);
        invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f3228f = mode;
        this.f3229g = a(this.f3227e, mode);
        invalidateSelf();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public boolean isAutoMirrored() {
        return this.h;
    }

    public void setAutoMirrored(boolean z) {
        if (this.h != z) {
            this.h = z;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.width() != 0 && bounds.height() != 0) {
            if (this.f3223a == null) {
                this.f3223a = new Paint();
                this.f3223a.setAntiAlias(true);
                this.f3223a.setColor(-16777216);
                a(this.f3223a);
            }
            this.f3223a.setAlpha(this.f3225c);
            ColorFilter colorFilter = this.f3226d;
            if (colorFilter == null) {
                colorFilter = this.f3229g;
            }
            this.f3223a.setColorFilter(colorFilter);
            int save = canvas.save();
            canvas.translate((float) bounds.left, (float) bounds.top);
            if (a()) {
                canvas.translate((float) bounds.width(), BitmapDescriptorFactory.HUE_RED);
                canvas.scale(-1.0f, 1.0f);
            }
            a(canvas, bounds.width(), bounds.height(), this.f3223a);
            canvas.restoreToCount(save);
        }
    }
}
