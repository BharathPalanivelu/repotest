package com.salesforce.android.chat.core.internal.chatbot.request;

import com.salesforce.android.service.common.liveagentclient.SessionInfo;

public class ChatBotRequestFactory {
    public ChatWindowMenuSelectionRequest createMenuSelectionRequest(int i, SessionInfo sessionInfo) {
        return new ChatWindowMenuSelectionRequest(i, sessionInfo.getSessionKey(), sessionInfo.getAffinityToken());
    }

    public ChatFooterMenuSelectionRequest createFooterMenuSelectionRequest(int i, String str, SessionInfo sessionInfo) {
        return new ChatFooterMenuSelectionRequest(i, str, sessionInfo.getSessionKey(), sessionInfo.getAffinityToken());
    }

    public ChatWindowButtonSelectionRequest createChatButtonSelectionRequest(int i, SessionInfo sessionInfo) {
        return new ChatWindowButtonSelectionRequest(i, sessionInfo.getSessionKey(), sessionInfo.getAffinityToken());
    }
}
