package com.salesforce.android.chat.ui.internal.messaging;

import com.salesforce.android.chat.core.model.ChatMessage;

public interface AgentMessageListener {
    void onChatMessageReceived(ChatMessage chatMessage);
}
