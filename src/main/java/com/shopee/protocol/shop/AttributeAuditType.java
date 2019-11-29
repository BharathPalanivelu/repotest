package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum AttributeAuditType implements ProtoEnum {
    AUDIT_ATTRIBUTE(1),
    AUDIT_MODEL(2),
    AUDIT_INSTANCE(3);
    
    private final int value;

    private AttributeAuditType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
