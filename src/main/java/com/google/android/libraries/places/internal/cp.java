package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;

final class cp implements Parcelable.Creator<co> {
    cp() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new co[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new co(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString());
    }
}
