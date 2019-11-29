package com.salesforce.android.service.common.liveagentlogging.event;

import com.google.a.a.c;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@BatchedEvent(groupId = "errorEvents")
public class ErrorEvent extends BaseEvent {
    public static final String OPENTOK_DOMAIN_PUBLISHER = "publisher";
    public static final String OPENTOK_DOMAIN_SESSION = "session";
    public static final String OPENTOK_DOMAIN_SUBSCRIBER = "subscriber";
    public static final int SEVERITY_ERROR = 1;
    public static final int SEVERITY_FATAL = 0;
    public static final int SEVERITY_WARNING = 2;
    public static final String TYPE_OPENTOK = "opentok";
    @c(a = "description")
    private final String mDescription;
    @c(a = "domain")
    private final String mOpenTokDomain;
    @c(a = "code")
    private final String mOpenTokErrorCode;
    @c(a = "severity")
    private final Integer mSeverity;
    @c(a = "stackTrace")
    private final String mStackTrace;
    @c(a = "type")
    private final String mType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface OpenTokDomain {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Severity {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    public ErrorEvent(String str, String str2, String str3, Integer num) {
        this(str, str2, str3, num, (String) null, (String) null, (String) null, (String) null);
    }

    public ErrorEvent(String str, String str2, String str3, Integer num, String str4) {
        this(str, str2, str3, num, str4, (String) null, (String) null, (String) null);
    }

    public ErrorEvent(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7) {
        super(str, str2);
        String str8;
        this.mDescription = str3;
        this.mSeverity = num;
        if (str4 == null) {
            str8 = null;
        } else {
            str8 = str4.replaceAll("\n", "\r");
        }
        this.mStackTrace = str8;
        this.mType = str5;
        this.mOpenTokDomain = str6;
        this.mOpenTokErrorCode = str7;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public Integer getSeverity() {
        return this.mSeverity;
    }

    public String getStackTrace() {
        return this.mStackTrace;
    }

    public String getType() {
        return this.mType;
    }

    public String getOpenTokDomain() {
        return this.mOpenTokDomain;
    }

    public String getOpenTokErrorCode() {
        return this.mOpenTokErrorCode;
    }
}
