package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.api.model.Place;

final class ct implements Parcelable.Creator<cs> {
    ct() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new cs[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new cs((Place) parcel.readParcelable(Place.class.getClassLoader()), parcel.readDouble());
    }
}
