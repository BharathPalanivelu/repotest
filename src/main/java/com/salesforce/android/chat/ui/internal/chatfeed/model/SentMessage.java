package com.salesforce.android.chat.ui.internal.chatfeed.model;

import com.salesforce.android.service.common.ui.internal.messaging.MultiActorMessage;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;

public class SentMessage implements MultiActorMessage {
    public static final int DELIVERY_FAILED = 2;
    public static final int DELIVERY_IN_PROGRESS = 0;
    public static final int DELIVERY_MODIFIED = 3;
    public static final int DELIVERY_NOT_SENT_PRIVACY = 4;
    public static final int DELIVERY_SUCCESS = 1;
    private int mDeliveryState = 0;
    private CharSequence mMessageText;
    private final Date mTimestamp;
    private final String mVisitorId;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DeliveryState {
    }

    public SentMessage(String str, CharSequence charSequence, Date date) {
        this.mVisitorId = str;
        this.mMessageText = charSequence;
        this.mTimestamp = date;
    }

    public String getId() {
        return this.mVisitorId;
    }

    public Date getTimestamp() {
        return this.mTimestamp;
    }

    public CharSequence getMessageText() {
        return this.mMessageText;
    }

    public void setMessageText(CharSequence charSequence) {
        this.mMessageText = charSequence;
    }

    public int getDeliveryState() {
        return this.mDeliveryState;
    }

    public void setDeliveryState(int i) {
        this.mDeliveryState = i;
    }
}
