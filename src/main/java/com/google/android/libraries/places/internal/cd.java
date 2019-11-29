package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.Place;

final class cd implements Parcelable.Creator<cc> {
    cd() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new cc[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new cc(parcel.readString(), parcel.readArrayList(Place.Type.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readArrayList(AutocompletePrediction.a.class.getClassLoader()), parcel.readArrayList(AutocompletePrediction.a.class.getClassLoader()), parcel.readArrayList(AutocompletePrediction.a.class.getClassLoader()));
    }
}
