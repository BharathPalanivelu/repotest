package com.salesforce.android.chat.core.internal.liveagent.handler;

import com.salesforce.android.chat.core.ChatAnalyticsEmit;
import com.salesforce.android.chat.core.internal.liveagent.ChatListenerNotifier;
import com.salesforce.android.chat.core.internal.liveagent.EndReasonUtil;
import com.salesforce.android.chat.core.internal.liveagent.lifecycle.LiveAgentChatMetric;
import com.salesforce.android.chat.core.internal.liveagent.lifecycle.LiveAgentChatState;
import com.salesforce.android.chat.core.internal.liveagent.request.ChatEndRequest;
import com.salesforce.android.chat.core.internal.liveagent.request.ChatRequestFactory;
import com.salesforce.android.chat.core.internal.liveagent.response.message.AgentDisconnectMessage;
import com.salesforce.android.chat.core.internal.liveagent.response.message.ChatEndedMessage;
import com.salesforce.android.chat.core.internal.liveagent.response.message.ChatRequestFailMessage;
import com.salesforce.android.chat.core.model.ChatEndReason;
import com.salesforce.android.service.common.liveagentclient.LiveAgentSession;
import com.salesforce.android.service.common.liveagentclient.SessionInfo;
import com.salesforce.android.service.common.liveagentclient.SessionListener;
import com.salesforce.android.service.common.liveagentclient.integrity.LiveAgentQueue;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest;
import com.salesforce.android.service.common.liveagentclient.response.LiveAgentStringResponse;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleEvaluator;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.io.IOException;

public class EndHandler implements SessionListener, LiveAgentQueue.RequestFailedListener, Async.CompletionHandler, Async.ErrorHandler {
    private static final int MAX_END_SESSION_REQUEST_RETRIES = 4;
    private static final ServiceLogger log = ServiceLogging.getLogger(EndHandler.class);
    private final ChatListenerNotifier mChatListenerNotifier;
    private final ChatRequestFactory mChatRequestFactory;
    private ChatEndReason mEndReason;
    private final LifecycleEvaluator<LiveAgentChatState, LiveAgentChatMetric> mLifecycleEvaluator;
    private final LiveAgentQueue mLiveAgentQueue;
    private final LiveAgentSession mLiveAgentSession;
    private SessionInfo mSessionInfo;

    /* synthetic */ EndHandler(Builder builder, AnonymousClass1 r2) {
        this(builder);
    }

    private EndHandler(Builder builder) {
        this.mEndReason = ChatEndReason.Unknown;
        this.mLiveAgentSession = builder.mLiveAgentSession.addSessionListener(this).endSessionOnMessagesError(true);
        this.mLiveAgentQueue = builder.mLiveAgentQueue.addRequestFailedListener(this);
        this.mLifecycleEvaluator = builder.mLifecycleEvaluator;
        this.mChatListenerNotifier = builder.mChatListenerNotifier;
        this.mChatRequestFactory = builder.mChatRequestFactory;
    }

    public void endSessionFromClient() {
        setEndReason(ChatEndReason.EndedByClient);
    }

    public void endSessionWithValidationError() {
        setEndReason(ChatEndReason.VerificationError);
    }

    /* renamed from: com.salesforce.android.chat.core.internal.liveagent.handler.EndHandler$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$salesforce$android$chat$core$model$ChatEndReason = new int[ChatEndReason.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|(3:11|12|14)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.salesforce.android.chat.core.model.ChatEndReason[] r0 = com.salesforce.android.chat.core.model.ChatEndReason.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$salesforce$android$chat$core$model$ChatEndReason = r0
                int[] r0 = $SwitchMap$com$salesforce$android$chat$core$model$ChatEndReason     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.salesforce.android.chat.core.model.ChatEndReason r1 = com.salesforce.android.chat.core.model.ChatEndReason.EndedByClient     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$salesforce$android$chat$core$model$ChatEndReason     // Catch:{ NoSuchFieldError -> 0x001f }
                com.salesforce.android.chat.core.model.ChatEndReason r1 = com.salesforce.android.chat.core.model.ChatEndReason.EndedByAgent     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$salesforce$android$chat$core$model$ChatEndReason     // Catch:{ NoSuchFieldError -> 0x002a }
                com.salesforce.android.chat.core.model.ChatEndReason r1 = com.salesforce.android.chat.core.model.ChatEndReason.NoAgentsAvailable     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$com$salesforce$android$chat$core$model$ChatEndReason     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.salesforce.android.chat.core.model.ChatEndReason r1 = com.salesforce.android.chat.core.model.ChatEndReason.LiveAgentTimeout     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = $SwitchMap$com$salesforce$android$chat$core$model$ChatEndReason     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.salesforce.android.chat.core.model.ChatEndReason r1 = com.salesforce.android.chat.core.model.ChatEndReason.NetworkError     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r0 = $SwitchMap$com$salesforce$android$chat$core$model$ChatEndReason     // Catch:{ NoSuchFieldError -> 0x004b }
                com.salesforce.android.chat.core.model.ChatEndReason r1 = com.salesforce.android.chat.core.model.ChatEndReason.Unknown     // Catch:{ NoSuchFieldError -> 0x004b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.android.chat.core.internal.liveagent.handler.EndHandler.AnonymousClass1.<clinit>():void");
        }
    }

    public void onEndingSessionState() {
        log.debug("Preparing to end the LiveAgent Chat Session");
        int i = AnonymousClass1.$SwitchMap$com$salesforce$android$chat$core$model$ChatEndReason[this.mEndReason.ordinal()];
        if (i == 1) {
            endLiveAgentChatSession();
        } else if (i == 2 || i == 3 || i == 4 || i == 5) {
            this.mLiveAgentSession.endSession();
        } else {
            this.mLifecycleEvaluator.setMetricSatisfied(LiveAgentChatMetric.SessionDeleted).evaluateState();
        }
    }

    public void onEndedState() {
        log.debug("Ended LiveAgent Chat Session with reason: {}", this.mEndReason);
        this.mChatListenerNotifier.onChatEnded(this.mEndReason);
    }

    /* access modifiers changed from: package-private */
    public void setEndReason(ChatRequestFailMessage chatRequestFailMessage) {
        setEndReason(EndReasonUtil.fromChatFailureReason(chatRequestFailMessage.getReason()));
    }

    /* access modifiers changed from: package-private */
    public void setEndReason(ChatEndedMessage chatEndedMessage) {
        setEndReason(EndReasonUtil.fromChatEndedReason(chatEndedMessage.getReason()));
    }

    /* access modifiers changed from: package-private */
    public void setEndReason(AgentDisconnectMessage agentDisconnectMessage) {
        setEndReason(ChatEndReason.EndedByAgent);
    }

    private void setEndReason(ChatEndReason chatEndReason) {
        if (this.mLifecycleEvaluator.getCurrentState().isPostSession()) {
            log.warn("Unable to set end reason on a session that is currently being ended");
            return;
        }
        this.mEndReason = chatEndReason;
        this.mLifecycleEvaluator.moveToMilestone().evaluateState();
    }

    private void endLiveAgentChatSession() {
        SessionInfo sessionInfo = this.mSessionInfo;
        if (sessionInfo == null) {
            this.mLiveAgentSession.endSession();
        } else {
            this.mLiveAgentQueue.add(this.mChatRequestFactory.createEndRequest(sessionInfo), LiveAgentStringResponse.class).onComplete(this).onError(this);
        }
    }

    public void onSessionCreated(SessionInfo sessionInfo) {
        this.mSessionInfo = sessionInfo;
    }

    public void onSessionStateChanged(LiveAgentState liveAgentState, LiveAgentState liveAgentState2) {
        if (liveAgentState == LiveAgentState.Ended) {
            this.mLiveAgentQueue.teardown();
            this.mLifecycleEvaluator.setMetricSatisfied(LiveAgentChatMetric.SessionDeleted).evaluateState();
        }
    }

    public void onError(Throwable th) {
        ChatAnalyticsEmit.responseError(th);
        if (th instanceof IOException) {
            setEndReason(ChatEndReason.NetworkError);
        } else {
            setEndReason(ChatEndReason.Unknown);
        }
        this.mLifecycleEvaluator.moveToMilestone().evaluateState();
    }

    public void onRequestFailed(LiveAgentRequest liveAgentRequest, int i) {
        if ((liveAgentRequest instanceof ChatEndRequest) && i >= 4) {
            log.debug("Failed to send ChatEndRequest in {} attempts. Ending the session anyway.", Integer.valueOf(i));
            this.mLiveAgentSession.endSession();
        }
    }

    public void handleComplete(Async<?> async) {
        this.mLiveAgentSession.endSession();
    }

    public void handleError(Async<?> async, Throwable th) {
        this.mLifecycleEvaluator.setMetricSatisfied(LiveAgentChatMetric.SessionDeleted).evaluateState();
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public ChatListenerNotifier mChatListenerNotifier;
        /* access modifiers changed from: private */
        public ChatRequestFactory mChatRequestFactory;
        /* access modifiers changed from: private */
        public LifecycleEvaluator<LiveAgentChatState, LiveAgentChatMetric> mLifecycleEvaluator;
        /* access modifiers changed from: private */
        public LiveAgentQueue mLiveAgentQueue;
        /* access modifiers changed from: private */
        public LiveAgentSession mLiveAgentSession;

        public Builder liveAgentSession(LiveAgentSession liveAgentSession) {
            this.mLiveAgentSession = liveAgentSession;
            return this;
        }

        public Builder liveAgentQueue(LiveAgentQueue liveAgentQueue) {
            this.mLiveAgentQueue = liveAgentQueue;
            return this;
        }

        public Builder lifecycleEvaluator(LifecycleEvaluator<LiveAgentChatState, LiveAgentChatMetric> lifecycleEvaluator) {
            this.mLifecycleEvaluator = lifecycleEvaluator;
            return this;
        }

        public Builder chatListenerNotifier(ChatListenerNotifier chatListenerNotifier) {
            this.mChatListenerNotifier = chatListenerNotifier;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder chatRequestFactory(ChatRequestFactory chatRequestFactory) {
            this.mChatRequestFactory = chatRequestFactory;
            return this;
        }

        public EndHandler build() {
            Arguments.checkNotNull(this.mLiveAgentSession);
            Arguments.checkNotNull(this.mLiveAgentQueue);
            Arguments.checkNotNull(this.mLifecycleEvaluator);
            Arguments.checkNotNull(this.mChatListenerNotifier);
            if (this.mChatRequestFactory == null) {
                this.mChatRequestFactory = new ChatRequestFactory();
            }
            return new EndHandler(this, (AnonymousClass1) null);
        }
    }
}
