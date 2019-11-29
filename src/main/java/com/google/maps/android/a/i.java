package com.google.maps.android.a;

import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.Observable;

public abstract class i extends Observable {

    /* renamed from: a  reason: collision with root package name */
    protected MarkerOptions f14432a = new MarkerOptions();

    /* renamed from: b  reason: collision with root package name */
    protected PolylineOptions f14433b = new PolylineOptions();

    /* renamed from: c  reason: collision with root package name */
    protected PolygonOptions f14434c = new PolygonOptions();

    public float a() {
        return this.f14432a.getRotation();
    }

    public void a(float f2) {
        this.f14432a.rotation(f2);
    }

    public void a(float f2, float f3, String str, String str2) {
        if (!str.equals("fraction")) {
            f2 = 0.5f;
        }
        if (!str2.equals("fraction")) {
            f3 = 1.0f;
        }
        this.f14432a.anchor(f2, f3);
    }

    public void b(float f2) {
        this.f14433b.width(f2);
    }

    public void c(float f2) {
        this.f14434c.strokeWidth(f2);
    }

    public void a(int i) {
        this.f14434c.fillColor(i);
    }
}
