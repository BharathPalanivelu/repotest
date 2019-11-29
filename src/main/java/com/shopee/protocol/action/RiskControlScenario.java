package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum RiskControlScenario implements ProtoEnum {
    CHANGE_PHONE_NUMBER(1);
    
    private final int value;

    private RiskControlScenario(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
