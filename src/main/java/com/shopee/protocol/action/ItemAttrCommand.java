package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum ItemAttrCommand implements ProtoEnum {
    CMD_ATTRIBUTE_SET(1),
    CMD_ATTRIBUTE_MODEL_SET(2),
    CMD_ATTRIBUTE_MODEL_INSTANCE_SET(3),
    CMD_GET_ATTRIBUTE_MODEL(4),
    CMD_MATCH_ATTRIBUTE(5),
    CMD_GET_MODELS_FOR_ATTR(6);
    
    private final int value;

    private ItemAttrCommand(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
