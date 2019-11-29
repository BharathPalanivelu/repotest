package com.shopee.react.sdk.bridge.protocol;

public class LocationRequestParams {
    private final boolean noPopUp;

    public LocationRequestParams(boolean z) {
        this.noPopUp = z;
    }

    public boolean isNoPopUp() {
        return this.noPopUp;
    }
}
