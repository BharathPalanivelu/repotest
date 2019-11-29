package com.salesforce.android.service.common.liveagentlogging.internal.service;

import android.os.Binder;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingSession;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class LiveAgentLoggingServiceBinder extends Binder {
    private final LiveAgentLoggingSession mLoggingSession;

    protected LiveAgentLoggingServiceBinder(Builder builder) {
        this.mLoggingSession = builder.mLoggingSession;
    }

    /* access modifiers changed from: package-private */
    public LiveAgentLoggingSession getLiveAgentLoggingSession() {
        return this.mLoggingSession;
    }

    public static class Builder {
        protected LiveAgentLoggingSession mLoggingSession;

        /* access modifiers changed from: package-private */
        public Builder liveAgentLoggingSession(LiveAgentLoggingSession liveAgentLoggingSession) {
            this.mLoggingSession = liveAgentLoggingSession;
            return this;
        }

        /* access modifiers changed from: package-private */
        public LiveAgentLoggingServiceBinder build() {
            Arguments.checkNotNull(this.mLoggingSession);
            return new LiveAgentLoggingServiceBinder(this);
        }
    }
}
