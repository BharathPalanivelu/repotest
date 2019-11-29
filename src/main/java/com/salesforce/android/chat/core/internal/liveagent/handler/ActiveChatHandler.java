package com.salesforce.android.chat.core.internal.liveagent.handler;

import com.salesforce.android.chat.core.exception.EmptyChatMessageException;
import com.salesforce.android.chat.core.exception.SessionDoesNotExistException;
import com.salesforce.android.chat.core.internal.liveagent.ChatListenerNotifier;
import com.salesforce.android.chat.core.internal.liveagent.request.ChatRequestFactory;
import com.salesforce.android.chat.core.internal.liveagent.response.message.ChatMessageMessage;
import com.salesforce.android.chat.core.internal.liveagent.response.message.ChatRequestSuccessMessage;
import com.salesforce.android.chat.core.internal.liveagent.response.message.ChatTransferredMessage;
import com.salesforce.android.chat.core.internal.model.ChatModelFactory;
import com.salesforce.android.chat.core.internal.model.SensitiveDataRuleModel;
import com.salesforce.android.chat.core.internal.sensitivedata.SensitiveDataScrubber;
import com.salesforce.android.chat.core.model.ChatSentMessageReceipt;
import com.salesforce.android.chat.core.model.SensitiveDataRule;
import com.salesforce.android.service.common.liveagentclient.LiveAgentSession;
import com.salesforce.android.service.common.liveagentclient.SessionInfo;
import com.salesforce.android.service.common.liveagentclient.SessionListener;
import com.salesforce.android.service.common.liveagentclient.integrity.LiveAgentQueue;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest;
import com.salesforce.android.service.common.liveagentclient.response.LiveAgentStringResponse;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.HandlerManager;
import com.salesforce.android.service.common.utilities.threading.Timer;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.Date;

public class ActiveChatHandler implements SessionListener, HandlerManager.OnTimerElapsedListener {
    static final long AGENT_IS_TYPING_TIMEOUT_MS = 5000;
    private static final ServiceLogger log = ServiceLogging.getLogger(ActiveChatHandler.class);
    private final Timer mAgentTypingTimer;
    private final ChatListenerNotifier mChatListenerNotifier;
    private final ChatModelFactory mChatModelFactory;
    private final ChatRequestFactory mChatRequestFactory;
    private boolean mIsAgentTyping;
    private boolean mIsUserTyping;
    private final LiveAgentQueue mLiveAgentQueue;
    private final SensitiveDataScrubber mSensitiveDataScrubber;
    private SessionInfo mSessionInfo;

    public void onError(Throwable th) {
    }

    public void onSessionStateChanged(LiveAgentState liveAgentState, LiveAgentState liveAgentState2) {
    }

    private ActiveChatHandler(Builder builder) {
        this.mChatRequestFactory = builder.mChatRequestFactory;
        this.mChatListenerNotifier = builder.mChatListenerNotifier;
        this.mChatModelFactory = builder.mChatModelFactory;
        this.mAgentTypingTimer = builder.mTimerBuilder.timerDelayMs(AGENT_IS_TYPING_TIMEOUT_MS).onTimerElapsedListener((HandlerManager.OnTimerElapsedListener) this).build();
        this.mLiveAgentQueue = builder.mLiveAgentQueue;
        this.mSensitiveDataScrubber = builder.mSensitiveDataScrubber;
        builder.mLiveAgentSession.addSessionListener(this);
    }

    public Async<LiveAgentStringResponse> sendUserIsTyping(boolean z) {
        LiveAgentRequest liveAgentRequest;
        SessionInfo sessionInfo = this.mSessionInfo;
        if (sessionInfo == null) {
            return BasicAsync.error(new SessionDoesNotExistException());
        }
        if (z == this.mIsUserTyping) {
            return BasicAsync.immediate();
        }
        this.mIsUserTyping = z;
        if (this.mIsUserTyping) {
            liveAgentRequest = this.mChatRequestFactory.createTypingRequest(sessionInfo);
        } else {
            liveAgentRequest = this.mChatRequestFactory.createNotTypingRequest(sessionInfo);
        }
        return this.mLiveAgentQueue.add(liveAgentRequest, LiveAgentStringResponse.class);
    }

    public Async<ChatSentMessageReceipt> sendChatMessage(String str) {
        if (this.mSessionInfo == null) {
            return BasicAsync.error(new SessionDoesNotExistException());
        }
        final BasicAsync create = BasicAsync.create();
        final ChatSentMessageReceipt scrubMessage = this.mSensitiveDataScrubber.scrubMessage(str);
        if (scrubMessage.isScrubbed()) {
            sendSensitiveDataRulesTriggered(scrubMessage.getTriggeredSensitiveDataRules());
        }
        if (scrubMessage.getScrubbedText().isEmpty() && scrubMessage.getTriggeredSensitiveDataRules().length > 0) {
            log.warn("Chat message is empty as a result of applying Sensitive Data Rules. Message failed to send.");
            create.setError((Throwable) new EmptyChatMessageException(scrubMessage.getTriggeredSensitiveDataRules()));
        } else if (scrubMessage.getScrubbedText().isEmpty()) {
            log.warn("Unable to send an empty chat message.");
            create.setError((Throwable) new EmptyChatMessageException());
        } else {
            this.mLiveAgentQueue.add(this.mChatRequestFactory.createMessageRequest(scrubMessage.getScrubbedText(), this.mSessionInfo), LiveAgentStringResponse.class).onComplete(new Async.CompletionHandler() {
                public void handleComplete(Async<?> async) {
                    create.setResult(scrubMessage);
                    create.complete();
                }
            }).onError(new Async.ErrorHandler() {
                public void handleError(Async<?> async, Throwable th) {
                    create.setError(th);
                }
            });
        }
        return create;
    }

    public Async<LiveAgentStringResponse> sendSneakPeekMessage(String str) {
        SessionInfo sessionInfo = this.mSessionInfo;
        if (sessionInfo == null) {
            return BasicAsync.error(new SessionDoesNotExistException());
        }
        return this.mLiveAgentQueue.add(this.mChatRequestFactory.createSneakPeekRequest(str, sessionInfo), LiveAgentStringResponse.class);
    }

    private void sendSensitiveDataRulesTriggered(SensitiveDataRule... sensitiveDataRuleArr) {
        SessionInfo sessionInfo = this.mSessionInfo;
        if (sessionInfo != null) {
            this.mLiveAgentQueue.add(this.mChatRequestFactory.createSensitiveDataRuleTriggered(sessionInfo, SensitiveDataRuleModel.toTriggered(sensitiveDataRuleArr)), LiveAgentStringResponse.class);
        }
    }

    /* access modifiers changed from: package-private */
    public void setQueuePosition(int i) {
        this.mChatListenerNotifier.onQueuePositionUpdate(i);
    }

    /* access modifiers changed from: package-private */
    public void setIsAgentTyping(boolean z) {
        boolean z2 = z != this.mIsAgentTyping;
        if (z) {
            this.mAgentTypingTimer.cancel();
            this.mAgentTypingTimer.schedule();
        } else {
            this.mAgentTypingTimer.cancel();
        }
        if (z2) {
            this.mIsAgentTyping = z;
            this.mChatListenerNotifier.onIsAgentTyping(this.mIsAgentTyping);
        }
    }

    /* access modifiers changed from: package-private */
    public void handleIncomingChatMessage(ChatMessageMessage chatMessageMessage) {
        this.mChatListenerNotifier.onChatMessageReceived(this.mChatModelFactory.createChatMessage(chatMessageMessage.getAgentId(), chatMessageMessage.getAgentName(), chatMessageMessage.getText(), new Date()));
        setIsAgentTyping(false);
    }

    /* access modifiers changed from: package-private */
    public void onTransferToButtonInitiated() {
        this.mChatListenerNotifier.onTransferToButtonInitiated();
    }

    /* access modifiers changed from: package-private */
    public void onChatTransferred(ChatTransferredMessage chatTransferredMessage) {
        this.mChatListenerNotifier.onAgentJoined(this.mChatModelFactory.createAgentInformation(chatTransferredMessage.getAgentName(), chatTransferredMessage.getAgentId(), chatTransferredMessage.isSneakPeekEnabled()));
    }

    /* access modifiers changed from: package-private */
    public void setSensitiveDataRules(ChatRequestSuccessMessage.SensitiveDataRule... sensitiveDataRuleArr) {
        this.mSensitiveDataScrubber.setSensitiveDataRules(this.mChatModelFactory.createSensitiveDataRules(sensitiveDataRuleArr));
    }

    public void onAgentJoinConference(String str) {
        this.mChatListenerNotifier.onAgentJoinedConference(str);
    }

    public void onAgentLeftConference(String str) {
        this.mChatListenerNotifier.onAgentLeftConference(str);
    }

    public void onTimerElapsed() {
        setIsAgentTyping(false);
    }

    public void onSessionCreated(SessionInfo sessionInfo) {
        this.mSessionInfo = sessionInfo;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public ChatListenerNotifier mChatListenerNotifier;
        /* access modifiers changed from: private */
        public ChatModelFactory mChatModelFactory;
        /* access modifiers changed from: private */
        public ChatRequestFactory mChatRequestFactory;
        /* access modifiers changed from: private */
        public LiveAgentQueue mLiveAgentQueue;
        /* access modifiers changed from: private */
        public LiveAgentSession mLiveAgentSession;
        /* access modifiers changed from: private */
        public SensitiveDataScrubber mSensitiveDataScrubber;
        /* access modifiers changed from: private */
        public Timer.Builder mTimerBuilder;

        public Builder liveAgentSession(LiveAgentSession liveAgentSession) {
            this.mLiveAgentSession = liveAgentSession;
            return this;
        }

        public Builder liveAgentQueue(LiveAgentQueue liveAgentQueue) {
            this.mLiveAgentQueue = liveAgentQueue;
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

        /* access modifiers changed from: package-private */
        public Builder modelFactory(ChatModelFactory chatModelFactory) {
            this.mChatModelFactory = chatModelFactory;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder timerBuilder(Timer.Builder builder) {
            this.mTimerBuilder = builder;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder sensitiveDataScrubber(SensitiveDataScrubber sensitiveDataScrubber) {
            this.mSensitiveDataScrubber = sensitiveDataScrubber;
            return this;
        }

        public ActiveChatHandler build() {
            Arguments.checkNotNull(this.mLiveAgentSession);
            Arguments.checkNotNull(this.mLiveAgentQueue);
            Arguments.checkNotNull(this.mChatListenerNotifier);
            if (this.mChatRequestFactory == null) {
                this.mChatRequestFactory = new ChatRequestFactory();
            }
            if (this.mChatModelFactory == null) {
                this.mChatModelFactory = new ChatModelFactory();
            }
            if (this.mTimerBuilder == null) {
                this.mTimerBuilder = new Timer.Builder();
            }
            if (this.mSensitiveDataScrubber == null) {
                this.mSensitiveDataScrubber = new SensitiveDataScrubber.Builder().chatModelFactory(this.mChatModelFactory).build();
            }
            return new ActiveChatHandler(this);
        }
    }
}
