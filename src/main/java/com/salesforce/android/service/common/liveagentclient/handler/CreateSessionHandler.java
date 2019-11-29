package com.salesforce.android.service.common.liveagentclient.handler;

import com.salesforce.android.service.common.liveagentclient.LiveAgentClient;
import com.salesforce.android.service.common.liveagentclient.LiveAgentSession;
import com.salesforce.android.service.common.liveagentclient.SessionInfo;
import com.salesforce.android.service.common.liveagentclient.SessionListener;
import com.salesforce.android.service.common.liveagentclient.SessionListenerNotifier;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentMetric;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequestFactory;
import com.salesforce.android.service.common.liveagentclient.response.CreateSessionResponse;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleEvaluator;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;

public class CreateSessionHandler implements SessionListener, Async.Handler<CreateSessionResponse> {
    private static final ServiceLogger log = ServiceLogging.getLogger(LiveAgentSession.class);
    private final LifecycleEvaluator<LiveAgentState, LiveAgentMetric> mLifecycleEvaluator;
    private final LiveAgentClient mLiveAgentClient;
    private final LiveAgentRequestFactory mLiveAgentRequestFactory;
    private final SessionListenerNotifier mSessionListenerNotifier;

    public void onError(Throwable th) {
    }

    public void onSessionCreated(SessionInfo sessionInfo) {
    }

    public CreateSessionHandler(LiveAgentClient liveAgentClient, LiveAgentRequestFactory liveAgentRequestFactory, SessionListenerNotifier sessionListenerNotifier, LifecycleEvaluator<LiveAgentState, LiveAgentMetric> lifecycleEvaluator) {
        this.mLiveAgentClient = liveAgentClient;
        this.mLiveAgentRequestFactory = liveAgentRequestFactory;
        this.mSessionListenerNotifier = sessionListenerNotifier.addSessionListener(this);
        this.mLifecycleEvaluator = lifecycleEvaluator;
    }

    /* renamed from: com.salesforce.android.service.common.liveagentclient.handler.CreateSessionHandler$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$salesforce$android$service$common$liveagentclient$lifecycle$LiveAgentState = new int[LiveAgentState.values().length];

        static {
            try {
                $SwitchMap$com$salesforce$android$service$common$liveagentclient$lifecycle$LiveAgentState[LiveAgentState.Connecting.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void onSessionStateChanged(LiveAgentState liveAgentState, LiveAgentState liveAgentState2) {
        if (AnonymousClass1.$SwitchMap$com$salesforce$android$service$common$liveagentclient$lifecycle$LiveAgentState[liveAgentState.ordinal()] == 1) {
            this.mLiveAgentClient.send(this.mLiveAgentRequestFactory.createCreateSessionRequest(), CreateSessionResponse.class).addHandler(this);
        }
    }

    public void handleResult(Async<?> async, CreateSessionResponse createSessionResponse) {
        this.mSessionListenerNotifier.onSessionCreated(new SessionInfo(createSessionResponse.getSessionId(), createSessionResponse.getSessionKey(), createSessionResponse.getAffinityToken(), createSessionResponse.getClientPollingTimeoutMs()));
        this.mLifecycleEvaluator.setMetricSatisfied(LiveAgentMetric.SessionInfoReceived).evaluateState();
    }

    public void handleComplete(Async<?> async) {
        this.mLifecycleEvaluator.setMetricSatisfied(LiveAgentMetric.ConnectionEstablished).evaluateState();
    }

    public void handleError(Async<?> async, Throwable th) {
        log.error("LiveAgent session has encountered an error while creating a session - {}", th);
        this.mLifecycleEvaluator.moveToMilestone().setMetricSatisfied(LiveAgentMetric.Deleted).evaluateState();
        this.mSessionListenerNotifier.onError(th);
    }
}
