package com.google.android.libraries.places.internal;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.RectangularBounds;

public final class bw extends RectangularBounds.a {

    /* renamed from: a  reason: collision with root package name */
    private LatLng f12423a;

    /* renamed from: b  reason: collision with root package name */
    private LatLng f12424b;

    /* access modifiers changed from: package-private */
    public final RectangularBounds.a a(LatLng latLng) {
        if (latLng != null) {
            this.f12423a = latLng;
            return this;
        }
        throw new NullPointerException("Null southwest");
    }

    /* access modifiers changed from: package-private */
    public final RectangularBounds.a b(LatLng latLng) {
        if (latLng != null) {
            this.f12424b = latLng;
            return this;
        }
        throw new NullPointerException("Null northeast");
    }

    /* access modifiers changed from: package-private */
    public final RectangularBounds a() {
        String str = "";
        if (this.f12423a == null) {
            str = str.concat(" southwest");
        }
        if (this.f12424b == null) {
            str = String.valueOf(str).concat(" northeast");
        }
        if (str.isEmpty()) {
            return new cw(this.f12423a, this.f12424b);
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
    }
}
