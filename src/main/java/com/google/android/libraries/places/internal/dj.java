package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;

public final class dj extends FetchPlaceResponse {

    /* renamed from: a  reason: collision with root package name */
    private final Place f12449a;

    public dj(Place place) {
        if (place != null) {
            this.f12449a = place;
            return;
        }
        throw new NullPointerException("Null place");
    }

    public final Place getPlace() {
        return this.f12449a;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f12449a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 26);
        sb.append("FetchPlaceResponse{place=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FetchPlaceResponse) {
            return this.f12449a.equals(((FetchPlaceResponse) obj).getPlace());
        }
        return false;
    }

    public final int hashCode() {
        return this.f12449a.hashCode() ^ 1000003;
    }
}
