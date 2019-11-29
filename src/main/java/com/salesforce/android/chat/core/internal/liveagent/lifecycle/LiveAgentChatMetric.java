package com.salesforce.android.chat.core.internal.liveagent.lifecycle;

import com.salesforce.android.service.common.utilities.lifecycle.LifecycleMetric;

public enum LiveAgentChatMetric implements LifecycleMetric {
    ServerSwitchChecked,
    SessionInitialized,
    SessionCreated(10000),
    EnteredChatQueue(10000),
    AgentJoined,
    ChatEnding,
    SessionDeleted;
    
    private Integer mTimeoutMs;

    private LiveAgentChatMetric(int i) {
        this.mTimeoutMs = Integer.valueOf(i);
    }

    public Integer getTimeoutMs() {
        return this.mTimeoutMs;
    }
}
