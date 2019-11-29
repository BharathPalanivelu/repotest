package com.salesforce.android.chat.core.internal.liveagent;

import com.salesforce.android.chat.core.ChatBotListener;
import com.salesforce.android.chat.core.FileTransferAssistant;
import com.salesforce.android.chat.core.FileTransferRequestListener;
import com.salesforce.android.chat.core.QueueListener;
import com.salesforce.android.chat.core.internal.liveagent.lifecycle.LiveAgentChatState;
import com.salesforce.android.chat.core.model.AgentInformation;
import com.salesforce.android.chat.core.model.ChatEndReason;
import com.salesforce.android.chat.core.model.ChatFooterMenu;
import com.salesforce.android.chat.core.model.ChatMessage;
import com.salesforce.android.chat.core.model.ChatSessionInfo;
import com.salesforce.android.chat.core.model.ChatWindowButtonMenu;
import com.salesforce.android.chat.core.model.ChatWindowMenu;
import com.salesforce.android.chat.core.model.FileTransferStatus;
import com.salesforce.android.service.common.liveagentclient.SessionInfo;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ChatListenerNotifier implements ChatBotListener, FileTransferRequestListener, QueueListener, AgentListener, ChatStateListener {
    private Set<AgentListener> mAgentListeners = Collections.newSetFromMap(new ConcurrentHashMap());
    private Set<ChatBotListener> mChatBotListeners = Collections.newSetFromMap(new ConcurrentHashMap());
    private Set<ChatStateListener> mChatStateListeners = Collections.newSetFromMap(new ConcurrentHashMap());
    private Set<FileTransferRequestListener> mFileTransferRequestListeners = Collections.newSetFromMap(new ConcurrentHashMap());
    private Set<QueueListener> mQueueListeners = Collections.newSetFromMap(new ConcurrentHashMap());

    public void onSessionCreated(SessionInfo sessionInfo) {
        for (ChatStateListener onSessionCreated : this.mChatStateListeners) {
            onSessionCreated.onSessionCreated(sessionInfo);
        }
    }

    public void onChatSessionCreated(ChatSessionInfo chatSessionInfo) {
        for (ChatStateListener onChatSessionCreated : this.mChatStateListeners) {
            onChatSessionCreated.onChatSessionCreated(chatSessionInfo);
        }
    }

    public void onStateChanged(LiveAgentChatState liveAgentChatState, LiveAgentChatState liveAgentChatState2) {
        for (ChatStateListener onStateChanged : this.mChatStateListeners) {
            onStateChanged.onStateChanged(liveAgentChatState, liveAgentChatState2);
        }
    }

    public void onChatEnded(ChatEndReason chatEndReason) {
        for (ChatStateListener onChatEnded : this.mChatStateListeners) {
            onChatEnded.onChatEnded(chatEndReason);
        }
    }

    public void onVerificationFailed() {
        for (ChatStateListener onVerificationFailed : this.mChatStateListeners) {
            onVerificationFailed.onVerificationFailed();
        }
    }

    public void onAgentJoined(AgentInformation agentInformation) {
        for (AgentListener onAgentJoined : this.mAgentListeners) {
            onAgentJoined.onAgentJoined(agentInformation);
        }
    }

    public void onIsAgentTyping(boolean z) {
        for (AgentListener onIsAgentTyping : this.mAgentListeners) {
            onIsAgentTyping.onIsAgentTyping(z);
        }
    }

    public void onChatMessageReceived(ChatMessage chatMessage) {
        for (AgentListener onChatMessageReceived : this.mAgentListeners) {
            onChatMessageReceived.onChatMessageReceived(chatMessage);
        }
    }

    public void onTransferToButtonInitiated() {
        for (AgentListener onTransferToButtonInitiated : this.mAgentListeners) {
            onTransferToButtonInitiated.onTransferToButtonInitiated();
        }
    }

    public void onAgentJoinedConference(String str) {
        for (AgentListener onAgentJoinedConference : this.mAgentListeners) {
            onAgentJoinedConference.onAgentJoinedConference(str);
        }
    }

    public void onAgentLeftConference(String str) {
        for (AgentListener onAgentLeftConference : this.mAgentListeners) {
            onAgentLeftConference.onAgentLeftConference(str);
        }
    }

    public void onQueuePositionUpdate(int i) {
        for (QueueListener onQueuePositionUpdate : this.mQueueListeners) {
            onQueuePositionUpdate.onQueuePositionUpdate(i);
        }
    }

    public void onFileTransferRequest(FileTransferAssistant fileTransferAssistant) {
        for (FileTransferRequestListener onFileTransferRequest : this.mFileTransferRequestListeners) {
            onFileTransferRequest.onFileTransferRequest(fileTransferAssistant);
        }
    }

    public void onFileTransferStatusChanged(FileTransferStatus fileTransferStatus) {
        for (FileTransferRequestListener onFileTransferStatusChanged : this.mFileTransferRequestListeners) {
            onFileTransferStatusChanged.onFileTransferStatusChanged(fileTransferStatus);
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

    /* access modifiers changed from: package-private */
    public void addChatStateListener(ChatStateListener chatStateListener) {
        this.mChatStateListeners.add(chatStateListener);
    }

    /* access modifiers changed from: package-private */
    public void addAgentListener(AgentListener agentListener) {
        this.mAgentListeners.add(agentListener);
    }

    /* access modifiers changed from: package-private */
    public void addQueueListener(QueueListener queueListener) {
        this.mQueueListeners.add(queueListener);
    }

    /* access modifiers changed from: package-private */
    public void addFileTransferRequestListener(FileTransferRequestListener fileTransferRequestListener) {
        this.mFileTransferRequestListeners.add(fileTransferRequestListener);
    }

    /* access modifiers changed from: package-private */
    public void addChatBotListener(ChatBotListener chatBotListener) {
        this.mChatBotListeners.add(chatBotListener);
    }
}
