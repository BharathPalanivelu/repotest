package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.view.View;
import android.view.ViewParent;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.horcrux.svg.z;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
class aa extends j {

    /* renamed from: b  reason: collision with root package name */
    private String f14823b = null;

    /* renamed from: c  reason: collision with root package name */
    u f14824c = null;

    /* renamed from: d  reason: collision with root package name */
    z.g f14825d = z.g.spacing;

    /* renamed from: e  reason: collision with root package name */
    double f14826e = Double.NaN;

    /* renamed from: f  reason: collision with root package name */
    private z.a f14827f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<u> f14828g;
    private ArrayList<u> h;
    private ArrayList<u> i;
    private ArrayList<u> j;
    private ArrayList<u> k;

    public aa(ReactContext reactContext) {
        super(reactContext);
    }

    public void invalidate() {
        if (this.mPath != null) {
            super.invalidate();
            k().clearChildCache();
        }
    }

    /* access modifiers changed from: package-private */
    public void clearCache() {
        this.f14826e = Double.NaN;
        super.clearCache();
    }

    @ReactProp(name = "textLength")
    public void setTextLength(Dynamic dynamic) {
        this.f14824c = u.a(dynamic);
        invalidate();
    }

    @ReactProp(name = "lengthAdjust")
    public void setLengthAdjust(String str) {
        this.f14825d = z.g.valueOf(str);
        invalidate();
    }

    @ReactProp(name = "alignmentBaseline")
    public void setMethod(String str) {
        this.f14827f = z.a.a(str);
        invalidate();
    }

    @ReactProp(name = "baselineShift")
    public void setBaselineShift(Dynamic dynamic) {
        this.f14823b = u.b(dynamic);
        invalidate();
    }

    @ReactProp(name = "verticalAlign")
    public void setVerticalAlign(String str) {
        if (str != null) {
            String trim = str.trim();
            int lastIndexOf = trim.lastIndexOf(32);
            try {
                this.f14827f = z.a.a(trim.substring(lastIndexOf));
            } catch (IllegalArgumentException unused) {
                this.f14827f = z.a.baseline;
            }
            try {
                this.f14823b = trim.substring(0, lastIndexOf);
            } catch (IndexOutOfBoundsException unused2) {
                this.f14823b = null;
            }
        } else {
            this.f14827f = z.a.baseline;
            this.f14823b = null;
        }
        invalidate();
    }

    @ReactProp(name = "rotate")
    public void setRotate(Dynamic dynamic) {
        this.i = u.c(dynamic);
        invalidate();
    }

    @ReactProp(name = "dx")
    public void setDeltaX(Dynamic dynamic) {
        this.j = u.c(dynamic);
        invalidate();
    }

    @ReactProp(name = "dy")
    public void setDeltaY(Dynamic dynamic) {
        this.k = u.c(dynamic);
        invalidate();
    }

    @ReactProp(name = "x")
    public void setPositionX(Dynamic dynamic) {
        this.f14828g = u.c(dynamic);
        invalidate();
    }

    @ReactProp(name = "y")
    public void setPositionY(Dynamic dynamic) {
        this.h = u.c(dynamic);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void draw(Canvas canvas, Paint paint, float f2) {
        if (f2 > 0.01f) {
            a(canvas);
            clip(canvas, paint);
            b(canvas, paint);
            a(canvas, paint, f2);
        }
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        if (this.mPath != null) {
            return this.mPath;
        }
        a(canvas);
        return b(canvas, paint);
    }

    /* access modifiers changed from: package-private */
    public Path a(Canvas canvas, Paint paint, Region.Op op) {
        return getPath(canvas, paint);
    }

    /* access modifiers changed from: package-private */
    public z.a h() {
        if (this.f14827f == null) {
            for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
                if (parent instanceof aa) {
                    z.a aVar = ((aa) parent).f14827f;
                    if (aVar != null) {
                        this.f14827f = aVar;
                        return aVar;
                    }
                }
            }
        }
        if (this.f14827f == null) {
            this.f14827f = z.a.baseline;
        }
        return this.f14827f;
    }

    /* access modifiers changed from: package-private */
    public String i() {
        if (this.f14823b == null) {
            for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
                if (parent instanceof aa) {
                    String str = ((aa) parent).f14823b;
                    if (str != null) {
                        this.f14823b = str;
                        return str;
                    }
                }
            }
        }
        return this.f14823b;
    }

    /* access modifiers changed from: package-private */
    public Path b(Canvas canvas, Paint paint) {
        if (this.mPath != null) {
            return this.mPath;
        }
        c();
        this.mPath = super.getPath(canvas, paint);
        d();
        return this.mPath;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        b().a(!(this instanceof y) && !(this instanceof x), this, this.f14858a, this.f14828g, this.h, this.j, this.k, this.i);
    }

    /* access modifiers changed from: package-private */
    public aa j() {
        ArrayList<g> arrayList = b().f14848a;
        ViewParent parent = getParent();
        int size = arrayList.size() - 1;
        ViewParent viewParent = parent;
        aa aaVar = this;
        while (size >= 0 && (viewParent instanceof aa) && arrayList.get(size).h != z.e.start && aaVar.f14828g == null) {
            aaVar = viewParent;
            viewParent = aaVar.getParent();
            size--;
        }
        return aaVar;
    }

    /* access modifiers changed from: package-private */
    public double a(Paint paint) {
        if (!Double.isNaN(this.f14826e)) {
            return this.f14826e;
        }
        double d2 = 0.0d;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof aa) {
                d2 += ((aa) childAt).a(paint);
            }
        }
        this.f14826e = d2;
        return d2;
    }

    /* access modifiers changed from: package-private */
    public aa k() {
        aa aaVar = this;
        ViewParent viewParent = getParent();
        while (viewParent instanceof aa) {
            aaVar = (aa) viewParent;
            viewParent = aaVar.getParent();
        }
        return aaVar;
    }
}
