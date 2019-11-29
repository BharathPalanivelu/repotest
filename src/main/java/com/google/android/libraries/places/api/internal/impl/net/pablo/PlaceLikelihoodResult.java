package com.google.android.libraries.places.api.internal.impl.net.pablo;

import com.google.a.a.c;

final class PlaceLikelihoodResult {
    public Double likelihood;
    @c(a = "place")
    public PlaceResult placeResult;

    PlaceLikelihoodResult() {
    }

    public final Double getLikelihood() {
        return this.likelihood;
    }

    public final PlaceResult getPlaceResult() {
        return this.placeResult;
    }
}
