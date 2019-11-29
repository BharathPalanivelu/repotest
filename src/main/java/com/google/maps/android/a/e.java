package com.google.maps.android.a;

import com.google.android.gms.maps.model.LatLng;
import java.util.List;

public class e implements c<List<LatLng>> {

    /* renamed from: a  reason: collision with root package name */
    private final List<LatLng> f14420a;

    public String c() {
        return "LineString";
    }

    public e(List<LatLng> list) {
        if (list != null) {
            this.f14420a = list;
            return;
        }
        throw new IllegalArgumentException("Coordinates cannot be null");
    }

    /* renamed from: a */
    public List<LatLng> d() {
        return this.f14420a;
    }

    public String toString() {
        return "LineString" + "{" + "\n coordinates=" + this.f14420a + "\n}\n";
    }
}
