package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import com.google.android.libraries.places.internal.cs;
import com.google.android.libraries.places.internal.go;
import com.google.android.libraries.places.internal.hk;

public abstract class PlaceLikelihood implements Parcelable {
    public static final double LIKELIHOOD_MAX_VALUE = 1.0d;
    public static final double LIKELIHOOD_MIN_VALUE = 0.0d;

    public abstract double getLikelihood();

    public abstract Place getPlace();

    public static PlaceLikelihood newInstance(Place place, double d2) {
        Double valueOf = Double.valueOf(0.0d);
        Double valueOf2 = Double.valueOf(1.0d);
        go.a(hk.a(valueOf, valueOf2).b(Double.valueOf(d2)), "Likelihood must not be out-of-range: %s to %s, but was: %s.", valueOf, valueOf2, Double.valueOf(d2));
        return new cs(place, d2);
    }
}
