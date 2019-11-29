package com.salesforce.android.service.common.liveagentlogging.event;

import com.google.a.a.c;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@BatchedEvent(groupId = "connectivityEvents")
public class ConnectivityEvent extends BaseEvent {
    public static final String RADIO_TYPE_1xRTT = "1xRTT";
    public static final String RADIO_TYPE_CDMA = "CDMA";
    public static final String RADIO_TYPE_EDGE = "EDGE";
    public static final String RADIO_TYPE_EHRPD = "EHRPD";
    public static final String RADIO_TYPE_EVDO_0 = "EVDO_0";
    public static final String RADIO_TYPE_EVDO_A = "EVDO_A";
    public static final String RADIO_TYPE_EVDO_B = "EVDO_B";
    public static final String RADIO_TYPE_GPRS = "GPRS";
    public static final String RADIO_TYPE_HSDPA = "HSDPA";
    public static final String RADIO_TYPE_HSPA = "HSPA";
    public static final String RADIO_TYPE_HSPAP = "HSPAP";
    public static final String RADIO_TYPE_HSUPA = "HSUPA";
    public static final String RADIO_TYPE_IDEN = "IDEN";
    public static final String RADIO_TYPE_LTE = "LTE";
    public static final String RADIO_TYPE_UMTS = "UMTS";
    public static final String RADIO_TYPE_UNKNOWN = "UNKNOWN";
    public static final String TECHNOLOGY_RADIO = "RADIO";
    public static final String TECHNOLOGY_WIFI = "WIFI";
    @c(a = "radioType")
    private final String mRadioType;
    @c(a = "technology")
    private final String mTechnology;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RadioType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Technology {
    }

    public ConnectivityEvent(String str, String str2, String str3, String str4) {
        super(str, str2);
        this.mTechnology = str3;
        this.mRadioType = str4;
    }

    public String getTechnology() {
        return this.mTechnology;
    }

    public String getRadioType() {
        return this.mRadioType;
    }
}
