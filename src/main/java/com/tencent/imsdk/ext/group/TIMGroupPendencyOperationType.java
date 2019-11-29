package com.tencent.imsdk.ext.group;

public enum TIMGroupPendencyOperationType {
    REFUSE(0),
    ACCEPT(1);
    
    private int value;

    private TIMGroupPendencyOperationType(int i) {
        this.value = 1;
        this.value = i;
    }

    /* access modifiers changed from: package-private */
    public final int getValue() {
        return this.value;
    }
}
