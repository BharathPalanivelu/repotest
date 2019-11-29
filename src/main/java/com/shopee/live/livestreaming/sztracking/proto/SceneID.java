package com.shopee.live.livestreaming.sztracking.proto;

import com.squareup.wire.ProtoEnum;

public enum SceneID implements ProtoEnum {
    LiveStreaming(1);
    
    private final int value;

    private SceneID(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
