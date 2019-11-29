package com.salesforce.android.chat.ui.internal.chatfeed.model;

import com.salesforce.android.service.common.ui.internal.messaging.MultiActorMessage;
import java.util.Date;

public class ReceivedMessage implements MultiActorMessage {
    private final String mAgentId;
    private final String mAgentName;
    private final String mMessageText;
    private final Date mTimestamp;

    public ReceivedMessage(String str, String str2, String str3, Date date) {
        this.mAgentId = str;
        this.mAgentName = str2;
        this.mMessageText = str3;
        this.mTimestamp = date;
    }

    public String getId() {
        return this.mAgentId;
    }

    public String getAgentName() {
        return this.mAgentName;
    }

    public String getMessageText() {
        return this.mMessageText;
    }

    public Date getTimestamp() {
        return this.mTimestamp;
    }
}
