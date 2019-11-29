package com.google.android.libraries.places.api.net;

import com.google.android.libraries.places.api.model.PlaceLikelihood;
import com.google.android.libraries.places.internal.dp;
import com.google.android.libraries.places.internal.ha;
import java.util.List;

public abstract class FindCurrentPlaceResponse {
    public abstract List<PlaceLikelihood> getPlaceLikelihoods();

    public static FindCurrentPlaceResponse newInstance(List<PlaceLikelihood> list) {
        return new dp(ha.a(list));
    }
}
