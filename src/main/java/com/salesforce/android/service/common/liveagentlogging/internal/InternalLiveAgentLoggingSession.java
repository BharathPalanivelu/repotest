package com.salesforce.android.service.common.liveagentlogging.internal;

import android.content.Context;
import com.salesforce.android.service.common.liveagentclient.LiveAgentSession;
import com.salesforce.android.service.common.liveagentclient.SessionInfo;
import com.salesforce.android.service.common.liveagentclient.integrity.LiveAgentQueue;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingConfiguration;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingSession;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.salesforce.android.service.common.liveagentlogging.internal.PodConnectionManager;
import com.salesforce.android.service.common.liveagentlogging.internal.request.BatchedEvents;
import com.salesforce.android.service.common.liveagentlogging.internal.request.InternalLiveAgentLoggingRequestFactory;
import com.salesforce.android.service.common.liveagentlogging.internal.request.LiveAgentLoggingRequestFactory;
import com.salesforce.android.service.common.liveagentlogging.internal.response.BatchedEventsResponse;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.HandlerManager;
import com.salesforce.android.service.common.utilities.threading.Timer;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InternalLiveAgentLoggingSession implements LiveAgentLoggingSession, PodConnectionManager.Listener, HandlerManager.OnTimerElapsedListener {
    private static final ServiceLogger log = ServiceLogging.getLogger(InternalLiveAgentLoggingSession.class);
    private final LiveAgentLoggingConfiguration mConfiguration;
    private List<BaseEvent> mEvents = new ArrayList();
    private Set<LiveAgentLoggingSession.Listener> mListeners = new HashSet();
    protected final LiveAgentQueue mLiveAgentQueue;
    private LiveAgentSession mLiveAgentSession;
    private final int mMaxQueuedEvents;
    private final PodConnectionManager mPodConnectionManager;
    private final LiveAgentLoggingRequestFactory mRequestFactory;
    private SessionInfo mSessionInfo;
    private final Timer mTimer;

    protected InternalLiveAgentLoggingSession(Builder builder) {
        this.mPodConnectionManager = builder.mPodConnectionManager.addListener(this);
        this.mRequestFactory = builder.mRequestFactory;
        this.mTimer = builder.mTimerBuilder.onTimerElapsedListener((HandlerManager.OnTimerElapsedListener) this).build();
        this.mConfiguration = builder.mConfiguration;
        this.mMaxQueuedEvents = builder.mConfiguration.getMaxQueuedEvents();
        this.mLiveAgentQueue = builder.mLiveAgentQueueBuilder.useExponentialBackoff(true).build();
    }

    public void queue(BaseEvent baseEvent) {
        log.trace("Queuing a Logging Event: {}", baseEvent.getClass().getSimpleName());
        this.mEvents.add(baseEvent);
        if (this.mEvents.size() == 1) {
            this.mTimer.schedule();
        } else if (this.mEvents.size() >= this.mMaxQueuedEvents) {
            flush();
        }
    }

    public void queue(Collection<? extends BaseEvent> collection) {
        log.trace("Batch queueing {} events", Integer.valueOf(collection.size()));
        this.mEvents.addAll(collection);
        if (this.mEvents.size() == collection.size()) {
            this.mTimer.schedule();
        } else if (this.mEvents.size() >= this.mMaxQueuedEvents) {
            notifyOnFlush(flush());
        }
    }

    public Async<BatchedEventsResponse> flush() {
        ArrayList arrayList;
        if (!this.mPodConnectionManager.isConnected() || this.mLiveAgentSession == null || this.mSessionInfo == null) {
            log.warn("Unable to send logging events without an active LiveAgent session.");
            return BasicAsync.immediate();
        } else if (this.mEvents.isEmpty()) {
            log.debug("There are no queued logging events to send.");
            return BasicAsync.immediate();
        } else {
            synchronized (this) {
                arrayList = new ArrayList(this.mEvents);
                this.mEvents.clear();
                this.mTimer.cancel();
            }
            log.trace("Sending {} queued events [LiveAgent Session ID - {}]", Integer.valueOf(arrayList.size()), this.mSessionInfo.getSessionId());
            final BatchedEvents createBatchedEvents = this.mRequestFactory.createBatchedEvents(this.mSessionInfo, arrayList);
            Async<BatchedEventsResponse> add = this.mLiveAgentQueue.add(createBatchedEvents, BatchedEventsResponse.class);
            add.onError(new Async.ErrorHandler() {
                public void handleError(Async<?> async, Throwable th) {
                    InternalLiveAgentLoggingSession.this.mLiveAgentQueue.add(createBatchedEvents, BatchedEventsResponse.class);
                }
            });
            notifyOnFlush(add);
            return add;
        }
    }

    public LiveAgentLoggingSession addLoggingSessionListener(LiveAgentLoggingSession.Listener listener) {
        this.mListeners.add(listener);
        return this;
    }

    public LiveAgentLoggingSession removeLoggingSessionListener(LiveAgentLoggingSession.Listener listener) {
        this.mListeners.remove(listener);
        return this;
    }

    public void teardown() {
        log.info("Tearing down the Live Agent Logging session.");
        this.mLiveAgentQueue.teardown();
        this.mPodConnectionManager.removeListener(this);
        this.mPodConnectionManager.endLiveAgentSession();
        this.mTimer.cancel();
        this.mEvents.clear();
    }

    /* access modifiers changed from: package-private */
    public void notifyOnFlush(Async<BatchedEventsResponse> async) {
        for (LiveAgentLoggingSession.Listener onFlush : this.mListeners) {
            onFlush.onFlush(async);
        }
    }

    public void onTimerElapsed() {
        if (this.mSessionInfo != null) {
            notifyOnFlush(flush());
        } else {
            log.warn("Unable to flush via timer. LiveAgent session is not active.");
        }
    }

    public void onConnected(LiveAgentSession liveAgentSession, SessionInfo sessionInfo) {
        log.info("Connected to a new Live Agent session {}", sessionInfo.getSessionId());
        this.mLiveAgentSession = liveAgentSession;
        this.mSessionInfo = sessionInfo;
        this.mLiveAgentSession.setSessionTimeoutMs(this.mConfiguration.getLiveAgentSessionTimeoutMs());
        this.mLiveAgentQueue.setQueueRequestListener(this.mLiveAgentSession);
        for (LiveAgentLoggingSession.Listener onConnected : this.mListeners) {
            onConnected.onConnected();
        }
    }

    public void onFailure() {
        this.mLiveAgentQueue.teardown();
        for (LiveAgentLoggingSession.Listener onEnded : this.mListeners) {
            onEnded.onEnded();
        }
    }

    public static class Builder {
        protected LiveAgentLoggingConfiguration mConfiguration;
        protected Context mContext;
        protected LiveAgentQueue.Builder mLiveAgentQueueBuilder;
        protected PodConnectionManager mPodConnectionManager;
        protected LiveAgentLoggingRequestFactory mRequestFactory;
        protected Timer.Builder mTimerBuilder;

        public Builder with(Context context) {
            this.mContext = context;
            return this;
        }

        public Builder configuration(LiveAgentLoggingConfiguration liveAgentLoggingConfiguration) {
            this.mConfiguration = liveAgentLoggingConfiguration;
            return this;
        }

        public Builder podConnectionManager(PodConnectionManager podConnectionManager) {
            this.mPodConnectionManager = podConnectionManager;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder requestFactory(LiveAgentLoggingRequestFactory liveAgentLoggingRequestFactory) {
            this.mRequestFactory = liveAgentLoggingRequestFactory;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder timerBuilder(Timer.Builder builder) {
            this.mTimerBuilder = builder;
            return this;
        }

        public Builder liveAgentQueueBuilder(LiveAgentQueue.Builder builder) {
            this.mLiveAgentQueueBuilder = builder;
            return this;
        }

        public InternalLiveAgentLoggingSession build() {
            Arguments.checkNotNull(this.mContext);
            Arguments.checkNotNull(this.mConfiguration);
            Arguments.checkNotNull(this.mPodConnectionManager);
            if (this.mRequestFactory == null) {
                this.mRequestFactory = new InternalLiveAgentLoggingRequestFactory();
            }
            if (this.mTimerBuilder == null) {
                this.mTimerBuilder = new Timer.Builder();
            }
            if (this.mLiveAgentQueueBuilder == null) {
                this.mLiveAgentQueueBuilder = new LiveAgentQueue.Builder().with(this.mContext);
            }
            this.mTimerBuilder.timerDelayMs(this.mConfiguration.getFlushTimerDelay());
            return new InternalLiveAgentLoggingSession(this);
        }
    }
}
