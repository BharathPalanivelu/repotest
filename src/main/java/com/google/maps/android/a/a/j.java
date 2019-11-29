package com.google.maps.android.a.a;

import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.a.i;
import java.util.Arrays;

public class j extends i implements m {

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f14379d = {"Point", "MultiPoint", "GeometryCollection"};

    public String[] b() {
        return f14379d;
    }

    public float c() {
        return this.f14432a.getAlpha();
    }

    public float d() {
        return this.f14432a.getAnchorU();
    }

    public float e() {
        return this.f14432a.getAnchorV();
    }

    public boolean f() {
        return this.f14432a.isDraggable();
    }

    public boolean g() {
        return this.f14432a.isFlat();
    }

    public float h() {
        return this.f14432a.getInfoWindowAnchorU();
    }

    public float i() {
        return this.f14432a.getInfoWindowAnchorV();
    }

    public float a() {
        return this.f14432a.getRotation();
    }

    public String j() {
        return this.f14432a.getSnippet();
    }

    public String k() {
        return this.f14432a.getTitle();
    }

    public boolean l() {
        return this.f14432a.isVisible();
    }

    public MarkerOptions m() {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.alpha(this.f14432a.getAlpha());
        markerOptions.anchor(this.f14432a.getAnchorU(), this.f14432a.getAnchorV());
        markerOptions.draggable(this.f14432a.isDraggable());
        markerOptions.flat(this.f14432a.isFlat());
        markerOptions.icon(this.f14432a.getIcon());
        markerOptions.infoWindowAnchor(this.f14432a.getInfoWindowAnchorU(), this.f14432a.getInfoWindowAnchorV());
        markerOptions.rotation(this.f14432a.getRotation());
        markerOptions.snippet(this.f14432a.getSnippet());
        markerOptions.title(this.f14432a.getTitle());
        markerOptions.visible(this.f14432a.isVisible());
        return markerOptions;
    }

    public String toString() {
        return "PointStyle{" + "\n geometry type=" + Arrays.toString(f14379d) + ",\n alpha=" + c() + ",\n anchor U=" + d() + ",\n anchor V=" + e() + ",\n draggable=" + f() + ",\n flat=" + g() + ",\n info window anchor U=" + h() + ",\n info window anchor V=" + i() + ",\n rotation=" + a() + ",\n snippet=" + j() + ",\n title=" + k() + ",\n visible=" + l() + "\n}\n";
    }
}
