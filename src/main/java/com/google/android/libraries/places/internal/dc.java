package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.api.model.Place;

public final class dc implements Parcelable.Creator<Place.Type> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new Place.Type[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return Place.Type.valueOf(parcel.readString());
    }
}
