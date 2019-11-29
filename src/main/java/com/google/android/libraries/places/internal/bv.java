package com.google.android.libraries.places.internal;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.RectangularBounds;

abstract class bv extends RectangularBounds {

    /* renamed from: a  reason: collision with root package name */
    private final LatLng f12421a;

    /* renamed from: b  reason: collision with root package name */
    private final LatLng f12422b;

    bv(LatLng latLng, LatLng latLng2) {
        if (latLng != null) {
            this.f12421a = latLng;
            if (latLng2 != null) {
                this.f12422b = latLng2;
                return;
            }
            throw new NullPointerException("Null northeast");
        }
        throw new NullPointerException("Null southwest");
    }

    public LatLng getSouthwest() {
        return this.f12421a;
    }

    public LatLng getNortheast() {
        return this.f12422b;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f12421a);
        String valueOf2 = String.valueOf(this.f12422b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 41 + String.valueOf(valueOf2).length());
        sb.append("RectangularBounds{southwest=");
        sb.append(valueOf);
        sb.append(", northeast=");
        sb.append(valueOf2);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RectangularBounds) {
            RectangularBounds rectangularBounds = (RectangularBounds) obj;
            return this.f12421a.equals(rectangularBounds.getSouthwest()) && this.f12422b.equals(rectangularBounds.getNortheast());
        }
    }

    public int hashCode() {
        return ((this.f12421a.hashCode() ^ 1000003) * 1000003) ^ this.f12422b.hashCode();
    }
}
