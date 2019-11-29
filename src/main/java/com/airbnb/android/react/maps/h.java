package com.airbnb.android.react.maps;

import android.content.Context;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RoundCap;
import java.util.ArrayList;
import java.util.List;

public class h extends c {

    /* renamed from: a  reason: collision with root package name */
    private PolylineOptions f3290a;

    /* renamed from: b  reason: collision with root package name */
    private Polyline f3291b;

    /* renamed from: c  reason: collision with root package name */
    private List<LatLng> f3292c;

    /* renamed from: d  reason: collision with root package name */
    private int f3293d;

    /* renamed from: e  reason: collision with root package name */
    private float f3294e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3295f;

    /* renamed from: g  reason: collision with root package name */
    private float f3296g;
    private Cap h = new RoundCap();

    public h(Context context) {
        super(context);
    }

    public void setCoordinates(ReadableArray readableArray) {
        this.f3292c = new ArrayList(readableArray.size());
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableMap map = readableArray.getMap(i);
            this.f3292c.add(i, new LatLng(map.getDouble("latitude"), map.getDouble("longitude")));
        }
        Polyline polyline = this.f3291b;
        if (polyline != null) {
            polyline.setPoints(this.f3292c);
        }
    }

    public void setColor(int i) {
        this.f3293d = i;
        Polyline polyline = this.f3291b;
        if (polyline != null) {
            polyline.setColor(i);
        }
    }

    public void setWidth(float f2) {
        this.f3294e = f2;
        Polyline polyline = this.f3291b;
        if (polyline != null) {
            polyline.setWidth(f2);
        }
    }

    public void setZIndex(float f2) {
        this.f3296g = f2;
        Polyline polyline = this.f3291b;
        if (polyline != null) {
            polyline.setZIndex(f2);
        }
    }

    public void setGeodesic(boolean z) {
        this.f3295f = z;
        Polyline polyline = this.f3291b;
        if (polyline != null) {
            polyline.setGeodesic(z);
        }
    }

    public void setLineCap(Cap cap) {
        this.h = cap;
        Polyline polyline = this.f3291b;
        if (polyline != null) {
            polyline.setStartCap(cap);
            this.f3291b.setEndCap(cap);
        }
    }

    public PolylineOptions getPolylineOptions() {
        if (this.f3290a == null) {
            this.f3290a = a();
        }
        return this.f3290a;
    }

    private PolylineOptions a() {
        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.addAll(this.f3292c);
        polylineOptions.color(this.f3293d);
        polylineOptions.width(this.f3294e);
        polylineOptions.geodesic(this.f3295f);
        polylineOptions.zIndex(this.f3296g);
        polylineOptions.startCap(this.h);
        polylineOptions.endCap(this.h);
        return polylineOptions;
    }

    public Object getFeature() {
        return this.f3291b;
    }

    public void a(GoogleMap googleMap) {
        this.f3291b = googleMap.addPolyline(getPolylineOptions());
        this.f3291b.setClickable(true);
    }

    public void b(GoogleMap googleMap) {
        this.f3291b.remove();
    }
}
