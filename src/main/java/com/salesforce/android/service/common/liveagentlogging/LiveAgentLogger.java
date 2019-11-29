package com.salesforce.android.service.common.liveagentlogging;

import android.content.Context;
import com.salesforce.android.service.common.liveagentlogging.internal.service.LiveAgentLoggingServiceConnection;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class LiveAgentLogger {
    private final LiveAgentLoggingConfiguration mConfiguration;
    private final LiveAgentLoggingServiceConnection mServiceConnection;

    protected LiveAgentLogger(Builder builder) {
        this.mConfiguration = builder.mConfiguration;
        this.mServiceConnection = builder.mServiceConnectionBuilder.build();
    }

    public Async<LiveAgentLoggingSession> bind(Context context) {
        return this.mServiceConnection.bindToService(context, this.mServiceConnection.createServiceIntent(context, this.mConfiguration));
    }

    public void unbind() {
        this.mServiceConnection.unbindFromService();
    }

    public static class Builder {
        protected LiveAgentLoggingConfiguration mConfiguration;
        protected LiveAgentLoggingServiceConnection.Builder mServiceConnectionBuilder;

        public Builder configuration(LiveAgentLoggingConfiguration liveAgentLoggingConfiguration) {
            this.mConfiguration = liveAgentLoggingConfiguration;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder serviceConnectionBuilder(LiveAgentLoggingServiceConnection.Builder builder) {
            this.mServiceConnectionBuilder = builder;
            return this;
        }

        public LiveAgentLogger build() {
            Arguments.checkNotNull(this.mConfiguration);
            if (this.mServiceConnectionBuilder == null) {
                this.mServiceConnectionBuilder = new LiveAgentLoggingServiceConnection.Builder();
            }
            return new LiveAgentLogger(this);
        }
    }
}
