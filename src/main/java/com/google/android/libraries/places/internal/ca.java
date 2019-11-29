package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.api.model.AddressComponent;
import java.util.List;

public final class ca extends bc {
    public static final Parcelable.Creator<ca> CREATOR = new cb();

    public ca(List<AddressComponent> list) {
        super(list);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(asList());
    }
}
