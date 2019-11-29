package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;

final class co extends bo {
    public static final Parcelable.Creator<co> CREATOR = new cp();

    co(String str, int i, int i2, String str2) {
        super(str, i, i2, str2);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getAttributions());
        parcel.writeInt(getHeight());
        parcel.writeInt(getWidth());
        parcel.writeString(a());
    }
}
