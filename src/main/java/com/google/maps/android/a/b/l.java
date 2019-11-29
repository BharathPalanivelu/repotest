package com.google.maps.android.a.b;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.a.a;
import java.util.ArrayList;
import java.util.List;

public class l implements a<ArrayList<ArrayList<LatLng>>> {

    /* renamed from: a  reason: collision with root package name */
    private final List<LatLng> f14404a;

    /* renamed from: b  reason: collision with root package name */
    private final List<List<LatLng>> f14405b;

    public String c() {
        return "Polygon";
    }

    public l(List<LatLng> list, List<List<LatLng>> list2) {
        if (list != null) {
            this.f14404a = list;
            this.f14405b = list2;
            return;
        }
        throw new IllegalArgumentException("Outer boundary coordinates cannot be null");
    }

    /* renamed from: e */
    public List<List<LatLng>> d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f14404a);
        List<List<LatLng>> list = this.f14405b;
        if (list != null) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    public List<LatLng> a() {
        return this.f14404a;
    }

    public List<List<LatLng>> b() {
        return this.f14405b;
    }

    public String toString() {
        return "Polygon" + "{" + "\n outer coordinates=" + this.f14404a + ",\n inner coordinates=" + this.f14405b + "\n}\n";
    }
}
