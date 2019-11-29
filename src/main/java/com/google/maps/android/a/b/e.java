package com.google.maps.android.a.b;

import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.HashMap;
import java.util.Map;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f14392a;

    /* renamed from: b  reason: collision with root package name */
    private final GroundOverlayOptions f14393b = new GroundOverlayOptions();

    /* renamed from: c  reason: collision with root package name */
    private String f14394c;

    /* renamed from: d  reason: collision with root package name */
    private LatLngBounds f14395d;

    e(String str, LatLngBounds latLngBounds, float f2, int i, HashMap<String, String> hashMap, float f3) {
        this.f14394c = str;
        this.f14392a = hashMap;
        if (latLngBounds != null) {
            this.f14395d = latLngBounds;
            this.f14393b.positionFromBounds(latLngBounds);
            this.f14393b.bearing(f3);
            this.f14393b.zIndex(f2);
            this.f14393b.visible(i != 0);
            return;
        }
        throw new IllegalArgumentException("No LatLonBox given");
    }

    public String a() {
        return this.f14394c;
    }

    public LatLngBounds b() {
        return this.f14395d;
    }

    /* access modifiers changed from: package-private */
    public GroundOverlayOptions c() {
        return this.f14393b;
    }

    public String toString() {
        return "GroundOverlay" + "{" + "\n properties=" + this.f14392a + ",\n image url=" + this.f14394c + ",\n LatLngBox=" + this.f14395d + "\n}\n";
    }
}
