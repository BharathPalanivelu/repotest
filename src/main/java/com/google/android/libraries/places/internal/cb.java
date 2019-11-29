package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.api.model.AddressComponent;

final class cb implements Parcelable.Creator<ca> {
    cb() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ca[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ca(parcel.readArrayList(AddressComponent.class.getClassLoader()));
    }
}
