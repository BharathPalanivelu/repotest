package com.salesforce.android.chat.core.internal.chatbot.request;

import com.google.a.a.c;
import com.google.a.f;
import com.salesforce.android.chat.core.internal.chatbot.response.message.ChatFooterMenuMessage;
import com.salesforce.android.service.common.http.HttpFactory;
import com.salesforce.android.service.common.http.HttpRequest;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentSessionRequest;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import okhttp3.RequestBody;

public class ChatFooterMenuSelectionRequest implements LiveAgentSessionRequest {
    private static final String REQUEST_PATH = "Chasitor/RichMessage";
    private final transient String mAffinityToken;
    @c(a = "actions")
    private MenuSelectionAction[] mMenuSelectionActions;
    private final transient String mSessionKey;

    ChatFooterMenuSelectionRequest(int i, String str, String str2, String str3) {
        this.mMenuSelectionActions = new MenuSelectionAction[]{new MenuSelectionAction(i, str)};
        this.mSessionKey = str2;
        this.mAffinityToken = str3;
    }

    private static class MenuSelectionAction {
        @c(a = "dialogId")
        private String mDialogId;
        @c(a = "index")
        private int mSelectedIndex;
        @c(a = "type")
        private final String mType = ChatFooterMenuMessage.Item.TYPE;

        MenuSelectionAction(int i, String str) {
            this.mSelectedIndex = i;
            this.mDialogId = str;
        }
    }

    public String getSessionKey() {
        return this.mSessionKey;
    }

    public String getAffinityToken() {
        return this.mAffinityToken;
    }

    public String getUrl(String str) {
        return String.format(LiveAgentRequest.LIVE_AGENT_ENDPOINT_FORMAT, new Object[]{Arguments.checkNotNull(str, LiveAgentRequest.ERROR_MESSAGE_POD_IS_NULL), REQUEST_PATH});
    }

    public String toJson(f fVar) {
        return fVar.b((Object) this);
    }

    public HttpRequest build(String str, f fVar, int i) {
        return HttpFactory.request().url(getUrl(str)).addHeader(LiveAgentRequest.HEADER_ACCEPT, LiveAgentRequest.HEADER_ACCEPT_VALUE).addHeader(LiveAgentRequest.LIVE_AGENT_HEADER_API_VERSION, LiveAgentRequest.LIVE_AGENT_HEADER_API_VERSION_VALUE).addHeader(LiveAgentRequest.LIVE_AGENT_HEADER_SESSION_KEY, this.mSessionKey).addHeader(LiveAgentRequest.LIVE_AGENT_HEADER_AFFINITY, this.mAffinityToken).addHeader(LiveAgentRequest.LIVE_AGENT_HEADER_SEQUENCE, Integer.toString(i)).post(RequestBody.create(MEDIA_TYPE, toJson(fVar))).build();
    }
}
