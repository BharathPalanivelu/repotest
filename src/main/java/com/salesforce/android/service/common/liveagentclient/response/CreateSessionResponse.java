package com.salesforce.android.service.common.liveagentclient.response;

import com.google.a.a.c;

public class CreateSessionResponse {
    @c(a = "affinityToken")
    private String mAffinityToken;
    @c(a = "clientPollTimeout")
    private long mClientPollingTimeoutSeconds;
    @c(a = "id")
    private String mSessionId;
    @c(a = "key")
    private String mSessionKey;

    public CreateSessionResponse(String str, String str2, String str3, int i) {
        this.mAffinityToken = str3;
        this.mClientPollingTimeoutSeconds = (long) i;
        this.mSessionId = str;
        this.mSessionKey = str2;
    }

    public String getSessionId() {
        return this.mSessionId;
    }

    public String getAffinityToken() {
        return this.mAffinityToken;
    }

    public String getSessionKey() {
        return this.mSessionKey;
    }

    public long getClientPollingTimeoutMs() {
        return this.mClientPollingTimeoutSeconds * 1000;
    }
}
