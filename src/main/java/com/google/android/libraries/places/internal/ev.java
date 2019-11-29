package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.internal.eu;

final class ev implements Parcelable.Creator<eu> {
    ev() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new eu[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new eu((eu.a) parcel.readParcelable(eu.a.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
    }
}
