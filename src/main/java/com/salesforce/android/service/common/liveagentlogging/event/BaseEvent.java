package com.salesforce.android.service.common.liveagentlogging.event;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;

public abstract class BaseEvent {
    public static final String SDK_CASE = "case";
    public static final String SDK_CHAT = "chat";
    public static final String SDK_KNOWLEDGE = "KB";
    public static final String SDK_SOS = "sos";
    private static final transient String UNKNOWN_ORG_ID = "00D000000000000";
    private final transient String mCorrelationId;
    private transient String mOrganizationId = UNKNOWN_ORG_ID;
    private final transient String mSdk;
    private final transient Date mTimestamp = new Date();
    private transient String mUniqueId;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SDK {
    }

    public BaseEvent(String str, String str2) {
        this.mSdk = str;
        this.mCorrelationId = str2;
    }

    public Date getTimestamp() {
        return this.mTimestamp;
    }

    public String getSdk() {
        return this.mSdk;
    }

    public String getCorrelationId() {
        return this.mCorrelationId;
    }

    public String getOrganizationId() {
        return this.mOrganizationId;
    }

    public void setOrganizationId(String str) {
        this.mOrganizationId = str;
    }

    public String getUniqueId() {
        return this.mUniqueId;
    }

    public void setUniqueId(String str) {
        this.mUniqueId = str;
    }
}
