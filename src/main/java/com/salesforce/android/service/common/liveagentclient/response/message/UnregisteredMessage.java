package com.salesforce.android.service.common.liveagentclient.response.message;

import com.google.a.l;
import java.util.Locale;

public class UnregisteredMessage extends LiveAgentMessage {
    public static final String TYPE = "UNKNOWN";
    private final String mUnregisteredTypeIdentifier;

    public UnregisteredMessage(String str, l lVar) {
        super("UNKNOWN", lVar);
        this.mUnregisteredTypeIdentifier = str;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Unregistered Live Agent Message. Type[%s] - Content[%s]", new Object[]{this.mUnregisteredTypeIdentifier, getContent(l.class)});
    }
}
