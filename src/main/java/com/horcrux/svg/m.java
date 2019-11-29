package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.horcrux.svg.a;

@SuppressLint({"ViewConstructor"})
class m extends d {

    /* renamed from: g  reason: collision with root package name */
    private static final float[] f14872g = {1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f};

    /* renamed from: a  reason: collision with root package name */
    private u f14873a;

    /* renamed from: b  reason: collision with root package name */
    private u f14874b;

    /* renamed from: c  reason: collision with root package name */
    private u f14875c;

    /* renamed from: d  reason: collision with root package name */
    private u f14876d;

    /* renamed from: e  reason: collision with root package name */
    private ReadableArray f14877e;

    /* renamed from: f  reason: collision with root package name */
    private a.b f14878f;
    private Matrix h = null;

    public m(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "x1")
    public void setX1(Dynamic dynamic) {
        this.f14873a = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "y1")
    public void setY1(Dynamic dynamic) {
        this.f14874b = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "x2")
    public void setX2(Dynamic dynamic) {
        this.f14875c = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "y2")
    public void setY2(Dynamic dynamic) {
        this.f14876d = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "gradient")
    public void setGradient(ReadableArray readableArray) {
        this.f14877e = readableArray;
        invalidate();
    }

    @ReactProp(name = "gradientUnits")
    public void setGradientUnits(int i) {
        if (i == 0) {
            this.f14878f = a.b.OBJECT_BOUNDING_BOX;
        } else if (i == 1) {
            this.f14878f = a.b.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    @ReactProp(name = "gradientTransform")
    public void setGradientTransform(ReadableArray readableArray) {
        if (readableArray != null) {
            int a2 = q.a(readableArray, f14872g, this.mScale);
            if (a2 == 6) {
                if (this.h == null) {
                    this.h = new Matrix();
                }
                this.h.setValues(f14872g);
            } else if (a2 != -1) {
                FLog.w(ReactConstants.TAG, "RNSVG: Transform matrices must be of size 6");
            }
        } else {
            this.h = null;
        }
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void saveDefinition() {
        if (this.mName != null) {
            a aVar = new a(a.C0241a.LINEAR_GRADIENT, new u[]{this.f14873a, this.f14874b, this.f14875c, this.f14876d}, this.f14878f);
            aVar.a(this.f14877e);
            Matrix matrix = this.h;
            if (matrix != null) {
                aVar.a(matrix);
            }
            SvgView svgView = getSvgView();
            if (this.f14878f == a.b.USER_SPACE_ON_USE) {
                aVar.a(svgView.getCanvasBounds());
            }
            svgView.defineBrush(aVar, this.mName);
        }
    }
}
