package com.salesforce.android.service.common.liveagentclient.request;

import com.google.a.f;
import com.salesforce.android.service.common.http.HttpFactory;
import com.salesforce.android.service.common.http.HttpRequest;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class MessagesRequest implements LiveAgentSessionRequest {
    private static final String REQUEST_PATH = "System/Messages";
    private final transient String mAffinityToken;
    private final transient String mSessionKey;

    public MessagesRequest(String str, String str2) {
        this.mSessionKey = str;
        this.mAffinityToken = str2;
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
        return HttpFactory.request().url(getUrl(str)).addHeader(LiveAgentRequest.HEADER_ACCEPT, LiveAgentRequest.HEADER_ACCEPT_VALUE).addHeader(LiveAgentRequest.LIVE_AGENT_HEADER_API_VERSION, LiveAgentRequest.LIVE_AGENT_HEADER_API_VERSION_VALUE).addHeader(LiveAgentRequest.LIVE_AGENT_HEADER_SESSION_KEY, getSessionKey()).addHeader(LiveAgentRequest.LIVE_AGENT_HEADER_AFFINITY, getAffinityToken()).get().build();
    }
}
