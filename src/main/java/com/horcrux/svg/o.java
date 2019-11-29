package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.horcrux.svg.q;

@SuppressLint({"ViewConstructor"})
class o extends RenderableView {

    /* renamed from: a  reason: collision with root package name */
    private Path f14885a;

    public o(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "d")
    public void setD(String str) {
        this.f14885a = new q.a(str, this.mScale).a();
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        return this.f14885a;
    }
}
