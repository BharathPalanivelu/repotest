package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum OrderListType implements ProtoEnum {
    PAID(1),
    UNPAID(2),
    COMPLETED(3),
    CANCELLED(4),
    SHIPPED(5),
    ALL(6),
    TOSHIP(7),
    TORECEIVE(8),
    TOPAY(9),
    TOSHIP_UNPROCESSED(10),
    TOSHIP_PROCESSED(11),
    RETURN(12),
    GROUP_BUY_ALL(13),
    GROUP_BUY_ONGOING(14),
    GROUP_BUY_COMPLETED(15),
    GROUP_BUY_INVALID(16);
    
    private final int value;

    private OrderListType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
