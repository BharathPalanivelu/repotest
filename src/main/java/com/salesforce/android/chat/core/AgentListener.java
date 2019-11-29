package com.salesforce.android.chat.core;

import com.salesforce.android.chat.core.model.AgentInformation;
import com.salesforce.android.chat.core.model.ChatMessage;

public interface AgentListener {
    void onAgentIsTyping(boolean z);

    void onAgentJoined(AgentInformation agentInformation);

    void onAgentJoinedConference(String str);

    void onAgentLeftConference(String str);

    void onChatMessageReceived(ChatMessage chatMessage);

    void onTransferToButtonInitiated();
}
