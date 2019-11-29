package com.salesforce.android.service.common.liveagentclient.response;

import com.google.a.a.c;
import com.salesforce.android.service.common.liveagentclient.response.message.LiveAgentMessage;
import java.util.Arrays;
import java.util.List;

public class MessagesResponse {
    @c(a = "messages")
    private List<LiveAgentMessage> mMessages;
    @c(a = "offset")
    private long mOffset;
    @c(a = "sequence")
    private int mSequence;

    public MessagesResponse(int i, long j, LiveAgentMessage... liveAgentMessageArr) {
        this.mMessages = Arrays.asList(liveAgentMessageArr);
        this.mOffset = j;
        this.mSequence = i;
    }

    public List<LiveAgentMessage> getMessages() {
        return this.mMessages;
    }

    public int getSequence() {
        return this.mSequence;
    }

    public long getOffset() {
        return this.mOffset;
    }
}
