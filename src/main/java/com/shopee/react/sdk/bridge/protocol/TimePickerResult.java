package com.shopee.react.sdk.bridge.protocol;

public class TimePickerResult {
    private boolean isCancelled;
    private long time;

    public void setTimestamp(long j) {
        this.time = j / 1000;
    }

    public void setCancelled(boolean z) {
        this.isCancelled = z;
    }
}
