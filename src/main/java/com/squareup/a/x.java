package com.squareup.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.widget.ImageView;
import com.squareup.a.w;

final class x extends BitmapDrawable {

    /* renamed from: e  reason: collision with root package name */
    private static final Paint f30590e = new Paint();

    /* renamed from: a  reason: collision with root package name */
    Drawable f30591a;

    /* renamed from: b  reason: collision with root package name */
    long f30592b;

    /* renamed from: c  reason: collision with root package name */
    boolean f30593c;

    /* renamed from: d  reason: collision with root package name */
    int f30594d = 255;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f30595f;

    /* renamed from: g  reason: collision with root package name */
    private final float f30596g;
    private final w.d h;

    static void a(ImageView imageView, Context context, Bitmap bitmap, w.d dVar, boolean z, boolean z2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
        imageView.setImageDrawable(new x(context, bitmap, drawable, dVar, z, z2));
    }

    static void a(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof AnimationDrawable) {
            ((AnimationDrawable) imageView.getDrawable()).start();
        }
    }

    x(Context context, Bitmap bitmap, Drawable drawable, w.d dVar, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.f30595f = z2;
        this.f30596g = context.getResources().getDisplayMetrics().density;
        this.h = dVar;
        if (dVar != w.d.MEMORY && !z) {
            this.f30591a = drawable;
            this.f30593c = true;
            this.f30592b = SystemClock.uptimeMillis();
        }
    }

    public void draw(Canvas canvas) {
        if (!this.f30593c) {
            super.draw(canvas);
        } else {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f30592b)) / 200.0f;
            if (uptimeMillis >= 1.0f) {
                this.f30593c = false;
                this.f30591a = null;
                super.draw(canvas);
            } else {
                Drawable drawable = this.f30591a;
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                super.setAlpha((int) (((float) this.f30594d) * uptimeMillis));
                super.draw(canvas);
                super.setAlpha(this.f30594d);
                if (Build.VERSION.SDK_INT <= 10) {
                    invalidateSelf();
                }
            }
        }
        if (this.f30595f) {
            a(canvas);
        }
    }

    public void setAlpha(int i) {
        this.f30594d = i;
        Drawable drawable = this.f30591a;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
        super.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f30591a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f30591a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    private void a(Canvas canvas) {
        f30590e.setColor(-1);
        canvas.drawPath(a(0, 0, (int) (this.f30596g * 16.0f)), f30590e);
        f30590e.setColor(this.h.debugColor);
        canvas.drawPath(a(0, 0, (int) (this.f30596g * 15.0f)), f30590e);
    }

    private static Path a(int i, int i2, int i3) {
        Path path = new Path();
        float f2 = (float) i;
        float f3 = (float) i2;
        path.moveTo(f2, f3);
        path.lineTo((float) (i + i3), f3);
        path.lineTo(f2, (float) (i2 + i3));
        return path;
    }
}
