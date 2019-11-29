package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import java.util.List;

/* renamed from: com.google.android.libraries.places.internal.do  reason: invalid class name */
public final class Cdo extends FindCurrentPlaceRequest.Builder {

    /* renamed from: a  reason: collision with root package name */
    private List<Place.Field> f12467a;

    /* renamed from: b  reason: collision with root package name */
    private CancellationToken f12468b;

    /* access modifiers changed from: package-private */
    public final FindCurrentPlaceRequest.Builder a(List<Place.Field> list) {
        if (list != null) {
            this.f12467a = list;
            return this;
        }
        throw new NullPointerException("Null placeFields");
    }

    public final FindCurrentPlaceRequest.Builder setCancellationToken(CancellationToken cancellationToken) {
        this.f12468b = cancellationToken;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final FindCurrentPlaceRequest a() {
        String str = "";
        if (this.f12467a == null) {
            str = str.concat(" placeFields");
        }
        if (str.isEmpty()) {
            return new dn(this.f12467a, this.f12468b);
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
    }
}
