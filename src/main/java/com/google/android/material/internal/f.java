package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.ad;
import com.google.android.material.a;

public class f extends ad {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f13386a;

    /* renamed from: b  reason: collision with root package name */
    boolean f13387b;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f13388c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f13389d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f13390e;

    /* renamed from: f  reason: collision with root package name */
    private int f13391f;

    public f(Context context) {
        this(context, (AttributeSet) null);
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13389d = new Rect();
        this.f13390e = new Rect();
        this.f13391f = 119;
        this.f13386a = true;
        this.f13387b = false;
        TypedArray a2 = l.a(context, attributeSet, a.k.ForegroundLinearLayout, i, 0, new int[0]);
        this.f13391f = a2.getInt(a.k.ForegroundLinearLayout_android_foregroundGravity, this.f13391f);
        Drawable drawable = a2.getDrawable(a.k.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f13386a = a2.getBoolean(a.k.ForegroundLinearLayout_foregroundInsidePadding, true);
        a2.recycle();
    }

    public int getForegroundGravity() {
        return this.f13391f;
    }

    public void setForegroundGravity(int i) {
        if (this.f13391f != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.f13391f = i;
            if (this.f13391f == 119 && this.f13388c != null) {
                this.f13388c.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f13388c;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f13388c;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f13388c;
        if (drawable != null && drawable.isStateful()) {
            this.f13388c.setState(getDrawableState());
        }
    }

    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f13388c;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
                unscheduleDrawable(this.f13388c);
            }
            this.f13388c = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f13391f == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public Drawable getForeground() {
        return this.f13388c;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f13387b = z | this.f13387b;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f13387b = true;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f13388c;
        if (drawable != null) {
            if (this.f13387b) {
                this.f13387b = false;
                Rect rect = this.f13389d;
                Rect rect2 = this.f13390e;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f13386a) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f13391f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @TargetApi(21)
    public void drawableHotspotChanged(float f2, float f3) {
        super.drawableHotspotChanged(f2, f3);
        Drawable drawable = this.f13388c;
        if (drawable != null) {
            drawable.setHotspot(f2, f3);
        }
    }
}
