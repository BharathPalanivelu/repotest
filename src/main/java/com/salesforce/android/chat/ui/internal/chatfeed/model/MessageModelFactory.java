package com.salesforce.android.chat.ui.internal.chatfeed.model;

import com.salesforce.android.chat.core.model.ChatWindowButtonMenu;
import com.salesforce.android.chat.core.model.ChatWindowMenu;
import com.salesforce.android.chat.ui.internal.filetransfer.model.ImageThumbnail;
import java.util.Date;

public class MessageModelFactory {
    public ReceivedMessage newReceivedMessage(String str, String str2, String str3, Date date) {
        return new ReceivedMessage(str, str2, str3, date);
    }

    public AgentIsTypingMessage newAgentIsTypingMessage(String str, String str2, Date date) {
        return new AgentIsTypingMessage(str, str2, date);
    }

    public SentMessage newSentMessage(String str, String str2, Date date) {
        return new SentMessage(str, str2, date);
    }

    public SentPhotoMessage newSentPhotoMessage(String str, ImageThumbnail imageThumbnail, Date date) {
        return new SentPhotoMessage(str, imageThumbnail, date);
    }

    public HorizontalRule newHorizontalRule(String str) {
        return new HorizontalRule(str);
    }

    public Notice newNotice(int i) {
        return new Notice(i);
    }

    public MessageSpacer newMessageSpacer() {
        return new MessageSpacer();
    }

    public ChatMenuMessage newChatMenu(String str, String str2, Date date, ChatWindowMenu.MenuItem... menuItemArr) {
        return new ChatMenuMessage(str, str2, date, menuItemArr);
    }

    public ChatButtonMenuMessage newChatButtonMenu(Date date, ChatWindowButtonMenu.Button... buttonArr) {
        return new ChatButtonMenuMessage(date, buttonArr);
    }

    public ChatBotTransferWaitingIndicator newChatFeedTransferWaitingIndicator() {
        return new ChatBotTransferWaitingIndicator();
    }

    public ChatBotTransferNoAgentAvailableMessage newChatBotTransferNoAgentsAvailableMessage() {
        return new ChatBotTransferNoAgentAvailableMessage();
    }

    public AgentHasJoinedConferenceMessage newAgentHasJoinedConferenceMessage(String str) {
        return new AgentHasJoinedConferenceMessage(str, new Date());
    }

    public AgentHasLeftConferenceMessage newAgentHasLeftConferenceMessage(String str) {
        return new AgentHasLeftConferenceMessage(str, new Date());
    }
}
