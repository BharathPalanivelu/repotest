package com.afollestad.materialdialogs.internal.progress;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import androidx.annotation.Keep;
import com.afollestad.materialdialogs.a.a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

@TargetApi(14)
public class IndeterminateHorizontalProgressDrawable extends c {
    private static final RectF i = new RectF(-180.0f, -1.0f, 180.0f, 1.0f);
    private static final RectF j = new RectF(-180.0f, -5.0f, 180.0f, 5.0f);
    private static final RectF k = new RectF(-144.0f, -1.0f, 144.0f, 1.0f);
    private static final RectTransformX l = new RectTransformX(-522.6f, 0.1f);
    private static final RectTransformX m = new RectTransformX(-197.6f, 0.1f);
    private int n;
    private int o;
    private boolean p = true;
    private float q;
    private RectTransformX r = new RectTransformX(l);
    private RectTransformX s = new RectTransformX(m);

    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    public /* bridge */ /* synthetic */ void setAlpha(int i2) {
        super.setAlpha(i2);
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    public /* bridge */ /* synthetic */ void setTint(int i2) {
        super.setTint(i2);
    }

    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    public IndeterminateHorizontalProgressDrawable(Context context) {
        super(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.n = Math.round(3.2f * f2);
        this.o = Math.round(f2 * 16.0f);
        this.q = a.a(context, 16842803);
        this.f3209a = new Animator[]{a.a(this.r), a.b(this.s)};
    }

    public int getIntrinsicHeight() {
        return this.f3224b ? this.o : this.n;
    }

    public int getOpacity() {
        if (this.f3225c == 0) {
            return -2;
        }
        if (this.f3225c == 255) {
            return (!this.p || this.q == 1.0f) ? -1 : -3;
        }
        return -3;
    }

    /* access modifiers changed from: protected */
    public void a(Paint paint) {
        paint.setStyle(Paint.Style.FILL);
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, int i2, int i3, Paint paint) {
        if (this.f3224b) {
            canvas.scale(((float) i2) / j.width(), ((float) i3) / j.height());
            canvas.translate(j.width() / 2.0f, j.height() / 2.0f);
        } else {
            canvas.scale(((float) i2) / i.width(), ((float) i3) / i.height());
            canvas.translate(i.width() / 2.0f, i.height() / 2.0f);
        }
        if (this.p) {
            paint.setAlpha(Math.round(((float) this.f3225c) * this.q));
            a(canvas, paint);
            paint.setAlpha(this.f3225c);
        }
        a(canvas, this.s, paint);
        a(canvas, this.r, paint);
    }

    private static void a(Canvas canvas, Paint paint) {
        canvas.drawRect(i, paint);
    }

    private static void a(Canvas canvas, RectTransformX rectTransformX, Paint paint) {
        int save = canvas.save();
        canvas.translate(rectTransformX.f3195a, BitmapDescriptorFactory.HUE_RED);
        canvas.scale(rectTransformX.f3196b, 1.0f);
        canvas.drawRect(k, paint);
        canvas.restoreToCount(save);
    }

    private static class RectTransformX {

        /* renamed from: a  reason: collision with root package name */
        public float f3195a;

        /* renamed from: b  reason: collision with root package name */
        public float f3196b;

        public RectTransformX(float f2, float f3) {
            this.f3195a = f2;
            this.f3196b = f3;
        }

        public RectTransformX(RectTransformX rectTransformX) {
            this.f3195a = rectTransformX.f3195a;
            this.f3196b = rectTransformX.f3196b;
        }

        @Keep
        public void setTranslateX(float f2) {
            this.f3195a = f2;
        }

        @Keep
        public void setScaleX(float f2) {
            this.f3196b = f2;
        }
    }
}
