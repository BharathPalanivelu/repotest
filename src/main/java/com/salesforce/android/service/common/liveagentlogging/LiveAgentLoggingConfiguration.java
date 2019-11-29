package com.salesforce.android.service.common.liveagentlogging;

import com.salesforce.android.service.common.utilities.threading.Timer;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LiveAgentLoggingConfiguration implements Serializable {
    public static final String EXTRA_ID = "com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingConfiguration";
    protected static final String[] LIVE_AGENT_PODS = {"la1-c1-dfw.salesforceliveagent.com", "la1-c2-dfw.salesforceliveagent.com", "la2-c1-dfw.salesforceliveagent.com", "la2-c2-dfw.salesforceliveagent.com", "la1-c1-phx.salesforceliveagent.com", "la1-c2-phx.salesforceliveagent.com", "la2-c1-phx.salesforceliveagent.com", "la2-c2-phx.salesforceliveagent.com"};
    private final long mFlushTimerDelay;
    private final String[] mLiveAgentPods;
    private final int mLiveAgentSessionTimeoutMs;
    private final int mMaxQueuedEvents;

    protected LiveAgentLoggingConfiguration(Builder builder) {
        this.mLiveAgentPods = (String[]) builder.mLiveAgentPods.toArray(new String[0]);
        this.mLiveAgentSessionTimeoutMs = builder.mLiveAgentSessionTimeoutMs;
        this.mMaxQueuedEvents = builder.mMaxQueuedEvents;
        this.mFlushTimerDelay = builder.mFlushTimerDelay;
    }

    public String[] getLiveAgentPods() {
        return this.mLiveAgentPods;
    }

    public int getLiveAgentSessionTimeoutMs() {
        return this.mLiveAgentSessionTimeoutMs;
    }

    public int getMaxQueuedEvents() {
        return this.mMaxQueuedEvents;
    }

    public long getFlushTimerDelay() {
        return this.mFlushTimerDelay;
    }

    public static class Builder {
        protected long mFlushTimerDelay = Timer.DEFAULT_TIMER_DELAY_MS;
        protected List<String> mLiveAgentPods = new ArrayList();
        protected int mLiveAgentSessionTimeoutMs = 20000;
        protected int mMaxQueuedEvents = 10;

        public Builder addLiveAgentPod(String str) {
            this.mLiveAgentPods.add(str);
            return this;
        }

        public Builder liveAgentSessionTimeoutMs(int i) {
            this.mLiveAgentSessionTimeoutMs = i;
            return this;
        }

        public Builder maxQueuedEvents(int i) {
            this.mMaxQueuedEvents = i;
            return this;
        }

        public Builder flushTimerDelayMs(long j) {
            this.mFlushTimerDelay = j;
            return this;
        }

        public LiveAgentLoggingConfiguration build() {
            if (this.mLiveAgentPods.isEmpty()) {
                this.mLiveAgentPods.addAll(Arrays.asList(LiveAgentLoggingConfiguration.LIVE_AGENT_PODS));
            }
            for (String checkValidLiveAgentPod : this.mLiveAgentPods) {
                Arguments.checkValidLiveAgentPod(checkValidLiveAgentPod);
            }
            return new LiveAgentLoggingConfiguration(this);
        }
    }
}
