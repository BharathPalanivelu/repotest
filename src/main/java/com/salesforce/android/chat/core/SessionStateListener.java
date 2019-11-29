package com.salesforce.android.chat.core;

import com.salesforce.android.chat.core.model.ChatEndReason;
import com.salesforce.android.chat.core.model.ChatSessionState;

public interface SessionStateListener {
    void onSessionEnded(ChatEndReason chatEndReason);

    void onSessionStateChange(ChatSessionState chatSessionState);
}
