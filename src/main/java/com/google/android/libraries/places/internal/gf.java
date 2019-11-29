package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

public final class gf implements Parcelable.Creator<AutocompleteActivityMode> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new AutocompleteActivityMode[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return AutocompleteActivityMode.valueOf(parcel.readString());
    }
}
