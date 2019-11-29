package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import java.util.List;

final class dn extends FindCurrentPlaceRequest {

    /* renamed from: a  reason: collision with root package name */
    private final List<Place.Field> f12465a;

    /* renamed from: b  reason: collision with root package name */
    private final CancellationToken f12466b;

    dn(List<Place.Field> list, CancellationToken cancellationToken) {
        this.f12465a = list;
        this.f12466b = cancellationToken;
    }

    public final List<Place.Field> getPlaceFields() {
        return this.f12465a;
    }

    public final CancellationToken getCancellationToken() {
        return this.f12466b;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f12465a);
        String valueOf2 = String.valueOf(this.f12466b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 57 + String.valueOf(valueOf2).length());
        sb.append("FindCurrentPlaceRequest{placeFields=");
        sb.append(valueOf);
        sb.append(", cancellationToken=");
        sb.append(valueOf2);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FindCurrentPlaceRequest) {
            FindCurrentPlaceRequest findCurrentPlaceRequest = (FindCurrentPlaceRequest) obj;
            if (this.f12465a.equals(findCurrentPlaceRequest.getPlaceFields())) {
                CancellationToken cancellationToken = this.f12466b;
                return cancellationToken != null ? cancellationToken.equals(findCurrentPlaceRequest.getCancellationToken()) : findCurrentPlaceRequest.getCancellationToken() == null;
            }
        }
    }

    public final int hashCode() {
        int hashCode = (this.f12465a.hashCode() ^ 1000003) * 1000003;
        CancellationToken cancellationToken = this.f12466b;
        return hashCode ^ (cancellationToken == null ? 0 : cancellationToken.hashCode());
    }
}
