package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum ReturnReason implements ProtoEnum {
    RETURN_REASON_NONE(0),
    RETURN_REASON_NONRECEIPT(1),
    RETURN_REASON_WRONG_ITEM(2),
    RETURN_REASON_ITEM_DAMAGED(3),
    RETURN_REASON_DIFF_DESC(4),
    RETURN_REASON_MUTUAL_AGREE(5),
    RETURN_REASON_OTHER(6),
    RETURN_REASON_ITEM_WRONGDAMAGED(101),
    RETURN_REASON_CHANGE_MIND(102),
    RETURN_REASON_ITEM_MISSING(103),
    RETURN_REASON_EXPECTATION_FAILED(104),
    RETURN_REASON_ITEM_FAKE(105),
    RETURN_REASON_PHYSICAL_DMG(106),
    RETURN_REASON_FUNCTIONAL_DMG(107);
    
    private final int value;

    private ReturnReason(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
