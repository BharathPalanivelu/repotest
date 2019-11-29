package com.shopee.live.livestreaming.sztracking.proto;

import com.squareup.wire.ProtoEnum;

public enum GeneralAction implements ProtoEnum {
    ACTION_ENTER_ROOM(0),
    ACTION_LEAVE_ROOM(1),
    ACTION_START_STREAM(2),
    ACTION_CONNECTED_STREAM(3),
    ACTION_DISCONNECTED_ACTIVE(4),
    ACTION_DISCONNECTED_PASSIVE(5);
    
    private final int value;

    private GeneralAction(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
