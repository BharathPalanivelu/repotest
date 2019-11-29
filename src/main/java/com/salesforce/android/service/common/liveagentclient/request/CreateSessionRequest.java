package com.salesforce.android.service.common.liveagentclient.request;

import com.google.a.f;
import com.salesforce.android.service.common.http.HttpFactory;
import com.salesforce.android.service.common.http.HttpRequest;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class CreateSessionRequest implements LiveAgentRequest {
    private static final String REQUEST_PATH = "System/SessionId";

    public String getUrl(String str) {
        return String.format(LiveAgentRequest.LIVE_AGENT_ENDPOINT_FORMAT, new Object[]{Arguments.checkNotNull(str, LiveAgentRequest.ERROR_MESSAGE_POD_IS_NULL), REQUEST_PATH});
    }

    public String toJson(f fVar) {
        return fVar.b((Object) this);
    }

    public HttpRequest build(String str, f fVar, int i) {
        return HttpFactory.request().url(getUrl(str)).addHeader(LiveAgentRequest.HEADER_ACCEPT, LiveAgentRequest.HEADER_ACCEPT_VALUE).addHeader(LiveAgentRequest.LIVE_AGENT_HEADER_API_VERSION, LiveAgentRequest.LIVE_AGENT_HEADER_API_VERSION_VALUE).addHeader(LiveAgentRequest.LIVE_AGENT_HEADER_AFFINITY, "null").get().build();
    }
}
