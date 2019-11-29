package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;

final class cj implements Parcelable.Creator<ci> {
    cj() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ci[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ci(parcel.readInt(), parcel.readInt());
    }
}
