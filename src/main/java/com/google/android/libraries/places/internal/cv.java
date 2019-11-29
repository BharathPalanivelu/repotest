package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;

final class cv implements Parcelable.Creator<cu> {
    cv() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new cu[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        String readString = parcel.readInt() == 0 ? parcel.readString() : null;
        if (parcel.readInt() == 0) {
            str = parcel.readString();
        }
        return new cu(readString, str);
    }
}
