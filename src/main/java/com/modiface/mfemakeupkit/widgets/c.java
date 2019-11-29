package com.modiface.mfemakeupkit.widgets;

import android.view.MotionEvent;
import android.view.View;

class c implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MFEBeforeAfterMakeupView f15465a;

    c(MFEBeforeAfterMakeupView mFEBeforeAfterMakeupView) {
        this.f15465a = mFEBeforeAfterMakeupView;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        MFEBeforeAfterMakeupView mFEBeforeAfterMakeupView = this.f15465a;
        if (mFEBeforeAfterMakeupView.mShowBefore) {
            mFEBeforeAfterMakeupView.overlayViewOnTouch(view, motionEvent);
        }
        return this.f15465a.mShowBefore;
    }
}
