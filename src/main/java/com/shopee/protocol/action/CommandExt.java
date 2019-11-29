package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum CommandExt implements ProtoEnum {
    CMD_APPLE_LOGIN(1);
    
    private final int value;

    private CommandExt(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
