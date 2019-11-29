package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import java.util.List;

public final class di extends FetchPlaceRequest.Builder {

    /* renamed from: a  reason: collision with root package name */
    private String f12445a;

    /* renamed from: b  reason: collision with root package name */
    private List<Place.Field> f12446b;

    /* renamed from: c  reason: collision with root package name */
    private AutocompleteSessionToken f12447c;

    /* renamed from: d  reason: collision with root package name */
    private CancellationToken f12448d;

    /* access modifiers changed from: package-private */
    public final FetchPlaceRequest.Builder a(String str) {
        if (str != null) {
            this.f12445a = str;
            return this;
        }
        throw new NullPointerException("Null placeId");
    }

    /* access modifiers changed from: package-private */
    public final FetchPlaceRequest.Builder a(List<Place.Field> list) {
        if (list != null) {
            this.f12446b = list;
            return this;
        }
        throw new NullPointerException("Null placeFields");
    }

    public final FetchPlaceRequest.Builder setSessionToken(AutocompleteSessionToken autocompleteSessionToken) {
        this.f12447c = autocompleteSessionToken;
        return this;
    }

    public final FetchPlaceRequest.Builder setCancellationToken(CancellationToken cancellationToken) {
        this.f12448d = cancellationToken;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final FetchPlaceRequest a() {
        String str = "";
        if (this.f12445a == null) {
            str = str.concat(" placeId");
        }
        if (this.f12446b == null) {
            str = String.valueOf(str).concat(" placeFields");
        }
        if (str.isEmpty()) {
            return new dh(this.f12445a, this.f12446b, this.f12447c, this.f12448d);
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
    }
}
