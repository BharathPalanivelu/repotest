package com.salesforce.android.service.common.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.appcompat.widget.f;
import com.salesforce.android.service.common.ui.R;
import com.salesforce.android.service.common.ui.internal.text.SalesforceStyleHelper;

public class SalesforceButton extends f {
    private final SalesforceStyleHelper mStyleHelper;

    public SalesforceButton(Context context) {
        super(context);
        this.mStyleHelper = null;
    }

    public SalesforceButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyle);
    }

    public SalesforceButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStyleHelper = SalesforceStyleHelper.initialize(context, attributeSet);
        setTypeface(this.mStyleHelper.getTypeface());
        super.setText(this.mStyleHelper.applyTextStyle(getText()));
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        SalesforceStyleHelper salesforceStyleHelper = this.mStyleHelper;
        if (salesforceStyleHelper != null) {
            charSequence = salesforceStyleHelper.applyTextStyle(charSequence);
        }
        super.setText(charSequence, bufferType);
    }

    public boolean performClick() {
        super.performClick();
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            performClick();
        }
        return true;
    }
}
