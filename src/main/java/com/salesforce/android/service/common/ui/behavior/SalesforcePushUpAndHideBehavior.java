package com.salesforce.android.service.common.ui.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class SalesforcePushUpAndHideBehavior extends CoordinatorLayout.b {
    public SalesforcePushUpAndHideBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return coordinatorLayout.indexOfChild(view2) == coordinatorLayout.indexOfChild(view) + 1;
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view2 == null || view2.getHeight() <= 0) {
            return false;
        }
        float bottom = ((float) ((view.getBottom() - view2.getTop()) * -1)) + view2.getTranslationY();
        view.setTranslationY(bottom - (((float) view.getHeight()) * (bottom / ((float) view2.getHeight()))));
        return true;
    }
}
