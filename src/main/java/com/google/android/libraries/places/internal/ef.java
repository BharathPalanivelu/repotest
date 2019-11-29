package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;

final class ef implements Parcelable.Creator<ee> {
    ef() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ee[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return ee.valueOf(parcel.readString());
    }
}
