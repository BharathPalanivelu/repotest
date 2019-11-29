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

@TargetApi(14)
public class IndeterminateProgressDrawable extends c {
    private static final RectF i = new RectF(-21.0f, -21.0f, 21.0f, 21.0f);
    private static final RectF j = new RectF(-24.0f, -24.0f, 24.0f, 24.0f);
    private static final RectF k = new RectF(-19.0f, -19.0f, 19.0f, 19.0f);
    private int l;
    private int m;
    private RingPathTransform n = new RingPathTransform();
    private RingRotation o = new RingRotation();

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

    public IndeterminateProgressDrawable(Context context) {
        super(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.l = Math.round(3.2f * f2);
        this.m = Math.round(f2 * 16.0f);
        this.f3209a = new Animator[]{a.c(this.n), a.d(this.o)};
    }

    private int a() {
        return this.f3224b ? this.m : this.l;
    }

    public int getIntrinsicWidth() {
        return a();
    }

    public int getIntrinsicHeight() {
        return a();
    }

    public int getOpacity() {
        if (this.f3225c == 0) {
            return -2;
        }
        return this.f3225c == 255 ? -1 : -3;
    }

    /* access modifiers changed from: protected */
    public void a(Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4.0f);
        paint.setStrokeCap(Paint.Cap.SQUARE);
        paint.setStrokeJoin(Paint.Join.MITER);
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
        a(canvas, paint);
    }

    private void a(Canvas canvas, Paint paint) {
        int save = canvas.save();
        canvas.rotate(this.o.f3200a);
        Canvas canvas2 = canvas;
        canvas2.drawArc(k, ((this.n.f3199c + this.n.f3197a) * 360.0f) - 0.049804688f, (this.n.f3198b - this.n.f3197a) * 360.0f, false, paint);
        canvas.restoreToCount(save);
    }

    private static class RingPathTransform {

        /* renamed from: a  reason: collision with root package name */
        public float f3197a;

        /* renamed from: b  reason: collision with root package name */
        public float f3198b;

        /* renamed from: c  reason: collision with root package name */
        public float f3199c;

        private RingPathTransform() {
        }

        @Keep
        public void setTrimPathStart(float f2) {
            this.f3197a = f2;
        }

        @Keep
        public void setTrimPathEnd(float f2) {
            this.f3198b = f2;
        }

        @Keep
        public void setTrimPathOffset(float f2) {
            this.f3199c = f2;
        }
    }

    private static class RingRotation {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public float f3200a;

        private RingRotation() {
        }

        @Keep
        public void setRotation(float f2) {
            this.f3200a = f2;
        }
    }
}
