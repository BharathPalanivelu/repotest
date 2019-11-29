package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.ui.a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public final class AspectRatioFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private float f12193a;

    /* renamed from: b  reason: collision with root package name */
    private int f12194b;

    public AspectRatioFrameLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12194b = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.C0195a.AspectRatioFrameLayout, 0, 0);
            try {
                this.f12194b = obtainStyledAttributes.getInt(a.C0195a.AspectRatioFrameLayout_resize_mode, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setAspectRatio(float f2) {
        if (this.f12193a != f2) {
            this.f12193a = f2;
            requestLayout();
        }
    }

    public void setResizeMode(int i) {
        if (this.f12194b != i) {
            this.f12194b = i;
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        float f2;
        float f3;
        super.onMeasure(i, i2);
        if (this.f12194b != 3 && this.f12193a > BitmapDescriptorFactory.HUE_RED) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float f4 = (float) measuredWidth;
            float f5 = (float) measuredHeight;
            float f6 = (this.f12193a / (f4 / f5)) - 1.0f;
            if (Math.abs(f6) > 0.01f) {
                int i3 = this.f12194b;
                if (i3 != 1) {
                    if (i3 == 2) {
                        f3 = this.f12193a;
                    } else if (f6 > BitmapDescriptorFactory.HUE_RED) {
                        f2 = this.f12193a;
                    } else {
                        f3 = this.f12193a;
                    }
                    measuredWidth = (int) (f5 * f3);
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
                }
                f2 = this.f12193a;
                measuredHeight = (int) (f4 / f2);
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            }
        }
    }
}
