package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;

final class cf implements Parcelable.Creator<ce> {
    cf() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ce[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ce(parcel.readInt(), parcel.readInt());
    }
}
