package com.shopee.protocol.pcenter;

import com.squareup.wire.ProtoEnum;

public enum PricingTaskStatus implements ProtoEnum {
    TASK_DELETED(0),
    TASK_WAITING(1),
    TASK_PROCESSING(2),
    TASK_FINISHED(3),
    TASK_FAILED(4);
    
    private final int value;

    private PricingTaskStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
