package com.shopee.react.sdk.bridge.protocol;

public class NetworkInfo {
    private final String cellularType;
    private final int networkType;

    public NetworkInfo(int i, String str) {
        this.networkType = i;
        this.cellularType = str;
    }

    public int getNetworkType() {
        return this.networkType;
    }

    public String getCellularType() {
        return this.cellularType;
    }
}
