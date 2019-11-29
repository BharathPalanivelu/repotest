package com.google.maps.android.a.a;

import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.a.i;
import java.util.Arrays;

public class e extends i implements m {

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f14378d = {"LineString", "MultiLineString", "GeometryCollection"};

    public String[] b() {
        return f14378d;
    }

    public int c() {
        return this.f14433b.getColor();
    }

    public boolean d() {
        return this.f14433b.isClickable();
    }

    public boolean e() {
        return this.f14433b.isGeodesic();
    }

    public float f() {
        return this.f14433b.getWidth();
    }

    public float g() {
        return this.f14433b.getZIndex();
    }

    public boolean h() {
        return this.f14433b.isVisible();
    }

    public PolylineOptions i() {
        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.color(this.f14433b.getColor());
        polylineOptions.clickable(this.f14433b.isClickable());
        polylineOptions.geodesic(this.f14433b.isGeodesic());
        polylineOptions.visible(this.f14433b.isVisible());
        polylineOptions.width(this.f14433b.getWidth());
        polylineOptions.zIndex(this.f14433b.getZIndex());
        return polylineOptions;
    }

    public String toString() {
        return "LineStringStyle{" + "\n geometry type=" + Arrays.toString(f14378d) + ",\n color=" + c() + ",\n clickable=" + d() + ",\n geodesic=" + e() + ",\n visible=" + h() + ",\n width=" + f() + ",\n z index=" + g() + "\n}\n";
    }
}
