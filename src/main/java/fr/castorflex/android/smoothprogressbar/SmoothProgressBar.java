package fr.castorflex.android.smoothprogressbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import fr.castorflex.android.smoothprogressbar.b;
import fr.castorflex.android.smoothprogressbar.d;

public class SmoothProgressBar extends ProgressBar {
    public SmoothProgressBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public SmoothProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a.spbStyle);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmoothProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interpolator interpolator;
        Context context2 = context;
        if (isInEditMode()) {
            setIndeterminateDrawable(new d.a(context2, true).a());
            return;
        }
        Resources resources = context.getResources();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, b.g.SmoothProgressBar, i, 0);
        int color = obtainStyledAttributes.getColor(b.g.SmoothProgressBar_spb_color, resources.getColor(b.c.spb_default_color));
        int integer = obtainStyledAttributes.getInteger(b.g.SmoothProgressBar_spb_sections_count, resources.getInteger(b.e.spb_default_sections_count));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(b.g.SmoothProgressBar_spb_stroke_separator_length, resources.getDimensionPixelSize(b.d.spb_default_stroke_separator_length));
        float dimension = obtainStyledAttributes.getDimension(b.g.SmoothProgressBar_spb_stroke_width, resources.getDimension(b.d.spb_default_stroke_width));
        float f2 = obtainStyledAttributes.getFloat(b.g.SmoothProgressBar_spb_speed, Float.parseFloat(resources.getString(b.f.spb_default_speed)));
        float f3 = obtainStyledAttributes.getFloat(b.g.SmoothProgressBar_spb_progressiveStart_speed, f2);
        float f4 = obtainStyledAttributes.getFloat(b.g.SmoothProgressBar_spb_progressiveStop_speed, f2);
        int integer2 = obtainStyledAttributes.getInteger(b.g.SmoothProgressBar_spb_interpolator, -1);
        boolean z = obtainStyledAttributes.getBoolean(b.g.SmoothProgressBar_spb_reversed, resources.getBoolean(b.C0508b.spb_default_reversed));
        boolean z2 = obtainStyledAttributes.getBoolean(b.g.SmoothProgressBar_spb_mirror_mode, resources.getBoolean(b.C0508b.spb_default_mirror_mode));
        int resourceId = obtainStyledAttributes.getResourceId(b.g.SmoothProgressBar_spb_colors, 0);
        boolean z3 = obtainStyledAttributes.getBoolean(b.g.SmoothProgressBar_spb_progressiveStart_activated, resources.getBoolean(b.C0508b.spb_default_progressiveStart_activated));
        int i2 = color;
        Drawable drawable = obtainStyledAttributes.getDrawable(b.g.SmoothProgressBar_spb_background);
        boolean z4 = obtainStyledAttributes.getBoolean(b.g.SmoothProgressBar_spb_generate_background_with_colors, false);
        boolean z5 = obtainStyledAttributes.getBoolean(b.g.SmoothProgressBar_spb_gradients, false);
        obtainStyledAttributes.recycle();
        int[] iArr = null;
        if (integer2 == -1) {
            interpolator = getInterpolator();
        } else {
            interpolator = null;
        }
        if (interpolator == null) {
            if (integer2 == 1) {
                interpolator = new LinearInterpolator();
            } else if (integer2 != 2) {
                interpolator = integer2 != 3 ? new AccelerateInterpolator() : new DecelerateInterpolator();
            } else {
                interpolator = new AccelerateDecelerateInterpolator();
            }
        }
        iArr = resourceId != 0 ? resources.getIntArray(resourceId) : iArr;
        d.a d2 = new d.a(context2).b(f2).c(f3).d(f4).a(interpolator).a(integer).b(dimensionPixelSize).a(dimension).a(z).b(z2).c(z3).d(z5);
        if (drawable != null) {
            d2.a(drawable);
        }
        if (z4) {
            d2.b();
        }
        if (iArr == null || iArr.length <= 0) {
            d2.c(i2);
        } else {
            d2.a(iArr);
        }
        setIndeterminateDrawable(d2.a());
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isIndeterminate() && (getIndeterminateDrawable() instanceof d) && !((d) getIndeterminateDrawable()).isRunning()) {
            getIndeterminateDrawable().draw(canvas);
        }
    }

    private d a() {
        Drawable indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null && (indeterminateDrawable instanceof d)) {
            return (d) indeterminateDrawable;
        }
        throw new RuntimeException("The drawable is not a SmoothProgressDrawable");
    }

    public void setInterpolator(Interpolator interpolator) {
        super.setInterpolator(interpolator);
        Drawable indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null && (indeterminateDrawable instanceof d)) {
            ((d) indeterminateDrawable).a(interpolator);
        }
    }

    public void setSmoothProgressDrawableInterpolator(Interpolator interpolator) {
        a().a(interpolator);
    }

    public void setSmoothProgressDrawableColors(int[] iArr) {
        a().a(iArr);
    }

    public void setSmoothProgressDrawableColor(int i) {
        a().a(i);
    }

    public void setSmoothProgressDrawableSpeed(float f2) {
        a().a(f2);
    }

    public void setSmoothProgressDrawableProgressiveStartSpeed(float f2) {
        a().b(f2);
    }

    public void setSmoothProgressDrawableProgressiveStopSpeed(float f2) {
        a().c(f2);
    }

    public void setSmoothProgressDrawableSectionsCount(int i) {
        a().b(i);
    }

    public void setSmoothProgressDrawableSeparatorLength(int i) {
        a().c(i);
    }

    public void setSmoothProgressDrawableStrokeWidth(float f2) {
        a().d(f2);
    }

    public void setSmoothProgressDrawableReversed(boolean z) {
        a().a(z);
    }

    public void setSmoothProgressDrawableMirrorMode(boolean z) {
        a().b(z);
    }

    public void setProgressiveStartActivated(boolean z) {
        a().c(z);
    }

    public void setSmoothProgressDrawableCallbacks(d.b bVar) {
        a().a(bVar);
    }

    public void setSmoothProgressDrawableBackgroundDrawable(Drawable drawable) {
        a().a(drawable);
    }

    public void setSmoothProgressDrawableUseGradients(boolean z) {
        a().d(z);
    }
}
