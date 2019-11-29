package com.salesforce.android.chat.core.internal.client;

import com.salesforce.android.chat.core.AgentListener;
import com.salesforce.android.chat.core.ChatBotListener;
import com.salesforce.android.chat.core.FileTransferAssistant;
import com.salesforce.android.chat.core.FileTransferRequestListener;
import com.salesforce.android.chat.core.QueueListener;
import com.salesforce.android.chat.core.SessionInfoListener;
import com.salesforce.android.chat.core.SessionStateListener;
import com.salesforce.android.chat.core.internal.service.ChatServiceConnection;
import com.salesforce.android.chat.core.model.AgentInformation;
import com.salesforce.android.chat.core.model.ChatEndReason;
import com.salesforce.android.chat.core.model.ChatFooterMenu;
import com.salesforce.android.chat.core.model.ChatMessage;
import com.salesforce.android.chat.core.model.ChatSessionInfo;
import com.salesforce.android.chat.core.model.ChatSessionState;
import com.salesforce.android.chat.core.model.ChatWindowButtonMenu;
import com.salesforce.android.chat.core.model.ChatWindowMenu;
import com.salesforce.android.chat.core.model.FileTransferStatus;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ChatClientListenerNotifier implements AgentListener, ChatBotListener, FileTransferRequestListener, QueueListener, SessionInfoListener, SessionStateListener, ChatServiceConnection.OnDisconnectedListener {
    private Set<AgentListener> mAgentListeners = Collections.newSetFromMap(new ConcurrentHashMap());
    private Set<ChatBotListener> mChatBotListeners = Collections.newSetFromMap(new ConcurrentHashMap());
    private Set<FileTransferRequestListener> mFileTransferRequestListeners = Collections.newSetFromMap(new ConcurrentHashMap());
    private Set<QueueListener> mQueueListeners = Collections.newSetFromMap(new ConcurrentHashMap());
    private Set<SessionInfoListener> mSessionInfoListeners = Collections.newSetFromMap(new ConcurrentHashMap());
    private Set<SessionStateListener> mSessionStateListeners = Collections.newSetFromMap(new ConcurrentHashMap());

    public void onAgentJoined(AgentInformation agentInformation) {
        for (AgentListener onAgentJoined : this.mAgentListeners) {
            onAgentJoined.onAgentJoined(agentInformation);
        }
    }

    public void onChatMessageReceived(ChatMessage chatMessage) {
        for (AgentListener onChatMessageReceived : this.mAgentListeners) {
            onChatMessageReceived.onChatMessageReceived(chatMessage);
        }
    }

    public void onAgentIsTyping(boolean z) {
        for (AgentListener onAgentIsTyping : this.mAgentListeners) {
            onAgentIsTyping.onAgentIsTyping(z);
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

    public void onSessionStateChange(ChatSessionState chatSessionState) {
        for (SessionStateListener onSessionStateChange : this.mSessionStateListeners) {
            onSessionStateChange.onSessionStateChange(chatSessionState);
        }
    }

    public void onSessionEnded(ChatEndReason chatEndReason) {
        for (SessionStateListener onSessionEnded : this.mSessionStateListeners) {
            onSessionEnded.onSessionEnded(chatEndReason);
        }
    }

    public void onSessionInfoReceived(ChatSessionInfo chatSessionInfo) {
        for (SessionInfoListener onSessionInfoReceived : this.mSessionInfoListeners) {
            onSessionInfoReceived.onSessionInfoReceived(chatSessionInfo);
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

    public void onServiceDisconnected() {
        onSessionEnded(ChatEndReason.Unknown);
    }

    /* access modifiers changed from: package-private */
    public void addAgentListener(AgentListener agentListener) {
        this.mAgentListeners.add(agentListener);
    }

    /* access modifiers changed from: package-private */
    public void removeAgentListener(AgentListener agentListener) {
        this.mAgentListeners.remove(agentListener);
    }

    /* access modifiers changed from: package-private */
    public void addSessionStateListener(SessionStateListener sessionStateListener) {
        this.mSessionStateListeners.add(sessionStateListener);
    }

    /* access modifiers changed from: package-private */
    public void removeSessionStateListener(SessionStateListener sessionStateListener) {
        this.mSessionStateListeners.remove(sessionStateListener);
    }

    /* access modifiers changed from: package-private */
    public void addSessionInfoListener(SessionInfoListener sessionInfoListener) {
        this.mSessionInfoListeners.add(sessionInfoListener);
    }

    /* access modifiers changed from: package-private */
    public void removeSessionInfoListener(SessionInfoListener sessionInfoListener) {
        this.mSessionInfoListeners.remove(sessionInfoListener);
    }

    /* access modifiers changed from: package-private */
    public void addQueueListener(QueueListener queueListener) {
        this.mQueueListeners.add(queueListener);
    }

    /* access modifiers changed from: package-private */
    public void removeQueueListener(QueueListener queueListener) {
        this.mQueueListeners.remove(queueListener);
    }

    /* access modifiers changed from: package-private */
    public void addFileTransferRequestListener(FileTransferRequestListener fileTransferRequestListener) {
        this.mFileTransferRequestListeners.add(fileTransferRequestListener);
    }

    /* access modifiers changed from: package-private */
    public void removeFileTransferRequestListener(FileTransferRequestListener fileTransferRequestListener) {
        this.mFileTransferRequestListeners.remove(fileTransferRequestListener);
    }

    /* access modifiers changed from: package-private */
    public void addChatBotListener(ChatBotListener chatBotListener) {
        this.mChatBotListeners.add(chatBotListener);
    }

    /* access modifiers changed from: package-private */
    public void removeChatBotListener(ChatBotListener chatBotListener) {
        this.mChatBotListeners.remove(chatBotListener);
    }
}
