package com.salesforce.android.service.common.ui.behavior;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.salesforce.android.service.common.ui.R;

public class SalesforceSqueezeBehavior extends CoordinatorLayout.b {
    private int mAboveViewId;
    private int mBelowViewId;

    public SalesforceSqueezeBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SalesforceSqueezeBehavior, 0, 0);
        try {
            this.mAboveViewId = obtainStyledAttributes.getResourceId(R.styleable.SalesforceSqueezeBehavior_salesforce_squeeze_beneath_view, 0);
            this.mBelowViewId = obtainStyledAttributes.getResourceId(R.styleable.SalesforceSqueezeBehavior_salesforce_squeeze_over_view, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2.getId() == this.mAboveViewId || view2.getId() == this.mBelowViewId;
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        View findViewById = coordinatorLayout.findViewById(this.mAboveViewId);
        View findViewById2 = coordinatorLayout.findViewById(this.mBelowViewId);
        int bottom = findViewById != null ? findViewById.getBottom() : coordinatorLayout.getBottom();
        int i = 0;
        int height = findViewById != null ? findViewById.getHeight() : 0;
        int translationY = findViewById != null ? (int) findViewById.getTranslationY() : 0;
        int height2 = findViewById2 != null ? findViewById2.getHeight() : 0;
        if (findViewById2 != null) {
            i = (int) findViewById2.getTranslationY();
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = (((coordinatorLayout.getHeight() - bottom) - translationY) - height2) + i;
        view.setLayoutParams(layoutParams);
        view.setTranslationY((float) height);
        return true;
    }
}
