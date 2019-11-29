package com.google.android.material.internal;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

public class j extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    Drawable f13407a;

    /* renamed from: b  reason: collision with root package name */
    Rect f13408b;

    /* renamed from: c  reason: collision with root package name */
    private Rect f13409c;

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f13408b != null && this.f13407a != null) {
            int save = canvas.save();
            canvas.translate((float) getScrollX(), (float) getScrollY());
            this.f13409c.set(0, 0, width, this.f13408b.top);
            this.f13407a.setBounds(this.f13409c);
            this.f13407a.draw(canvas);
            this.f13409c.set(0, height - this.f13408b.bottom, width, height);
            this.f13407a.setBounds(this.f13409c);
            this.f13407a.draw(canvas);
            this.f13409c.set(0, this.f13408b.top, this.f13408b.left, height - this.f13408b.bottom);
            this.f13407a.setBounds(this.f13409c);
            this.f13407a.draw(canvas);
            this.f13409c.set(width - this.f13408b.right, this.f13408b.top, width, height - this.f13408b.bottom);
            this.f13407a.setBounds(this.f13409c);
            this.f13407a.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f13407a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f13407a;
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
    }
}
