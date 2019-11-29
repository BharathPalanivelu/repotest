package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;

final class dk extends FindAutocompletePredictionsRequest {

    /* renamed from: a  reason: collision with root package name */
    private final String f12450a;

    /* renamed from: b  reason: collision with root package name */
    private final LocationBias f12451b;

    /* renamed from: c  reason: collision with root package name */
    private final LocationRestriction f12452c;

    /* renamed from: d  reason: collision with root package name */
    private final String f12453d;

    /* renamed from: e  reason: collision with root package name */
    private final AutocompleteSessionToken f12454e;

    /* renamed from: f  reason: collision with root package name */
    private final TypeFilter f12455f;

    /* renamed from: g  reason: collision with root package name */
    private final CancellationToken f12456g;

    dk(String str, LocationBias locationBias, LocationRestriction locationRestriction, String str2, AutocompleteSessionToken autocompleteSessionToken, TypeFilter typeFilter, CancellationToken cancellationToken) {
        this.f12450a = str;
        this.f12451b = locationBias;
        this.f12452c = locationRestriction;
        this.f12453d = str2;
        this.f12454e = autocompleteSessionToken;
        this.f12455f = typeFilter;
        this.f12456g = cancellationToken;
    }

    public final String getQuery() {
        return this.f12450a;
    }

    public final LocationBias getLocationBias() {
        return this.f12451b;
    }

    public final LocationRestriction getLocationRestriction() {
        return this.f12452c;
    }

    public final String getCountry() {
        return this.f12453d;
    }

    public final AutocompleteSessionToken getSessionToken() {
        return this.f12454e;
    }

    public final TypeFilter getTypeFilter() {
        return this.f12455f;
    }

    public final CancellationToken getCancellationToken() {
        return this.f12456g;
    }

    public final String toString() {
        String str = this.f12450a;
        String valueOf = String.valueOf(this.f12451b);
        String valueOf2 = String.valueOf(this.f12452c);
        String str2 = this.f12453d;
        String valueOf3 = String.valueOf(this.f12454e);
        String valueOf4 = String.valueOf(this.f12455f);
        String valueOf5 = String.valueOf(this.f12456g);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 137 + String.valueOf(valueOf).length() + String.valueOf(valueOf2).length() + String.valueOf(str2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length() + String.valueOf(valueOf5).length());
        sb.append("FindAutocompletePredictionsRequest{query=");
        sb.append(str);
        sb.append(", locationBias=");
        sb.append(valueOf);
        sb.append(", locationRestriction=");
        sb.append(valueOf2);
        sb.append(", country=");
        sb.append(str2);
        sb.append(", sessionToken=");
        sb.append(valueOf3);
        sb.append(", typeFilter=");
        sb.append(valueOf4);
        sb.append(", cancellationToken=");
        sb.append(valueOf5);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FindAutocompletePredictionsRequest) {
            FindAutocompletePredictionsRequest findAutocompletePredictionsRequest = (FindAutocompletePredictionsRequest) obj;
            String str = this.f12450a;
            if (str != null ? str.equals(findAutocompletePredictionsRequest.getQuery()) : findAutocompletePredictionsRequest.getQuery() == null) {
                LocationBias locationBias = this.f12451b;
                if (locationBias != null ? locationBias.equals(findAutocompletePredictionsRequest.getLocationBias()) : findAutocompletePredictionsRequest.getLocationBias() == null) {
                    LocationRestriction locationRestriction = this.f12452c;
                    if (locationRestriction != null ? locationRestriction.equals(findAutocompletePredictionsRequest.getLocationRestriction()) : findAutocompletePredictionsRequest.getLocationRestriction() == null) {
                        String str2 = this.f12453d;
                        if (str2 != null ? str2.equals(findAutocompletePredictionsRequest.getCountry()) : findAutocompletePredictionsRequest.getCountry() == null) {
                            AutocompleteSessionToken autocompleteSessionToken = this.f12454e;
                            if (autocompleteSessionToken != null ? autocompleteSessionToken.equals(findAutocompletePredictionsRequest.getSessionToken()) : findAutocompletePredictionsRequest.getSessionToken() == null) {
                                TypeFilter typeFilter = this.f12455f;
                                if (typeFilter != null ? typeFilter.equals(findAutocompletePredictionsRequest.getTypeFilter()) : findAutocompletePredictionsRequest.getTypeFilter() == null) {
                                    CancellationToken cancellationToken = this.f12456g;
                                    return cancellationToken != null ? cancellationToken.equals(findAutocompletePredictionsRequest.getCancellationToken()) : findAutocompletePredictionsRequest.getCancellationToken() == null;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final int hashCode() {
        String str = this.f12450a;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        LocationBias locationBias = this.f12451b;
        int hashCode2 = (hashCode ^ (locationBias == null ? 0 : locationBias.hashCode())) * 1000003;
        LocationRestriction locationRestriction = this.f12452c;
        int hashCode3 = (hashCode2 ^ (locationRestriction == null ? 0 : locationRestriction.hashCode())) * 1000003;
        String str2 = this.f12453d;
        int hashCode4 = (hashCode3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        AutocompleteSessionToken autocompleteSessionToken = this.f12454e;
        int hashCode5 = (hashCode4 ^ (autocompleteSessionToken == null ? 0 : autocompleteSessionToken.hashCode())) * 1000003;
        TypeFilter typeFilter = this.f12455f;
        int hashCode6 = (hashCode5 ^ (typeFilter == null ? 0 : typeFilter.hashCode())) * 1000003;
        CancellationToken cancellationToken = this.f12456g;
        if (cancellationToken != null) {
            i = cancellationToken.hashCode();
        }
        return hashCode6 ^ i;
    }
}
