package com.salesforce.android.service.common.liveagentclient;

import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState;
import com.salesforce.android.service.common.liveagentclient.response.MessagesResponse;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SessionListenerNotifier implements MessagesListener, SessionListener {
    Set<MessagesListener> mMessagesListeners = Collections.newSetFromMap(new ConcurrentHashMap());
    Set<SessionListener> mSessionListeners = Collections.newSetFromMap(new ConcurrentHashMap());

    SessionListenerNotifier() {
    }

    public void onSessionCreated(SessionInfo sessionInfo) {
        for (SessionListener onSessionCreated : this.mSessionListeners) {
            onSessionCreated.onSessionCreated(sessionInfo);
        }
    }

    public void onSessionStateChanged(LiveAgentState liveAgentState, LiveAgentState liveAgentState2) {
        for (SessionListener onSessionStateChanged : this.mSessionListeners) {
            onSessionStateChanged.onSessionStateChanged(liveAgentState, liveAgentState2);
        }
    }

    public void onError(Throwable th) {
        for (SessionListener onError : this.mSessionListeners) {
            onError.onError(th);
        }
    }

    public void onMessagesResponse(MessagesResponse messagesResponse) {
        for (MessagesListener onMessagesResponse : this.mMessagesListeners) {
            onMessagesResponse.onMessagesResponse(messagesResponse);
        }
    }

    public SessionListenerNotifier addSessionListener(SessionListener sessionListener) {
        this.mSessionListeners.add(sessionListener);
        return this;
    }

    public SessionListenerNotifier removeSessionListener(SessionListener sessionListener) {
        this.mSessionListeners.remove(sessionListener);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void addMessagesListener(MessagesListener messagesListener) {
        this.mMessagesListeners.add(messagesListener);
    }

    /* access modifiers changed from: package-private */
    public void removeMessagesListener(MessagesListener messagesListener) {
        this.mMessagesListeners.remove(messagesListener);
    }
}
