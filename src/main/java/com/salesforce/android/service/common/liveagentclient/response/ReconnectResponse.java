package com.salesforce.android.service.common.liveagentclient.response;

public class ReconnectResponse {
    private final String mAffinityToken;
    private final boolean mIsSequenceResetRequested;

    public ReconnectResponse(String str) {
        this.mIsSequenceResetRequested = true;
        this.mAffinityToken = str;
    }

    public ReconnectResponse(boolean z, String str) {
        this.mIsSequenceResetRequested = z;
        this.mAffinityToken = str;
    }

    public boolean isSequenceResetRequested() {
        return this.mIsSequenceResetRequested;
    }

    public String getAffinityToken() {
        return this.mAffinityToken;
    }
}
