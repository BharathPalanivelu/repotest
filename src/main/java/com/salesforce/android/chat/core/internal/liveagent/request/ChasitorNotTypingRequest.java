package com.salesforce.android.chat.core.internal.liveagent.request;

import com.google.a.f;
import com.salesforce.android.service.common.http.HttpFactory;
import com.salesforce.android.service.common.http.HttpRequest;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentSessionRequest;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import okhttp3.RequestBody;

public class ChasitorNotTypingRequest implements LiveAgentSessionRequest {
    private static final String REQUEST_PATH = "Chasitor/ChasitorNotTyping";
    private final transient String mAffinityToken;
    private final transient String mSessionKey;

    ChasitorNotTypingRequest(String str, String str2) {
        this.mAffinityToken = str2;
        this.mSessionKey = str;
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
