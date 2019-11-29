package com.google.android.libraries.places.api.model;

import android.os.ParcelUuid;
import android.os.Parcelable;
import com.google.android.libraries.places.internal.cg;
import java.util.UUID;

public abstract class AutocompleteSessionToken implements Parcelable {
    public abstract ParcelUuid a();

    public static AutocompleteSessionToken newInstance() {
        return new cg(new ParcelUuid(UUID.randomUUID()));
    }

    public final String toString() {
        return a().toString();
    }
}
