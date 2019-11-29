package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.api.model.TypeFilter;

public final class dd implements Parcelable.Creator<TypeFilter> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new TypeFilter[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return TypeFilter.valueOf(parcel.readString());
    }
}
