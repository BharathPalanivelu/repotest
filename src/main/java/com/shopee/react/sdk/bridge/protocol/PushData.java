package com.shopee.react.sdk.bridge.protocol;

public class PushData {
    private int popCount = 0;
    private String propsString;

    public PushData() {
    }

    public PushData(String str) {
        this.propsString = str;
    }

    public String getPropsString() {
        return this.propsString;
    }

    public int getPopCount() {
        return this.popCount;
    }
}
