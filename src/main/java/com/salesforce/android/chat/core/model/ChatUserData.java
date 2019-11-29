package com.salesforce.android.chat.core.model;

import java.io.Serializable;
import java.util.Arrays;

public class ChatUserData implements Serializable {
    private final String mAgentLabel;
    private final boolean mIsDisplayedToAgent;
    private final String[] mTranscriptFieldNames;
    private Object mValue;

    public ChatUserData(String str) {
        this(str, true, new String[0]);
    }

    public ChatUserData(String str, boolean z, String... strArr) {
        this(str, (Object) null, z, strArr);
    }

    public ChatUserData(String str, Object obj, boolean z, String... strArr) {
        this.mAgentLabel = str;
        this.mValue = obj;
        this.mIsDisplayedToAgent = z;
        this.mTranscriptFieldNames = strArr;
    }

    public void setValue(Object obj) {
        this.mValue = obj;
    }

    public Object getValue() {
        return this.mValue;
    }

    public String getAgentLabel() {
        return this.mAgentLabel;
    }

    public boolean isDisplayedToAgent() {
        return this.mIsDisplayedToAgent;
    }

    public String[] getTranscriptFieldNames() {
        return this.mTranscriptFieldNames;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ChatUserData)) {
            ChatUserData chatUserData = (ChatUserData) obj;
            if (this.mAgentLabel.equals(chatUserData.mAgentLabel)) {
                Object obj2 = this.mValue;
                return ((obj2 != null && obj2.equals(chatUserData.mValue)) || (this.mValue == null && chatUserData.mValue == null)) && this.mIsDisplayedToAgent == chatUserData.mIsDisplayedToAgent && Arrays.equals(this.mTranscriptFieldNames, chatUserData.mTranscriptFieldNames);
            }
        }
    }
}
