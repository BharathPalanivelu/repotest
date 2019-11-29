package com.shopee.react.sdk.bridge.protocol;

public class LocationData {
    private final int errorCode;
    private final double latitude;
    private final double longitude;
    private final int status;

    public LocationData(int i, int i2, double d2, double d3) {
        this.status = i;
        this.errorCode = i2;
        this.longitude = d2;
        this.latitude = d3;
    }

    public int getStatus() {
        return this.status;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }
}
