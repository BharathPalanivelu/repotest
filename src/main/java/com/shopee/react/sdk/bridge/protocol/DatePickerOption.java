package com.shopee.react.sdk.bridge.protocol;

public class DatePickerOption {
    private long date;
    private boolean hideDay = false;
    private long maxDate = -1;
    private long minDate = -1;

    public long getTimestamp() {
        return this.date * 1000;
    }

    public long getMinDate() {
        return this.minDate * 1000;
    }

    public long getMaxDate() {
        return this.maxDate * 1000;
    }

    public boolean isHideDay() {
        return this.hideDay;
    }
}
