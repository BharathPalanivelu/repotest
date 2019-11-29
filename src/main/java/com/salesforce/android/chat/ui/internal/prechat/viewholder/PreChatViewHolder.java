package com.salesforce.android.chat.ui.internal.prechat.viewholder;

import com.salesforce.android.chat.core.model.ChatUserData;

public interface PreChatViewHolder {

    public interface OnUpdateListener {
        void onPreChatFieldUpdate(ChatUserData chatUserData);
    }

    void setData(ChatUserData chatUserData);

    void setOnUpdateListener(OnUpdateListener onUpdateListener);
}
