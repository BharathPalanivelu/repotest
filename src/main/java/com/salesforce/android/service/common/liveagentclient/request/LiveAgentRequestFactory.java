package com.salesforce.android.service.common.liveagentclient.request;

import com.salesforce.android.service.common.liveagentclient.SessionInfo;

public interface LiveAgentRequestFactory {
    CreateSessionRequest createCreateSessionRequest();

    DeleteSessionRequest createDeleteSessionRequest(SessionInfo sessionInfo);

    MessagesRequest createMessagesRequest(SessionInfo sessionInfo);

    ReconnectRequest createReconnectRequest(SessionInfo sessionInfo, long j);
}
