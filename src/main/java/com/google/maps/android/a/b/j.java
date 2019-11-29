package com.google.maps.android.a.b;

import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.a.b;
import com.google.maps.android.a.c;
import java.util.HashMap;

public class j extends b {

    /* renamed from: a  reason: collision with root package name */
    private final String f14402a;

    /* renamed from: b  reason: collision with root package name */
    private final n f14403b;

    public j(c cVar, String str, n nVar, HashMap<String, String> hashMap) {
        super(cVar, str, hashMap);
        this.f14402a = str;
        this.f14403b = nVar;
    }

    public String e() {
        return super.b();
    }

    public n f() {
        return this.f14403b;
    }

    public PolygonOptions g() {
        return this.f14403b.n();
    }

    public MarkerOptions h() {
        return this.f14403b.l();
    }

    public PolylineOptions i() {
        return this.f14403b.m();
    }

    public String toString() {
        return "Placemark" + "{" + "\n style id=" + this.f14402a + ",\n inline style=" + this.f14403b + "\n}\n";
    }
}
