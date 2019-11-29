package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.api.model.DayOfWeek;
import com.google.android.libraries.places.api.model.LocalTime;

final class cz implements Parcelable.Creator<cy> {
    cz() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new cy[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new cy((DayOfWeek) parcel.readParcelable(DayOfWeek.class.getClassLoader()), (LocalTime) parcel.readParcelable(LocalTime.class.getClassLoader()));
    }
}
