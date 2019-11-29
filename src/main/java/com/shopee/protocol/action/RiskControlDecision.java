package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum RiskControlDecision implements ProtoEnum {
    DECISION_APPROVED(1),
    DECISION_BLOCKED(2),
    DECISION_AUTH_REQUIRED(3);
    
    private final int value;

    private RiskControlDecision(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
