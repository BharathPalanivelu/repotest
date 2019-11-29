package com.salesforce.android.chat.core.internal.liveagent.request;

import com.google.a.a.c;
import com.google.a.f;
import com.salesforce.android.service.common.http.HttpFactory;
import com.salesforce.android.service.common.http.HttpRequest;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class AgentAvailabilityRequest implements LiveAgentRequest {
    private static final String REQUEST_FORMAT = "https://%s/chat/rest/%s?org_id=%s&deployment_id=%s&Availability.ids=%s";
    private static final String REQUEST_PATH = "Visitor/Availability";
    @c(a = "Availability.ids")
    private String mButtonId;
    @c(a = "deployment_id")
    private String mDeploymentId;
    @c(a = "org_id")
    private String mOrganizationId;

    AgentAvailabilityRequest(String str, String str2, String str3) {
        this.mOrganizationId = str;
        this.mDeploymentId = str2;
        this.mButtonId = str3;
    }

    public String getOrganizationId() {
        return this.mOrganizationId;
    }

    public String getDeploymentId() {
        return this.mDeploymentId;
    }

    public String getButtonId() {
        return this.mButtonId;
    }

    public String getUrl(String str) {
        return String.format(REQUEST_FORMAT, new Object[]{Arguments.checkNotNull(str, LiveAgentRequest.ERROR_MESSAGE_POD_IS_NULL), REQUEST_PATH, this.mOrganizationId, this.mDeploymentId, this.mButtonId});
    }

    public String toJson(f fVar) {
        return fVar.b((Object) this);
    }

    public HttpRequest build(String str, f fVar, int i) {
        return HttpFactory.request().url(getUrl(str)).addHeader(LiveAgentRequest.HEADER_ACCEPT, LiveAgentRequest.HEADER_ACCEPT_VALUE).addHeader(LiveAgentRequest.LIVE_AGENT_HEADER_API_VERSION, LiveAgentRequest.LIVE_AGENT_HEADER_API_VERSION_VALUE).get().build();
    }
}
