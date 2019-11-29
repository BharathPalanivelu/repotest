package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.api.model.Period;

final class cl implements Parcelable.Creator<ck> {
    cl() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ck[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ck(parcel.readArrayList(Period.class.getClassLoader()), parcel.readArrayList(String.class.getClassLoader()));
    }
}
