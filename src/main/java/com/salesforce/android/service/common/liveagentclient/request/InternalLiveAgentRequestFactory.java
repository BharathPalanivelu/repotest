package com.salesforce.android.service.common.liveagentclient.request;

import com.salesforce.android.service.common.liveagentclient.SessionInfo;

public class InternalLiveAgentRequestFactory implements LiveAgentRequestFactory {
    public CreateSessionRequest createCreateSessionRequest() {
        return new CreateSessionRequest();
    }

    public MessagesRequest createMessagesRequest(SessionInfo sessionInfo) {
        return new MessagesRequest(sessionInfo.getSessionKey(), sessionInfo.getAffinityToken());
    }

    public DeleteSessionRequest createDeleteSessionRequest(SessionInfo sessionInfo) {
        return new DeleteSessionRequest(sessionInfo.getSessionKey(), sessionInfo.getAffinityToken());
    }

    public ReconnectRequest createReconnectRequest(SessionInfo sessionInfo, long j) {
        return new ReconnectRequest(sessionInfo.getSessionKey(), j);
    }
}
