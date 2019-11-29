package com.google.android.libraries.places.api.model;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.libraries.places.internal.bw;

public abstract class RectangularBounds implements LocationBias, LocationRestriction {

    public static abstract class a {
        public abstract a a(LatLng latLng);

        public abstract RectangularBounds a();

        public abstract a b(LatLng latLng);
    }

    public abstract LatLng getNortheast();

    public abstract LatLng getSouthwest();

    public static RectangularBounds newInstance(LatLngBounds latLngBounds) {
        return new bw().a(latLngBounds.southwest).b(latLngBounds.northeast).a();
    }

    public static RectangularBounds newInstance(LatLng latLng, LatLng latLng2) {
        return newInstance(new LatLngBounds(latLng, latLng2));
    }
}
