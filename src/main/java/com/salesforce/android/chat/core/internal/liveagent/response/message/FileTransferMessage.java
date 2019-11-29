package com.salesforce.android.chat.core.internal.liveagent.response.message;

import com.google.a.a.c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class FileTransferMessage {
    public static final String EVENT_TYPE_CANCELLED = "Canceled";
    public static final String EVENT_TYPE_FAILURE = "Failure";
    public static final String EVENT_TYPE_REQUESTED = "Requested";
    public static final String EVENT_TYPE_SUCCESS = "Success";
    public static final String TYPE = "FileTransfer";
    @c(a = "cdmServletUrl")
    private String mCdmUrl;
    @c(a = "type")
    private String mEventType;
    @c(a = "fileToken")
    private String mFileToken;
    @c(a = "uploadServletUrl")
    private String mUploadUrl;

    @Retention(RetentionPolicy.SOURCE)
    public @interface EventType {
    }

    public FileTransferMessage(String str, String str2, String str3) {
        this.mEventType = str;
        this.mUploadUrl = str2;
        this.mFileToken = str3;
    }

    public String getEventType() {
        return this.mEventType;
    }

    public String getUploadUrl() {
        return this.mUploadUrl;
    }

    public String getCdmUrl() {
        return this.mCdmUrl;
    }

    public String getFileToken() {
        return this.mFileToken;
    }
}
