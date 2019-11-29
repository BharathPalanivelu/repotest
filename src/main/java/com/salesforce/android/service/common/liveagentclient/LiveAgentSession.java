package com.salesforce.android.service.common.liveagentclient;

import android.content.Context;
import com.salesforce.android.service.common.liveagentclient.handler.CreateSessionHandler;
import com.salesforce.android.service.common.liveagentclient.handler.DeleteSessionHandler;
import com.salesforce.android.service.common.liveagentclient.handler.MessagesHandler;
import com.salesforce.android.service.common.liveagentclient.integrity.LiveAgentQueueRequestListener;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentMetric;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState;
import com.salesforce.android.service.common.liveagentclient.request.InternalLiveAgentRequestFactory;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequestFactory;
import com.salesforce.android.service.common.liveagentclient.response.ReconnectResponse;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleEvaluator;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleListener;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.concurrent.atomic.AtomicInteger;

public class LiveAgentSession implements MessagesHandler.ReconnectListener, LiveAgentQueueRequestListener, LifecycleListener<LiveAgentState, LiveAgentMetric> {
    protected static final ServiceLogger log = ServiceLogging.getLogger(LiveAgentSession.class);
    private final CreateSessionHandler mCreateSessionHandler;
    private final DeleteSessionHandler mDeleteSessionHandler;
    private final LifecycleEvaluator<LiveAgentState, LiveAgentMetric> mLifecycleEvaluator;
    private final LiveAgentClient mLiveAgentClient;
    private final MessagesHandler mMessagesHandler;
    protected AtomicInteger mSequenceNumber = new AtomicInteger();
    private final SessionListenerNotifier mSessionListenerNotifier;

    LiveAgentSession(Builder builder) {
        this.mLiveAgentClient = builder.mLiveAgentClient;
        this.mSessionListenerNotifier = builder.mSessionListenerNotifier;
        this.mCreateSessionHandler = builder.mCreateSessionHandler;
        this.mMessagesHandler = builder.mMessagesHandler;
        this.mDeleteSessionHandler = builder.mDeleteSessionHandler;
        this.mMessagesHandler.setReconnectListener(this);
        this.mLifecycleEvaluator = builder.mLifecycleEvaluator.setMilestoneState(LiveAgentState.Deleting);
        this.mLifecycleEvaluator.addListener(this);
    }

    public LiveAgentSession endSessionOnMessagesError(boolean z) {
        this.mMessagesHandler.endSessionOnMessagesError(z);
        return this;
    }

    public LiveAgentSession addSessionListener(SessionListener sessionListener) {
        this.mSessionListenerNotifier.addSessionListener(sessionListener);
        return this;
    }

    public LiveAgentSession removeSessionListener(SessionListener sessionListener) {
        this.mSessionListenerNotifier.removeSessionListener(sessionListener);
        return this;
    }

    public LiveAgentSession addMessagesListener(MessagesListener messagesListener) {
        this.mSessionListenerNotifier.addMessagesListener(messagesListener);
        return this;
    }

    public LiveAgentSession removeMessagesListener(MessagesListener messagesListener) {
        this.mSessionListenerNotifier.removeMessagesListener(messagesListener);
        return this;
    }

    public void createSession() {
        this.mLifecycleEvaluator.setMetricSatisfied(LiveAgentMetric.Initiated).evaluateState();
    }

    public void endSession() {
        this.mLifecycleEvaluator.moveToMilestone().evaluateState();
    }

    public void setSessionTimeoutMs(int i) {
        if (i > 0) {
            this.mMessagesHandler.setHeartbeatTimeoutMs(i);
        }
    }

    public <T> Async<T> onRequestPending(LiveAgentRequest liveAgentRequest, Class<T> cls) {
        int incrementAndGet = this.mSequenceNumber.incrementAndGet();
        log.debug("Handling pending request #{}, {}", Integer.valueOf(incrementAndGet), liveAgentRequest.getClass().getSimpleName());
        return this.mLiveAgentClient.send(liveAgentRequest, cls, incrementAndGet).onError(new Async.ErrorHandler() {
            public void handleError(Async<?> async, Throwable th) {
                LiveAgentSession.this.mSequenceNumber.decrementAndGet();
            }
        });
    }

    public void onStateChanged(LiveAgentState liveAgentState, LiveAgentState liveAgentState2) {
        if (liveAgentState == LiveAgentState.Connecting) {
            log.info("Creating LiveAgent Session...");
        } else if (liveAgentState == LiveAgentState.LongPolling) {
            log.info("Starting LiveAgent heartbeat (Long polling, MessagesRequest)");
        } else if (liveAgentState == LiveAgentState.Deleting) {
            log.info("Ending LiveAgent Session");
        } else if (liveAgentState == LiveAgentState.Ended) {
            log.info("LiveAgent Session has ended");
        }
        this.mSessionListenerNotifier.onSessionStateChanged(liveAgentState, liveAgentState2);
    }

    public void onMetricTimeout(LiveAgentMetric liveAgentMetric) {
        this.mLifecycleEvaluator.moveToMilestone().evaluateState();
    }

    public void onReconnect(ReconnectResponse reconnectResponse, SessionInfo sessionInfo) {
        if (reconnectResponse.isSequenceResetRequested()) {
            this.mSequenceNumber.set(0);
        }
        if (sessionInfo != null) {
            this.mSessionListenerNotifier.onSessionCreated(new SessionInfo(sessionInfo.getSessionId(), sessionInfo.getSessionKey(), reconnectResponse.getAffinityToken(), sessionInfo.getPollingTimeoutMs()));
        }
    }

    public static class Builder {
        private Context mContext;
        protected CreateSessionHandler mCreateSessionHandler;
        protected DeleteSessionHandler mDeleteSessionHandler;
        protected LifecycleEvaluator<LiveAgentState, LiveAgentMetric> mLifecycleEvaluator;
        protected LiveAgentClient mLiveAgentClient;
        protected LiveAgentRequestFactory mLiveAgentRequestFactory = new InternalLiveAgentRequestFactory();
        protected MessagesHandler mMessagesHandler;
        protected SessionListenerNotifier mSessionListenerNotifier;

        public Builder with(Context context) {
            this.mContext = context;
            return this;
        }

        public Builder liveAgentClient(LiveAgentClient liveAgentClient) {
            this.mLiveAgentClient = liveAgentClient;
            return this;
        }

        public Builder lifecycleEvaluator(LifecycleEvaluator<LiveAgentState, LiveAgentMetric> lifecycleEvaluator) {
            this.mLifecycleEvaluator = lifecycleEvaluator;
            return this;
        }

        public Builder sessionListenerNotifier(SessionListenerNotifier sessionListenerNotifier) {
            this.mSessionListenerNotifier = sessionListenerNotifier;
            return this;
        }

        public Builder createSessionHandler(CreateSessionHandler createSessionHandler) {
            this.mCreateSessionHandler = createSessionHandler;
            return this;
        }

        public Builder messagesHandler(MessagesHandler messagesHandler) {
            this.mMessagesHandler = messagesHandler;
            return this;
        }

        public Builder deleteSessionHandler(DeleteSessionHandler deleteSessionHandler) {
            this.mDeleteSessionHandler = deleteSessionHandler;
            return this;
        }

        public LiveAgentSession build() {
            Arguments.checkNotNull(this.mContext);
            Arguments.checkNotNull(this.mLiveAgentClient);
            int integer = this.mContext.getResources().getInteger(R.integer.salesforce_live_agent_message_retry_timeout_ms);
            if (this.mLifecycleEvaluator == null) {
                this.mLifecycleEvaluator = new LifecycleEvaluator.Builder().build(LiveAgentState.class, LiveAgentMetric.class);
            }
            if (this.mSessionListenerNotifier == null) {
                this.mSessionListenerNotifier = new SessionListenerNotifier();
            }
            if (this.mCreateSessionHandler == null) {
                this.mCreateSessionHandler = new CreateSessionHandler(this.mLiveAgentClient, this.mLiveAgentRequestFactory, this.mSessionListenerNotifier, this.mLifecycleEvaluator);
            }
            if (this.mMessagesHandler == null) {
                this.mMessagesHandler = new MessagesHandler.Builder().liveAgentClient(this.mLiveAgentClient).liveAgentRequestFactory(this.mLiveAgentRequestFactory).sessionListenerNotifier(this.mSessionListenerNotifier).lifecycleEvaluator(this.mLifecycleEvaluator).retryTimeoutMs(integer).build();
            }
            if (this.mDeleteSessionHandler == null) {
                this.mDeleteSessionHandler = new DeleteSessionHandler(this.mLiveAgentClient, this.mLiveAgentRequestFactory, this.mSessionListenerNotifier, this.mLifecycleEvaluator);
            }
            return new LiveAgentSession(this);
        }
    }
}
