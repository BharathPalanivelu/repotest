package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import java.util.List;

public final class dm extends FindAutocompletePredictionsResponse {

    /* renamed from: a  reason: collision with root package name */
    private final List<AutocompletePrediction> f12464a;

    public dm(List<AutocompletePrediction> list) {
        if (list != null) {
            this.f12464a = list;
            return;
        }
        throw new NullPointerException("Null autocompletePredictions");
    }

    public final List<AutocompletePrediction> getAutocompletePredictions() {
        return this.f12464a;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f12464a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 61);
        sb.append("FindAutocompletePredictionsResponse{autocompletePredictions=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FindAutocompletePredictionsResponse) {
            return this.f12464a.equals(((FindAutocompletePredictionsResponse) obj).getAutocompletePredictions());
        }
        return false;
    }

    public final int hashCode() {
        return this.f12464a.hashCode() ^ 1000003;
    }
}
