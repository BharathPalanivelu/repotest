package com.modiface.mfemakeupkit.widgets;

import android.view.View;
import android.view.ViewGroup;

class b implements View.OnLayoutChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MFEBeforeAfterMakeupView f15464a;

    b(MFEBeforeAfterMakeupView mFEBeforeAfterMakeupView) {
        this.f15464a = mFEBeforeAfterMakeupView;
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i3 - i;
        int i10 = i4 - i2;
        if (i9 > 0 && i10 > 0) {
            ViewGroup.LayoutParams layoutParams = this.f15464a.mCroppedMakeupView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i9, i10);
            }
            layoutParams.width = i9;
            layoutParams.height = i10;
            this.f15464a.mCroppedMakeupView.setLayoutParams(layoutParams);
            this.f15464a.mScrollViewContainer.requestLayout();
            this.f15464a.mScrollView.requestLayout();
            this.f15464a.updateSplit();
        }
    }
}
