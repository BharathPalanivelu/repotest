package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

@SuppressLint({"ViewConstructor"})
class t extends RenderableView {

    /* renamed from: a  reason: collision with root package name */
    private u f14907a;

    /* renamed from: b  reason: collision with root package name */
    private u f14908b;

    /* renamed from: c  reason: collision with root package name */
    private u f14909c;

    /* renamed from: d  reason: collision with root package name */
    private u f14910d;

    /* renamed from: e  reason: collision with root package name */
    private u f14911e;

    /* renamed from: f  reason: collision with root package name */
    private u f14912f;

    public t(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "x")
    public void setX(Dynamic dynamic) {
        this.f14907a = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "y")
    public void setY(Dynamic dynamic) {
        this.f14908b = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "width")
    public void setWidth(Dynamic dynamic) {
        this.f14909c = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "height")
    public void setHeight(Dynamic dynamic) {
        this.f14910d = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "rx")
    public void setRx(Dynamic dynamic) {
        this.f14911e = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "ry")
    public void setRy(Dynamic dynamic) {
        this.f14912f = u.a(dynamic);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        Path path = new Path();
        double relativeOnWidth = relativeOnWidth(this.f14907a);
        double relativeOnHeight = relativeOnHeight(this.f14908b);
        double relativeOnWidth2 = relativeOnWidth(this.f14909c);
        double relativeOnHeight2 = relativeOnHeight(this.f14910d);
        double relativeOnWidth3 = relativeOnWidth(this.f14911e);
        double relativeOnHeight3 = relativeOnHeight(this.f14912f);
        if (relativeOnWidth3 == 0.0d && relativeOnHeight3 == 0.0d) {
            path.addRect((float) relativeOnWidth, (float) relativeOnHeight, (float) (relativeOnWidth + relativeOnWidth2), (float) (relativeOnHeight + relativeOnHeight2), Path.Direction.CW);
        } else {
            if (relativeOnWidth3 == 0.0d) {
                relativeOnWidth3 = relativeOnHeight3;
            } else if (relativeOnHeight3 == 0.0d) {
                relativeOnHeight3 = relativeOnWidth3;
            }
            double d2 = relativeOnWidth2 / 2.0d;
            if (relativeOnWidth3 > d2) {
                relativeOnWidth3 = d2;
            }
            double d3 = relativeOnHeight2 / 2.0d;
            if (relativeOnHeight3 <= d3) {
                d3 = relativeOnHeight3;
            }
            path.addRoundRect(new RectF((float) relativeOnWidth, (float) relativeOnHeight, (float) (relativeOnWidth + relativeOnWidth2), (float) (relativeOnHeight + relativeOnHeight2)), (float) relativeOnWidth3, (float) d3, Path.Direction.CW);
        }
        return path;
    }
}
