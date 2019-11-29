package com.tencent.imsdk.ext.sns;

import com.tencent.imcore.PendencyType;

public enum TIMPendencyGetType {
    TIM_PENDENCY_GET_COME_IN(1),
    TIM_PENDENCY_GET_SEND_OUT(2),
    TIM_PENDENCY_GET_BOTH(3);
    
    private int value;

    private TIMPendencyGetType(int i) {
        this.value = i;
    }

    static PendencyType getType(TIMPendencyGetType tIMPendencyGetType) {
        int i = bs.f31085a[tIMPendencyGetType.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? PendencyType.PendencyTypeBoth : PendencyType.PendencyTypeSendOut : PendencyType.PendencyTypeComeIn : PendencyType.PendencyTypeBoth;
    }

    static TIMPendencyGetType getType(PendencyType pendencyType) {
        return pendencyType == PendencyType.PendencyTypeBoth ? TIM_PENDENCY_GET_BOTH : pendencyType == PendencyType.PendencyTypeComeIn ? TIM_PENDENCY_GET_COME_IN : TIM_PENDENCY_GET_SEND_OUT;
    }

    public final int getValue() {
        return this.value;
    }
}
