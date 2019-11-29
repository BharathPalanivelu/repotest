package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum NotiMethod implements ProtoEnum {
    NM_ALL(1),
    NM_AR(2),
    NM_ACTIVITY(4),
    NM_EMAIL(8),
    NM_SMS(16),
    NM_PUSH(32),
    NM_WEB_PUSH(64),
    NM_INAPP(128);
    
    private final int value;

    private NotiMethod(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
