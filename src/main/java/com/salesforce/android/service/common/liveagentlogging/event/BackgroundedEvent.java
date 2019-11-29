package com.salesforce.android.service.common.liveagentlogging.event;

import com.google.a.a.c;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;

@BatchedEvent(groupId = "backgroundedEvents")
public class BackgroundedEvent extends BaseEvent {
    @c(a = "backgrounded")
    private final boolean mBackgrounded;

    public BackgroundedEvent(String str, String str2, boolean z) {
        super(str, str2);
        this.mBackgrounded = z;
    }

    public boolean isBackgrounded() {
        return this.mBackgrounded;
    }
}
