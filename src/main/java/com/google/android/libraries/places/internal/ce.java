package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;

final class ce extends bf {
    public static final Parcelable.Creator<ce> CREATOR = new cf();

    ce(int i, int i2) {
        super(i, i2);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(a());
        parcel.writeInt(b());
    }
}
