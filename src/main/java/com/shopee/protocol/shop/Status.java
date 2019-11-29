package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum Status implements ProtoEnum {
    TASK_WAIT(0),
    TASK_PROCESSING(1),
    TASK_SUCCESSED(2),
    TASK_FAILED(3),
    TASK_TERMINATED(4);
    
    private final int value;

    private Status(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
