package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;

final class bz implements Parcelable.Creator<by> {
    bz() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new by[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new by(parcel.readString(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readArrayList(String.class.getClassLoader()));
    }
}
