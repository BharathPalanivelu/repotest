package com.google.maps.android.a;

import java.util.ArrayList;
import java.util.List;

public class f implements c {

    /* renamed from: a  reason: collision with root package name */
    private String f14421a = "MultiGeometry";

    /* renamed from: b  reason: collision with root package name */
    private List<c> f14422b;

    public f(List<? extends c> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (c add : list) {
                arrayList.add(add);
            }
            this.f14422b = arrayList;
            return;
        }
        throw new IllegalArgumentException("Geometries cannot be null");
    }

    public String c() {
        return this.f14421a;
    }

    /* renamed from: a */
    public List<c> d() {
        return this.f14422b;
    }

    public String toString() {
        String str = this.f14421a.equals("MultiPoint") ? "LineStrings=" : "Geometries=";
        if (this.f14421a.equals("MultiLineString")) {
            str = "points=";
        }
        if (this.f14421a.equals("MultiPolygon")) {
            str = "Polygons=";
        }
        StringBuilder sb = new StringBuilder(c());
        sb.append("{");
        sb.append("\n " + str);
        sb.append(d());
        sb.append("\n}\n");
        return sb.toString();
    }
}
