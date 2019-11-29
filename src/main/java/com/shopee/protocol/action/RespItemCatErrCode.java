package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum RespItemCatErrCode implements ProtoEnum {
    RESP_ITEM_CAT_ERR_OK(0),
    RESP_ITEM_CAT_ERR_UNKNOWN(1),
    RESP_ITEM_CAT_ERR_NOT_LEAF_NODE(2),
    RESP_ITEM_CAT_ERR_INVALID_STATUS(3),
    RESP_ITEM_CAT_ERR_NOT_FOUND(4),
    RESP_ITEM_CAT_ERR_EMPTY_PATH(5);
    
    private final int value;

    private RespItemCatErrCode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
