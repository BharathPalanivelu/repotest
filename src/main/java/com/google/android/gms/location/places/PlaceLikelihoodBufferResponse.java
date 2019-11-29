package com.google.android.gms.location.places;

import com.google.android.gms.common.api.DataBufferResponse;
import com.google.android.gms.common.internal.ShowFirstParty;

@Deprecated
public class PlaceLikelihoodBufferResponse extends DataBufferResponse<PlaceLikelihood, PlaceLikelihoodBuffer> {
    PlaceLikelihoodBufferResponse() {
    }

    public CharSequence getAttributions() {
        return ((PlaceLikelihoodBuffer) getResult()).getAttributions();
    }

    @ShowFirstParty
    public String toString() {
        return ((PlaceLikelihoodBuffer) getResult()).toString();
    }
}
