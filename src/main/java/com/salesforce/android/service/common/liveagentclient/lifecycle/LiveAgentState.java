package com.salesforce.android.service.common.liveagentclient.lifecycle;

import com.salesforce.android.service.common.utilities.lifecycle.LifecycleState;

public enum LiveAgentState implements LifecycleState<LiveAgentMetric> {
    Initializing(LiveAgentMetric.Initiated),
    Connecting(LiveAgentMetric.ConnectionEstablished, LiveAgentMetric.SessionInfoReceived),
    LongPolling(LiveAgentMetric.Ending),
    Deleting(LiveAgentMetric.Deleted),
    Ended(new LiveAgentMetric[0]);
    
    private final LiveAgentMetric[] mMetrics;

    private LiveAgentState(LiveAgentMetric... liveAgentMetricArr) {
        this.mMetrics = liveAgentMetricArr;
    }

    public LiveAgentMetric[] getMetrics() {
        return this.mMetrics;
    }
}
