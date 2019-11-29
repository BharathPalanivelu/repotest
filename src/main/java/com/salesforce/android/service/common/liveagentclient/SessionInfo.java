package com.salesforce.android.service.common.liveagentclient;

public class SessionInfo {
    private final String mAffinityToken;
    private final long mPollingTimeoutMs;
    private final String mSessionId;
    private final String mSessionKey;

    public SessionInfo(String str, String str2, String str3, long j) {
        this.mSessionId = str;
        this.mSessionKey = str2;
        this.mAffinityToken = str3;
        this.mPollingTimeoutMs = j;
    }

    public String getSessionId() {
        return this.mSessionId;
    }

    public String getSessionKey() {
        return this.mSessionKey;
    }

    public String getAffinityToken() {
        return this.mAffinityToken;
    }

    public long getPollingTimeoutMs() {
        return this.mPollingTimeoutMs;
    }

    public String toString() {
        return String.format("SessionInfo[id=%s, key=%s, affinityToken=%s, pollingTimeoutMs=%s]", new Object[]{this.mSessionId, this.mSessionKey, this.mAffinityToken, Long.valueOf(this.mPollingTimeoutMs)});
    }
}
