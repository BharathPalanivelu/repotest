package com.salesforce.android.service.common.liveagentclient.lifecycle;

import com.salesforce.android.service.common.utilities.lifecycle.LifecycleMetric;

public enum LiveAgentMetric implements LifecycleMetric {
    Initiated,
    SessionInfoReceived,
    ConnectionEstablished(30000),
    Ending,
    Deleted;
    
    private int mTimeoutMs;

    private LiveAgentMetric(int i) {
        this.mTimeoutMs = i;
    }

    public Integer getTimeoutMs() {
        return Integer.valueOf(this.mTimeoutMs);
    }
}
