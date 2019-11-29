package com.salesforce.android.chat.ui.internal.chatfeed.model;

public class ChatBotTransferWaitingIndicator {
    private OnCancelListener mOnCancelListener;

    public interface OnCancelListener {
        void onChatBotTransferCancelButtonSelected();
    }

    ChatBotTransferWaitingIndicator() {
    }

    public void setCancelButtonListener(OnCancelListener onCancelListener) {
        this.mOnCancelListener = onCancelListener;
    }

    public void setCancelButtonSelected() {
        OnCancelListener onCancelListener = this.mOnCancelListener;
        if (onCancelListener != null) {
            onCancelListener.onChatBotTransferCancelButtonSelected();
        }
    }
}
