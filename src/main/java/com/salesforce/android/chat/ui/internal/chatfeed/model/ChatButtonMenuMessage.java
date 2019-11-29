package com.salesforce.android.chat.ui.internal.chatfeed.model;

import com.salesforce.android.chat.core.model.ChatWindowButtonMenu;
import com.salesforce.android.service.common.ui.internal.messaging.Message;
import java.util.Date;

public class ChatButtonMenuMessage implements Message {
    private final ChatWindowButtonMenu.Button[] mButtons;
    private OnChatButtonSelectedListener mChatButtonSelectedListener;
    private final Date mTimestamp;

    public interface OnChatButtonSelectedListener {
        void onChatButtonSelected(ChatButtonMenuMessage chatButtonMenuMessage, ChatWindowButtonMenu.Button button);
    }

    ChatButtonMenuMessage(Date date, ChatWindowButtonMenu.Button... buttonArr) {
        this.mTimestamp = date;
        this.mButtons = buttonArr;
    }

    public Date getTimestamp() {
        return this.mTimestamp;
    }

    public ChatWindowButtonMenu.Button[] getButtons() {
        return this.mButtons;
    }

    public void setSelectedButton(ChatWindowButtonMenu.Button button) {
        OnChatButtonSelectedListener onChatButtonSelectedListener = this.mChatButtonSelectedListener;
        if (onChatButtonSelectedListener != null) {
            onChatButtonSelectedListener.onChatButtonSelected(this, button);
        }
    }

    public void setOnChatButtonSelectedListener(OnChatButtonSelectedListener onChatButtonSelectedListener) {
        this.mChatButtonSelectedListener = onChatButtonSelectedListener;
    }
}
