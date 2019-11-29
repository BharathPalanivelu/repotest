package com.salesforce.android.chat.core;

import com.salesforce.android.chat.core.model.ChatFooterMenu;
import com.salesforce.android.chat.core.model.ChatSentMessageReceipt;
import com.salesforce.android.chat.core.model.ChatSessionState;
import com.salesforce.android.chat.core.model.ChatWindowButtonMenu;
import com.salesforce.android.chat.core.model.ChatWindowMenu;
import com.salesforce.android.service.common.utilities.control.Async;

public interface ChatClient {
    ChatClient addAgentListener(AgentListener agentListener);

    ChatClient addChatBotListener(ChatBotListener chatBotListener);

    ChatClient addFileTransferRequestListener(FileTransferRequestListener fileTransferRequestListener);

    ChatClient addQueueListener(QueueListener queueListener);

    ChatClient addSessionInfoListener(SessionInfoListener sessionInfoListener);

    ChatClient addSessionStateListener(SessionStateListener sessionStateListener);

    void endChatSession();

    ChatSessionState getCurrentSessionState();

    ChatClient removeAgentListener(AgentListener agentListener);

    ChatClient removeChatBotListener(ChatBotListener chatBotListener);

    ChatClient removeFileTransferRequestListener(FileTransferRequestListener fileTransferRequestListener);

    ChatClient removeQueueListener(QueueListener queueListener);

    ChatClient removeSessionInfoListener(SessionInfoListener sessionInfoListener);

    ChatClient removeSessionStateListener(SessionStateListener sessionStateListener);

    Async<Void> sendButtonSelection(int i);

    Async<Void> sendButtonSelection(ChatWindowButtonMenu.Button button);

    Async<ChatSentMessageReceipt> sendChatMessage(String str);

    Async<Void> sendFooterMenuSelection(int i, String str);

    Async<Void> sendFooterMenuSelection(ChatFooterMenu.MenuItem menuItem);

    Async<Void> sendMenuSelection(int i);

    Async<Void> sendMenuSelection(ChatWindowMenu.MenuItem menuItem);

    Async<Void> sendSneakPeekMessage(String str);

    Async<Void> setIsUserTyping(boolean z);
}
