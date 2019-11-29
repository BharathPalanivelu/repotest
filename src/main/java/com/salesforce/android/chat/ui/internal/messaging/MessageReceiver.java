package com.salesforce.android.chat.ui.internal.messaging;

import com.salesforce.android.chat.core.AgentListener;
import com.salesforce.android.chat.core.ChatBotListener;
import com.salesforce.android.chat.core.ChatClient;
import com.salesforce.android.chat.core.QueueListener;
import com.salesforce.android.chat.core.model.AgentInformation;
import com.salesforce.android.chat.core.model.ChatFooterMenu;
import com.salesforce.android.chat.core.model.ChatMessage;
import com.salesforce.android.chat.core.model.ChatWindowButtonMenu;
import com.salesforce.android.chat.core.model.ChatWindowMenu;
import com.salesforce.android.chat.ui.ChatEventListener;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MessageReceiver implements AgentListener, ChatBotListener, QueueListener {
    private AgentInformation mAgentInformation;
    Set<AgentInformationListener> mAgentInformationListeners = Collections.newSetFromMap(new ConcurrentHashMap());
    Set<AgentMessageListener> mAgentMessageListeners = Collections.newSetFromMap(new ConcurrentHashMap());
    Set<AgentStatusListener> mAgentStatusListeners = Collections.newSetFromMap(new ConcurrentHashMap());
    Set<ChatBotListener> mChatBotListeners = Collections.newSetFromMap(new ConcurrentHashMap());
    private ChatClient mChatClient;
    private ChatEventListener mChatEventListener;
    private boolean mIsAgentTyping;
    Set<QueueListener> mQueueListeners = Collections.newSetFromMap(new ConcurrentHashMap());
    private int mQueuePosition;

    public void setChatClient(ChatClient chatClient) {
        this.mChatClient = chatClient;
        ChatClient chatClient2 = this.mChatClient;
        if (chatClient2 != null) {
            chatClient2.addAgentListener(this).addQueueListener(this).addChatBotListener(this);
        }
    }

    public AgentInformation getAgentInformation() {
        return this.mAgentInformation;
    }

    public boolean isAgentTyping() {
        return this.mIsAgentTyping;
    }

    public int getQueuePosition() {
        return this.mQueuePosition;
    }

    public void addAgentInformationListener(AgentInformationListener agentInformationListener) {
        this.mAgentInformationListeners.add(agentInformationListener);
    }

    public void removeAgentInformationListener(AgentInformationListener agentInformationListener) {
        this.mAgentInformationListeners.remove(agentInformationListener);
    }

    public void addAgentMessageListener(AgentMessageListener agentMessageListener) {
        this.mAgentMessageListeners.add(agentMessageListener);
    }

    public void removeAgentMessageListener(AgentMessageListener agentMessageListener) {
        this.mAgentMessageListeners.remove(agentMessageListener);
    }

    public void addAgentStatusListener(AgentStatusListener agentStatusListener) {
        this.mAgentStatusListeners.add(agentStatusListener);
    }

    public void removeAgentStatusListener(AgentStatusListener agentStatusListener) {
        this.mAgentStatusListeners.remove(agentStatusListener);
    }

    public void addQueueListener(QueueListener queueListener) {
        this.mQueueListeners.add(queueListener);
    }

    public void removeQueueListener(QueueListener queueListener) {
        this.mQueueListeners.remove(queueListener);
    }

    public void addChatBotListener(ChatBotListener chatBotListener) {
        this.mChatBotListeners.add(chatBotListener);
    }

    public void removeChatBotListener(ChatBotListener chatBotListener) {
        this.mChatBotListeners.remove(chatBotListener);
    }

    public void addChatEventListener(ChatEventListener chatEventListener) {
        this.mChatEventListener = chatEventListener;
    }

    public void clearChatEventListener() {
        this.mChatEventListener = null;
    }

    public void teardown() {
        ChatClient chatClient = this.mChatClient;
        if (chatClient != null) {
            chatClient.removeAgentListener(this);
        }
        this.mAgentInformationListeners.clear();
        this.mAgentMessageListeners.clear();
        this.mAgentStatusListeners.clear();
        this.mQueueListeners.clear();
        this.mChatBotListeners.clear();
        this.mChatEventListener = null;
    }

    public void onAgentJoined(AgentInformation agentInformation) {
        this.mAgentInformation = agentInformation;
        for (AgentInformationListener onAgentJoined : this.mAgentInformationListeners) {
            onAgentJoined.onAgentJoined(agentInformation);
        }
    }

    public void onChatMessageReceived(ChatMessage chatMessage) {
        for (AgentMessageListener onChatMessageReceived : this.mAgentMessageListeners) {
            onChatMessageReceived.onChatMessageReceived(chatMessage);
        }
        ChatEventListener chatEventListener = this.mChatEventListener;
        if (chatEventListener != null) {
            chatEventListener.didReceiveMessage(chatMessage);
        }
    }

    public void onAgentIsTyping(boolean z) {
        this.mIsAgentTyping = z;
        for (AgentStatusListener onAgentIsTyping : this.mAgentStatusListeners) {
            onAgentIsTyping.onAgentIsTyping(z);
        }
        ChatEventListener chatEventListener = this.mChatEventListener;
        if (chatEventListener != null) {
            chatEventListener.agentIsTyping(z);
        }
    }

    public void onTransferToButtonInitiated() {
        for (AgentInformationListener onTransferToButtonInitiated : this.mAgentInformationListeners) {
            onTransferToButtonInitiated.onTransferToButtonInitiated();
        }
    }

    public void onAgentJoinedConference(String str) {
        for (AgentInformationListener onAgentJoinedConference : this.mAgentInformationListeners) {
            onAgentJoinedConference.onAgentJoinedConference(str);
        }
    }

    public void onAgentLeftConference(String str) {
        for (AgentInformationListener onAgentLeftConference : this.mAgentInformationListeners) {
            onAgentLeftConference.onAgentLeftConference(str);
        }
    }

    public void onQueuePositionUpdate(int i) {
        this.mQueuePosition = i;
        for (QueueListener onQueuePositionUpdate : this.mQueueListeners) {
            onQueuePositionUpdate.onQueuePositionUpdate(i);
        }
    }

    public void onChatMenuReceived(ChatWindowMenu chatWindowMenu) {
        for (ChatBotListener onChatMenuReceived : this.mChatBotListeners) {
            onChatMenuReceived.onChatMenuReceived(chatWindowMenu);
        }
    }

    public void onChatFooterMenuReceived(ChatFooterMenu chatFooterMenu) {
        for (ChatBotListener onChatFooterMenuReceived : this.mChatBotListeners) {
            onChatFooterMenuReceived.onChatFooterMenuReceived(chatFooterMenu);
        }
    }

    public void onChatButtonMenuReceived(ChatWindowButtonMenu chatWindowButtonMenu) {
        for (ChatBotListener onChatButtonMenuReceived : this.mChatBotListeners) {
            onChatButtonMenuReceived.onChatButtonMenuReceived(chatWindowButtonMenu);
        }
    }
}
