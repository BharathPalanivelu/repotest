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
class s extends d {
    private static final float[] i = {1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f};

    /* renamed from: a  reason: collision with root package name */
    private u f14900a;

    /* renamed from: b  reason: collision with root package name */
    private u f14901b;

    /* renamed from: c  reason: collision with root package name */
    private u f14902c;

    /* renamed from: d  reason: collision with root package name */
    private u f14903d;

    /* renamed from: e  reason: collision with root package name */
    private u f14904e;

    /* renamed from: f  reason: collision with root package name */
    private u f14905f;

    /* renamed from: g  reason: collision with root package name */
    private ReadableArray f14906g;
    private a.b h;
    private Matrix j = null;

    public s(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "fx")
    public void setFx(Dynamic dynamic) {
        this.f14900a = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "fy")
    public void setFy(Dynamic dynamic) {
        this.f14901b = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "rx")
    public void setRx(Dynamic dynamic) {
        this.f14902c = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "ry")
    public void setRy(Dynamic dynamic) {
        this.f14903d = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "cx")
    public void setCx(Dynamic dynamic) {
        this.f14904e = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "cy")
    public void setCy(Dynamic dynamic) {
        this.f14905f = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "gradient")
    public void setGradient(ReadableArray readableArray) {
        this.f14906g = readableArray;
        invalidate();
    }

    @ReactProp(name = "gradientUnits")
    public void setGradientUnits(int i2) {
        if (i2 == 0) {
            this.h = a.b.OBJECT_BOUNDING_BOX;
        } else if (i2 == 1) {
            this.h = a.b.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    @ReactProp(name = "gradientTransform")
    public void setGradientTransform(ReadableArray readableArray) {
        if (readableArray != null) {
            int a2 = q.a(readableArray, i, this.mScale);
            if (a2 == 6) {
                if (this.j == null) {
                    this.j = new Matrix();
                }
                this.j.setValues(i);
            } else if (a2 != -1) {
                FLog.w(ReactConstants.TAG, "RNSVG: Transform matrices must be of size 6");
            }
        } else {
            this.j = null;
        }
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void saveDefinition() {
        if (this.mName != null) {
            a aVar = new a(a.C0241a.RADIAL_GRADIENT, new u[]{this.f14900a, this.f14901b, this.f14902c, this.f14903d, this.f14904e, this.f14905f}, this.h);
            aVar.a(this.f14906g);
            Matrix matrix = this.j;
            if (matrix != null) {
                aVar.a(matrix);
            }
            SvgView svgView = getSvgView();
            if (this.h == a.b.USER_SPACE_ON_USE) {
                aVar.a(svgView.getCanvasBounds());
            }
            svgView.defineBrush(aVar, this.mName);
        }
    }
}
