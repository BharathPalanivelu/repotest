package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

@SuppressLint({"ViewConstructor"})
class b extends RenderableView {

    /* renamed from: a  reason: collision with root package name */
    private u f14834a;

    /* renamed from: b  reason: collision with root package name */
    private u f14835b;

    /* renamed from: c  reason: collision with root package name */
    private u f14836c;

    public b(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "cx")
    public void setCx(Dynamic dynamic) {
        this.f14834a = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "cy")
    public void setCy(Dynamic dynamic) {
        this.f14835b = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "r")
    public void setR(Dynamic dynamic) {
        this.f14836c = u.a(dynamic);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        Path path = new Path();
        path.addCircle((float) relativeOnWidth(this.f14834a), (float) relativeOnHeight(this.f14835b), (float) relativeOnOther(this.f14836c), Path.Direction.CW);
        return path;
    }
}
