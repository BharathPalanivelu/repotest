package com.shopee.protocol.ads.action;

import com.squareup.wire.ProtoEnum;

public enum AdsAuditEvent implements ProtoEnum {
    ADS_EVENT_PAUSE(1),
    ADS_EVENT_RESUME(2),
    ADS_EVENT_START(3),
    ADS_EVENT_CREATE(4),
    ADS_EVENT_STOP(5),
    ADS_EVENT_RESTART(6),
    ADS_EVENT_CHANGE_SCHEDULE(7),
    ADS_EVENT_CHANGE_BUDGET(8),
    ADS_EVENT_SYSTEM_PAUSE(9),
    ADS_EVENT_SYSTEM_END(10);
    
    private final int value;

    private AdsAuditEvent(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
