package com.shopee.protocol.ads.action;

import com.squareup.wire.ProtoEnum;

public enum ReportEventType implements ProtoEnum {
    EVT_SEARCH(1),
    EVT_IMPRESSION(2),
    EVT_CLICK(3),
    EVT_BID(4),
    EVT_SALE(5),
    EVT_BROAD_IMPRESSION(6),
    EVT_BROAD_CLICK(7),
    EVT_BROAD_SALE(8),
    EVT_FLUSH(98),
    EVT_RESTART(99);
    
    private final int value;

    private ReportEventType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
