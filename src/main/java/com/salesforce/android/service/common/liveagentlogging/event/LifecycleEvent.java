package com.salesforce.android.service.common.liveagentlogging.event;

import com.google.a.a.c;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;

@BatchedEvent(groupId = "lifecycleEvents")
public class LifecycleEvent extends BaseEvent {
    @c(a = "current")
    private final String mCurrent;
    @c(a = "previous")
    private final String mPrevious;
    @c(a = "reason")
    private final String mReason;

    public LifecycleEvent(String str, String str2, String str3, String str4) {
        this(str, str2, str3, str4, (String) null);
    }

    public LifecycleEvent(String str, String str2, String str3, String str4, String str5) {
        super(str, str2);
        this.mCurrent = str3;
        this.mPrevious = str4;
        this.mReason = str5;
    }

    public String getCurrent() {
        return this.mCurrent;
    }

    public String getPrevious() {
        return this.mPrevious;
    }

    public String getReason() {
        return this.mReason;
    }
}
