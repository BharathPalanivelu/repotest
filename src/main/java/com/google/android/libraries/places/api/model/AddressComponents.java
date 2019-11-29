package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import com.google.android.libraries.places.internal.ca;
import java.util.List;

public abstract class AddressComponents implements Parcelable {
    public abstract List<AddressComponent> asList();

    public static AddressComponents newInstance(List<AddressComponent> list) {
        return new ca(list);
    }
}
