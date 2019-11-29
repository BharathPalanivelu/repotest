package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.api.model.Place;

public final class db implements Parcelable.Creator<Place.Field> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new Place.Field[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return Place.Field.valueOf(parcel.readString());
    }
}
