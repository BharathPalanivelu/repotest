package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import com.google.android.libraries.places.internal.cy;

public abstract class TimeOfWeek implements Parcelable {
    public abstract DayOfWeek getDay();

    public abstract LocalTime getTime();

    public static TimeOfWeek newInstance(DayOfWeek dayOfWeek, LocalTime localTime) {
        return new cy(dayOfWeek, localTime);
    }
}
