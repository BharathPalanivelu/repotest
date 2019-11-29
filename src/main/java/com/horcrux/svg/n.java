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
class n extends j {
    private static final float[] h = {1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f};

    /* renamed from: b  reason: collision with root package name */
    u f14879b;

    /* renamed from: c  reason: collision with root package name */
    u f14880c;

    /* renamed from: d  reason: collision with root package name */
    u f14881d;

    /* renamed from: e  reason: collision with root package name */
    u f14882e;

    /* renamed from: f  reason: collision with root package name */
    private a.b f14883f;

    /* renamed from: g  reason: collision with root package name */
    private a.b f14884g;
    private Matrix i = null;

    public n(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "x")
    public void setX(Dynamic dynamic) {
        this.f14879b = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "y")
    public void setY(Dynamic dynamic) {
        this.f14880c = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "width")
    public void setWidth(Dynamic dynamic) {
        this.f14881d = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "height")
    public void setHeight(Dynamic dynamic) {
        this.f14882e = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "maskUnits")
    public void setMaskUnits(int i2) {
        if (i2 == 0) {
            this.f14883f = a.b.OBJECT_BOUNDING_BOX;
        } else if (i2 == 1) {
            this.f14883f = a.b.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    @ReactProp(name = "maskContentUnits")
    public void setMaskContentUnits(int i2) {
        if (i2 == 0) {
            this.f14884g = a.b.OBJECT_BOUNDING_BOX;
        } else if (i2 == 1) {
            this.f14884g = a.b.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    @ReactProp(name = "maskTransform")
    public void setMaskTransform(ReadableArray readableArray) {
        if (readableArray != null) {
            int a2 = q.a(readableArray, h, this.mScale);
            if (a2 == 6) {
                if (this.i == null) {
                    this.i = new Matrix();
                }
                this.i.setValues(h);
            } else if (a2 != -1) {
                FLog.w(ReactConstants.TAG, "RNSVG: Transform matrices must be of size 6");
            }
        } else {
            this.i = null;
        }
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void saveDefinition() {
        if (this.mName != null) {
            getSvgView().defineMask(this, this.mName);
        }
    }
}
