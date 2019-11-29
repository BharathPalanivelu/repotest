package com.salesforce.android.service.common.liveagentclient.request;

import com.google.a.f;
import com.salesforce.android.service.common.http.HttpFactory;
import com.salesforce.android.service.common.http.HttpRequest;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class ReconnectRequest implements LiveAgentRequest {
    private static final String ENDPOINT_FORMAT = "https://%s/chat/rest/%s?ReconnectSession.offset=%s";
    private static final String REQUEST_PATH = "System/ReconnectSession";
    private final transient long mOffset;
    private final transient String mSessionKey;

    ReconnectRequest(String str, long j) {
        this.mSessionKey = str;
        this.mOffset = j;
    }

    public String getSessionKey() {
        return this.mSessionKey;
    }

    public String getUrl(String str) {
        return String.format(ENDPOINT_FORMAT, new Object[]{Arguments.checkNotNull(str, LiveAgentRequest.ERROR_MESSAGE_POD_IS_NULL), REQUEST_PATH, Long.valueOf(this.mOffset)});
    }

    public String toJson(f fVar) {
        return fVar.b((Object) this);
    }

    public HttpRequest build(String str, f fVar, int i) {
        return HttpFactory.request().url(getUrl(str)).addHeader(LiveAgentRequest.HEADER_ACCEPT, LiveAgentRequest.HEADER_ACCEPT_VALUE).addHeader(LiveAgentRequest.LIVE_AGENT_HEADER_API_VERSION, LiveAgentRequest.LIVE_AGENT_HEADER_API_VERSION_VALUE).addHeader(LiveAgentRequest.LIVE_AGENT_HEADER_SESSION_KEY, getSessionKey()).addHeader(LiveAgentRequest.LIVE_AGENT_HEADER_AFFINITY, "null").get().build();
    }
}
