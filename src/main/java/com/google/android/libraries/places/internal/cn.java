package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.api.model.TimeOfWeek;

final class cn implements Parcelable.Creator<cm> {
    cn() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new cm[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new cm((TimeOfWeek) parcel.readParcelable(TimeOfWeek.class.getClassLoader()), (TimeOfWeek) parcel.readParcelable(TimeOfWeek.class.getClassLoader()));
    }
}
