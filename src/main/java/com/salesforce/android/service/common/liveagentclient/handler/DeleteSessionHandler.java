package com.salesforce.android.service.common.liveagentclient.handler;

import com.salesforce.android.service.common.liveagentclient.LiveAgentClient;
import com.salesforce.android.service.common.liveagentclient.SessionInfo;
import com.salesforce.android.service.common.liveagentclient.SessionListener;
import com.salesforce.android.service.common.liveagentclient.SessionListenerNotifier;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentMetric;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequestFactory;
import com.salesforce.android.service.common.liveagentclient.response.LiveAgentStringResponse;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleEvaluator;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;

public class DeleteSessionHandler implements SessionListener, Async.CompletionHandler, Async.ErrorHandler {
    private static final ServiceLogger log = ServiceLogging.getLogger(DeleteSessionHandler.class);
    private final LifecycleEvaluator<LiveAgentState, LiveAgentMetric> mLifecycleEvaluator;
    private final LiveAgentClient mLiveAgentClient;
    private final LiveAgentRequestFactory mLiveAgentRequestFactory;
    private SessionInfo mSessionInfo;
    private final SessionListenerNotifier mSessionListenerNotifier;

    public void onError(Throwable th) {
    }

    public DeleteSessionHandler(LiveAgentClient liveAgentClient, LiveAgentRequestFactory liveAgentRequestFactory, SessionListenerNotifier sessionListenerNotifier, LifecycleEvaluator<LiveAgentState, LiveAgentMetric> lifecycleEvaluator) {
        this.mLiveAgentClient = liveAgentClient;
        this.mLiveAgentRequestFactory = liveAgentRequestFactory;
        this.mSessionListenerNotifier = sessionListenerNotifier.addSessionListener(this);
        this.mLifecycleEvaluator = lifecycleEvaluator;
    }

    private void deleteSession() {
        SessionInfo sessionInfo = this.mSessionInfo;
        if (sessionInfo == null) {
            this.mLifecycleEvaluator.setMetricSatisfied(LiveAgentMetric.Deleted).evaluateState();
        } else {
            this.mLiveAgentClient.send(this.mLiveAgentRequestFactory.createDeleteSessionRequest(sessionInfo), LiveAgentStringResponse.class).onComplete(this).onError(this);
        }
    }

    public void onSessionCreated(SessionInfo sessionInfo) {
        this.mSessionInfo = sessionInfo;
    }

    /* renamed from: com.salesforce.android.service.common.liveagentclient.handler.DeleteSessionHandler$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$salesforce$android$service$common$liveagentclient$lifecycle$LiveAgentState = new int[LiveAgentState.values().length];

        static {
            try {
                $SwitchMap$com$salesforce$android$service$common$liveagentclient$lifecycle$LiveAgentState[LiveAgentState.Deleting.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void onSessionStateChanged(LiveAgentState liveAgentState, LiveAgentState liveAgentState2) {
        if (AnonymousClass1.$SwitchMap$com$salesforce$android$service$common$liveagentclient$lifecycle$LiveAgentState[liveAgentState.ordinal()] == 1) {
            deleteSession();
        }
    }

    public void handleComplete(Async<?> async) {
        this.mLifecycleEvaluator.setMetricSatisfied(LiveAgentMetric.Deleted).evaluateState();
        this.mSessionInfo = null;
    }

    public void handleError(Async<?> async, Throwable th) {
        log.warn("LiveAgent session has encountered an error while attempting to delete the session. Ending the session anyway. - {}", th);
        this.mLifecycleEvaluator.setMetricSatisfied(LiveAgentMetric.Deleted).evaluateState();
        this.mSessionListenerNotifier.onError(th);
        this.mSessionInfo = null;
    }
}
