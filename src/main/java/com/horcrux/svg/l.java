package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

@SuppressLint({"ViewConstructor"})
class l extends RenderableView {

    /* renamed from: a  reason: collision with root package name */
    private u f14868a;

    /* renamed from: b  reason: collision with root package name */
    private u f14869b;

    /* renamed from: c  reason: collision with root package name */
    private u f14870c;

    /* renamed from: d  reason: collision with root package name */
    private u f14871d;

    public l(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "x1")
    public void setX1(Dynamic dynamic) {
        this.f14868a = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "y1")
    public void setY1(Dynamic dynamic) {
        this.f14869b = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "x2")
    public void setX2(Dynamic dynamic) {
        this.f14870c = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "y2")
    public void setY2(Dynamic dynamic) {
        this.f14871d = u.a(dynamic);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        Path path = new Path();
        double relativeOnWidth = relativeOnWidth(this.f14868a);
        double relativeOnHeight = relativeOnHeight(this.f14869b);
        double relativeOnWidth2 = relativeOnWidth(this.f14870c);
        double relativeOnHeight2 = relativeOnHeight(this.f14871d);
        path.moveTo((float) relativeOnWidth, (float) relativeOnHeight);
        path.lineTo((float) relativeOnWidth2, (float) relativeOnHeight2);
        return path;
    }
}
