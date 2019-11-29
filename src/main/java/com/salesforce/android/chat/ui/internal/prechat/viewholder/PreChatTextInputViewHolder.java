package com.salesforce.android.chat.ui.internal.prechat.viewholder;

import android.widget.EditText;
import androidx.recyclerview.widget.RecyclerView;
import com.salesforce.android.chat.core.model.ChatUserData;
import com.salesforce.android.chat.ui.internal.prechat.viewholder.PreChatViewHolder;
import com.salesforce.android.chat.ui.model.PreChatTextInputField;
import com.salesforce.android.service.common.ui.internal.text.SalesforceTextWatcher;
import com.salesforce.android.service.common.ui.views.SalesforceTextInputLayout;

public class PreChatTextInputViewHolder extends RecyclerView.w implements PreChatViewHolder {
    private PreChatViewHolder.OnUpdateListener mOnUpdateListener;
    private final SalesforceTextInputLayout mSalesforceTextInputLayout;
    public PreChatTextInputField mTextInputField;
    private SalesforceTextWatcher mTextWatcher = new SalesforceTextWatcher() {
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            PreChatTextInputViewHolder.this.processUpdate(charSequence);
        }
    };

    public PreChatTextInputViewHolder(SalesforceTextInputLayout salesforceTextInputLayout) {
        super(salesforceTextInputLayout);
        this.mSalesforceTextInputLayout = salesforceTextInputLayout;
    }

    public void setData(ChatUserData chatUserData) {
        if (chatUserData instanceof PreChatTextInputField) {
            this.mTextInputField = (PreChatTextInputField) chatUserData;
            EditText editText = this.mSalesforceTextInputLayout.getEditText();
            editText.removeTextChangedListener(this.mTextWatcher);
            this.mSalesforceTextInputLayout.setCounterMaxLength(this.mTextInputField.getMaxValueLength());
            this.mSalesforceTextInputLayout.setCounterEnabled(this.mTextInputField.isCounterEnabled());
            editText.setId(this.mTextInputField.getAgentLabel().hashCode());
            editText.setInputType(this.mTextInputField.getInputType());
            String displayLabel = this.mTextInputField.getDisplayLabel();
            if (this.mTextInputField.isRequired()) {
                displayLabel = displayLabel + "*";
            }
            this.mSalesforceTextInputLayout.setHint(displayLabel);
            if (this.mTextInputField.hasValue()) {
                editText.setText(this.mTextInputField.getValue().toString());
            }
            if (this.mTextInputField.isReadOnly()) {
                editText.setEnabled(false);
            }
            editText.addTextChangedListener(this.mTextWatcher);
        }
    }

    public void setOnUpdateListener(PreChatViewHolder.OnUpdateListener onUpdateListener) {
        this.mOnUpdateListener = onUpdateListener;
    }

    /* access modifiers changed from: private */
    public void processUpdate(CharSequence charSequence) {
        PreChatTextInputField preChatTextInputField = this.mTextInputField;
        if (preChatTextInputField != null) {
            preChatTextInputField.setValue((CharSequence) charSequence.toString());
            PreChatViewHolder.OnUpdateListener onUpdateListener = this.mOnUpdateListener;
            if (onUpdateListener != null) {
                onUpdateListener.onPreChatFieldUpdate(this.mTextInputField);
            }
        }
    }
}
