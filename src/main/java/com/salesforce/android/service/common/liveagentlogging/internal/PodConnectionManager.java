package com.salesforce.android.service.common.liveagentlogging.internal;

import android.content.Context;
import androidx.b.b;
import com.google.a.g;
import com.salesforce.android.service.common.liveagentclient.LiveAgentClient;
import com.salesforce.android.service.common.liveagentclient.LiveAgentSession;
import com.salesforce.android.service.common.liveagentclient.SessionInfo;
import com.salesforce.android.service.common.liveagentclient.SessionListener;
import com.salesforce.android.service.common.liveagentclient.interceptor.AffinityTokenInterceptor;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingConfiguration;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.salesforce.android.service.common.liveagentlogging.internal.PodProvider;
import com.salesforce.android.service.common.liveagentlogging.internal.json.BaseEventSerializer;
import com.salesforce.android.service.common.liveagentlogging.internal.json.BatchedEventsSerializer;
import com.salesforce.android.service.common.liveagentlogging.internal.request.BatchedEvents;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectionInfo;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectivityState;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectivityTracker;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.lang.reflect.Type;
import java.security.GeneralSecurityException;
import java.util.Set;

public class PodConnectionManager implements SessionListener, ConnectivityTracker.Listener {
    public static final String ISO_8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    private static final ServiceLogger log = ServiceLogging.getLogger(PodConnectionManager.class);
    private final ConnectivityTracker mConnectivityTracker;
    private String mCurrentPod;
    private final g mGsonBuilder;
    private Set<Listener> mListeners = new b();
    private final LiveAgentClient.Builder mLiveAgentClientBuilder;
    private LiveAgentSession mLiveAgentSession;
    private final LiveAgentSession.Builder mLiveAgentSessionBuilder;
    private final PodProvider mPodProvider;
    private SessionInfo mSessionInfo;

    interface Listener {
        void onConnected(LiveAgentSession liveAgentSession, SessionInfo sessionInfo);

        void onFailure();
    }

    protected PodConnectionManager(Builder builder) {
        this.mPodProvider = builder.mPodProvider;
        this.mLiveAgentClientBuilder = builder.mLiveAgentClientBuilder;
        this.mLiveAgentSessionBuilder = builder.mLiveAgentSessionBuilder;
        this.mConnectivityTracker = builder.mConnectivityTrackerBuilder.build(builder.mContext, this);
        this.mGsonBuilder = builder.mGsonBuilder;
        connect();
    }

    public boolean isConnected() {
        return (this.mLiveAgentSession == null || this.mSessionInfo == null) ? false : true;
    }

    public void stopConnectivityTracking() {
        this.mConnectivityTracker.teardown();
    }

    public void endLiveAgentSession() {
        LiveAgentSession liveAgentSession = this.mLiveAgentSession;
        if (liveAgentSession != null) {
            liveAgentSession.endSession();
        }
    }

    public PodConnectionManager addListener(Listener listener) {
        this.mListeners.add(listener);
        return this;
    }

    public PodConnectionManager removeListener(Listener listener) {
        this.mListeners.remove(listener);
        return this;
    }

    private void connect() {
        if (this.mConnectivityTracker.getConnectivityState() != ConnectivityState.CONNECTED) {
            log.info("Unable to connect to a LiveAgent Logging pod because the network is not connected. Waiting for network to be restored...");
            return;
        }
        try {
            this.mCurrentPod = this.mPodProvider.nextPod();
            log.info("Attempting to create a LiveAgent Logging session on pod {}", this.mCurrentPod);
            this.mLiveAgentSession = createLiveAgentSession(this.mCurrentPod);
        } catch (AllPodsUnavailableException unused) {
            log.error("Unable to connect to any LiveAgent pod for Logging. Logging has failed.");
            notifyOnFailure();
        } catch (GeneralSecurityException e2) {
            log.warn("Unable to connect to the LiveAgent pod {} for Logging. Trying another pod.\n{}", this.mCurrentPod, e2.getMessage());
            this.mPodProvider.removePod(this.mCurrentPod);
            connect();
        }
    }

    private LiveAgentSession createLiveAgentSession(String str) throws GeneralSecurityException {
        AffinityTokenInterceptor affinityTokenInterceptor = new AffinityTokenInterceptor();
        this.mLiveAgentSession = this.mLiveAgentSessionBuilder.liveAgentClient(this.mLiveAgentClientBuilder.liveAgentPod(str).gsonBuilder(this.mGsonBuilder).interceptors(affinityTokenInterceptor).build()).build();
        this.mLiveAgentSession.addSessionListener(this);
        this.mLiveAgentSession.addSessionListener(affinityTokenInterceptor);
        this.mLiveAgentSession.createSession();
        return this.mLiveAgentSession;
    }

    public void onSessionCreated(SessionInfo sessionInfo) {
        this.mSessionInfo = sessionInfo;
        notifyOnConnected(this.mLiveAgentSession, this.mSessionInfo);
    }

    public void onSessionStateChanged(LiveAgentState liveAgentState, LiveAgentState liveAgentState2) {
        if (liveAgentState == LiveAgentState.Ended) {
            LiveAgentSession liveAgentSession = this.mLiveAgentSession;
            if (liveAgentSession != null) {
                liveAgentSession.removeSessionListener(this);
            }
        }
    }

    public void onError(Throwable th) {
        ServiceLogger serviceLogger = log;
        Object[] objArr = new Object[3];
        objArr[0] = this.mCurrentPod;
        SessionInfo sessionInfo = this.mSessionInfo;
        objArr[1] = sessionInfo != null ? sessionInfo.getSessionId() : "UNKNOWN";
        objArr[2] = th.getMessage();
        serviceLogger.error("Error encountered during LiveAgent Logging session [Pod - {}, LiveAgent Session ID - {}]\n{}", objArr);
        LiveAgentSession liveAgentSession = this.mLiveAgentSession;
        if (liveAgentSession != null) {
            liveAgentSession.endSession();
        }
        connect();
    }

    public void onConnectivityChanged(ConnectionInfo connectionInfo, ConnectivityState connectivityState, ConnectivityState connectivityState2) {
        if (!isConnected() && connectivityState == ConnectivityState.CONNECTED) {
            log.trace("Network connection has been restored. Retrying LiveAgent Logging connection.");
            connect();
        }
    }

    private void notifyOnConnected(LiveAgentSession liveAgentSession, SessionInfo sessionInfo) {
        for (Listener onConnected : this.mListeners) {
            onConnected.onConnected(liveAgentSession, sessionInfo);
        }
    }

    private void notifyOnFailure() {
        for (Listener onFailure : this.mListeners) {
            onFailure.onFailure();
        }
    }

    public static class Builder {
        protected LiveAgentLoggingConfiguration mConfiguration;
        protected ConnectivityTracker.Builder mConnectivityTrackerBuilder;
        protected Context mContext;
        protected g mGsonBuilder;
        protected LiveAgentClient.Builder mLiveAgentClientBuilder;
        protected LiveAgentSession.Builder mLiveAgentSessionBuilder;
        protected PodProvider mPodProvider;

        public Builder with(Context context) {
            this.mContext = context;
            return this;
        }

        public Builder configuration(LiveAgentLoggingConfiguration liveAgentLoggingConfiguration) {
            this.mConfiguration = liveAgentLoggingConfiguration;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder podProvider(PodProvider podProvider) {
            this.mPodProvider = podProvider;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder liveAgentClientBuilder(LiveAgentClient.Builder builder) {
            this.mLiveAgentClientBuilder = builder;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder liveAgentSessionBuilder(LiveAgentSession.Builder builder) {
            this.mLiveAgentSessionBuilder = builder;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder connectivityTrackerBuilder(ConnectivityTracker.Builder builder) {
            this.mConnectivityTrackerBuilder = builder;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder gsonBuilder(g gVar) {
            this.mGsonBuilder = gVar;
            return this;
        }

        public PodConnectionManager build() {
            Arguments.checkNotNull(this.mContext);
            Arguments.checkNotNull(this.mConfiguration);
            if (this.mPodProvider == null) {
                this.mPodProvider = new PodProvider.Builder().liveAgentPods(this.mConfiguration.getLiveAgentPods()).build();
            }
            if (this.mLiveAgentClientBuilder == null) {
                this.mLiveAgentClientBuilder = new LiveAgentClient.Builder();
            }
            if (this.mLiveAgentSessionBuilder == null) {
                this.mLiveAgentSessionBuilder = new LiveAgentSession.Builder().with(this.mContext);
            }
            if (this.mConnectivityTrackerBuilder == null) {
                this.mConnectivityTrackerBuilder = new ConnectivityTracker.Builder();
            }
            if (this.mGsonBuilder == null) {
                this.mGsonBuilder = new g().a((Type) BaseEvent.class, (Object) new BaseEventSerializer()).a((Type) BatchedEvents.class, (Object) new BatchedEventsSerializer()).a(PodConnectionManager.ISO_8601_DATE_FORMAT);
            }
            return new PodConnectionManager(this);
        }
    }
}
