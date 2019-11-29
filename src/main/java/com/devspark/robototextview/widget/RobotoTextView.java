package com.devspark.robototextview.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.devspark.robototextview.b;

public class RobotoTextView extends AppCompatTextView {
    public RobotoTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RobotoTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            b.a(this, context, attributeSet);
        }
    }

    public RobotoTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (!isInEditMode()) {
            b.a(this, context, attributeSet);
        }
    }
}
