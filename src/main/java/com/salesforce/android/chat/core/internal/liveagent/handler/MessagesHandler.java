package com.salesforce.android.chat.core.internal.liveagent.handler;

import com.salesforce.android.chat.core.internal.chatbot.handler.ChatBotHandler;
import com.salesforce.android.chat.core.internal.chatbot.response.message.RichMessage;
import com.salesforce.android.chat.core.internal.chatbot.response.message.conferencing.AgentJoinedConferenceMessage;
import com.salesforce.android.chat.core.internal.chatbot.response.message.conferencing.AgentLeftConferenceMessage;
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
import com.salesforce.android.service.common.liveagentclient.LiveAgentSession;
import com.salesforce.android.service.common.liveagentclient.MessagesListener;
import com.salesforce.android.service.common.liveagentclient.response.MessagesResponse;
import com.salesforce.android.service.common.liveagentclient.response.message.LiveAgentMessage;

public class MessagesHandler implements MessagesListener {
    private final ActiveChatHandler mActiveChatHandler;
    private final ChatBotHandler mChatBotHandler;
    private final ChatStartHandler mChatStartHandler;
    private final EndHandler mEndHandler;
    private final FileTransferHandler mFileTransferHandler;
    private boolean mIsChatEstablished;

    public MessagesHandler(LiveAgentSession liveAgentSession, ChatStartHandler chatStartHandler, ActiveChatHandler activeChatHandler, EndHandler endHandler, FileTransferHandler fileTransferHandler, ChatBotHandler chatBotHandler) {
        liveAgentSession.addMessagesListener(this);
        this.mChatStartHandler = chatStartHandler;
        this.mActiveChatHandler = activeChatHandler;
        this.mEndHandler = endHandler;
        this.mFileTransferHandler = fileTransferHandler;
        this.mChatBotHandler = chatBotHandler;
    }

    public void onMessagesResponse(MessagesResponse messagesResponse) {
        for (LiveAgentMessage next : messagesResponse.getMessages()) {
            String typeIdentifier = next.getTypeIdentifier();
            char c2 = 65535;
            switch (typeIdentifier.hashCode()) {
                case -1962084096:
                    if (typeIdentifier.equals(ChatEstablishedMessage.TYPE)) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -1409102262:
                    if (typeIdentifier.equals(AgentJoinedConferenceMessage.TYPE)) {
                        c2 = 13;
                        break;
                    }
                    break;
                case -941194052:
                    if (typeIdentifier.equals(AgentTypingMessage.TYPE)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -895802443:
                    if (typeIdentifier.equals(ChatRequestFailMessage.TYPE)) {
                        c2 = 9;
                        break;
                    }
                    break;
                case -894570299:
                    if (typeIdentifier.equals(AgentNotTypingMessage.TYPE)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -695091678:
                    if (typeIdentifier.equals(ChatEndedMessage.TYPE)) {
                        c2 = 10;
                        break;
                    }
                    break;
                case 158689131:
                    if (typeIdentifier.equals(RichMessage.TYPE)) {
                        c2 = 12;
                        break;
                    }
                    break;
                case 177154471:
                    if (typeIdentifier.equals(FileTransferMessage.TYPE)) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 240728622:
                    if (typeIdentifier.equals(ChatTransferredMessage.TYPE)) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 298498415:
                    if (typeIdentifier.equals(ChatMessageMessage.TYPE)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 406212296:
                    if (typeIdentifier.equals(AgentLeftConferenceMessage.TYPE)) {
                        c2 = 14;
                        break;
                    }
                    break;
                case 654896481:
                    if (typeIdentifier.equals(AgentDisconnectMessage.TYPE)) {
                        c2 = 11;
                        break;
                    }
                    break;
                case 823203098:
                    if (typeIdentifier.equals(QueueUpdateMessage.TYPE)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1295718412:
                    if (typeIdentifier.equals(ChatRequestSuccessMessage.TYPE)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1296601363:
                    if (typeIdentifier.equals(TransferToButtonInitiatedMessage.TYPE)) {
                        c2 = 8;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    this.mActiveChatHandler.setIsAgentTyping(true);
                    break;
                case 1:
                    this.mActiveChatHandler.setIsAgentTyping(false);
                    break;
                case 2:
                    this.mActiveChatHandler.handleIncomingChatMessage((ChatMessageMessage) next.getContent(ChatMessageMessage.class));
                    break;
                case 3:
                    ChatRequestSuccessMessage chatRequestSuccessMessage = (ChatRequestSuccessMessage) next.getContent(ChatRequestSuccessMessage.class);
                    this.mChatStartHandler.onChatRequestSuccess(chatRequestSuccessMessage);
                    this.mActiveChatHandler.setSensitiveDataRules(chatRequestSuccessMessage.getSensitiveDataRules());
                    this.mActiveChatHandler.setQueuePosition(chatRequestSuccessMessage.getQueuePosition());
                    break;
                case 4:
                    this.mActiveChatHandler.setQueuePosition(((QueueUpdateMessage) next.getContent(QueueUpdateMessage.class)).getQueuePosition());
                    break;
                case 5:
                    this.mFileTransferHandler.handleFileTransferMessage((FileTransferMessage) next.getContent(FileTransferMessage.class));
                    break;
                case 6:
                    if (!this.mIsChatEstablished) {
                        ChatEstablishedMessage chatEstablishedMessage = (ChatEstablishedMessage) next.getContent(ChatEstablishedMessage.class);
                        this.mChatStartHandler.onChatEstablished(chatEstablishedMessage);
                        this.mChatBotHandler.onFooterMenuReceived(chatEstablishedMessage.getFooterMenu());
                        this.mIsChatEstablished = true;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    this.mActiveChatHandler.onChatTransferred((ChatTransferredMessage) next.getContent(ChatTransferredMessage.class));
                    break;
                case 8:
                    this.mActiveChatHandler.onTransferToButtonInitiated();
                    break;
                case 9:
                    this.mEndHandler.setEndReason((ChatRequestFailMessage) next.getContent(ChatRequestFailMessage.class));
                    break;
                case 10:
                    this.mEndHandler.setEndReason((ChatEndedMessage) next.getContent(ChatEndedMessage.class));
                    break;
                case 11:
                    this.mEndHandler.setEndReason((AgentDisconnectMessage) next.getContent(AgentDisconnectMessage.class));
                    break;
                case 12:
                    this.mChatBotHandler.onRichMessage((RichMessage) next.getContent(RichMessage.class));
                    break;
                case 13:
                    this.mActiveChatHandler.onAgentJoinConference(((AgentJoinedConferenceMessage) next.getContent(AgentJoinedConferenceMessage.class)).getAgentName());
                    break;
                case 14:
                    this.mActiveChatHandler.onAgentLeftConference(((AgentLeftConferenceMessage) next.getContent(AgentLeftConferenceMessage.class)).getAgentName());
                    break;
            }
        }
    }
}
