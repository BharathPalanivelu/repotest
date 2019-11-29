package com.tencent.imsdk.ext.sns;

public enum TIMPageDirectionType {
    TIM_PAGE_DIRECTION_UP_TYPE(1),
    TIM_PAGE_DIRECTION_DOWN_TYPE(2);
    
    private int value;

    private TIMPageDirectionType(int i) {
        this.value = i;
    }

    static TIMPageDirectionType getType(int i) {
        return i != 1 ? i != 2 ? TIM_PAGE_DIRECTION_UP_TYPE : TIM_PAGE_DIRECTION_DOWN_TYPE : TIM_PAGE_DIRECTION_UP_TYPE;
    }

    public final int getValue() {
        return this.value;
    }
}
