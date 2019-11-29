package com.garena.rnrecyclerview.library.sticky.views;

import android.view.View;
import android.widget.FrameLayout;

public class a extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f8636a;

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), this.f8636a);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            getChildAt(i5).layout(0, 0, i3, i4);
        }
    }

    public void requestLayout() {
        super.requestLayout();
        if (getParent() != null) {
            if (getLayoutParams().height > 0) {
                this.f8636a = getLayoutParams().height;
            }
            if (getChildAt(0) != null) {
                this.f8636a = getChildAt(0).getMeasuredHeight();
            }
        }
    }

    public int getRowHeight() {
        return this.f8636a;
    }
}
