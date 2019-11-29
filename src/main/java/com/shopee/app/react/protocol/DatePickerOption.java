package com.shopee.app.react.protocol;

@Deprecated
public class DatePickerOption {
    public static final int TYPE_DATE = 0;
    public static final int TYPE_TIME = 1;
    private long date;
    private boolean hideDay = false;
    private long maxDate = -1;
    private long minDate = -1;
    private int minuteInterval = 1;
    private boolean timeIs24Hour = false;
    private int type = 0;

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

    public int getType() {
        return this.type;
    }

    public int getMinuteInterval() {
        return this.minuteInterval;
    }

    public boolean isTimeIs24Hour() {
        return this.timeIs24Hour;
    }
}
