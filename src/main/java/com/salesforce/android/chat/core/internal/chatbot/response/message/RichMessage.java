package com.salesforce.android.chat.core.internal.chatbot.response.message;

public class RichMessage {
    public static final String TYPE = "RichMessage";
    private Object mContent;
    private String mTypeIdentifier;

    public RichMessage(String str, Object obj) {
        this.mContent = obj;
        this.mTypeIdentifier = str;
    }

    public String getTypeIdentifier() {
        return this.mTypeIdentifier;
    }

    public <T> T getContent(Class<T> cls) {
        return cls.cast(this.mContent);
    }
}
