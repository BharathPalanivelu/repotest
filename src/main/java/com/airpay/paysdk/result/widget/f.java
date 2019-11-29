package com.airpay.paysdk.result.widget;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.airpay.paysdk.result.d;

public abstract class f extends LinearLayout {
    public f(Context context) {
        super(context);
    }

    public void setFieldTextWidth(int i) {
        if (i > 0) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof d) {
                    ((d) childAt).setFieldWidth(i);
                }
            }
        }
    }

    public int getFieldMeasuredMaxWidth() {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (childAt instanceof d)) {
                i = Math.max(i, ((d) childAt).getFieldMeasuredWidth());
            }
        }
        return i;
    }
}
