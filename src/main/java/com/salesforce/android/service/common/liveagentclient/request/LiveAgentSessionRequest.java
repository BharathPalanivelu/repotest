package com.salesforce.android.service.common.liveagentclient.request;

public interface LiveAgentSessionRequest extends LiveAgentRequest {
    String getAffinityToken();

    String getSessionKey();
}
