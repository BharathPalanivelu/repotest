package com.airbnb.android.react.maps;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.react.bridge.ReadableArray;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class f extends c implements l {

    /* renamed from: a  reason: collision with root package name */
    private GroundOverlayOptions f3276a;

    /* renamed from: b  reason: collision with root package name */
    private GroundOverlay f3277b;

    /* renamed from: c  reason: collision with root package name */
    private LatLngBounds f3278c;

    /* renamed from: d  reason: collision with root package name */
    private BitmapDescriptor f3279d;

    /* renamed from: e  reason: collision with root package name */
    private Bitmap f3280e;

    /* renamed from: f  reason: collision with root package name */
    private float f3281f;

    /* renamed from: g  reason: collision with root package name */
    private final m f3282g;
    private GoogleMap h;

    public f(Context context) {
        super(context);
        this.f3282g = new m(context, getResources(), this);
    }

    public void setBounds(ReadableArray readableArray) {
        this.f3278c = new LatLngBounds(new LatLng(readableArray.getArray(1).getDouble(0), readableArray.getArray(0).getDouble(1)), new LatLng(readableArray.getArray(0).getDouble(0), readableArray.getArray(1).getDouble(1)));
        GroundOverlay groundOverlay = this.f3277b;
        if (groundOverlay != null) {
            groundOverlay.setPositionFromBounds(this.f3278c);
        }
    }

    public void setZIndex(float f2) {
        this.f3281f = f2;
        GroundOverlay groundOverlay = this.f3277b;
        if (groundOverlay != null) {
            groundOverlay.setZIndex(f2);
        }
    }

    public void setImage(String str) {
        this.f3282g.a(str);
    }

    public GroundOverlayOptions getGroundOverlayOptions() {
        if (this.f3276a == null) {
            this.f3276a = b();
        }
        return this.f3276a;
    }

    private GroundOverlayOptions b() {
        GroundOverlayOptions groundOverlayOptions = this.f3276a;
        if (groundOverlayOptions != null) {
            return groundOverlayOptions;
        }
        if (this.f3279d == null) {
            return null;
        }
        GroundOverlayOptions groundOverlayOptions2 = new GroundOverlayOptions();
        groundOverlayOptions2.image(this.f3279d);
        groundOverlayOptions2.positionFromBounds(this.f3278c);
        groundOverlayOptions2.zIndex(this.f3281f);
        return groundOverlayOptions2;
    }

    public Object getFeature() {
        return this.f3277b;
    }

    public void a(GoogleMap googleMap) {
        GroundOverlayOptions groundOverlayOptions = getGroundOverlayOptions();
        if (groundOverlayOptions != null) {
            this.f3277b = googleMap.addGroundOverlay(groundOverlayOptions);
            this.f3277b.setClickable(true);
            return;
        }
        this.h = googleMap;
    }

    public void b(GoogleMap googleMap) {
        this.h = null;
        GroundOverlay groundOverlay = this.f3277b;
        if (groundOverlay != null) {
            groundOverlay.remove();
            this.f3277b = null;
            this.f3276a = null;
        }
    }

    public void setIconBitmap(Bitmap bitmap) {
        this.f3280e = bitmap;
    }

    public void setIconBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        this.f3279d = bitmapDescriptor;
    }

    public void a() {
        this.f3277b = getGroundOverlay();
        GroundOverlay groundOverlay = this.f3277b;
        if (groundOverlay != null) {
            groundOverlay.setImage(this.f3279d);
            this.f3277b.setClickable(true);
        }
    }

    private GroundOverlay getGroundOverlay() {
        GroundOverlay groundOverlay = this.f3277b;
        if (groundOverlay != null) {
            return groundOverlay;
        }
        if (this.h == null) {
            return null;
        }
        GroundOverlayOptions groundOverlayOptions = getGroundOverlayOptions();
        if (groundOverlayOptions != null) {
            return this.h.addGroundOverlay(groundOverlayOptions);
        }
        return null;
    }
}
