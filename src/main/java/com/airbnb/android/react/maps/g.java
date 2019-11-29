package com.airbnb.android.react.maps;

import android.content.Context;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import java.util.ArrayList;
import java.util.List;

public class g extends c {

    /* renamed from: a  reason: collision with root package name */
    private PolygonOptions f3283a;

    /* renamed from: b  reason: collision with root package name */
    private Polygon f3284b;

    /* renamed from: c  reason: collision with root package name */
    private List<LatLng> f3285c;

    /* renamed from: d  reason: collision with root package name */
    private List<List<LatLng>> f3286d;

    /* renamed from: e  reason: collision with root package name */
    private int f3287e;

    /* renamed from: f  reason: collision with root package name */
    private int f3288f;

    /* renamed from: g  reason: collision with root package name */
    private float f3289g;
    private boolean h;
    private boolean i;
    private float j;

    public g(Context context) {
        super(context);
    }

    public void setCoordinates(ReadableArray readableArray) {
        this.f3285c = new ArrayList(readableArray.size());
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            ReadableMap map = readableArray.getMap(i2);
            this.f3285c.add(i2, new LatLng(map.getDouble("latitude"), map.getDouble("longitude")));
        }
        Polygon polygon = this.f3284b;
        if (polygon != null) {
            polygon.setPoints(this.f3285c);
        }
    }

    public void setHoles(ReadableArray readableArray) {
        if (readableArray != null) {
            this.f3286d = new ArrayList(readableArray.size());
            for (int i2 = 0; i2 < readableArray.size(); i2++) {
                ReadableArray array = readableArray.getArray(i2);
                if (array.size() >= 3) {
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < array.size(); i3++) {
                        ReadableMap map = array.getMap(i3);
                        arrayList.add(new LatLng(map.getDouble("latitude"), map.getDouble("longitude")));
                    }
                    if (arrayList.size() == 3) {
                        arrayList.add(arrayList.get(0));
                    }
                    this.f3286d.add(arrayList);
                }
            }
            Polygon polygon = this.f3284b;
            if (polygon != null) {
                polygon.setHoles(this.f3286d);
            }
        }
    }

    public void setFillColor(int i2) {
        this.f3288f = i2;
        Polygon polygon = this.f3284b;
        if (polygon != null) {
            polygon.setFillColor(i2);
        }
    }

    public void setStrokeColor(int i2) {
        this.f3287e = i2;
        Polygon polygon = this.f3284b;
        if (polygon != null) {
            polygon.setStrokeColor(i2);
        }
    }

    public void setStrokeWidth(float f2) {
        this.f3289g = f2;
        Polygon polygon = this.f3284b;
        if (polygon != null) {
            polygon.setStrokeWidth(f2);
        }
    }

    public void setTappable(boolean z) {
        this.i = z;
        Polygon polygon = this.f3284b;
        if (polygon != null) {
            polygon.setClickable(this.i);
        }
    }

    public void setGeodesic(boolean z) {
        this.h = z;
        Polygon polygon = this.f3284b;
        if (polygon != null) {
            polygon.setGeodesic(z);
        }
    }

    public void setZIndex(float f2) {
        this.j = f2;
        Polygon polygon = this.f3284b;
        if (polygon != null) {
            polygon.setZIndex(f2);
        }
    }

    public PolygonOptions getPolygonOptions() {
        if (this.f3283a == null) {
            this.f3283a = a();
        }
        return this.f3283a;
    }

    private PolygonOptions a() {
        PolygonOptions polygonOptions = new PolygonOptions();
        polygonOptions.addAll(this.f3285c);
        polygonOptions.fillColor(this.f3288f);
        polygonOptions.strokeColor(this.f3287e);
        polygonOptions.strokeWidth(this.f3289g);
        polygonOptions.geodesic(this.h);
        polygonOptions.zIndex(this.j);
        if (this.f3286d != null) {
            for (int i2 = 0; i2 < this.f3286d.size(); i2++) {
                polygonOptions.addHole(this.f3286d.get(i2));
            }
        }
        return polygonOptions;
    }

    public Object getFeature() {
        return this.f3284b;
    }

    public void a(GoogleMap googleMap) {
        this.f3284b = googleMap.addPolygon(getPolygonOptions());
        this.f3284b.setClickable(this.i);
    }

    public void b(GoogleMap googleMap) {
        this.f3284b.remove();
    }
}
