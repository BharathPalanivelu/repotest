package com.salesforce.android.service.common.liveagentclient;

import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState;

public interface SessionListener {
    void onError(Throwable th);

    void onSessionCreated(SessionInfo sessionInfo);

    void onSessionStateChanged(LiveAgentState liveAgentState, LiveAgentState liveAgentState2);
}
