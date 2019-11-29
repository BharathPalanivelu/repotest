package com.airpay.paysdk.base.ui.weidget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class BPLoadingLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private BPLoadingView f3870a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3871b = false;

    public BPLoadingLayout(Context context) {
        super(context);
        a(context);
    }

    public BPLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public BPLoadingLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        this.f3870a = new BPLoadingView(context);
        addView(this.f3870a, 0, new FrameLayout.LayoutParams(-2, -2, 17));
    }

    public void setLoadingOn(boolean z) {
        if (this.f3871b != z) {
            this.f3871b = z;
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = 4;
                if (i2 >= getChildCount()) {
                    break;
                }
                View childAt = getChildAt(i2);
                if (!this.f3871b) {
                    i3 = 0;
                }
                childAt.setVisibility(i3);
                getChildAt(i2).setEnabled(!this.f3871b);
                i2++;
            }
            this.f3870a.changeLoadingState(this.f3871b);
            BPLoadingView bPLoadingView = this.f3870a;
            if (!this.f3871b) {
                i = 4;
            }
            bPLoadingView.setVisibility(i);
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            setAlpha(1.0f);
        } else {
            setAlpha(0.3f);
        }
    }
}
