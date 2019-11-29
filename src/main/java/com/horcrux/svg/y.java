package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.horcrux.svg.z;

@SuppressLint({"ViewConstructor"})
class y extends aa {

    /* renamed from: b  reason: collision with root package name */
    private String f14928b;

    /* renamed from: f  reason: collision with root package name */
    private z.j f14929f;

    /* renamed from: g  reason: collision with root package name */
    private z.i f14930g;
    private u h;
    private z.h i = z.h.align;
    private z.k j = z.k.exact;

    /* access modifiers changed from: package-private */
    public void c() {
    }

    /* access modifiers changed from: package-private */
    public void d() {
    }

    public y(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "href")
    public void setHref(String str) {
        this.f14928b = str;
        invalidate();
    }

    @ReactProp(name = "startOffset")
    public void setStartOffset(Dynamic dynamic) {
        this.h = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "method")
    public void setMethod(String str) {
        this.i = z.h.valueOf(str);
        invalidate();
    }

    @ReactProp(name = "spacing")
    public void setSpacing(String str) {
        this.j = z.k.valueOf(str);
        invalidate();
    }

    @ReactProp(name = "side")
    public void setSide(String str) {
        this.f14929f = z.j.valueOf(str);
        invalidate();
    }

    @ReactProp(name = "midLine")
    public void setSharp(String str) {
        this.f14930g = z.i.valueOf(str);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public z.j e() {
        return this.f14929f;
    }

    /* access modifiers changed from: package-private */
    public z.i f() {
        return this.f14930g;
    }

    /* access modifiers changed from: package-private */
    public u g() {
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public void draw(Canvas canvas, Paint paint, float f2) {
        a(canvas, paint, f2);
    }

    /* access modifiers changed from: package-private */
    public Path a(Canvas canvas, Paint paint) {
        VirtualView definedTemplate = getSvgView().getDefinedTemplate(this.f14928b);
        if (!(definedTemplate instanceof RenderableView)) {
            return null;
        }
        return ((RenderableView) definedTemplate).getPath(canvas, paint);
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        return b(canvas, paint);
    }
}
