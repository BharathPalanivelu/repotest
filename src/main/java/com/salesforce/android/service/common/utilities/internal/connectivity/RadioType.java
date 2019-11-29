package com.salesforce.android.service.common.utilities.internal.connectivity;

import com.salesforce.android.service.common.liveagentlogging.event.ConnectivityEvent;

public enum RadioType {
    RTT(7, ConnectivityEvent.RADIO_TYPE_1xRTT, false),
    CDMA(4, ConnectivityEvent.RADIO_TYPE_CDMA, false),
    EDGE(2, ConnectivityEvent.RADIO_TYPE_EDGE, false),
    EHRPD(14, ConnectivityEvent.RADIO_TYPE_EHRPD, false),
    EVDO_0(5, ConnectivityEvent.RADIO_TYPE_EVDO_0, true),
    EVDO_A(6, ConnectivityEvent.RADIO_TYPE_EVDO_A, true),
    EVDO_B(12, ConnectivityEvent.RADIO_TYPE_EVDO_B, true),
    GPRS(1, ConnectivityEvent.RADIO_TYPE_GPRS, false),
    HSDPA(8, ConnectivityEvent.RADIO_TYPE_HSDPA, true),
    HSPA(10, ConnectivityEvent.RADIO_TYPE_HSPA, true),
    HSPAP(15, ConnectivityEvent.RADIO_TYPE_HSPAP, true),
    HSUPA(9, ConnectivityEvent.RADIO_TYPE_HSUPA, true),
    IDEN(11, ConnectivityEvent.RADIO_TYPE_IDEN, false),
    LTE(13, ConnectivityEvent.RADIO_TYPE_LTE, true),
    UMTS(3, ConnectivityEvent.RADIO_TYPE_UMTS, true),
    UNKNOWN(0, "UNKNOWN", false);
    
    private final boolean mIsFastConnection;
    private final String mRadioName;
    private final int mType;

    private RadioType(int i, String str, boolean z) {
        this.mType = i;
        this.mRadioName = str;
        this.mIsFastConnection = z;
    }

    public int getType() {
        return this.mType;
    }

    public String getRadioName() {
        return this.mRadioName;
    }

    public boolean isFastConnection() {
        return this.mIsFastConnection;
    }

    static RadioType fromType(int i) {
        for (RadioType radioType : values()) {
            if (radioType.mType == i) {
                return radioType;
            }
        }
        return UNKNOWN;
    }
}
