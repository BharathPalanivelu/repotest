package com.shopee.protocol.ads.action;

import com.squareup.wire.ProtoEnum;

public enum CIRAuditEvent implements ProtoEnum {
    CIR_ADDITION(0),
    CIR_MODIFICATION(1),
    CIR_DELETION(2);
    
    private final int value;

    private CIRAuditEvent(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
