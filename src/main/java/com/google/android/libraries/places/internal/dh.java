package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import java.util.List;

final class dh extends FetchPlaceRequest {

    /* renamed from: a  reason: collision with root package name */
    private final String f12441a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Place.Field> f12442b;

    /* renamed from: c  reason: collision with root package name */
    private final AutocompleteSessionToken f12443c;

    /* renamed from: d  reason: collision with root package name */
    private final CancellationToken f12444d;

    dh(String str, List<Place.Field> list, AutocompleteSessionToken autocompleteSessionToken, CancellationToken cancellationToken) {
        this.f12441a = str;
        this.f12442b = list;
        this.f12443c = autocompleteSessionToken;
        this.f12444d = cancellationToken;
    }

    public final String getPlaceId() {
        return this.f12441a;
    }

    public final List<Place.Field> getPlaceFields() {
        return this.f12442b;
    }

    public final AutocompleteSessionToken getSessionToken() {
        return this.f12443c;
    }

    public final CancellationToken getCancellationToken() {
        return this.f12444d;
    }

    public final String toString() {
        String str = this.f12441a;
        String valueOf = String.valueOf(this.f12442b);
        String valueOf2 = String.valueOf(this.f12443c);
        String valueOf3 = String.valueOf(this.f12444d);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 76 + String.valueOf(valueOf).length() + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length());
        sb.append("FetchPlaceRequest{placeId=");
        sb.append(str);
        sb.append(", placeFields=");
        sb.append(valueOf);
        sb.append(", sessionToken=");
        sb.append(valueOf2);
        sb.append(", cancellationToken=");
        sb.append(valueOf3);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FetchPlaceRequest) {
            FetchPlaceRequest fetchPlaceRequest = (FetchPlaceRequest) obj;
            if (this.f12441a.equals(fetchPlaceRequest.getPlaceId()) && this.f12442b.equals(fetchPlaceRequest.getPlaceFields())) {
                AutocompleteSessionToken autocompleteSessionToken = this.f12443c;
                if (autocompleteSessionToken != null ? autocompleteSessionToken.equals(fetchPlaceRequest.getSessionToken()) : fetchPlaceRequest.getSessionToken() == null) {
                    CancellationToken cancellationToken = this.f12444d;
                    return cancellationToken != null ? cancellationToken.equals(fetchPlaceRequest.getCancellationToken()) : fetchPlaceRequest.getCancellationToken() == null;
                }
            }
        }
    }

    public final int hashCode() {
        int hashCode = (((this.f12441a.hashCode() ^ 1000003) * 1000003) ^ this.f12442b.hashCode()) * 1000003;
        AutocompleteSessionToken autocompleteSessionToken = this.f12443c;
        int i = 0;
        int hashCode2 = (hashCode ^ (autocompleteSessionToken == null ? 0 : autocompleteSessionToken.hashCode())) * 1000003;
        CancellationToken cancellationToken = this.f12444d;
        if (cancellationToken != null) {
            i = cancellationToken.hashCode();
        }
        return hashCode2 ^ i;
    }
}
