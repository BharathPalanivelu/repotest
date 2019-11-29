package com.salesforce.android.service.common.ui.internal.text;

import android.text.Editable;
import android.text.TextWatcher;

public class SalesforceTextWatcher implements TextWatcher {
    private OnAfterTextChangedListener mOnAfterTextChangedListener;
    private OnBeforeTextChangedListener mOnBeforeTextChangedListener;
    private OnTextChangedListener mOnTextChangedListener;

    public interface OnAfterTextChangedListener {
        void onAfterTextChanged(Editable editable);
    }

    public interface OnBeforeTextChangedListener {
        void onBeforeTextChanged(CharSequence charSequence, int i, int i2, int i3);
    }

    public interface OnTextChangedListener {
        void onTextChanged(CharSequence charSequence, int i, int i2, int i3);
    }

    public void setOnBeforeTextChangedListener(OnBeforeTextChangedListener onBeforeTextChangedListener) {
        this.mOnBeforeTextChangedListener = onBeforeTextChangedListener;
    }

    public void setOnTextChangedListener(OnTextChangedListener onTextChangedListener) {
        this.mOnTextChangedListener = onTextChangedListener;
    }

    public void setOnAfterTextChangedListener(OnAfterTextChangedListener onAfterTextChangedListener) {
        this.mOnAfterTextChangedListener = onAfterTextChangedListener;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        OnBeforeTextChangedListener onBeforeTextChangedListener = this.mOnBeforeTextChangedListener;
        if (onBeforeTextChangedListener != null) {
            onBeforeTextChangedListener.onBeforeTextChanged(charSequence, i, i2, i3);
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        OnTextChangedListener onTextChangedListener = this.mOnTextChangedListener;
        if (onTextChangedListener != null) {
            onTextChangedListener.onTextChanged(charSequence, i, i2, i3);
        }
    }

    public void afterTextChanged(Editable editable) {
        OnAfterTextChangedListener onAfterTextChangedListener = this.mOnAfterTextChangedListener;
        if (onAfterTextChangedListener != null) {
            onAfterTextChangedListener.onAfterTextChanged(editable);
        }
    }
}
