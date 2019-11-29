package com.salesforce.android.service.common.liveagentclient.response.message;

public class LiveAgentMessage {
    private final Object mContent;
    private final String mTypeIdentifier;

    public LiveAgentMessage(String str, Object obj) {
        this.mContent = obj;
        this.mTypeIdentifier = str;
    }

    public String getTypeIdentifier() {
        return this.mTypeIdentifier;
    }

    public <T> T getContent(Class<T> cls) {
        return cls.cast(this.mContent);
    }
}
