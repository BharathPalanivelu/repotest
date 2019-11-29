package com.modiface.mfemakeupkit.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

class a extends View {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MFEBeforeAfterMakeupView f15463a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    a(MFEBeforeAfterMakeupView mFEBeforeAfterMakeupView, Context context) {
        super(context);
        this.f15463a = mFEBeforeAfterMakeupView;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f15463a.drawOnOverlayView(canvas);
    }
}
