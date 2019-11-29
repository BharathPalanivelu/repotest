package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.horcrux.svg.a;

@SuppressLint({"ViewConstructor"})
class p extends j {
    private static final float[] n = {1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f};

    /* renamed from: b  reason: collision with root package name */
    String f14886b;

    /* renamed from: c  reason: collision with root package name */
    int f14887c;

    /* renamed from: d  reason: collision with root package name */
    private u f14888d;

    /* renamed from: e  reason: collision with root package name */
    private u f14889e;

    /* renamed from: f  reason: collision with root package name */
    private u f14890f;

    /* renamed from: g  reason: collision with root package name */
    private u f14891g;
    private a.b h;
    private a.b i;
    private float j;
    private float k;
    private float l;
    private float m;
    private Matrix o = null;

    public p(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "x")
    public void setX(Dynamic dynamic) {
        this.f14888d = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "y")
    public void setY(Dynamic dynamic) {
        this.f14889e = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "width")
    public void setWidth(Dynamic dynamic) {
        this.f14890f = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "height")
    public void setHeight(Dynamic dynamic) {
        this.f14891g = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "patternUnits")
    public void setPatternUnits(int i2) {
        if (i2 == 0) {
            this.h = a.b.OBJECT_BOUNDING_BOX;
        } else if (i2 == 1) {
            this.h = a.b.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    @ReactProp(name = "patternContentUnits")
    public void setPatternContentUnits(int i2) {
        if (i2 == 0) {
            this.i = a.b.OBJECT_BOUNDING_BOX;
        } else if (i2 == 1) {
            this.i = a.b.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    @ReactProp(name = "patternTransform")
    public void setPatternTransform(ReadableArray readableArray) {
        if (readableArray != null) {
            int a2 = q.a(readableArray, n, this.mScale);
            if (a2 == 6) {
                if (this.o == null) {
                    this.o = new Matrix();
                }
                this.o.setValues(n);
            } else if (a2 != -1) {
                FLog.w(ReactConstants.TAG, "RNSVG: Transform matrices must be of size 6");
            }
        } else {
            this.o = null;
        }
        invalidate();
    }

    @ReactProp(name = "minX")
    public void setMinX(float f2) {
        this.j = f2;
        invalidate();
    }

    @ReactProp(name = "minY")
    public void setMinY(float f2) {
        this.k = f2;
        invalidate();
    }

    @ReactProp(name = "vbWidth")
    public void setVbWidth(float f2) {
        this.l = f2;
        invalidate();
    }

    @ReactProp(name = "vbHeight")
    public void setVbHeight(float f2) {
        this.m = f2;
        invalidate();
    }

    @ReactProp(name = "align")
    public void setAlign(String str) {
        this.f14886b = str;
        invalidate();
    }

    @ReactProp(name = "meetOrSlice")
    public void setMeetOrSlice(int i2) {
        this.f14887c = i2;
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public RectF e() {
        return new RectF(this.j * this.mScale, this.k * this.mScale, (this.j + this.l) * this.mScale, (this.k + this.m) * this.mScale);
    }

    /* access modifiers changed from: package-private */
    public void saveDefinition() {
        if (this.mName != null) {
            a aVar = new a(a.C0241a.PATTERN, new u[]{this.f14888d, this.f14889e, this.f14890f, this.f14891g}, this.h);
            aVar.a(this.i);
            aVar.a(this);
            Matrix matrix = this.o;
            if (matrix != null) {
                aVar.a(matrix);
            }
            SvgView svgView = getSvgView();
            if (this.h == a.b.USER_SPACE_ON_USE || this.i == a.b.USER_SPACE_ON_USE) {
                aVar.a(svgView.getCanvasBounds());
            }
            svgView.defineBrush(aVar, this.mName);
        }
    }
}
