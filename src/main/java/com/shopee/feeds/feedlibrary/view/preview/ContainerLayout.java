package com.shopee.feeds.feedlibrary.view.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.garena.android.appkit.tools.b;

public class ContainerLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private float f28608a = 1.0f;

    /* renamed from: b  reason: collision with root package name */
    private float f28609b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    private int f28610c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f28611d = true;

    public ContainerLayout(Context context) {
        super(context);
        a(context);
    }

    public ContainerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ContainerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        this.f28610c = b.b();
    }

    public void a(float f2, float f3) {
        this.f28608a = f2;
        this.f28609b = f3;
        invalidate();
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        float f2 = this.f28608a;
        float f3 = this.f28609b;
        if (f2 == f3) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.f28610c, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f28610c, 1073741824));
        } else if (f2 > f3) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.f28610c, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f28610c, 1073741824));
        } else if (f3 > f2) {
            int i3 = this.f28610c;
            super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) (((float) i3) * (f2 / (f3 * 1.0f))), 1073741824), View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f28611d) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setmScale(boolean z) {
        this.f28611d = z;
    }
}
