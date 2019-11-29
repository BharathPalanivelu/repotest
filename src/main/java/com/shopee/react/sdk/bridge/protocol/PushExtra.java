package com.shopee.react.sdk.bridge.protocol;

public class PushExtra {
    private int popCount;
    private int type;

    public int getPopCount() {
        return this.popCount;
    }

    public int getEnterType() {
        return this.type;
    }

    public void setPopCount(int i) {
        this.popCount = i;
    }

    public void setEnterType(int i) {
        this.type = i;
    }
}
