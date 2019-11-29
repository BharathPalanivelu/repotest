package com.salesforce.android.service.common.liveagentclient.response;

public class LiveAgentStringResponse {
    private String mValue;

    public LiveAgentStringResponse(String str) {
        this.mValue = str;
    }

    public String getValue() {
        return this.mValue;
    }
}
