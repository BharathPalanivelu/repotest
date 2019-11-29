package com.salesforce.android.chat.core.internal.liveagent;

import com.salesforce.android.chat.core.internal.liveagent.lifecycle.LiveAgentChatState;
import com.salesforce.android.chat.core.model.ChatEndReason;
import com.salesforce.android.chat.core.model.ChatSessionInfo;
import com.salesforce.android.service.common.liveagentclient.SessionInfo;

public interface ChatStateListener {
    void onChatEnded(ChatEndReason chatEndReason);

    void onChatSessionCreated(ChatSessionInfo chatSessionInfo);

    void onSessionCreated(SessionInfo sessionInfo);

    void onStateChanged(LiveAgentChatState liveAgentChatState, LiveAgentChatState liveAgentChatState2);

    void onVerificationFailed();
}
