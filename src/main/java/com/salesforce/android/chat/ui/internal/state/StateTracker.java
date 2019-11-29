package com.salesforce.android.chat.ui.internal.state;

import com.salesforce.android.chat.core.ChatClient;
import com.salesforce.android.chat.core.SessionInfoListener;
import com.salesforce.android.chat.core.SessionStateListener;
import com.salesforce.android.chat.core.model.ChatEndReason;
import com.salesforce.android.chat.core.model.ChatSessionInfo;
import com.salesforce.android.chat.core.model.ChatSessionState;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class StateTracker implements SessionInfoListener, SessionStateListener {
    private ChatSessionState mCurrentChatSessionState = ChatSessionState.Ready;
    private Set<SessionInfoListener> mSessionInfoListeners = Collections.newSetFromMap(new ConcurrentHashMap());
    private Set<SessionStateListener> mSessionStateListeners = Collections.newSetFromMap(new ConcurrentHashMap());

    public ChatSessionState getCurrentChatSessionState() {
        return this.mCurrentChatSessionState;
    }

    public void setChatClient(ChatClient chatClient) {
        this.mCurrentChatSessionState = chatClient.getCurrentSessionState();
        chatClient.addSessionStateListener(this);
        chatClient.addSessionInfoListener(this);
    }

    public void addSessionStateListener(SessionStateListener sessionStateListener) {
        this.mSessionStateListeners.add(sessionStateListener);
    }

    public void removeSessionStateListener(SessionStateListener sessionStateListener) {
        this.mSessionStateListeners.remove(sessionStateListener);
    }

    public void addSessionInfoListener(SessionInfoListener sessionInfoListener) {
        this.mSessionInfoListeners.add(sessionInfoListener);
    }

    public void removeSessionInfoListener(SessionInfoListener sessionInfoListener) {
        this.mSessionInfoListeners.remove(sessionInfoListener);
    }

    public void onSessionStateChange(ChatSessionState chatSessionState) {
        this.mCurrentChatSessionState = chatSessionState;
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
}
