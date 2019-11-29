package com.salesforce.android.chat.core.internal.logging.event;

import com.google.a.a.c;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@BatchedEvent(groupId = "chatFileTransferEvents")
public class ChatFileTransferEvent extends BaseEvent {
    public static final String CANCELLED = "cancelled";
    public static final String COMPLETED = "completed";
    public static final String DOCUMENT = "document";
    public static final String FAILED = "failed";
    public static final String IMAGE = "image";
    public static final String INITIALIZED = "initialized";
    public static final String REQUESTED = "requested";
    public static final String UNKNOWN = "unknown";
    @c(a = "ftState")
    private final String mState;
    @c(a = "fileType")
    private final String mType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    public ChatFileTransferEvent(String str, String str2, String str3) {
        super(BaseEvent.SDK_CHAT, str);
        this.mState = str2;
        this.mType = parseMediaType(str3);
    }

    private String parseMediaType(String str) {
        if (str == null) {
            return "unknown";
        }
        return str.contains("image") ? "image" : DOCUMENT;
    }

    public String getState() {
        return this.mState;
    }

    public String getType() {
        return this.mType;
    }
}
