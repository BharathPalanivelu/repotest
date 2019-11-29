package com.salesforce.android.service.common.ui.views;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.google.android.material.textfield.c;
import com.salesforce.android.service.common.ui.R;
import com.salesforce.android.service.common.ui.internal.text.SalesforceStyleHelper;

public class SalesforceEditText extends c {
    public SalesforceEditText(Context context) {
        super(context);
    }

    public SalesforceEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public SalesforceEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        final SalesforceStyleHelper initialize = SalesforceStyleHelper.initialize(context, attributeSet);
        setTypeface(initialize.getTypeface());
        setText(initialize.applyTextStyle(getText()));
        addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                initialize.applyTextStyle(editable);
            }
        });
        setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.salesforce_message_input) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if ((motionEvent.getAction() & 255) == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMaxHeight(getMaxGrowHeight());
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: package-private */
    public int getMaxGrowHeight() {
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        if (windowManager == null) {
            return 0;
        }
        windowManager.getDefaultDisplay().getRealSize(new Point());
        Rect rect = new Rect();
        if (getContext() instanceof Activity) {
            ((Activity) getContext()).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        }
        return rect.height() / 2;
    }
}
