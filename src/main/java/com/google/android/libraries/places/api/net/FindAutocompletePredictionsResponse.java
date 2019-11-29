package com.google.android.libraries.places.api.net;

import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.internal.dm;
import com.google.android.libraries.places.internal.ha;
import java.util.List;

public abstract class FindAutocompletePredictionsResponse {
    public abstract List<AutocompletePrediction> getAutocompletePredictions();

    public static FindAutocompletePredictionsResponse newInstance(List<AutocompletePrediction> list) {
        return new dm(ha.a(list));
    }
}
