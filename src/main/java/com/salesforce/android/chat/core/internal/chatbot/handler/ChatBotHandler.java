package com.salesforce.android.chat.core.internal.chatbot.handler;

import com.salesforce.android.chat.core.internal.chatbot.request.ChatBotRequestFactory;
import com.salesforce.android.chat.core.internal.chatbot.response.message.ChatFooterMenuMessage;
import com.salesforce.android.chat.core.internal.liveagent.ChatListenerNotifier;
import com.salesforce.android.service.common.liveagentclient.LiveAgentSession;
import com.salesforce.android.service.common.liveagentclient.SessionInfo;
import com.salesforce.android.service.common.liveagentclient.SessionListener;
import com.salesforce.android.service.common.liveagentclient.integrity.LiveAgentQueue;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState;
import com.salesforce.android.service.common.liveagentclient.response.LiveAgentStringResponse;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class ChatBotHandler implements SessionListener {
    private static final ServiceLogger log = ServiceLogging.getLogger(ChatBotHandler.class);
    private final ChatBotRequestFactory mChatBotRequestFactory;
    private final ChatListenerNotifier mChatListenerNotifier;
    private final LiveAgentQueue mLiveAgentQueue;
    private SessionInfo mSessionInfo;

    public void onError(Throwable th) {
    }

    public void onSessionStateChanged(LiveAgentState liveAgentState, LiveAgentState liveAgentState2) {
    }

    private ChatBotHandler(Builder builder) {
        this.mLiveAgentQueue = builder.mLiveAgentQueue;
        this.mChatBotRequestFactory = builder.mChatBotRequestFactory;
        this.mChatListenerNotifier = builder.mChatListenerNotifier;
        builder.mLiveAgentSession.addSessionListener(this);
    }

    public Async<LiveAgentStringResponse> sendMenuSelection(int i) {
        if (this.mSessionInfo == null) {
            return BasicAsync.error(new RuntimeException("Session does not exist"));
        }
        log.trace("Queuing window menu selection: {}", Integer.valueOf(i));
        return this.mLiveAgentQueue.add(this.mChatBotRequestFactory.createMenuSelectionRequest(i, this.mSessionInfo), LiveAgentStringResponse.class);
    }

    public Async<LiveAgentStringResponse> sendButtonSelection(int i) {
        if (this.mSessionInfo == null) {
            return BasicAsync.error(new RuntimeException("Session does not exist"));
        }
        log.trace("Queuing window button selection: {}", Integer.valueOf(i));
        return this.mLiveAgentQueue.add(this.mChatBotRequestFactory.createChatButtonSelectionRequest(i, this.mSessionInfo), LiveAgentStringResponse.class);
    }

    public Async<LiveAgentStringResponse> sendFooterMenuSelection(int i, String str) {
        if (this.mSessionInfo == null) {
            return BasicAsync.error(new RuntimeException("Session does not exist"));
        }
        log.trace("Queuing footer menu selection: {}, {}", Integer.valueOf(i), str);
        return this.mLiveAgentQueue.add(this.mChatBotRequestFactory.createFooterMenuSelectionRequest(i, str, this.mSessionInfo), LiveAgentStringResponse.class);
    }

    public void onFooterMenuReceived(ChatFooterMenuMessage chatFooterMenuMessage) {
        if (chatFooterMenuMessage != null && chatFooterMenuMessage.getMenuItems().length > 0) {
            log.debug("Received footer menu from Chat Bot: {}", chatFooterMenuMessage);
            this.mChatListenerNotifier.onChatFooterMenuReceived(chatFooterMenuMessage);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRichMessage(com.salesforce.android.chat.core.internal.chatbot.response.message.RichMessage r6) {
        /*
            r5 = this;
            java.lang.String r0 = r6.getTypeIdentifier()
            int r1 = r0.hashCode()
            r2 = -585227558(0xffffffffdd1e22da, float:-7.1218186E17)
            r3 = 0
            r4 = 1
            if (r1 == r2) goto L_0x001f
            r2 = 1242159879(0x4a09db07, float:2258625.8)
            if (r1 == r2) goto L_0x0015
            goto L_0x0029
        L_0x0015:
            java.lang.String r1 = "ChatWindowMenu"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0029
            r0 = 0
            goto L_0x002a
        L_0x001f:
            java.lang.String r1 = "ChatWindowButton"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0029
            r0 = 1
            goto L_0x002a
        L_0x0029:
            r0 = -1
        L_0x002a:
            if (r0 == 0) goto L_0x0060
            if (r0 == r4) goto L_0x0047
            com.salesforce.android.service.common.utilities.logging.ServiceLogger r0 = log
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = r6.getTypeIdentifier()
            r1[r3] = r2
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            java.lang.Object r6 = r6.getContent(r2)
            r1[r4] = r6
            java.lang.String r6 = "Ignoring unknown RichMessage. Type[{}] - Content[{}]"
            r0.warn(r6, r1)
            goto L_0x0078
        L_0x0047:
            java.lang.Class<com.salesforce.android.chat.core.internal.chatbot.response.message.ChatWindowButtonMenuMessage> r0 = com.salesforce.android.chat.core.internal.chatbot.response.message.ChatWindowButtonMenuMessage.class
            java.lang.Object r6 = r6.getContent(r0)
            com.salesforce.android.chat.core.internal.chatbot.response.message.ChatWindowButtonMenuMessage r6 = (com.salesforce.android.chat.core.internal.chatbot.response.message.ChatWindowButtonMenuMessage) r6
            com.salesforce.android.service.common.utilities.logging.ServiceLogger r0 = log
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r1[r3] = r6
            java.lang.String r2 = "Received button(s) from Chat Bot: {}"
            r0.debug(r2, r1)
            com.salesforce.android.chat.core.internal.liveagent.ChatListenerNotifier r0 = r5.mChatListenerNotifier
            r0.onChatButtonMenuReceived(r6)
            goto L_0x0078
        L_0x0060:
            java.lang.Class<com.salesforce.android.chat.core.internal.chatbot.response.message.ChatWindowMenuMessage> r0 = com.salesforce.android.chat.core.internal.chatbot.response.message.ChatWindowMenuMessage.class
            java.lang.Object r6 = r6.getContent(r0)
            com.salesforce.android.chat.core.internal.chatbot.response.message.ChatWindowMenuMessage r6 = (com.salesforce.android.chat.core.internal.chatbot.response.message.ChatWindowMenuMessage) r6
            com.salesforce.android.service.common.utilities.logging.ServiceLogger r0 = log
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r1[r3] = r6
            java.lang.String r2 = "Received window menu from Chat Bot: {}"
            r0.debug(r2, r1)
            com.salesforce.android.chat.core.internal.liveagent.ChatListenerNotifier r0 = r5.mChatListenerNotifier
            r0.onChatMenuReceived(r6)
        L_0x0078:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.android.chat.core.internal.chatbot.handler.ChatBotHandler.onRichMessage(com.salesforce.android.chat.core.internal.chatbot.response.message.RichMessage):void");
    }

    public void onSessionCreated(SessionInfo sessionInfo) {
        this.mSessionInfo = sessionInfo;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public ChatBotRequestFactory mChatBotRequestFactory;
        /* access modifiers changed from: private */
        public ChatListenerNotifier mChatListenerNotifier;
        /* access modifiers changed from: private */
        public LiveAgentQueue mLiveAgentQueue;
        /* access modifiers changed from: private */
        public LiveAgentSession mLiveAgentSession;

        public Builder liveAgentSession(LiveAgentSession liveAgentSession) {
            this.mLiveAgentSession = liveAgentSession;
            return this;
        }

        public Builder chatListenerNotifier(ChatListenerNotifier chatListenerNotifier) {
            this.mChatListenerNotifier = chatListenerNotifier;
            return this;
        }

        public Builder liveAgentQueue(LiveAgentQueue liveAgentQueue) {
            this.mLiveAgentQueue = liveAgentQueue;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder chatBotRequestFactory(ChatBotRequestFactory chatBotRequestFactory) {
            this.mChatBotRequestFactory = chatBotRequestFactory;
            return this;
        }

        public ChatBotHandler build() {
            Arguments.checkNotNull(this.mLiveAgentSession);
            Arguments.checkNotNull(this.mLiveAgentQueue);
            Arguments.checkNotNull(this.mChatListenerNotifier);
            if (this.mChatBotRequestFactory == null) {
                this.mChatBotRequestFactory = new ChatBotRequestFactory();
            }
            return new ChatBotHandler(this);
        }
    }
}
