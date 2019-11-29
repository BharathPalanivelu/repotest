package com.salesforce.android.service.common.liveagentclient.request;

import com.google.a.f;
import com.salesforce.android.service.common.http.HttpRequest;
import okhttp3.MediaType;

public interface LiveAgentRequest {
    public static final String ERROR_MESSAGE_POD_IS_NULL = "LiveAgent Pod must not be null";
    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_ACCEPT_VALUE = "application/json; charset=utf-8";
    public static final String LIVE_AGENT_ENDPOINT_FORMAT = "https://%s/chat/rest/%s";
    public static final String LIVE_AGENT_HEADER_AFFINITY = "x-liveagent-affinity";
    public static final String LIVE_AGENT_HEADER_API_VERSION = "x-liveagent-api-version";
    public static final String LIVE_AGENT_HEADER_API_VERSION_VALUE = "43";
    public static final String LIVE_AGENT_HEADER_SEQUENCE = "x-liveagent-sequence";
    public static final String LIVE_AGENT_HEADER_SESSION_KEY = "x-liveagent-session-key";
    public static final MediaType MEDIA_TYPE = MediaType.parse(HEADER_ACCEPT_VALUE);

    HttpRequest build(String str, f fVar, int i);

    String getUrl(String str);

    String toJson(f fVar);
}
