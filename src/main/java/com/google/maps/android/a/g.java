package com.google.maps.android.a;

import com.google.android.gms.maps.model.LatLng;

public class g implements c {

    /* renamed from: a  reason: collision with root package name */
    private final LatLng f14423a;

    public String c() {
        return "Point";
    }

    public g(LatLng latLng) {
        if (latLng != null) {
            this.f14423a = latLng;
            return;
        }
        throw new IllegalArgumentException("Coordinates cannot be null");
    }

    /* renamed from: a */
    public LatLng d() {
        return this.f14423a;
    }

    public String toString() {
        return "Point" + "{" + "\n coordinates=" + this.f14423a + "\n}\n";
    }
}
