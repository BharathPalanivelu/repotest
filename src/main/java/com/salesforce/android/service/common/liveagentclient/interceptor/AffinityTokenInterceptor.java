package com.salesforce.android.service.common.liveagentclient.interceptor;

import com.salesforce.android.service.common.liveagentclient.SessionInfo;
import com.salesforce.android.service.common.liveagentclient.SessionListener;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AffinityTokenInterceptor implements SessionListener, Interceptor {
    protected static final ServiceLogger log = ServiceLogging.getLogger(AffinityTokenInterceptor.class);
    private SessionInfo mSessionInfo;

    public void onError(Throwable th) {
    }

    public void onSessionStateChanged(LiveAgentState liveAgentState, LiveAgentState liveAgentState2) {
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        String header = chain.request().header(LiveAgentRequest.LIVE_AGENT_HEADER_AFFINITY);
        Request.Builder newBuilder = chain.request().newBuilder();
        if (header != null) {
            SessionInfo sessionInfo = this.mSessionInfo;
            if (sessionInfo != null && !header.equals(sessionInfo.getAffinityToken()) && !header.equals("null")) {
                log.trace("Affinity token {} is invalid. Sending {} instead to {}", header, this.mSessionInfo.getAffinityToken(), chain.request().url());
                newBuilder.addHeader(LiveAgentRequest.LIVE_AGENT_HEADER_AFFINITY, this.mSessionInfo.getAffinityToken());
            }
        }
        return chain.proceed(newBuilder.build());
    }

    public void onSessionCreated(SessionInfo sessionInfo) {
        this.mSessionInfo = sessionInfo;
    }
}
