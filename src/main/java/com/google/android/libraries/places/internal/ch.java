package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;

final class ch implements Parcelable.Creator<cg> {
    ch() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new cg[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new cg((ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader()));
    }
}
