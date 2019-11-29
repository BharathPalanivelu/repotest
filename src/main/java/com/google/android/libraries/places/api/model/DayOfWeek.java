package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.internal.da;

public enum DayOfWeek implements Parcelable {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;
    
    public static final Parcelable.Creator<DayOfWeek> CREATOR = null;

    public final int describeContents() {
        return 0;
    }

    public static DayOfWeek a(Parcel parcel) {
        return valueOf(parcel.readString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name());
    }

    static {
        CREATOR = new da();
    }
}
