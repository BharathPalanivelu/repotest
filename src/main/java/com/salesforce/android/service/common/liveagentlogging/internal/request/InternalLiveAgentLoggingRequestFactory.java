package com.salesforce.android.service.common.liveagentlogging.internal.request;

import com.salesforce.android.service.common.liveagentclient.SessionInfo;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import java.util.List;

public class InternalLiveAgentLoggingRequestFactory implements LiveAgentLoggingRequestFactory {
    public BatchedEvents createBatchedEvents(SessionInfo sessionInfo, List<BaseEvent> list) {
        return new BatchedEvents(sessionInfo.getSessionKey(), sessionInfo.getAffinityToken(), list);
    }
}
