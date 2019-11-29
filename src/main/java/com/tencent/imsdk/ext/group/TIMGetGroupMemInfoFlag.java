package com.tencent.imsdk.ext.group;

public enum TIMGetGroupMemInfoFlag {
    TIM_GET_GROUP_MEM_INFO_FLAG_JOIN_TIME(1),
    TIM_GET_GROUP_MEM_INFO_FLAG_MSG_FLAG(2),
    TIM_GET_GROUP_MEM_INFO_FLAG_ROLE_INFO(8),
    TIM_GET_GROUP_MEM_INFO_FLAG_SHUTUP_TIME(16);
    
    private long value;

    private TIMGetGroupMemInfoFlag(long j) {
        this.value = j;
    }

    /* access modifiers changed from: package-private */
    public final long getValue() {
        return this.value;
    }
}
