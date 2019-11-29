package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;

public final class dl extends FindAutocompletePredictionsRequest.Builder {

    /* renamed from: a  reason: collision with root package name */
    private String f12457a;

    /* renamed from: b  reason: collision with root package name */
    private LocationBias f12458b;

    /* renamed from: c  reason: collision with root package name */
    private LocationRestriction f12459c;

    /* renamed from: d  reason: collision with root package name */
    private String f12460d;

    /* renamed from: e  reason: collision with root package name */
    private AutocompleteSessionToken f12461e;

    /* renamed from: f  reason: collision with root package name */
    private TypeFilter f12462f;

    /* renamed from: g  reason: collision with root package name */
    private CancellationToken f12463g;

    public final FindAutocompletePredictionsRequest.Builder setQuery(String str) {
        this.f12457a = str;
        return this;
    }

    public final FindAutocompletePredictionsRequest.Builder setLocationBias(LocationBias locationBias) {
        this.f12458b = locationBias;
        return this;
    }

    public final FindAutocompletePredictionsRequest.Builder setLocationRestriction(LocationRestriction locationRestriction) {
        this.f12459c = locationRestriction;
        return this;
    }

    public final FindAutocompletePredictionsRequest.Builder setCountry(String str) {
        this.f12460d = str;
        return this;
    }

    public final FindAutocompletePredictionsRequest.Builder setSessionToken(AutocompleteSessionToken autocompleteSessionToken) {
        this.f12461e = autocompleteSessionToken;
        return this;
    }

    public final FindAutocompletePredictionsRequest.Builder setTypeFilter(TypeFilter typeFilter) {
        this.f12462f = typeFilter;
        return this;
    }

    public final FindAutocompletePredictionsRequest.Builder setCancellationToken(CancellationToken cancellationToken) {
        this.f12463g = cancellationToken;
        return this;
    }

    public final FindAutocompletePredictionsRequest build() {
        return new dk(this.f12457a, this.f12458b, this.f12459c, this.f12460d, this.f12461e, this.f12462f, this.f12463g);
    }
}
