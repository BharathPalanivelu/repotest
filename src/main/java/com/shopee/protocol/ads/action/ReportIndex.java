package com.shopee.protocol.ads.action;

import com.squareup.wire.ProtoEnum;

public enum ReportIndex implements ProtoEnum {
    REPORT_CURR_AGGREGATE(0),
    REPORT_DETAIL(1),
    REPORT_OLD_AGGREGATE(2);
    
    private final int value;

    private ReportIndex(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
