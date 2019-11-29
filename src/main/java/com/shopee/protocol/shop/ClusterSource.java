package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum ClusterSource implements ProtoEnum {
    CLUSTER_SOURCE_UNIDENTIFIED(0),
    CLUSTER_SOURCE_DEEP(1),
    CLUSTER_SOURCE_DATA_SCIENCE(2);
    
    private final int value;

    private ClusterSource(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
