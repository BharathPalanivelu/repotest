package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.api.model.DayOfWeek;

public final class da implements Parcelable.Creator<DayOfWeek> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new DayOfWeek[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return DayOfWeek.a(parcel);
    }
}
