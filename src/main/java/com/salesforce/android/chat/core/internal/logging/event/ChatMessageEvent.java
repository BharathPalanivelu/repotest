package com.salesforce.android.chat.core.internal.logging.event;

import com.google.a.a.c;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@BatchedEvent(groupId = "chatMessageEvents")
public class ChatMessageEvent extends BaseEvent {
    public static final String SENDER_AGENT = "agent";
    public static final String SENDER_CUSTOMER = "customer";
    @c(a = "sender")
    private final String mSender;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Sender {
    }

    public ChatMessageEvent(String str, String str2) {
        super(BaseEvent.SDK_CHAT, str);
        this.mSender = str2;
    }

    public String getSender() {
        return this.mSender;
    }
}
