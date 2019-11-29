package com.devspark.robototextview.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.g;
import com.devspark.robototextview.b;

public class RobotoCheckBox extends g {
    public RobotoCheckBox(Context context) {
        this(context, (AttributeSet) null);
    }

    public RobotoCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            b.a(this, context, attributeSet);
        }
    }

    public RobotoCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (!isInEditMode()) {
            b.a(this, context, attributeSet);
        }
    }
}
