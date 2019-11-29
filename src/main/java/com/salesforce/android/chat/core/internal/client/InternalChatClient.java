package com.salesforce.android.chat.core.internal.client;

import com.salesforce.android.chat.core.AgentListener;
import com.salesforce.android.chat.core.ChatAnalyticsEmit;
import com.salesforce.android.chat.core.ChatBotListener;
import com.salesforce.android.chat.core.ChatClient;
import com.salesforce.android.chat.core.FileTransferRequestListener;
import com.salesforce.android.chat.core.QueueListener;
import com.salesforce.android.chat.core.SessionInfoListener;
import com.salesforce.android.chat.core.SessionStateListener;
import com.salesforce.android.chat.core.internal.service.ChatServiceConnection;
import com.salesforce.android.chat.core.internal.service.ChatServiceController;
import com.salesforce.android.chat.core.model.ChatEndReason;
import com.salesforce.android.chat.core.model.ChatFooterMenu;
import com.salesforce.android.chat.core.model.ChatSentMessageReceipt;
import com.salesforce.android.chat.core.model.ChatSessionState;
import com.salesforce.android.chat.core.model.ChatWindowButtonMenu;
import com.salesforce.android.chat.core.model.ChatWindowMenu;
import com.salesforce.android.service.common.utilities.control.Async;

public class InternalChatClient implements ChatClient, SessionStateListener {
    private final ChatClientListenerNotifier mChatClientListenerNotifier;
    private final ChatServiceConnection mChatServiceConnection;
    private final ChatServiceController mChatServiceController;
    private ChatSessionState mCurrentSessionState;

    private InternalChatClient(ChatServiceConnection chatServiceConnection, ChatServiceController chatServiceController, ChatClientListenerNotifier chatClientListenerNotifier) {
        this.mCurrentSessionState = ChatSessionState.Ready;
        this.mChatServiceConnection = chatServiceConnection;
        this.mChatServiceController = chatServiceController;
        this.mChatClientListenerNotifier = chatClientListenerNotifier;
        this.mChatClientListenerNotifier.addSessionStateListener(this);
        this.mChatServiceConnection.setOnDisconnectedListener(this.mChatClientListenerNotifier);
        this.mChatServiceController.setChatClientListenerNotifier(this.mChatClientListenerNotifier);
    }

    public Async<ChatSentMessageReceipt> sendChatMessage(String str) {
        ChatAnalyticsEmit.userSendMessage();
        return this.mChatServiceController.sendChatMessage(str);
    }

    public Async<Void> sendSneakPeekMessage(String str) {
        return this.mChatServiceController.sendSneakPeekMessage(str);
    }

    public Async<Void> setIsUserTyping(boolean z) {
        if (z) {
            ChatAnalyticsEmit.userIsTyping();
        } else {
            ChatAnalyticsEmit.userHasFinishedTyping();
        }
        return this.mChatServiceController.setIsUserTyping(z);
    }

    public Async<Void> sendMenuSelection(int i) {
        return this.mChatServiceController.sendMenuSelection(i);
    }

    public Async<Void> sendMenuSelection(ChatWindowMenu.MenuItem menuItem) {
        return sendMenuSelection(menuItem.getIndex());
    }

    public Async<Void> sendButtonSelection(int i) {
        return this.mChatServiceController.sendButtonSelection(i);
    }

    public Async<Void> sendButtonSelection(ChatWindowButtonMenu.Button button) {
        return sendButtonSelection(button.getIndex());
    }

    public Async<Void> sendFooterMenuSelection(int i, String str) {
        return this.mChatServiceController.sendFooterMenuSelection(i, str);
    }

    public Async<Void> sendFooterMenuSelection(ChatFooterMenu.MenuItem menuItem) {
        return sendFooterMenuSelection(menuItem.getIndex(), menuItem.getDialogId());
    }

    public void endChatSession() {
        ChatAnalyticsEmit.userEndSession();
        this.mChatServiceController.endChatSession();
    }

    public ChatSessionState getCurrentSessionState() {
        return this.mCurrentSessionState;
    }

    public ChatClient addAgentListener(AgentListener agentListener) {
        this.mChatClientListenerNotifier.addAgentListener(agentListener);
        return this;
    }

    public ChatClient removeAgentListener(AgentListener agentListener) {
        this.mChatClientListenerNotifier.removeAgentListener(agentListener);
        return this;
    }

    public ChatClient addSessionStateListener(SessionStateListener sessionStateListener) {
        this.mChatClientListenerNotifier.addSessionStateListener(sessionStateListener);
        return this;
    }

    public ChatClient removeSessionStateListener(SessionStateListener sessionStateListener) {
        this.mChatClientListenerNotifier.removeSessionStateListener(sessionStateListener);
        return this;
    }

    public ChatClient addSessionInfoListener(SessionInfoListener sessionInfoListener) {
        this.mChatClientListenerNotifier.addSessionInfoListener(sessionInfoListener);
        return this;
    }

    public ChatClient removeSessionInfoListener(SessionInfoListener sessionInfoListener) {
        this.mChatClientListenerNotifier.removeSessionInfoListener(sessionInfoListener);
        return this;
    }

    public ChatClient addQueueListener(QueueListener queueListener) {
        this.mChatClientListenerNotifier.addQueueListener(queueListener);
        return this;
    }

    public ChatClient removeQueueListener(QueueListener queueListener) {
        this.mChatClientListenerNotifier.removeQueueListener(queueListener);
        return this;
    }

    public ChatClient addFileTransferRequestListener(FileTransferRequestListener fileTransferRequestListener) {
        this.mChatClientListenerNotifier.addFileTransferRequestListener(fileTransferRequestListener);
        return this;
    }

    public ChatClient removeFileTransferRequestListener(FileTransferRequestListener fileTransferRequestListener) {
        this.mChatClientListenerNotifier.removeFileTransferRequestListener(fileTransferRequestListener);
        return this;
    }

    public ChatClient addChatBotListener(ChatBotListener chatBotListener) {
        this.mChatClientListenerNotifier.addChatBotListener(chatBotListener);
        return this;
    }

    public ChatClient removeChatBotListener(ChatBotListener chatBotListener) {
        this.mChatClientListenerNotifier.removeChatBotListener(chatBotListener);
        return this;
    }

    public void onSessionStateChange(ChatSessionState chatSessionState) {
        ChatAnalyticsEmit.responseLifecycleChange(chatSessionState, this.mCurrentSessionState);
        this.mCurrentSessionState = chatSessionState;
        if (chatSessionState == ChatSessionState.Disconnected) {
            this.mChatServiceConnection.stopService(this.mChatServiceController.getContext());
        }
    }

    public void onSessionEnded(ChatEndReason chatEndReason) {
        ChatAnalyticsEmit.responseSessionEnded(chatEndReason);
    }

    public static class Builder {
        private ChatClientListenerNotifier mChatClientListenerNotifier;

        /* access modifiers changed from: package-private */
        public Builder listenerNotifier(ChatClientListenerNotifier chatClientListenerNotifier) {
            this.mChatClientListenerNotifier = chatClientListenerNotifier;
            return this;
        }

        public InternalChatClient build(ChatServiceConnection chatServiceConnection, ChatServiceController chatServiceController) {
            if (this.mChatClientListenerNotifier == null) {
                this.mChatClientListenerNotifier = new ChatClientListenerNotifier();
            }
            return new InternalChatClient(chatServiceConnection, chatServiceController, this.mChatClientListenerNotifier);
        }
    }
}
