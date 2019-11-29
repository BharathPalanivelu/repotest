package com.devspark.robototextview.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.k;
import com.devspark.robototextview.b;

public class RobotoEditText extends k {
    public RobotoEditText(Context context) {
        this(context, (AttributeSet) null);
    }

    public RobotoEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            b.a(this, context, attributeSet);
        }
    }

    public RobotoEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (!isInEditMode()) {
            b.a(this, context, attributeSet);
        }
    }
}
