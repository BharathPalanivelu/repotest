package com.shopee.app.react.protocol;

public class DatePickerResult {
    private long date;
    private boolean isCancelled;

    public void setTimestamp(long j) {
        this.date = j / 1000;
    }

    public void setCancelled(boolean z) {
        this.isCancelled = z;
    }
}
