package com.devspark.robototextview.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.f;
import com.devspark.robototextview.b;

public class RobotoButton extends f {
    public RobotoButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public RobotoButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            b.a(this, context, attributeSet);
        }
    }

    public RobotoButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (!isInEditMode()) {
            b.a(this, context, attributeSet);
        }
    }
}
