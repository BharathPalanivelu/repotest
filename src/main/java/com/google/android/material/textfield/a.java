package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

class a extends GradientDrawable {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f13524a = new Paint(1);

    /* renamed from: b  reason: collision with root package name */
    private final RectF f13525b;

    /* renamed from: c  reason: collision with root package name */
    private int f13526c;

    a() {
        c();
        this.f13525b = new RectF();
    }

    private void c() {
        this.f13524a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f13524a.setColor(-1);
        this.f13524a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return !this.f13525b.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public void a(float f2, float f3, float f4, float f5) {
        if (f2 != this.f13525b.left || f3 != this.f13525b.top || f4 != this.f13525b.right || f5 != this.f13525b.bottom) {
            this.f13525b.set(f2, f3, f4, f5);
            invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(RectF rectF) {
        a(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        a(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
    }

    public void draw(Canvas canvas) {
        a(canvas);
        super.draw(canvas);
        canvas.drawRect(this.f13525b, this.f13524a);
        c(canvas);
    }

    private void a(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (a(callback)) {
            ((View) callback).setLayerType(2, (Paint) null);
        } else {
            b(canvas);
        }
    }

    private void b(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f13526c = canvas.saveLayer(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) canvas.getWidth(), (float) canvas.getHeight(), (Paint) null);
            return;
        }
        this.f13526c = canvas.saveLayer(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) canvas.getWidth(), (float) canvas.getHeight(), (Paint) null, 31);
    }

    private void c(Canvas canvas) {
        if (!a(getCallback())) {
            canvas.restoreToCount(this.f13526c);
        }
    }

    private boolean a(Drawable.Callback callback) {
        return callback instanceof View;
    }
}
