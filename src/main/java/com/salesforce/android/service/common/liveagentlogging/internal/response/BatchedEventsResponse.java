package com.salesforce.android.service.common.liveagentlogging.internal.response;

import com.google.a.a.c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class BatchedEventsResponse {
    private static final String TYPE_SUCCESS = "Success";
    @c(a = "messages")
    private List<Message> mMessages;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    BatchedEventsResponse(Message... messageArr) {
        this.mMessages = Arrays.asList(messageArr);
    }

    public List<Message> getMessages() {
        return this.mMessages;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%s: %s", new Object[]{getClass().getSimpleName(), this.mMessages.toString()});
    }

    public static class Message {
        @c(a = "message")
        private EventMessage mEventMessage;
        @c(a = "type")
        private String mResponseType;

        public Message(String str, String str2) {
            this.mEventMessage = new EventMessage(str);
            this.mResponseType = str2;
        }

        public Boolean isSuccess() {
            return Boolean.valueOf(this.mResponseType.equals("Success"));
        }

        public String getEventIdentifier() {
            return this.mEventMessage.getEventIdentifier();
        }

        public String toString() {
            return String.format(Locale.getDefault(), "%s {%s}", new Object[]{getEventIdentifier(), this.mResponseType.toUpperCase()});
        }
    }

    private static class EventMessage {
        @c(a = "eventType")
        private String mEventIdentifier;

        public EventMessage(String str) {
            this.mEventIdentifier = str;
        }

        public String getEventIdentifier() {
            return this.mEventIdentifier;
        }
    }
}
