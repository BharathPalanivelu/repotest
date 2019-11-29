package com.afollestad.materialdialogs.internal.progress;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.afollestad.materialdialogs.a.a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

@TargetApi(14)
class i extends h {

    /* renamed from: a  reason: collision with root package name */
    private static final RectF f3230a = new RectF(-180.0f, -1.0f, 180.0f, 1.0f);
    private static final RectF i = new RectF(-180.0f, -5.0f, 180.0f, 5.0f);
    private int j;
    private int k;
    private boolean l = true;
    private float m;

    public i(Context context) {
        super(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.j = Math.round(3.2f * f2);
        this.k = Math.round(f2 * 16.0f);
        this.m = a.a(context, 16842803);
    }

    public void a(boolean z) {
        if (this.l != z) {
            this.l = z;
            invalidateSelf();
        }
    }

    public int getIntrinsicHeight() {
        return this.f3224b ? this.k : this.j;
    }

    public int getOpacity() {
        if (this.f3225c == 0) {
            return -2;
        }
        if (this.f3225c == 255) {
            return (!this.l || this.m == 1.0f) ? -1 : -3;
        }
        return -3;
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        invalidateSelf();
        return true;
    }

    /* access modifiers changed from: protected */
    public void a(Paint paint) {
        paint.setStyle(Paint.Style.FILL);
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, int i2, int i3, Paint paint) {
        if (this.f3224b) {
            canvas.scale(((float) i2) / i.width(), ((float) i3) / i.height());
            canvas.translate(i.width() / 2.0f, i.height() / 2.0f);
        } else {
            canvas.scale(((float) i2) / f3230a.width(), ((float) i3) / f3230a.height());
            canvas.translate(f3230a.width() / 2.0f, f3230a.height() / 2.0f);
        }
        if (this.l) {
            paint.setAlpha(Math.round(((float) this.f3225c) * this.m));
            a(canvas, paint);
            paint.setAlpha(this.f3225c);
        }
        b(canvas, paint);
    }

    private static void a(Canvas canvas, Paint paint) {
        canvas.drawRect(f3230a, paint);
    }

    private void b(Canvas canvas, Paint paint) {
        int level = getLevel();
        if (level != 0) {
            int save = canvas.save();
            canvas.scale(((float) level) / 10000.0f, 1.0f, f3230a.left, BitmapDescriptorFactory.HUE_RED);
            canvas.drawRect(f3230a, paint);
            canvas.restoreToCount(save);
        }
    }
}
