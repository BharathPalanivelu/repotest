package com.salesforce.android.chat.core.internal.liveagent.lifecycle;

import com.salesforce.android.service.common.utilities.lifecycle.LifecycleState;

public enum LiveAgentChatState implements LifecycleState<LiveAgentChatMetric> {
    Ready(new LiveAgentChatMetric[0]),
    Verification(LiveAgentChatMetric.ServerSwitchChecked),
    Initializing(LiveAgentChatMetric.SessionInitialized),
    CreatingSession(LiveAgentChatMetric.SessionCreated),
    RequestingChat(LiveAgentChatMetric.EnteredChatQueue),
    InQueue(LiveAgentChatMetric.AgentJoined),
    Chatting(LiveAgentChatMetric.ChatEnding),
    EndingSession(LiveAgentChatMetric.SessionDeleted),
    Ended(new LiveAgentChatMetric[0]);
    
    private final LiveAgentChatMetric[] mLiveAgentChatMetrics;

    private LiveAgentChatState(LiveAgentChatMetric... liveAgentChatMetricArr) {
        this.mLiveAgentChatMetrics = liveAgentChatMetricArr;
    }

    public LiveAgentChatMetric[] getMetrics() {
        return this.mLiveAgentChatMetrics;
    }

    public boolean isPostSession() {
        return ordinal() > Chatting.ordinal();
    }
}
