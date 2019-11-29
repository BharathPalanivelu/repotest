package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.PlaceLikelihood;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import java.util.List;

public final class dp extends FindCurrentPlaceResponse {

    /* renamed from: a  reason: collision with root package name */
    private final List<PlaceLikelihood> f12469a;

    public dp(List<PlaceLikelihood> list) {
        if (list != null) {
            this.f12469a = list;
            return;
        }
        throw new NullPointerException("Null placeLikelihoods");
    }

    public final List<PlaceLikelihood> getPlaceLikelihoods() {
        return this.f12469a;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f12469a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 43);
        sb.append("FindCurrentPlaceResponse{placeLikelihoods=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FindCurrentPlaceResponse) {
            return this.f12469a.equals(((FindCurrentPlaceResponse) obj).getPlaceLikelihoods());
        }
        return false;
    }

    public final int hashCode() {
        return this.f12469a.hashCode() ^ 1000003;
    }
}
