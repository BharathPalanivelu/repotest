package com.horcrux.svg;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class RenderableView extends VirtualView {
    private static final int CAP_BUTT = 0;
    static final int CAP_ROUND = 1;
    private static final int CAP_SQUARE = 2;
    private static final int FILL_RULE_EVENODD = 0;
    static final int FILL_RULE_NONZERO = 1;
    private static final int JOIN_BEVEL = 2;
    private static final int JOIN_MITER = 0;
    static final int JOIN_ROUND = 1;
    private static final int VECTOR_EFFECT_DEFAULT = 0;
    private static final int VECTOR_EFFECT_NON_SCALING_STROKE = 1;
    private static final Pattern regex = Pattern.compile("[0-9.-]+");
    public ReadableArray fill;
    public float fillOpacity = 1.0f;
    public Path.FillType fillRule = Path.FillType.WINDING;
    private ArrayList<String> mAttributeList;
    private ArrayList<String> mLastMergedList;
    private ArrayList<Object> mOriginProperties;
    private ArrayList<String> mPropList;
    public ReadableArray stroke;
    public u[] strokeDasharray;
    public float strokeDashoffset = BitmapDescriptorFactory.HUE_RED;
    public Paint.Cap strokeLinecap = Paint.Cap.ROUND;
    public Paint.Join strokeLinejoin = Paint.Join.ROUND;
    public float strokeMiterlimit = 4.0f;
    public float strokeOpacity = 1.0f;
    public u strokeWidth = new u(1.0d);
    public int vectorEffect = 0;

    private static double saturate(double d2) {
        if (d2 <= 0.0d) {
            return 0.0d;
        }
        if (d2 >= 1.0d) {
            return 1.0d;
        }
        return d2;
    }

    /* access modifiers changed from: package-private */
    public abstract Path getPath(Canvas canvas, Paint paint);

    RenderableView(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "vectorEffect")
    public void setVectorEffect(int i) {
        this.vectorEffect = i;
        invalidate();
    }

    @ReactProp(name = "fill")
    public void setFill(Dynamic dynamic) {
        if (dynamic == null || dynamic.isNull()) {
            this.fill = null;
            invalidate();
            return;
        }
        if (dynamic.getType().equals(ReadableType.Array)) {
            this.fill = dynamic.asArray();
        } else {
            JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
            int i = 0;
            javaOnlyArray.pushInt(0);
            Matcher matcher = regex.matcher(dynamic.asString());
            while (matcher.find()) {
                double parseDouble = Double.parseDouble(matcher.group());
                int i2 = i + 1;
                if (i < 3) {
                    parseDouble /= 255.0d;
                }
                javaOnlyArray.pushDouble(parseDouble);
                i = i2;
            }
            this.fill = javaOnlyArray;
        }
        invalidate();
    }

    @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
    public void setFillOpacity(float f2) {
        this.fillOpacity = f2;
        invalidate();
    }

    @ReactProp(defaultInt = 1, name = "fillRule")
    public void setFillRule(int i) {
        if (i == 0) {
            this.fillRule = Path.FillType.EVEN_ODD;
        } else if (i != 1) {
            throw new JSApplicationIllegalArgumentException("fillRule " + this.fillRule + " unrecognized");
        }
        invalidate();
    }

    @ReactProp(name = "stroke")
    public void setStroke(Dynamic dynamic) {
        if (dynamic == null || dynamic.isNull()) {
            this.stroke = null;
            invalidate();
            return;
        }
        if (dynamic.getType().equals(ReadableType.Array)) {
            this.stroke = dynamic.asArray();
        } else {
            JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
            javaOnlyArray.pushInt(0);
            Matcher matcher = regex.matcher(dynamic.asString());
            while (matcher.find()) {
                javaOnlyArray.pushDouble(Double.parseDouble(matcher.group()));
            }
            this.stroke = javaOnlyArray;
        }
        invalidate();
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
    public void setStrokeOpacity(float f2) {
        this.strokeOpacity = f2;
        invalidate();
    }

    @ReactProp(name = "strokeDasharray")
    public void setStrokeDasharray(ReadableArray readableArray) {
        if (readableArray != null) {
            int size = readableArray.size();
            this.strokeDasharray = new u[size];
            for (int i = 0; i < size; i++) {
                this.strokeDasharray[i] = u.a(readableArray.getDynamic(i));
            }
        } else {
            this.strokeDasharray = null;
        }
        invalidate();
    }

    @ReactProp(name = "strokeDashoffset")
    public void setStrokeDashoffset(float f2) {
        this.strokeDashoffset = f2 * this.mScale;
        invalidate();
    }

    @ReactProp(name = "strokeWidth")
    public void setStrokeWidth(Dynamic dynamic) {
        this.strokeWidth = u.a(dynamic);
        invalidate();
    }

    @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
    public void setStrokeMiterlimit(float f2) {
        this.strokeMiterlimit = f2;
        invalidate();
    }

    @ReactProp(defaultInt = 1, name = "strokeLinecap")
    public void setStrokeLinecap(int i) {
        if (i == 0) {
            this.strokeLinecap = Paint.Cap.BUTT;
        } else if (i == 1) {
            this.strokeLinecap = Paint.Cap.ROUND;
        } else if (i == 2) {
            this.strokeLinecap = Paint.Cap.SQUARE;
        } else {
            throw new JSApplicationIllegalArgumentException("strokeLinecap " + this.strokeLinecap + " unrecognized");
        }
        invalidate();
    }

    @ReactProp(defaultInt = 1, name = "strokeLinejoin")
    public void setStrokeLinejoin(int i) {
        if (i == 0) {
            this.strokeLinejoin = Paint.Join.MITER;
        } else if (i == 1) {
            this.strokeLinejoin = Paint.Join.ROUND;
        } else if (i == 2) {
            this.strokeLinejoin = Paint.Join.BEVEL;
        } else {
            throw new JSApplicationIllegalArgumentException("strokeLinejoin " + this.strokeLinejoin + " unrecognized");
        }
        invalidate();
    }

    @ReactProp(name = "propList")
    public void setPropList(ReadableArray readableArray) {
        if (readableArray != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            this.mAttributeList = arrayList;
            this.mPropList = arrayList;
            for (int i = 0; i < readableArray.size(); i++) {
                this.mPropList.add(readableArray.getString(i));
            }
        }
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void render(Canvas canvas, Paint paint, float f2) {
        Paint paint2 = paint;
        n nVar = this.mMask != null ? (n) getSvgView().getDefinedMask(this.mMask) : null;
        if (nVar != null) {
            Rect clipBounds = canvas.getClipBounds();
            int height = clipBounds.height();
            int width = clipBounds.width();
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Bitmap createBitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Bitmap createBitmap3 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap2);
            Canvas canvas3 = new Canvas(createBitmap);
            Canvas canvas4 = new Canvas(createBitmap3);
            int i = width;
            canvas3.clipRect((float) relativeOnWidth(nVar.f14879b), (float) relativeOnWidth(nVar.f14880c), (float) relativeOnWidth(nVar.f14881d), (float) relativeOnWidth(nVar.f14882e));
            Paint paint3 = new Paint(1);
            nVar.draw(canvas3, paint3, 1.0f);
            int i2 = i * height;
            int[] iArr = new int[i2];
            Canvas canvas5 = canvas4;
            Canvas canvas6 = canvas2;
            Bitmap bitmap = createBitmap3;
            createBitmap.getPixels(iArr, 0, i, 0, 0, i, height);
            int i3 = 0;
            while (i3 < i2) {
                int i4 = iArr[i3];
                Paint paint4 = paint3;
                double d2 = (double) ((i4 >> 16) & 255);
                Double.isNaN(d2);
                double d3 = (double) ((i4 >> 8) & 255);
                Double.isNaN(d3);
                double d4 = (double) (i4 & 255);
                Double.isNaN(d4);
                double saturate = saturate((((d2 * 0.299d) + (d3 * 0.587d)) + (d4 * 0.144d)) / 255.0d);
                double d5 = (double) (i4 >>> 24);
                Double.isNaN(d5);
                iArr[i3] = ((int) (d5 * saturate)) << 24;
                i3++;
                i2 = i2;
                paint3 = paint4;
            }
            createBitmap.setPixels(iArr, 0, i, 0, 0, i, height);
            draw(canvas6, paint2, f2);
            Paint paint5 = paint3;
            paint5.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            Canvas canvas7 = canvas5;
            canvas7.drawBitmap(createBitmap2, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (Paint) null);
            canvas7.drawBitmap(createBitmap, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, paint5);
            canvas.drawBitmap(bitmap, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, paint2);
            return;
        }
        Canvas canvas8 = canvas;
        float f3 = f2;
        draw(canvas, paint, f2);
    }

    /* access modifiers changed from: package-private */
    public void draw(Canvas canvas, Paint paint, float f2) {
        float f3 = f2 * this.mOpacity;
        if (f3 > 0.01f) {
            boolean z = false;
            boolean z2 = this.mPath == null;
            if (z2) {
                this.mPath = getPath(canvas, paint);
                this.mPath.setFillType(this.fillRule);
            }
            if (this.vectorEffect == 1) {
                z = true;
            }
            Path path = this.mPath;
            if (z) {
                path = new Path();
                this.mPath.transform(canvas.getMatrix(), path);
                canvas.setMatrix((Matrix) null);
            }
            RectF rectF = new RectF();
            path.computeBounds(rectF, true);
            this.mBox = new RectF(rectF);
            new Matrix(canvas.getMatrix()).mapRect(rectF);
            setClientRect(rectF);
            clip(canvas, paint);
            if (setupFillPaint(paint, this.fillOpacity * f3)) {
                if (z2) {
                    this.mFillPath = new Path();
                    paint.getFillPath(path, this.mFillPath);
                }
                canvas.drawPath(path, paint);
            }
            if (setupStrokePaint(paint, f3 * this.strokeOpacity)) {
                if (z2) {
                    this.mStrokePath = new Path();
                    paint.getFillPath(path, this.mStrokePath);
                }
                canvas.drawPath(path, paint);
            }
        }
    }

    private boolean setupFillPaint(Paint paint, float f2) {
        ReadableArray readableArray = this.fill;
        if (readableArray == null || readableArray.size() <= 0) {
            return false;
        }
        paint.reset();
        paint.setFlags(385);
        paint.setStyle(Paint.Style.FILL);
        setupPaint(paint, f2, this.fill);
        return true;
    }

    private boolean setupStrokePaint(Paint paint, float f2) {
        paint.reset();
        double relativeOnOther = relativeOnOther(this.strokeWidth);
        if (relativeOnOther != 0.0d) {
            ReadableArray readableArray = this.stroke;
            if (!(readableArray == null || readableArray.size() == 0)) {
                paint.setFlags(385);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeCap(this.strokeLinecap);
                paint.setStrokeJoin(this.strokeLinejoin);
                paint.setStrokeMiter(this.strokeMiterlimit * this.mScale);
                paint.setStrokeWidth((float) relativeOnOther);
                setupPaint(paint, f2, this.stroke);
                u[] uVarArr = this.strokeDasharray;
                if (uVarArr == null) {
                    return true;
                }
                int length = uVarArr.length;
                float[] fArr = new float[length];
                for (int i = 0; i < length; i++) {
                    fArr[i] = (float) relativeOnOther(this.strokeDasharray[i]);
                }
                paint.setPathEffect(new DashPathEffect(fArr, this.strokeDashoffset));
                return true;
            }
        }
        return false;
    }

    private void setupPaint(Paint paint, float f2, ReadableArray readableArray) {
        double d2;
        int i = readableArray.getInt(0);
        if (i != 0) {
            if (i == 1) {
                a definedBrush = getSvgView().getDefinedBrush(readableArray.getString(1));
                if (definedBrush != null) {
                    definedBrush.a(paint, this.mBox, this.mScale, f2);
                }
            } else if (i == 2) {
                paint.setColor(getSvgView().mTintColor);
            }
        } else if (readableArray.size() == 2) {
            int i2 = readableArray.getInt(1);
            paint.setColor((Math.round(((float) (i2 >>> 24)) * f2) << 24) | (i2 & 16777215));
        } else {
            if (readableArray.size() > 4) {
                double d3 = readableArray.getDouble(4);
                double d4 = (double) f2;
                Double.isNaN(d4);
                d2 = d3 * d4 * 255.0d;
            } else {
                d2 = (double) (f2 * 255.0f);
            }
            paint.setARGB((int) d2, (int) (readableArray.getDouble(1) * 255.0d), (int) (readableArray.getDouble(2) * 255.0d), (int) (readableArray.getDouble(3) * 255.0d));
        }
    }

    /* access modifiers changed from: package-private */
    public int hitTest(float[] fArr) {
        if (this.mPath != null && this.mInvertible && this.mTransformInvertible) {
            float[] fArr2 = new float[2];
            this.mInvMatrix.mapPoints(fArr2, fArr);
            this.mInvTransform.mapPoints(fArr2);
            int round = Math.round(fArr2[0]);
            int round2 = Math.round(fArr2[1]);
            if (this.mRegion == null && this.mFillPath != null) {
                this.mRegion = getRegion(this.mFillPath);
            }
            if (this.mRegion == null && this.mPath != null) {
                this.mRegion = getRegion(this.mPath);
            }
            if (this.mStrokeRegion == null && this.mStrokePath != null) {
                this.mStrokeRegion = getRegion(this.mStrokePath);
            }
            if ((this.mRegion != null && this.mRegion.contains(round, round2)) || (this.mStrokeRegion != null && this.mStrokeRegion.contains(round, round2))) {
                Path clipPath = getClipPath();
                if (clipPath != null) {
                    if (this.mClipRegionPath != clipPath) {
                        this.mClipRegionPath = clipPath;
                        this.mClipRegion = getRegion(clipPath);
                    }
                    if (!this.mClipRegion.contains(round, round2)) {
                        return -1;
                    }
                }
                return getId();
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public Region getRegion(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        Region region = new Region();
        region.setPath(path, new Region((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom)));
        return region;
    }

    private ArrayList<String> getAttributeList() {
        return this.mAttributeList;
    }

    /* access modifiers changed from: package-private */
    public void mergeProperties(RenderableView renderableView) {
        ArrayList<String> attributeList = renderableView.getAttributeList();
        if (attributeList != null && attributeList.size() != 0) {
            this.mOriginProperties = new ArrayList<>();
            ArrayList<String> arrayList = this.mPropList;
            this.mAttributeList = arrayList == null ? new ArrayList<>() : new ArrayList<>(arrayList);
            int i = 0;
            int size = attributeList.size();
            while (i < size) {
                try {
                    String str = attributeList.get(i);
                    Field field = getClass().getField(str);
                    Object obj = field.get(renderableView);
                    this.mOriginProperties.add(field.get(this));
                    if (!hasOwnProperty(str)) {
                        this.mAttributeList.add(str);
                        field.set(this, obj);
                    }
                    i++;
                } catch (Exception e2) {
                    throw new IllegalStateException(e2);
                }
            }
            this.mLastMergedList = attributeList;
        }
    }

    /* access modifiers changed from: package-private */
    public void resetProperties() {
        ArrayList<String> arrayList = this.mLastMergedList;
        if (arrayList != null && this.mOriginProperties != null) {
            try {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    getClass().getField(this.mLastMergedList.get(size)).set(this, this.mOriginProperties.get(size));
                }
                this.mLastMergedList = null;
                this.mOriginProperties = null;
                this.mAttributeList = this.mPropList;
            } catch (Exception e2) {
                throw new IllegalStateException(e2);
            }
        }
    }

    private boolean hasOwnProperty(String str) {
        ArrayList<String> arrayList = this.mAttributeList;
        return arrayList != null && arrayList.contains(str);
    }
}
