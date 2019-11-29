package com.devspark.robototextview.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.q;
import com.devspark.robototextview.b;

public class RobotoRadioButton extends q {
    public RobotoRadioButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public RobotoRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            b.a(this, context, attributeSet);
        }
    }

    public RobotoRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (!isInEditMode()) {
            b.a(this, context, attributeSet);
        }
    }
}
