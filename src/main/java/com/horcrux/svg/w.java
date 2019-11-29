package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

@SuppressLint({"ViewConstructor"})
class w extends j {

    /* renamed from: b  reason: collision with root package name */
    private float f14916b;

    /* renamed from: c  reason: collision with root package name */
    private float f14917c;

    /* renamed from: d  reason: collision with root package name */
    private float f14918d;

    /* renamed from: e  reason: collision with root package name */
    private float f14919e;

    /* renamed from: f  reason: collision with root package name */
    private String f14920f;

    /* renamed from: g  reason: collision with root package name */
    private int f14921g;

    public w(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "minX")
    public void setMinX(float f2) {
        this.f14916b = f2;
        invalidate();
    }

    @ReactProp(name = "minY")
    public void setMinY(float f2) {
        this.f14917c = f2;
        invalidate();
    }

    @ReactProp(name = "vbWidth")
    public void setVbWidth(float f2) {
        this.f14918d = f2;
        invalidate();
    }

    @ReactProp(name = "vbHeight")
    public void setVbHeight(float f2) {
        this.f14919e = f2;
        invalidate();
    }

    @ReactProp(name = "align")
    public void setAlign(String str) {
        this.f14920f = str;
        invalidate();
    }

    @ReactProp(name = "meetOrSlice")
    public void setMeetOrSlice(int i) {
        this.f14921g = i;
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void draw(Canvas canvas, Paint paint, float f2) {
        saveDefinition();
    }

    /* access modifiers changed from: package-private */
    public void a(Canvas canvas, Paint paint, float f2, float f3, float f4) {
        if (this.f14920f != null) {
            canvas.concat(ac.a(new RectF(this.f14916b * this.mScale, this.f14917c * this.mScale, (this.f14916b + this.f14918d) * this.mScale, (this.f14917c + this.f14919e) * this.mScale), new RectF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, f3, f4), this.f14920f, this.f14921g));
            super.draw(canvas, paint, f2);
        }
    }
}
