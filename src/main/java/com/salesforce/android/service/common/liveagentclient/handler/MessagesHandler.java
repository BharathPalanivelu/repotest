package com.salesforce.android.service.common.liveagentclient.handler;

import com.salesforce.android.service.common.http.HttpResponseParseResult;
import com.salesforce.android.service.common.http.ResponseException;
import com.salesforce.android.service.common.liveagentclient.LiveAgentClient;
import com.salesforce.android.service.common.liveagentclient.SessionInfo;
import com.salesforce.android.service.common.liveagentclient.SessionListener;
import com.salesforce.android.service.common.liveagentclient.SessionListenerNotifier;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentMetric;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequestFactory;
import com.salesforce.android.service.common.liveagentclient.response.MessagesResponse;
import com.salesforce.android.service.common.liveagentclient.response.ReconnectResponse;
import com.salesforce.android.service.common.liveagentclient.response.message.AsyncResult;
import com.salesforce.android.service.common.liveagentclient.response.message.LiveAgentMessage;
import com.salesforce.android.service.common.liveagentclient.response.message.SwitchServerMessage;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleEvaluator;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.HandlerManager;
import com.salesforce.android.service.common.utilities.threading.Timer;
import java.util.concurrent.atomic.AtomicLong;

public class MessagesHandler implements SessionListener, Async.Handler<HttpResponseParseResult<MessagesResponse>>, HandlerManager.OnTimerElapsedListener {
    protected static final ServiceLogger log = ServiceLogging.getLogger(MessagesHandler.class);
    private boolean mEndSessionOnMessagesError;
    private int mFailedHeartbeatCount;
    private AtomicLong mLatestOffset = new AtomicLong();
    protected final LifecycleEvaluator<LiveAgentState, LiveAgentMetric> mLifecycleEvaluator;
    private final LiveAgentClient mLiveAgentClient;
    private final LiveAgentRequestFactory mLiveAgentRequestFactory;
    private int mMaxHeartbeatRetryAttempts;
    protected ReconnectListener mReconnectListener;
    private final int mRetryTimeoutMs;
    protected SessionInfo mSessionInfo;
    protected final SessionListenerNotifier mSessionListenerNotifier;
    private final Timer mTimer;

    public interface ReconnectListener {
        void onReconnect(ReconnectResponse reconnectResponse, SessionInfo sessionInfo);
    }

    public void onError(Throwable th) {
    }

    protected MessagesHandler(Builder builder) {
        this.mLiveAgentClient = builder.mLiveAgentClient;
        this.mLiveAgentRequestFactory = builder.mLiveAgentRequestFactory;
        this.mSessionListenerNotifier = builder.mSessionListenerNotifier.addSessionListener(this);
        this.mLifecycleEvaluator = builder.mLifecycleEvaluator;
        this.mRetryTimeoutMs = builder.mRetryTimeoutMs;
        this.mTimer = builder.mTimerBuilder.timerDelayMs((long) this.mRetryTimeoutMs).onTimerElapsedListener((HandlerManager.OnTimerElapsedListener) this).build();
        this.mMaxHeartbeatRetryAttempts = builder.mMaxHeartbeatRetryAttempts;
    }

    public void setReconnectListener(ReconnectListener reconnectListener) {
        this.mReconnectListener = reconnectListener;
    }

    public void endSessionOnMessagesError(boolean z) {
        this.mEndSessionOnMessagesError = z;
    }

    public void setHeartbeatTimeoutMs(int i) {
        this.mMaxHeartbeatRetryAttempts = i / this.mRetryTimeoutMs;
    }

    /* access modifiers changed from: package-private */
    public void requestMessages() {
        if (this.mSessionInfo != null && this.mLifecycleEvaluator.getCurrentState() == LiveAgentState.LongPolling) {
            this.mLiveAgentClient.sendAndGetResponse(this.mLiveAgentRequestFactory.createMessagesRequest(this.mSessionInfo), MessagesResponse.class, this.mSessionInfo.getPollingTimeoutMs()).addHandler(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void reconnect() {
        SessionInfo sessionInfo = this.mSessionInfo;
        if (sessionInfo != null) {
            this.mLiveAgentClient.sendAndGetResponse(this.mLiveAgentRequestFactory.createReconnectRequest(sessionInfo, this.mLatestOffset.get()), ReconnectResponse.class).onResult(new Async.ResultHandler<HttpResponseParseResult<ReconnectResponse>>() {
                public void handleResult(Async<?> async, HttpResponseParseResult<ReconnectResponse> httpResponseParseResult) {
                    if (MessagesHandler.this.mReconnectListener != null) {
                        MessagesHandler.this.mReconnectListener.onReconnect(httpResponseParseResult.getBody(), MessagesHandler.this.mSessionInfo);
                        MessagesHandler.this.requestMessages();
                    }
                }
            }).onError(new Async.ErrorHandler() {
                public void handleError(Async<?> async, Throwable th) {
                    MessagesHandler.log.error("LiveAgent session has encountered an unrecoverable error while attempting to reconnect the session after an app server handover - {}", th);
                    MessagesHandler.this.mLifecycleEvaluator.moveToMilestone().evaluateState();
                    MessagesHandler.this.mSessionListenerNotifier.onError(th);
                }
            });
        }
    }

    public void onSessionCreated(SessionInfo sessionInfo) {
        this.mSessionInfo = sessionInfo;
    }

    /* renamed from: com.salesforce.android.service.common.liveagentclient.handler.MessagesHandler$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$salesforce$android$service$common$liveagentclient$lifecycle$LiveAgentState = new int[LiveAgentState.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState[] r0 = com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$salesforce$android$service$common$liveagentclient$lifecycle$LiveAgentState = r0
                int[] r0 = $SwitchMap$com$salesforce$android$service$common$liveagentclient$lifecycle$LiveAgentState     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState r1 = com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState.LongPolling     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$salesforce$android$service$common$liveagentclient$lifecycle$LiveAgentState     // Catch:{ NoSuchFieldError -> 0x001f }
                com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState r1 = com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState.Deleting     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$salesforce$android$service$common$liveagentclient$lifecycle$LiveAgentState     // Catch:{ NoSuchFieldError -> 0x002a }
                com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState r1 = com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState.Ended     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.android.service.common.liveagentclient.handler.MessagesHandler.AnonymousClass3.<clinit>():void");
        }
    }

    public void onSessionStateChanged(LiveAgentState liveAgentState, LiveAgentState liveAgentState2) {
        int i = AnonymousClass3.$SwitchMap$com$salesforce$android$service$common$liveagentclient$lifecycle$LiveAgentState[liveAgentState.ordinal()];
        if (i == 1) {
            requestMessages();
        } else if (i == 2) {
            log.trace("Stopping LiveAgent heartbeat");
            this.mTimer.cancel();
        } else if (i == 3) {
            this.mSessionInfo = null;
        }
    }

    public void handleResult(Async<?> async, HttpResponseParseResult<MessagesResponse> httpResponseParseResult) {
        log.trace("LiveAgent heartbeat response (MessagesResponse) has been received");
        if (httpResponseParseResult.getBody() != null) {
            long offset = httpResponseParseResult.getBody().getOffset();
            if (offset > 0) {
                this.mLatestOffset.set(offset);
            }
            for (LiveAgentMessage next : httpResponseParseResult.getBody().getMessages()) {
                if (next.getTypeIdentifier().equals(SwitchServerMessage.TYPE)) {
                    onSwitchServer((SwitchServerMessage) next.getContent(SwitchServerMessage.class));
                } else if (next.getTypeIdentifier().equals(AsyncResult.TYPE)) {
                    onAsyncResult((AsyncResult) next.getContent(AsyncResult.class));
                }
            }
            this.mSessionListenerNotifier.onMessagesResponse(httpResponseParseResult.getBody());
        }
    }

    public void handleComplete(Async<?> async) {
        this.mFailedHeartbeatCount = 0;
        requestMessages();
    }

    public void handleError(Async<?> async, Throwable th) {
        if (this.mLifecycleEvaluator.getCurrentState() == LiveAgentState.LongPolling) {
            this.mFailedHeartbeatCount++;
            if (isServerHandoverOccurring(th)) {
                log.warn("Live Agent session may be transitioning to another app server. Attempting to reconnect...");
                reconnect();
                return;
            }
            int i = this.mFailedHeartbeatCount;
            if (i > this.mMaxHeartbeatRetryAttempts) {
                log.error("LiveAgent session has encountered an unrecoverable error while retrieving messages - {}", th);
                this.mLifecycleEvaluator.moveToMilestone().evaluateState();
                this.mSessionListenerNotifier.onError(th);
                return;
            }
            log.warn("LiveAgent session is attempting to reconnect. Retry #{} of {}", Integer.valueOf(i), Integer.valueOf(this.mMaxHeartbeatRetryAttempts));
            this.mTimer.schedule();
        }
    }

    public void onTimerElapsed() {
        requestMessages();
    }

    /* access modifiers changed from: package-private */
    public void onSwitchServer(SwitchServerMessage switchServerMessage) {
        String newLiveAgentPod = switchServerMessage.getNewLiveAgentPod();
        if (newLiveAgentPod == null) {
            log.warn("Failed to switch to a different LiveAgent Server: Address is null.");
            this.mLifecycleEvaluator.moveToMilestone().evaluateState();
            return;
        }
        ServiceLogger serviceLogger = log;
        serviceLogger.trace("Switching to a different LiveAgent Server: {}" + switchServerMessage.getNewServerUrl());
        this.mLiveAgentClient.setLiveAgentPod(newLiveAgentPod);
        this.mLifecycleEvaluator.setMetricUnsatisfied(LiveAgentMetric.ConnectionEstablished).evaluateState();
    }

    /* access modifiers changed from: package-private */
    public void onAsyncResult(AsyncResult asyncResult) {
        if (asyncResult.isError() && this.mEndSessionOnMessagesError) {
            log.error("LiveAgent session has encountered an error while creating a session - {}", asyncResult.getErrorMessage());
            this.mLifecycleEvaluator.moveToMilestone().evaluateState();
            this.mSessionListenerNotifier.onError(new Exception(asyncResult.getErrorMessage()));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isServerHandoverOccurring(Throwable th) {
        return (th instanceof ResponseException) && ((ResponseException) th).getErrorCode() == 503;
    }

    public static class Builder {
        protected LifecycleEvaluator<LiveAgentState, LiveAgentMetric> mLifecycleEvaluator;
        protected LiveAgentClient mLiveAgentClient;
        protected LiveAgentRequestFactory mLiveAgentRequestFactory;
        protected int mMaxHeartbeatRetryAttempts = 20;
        protected int mRetryTimeoutMs = 2000;
        protected SessionListenerNotifier mSessionListenerNotifier;
        protected Timer.Builder mTimerBuilder;

        public Builder liveAgentClient(LiveAgentClient liveAgentClient) {
            this.mLiveAgentClient = liveAgentClient;
            return this;
        }

        public Builder liveAgentRequestFactory(LiveAgentRequestFactory liveAgentRequestFactory) {
            this.mLiveAgentRequestFactory = liveAgentRequestFactory;
            return this;
        }

        public Builder sessionListenerNotifier(SessionListenerNotifier sessionListenerNotifier) {
            this.mSessionListenerNotifier = sessionListenerNotifier;
            return this;
        }

        public Builder lifecycleEvaluator(LifecycleEvaluator<LiveAgentState, LiveAgentMetric> lifecycleEvaluator) {
            this.mLifecycleEvaluator = lifecycleEvaluator;
            return this;
        }

        public Builder timerBuilder(Timer.Builder builder) {
            this.mTimerBuilder = builder;
            return this;
        }

        public Builder maxHeartbeatRetryAttempts(int i) {
            this.mMaxHeartbeatRetryAttempts = i;
            return this;
        }

        public Builder retryTimeoutMs(int i) {
            this.mRetryTimeoutMs = i;
            return this;
        }

        public MessagesHandler build() {
            if (this.mTimerBuilder == null) {
                this.mTimerBuilder = new Timer.Builder();
            }
            return new MessagesHandler(this);
        }
    }
}
