package com.salesforce.android.service.common.ui.views;

import android.content.Context;
import android.text.Layout;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.salesforce.android.service.common.ui.internal.text.SalesforceStyleHelper;
import java.lang.reflect.Field;

public class SalesforceTextView extends AppCompatTextView {
    private Object mBaseEditor;
    private Field mDiscardNextActionUp;
    private Field mIgnoreActionUpEvent;
    private final SalesforceStyleHelper mStyleHelper;

    public SalesforceTextView(Context context) {
        super(context);
        this.mBaseEditor = null;
        this.mDiscardNextActionUp = null;
        this.mIgnoreActionUpEvent = null;
        this.mStyleHelper = null;
    }

    public SalesforceTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SalesforceTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBaseEditor = null;
        this.mDiscardNextActionUp = null;
        this.mIgnoreActionUpEvent = null;
        this.mStyleHelper = SalesforceStyleHelper.initialize(context, attributeSet);
        setTypeface(this.mStyleHelper.getTypeface());
        super.setText(this.mStyleHelper.applyTextStyle(getText()));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isTextSelectable() || !(getText() instanceof Spannable) || getAutoLinkMask() != 0 || !getLinksClickable() || !isEnabled() || getLayout() == null) {
            return super.onTouchEvent(motionEvent);
        }
        return checkLinksOnTouch(motionEvent);
    }

    private boolean checkLinksOnTouch(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        boolean discardNextActionUp = getDiscardNextActionUp();
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (discardNextActionUp && action == 1) {
            return onTouchEvent;
        }
        if (action == 1 && !getIgnoreActionUpEvent() && isFocused()) {
            int x = ((int) motionEvent.getX()) - getTotalPaddingLeft();
            int y = ((int) motionEvent.getY()) - getTotalPaddingTop();
            int scrollX = x + getScrollX();
            int scrollY = y + getScrollY();
            Layout layout = getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) scrollX);
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((Spannable) getText()).getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (clickableSpanArr.length != 0) {
                clickableSpanArr[0].onClick(this);
                return true;
            }
        }
        return onTouchEvent;
    }

    private boolean getDiscardNextActionUp() {
        Object obj = this.mBaseEditor;
        if (obj == null) {
            return false;
        }
        try {
            return this.mDiscardNextActionUp.getBoolean(obj);
        } catch (IllegalAccessException unused) {
            return false;
        }
    }

    private boolean getIgnoreActionUpEvent() {
        Object obj = this.mBaseEditor;
        if (obj == null) {
            return false;
        }
        try {
            return this.mIgnoreActionUpEvent.getBoolean(obj);
        } catch (IllegalAccessException | IllegalArgumentException unused) {
            return false;
        }
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        SalesforceStyleHelper salesforceStyleHelper = this.mStyleHelper;
        if (salesforceStyleHelper != null) {
            charSequence = salesforceStyleHelper.applyTextStyle(charSequence);
        }
        super.setText(charSequence, bufferType);
    }
}
