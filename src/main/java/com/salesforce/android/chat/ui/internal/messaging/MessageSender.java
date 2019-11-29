package com.salesforce.android.chat.ui.internal.messaging;

import com.salesforce.android.chat.core.ChatClient;
import com.salesforce.android.chat.core.exception.SessionDoesNotExistException;
import com.salesforce.android.chat.core.model.AgentInformation;
import com.salesforce.android.chat.core.model.ChatFooterMenu;
import com.salesforce.android.chat.core.model.ChatSentMessageReceipt;
import com.salesforce.android.chat.core.model.ChatWindowButtonMenu;
import com.salesforce.android.chat.core.model.ChatWindowMenu;
import com.salesforce.android.chat.ui.ChatEventListener;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class MessageSender implements AgentInformationListener {
    private ChatClient mChatClient;
    private ChatEventListener mChatEventListener;
    private boolean mIsSneakPeekEnabled;

    public void onAgentJoinedConference(String str) {
    }

    public void onAgentLeftConference(String str) {
    }

    private MessageSender(Builder builder) {
        builder.mMessageReceiver.addAgentInformationListener(this);
        this.mChatEventListener = builder.mChatEventListener;
    }

    public void setChatClient(ChatClient chatClient) {
        this.mChatClient = chatClient;
    }

    public Async<ChatSentMessageReceipt> send(String str) {
        if (this.mChatClient == null) {
            return BasicAsync.error(new SessionDoesNotExistException());
        }
        ChatEventListener chatEventListener = this.mChatEventListener;
        if (chatEventListener != null) {
            chatEventListener.processedOutgoingMessage(str);
        }
        return this.mChatClient.sendChatMessage(str);
    }

    public void sendSneakPeek(String str) {
        ChatClient chatClient = this.mChatClient;
        if (chatClient != null && this.mIsSneakPeekEnabled) {
            chatClient.sendSneakPeekMessage(str);
        }
    }

    public void setIsUserTyping(boolean z) {
        ChatClient chatClient = this.mChatClient;
        if (chatClient != null && !this.mIsSneakPeekEnabled) {
            chatClient.setIsUserTyping(z);
        }
    }

    public Async<Void> sendMenuSelection(ChatWindowMenu.MenuItem menuItem) {
        if (this.mChatClient == null) {
            return BasicAsync.error(new SessionDoesNotExistException());
        }
        ChatEventListener chatEventListener = this.mChatEventListener;
        if (chatEventListener != null) {
            chatEventListener.didSelectMenuItem(menuItem);
        }
        return this.mChatClient.sendMenuSelection(menuItem);
    }

    public Async<Void> sendButtonSelection(ChatWindowButtonMenu.Button button) {
        if (this.mChatClient == null) {
            return BasicAsync.error(new SessionDoesNotExistException());
        }
        ChatEventListener chatEventListener = this.mChatEventListener;
        if (chatEventListener != null) {
            chatEventListener.didSelectButtonItem(button);
        }
        return this.mChatClient.sendButtonSelection(button);
    }

    public Async<Void> sendFooterMenuSelection(ChatFooterMenu.MenuItem menuItem) {
        if (this.mChatClient == null) {
            return BasicAsync.error(new SessionDoesNotExistException());
        }
        ChatEventListener chatEventListener = this.mChatEventListener;
        if (chatEventListener != null) {
            chatEventListener.didSelectFooterMenuItem(menuItem);
        }
        return this.mChatClient.sendFooterMenuSelection(menuItem);
    }

    public void addChatEventListener(ChatEventListener chatEventListener) {
        this.mChatEventListener = chatEventListener;
    }

    public void clearChatEventListener() {
        this.mChatEventListener = null;
    }

    public void onAgentJoined(AgentInformation agentInformation) {
        this.mIsSneakPeekEnabled = agentInformation.isSneakPeekEnabled();
        ChatEventListener chatEventListener = this.mChatEventListener;
        if (chatEventListener != null) {
            chatEventListener.agentJoined(agentInformation);
        }
    }

    public void onTransferToButtonInitiated() {
        ChatEventListener chatEventListener = this.mChatEventListener;
        if (chatEventListener != null) {
            chatEventListener.transferToButtonInitiated();
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public ChatEventListener mChatEventListener;
        /* access modifiers changed from: private */
        public MessageReceiver mMessageReceiver;

        public Builder messageReceiver(MessageReceiver messageReceiver) {
            this.mMessageReceiver = messageReceiver;
            return this;
        }

        public Builder chatEventListener(ChatEventListener chatEventListener) {
            this.mChatEventListener = chatEventListener;
            return this;
        }

        public MessageSender build() {
            Arguments.checkNotNull(this.mMessageReceiver);
            return new MessageSender(this);
        }
    }
}
