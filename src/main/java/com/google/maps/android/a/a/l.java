package com.google.maps.android.a.a;

import com.google.android.gms.maps.model.PolygonOptions;
import com.google.maps.android.a.i;
import java.util.Arrays;

public class l extends i implements m {

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f14381d = {"Polygon", "MultiPolygon", "GeometryCollection"};

    public String[] b() {
        return f14381d;
    }

    public int c() {
        return this.f14434c.getFillColor();
    }

    public boolean d() {
        return this.f14434c.isGeodesic();
    }

    public int e() {
        return this.f14434c.getStrokeColor();
    }

    public float f() {
        return this.f14434c.getStrokeWidth();
    }

    public float g() {
        return this.f14434c.getZIndex();
    }

    public boolean h() {
        return this.f14434c.isVisible();
    }

    public PolygonOptions i() {
        PolygonOptions polygonOptions = new PolygonOptions();
        polygonOptions.fillColor(this.f14434c.getFillColor());
        polygonOptions.geodesic(this.f14434c.isGeodesic());
        polygonOptions.strokeColor(this.f14434c.getStrokeColor());
        polygonOptions.strokeWidth(this.f14434c.getStrokeWidth());
        polygonOptions.visible(this.f14434c.isVisible());
        polygonOptions.zIndex(this.f14434c.getZIndex());
        return polygonOptions;
    }

    public String toString() {
        return "PolygonStyle{" + "\n geometry type=" + Arrays.toString(f14381d) + ",\n fill color=" + c() + ",\n geodesic=" + d() + ",\n stroke color=" + e() + ",\n stroke width=" + f() + ",\n visible=" + h() + ",\n z index=" + g() + "\n}\n";
    }
}
