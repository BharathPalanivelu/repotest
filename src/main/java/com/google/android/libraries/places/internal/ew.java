package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.internal.eu;

final class ew implements Parcelable.Creator<eu.a> {
    ew() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new eu.a[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return eu.a.valueOf(parcel.readString());
    }
}
