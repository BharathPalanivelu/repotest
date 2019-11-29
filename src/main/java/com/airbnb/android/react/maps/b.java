package com.airbnb.android.react.maps;

import android.content.Context;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

public class b extends c {

    /* renamed from: a  reason: collision with root package name */
    private CircleOptions f3251a;

    /* renamed from: b  reason: collision with root package name */
    private Circle f3252b;

    /* renamed from: c  reason: collision with root package name */
    private LatLng f3253c;

    /* renamed from: d  reason: collision with root package name */
    private double f3254d;

    /* renamed from: e  reason: collision with root package name */
    private int f3255e;

    /* renamed from: f  reason: collision with root package name */
    private int f3256f;

    /* renamed from: g  reason: collision with root package name */
    private float f3257g;
    private float h;

    public b(Context context) {
        super(context);
    }

    public void setCenter(LatLng latLng) {
        this.f3253c = latLng;
        Circle circle = this.f3252b;
        if (circle != null) {
            circle.setCenter(this.f3253c);
        }
    }

    public void setRadius(double d2) {
        this.f3254d = d2;
        Circle circle = this.f3252b;
        if (circle != null) {
            circle.setRadius(this.f3254d);
        }
    }

    public void setFillColor(int i) {
        this.f3256f = i;
        Circle circle = this.f3252b;
        if (circle != null) {
            circle.setFillColor(i);
        }
    }

    public void setStrokeColor(int i) {
        this.f3255e = i;
        Circle circle = this.f3252b;
        if (circle != null) {
            circle.setStrokeColor(i);
        }
    }

    public void setStrokeWidth(float f2) {
        this.f3257g = f2;
        Circle circle = this.f3252b;
        if (circle != null) {
            circle.setStrokeWidth(f2);
        }
    }

    public void setZIndex(float f2) {
        this.h = f2;
        Circle circle = this.f3252b;
        if (circle != null) {
            circle.setZIndex(f2);
        }
    }

    public CircleOptions getCircleOptions() {
        if (this.f3251a == null) {
            this.f3251a = a();
        }
        return this.f3251a;
    }

    private CircleOptions a() {
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(this.f3253c);
        circleOptions.radius(this.f3254d);
        circleOptions.fillColor(this.f3256f);
        circleOptions.strokeColor(this.f3255e);
        circleOptions.strokeWidth(this.f3257g);
        circleOptions.zIndex(this.h);
        return circleOptions;
    }

    public Object getFeature() {
        return this.f3252b;
    }

    public void a(GoogleMap googleMap) {
        this.f3252b = googleMap.addCircle(getCircleOptions());
    }

    public void b(GoogleMap googleMap) {
        this.f3252b.remove();
    }
}
