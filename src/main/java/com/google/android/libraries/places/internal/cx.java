package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.LatLng;

final class cx implements Parcelable.Creator<cw> {
    cx() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new cw[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new cw((LatLng) parcel.readParcelable(LatLng.class.getClassLoader()), (LatLng) parcel.readParcelable(LatLng.class.getClassLoader()));
    }
}
