package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;

final class ff implements Parcelable.Creator<fe> {
    ff() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new fe[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return fe.a(parcel);
    }
}
