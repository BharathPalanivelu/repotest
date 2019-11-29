package com.salesforce.android.chat.core.internal.liveagent.handler;

import com.salesforce.android.chat.core.ChatConfiguration;
import com.salesforce.android.chat.core.internal.chatbot.response.message.RichMessage;
import com.salesforce.android.chat.core.internal.chatbot.response.message.conferencing.AgentJoinedConferenceMessage;
import com.salesforce.android.chat.core.internal.chatbot.response.message.conferencing.AgentLeftConferenceMessage;
import com.salesforce.android.chat.core.internal.liveagent.ChatListenerNotifier;
import com.salesforce.android.chat.core.internal.liveagent.lifecycle.LiveAgentChatMetric;
import com.salesforce.android.chat.core.internal.liveagent.lifecycle.LiveAgentChatState;
import com.salesforce.android.chat.core.internal.liveagent.request.ChatRequestFactory;
import com.salesforce.android.chat.core.internal.liveagent.response.message.AgentDisconnectMessage;
import com.salesforce.android.chat.core.internal.liveagent.response.message.AgentNotTypingMessage;
import com.salesforce.android.chat.core.internal.liveagent.response.message.AgentTypingMessage;
import com.salesforce.android.chat.core.internal.liveagent.response.message.ChatEndedMessage;
import com.salesforce.android.chat.core.internal.liveagent.response.message.ChatEstablishedMessage;
import com.salesforce.android.chat.core.internal.liveagent.response.message.ChatMessageMessage;
import com.salesforce.android.chat.core.internal.liveagent.response.message.ChatRequestFailMessage;
import com.salesforce.android.chat.core.internal.liveagent.response.message.ChatRequestSuccessMessage;
import com.salesforce.android.chat.core.internal.liveagent.response.message.ChatTransferredMessage;
import com.salesforce.android.chat.core.internal.liveagent.response.message.FileTransferMessage;
import com.salesforce.android.chat.core.internal.liveagent.response.message.QueueUpdateMessage;
import com.salesforce.android.chat.core.internal.liveagent.response.message.TransferToButtonInitiatedMessage;
import com.salesforce.android.chat.core.internal.model.ChatModelFactory;
import com.salesforce.android.chat.core.model.AgentInformation;
import com.salesforce.android.service.common.liveagentclient.LiveAgentMessageRegistry;
import com.salesforce.android.service.common.liveagentclient.LiveAgentSession;
import com.salesforce.android.service.common.liveagentclient.SessionInfo;
import com.salesforce.android.service.common.liveagentclient.SessionListener;
import com.salesforce.android.service.common.liveagentclient.integrity.LiveAgentQueue;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState;
import com.salesforce.android.service.common.liveagentclient.response.LiveAgentStringResponse;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleEvaluator;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class ChatStartHandler implements SessionListener {
    private static final ServiceLogger log = ServiceLogging.getLogger(ChatStartHandler.class);
    private final ChatConfiguration mChatConfiguration;
    private final ChatListenerNotifier mChatListenerNotifier;
    private final ChatModelFactory mChatModelFactory;
    private final ChatRequestFactory mChatRequestFactory;
    private final LifecycleEvaluator<LiveAgentChatState, LiveAgentChatMetric> mLifecycleEvaluator;
    private final LiveAgentMessageRegistry mLiveAgentMessageRegistry;
    private final LiveAgentQueue mLiveAgentQueue;
    private final LiveAgentSession mLiveAgentSession;
    private SessionInfo mSessionInfo;

    public void onError(Throwable th) {
    }

    private ChatStartHandler(Builder builder) {
        this.mChatConfiguration = builder.mChatConfiguration;
        this.mLiveAgentSession = builder.mLiveAgentSession.addSessionListener(this);
        this.mLiveAgentQueue = builder.mLiveAgentQueue;
        this.mLiveAgentMessageRegistry = builder.mLiveAgentMessageRegistry;
        this.mLifecycleEvaluator = builder.mLifecycleEvaluator;
        this.mChatRequestFactory = builder.mChatRequestFactory;
        this.mChatListenerNotifier = builder.mChatListenerNotifier;
        this.mChatModelFactory = builder.mChatModelFactory;
    }

    public void onInitializingSessionState() {
        log.debug("Initializing LiveAgent Session");
        this.mLiveAgentMessageRegistry.register(AgentNotTypingMessage.TYPE, AgentNotTypingMessage.class);
        this.mLiveAgentMessageRegistry.register(AgentTypingMessage.TYPE, AgentTypingMessage.class);
        this.mLiveAgentMessageRegistry.register(ChatEndedMessage.TYPE, ChatEndedMessage.class);
        this.mLiveAgentMessageRegistry.register(ChatEstablishedMessage.TYPE, ChatEstablishedMessage.class);
        this.mLiveAgentMessageRegistry.register(ChatTransferredMessage.TYPE, ChatTransferredMessage.class);
        this.mLiveAgentMessageRegistry.register(TransferToButtonInitiatedMessage.TYPE, TransferToButtonInitiatedMessage.class);
        this.mLiveAgentMessageRegistry.register(ChatMessageMessage.TYPE, ChatMessageMessage.class);
        this.mLiveAgentMessageRegistry.register(ChatRequestFailMessage.TYPE, ChatRequestFailMessage.class);
        this.mLiveAgentMessageRegistry.register(ChatRequestSuccessMessage.TYPE, ChatRequestSuccessMessage.class);
        this.mLiveAgentMessageRegistry.register(QueueUpdateMessage.TYPE, QueueUpdateMessage.class);
        this.mLiveAgentMessageRegistry.register(AgentDisconnectMessage.TYPE, AgentDisconnectMessage.class);
        this.mLiveAgentMessageRegistry.register(FileTransferMessage.TYPE, FileTransferMessage.class);
        this.mLiveAgentMessageRegistry.register(RichMessage.TYPE, RichMessage.class);
        this.mLiveAgentMessageRegistry.register(AgentJoinedConferenceMessage.TYPE, AgentJoinedConferenceMessage.class);
        this.mLiveAgentMessageRegistry.register(AgentLeftConferenceMessage.TYPE, AgentLeftConferenceMessage.class);
        this.mLifecycleEvaluator.setMetricSatisfied(LiveAgentChatMetric.SessionInitialized).evaluateState();
    }

    public void onCreatingSessionState() {
        log.debug("Creating LiveAgent Session");
        this.mLiveAgentSession.createSession();
    }

    public void onRequestingChatState() {
        SessionInfo sessionInfo = this.mSessionInfo;
        if (sessionInfo == null) {
            log.error("Unable to initialize Chat session. LiveAgent session does not exist.");
        } else {
            this.mLiveAgentQueue.add(this.mChatRequestFactory.createInitRequest(this.mChatConfiguration, sessionInfo), LiveAgentStringResponse.class);
        }
    }

    /* access modifiers changed from: package-private */
    public void onChatRequestSuccess(ChatRequestSuccessMessage chatRequestSuccessMessage) {
        this.mLiveAgentSession.setSessionTimeoutMs(chatRequestSuccessMessage.getConnectionTimeoutMs());
        this.mChatListenerNotifier.onChatSessionCreated(this.mChatModelFactory.createChatSessionInfo(chatRequestSuccessMessage.getVisitorId(), this.mChatModelFactory.createSensitiveDataRules(chatRequestSuccessMessage.getSensitiveDataRules())));
        this.mLifecycleEvaluator.setMetricSatisfied(LiveAgentChatMetric.EnteredChatQueue).evaluateState();
    }

    /* access modifiers changed from: package-private */
    public void onChatEstablished(ChatEstablishedMessage chatEstablishedMessage) {
        AgentInformation agentInformation;
        if (chatEstablishedMessage.getFooterMenu() == null || chatEstablishedMessage.getFooterMenu().getMenuItems().length == 0) {
            agentInformation = this.mChatModelFactory.createAgentInformation(chatEstablishedMessage.getAgentName(), chatEstablishedMessage.getAgentId(), chatEstablishedMessage.isSneakPeekEnabled());
        } else {
            agentInformation = this.mChatModelFactory.createChatBotInformation(chatEstablishedMessage.getAgentName(), chatEstablishedMessage.getAgentId(), chatEstablishedMessage.isSneakPeekEnabled());
        }
        this.mChatListenerNotifier.onAgentJoined(agentInformation);
        this.mLifecycleEvaluator.setMetricSatisfied(LiveAgentChatMetric.AgentJoined).evaluateState();
    }

    public void onSessionCreated(SessionInfo sessionInfo) {
        this.mSessionInfo = sessionInfo;
        this.mChatListenerNotifier.onSessionCreated(sessionInfo);
    }

    public void onSessionStateChanged(LiveAgentState liveAgentState, LiveAgentState liveAgentState2) {
        if (liveAgentState == LiveAgentState.LongPolling) {
            this.mLifecycleEvaluator.setMetricSatisfied(LiveAgentChatMetric.SessionCreated).evaluateState();
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public ChatConfiguration mChatConfiguration;
        /* access modifiers changed from: private */
        public ChatListenerNotifier mChatListenerNotifier;
        /* access modifiers changed from: private */
        public ChatModelFactory mChatModelFactory;
        /* access modifiers changed from: private */
        public ChatRequestFactory mChatRequestFactory;
        /* access modifiers changed from: private */
        public LifecycleEvaluator<LiveAgentChatState, LiveAgentChatMetric> mLifecycleEvaluator;
        /* access modifiers changed from: private */
        public LiveAgentMessageRegistry mLiveAgentMessageRegistry;
        /* access modifiers changed from: private */
        public LiveAgentQueue mLiveAgentQueue;
        /* access modifiers changed from: private */
        public LiveAgentSession mLiveAgentSession;

        public Builder chatConfiguration(ChatConfiguration chatConfiguration) {
            this.mChatConfiguration = chatConfiguration;
            return this;
        }

        public Builder liveAgentSession(LiveAgentSession liveAgentSession) {
            this.mLiveAgentSession = liveAgentSession;
            return this;
        }

        public Builder liveAgentQueue(LiveAgentQueue liveAgentQueue) {
            this.mLiveAgentQueue = liveAgentQueue;
            return this;
        }

        public Builder liveAgentMessageRegistry(LiveAgentMessageRegistry liveAgentMessageRegistry) {
            this.mLiveAgentMessageRegistry = liveAgentMessageRegistry;
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

        /* access modifiers changed from: package-private */
        public Builder modelFactory(ChatModelFactory chatModelFactory) {
            this.mChatModelFactory = chatModelFactory;
            return this;
        }

        public ChatStartHandler build() {
            Arguments.checkNotNull(this.mChatConfiguration);
            Arguments.checkNotNull(this.mLiveAgentSession);
            Arguments.checkNotNull(this.mLiveAgentQueue);
            Arguments.checkNotNull(this.mLiveAgentMessageRegistry);
            Arguments.checkNotNull(this.mLifecycleEvaluator);
            Arguments.checkNotNull(this.mChatListenerNotifier);
            if (this.mChatRequestFactory == null) {
                this.mChatRequestFactory = new ChatRequestFactory();
            }
            if (this.mChatModelFactory == null) {
                this.mChatModelFactory = new ChatModelFactory();
            }
            return new ChatStartHandler(this);
        }
    }
}
