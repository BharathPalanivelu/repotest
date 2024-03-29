package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.Base64;
import android.view.View;
import android.view.ViewParent;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.ReactCompoundView;
import com.facebook.react.uimanager.ReactCompoundViewGroup;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewGroup;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
public class SvgView extends ReactViewGroup implements ReactCompoundView, ReactCompoundViewGroup {
    private String mAlign;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private final Map<String, a> mDefinedBrushes = new HashMap();
    private final Map<String, VirtualView> mDefinedClipPaths = new HashMap();
    private final Map<String, VirtualView> mDefinedMasks = new HashMap();
    private final Map<String, VirtualView> mDefinedTemplates = new HashMap();
    private final Matrix mInvViewBoxMatrix = new Matrix();
    private boolean mInvertible = true;
    private int mMeetOrSlice;
    private float mMinX;
    private float mMinY;
    private boolean mRendered = false;
    private boolean mResponsible = false;
    private final float mScale = DisplayMetricsHolder.getScreenDisplayMetrics().density;
    int mTintColor = 0;
    private float mVbHeight;
    private float mVbWidth;
    private u mbbHeight;
    private u mbbWidth;
    private Runnable toDataUrlTask = null;

    public boolean interceptsTouchEvent(float f2, float f3) {
        return true;
    }

    public enum Events {
        EVENT_DATA_URL("onDataURL");
        
        private final String mName;

        private Events(String str) {
            this.mName = str;
        }

        public String toString() {
            return this.mName;
        }
    }

    public SvgView(ReactContext reactContext) {
        super(reactContext);
    }

    public void setId(int i) {
        super.setId(i);
        SvgViewManager.setSvgView(i, this);
    }

    public void invalidate() {
        super.invalidate();
        ViewParent parent = getParent();
        if (!(parent instanceof VirtualView)) {
            Bitmap bitmap = this.mBitmap;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.mBitmap = null;
        } else if (this.mRendered) {
            this.mRendered = false;
            ((VirtualView) parent).getSvgView().invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!(getParent() instanceof VirtualView)) {
            super.onDraw(canvas);
            if (this.mBitmap == null) {
                this.mBitmap = drawOutput();
            }
            Bitmap bitmap = this.mBitmap;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (Paint) null);
                Runnable runnable = this.toDataUrlTask;
                if (runnable != null) {
                    runnable.run();
                    this.toDataUrlTask = null;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setToDataUrlTask(Runnable runnable) {
        this.toDataUrlTask = runnable;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        invalidate();
    }

    public int reactTagForTouch(float f2, float f3) {
        return hitTest(f2, f3);
    }

    /* access modifiers changed from: package-private */
    public boolean notRendered() {
        return !this.mRendered;
    }

    private void clearChildCache() {
        if (this.mRendered) {
            this.mRendered = false;
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof VirtualView) {
                    ((VirtualView) childAt).clearChildCache();
                }
            }
        }
    }

    @ReactProp(customType = "Color", name = "tintColor")
    public void setTintColor(Integer num) {
        if (num == null) {
            this.mTintColor = 0;
        } else {
            this.mTintColor = num.intValue();
        }
    }

    @ReactProp(name = "minX")
    public void setMinX(float f2) {
        this.mMinX = f2;
        invalidate();
        clearChildCache();
    }

    @ReactProp(name = "minY")
    public void setMinY(float f2) {
        this.mMinY = f2;
        invalidate();
        clearChildCache();
    }

    @ReactProp(name = "vbWidth")
    public void setVbWidth(float f2) {
        this.mVbWidth = f2;
        invalidate();
        clearChildCache();
    }

    @ReactProp(name = "vbHeight")
    public void setVbHeight(float f2) {
        this.mVbHeight = f2;
        invalidate();
        clearChildCache();
    }

    @ReactProp(name = "bbWidth")
    public void setBbWidth(Dynamic dynamic) {
        this.mbbWidth = u.a(dynamic);
        invalidate();
        clearChildCache();
    }

    @ReactProp(name = "bbHeight")
    public void setBbHeight(Dynamic dynamic) {
        this.mbbHeight = u.a(dynamic);
        invalidate();
        clearChildCache();
    }

    @ReactProp(name = "align")
    public void setAlign(String str) {
        this.mAlign = str;
        invalidate();
        clearChildCache();
    }

    @ReactProp(name = "meetOrSlice")
    public void setMeetOrSlice(int i) {
        this.mMeetOrSlice = i;
        invalidate();
        clearChildCache();
    }

    private Bitmap drawOutput() {
        boolean z = true;
        this.mRendered = true;
        float width = (float) getWidth();
        float height = (float) getHeight();
        if (!Float.isNaN(width) && !Float.isNaN(height) && width >= 1.0f && height >= 1.0f && Math.log10((double) width) + Math.log10((double) height) <= 42.0d) {
            z = false;
        }
        if (z) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap((int) width, (int) height, Bitmap.Config.ARGB_8888);
        drawChildren(new Canvas(createBitmap));
        return createBitmap;
    }

    /* access modifiers changed from: package-private */
    public Rect getCanvasBounds() {
        return this.mCanvas.getClipBounds();
    }

    /* access modifiers changed from: package-private */
    public synchronized void drawChildren(Canvas canvas) {
        this.mRendered = true;
        this.mCanvas = canvas;
        if (this.mAlign != null) {
            RectF viewBox = getViewBox();
            float width = (float) canvas.getWidth();
            float height = (float) canvas.getHeight();
            boolean z = getParent() instanceof VirtualView;
            if (z) {
                width = (float) q.a(this.mbbWidth, (double) width, 0.0d, (double) this.mScale, 12.0d);
                height = (float) q.a(this.mbbHeight, (double) height, 0.0d, (double) this.mScale, 12.0d);
            }
            RectF rectF = new RectF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, width, height);
            if (z) {
                canvas.clipRect(rectF);
            }
            Matrix a2 = ac.a(viewBox, rectF, this.mAlign, this.mMeetOrSlice);
            this.mInvertible = a2.invert(this.mInvViewBoxMatrix);
            canvas.concat(a2);
        }
        Paint paint = new Paint();
        paint.setFlags(385);
        paint.setTypeface(Typeface.DEFAULT);
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof VirtualView) {
                ((VirtualView) childAt).saveDefinition();
            }
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt2 = getChildAt(i2);
            if (childAt2 instanceof VirtualView) {
                VirtualView virtualView = (VirtualView) childAt2;
                int saveAndSetupCanvas = virtualView.saveAndSetupCanvas(canvas);
                virtualView.render(canvas, paint, 1.0f);
                virtualView.restoreCanvas(canvas, saveAndSetupCanvas);
                if (virtualView.isResponsible() && !this.mResponsible) {
                    this.mResponsible = true;
                }
            }
        }
    }

    private RectF getViewBox() {
        float f2 = this.mMinX;
        float f3 = this.mScale;
        float f4 = this.mMinY;
        return new RectF(f2 * f3, f4 * f3, (f2 + this.mVbWidth) * f3, (f4 + this.mVbHeight) * f3);
    }

    /* access modifiers changed from: package-private */
    public String toDataURL() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        clearChildCache();
        drawChildren(new Canvas(createBitmap));
        clearChildCache();
        invalidate();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        createBitmap.recycle();
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    /* access modifiers changed from: package-private */
    public String toDataURL(int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        clearChildCache();
        drawChildren(new Canvas(createBitmap));
        clearChildCache();
        invalidate();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        createBitmap.recycle();
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    /* access modifiers changed from: package-private */
    public void enableTouchEvents() {
        if (!this.mResponsible) {
            this.mResponsible = true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isResponsible() {
        return this.mResponsible;
    }

    private int hitTest(float f2, float f3) {
        if (!this.mResponsible || !this.mInvertible) {
            return getId();
        }
        float[] fArr = {f2, f3};
        this.mInvViewBoxMatrix.mapPoints(fArr);
        int i = -1;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt instanceof VirtualView) {
                i = ((VirtualView) childAt).hitTest(fArr);
            } else if (childAt instanceof SvgView) {
                i = ((SvgView) childAt).hitTest(f2, f3);
            }
            if (i != -1) {
                break;
            }
        }
        if (i == -1) {
            return getId();
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public void defineClipPath(VirtualView virtualView, String str) {
        this.mDefinedClipPaths.put(str, virtualView);
    }

    /* access modifiers changed from: package-private */
    public VirtualView getDefinedClipPath(String str) {
        return this.mDefinedClipPaths.get(str);
    }

    /* access modifiers changed from: package-private */
    public void defineTemplate(VirtualView virtualView, String str) {
        this.mDefinedTemplates.put(str, virtualView);
    }

    /* access modifiers changed from: package-private */
    public VirtualView getDefinedTemplate(String str) {
        return this.mDefinedTemplates.get(str);
    }

    /* access modifiers changed from: package-private */
    public void defineBrush(a aVar, String str) {
        this.mDefinedBrushes.put(str, aVar);
    }

    /* access modifiers changed from: package-private */
    public a getDefinedBrush(String str) {
        return this.mDefinedBrushes.get(str);
    }

    /* access modifiers changed from: package-private */
    public void defineMask(VirtualView virtualView, String str) {
        this.mDefinedMasks.put(str, virtualView);
    }

    /* access modifiers changed from: package-private */
    public VirtualView getDefinedMask(String str) {
        return this.mDefinedMasks.get(str);
    }
}
