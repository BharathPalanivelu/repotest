package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;

public final class cg extends bh {
    public static final Parcelable.Creator<cg> CREATOR = new ch();

    public cg(ParcelUuid parcelUuid) {
        super(parcelUuid);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(a(), i);
    }
}
