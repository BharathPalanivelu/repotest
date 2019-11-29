package com.salesforce.android.chat.core.internal.logging.event;

import com.google.a.a.c;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@BatchedEvent(groupId = "eventEvents")
public class AgentGroupConferenceEvent extends BaseEvent {
    public static final String JOINED = "AgentJoinedGroupConference";
    public static final String LEFT = "AgentLeftGroupConference";
    @c(a = "eventType")
    private final String mEventType;
    @c(a = "lifecycleState")
    private String mLifecycleState;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    public AgentGroupConferenceEvent(String str, String str2, String str3) {
        super(BaseEvent.SDK_CHAT, str);
        this.mEventType = str2;
        this.mLifecycleState = str3;
    }

    public String getEventType() {
        return this.mEventType;
    }

    public String getLifecycleState() {
        return this.mLifecycleState;
    }
}
