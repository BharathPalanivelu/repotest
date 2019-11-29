package com.salesforce.android.chat.core.internal.liveagent;

import android.content.Context;
import com.google.a.g;
import com.salesforce.android.chat.core.ChatBotListener;
import com.salesforce.android.chat.core.ChatConfiguration;
import com.salesforce.android.chat.core.FileTransferRequestListener;
import com.salesforce.android.chat.core.QueueListener;
import com.salesforce.android.chat.core.internal.availability.AgentAvailability;
import com.salesforce.android.chat.core.internal.chatbot.handler.ChatBotHandler;
import com.salesforce.android.chat.core.internal.chatbot.response.message.ChatButtonDeserializer;
import com.salesforce.android.chat.core.internal.chatbot.response.message.ChatFooterMenuDeserializer;
import com.salesforce.android.chat.core.internal.chatbot.response.message.ChatFooterMenuMessage;
import com.salesforce.android.chat.core.internal.chatbot.response.message.ChatWindowButtonMenuMessage;
import com.salesforce.android.chat.core.internal.chatbot.response.message.ChatWindowMenuDeserializer;
import com.salesforce.android.chat.core.internal.chatbot.response.message.ChatWindowMenuMessage;
import com.salesforce.android.chat.core.internal.chatbot.response.message.RichMessage;
import com.salesforce.android.chat.core.internal.chatbot.response.message.RichMessageDeserializer;
import com.salesforce.android.chat.core.internal.liveagent.handler.ActiveChatHandler;
import com.salesforce.android.chat.core.internal.liveagent.handler.ChatStartHandler;
import com.salesforce.android.chat.core.internal.liveagent.handler.EndHandler;
import com.salesforce.android.chat.core.internal.liveagent.handler.FileTransferHandler;
import com.salesforce.android.chat.core.internal.liveagent.handler.MessagesHandler;
import com.salesforce.android.chat.core.internal.liveagent.lifecycle.LiveAgentChatMetric;
import com.salesforce.android.chat.core.internal.liveagent.lifecycle.LiveAgentChatState;
import com.salesforce.android.chat.core.model.AvailabilityState;
import com.salesforce.android.chat.core.model.ChatSentMessageReceipt;
import com.salesforce.android.service.common.liveagentclient.LiveAgentClient;
import com.salesforce.android.service.common.liveagentclient.LiveAgentMessageRegistry;
import com.salesforce.android.service.common.liveagentclient.LiveAgentSession;
import com.salesforce.android.service.common.liveagentclient.integrity.LiveAgentQueue;
import com.salesforce.android.service.common.liveagentclient.interceptor.AffinityTokenInterceptor;
import com.salesforce.android.service.common.liveagentclient.response.LiveAgentStringResponse;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleEvaluator;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleListener;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.lang.reflect.Type;
import java.security.GeneralSecurityException;

public class LiveAgentChatSession implements LifecycleListener<LiveAgentChatState, LiveAgentChatMetric> {
    private static final ServiceLogger log = ServiceLogging.getLogger(LiveAgentChatSession.class);
    private final ActiveChatHandler mActiveChatHandler;
    private final AgentAvailability mAgentAvailability;
    private final ChatBotHandler mChatBotHandler;
    private final ChatListenerNotifier mChatListenerNotifier;
    private final ChatStartHandler mChatStartHandler;
    /* access modifiers changed from: private */
    public final EndHandler mEndHandler;
    /* access modifiers changed from: private */
    public final LifecycleEvaluator<LiveAgentChatState, LiveAgentChatMetric> mLifecycleEvaluator;
    /* access modifiers changed from: private */
    public final LiveAgentClient mLiveAgentClient;

    private LiveAgentChatSession(Builder builder) {
        this.mLiveAgentClient = builder.mLiveAgentClient;
        this.mChatListenerNotifier = builder.mChatListenerNotifier;
        this.mChatStartHandler = builder.mChatStartHandler;
        this.mActiveChatHandler = builder.mActiveChatHandler;
        this.mChatBotHandler = builder.mChatBotHandler;
        this.mEndHandler = builder.mEndHandler;
        this.mAgentAvailability = builder.mAgentAvailability;
        this.mLifecycleEvaluator = builder.mLifecycleEvaluator.setMilestoneState(LiveAgentChatState.EndingSession);
        this.mLifecycleEvaluator.addListener(this);
    }

    public void start() {
        this.mLifecycleEvaluator.evaluateState();
    }

    public Async<LiveAgentStringResponse> sendUserIsTyping(boolean z) {
        return this.mActiveChatHandler.sendUserIsTyping(z);
    }

    public Async<ChatSentMessageReceipt> sendChatMessage(String str) {
        return this.mActiveChatHandler.sendChatMessage(str);
    }

    public Async<LiveAgentStringResponse> sendSneakPeekMessage(String str) {
        return this.mActiveChatHandler.sendSneakPeekMessage(str);
    }

    public Async<LiveAgentStringResponse> sendMenuSelection(int i) {
        return this.mChatBotHandler.sendMenuSelection(i);
    }

    public Async<LiveAgentStringResponse> sendButtonSelection(int i) {
        return this.mChatBotHandler.sendButtonSelection(i);
    }

    public Async<LiveAgentStringResponse> sendFooterMenuSelection(int i, String str) {
        return this.mChatBotHandler.sendFooterMenuSelection(i, str);
    }

    public void endSessionFromClient() {
        this.mEndHandler.endSessionFromClient();
    }

    public void endSessionWithValidationError() {
        this.mEndHandler.endSessionWithValidationError();
    }

    private void checkSwitchServer() {
        this.mAgentAvailability.verifyLiveAgentPod().onResult(new Async.ResultHandler<AvailabilityState>() {
            public void handleResult(Async<?> async, AvailabilityState availabilityState) {
                LiveAgentChatSession.this.mLiveAgentClient.setLiveAgentPod(availabilityState.getLiveAgentPod());
            }
        }).onError(new Async.ErrorHandler() {
            public void handleError(Async<?> async, Throwable th) {
                LiveAgentChatSession.this.mEndHandler.onError(th);
                LiveAgentChatSession.this.mLifecycleEvaluator.moveToMilestone().evaluateState();
            }
        }).onComplete(new Async.CompletionHandler() {
            public void handleComplete(Async<?> async) {
                LiveAgentChatSession.this.mLifecycleEvaluator.setMetricSatisfied(LiveAgentChatMetric.ServerSwitchChecked).evaluateState();
            }
        });
    }

    public LiveAgentChatSession addChatStateListener(ChatStateListener chatStateListener) {
        this.mChatListenerNotifier.addChatStateListener(chatStateListener);
        return this;
    }

    public LiveAgentChatSession addAgentListener(AgentListener agentListener) {
        this.mChatListenerNotifier.addAgentListener(agentListener);
        return this;
    }

    public LiveAgentChatSession addQueueListener(QueueListener queueListener) {
        this.mChatListenerNotifier.addQueueListener(queueListener);
        return this;
    }

    public LiveAgentChatSession addFileTransferRequestListener(FileTransferRequestListener fileTransferRequestListener) {
        this.mChatListenerNotifier.addFileTransferRequestListener(fileTransferRequestListener);
        return this;
    }

    public LiveAgentChatSession addChatBotListener(ChatBotListener chatBotListener) {
        this.mChatListenerNotifier.addChatBotListener(chatBotListener);
        return this;
    }

    public void onStateChanged(LiveAgentChatState liveAgentChatState, LiveAgentChatState liveAgentChatState2) {
        switch (liveAgentChatState) {
            case Verification:
                log.info("Verifying Live Agent Connection Information...");
                checkSwitchServer();
                break;
            case Initializing:
                log.info("Initializing LiveAgent Session...");
                this.mChatStartHandler.onInitializingSessionState();
                break;
            case CreatingSession:
                log.info("Creating LiveAgent Session...");
                this.mChatStartHandler.onCreatingSessionState();
                break;
            case RequestingChat:
                log.info("Requesting a new LiveAgent Chat Session...");
                this.mChatStartHandler.onRequestingChatState();
                break;
            case InQueue:
                log.info("In Queue...");
                break;
            case Chatting:
                log.info("Agent has joined the LiveAgent Chat Session.");
                break;
            case EndingSession:
                log.info("Ending the LiveAgent Chat Session...");
                this.mEndHandler.onEndingSessionState();
                break;
            case Ended:
                log.info("Ended LiveAgent Chat Session");
                this.mEndHandler.onEndedState();
                break;
        }
        this.mChatListenerNotifier.onStateChanged(liveAgentChatState, liveAgentChatState2);
    }

    public void onMetricTimeout(LiveAgentChatMetric liveAgentChatMetric) {
        this.mLifecycleEvaluator.moveToMilestone().evaluateState();
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public ActiveChatHandler mActiveChatHandler;
        /* access modifiers changed from: private */
        public AgentAvailability mAgentAvailability;
        /* access modifiers changed from: private */
        public ChatBotHandler mChatBotHandler;
        private ChatConfiguration mChatConfiguration;
        /* access modifiers changed from: private */
        public ChatListenerNotifier mChatListenerNotifier;
        /* access modifiers changed from: private */
        public ChatStartHandler mChatStartHandler;
        private Context mContext;
        /* access modifiers changed from: private */
        public EndHandler mEndHandler;
        private FileTransferHandler mFileTransferHandler;
        /* access modifiers changed from: private */
        public LifecycleEvaluator<LiveAgentChatState, LiveAgentChatMetric> mLifecycleEvaluator;
        /* access modifiers changed from: private */
        public LiveAgentClient mLiveAgentClient;
        private LiveAgentMessageRegistry mLiveAgentMessageRegistry;
        private LiveAgentQueue mLiveAgentQueue;
        private LiveAgentSession mLiveAgentSession;
        private MessagesHandler mMessagesHandler;

        public Builder with(Context context) {
            this.mContext = context;
            return this;
        }

        public Builder chatConfiguration(ChatConfiguration chatConfiguration) {
            this.mChatConfiguration = chatConfiguration;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder liveAgentClient(LiveAgentClient liveAgentClient) {
            this.mLiveAgentClient = liveAgentClient;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder liveAgentSession(LiveAgentSession liveAgentSession) {
            this.mLiveAgentSession = liveAgentSession;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder lifecycleEvaluator(LifecycleEvaluator<LiveAgentChatState, LiveAgentChatMetric> lifecycleEvaluator) {
            this.mLifecycleEvaluator = lifecycleEvaluator;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder chatListenerNotifier(ChatListenerNotifier chatListenerNotifier) {
            this.mChatListenerNotifier = chatListenerNotifier;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder messageRegistry(LiveAgentMessageRegistry liveAgentMessageRegistry) {
            this.mLiveAgentMessageRegistry = liveAgentMessageRegistry;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder agentAvailability(AgentAvailability agentAvailability) {
            this.mAgentAvailability = agentAvailability;
            return this;
        }

        public LiveAgentChatSession build() throws GeneralSecurityException {
            Arguments.checkNotNull(this.mContext);
            Arguments.checkNotNull(this.mChatConfiguration);
            AffinityTokenInterceptor affinityTokenInterceptor = new AffinityTokenInterceptor();
            if (this.mLiveAgentMessageRegistry == null) {
                this.mLiveAgentMessageRegistry = new LiveAgentMessageRegistry();
            }
            if (this.mLiveAgentClient == null) {
                this.mLiveAgentClient = new LiveAgentClient.Builder().gsonBuilder(new g().a((Type) RichMessage.class, (Object) new RichMessageDeserializer()).a((Type) ChatWindowMenuMessage.class, (Object) new ChatWindowMenuDeserializer()).a((Type) ChatFooterMenuMessage.class, (Object) new ChatFooterMenuDeserializer()).a((Type) ChatWindowButtonMenuMessage.class, (Object) new ChatButtonDeserializer())).liveAgentPod(this.mChatConfiguration.getLiveAgentPod()).liveAgentMessageRegistry(this.mLiveAgentMessageRegistry).interceptors(affinityTokenInterceptor).build();
            }
            if (this.mLiveAgentSession == null) {
                this.mLiveAgentSession = new LiveAgentSession.Builder().with(this.mContext).liveAgentClient(this.mLiveAgentClient).build();
                this.mLiveAgentSession.addSessionListener(affinityTokenInterceptor);
            }
            if (this.mLiveAgentQueue == null) {
                this.mLiveAgentQueue = new LiveAgentQueue.Builder().with(this.mContext).queueRequestListener(this.mLiveAgentSession).build();
            }
            if (this.mLifecycleEvaluator == null) {
                this.mLifecycleEvaluator = new LifecycleEvaluator.Builder().build(LiveAgentChatState.class, LiveAgentChatMetric.class);
            }
            if (this.mChatListenerNotifier == null) {
                this.mChatListenerNotifier = new ChatListenerNotifier();
            }
            if (this.mChatStartHandler == null) {
                this.mChatStartHandler = new ChatStartHandler.Builder().chatConfiguration(this.mChatConfiguration).lifecycleEvaluator(this.mLifecycleEvaluator).liveAgentSession(this.mLiveAgentSession).liveAgentQueue(this.mLiveAgentQueue).liveAgentMessageRegistry(this.mLiveAgentMessageRegistry).chatListenerNotifier(this.mChatListenerNotifier).build();
            }
            if (this.mActiveChatHandler == null) {
                this.mActiveChatHandler = new ActiveChatHandler.Builder().liveAgentSession(this.mLiveAgentSession).liveAgentQueue(this.mLiveAgentQueue).chatListenerNotifier(this.mChatListenerNotifier).build();
            }
            if (this.mChatBotHandler == null) {
                this.mChatBotHandler = new ChatBotHandler.Builder().liveAgentSession(this.mLiveAgentSession).liveAgentQueue(this.mLiveAgentQueue).chatListenerNotifier(this.mChatListenerNotifier).build();
            }
            if (this.mEndHandler == null) {
                this.mEndHandler = new EndHandler.Builder().liveAgentSession(this.mLiveAgentSession).liveAgentQueue(this.mLiveAgentQueue).lifecycleEvaluator(this.mLifecycleEvaluator).chatListenerNotifier(this.mChatListenerNotifier).build();
            }
            if (this.mFileTransferHandler == null) {
                this.mFileTransferHandler = new FileTransferHandler.Builder().organizationId(this.mChatConfiguration.getOrganizationId()).liveAgentSession(this.mLiveAgentSession).chatListenerNotifier(this.mChatListenerNotifier).build();
            }
            if (this.mAgentAvailability == null) {
                this.mAgentAvailability = new AgentAvailability.Builder().chatConfiguration(this.mChatConfiguration).build();
            }
            if (this.mMessagesHandler == null) {
                this.mMessagesHandler = new MessagesHandler(this.mLiveAgentSession, this.mChatStartHandler, this.mActiveChatHandler, this.mEndHandler, this.mFileTransferHandler, this.mChatBotHandler);
            }
            return new LiveAgentChatSession(this);
        }
    }
}
