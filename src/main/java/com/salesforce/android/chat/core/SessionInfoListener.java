package com.salesforce.android.chat.core;

import com.salesforce.android.chat.core.model.ChatSessionInfo;

public interface SessionInfoListener {
    void onSessionInfoReceived(ChatSessionInfo chatSessionInfo);
}
