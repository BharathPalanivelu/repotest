package com.shopee.react.sdk.bridge.protocol;

import com.litesuits.orm.db.assit.SQLBuilder;

public final class TimePickerOption {
    private final long initialTime;
    private final int minuteInterval;
    private final int timeFormat;

    public static /* synthetic */ TimePickerOption copy$default(TimePickerOption timePickerOption, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j = timePickerOption.initialTime;
        }
        if ((i3 & 2) != 0) {
            i = timePickerOption.minuteInterval;
        }
        if ((i3 & 4) != 0) {
            i2 = timePickerOption.timeFormat;
        }
        return timePickerOption.copy(j, i, i2);
    }

    public final long component1() {
        return this.initialTime;
    }

    public final int component2() {
        return this.minuteInterval;
    }

    public final int component3() {
        return this.timeFormat;
    }

    public final TimePickerOption copy(long j, int i, int i2) {
        return new TimePickerOption(j, i, i2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof TimePickerOption) {
                TimePickerOption timePickerOption = (TimePickerOption) obj;
                if (this.initialTime == timePickerOption.initialTime) {
                    if (this.minuteInterval == timePickerOption.minuteInterval) {
                        if (this.timeFormat == timePickerOption.timeFormat) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.initialTime;
        return (((((int) (j ^ (j >>> 32))) * 31) + this.minuteInterval) * 31) + this.timeFormat;
    }

    public String toString() {
        return "TimePickerOption(initialTime=" + this.initialTime + ", minuteInterval=" + this.minuteInterval + ", timeFormat=" + this.timeFormat + SQLBuilder.PARENTHESES_RIGHT;
    }

    public TimePickerOption(long j, int i, int i2) {
        this.initialTime = j;
        this.minuteInterval = i;
        this.timeFormat = i2;
    }

    public final long getInitialTime() {
        return this.initialTime;
    }

    public final int getMinuteInterval() {
        return this.minuteInterval;
    }

    public final int getTimeFormat() {
        return this.timeFormat;
    }

    public final long getTimestamp() {
        return this.initialTime * 1000;
    }
}
