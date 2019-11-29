package com.salesforce.android.chat.core.internal.service;

import android.content.Context;
import com.salesforce.android.chat.core.ChatAnalyticsEmit;
import com.salesforce.android.chat.core.ChatBotListener;
import com.salesforce.android.chat.core.ChatConfiguration;
import com.salesforce.android.chat.core.FileTransferAssistant;
import com.salesforce.android.chat.core.FileTransferRequestListener;
import com.salesforce.android.chat.core.QueueListener;
import com.salesforce.android.chat.core.internal.client.ChatClientListenerNotifier;
import com.salesforce.android.chat.core.internal.liveagent.AgentListener;
import com.salesforce.android.chat.core.internal.liveagent.ChatStateListener;
import com.salesforce.android.chat.core.internal.liveagent.LiveAgentChatSession;
import com.salesforce.android.chat.core.internal.liveagent.lifecycle.LiveAgentChatState;
import com.salesforce.android.chat.core.internal.service.ChatServiceNotification;
import com.salesforce.android.chat.core.model.AgentInformation;
import com.salesforce.android.chat.core.model.ChatEndReason;
import com.salesforce.android.chat.core.model.ChatFooterMenu;
import com.salesforce.android.chat.core.model.ChatMessage;
import com.salesforce.android.chat.core.model.ChatSentMessageReceipt;
import com.salesforce.android.chat.core.model.ChatSessionInfo;
import com.salesforce.android.chat.core.model.ChatSessionState;
import com.salesforce.android.chat.core.model.ChatWindowButtonMenu;
import com.salesforce.android.chat.core.model.ChatWindowMenu;
import com.salesforce.android.chat.core.model.FileTransferStatus;
import com.salesforce.android.service.common.liveagentclient.SessionInfo;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.security.GeneralSecurityException;

public class ChatServiceController implements ChatBotListener, FileTransferRequestListener, QueueListener, AgentListener, ChatStateListener {
    private static final ServiceLogger log = ServiceLogging.getLogger(ChatServiceController.class);
    private ChatClientListenerNotifier mChatClientListenerNotifier;
    private final ChatService mChatService;
    private final LiveAgentChatSession mLiveAgentChatSession;

    private ChatServiceController(ChatService chatService, ChatServiceNotification chatServiceNotification, LiveAgentChatSession liveAgentChatSession) {
        this.mChatService = chatService;
        this.mLiveAgentChatSession = liveAgentChatSession;
        this.mLiveAgentChatSession.addAgentListener(this).addChatStateListener(this).addQueueListener(this).addFileTransferRequestListener(this).addChatBotListener(this);
        ChatService chatService2 = this.mChatService;
        chatService2.startForeground(547, chatServiceNotification.getNotification(chatService2));
    }

    public void setChatClientListenerNotifier(ChatClientListenerNotifier chatClientListenerNotifier) {
        this.mChatClientListenerNotifier = chatClientListenerNotifier;
    }

    /* access modifiers changed from: package-private */
    public void createChatSession() {
        this.mLiveAgentChatSession.start();
    }

    public void endChatSession() {
        this.mLiveAgentChatSession.endSessionFromClient();
    }

    public Context getContext() {
        return this.mChatService;
    }

    public Async<ChatSentMessageReceipt> sendChatMessage(String str) {
        final BasicAsync create = BasicAsync.create();
        this.mLiveAgentChatSession.sendChatMessage(str).onResult(new Async.ResultHandler<ChatSentMessageReceipt>() {
            public void handleResult(Async<?> async, ChatSentMessageReceipt chatSentMessageReceipt) {
                create.setResult(chatSentMessageReceipt);
            }
        }).onComplete(new Async.CompletionHandler() {
            public void handleComplete(Async<?> async) {
                ChatAnalyticsEmit.responseMessageSent();
                create.complete();
            }
        }).onError(new Async.ErrorHandler() {
            public void handleError(Async<?> async, Throwable th) {
                ChatAnalyticsEmit.responseError(th);
                create.setError(th);
            }
        });
        return create;
    }

    public Async<Void> sendSneakPeekMessage(String str) {
        final BasicAsync create = BasicAsync.create();
        this.mLiveAgentChatSession.sendSneakPeekMessage(str).onComplete(new Async.CompletionHandler() {
            public void handleComplete(Async<?> async) {
                create.complete();
            }
        }).onError(new Async.ErrorHandler() {
            public void handleError(Async<?> async, Throwable th) {
                create.setError(th);
            }
        });
        return create;
    }

    public Async<Void> sendMenuSelection(int i) {
        final BasicAsync create = BasicAsync.create();
        this.mLiveAgentChatSession.sendMenuSelection(i).onComplete(new Async.CompletionHandler() {
            public void handleComplete(Async<?> async) {
                create.complete();
            }
        }).onError(new Async.ErrorHandler() {
            public void handleError(Async<?> async, Throwable th) {
                create.setError(th);
            }
        });
        return create;
    }

    public Async<Void> sendButtonSelection(int i) {
        final BasicAsync create = BasicAsync.create();
        this.mLiveAgentChatSession.sendButtonSelection(i).onComplete(new Async.CompletionHandler() {
            public void handleComplete(Async<?> async) {
                create.complete();
            }
        }).onError(new Async.ErrorHandler() {
            public void handleError(Async<?> async, Throwable th) {
                create.setError(th);
            }
        });
        return create;
    }

    public Async<Void> sendFooterMenuSelection(int i, String str) {
        final BasicAsync create = BasicAsync.create();
        this.mLiveAgentChatSession.sendFooterMenuSelection(i, str).onComplete(new Async.CompletionHandler() {
            public void handleComplete(Async<?> async) {
                create.complete();
            }
        }).onError(new Async.ErrorHandler() {
            public void handleError(Async<?> async, Throwable th) {
                create.setError(th);
            }
        });
        return create;
    }

    public Async<Void> setIsUserTyping(boolean z) {
        final BasicAsync create = BasicAsync.create();
        this.mLiveAgentChatSession.sendUserIsTyping(z).onComplete(new Async.CompletionHandler() {
            public void handleComplete(Async<?> async) {
                create.complete();
            }
        }).onError(new Async.ErrorHandler() {
            public void handleError(Async<?> async, Throwable th) {
                ChatAnalyticsEmit.responseError(th);
                create.setError(th);
            }
        });
        return create;
    }

    public void onAgentJoined(AgentInformation agentInformation) {
        ChatAnalyticsEmit.responseAgentJoined(agentInformation.getAgentName(), agentInformation.getAgentId());
        ChatClientListenerNotifier chatClientListenerNotifier = this.mChatClientListenerNotifier;
        if (chatClientListenerNotifier != null) {
            chatClientListenerNotifier.onAgentJoined(agentInformation);
        }
    }

    public void onIsAgentTyping(boolean z) {
        if (z) {
            ChatAnalyticsEmit.responseAgentIsTyping();
        } else {
            ChatAnalyticsEmit.responseAgentHasFinishedTyping();
        }
        ChatClientListenerNotifier chatClientListenerNotifier = this.mChatClientListenerNotifier;
        if (chatClientListenerNotifier != null) {
            chatClientListenerNotifier.onAgentIsTyping(z);
        }
    }

    public void onChatMessageReceived(ChatMessage chatMessage) {
        ChatAnalyticsEmit.responseMessageReceived(chatMessage.getTimestamp());
        ChatClientListenerNotifier chatClientListenerNotifier = this.mChatClientListenerNotifier;
        if (chatClientListenerNotifier != null) {
            chatClientListenerNotifier.onChatMessageReceived(chatMessage);
        }
    }

    public void onTransferToButtonInitiated() {
        ChatClientListenerNotifier chatClientListenerNotifier = this.mChatClientListenerNotifier;
        if (chatClientListenerNotifier != null) {
            chatClientListenerNotifier.onTransferToButtonInitiated();
        }
    }

    public void onAgentJoinedConference(String str) {
        ChatAnalyticsEmit.responseAgentJoinedConference(ChatSessionState.Connected);
        ChatClientListenerNotifier chatClientListenerNotifier = this.mChatClientListenerNotifier;
        if (chatClientListenerNotifier != null) {
            chatClientListenerNotifier.onAgentJoinedConference(str);
        }
    }

    public void onAgentLeftConference(String str) {
        ChatAnalyticsEmit.responseAgentLeftConference(ChatSessionState.Connected);
        ChatClientListenerNotifier chatClientListenerNotifier = this.mChatClientListenerNotifier;
        if (chatClientListenerNotifier != null) {
            chatClientListenerNotifier.onAgentLeftConference(str);
        }
    }

    public void onSessionCreated(SessionInfo sessionInfo) {
        ChatAnalyticsEmit.responseSessionCreated(sessionInfo.getSessionId());
    }

    public void onChatSessionCreated(ChatSessionInfo chatSessionInfo) {
        ChatClientListenerNotifier chatClientListenerNotifier = this.mChatClientListenerNotifier;
        if (chatClientListenerNotifier != null) {
            chatClientListenerNotifier.onSessionInfoReceived(chatSessionInfo);
        }
    }

    public void onStateChanged(LiveAgentChatState liveAgentChatState, LiveAgentChatState liveAgentChatState2) {
        if (this.mChatClientListenerNotifier != null) {
            log.info("Current LiveAgentChat State: {}", liveAgentChatState);
            switch (liveAgentChatState) {
                case Verification:
                    this.mChatClientListenerNotifier.onSessionStateChange(ChatSessionState.Verification);
                    return;
                case Initializing:
                    this.mChatClientListenerNotifier.onSessionStateChange(ChatSessionState.Initializing);
                    return;
                case CreatingSession:
                    this.mChatClientListenerNotifier.onSessionStateChange(ChatSessionState.Connecting);
                    return;
                case InQueue:
                    this.mChatClientListenerNotifier.onSessionStateChange(ChatSessionState.InQueue);
                    return;
                case Chatting:
                    this.mChatClientListenerNotifier.onSessionStateChange(ChatSessionState.Connected);
                    return;
                case EndingSession:
                    this.mChatClientListenerNotifier.onSessionStateChange(ChatSessionState.Ending);
                    return;
                case Ended:
                    this.mChatClientListenerNotifier.onSessionStateChange(ChatSessionState.Disconnected);
                    return;
                default:
                    return;
            }
        }
    }

    public void onChatEnded(ChatEndReason chatEndReason) {
        ChatClientListenerNotifier chatClientListenerNotifier = this.mChatClientListenerNotifier;
        if (chatClientListenerNotifier != null) {
            chatClientListenerNotifier.onSessionEnded(chatEndReason);
        }
    }

    public void onVerificationFailed() {
        this.mLiveAgentChatSession.endSessionWithValidationError();
        ChatClientListenerNotifier chatClientListenerNotifier = this.mChatClientListenerNotifier;
        if (chatClientListenerNotifier != null) {
            chatClientListenerNotifier.onSessionEnded(ChatEndReason.VerificationError);
        }
    }

    public void onQueuePositionUpdate(int i) {
        ChatClientListenerNotifier chatClientListenerNotifier = this.mChatClientListenerNotifier;
        if (chatClientListenerNotifier != null) {
            chatClientListenerNotifier.onQueuePositionUpdate(i);
        }
    }

    public void onFileTransferRequest(FileTransferAssistant fileTransferAssistant) {
        ChatClientListenerNotifier chatClientListenerNotifier = this.mChatClientListenerNotifier;
        if (chatClientListenerNotifier != null) {
            chatClientListenerNotifier.onFileTransferRequest(fileTransferAssistant);
        }
    }

    public void onFileTransferStatusChanged(FileTransferStatus fileTransferStatus) {
        ChatClientListenerNotifier chatClientListenerNotifier = this.mChatClientListenerNotifier;
        if (chatClientListenerNotifier != null) {
            chatClientListenerNotifier.onFileTransferStatusChanged(fileTransferStatus);
        }
    }

    public void onChatMenuReceived(ChatWindowMenu chatWindowMenu) {
        ChatClientListenerNotifier chatClientListenerNotifier = this.mChatClientListenerNotifier;
        if (chatClientListenerNotifier != null) {
            chatClientListenerNotifier.onChatMenuReceived(chatWindowMenu);
        }
    }

    public void onChatFooterMenuReceived(ChatFooterMenu chatFooterMenu) {
        ChatClientListenerNotifier chatClientListenerNotifier = this.mChatClientListenerNotifier;
        if (chatClientListenerNotifier != null) {
            chatClientListenerNotifier.onChatFooterMenuReceived(chatFooterMenu);
        }
    }

    public void onChatButtonMenuReceived(ChatWindowButtonMenu chatWindowButtonMenu) {
        ChatClientListenerNotifier chatClientListenerNotifier = this.mChatClientListenerNotifier;
        if (chatClientListenerNotifier != null) {
            chatClientListenerNotifier.onChatButtonMenuReceived(chatWindowButtonMenu);
        }
    }

    static class Builder {
        private ChatServiceNotification mChatServiceNotification;
        private LiveAgentChatSession mLiveAgentChatSession;

        Builder() {
        }

        /* access modifiers changed from: package-private */
        public Builder chatServiceNotification(ChatServiceNotification chatServiceNotification) {
            this.mChatServiceNotification = chatServiceNotification;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder liveAgentChatSession(LiveAgentChatSession liveAgentChatSession) {
            this.mLiveAgentChatSession = liveAgentChatSession;
            return this;
        }

        /* access modifiers changed from: package-private */
        public ChatServiceController build(ChatService chatService, ChatConfiguration chatConfiguration) throws GeneralSecurityException {
            if (this.mChatServiceNotification == null) {
                this.mChatServiceNotification = new ChatServiceNotification.Builder().build(chatService);
            }
            if (this.mLiveAgentChatSession == null) {
                this.mLiveAgentChatSession = new LiveAgentChatSession.Builder().with(chatService).chatConfiguration(chatConfiguration).build();
            }
            return new ChatServiceController(chatService, this.mChatServiceNotification, this.mLiveAgentChatSession);
        }
    }
}
