package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;

final class ci extends bi {
    public static final Parcelable.Creator<ci> CREATOR = new cj();

    ci(int i, int i2) {
        super(i, i2);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getHours());
        parcel.writeInt(getMinutes());
    }
}
