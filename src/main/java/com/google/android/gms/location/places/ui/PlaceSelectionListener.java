package com.google.android.gms.location.places.ui;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;

@Deprecated
public interface PlaceSelectionListener {
    void onError(Status status);

    void onPlaceSelected(Place place);
}
