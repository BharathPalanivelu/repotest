package com.salesforce.android.service.common.ui.internal.text;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.salesforce.android.service.common.ui.R;

public class SalesforceStyleHelper {
    private final AttributeSet mAttributeSet;
    private final Context mContext;
    private StyleSpan mTextStyle;
    private final Typeface mTypeface = parseStyleAttributes();

    public static SalesforceStyleHelper initialize(Context context, AttributeSet attributeSet) {
        return new SalesforceStyleHelper(context, attributeSet);
    }

    SalesforceStyleHelper(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        this.mAttributeSet = attributeSet;
    }

    /* access modifiers changed from: package-private */
    public Typeface parseStyleAttributes() {
        TypedArray salesforceTextViewTypedArray = getSalesforceTextViewTypedArray();
        TypedArray textStyleTypedArray = getTextStyleTypedArray();
        try {
            Typeface salesforceTypeface = getSalesforceTypeface(salesforceTextViewTypedArray);
            this.mTextStyle = new StyleSpan(getTextStyle(textStyleTypedArray, getTextStyleResourceIdentifier()));
            return salesforceTypeface;
        } finally {
            salesforceTextViewTypedArray.recycle();
            textStyleTypedArray.recycle();
        }
    }

    public Typeface getTypeface() {
        return this.mTypeface;
    }

    /* access modifiers changed from: package-private */
    public TypedArray getSalesforceTextViewTypedArray() {
        return this.mContext.getTheme().obtainStyledAttributes(this.mAttributeSet, R.styleable.SalesforceTextView, R.attr.salesforceFontStyle, 0);
    }

    /* access modifiers changed from: package-private */
    public Typeface getSalesforceTypeface(TypedArray typedArray) {
        String string = typedArray.getString(R.styleable.SalesforceTextView_salesforceFont);
        if (string == null || string.isEmpty()) {
            return null;
        }
        return TypefaceFactory.createFromAsset(this.mContext.getAssets(), string);
    }

    public CharSequence applyTextStyle(CharSequence charSequence) {
        if (!(this.mTextStyle == null || charSequence == null || charSequence.length() < 1)) {
            if (!(charSequence instanceof Spannable)) {
                charSequence = new SpannableString(charSequence);
            }
            setSpan((Spannable) charSequence, this.mTextStyle);
        }
        return charSequence;
    }

    /* access modifiers changed from: package-private */
    public TypedArray getTextStyleTypedArray() {
        return this.mContext.obtainStyledAttributes(this.mAttributeSet, new int[]{16842903});
    }

    /* access modifiers changed from: package-private */
    public int getTextStyleResourceIdentifier() {
        TypedValue typedValue = new TypedValue();
        this.mContext.getTheme().resolveAttribute(16842903, typedValue, true);
        return typedValue.data;
    }

    /* access modifiers changed from: package-private */
    public int getTextStyle(TypedArray typedArray, int i) {
        return typedArray.getInt(i, 0);
    }

    /* access modifiers changed from: package-private */
    public void setSpan(Spannable spannable, StyleSpan styleSpan) {
        spannable.setSpan(styleSpan, 0, spannable.length(), 33);
    }
}
