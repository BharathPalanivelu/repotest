package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;

final class gd implements Parcelable.Creator<gc> {
    gd() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new gc[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new gc(parcel);
    }
}
