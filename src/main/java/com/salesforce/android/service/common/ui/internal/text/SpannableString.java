package com.salesforce.android.service.common.ui.internal.text;

import android.text.GetChars;
import android.text.Spannable;

public class SpannableString implements GetChars, Spannable, CharSequence {
    private android.text.SpannableString mSpannableString;

    public SpannableString(CharSequence charSequence) {
        this.mSpannableString = new android.text.SpannableString(charSequence);
    }

    public void getChars(int i, int i2, char[] cArr, int i3) {
        this.mSpannableString.getChars(i, i2, cArr, i3);
    }

    public void setSpan(Object obj, int i, int i2, int i3) {
        this.mSpannableString.setSpan(obj, i, i2, i3);
    }

    public void removeSpan(Object obj) {
        this.mSpannableString.removeSpan(obj);
    }

    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        return this.mSpannableString.getSpans(i, i2, cls);
    }

    public int getSpanStart(Object obj) {
        return this.mSpannableString.getSpanStart(obj);
    }

    public int getSpanEnd(Object obj) {
        return this.mSpannableString.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.mSpannableString.getSpanFlags(obj);
    }

    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.mSpannableString.nextSpanTransition(i, i2, cls);
    }

    public int length() {
        return this.mSpannableString.length();
    }

    public char charAt(int i) {
        return this.mSpannableString.charAt(i);
    }

    public CharSequence subSequence(int i, int i2) {
        return this.mSpannableString.subSequence(i, i2);
    }

    public int hashCode() {
        return this.mSpannableString.hashCode();
    }

    public boolean equals(Object obj) {
        return this.mSpannableString.equals(obj);
    }

    public String toString() {
        return this.mSpannableString.toString();
    }
}
