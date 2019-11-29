package com.salesforce.android.chat.core.internal.liveagent;

import com.salesforce.android.chat.core.model.AgentInformation;
import com.salesforce.android.chat.core.model.ChatMessage;

public interface AgentListener {
    void onAgentJoined(AgentInformation agentInformation);

    void onAgentJoinedConference(String str);

    void onAgentLeftConference(String str);

    void onChatMessageReceived(ChatMessage chatMessage);

    void onIsAgentTyping(boolean z);

    void onTransferToButtonInitiated();
}
