package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.view.View;
import android.view.ViewParent;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.OnLayoutEvent;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewGroup;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

@SuppressLint({"ViewConstructor"})
public abstract class VirtualView extends ReactViewGroup {
    private static final int CLIP_RULE_EVENODD = 0;
    static final int CLIP_RULE_NONZERO = 1;
    static final float MIN_OPACITY_FOR_DRAW = 0.01f;
    private static final double M_SQRT1_2l = 0.7071067811865476d;
    private static final float[] sRawMatrix = {1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f};
    private double canvasDiagonal = -1.0d;
    private float canvasHeight = -1.0f;
    private float canvasWidth = -1.0f;
    private double fontSize = -1.0d;
    private h glyphContext;
    RectF mBox;
    private Path mCachedClipPath;
    private RectF mClientRect;
    private String mClipPath;
    Region mClipRegion;
    Path mClipRegionPath;
    int mClipRule;
    final ReactContext mContext;
    Path mFillPath;
    Matrix mInvMatrix = new Matrix();
    final Matrix mInvTransform = new Matrix();
    boolean mInvertible = true;
    String mMask;
    Matrix mMatrix = new Matrix();
    String mName;
    float mOpacity = 1.0f;
    Path mPath;
    Region mRegion;
    private boolean mResponsible;
    final float mScale;
    Path mStrokePath;
    Region mStrokeRegion;
    private j mTextRoot;
    Matrix mTransform = new Matrix();
    boolean mTransformInvertible = true;
    private SvgView svgView;

    /* access modifiers changed from: package-private */
    public abstract void draw(Canvas canvas, Paint paint, float f2);

    /* access modifiers changed from: package-private */
    public abstract Path getPath(Canvas canvas, Paint paint);

    /* access modifiers changed from: package-private */
    public abstract int hitTest(float[] fArr);

    VirtualView(ReactContext reactContext) {
        super(reactContext);
        this.mContext = reactContext;
        this.mScale = DisplayMetricsHolder.getScreenDisplayMetrics().density;
    }

    public void invalidate() {
        if (!(this instanceof RenderableView) || this.mPath != null) {
            clearCache();
            clearParentCache();
            super.invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public void clearCache() {
        this.canvasDiagonal = -1.0d;
        this.canvasHeight = -1.0f;
        this.canvasWidth = -1.0f;
        this.fontSize = -1.0d;
        this.mStrokeRegion = null;
        this.mRegion = null;
        this.mPath = null;
    }

    /* access modifiers changed from: package-private */
    public void clearChildCache() {
        clearCache();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof VirtualView) {
                ((VirtualView) childAt).clearChildCache();
            }
        }
    }

    private void clearParentCache() {
        VirtualView virtualView = this;
        while (true) {
            ViewParent parent = virtualView.getParent();
            if (parent instanceof VirtualView) {
                virtualView = (VirtualView) parent;
                if (virtualView.mPath != null) {
                    virtualView.clearCache();
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public j getTextRoot() {
        if (this.mTextRoot == null) {
            VirtualView virtualView = this;
            while (true) {
                if (virtualView == null) {
                    break;
                }
                if (virtualView instanceof j) {
                    j jVar = (j) virtualView;
                    if (jVar.a() != null) {
                        this.mTextRoot = jVar;
                        break;
                    }
                }
                ViewParent parent = virtualView.getParent();
                if (!(parent instanceof VirtualView)) {
                    virtualView = null;
                } else {
                    virtualView = (VirtualView) parent;
                }
            }
        }
        return this.mTextRoot;
    }

    /* access modifiers changed from: package-private */
    public j getParentTextRoot() {
        ViewParent parent = getParent();
        if (!(parent instanceof VirtualView)) {
            return null;
        }
        return ((VirtualView) parent).getTextRoot();
    }

    private double getFontSizeFromContext() {
        double d2 = this.fontSize;
        if (d2 != -1.0d) {
            return d2;
        }
        j textRoot = getTextRoot();
        if (textRoot == null) {
            return 12.0d;
        }
        if (this.glyphContext == null) {
            this.glyphContext = textRoot.a();
        }
        this.fontSize = this.glyphContext.c();
        return this.fontSize;
    }

    /* access modifiers changed from: package-private */
    public void render(Canvas canvas, Paint paint, float f2) {
        draw(canvas, paint, f2);
    }

    /* access modifiers changed from: package-private */
    public int saveAndSetupCanvas(Canvas canvas) {
        int save = canvas.save();
        canvas.concat(this.mMatrix);
        canvas.concat(this.mTransform);
        return save;
    }

    /* access modifiers changed from: package-private */
    public void restoreCanvas(Canvas canvas, int i) {
        canvas.restoreToCount(i);
    }

    @ReactProp(name = "name")
    public void setName(String str) {
        this.mName = str;
        invalidate();
    }

    @ReactProp(name = "mask")
    public void setMask(String str) {
        this.mMask = str;
        invalidate();
    }

    @ReactProp(name = "clipPath")
    public void setClipPath(String str) {
        this.mCachedClipPath = null;
        this.mClipPath = str;
        invalidate();
    }

    @ReactProp(defaultInt = 1, name = "clipRule")
    public void setClipRule(int i) {
        this.mClipRule = i;
        invalidate();
    }

    @ReactProp(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(float f2) {
        this.mOpacity = f2;
        invalidate();
    }

    @ReactProp(name = "matrix")
    public void setMatrix(Dynamic dynamic) {
        ReadableType type = dynamic.getType();
        if (dynamic.isNull() || !type.equals(ReadableType.Array)) {
            this.mMatrix = null;
            this.mInvMatrix = null;
            this.mInvertible = false;
        } else {
            int a2 = q.a(dynamic.asArray(), sRawMatrix, this.mScale);
            if (a2 == 6) {
                if (this.mMatrix == null) {
                    this.mMatrix = new Matrix();
                    this.mInvMatrix = new Matrix();
                }
                this.mMatrix.setValues(sRawMatrix);
                this.mInvertible = this.mMatrix.invert(this.mInvMatrix);
            } else if (a2 != -1) {
                FLog.w(ReactConstants.TAG, "RNSVG: Transform matrices must be of size 6");
            }
        }
        super.invalidate();
        clearParentCache();
    }

    @ReactProp(name = "responsible")
    public void setResponsible(boolean z) {
        this.mResponsible = z;
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public Path getClipPath() {
        return this.mCachedClipPath;
    }

    /* access modifiers changed from: package-private */
    public Path getClipPath(Canvas canvas, Paint paint) {
        Path path;
        if (this.mClipPath != null) {
            c cVar = (c) getSvgView().getDefinedClipPath(this.mClipPath);
            if (cVar != null) {
                if (cVar.mClipRule == 0) {
                    path = cVar.getPath(canvas, paint);
                } else {
                    path = cVar.a(canvas, paint, Region.Op.UNION);
                }
                int i = cVar.mClipRule;
                if (i == 0) {
                    path.setFillType(Path.FillType.EVEN_ODD);
                } else if (i != 1) {
                    FLog.w(ReactConstants.TAG, "RNSVG: clipRule: " + this.mClipRule + " unrecognized");
                }
                this.mCachedClipPath = path;
            } else {
                FLog.w(ReactConstants.TAG, "RNSVG: Undefined clipPath: " + this.mClipPath);
            }
        }
        return getClipPath();
    }

    /* access modifiers changed from: package-private */
    public void clip(Canvas canvas, Paint paint) {
        Path clipPath = getClipPath(canvas, paint);
        if (clipPath != null) {
            canvas.clipPath(clipPath);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isResponsible() {
        return this.mResponsible;
    }

    /* access modifiers changed from: package-private */
    public SvgView getSvgView() {
        SvgView svgView2 = this.svgView;
        if (svgView2 != null) {
            return svgView2;
        }
        ViewParent parent = getParent();
        if (parent == null) {
            return null;
        }
        if (parent instanceof SvgView) {
            this.svgView = (SvgView) parent;
        } else if (parent instanceof VirtualView) {
            this.svgView = ((VirtualView) parent).getSvgView();
        } else {
            FLog.e(ReactConstants.TAG, "RNSVG: " + getClass().getName() + " should be descendant of a SvgView.");
        }
        return this.svgView;
    }

    /* access modifiers changed from: package-private */
    public double relativeOnWidth(u uVar) {
        double d2;
        double canvasWidth2;
        v vVar = uVar.f14914b;
        if (vVar == v.SVG_LENGTHTYPE_NUMBER) {
            d2 = uVar.f14913a;
            canvasWidth2 = (double) this.mScale;
            Double.isNaN(canvasWidth2);
        } else if (vVar != v.SVG_LENGTHTYPE_PERCENTAGE) {
            return fromRelativeFast(uVar);
        } else {
            d2 = uVar.f14913a / 100.0d;
            canvasWidth2 = (double) getCanvasWidth();
            Double.isNaN(canvasWidth2);
        }
        return d2 * canvasWidth2;
    }

    /* access modifiers changed from: package-private */
    public double relativeOnHeight(u uVar) {
        double d2;
        double canvasHeight2;
        v vVar = uVar.f14914b;
        if (vVar == v.SVG_LENGTHTYPE_NUMBER) {
            d2 = uVar.f14913a;
            canvasHeight2 = (double) this.mScale;
            Double.isNaN(canvasHeight2);
        } else if (vVar != v.SVG_LENGTHTYPE_PERCENTAGE) {
            return fromRelativeFast(uVar);
        } else {
            d2 = uVar.f14913a / 100.0d;
            canvasHeight2 = (double) getCanvasHeight();
            Double.isNaN(canvasHeight2);
        }
        return d2 * canvasHeight2;
    }

    /* access modifiers changed from: package-private */
    public double relativeOnOther(u uVar) {
        double d2;
        double canvasDiagonal2;
        v vVar = uVar.f14914b;
        if (vVar == v.SVG_LENGTHTYPE_NUMBER) {
            d2 = uVar.f14913a;
            canvasDiagonal2 = (double) this.mScale;
            Double.isNaN(canvasDiagonal2);
        } else if (vVar != v.SVG_LENGTHTYPE_PERCENTAGE) {
            return fromRelativeFast(uVar);
        } else {
            d2 = uVar.f14913a / 100.0d;
            canvasDiagonal2 = getCanvasDiagonal();
        }
        return d2 * canvasDiagonal2;
    }

    private double fromRelativeFast(u uVar) {
        double d2;
        switch (uVar.f14914b) {
            case SVG_LENGTHTYPE_EMS:
                d2 = getFontSizeFromContext();
                break;
            case SVG_LENGTHTYPE_EXS:
                d2 = getFontSizeFromContext() / 2.0d;
                break;
            case SVG_LENGTHTYPE_CM:
                d2 = 35.43307d;
                break;
            case SVG_LENGTHTYPE_MM:
                d2 = 3.543307d;
                break;
            case SVG_LENGTHTYPE_IN:
                d2 = 90.0d;
                break;
            case SVG_LENGTHTYPE_PT:
                d2 = 1.25d;
                break;
            case SVG_LENGTHTYPE_PC:
                d2 = 15.0d;
                break;
            default:
                d2 = 1.0d;
                break;
        }
        double d3 = uVar.f14913a * d2;
        double d4 = (double) this.mScale;
        Double.isNaN(d4);
        return d3 * d4;
    }

    private float getCanvasWidth() {
        float f2 = this.canvasWidth;
        if (f2 != -1.0f) {
            return f2;
        }
        j textRoot = getTextRoot();
        if (textRoot == null) {
            this.canvasWidth = (float) getSvgView().getCanvasBounds().width();
        } else {
            this.canvasWidth = textRoot.a().h();
        }
        return this.canvasWidth;
    }

    private float getCanvasHeight() {
        float f2 = this.canvasHeight;
        if (f2 != -1.0f) {
            return f2;
        }
        j textRoot = getTextRoot();
        if (textRoot == null) {
            this.canvasHeight = (float) getSvgView().getCanvasBounds().height();
        } else {
            this.canvasHeight = textRoot.a().i();
        }
        return this.canvasHeight;
    }

    private double getCanvasDiagonal() {
        double d2 = this.canvasDiagonal;
        if (d2 != -1.0d) {
            return d2;
        }
        this.canvasDiagonal = Math.sqrt(Math.pow((double) getCanvasWidth(), 2.0d) + Math.pow((double) getCanvasHeight(), 2.0d)) * M_SQRT1_2l;
        return this.canvasDiagonal;
    }

    /* access modifiers changed from: package-private */
    public void saveDefinition() {
        if (this.mName != null) {
            getSvgView().defineTemplate(this, this.mName);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        RectF rectF = this.mClientRect;
        if (rectF != null) {
            i3 = (int) Math.ceil((double) rectF.width());
        } else {
            i3 = getDefaultSize(getSuggestedMinimumWidth(), i);
        }
        RectF rectF2 = this.mClientRect;
        if (rectF2 != null) {
            i4 = (int) Math.ceil((double) rectF2.height());
        } else {
            i4 = getDefaultSize(getSuggestedMinimumHeight(), i2);
        }
        setMeasuredDimension(i3, i4);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        RectF rectF = this.mClientRect;
        if (rectF != null) {
            if (!(this instanceof j)) {
                setLeft((int) Math.floor((double) rectF.left));
                setTop((int) Math.floor((double) this.mClientRect.top));
                setRight((int) Math.ceil((double) this.mClientRect.right));
                setBottom((int) Math.ceil((double) this.mClientRect.bottom));
            }
            setMeasuredDimension((int) Math.ceil((double) this.mClientRect.width()), (int) Math.ceil((double) this.mClientRect.height()));
        }
    }

    /* access modifiers changed from: package-private */
    public void setClientRect(RectF rectF) {
        RectF rectF2 = this.mClientRect;
        if (rectF2 == null || !rectF2.equals(rectF)) {
            this.mClientRect = rectF;
            RectF rectF3 = this.mClientRect;
            if (rectF3 != null) {
                int floor = (int) Math.floor((double) rectF3.left);
                int floor2 = (int) Math.floor((double) this.mClientRect.top);
                int ceil = (int) Math.ceil((double) this.mClientRect.right);
                int ceil2 = (int) Math.ceil((double) this.mClientRect.bottom);
                int ceil3 = (int) Math.ceil((double) this.mClientRect.width());
                int ceil4 = (int) Math.ceil((double) this.mClientRect.height());
                if (!(this instanceof j)) {
                    setLeft(floor);
                    setTop(floor2);
                    setRight(ceil);
                    setBottom(ceil2);
                }
                setMeasuredDimension(ceil3, ceil4);
                ((UIManagerModule) this.mContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(OnLayoutEvent.obtain(getId(), floor, floor2, ceil3, ceil4));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public RectF getClientRect() {
        return this.mClientRect;
    }
}
