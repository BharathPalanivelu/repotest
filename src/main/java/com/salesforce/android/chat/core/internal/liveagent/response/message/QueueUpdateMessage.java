package com.salesforce.android.chat.core.internal.liveagent.response.message;

import com.google.a.a.c;

public class QueueUpdateMessage {
    public static final String TYPE = "QueueUpdate";
    @c(a = "position")
    private int mQueuePosition;

    public QueueUpdateMessage(int i) {
        this.mQueuePosition = i;
    }

    public int getQueuePosition() {
        return this.mQueuePosition;
    }
}
