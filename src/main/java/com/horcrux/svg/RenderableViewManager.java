package com.horcrux.svg;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.MatrixMathHelper;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.TransformHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.reflect.Array;

class RenderableViewManager extends ViewGroupManager<VirtualView> {
    private static final float CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER = 5.0f;
    private static final double EPSILON = 1.0E-5d;
    private static final int PERSPECTIVE_ARRAY_INVERTED_CAMERA_DISTANCE_INDEX = 2;
    private static final a sMatrixDecompositionContext = new a();
    private static final double[] sTransformDecompositionArray = new double[16];
    private final String mClassName;
    private final c svgClass;

    enum c {
        RNSVGGroup,
        RNSVGPath,
        RNSVGText,
        RNSVGTSpan,
        RNSVGTextPath,
        RNSVGImage,
        RNSVGCircle,
        RNSVGEllipse,
        RNSVGLine,
        RNSVGRect,
        RNSVGClipPath,
        RNSVGDefs,
        RNSVGUse,
        RNSVGSymbol,
        RNSVGLinearGradient,
        RNSVGRadialGradient,
        RNSVGPattern,
        RNSVGMask
    }

    class b extends LayoutShadowNode {
        @ReactPropGroup(names = {"alignSelf", "alignItems", "collapsable", "flex", "flexBasis", "flexDirection", "flexGrow", "flexShrink", "flexWrap", "justifyContent", "overflow", "alignContent", "display", "position", "right", "top", "bottom", "left", "start", "end", "width", "height", "minWidth", "maxWidth", "minHeight", "maxHeight", "margin", "marginVertical", "marginHorizontal", "marginLeft", "marginRight", "marginTop", "marginBottom", "marginStart", "marginEnd", "padding", "paddingVertical", "paddingHorizontal", "paddingLeft", "paddingRight", "paddingTop", "paddingBottom", "paddingStart", "paddingEnd", "borderWidth", "borderStartWidth", "borderEndWidth", "borderTopWidth", "borderBottomWidth", "borderLeftWidth", "borderRightWidth"})
        public void ignoreLayoutProps(int i, Dynamic dynamic) {
        }

        b() {
        }
    }

    public LayoutShadowNode createShadowNodeInstance() {
        return new b();
    }

    public Class<b> getShadowNodeClass() {
        return b.class;
    }

    static class a extends MatrixMathHelper.MatrixDecompositionContext {

        /* renamed from: a  reason: collision with root package name */
        final double[] f14802a = new double[4];

        /* renamed from: b  reason: collision with root package name */
        final double[] f14803b = new double[3];

        /* renamed from: c  reason: collision with root package name */
        final double[] f14804c = new double[3];

        /* renamed from: d  reason: collision with root package name */
        final double[] f14805d = new double[3];

        /* renamed from: e  reason: collision with root package name */
        final double[] f14806e = new double[3];

        a() {
        }
    }

    private static boolean isZero(double d2) {
        return !Double.isNaN(d2) && Math.abs(d2) < EPSILON;
    }

    private static void decomposeMatrix() {
        double[] dArr = sMatrixDecompositionContext.f14802a;
        double[] dArr2 = sMatrixDecompositionContext.f14803b;
        double[] dArr3 = sMatrixDecompositionContext.f14804c;
        double[] dArr4 = sMatrixDecompositionContext.f14805d;
        double[] dArr5 = sMatrixDecompositionContext.f14806e;
        if (!isZero(sTransformDecompositionArray[15])) {
            double[][] dArr6 = (double[][]) Array.newInstance(double.class, new int[]{4, 4});
            double[] dArr7 = new double[16];
            for (int i = 0; i < 4; i++) {
                for (int i2 = 0; i2 < 4; i2++) {
                    double[] dArr8 = sTransformDecompositionArray;
                    int i3 = (i * 4) + i2;
                    double d2 = dArr8[i3] / dArr8[15];
                    dArr6[i][i2] = d2;
                    if (i2 == 3) {
                        d2 = 0.0d;
                    }
                    dArr7[i3] = d2;
                }
            }
            dArr7[15] = 1.0d;
            if (!isZero(MatrixMathHelper.determinant(dArr7))) {
                if (!isZero(dArr6[0][3]) || !isZero(dArr6[1][3]) || !isZero(dArr6[2][3])) {
                    MatrixMathHelper.multiplyVectorByMatrix(new double[]{dArr6[0][3], dArr6[1][3], dArr6[2][3], dArr6[3][3]}, MatrixMathHelper.transpose(MatrixMathHelper.inverse(dArr7)), dArr);
                } else {
                    dArr[2] = 0.0d;
                    dArr[1] = 0.0d;
                    dArr[0] = 0.0d;
                    dArr[3] = 1.0d;
                }
                System.arraycopy(dArr6[3], 0, dArr4, 0, 3);
                double[][] dArr9 = (double[][]) Array.newInstance(double.class, new int[]{3, 3});
                for (int i4 = 0; i4 < 3; i4++) {
                    dArr9[i4][0] = dArr6[i4][0];
                    dArr9[i4][1] = dArr6[i4][1];
                    dArr9[i4][2] = dArr6[i4][2];
                }
                dArr2[0] = MatrixMathHelper.v3Length(dArr9[0]);
                dArr9[0] = MatrixMathHelper.v3Normalize(dArr9[0], dArr2[0]);
                dArr3[0] = MatrixMathHelper.v3Dot(dArr9[0], dArr9[1]);
                dArr9[1] = MatrixMathHelper.v3Combine(dArr9[1], dArr9[0], 1.0d, -dArr3[0]);
                dArr3[0] = MatrixMathHelper.v3Dot(dArr9[0], dArr9[1]);
                dArr9[1] = MatrixMathHelper.v3Combine(dArr9[1], dArr9[0], 1.0d, -dArr3[0]);
                dArr2[1] = MatrixMathHelper.v3Length(dArr9[1]);
                dArr9[1] = MatrixMathHelper.v3Normalize(dArr9[1], dArr2[1]);
                dArr3[0] = dArr3[0] / dArr2[1];
                dArr3[1] = MatrixMathHelper.v3Dot(dArr9[0], dArr9[2]);
                dArr9[2] = MatrixMathHelper.v3Combine(dArr9[2], dArr9[0], 1.0d, -dArr3[1]);
                dArr3[2] = MatrixMathHelper.v3Dot(dArr9[1], dArr9[2]);
                dArr9[2] = MatrixMathHelper.v3Combine(dArr9[2], dArr9[1], 1.0d, -dArr3[2]);
                dArr2[2] = MatrixMathHelper.v3Length(dArr9[2]);
                dArr9[2] = MatrixMathHelper.v3Normalize(dArr9[2], dArr2[2]);
                dArr3[1] = dArr3[1] / dArr2[2];
                dArr3[2] = dArr3[2] / dArr2[2];
                if (MatrixMathHelper.v3Dot(dArr9[0], MatrixMathHelper.v3Cross(dArr9[1], dArr9[2])) < 0.0d) {
                    for (int i5 = 0; i5 < 3; i5++) {
                        dArr2[i5] = dArr2[i5] * -1.0d;
                        double[] dArr10 = dArr9[i5];
                        dArr10[0] = dArr10[0] * -1.0d;
                        double[] dArr11 = dArr9[i5];
                        dArr11[1] = dArr11[1] * -1.0d;
                        double[] dArr12 = dArr9[i5];
                        dArr12[2] = dArr12[2] * -1.0d;
                    }
                }
                dArr5[0] = MatrixMathHelper.roundTo3Places((-Math.atan2(dArr9[2][1], dArr9[2][2])) * 57.29577951308232d);
                dArr5[1] = MatrixMathHelper.roundTo3Places((-Math.atan2(-dArr9[2][0], Math.sqrt((dArr9[2][1] * dArr9[2][1]) + (dArr9[2][2] * dArr9[2][2])))) * 57.29577951308232d);
                dArr5[2] = MatrixMathHelper.roundTo3Places((-Math.atan2(dArr9[1][0], dArr9[0][0])) * 57.29577951308232d);
            }
        }
    }

    private static void setTransformProperty(View view, ReadableArray readableArray) {
        TransformHelper.processTransform(readableArray, sTransformDecompositionArray);
        decomposeMatrix();
        view.setTranslationX(PixelUtil.toPixelFromDIP((float) sMatrixDecompositionContext.f14805d[0]));
        view.setTranslationY(PixelUtil.toPixelFromDIP((float) sMatrixDecompositionContext.f14805d[1]));
        view.setRotation((float) sMatrixDecompositionContext.f14806e[2]);
        view.setRotationX((float) sMatrixDecompositionContext.f14806e[0]);
        view.setRotationY((float) sMatrixDecompositionContext.f14806e[1]);
        view.setScaleX((float) sMatrixDecompositionContext.f14803b[0]);
        view.setScaleY((float) sMatrixDecompositionContext.f14803b[1]);
        double[] dArr = sMatrixDecompositionContext.f14802a;
        if (dArr.length > 2) {
            float f2 = (float) dArr[2];
            if (f2 == BitmapDescriptorFactory.HUE_RED) {
                f2 = 7.8125E-4f;
            }
            float f3 = -1.0f / f2;
            float f4 = DisplayMetricsHolder.getScreenDisplayMetrics().density;
            view.setCameraDistance(f4 * f4 * f3 * CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        }
    }

    private static void resetTransformProperty(View view) {
        view.setTranslationX(PixelUtil.toPixelFromDIP((float) BitmapDescriptorFactory.HUE_RED));
        view.setTranslationY(PixelUtil.toPixelFromDIP((float) BitmapDescriptorFactory.HUE_RED));
        view.setRotation(BitmapDescriptorFactory.HUE_RED);
        view.setRotationX(BitmapDescriptorFactory.HUE_RED);
        view.setRotationY(BitmapDescriptorFactory.HUE_RED);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setCameraDistance(BitmapDescriptorFactory.HUE_RED);
    }

    static class GroupViewManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f2) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f2);
        }

        GroupViewManager() {
            super(c.RNSVGGroup);
        }

        GroupViewManager(c cVar) {
            super(cVar);
        }

        @ReactProp(name = "font")
        public void setFont(j jVar, ReadableMap readableMap) {
            jVar.setFont(readableMap);
        }

        @ReactProp(name = "fontSize")
        public void setFontSize(j jVar, Dynamic dynamic) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            int i = AnonymousClass2.f14800a[dynamic.getType().ordinal()];
            if (i == 1) {
                javaOnlyMap.putDouble(ViewProps.FONT_SIZE, dynamic.asDouble());
            } else if (i == 2) {
                javaOnlyMap.putString(ViewProps.FONT_SIZE, dynamic.asString());
            } else {
                return;
            }
            jVar.setFont(javaOnlyMap);
        }
    }

    static class PathViewManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f2) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f2);
        }

        PathViewManager() {
            super(c.RNSVGPath);
        }

        @ReactProp(name = "d")
        public void setD(o oVar, String str) {
            oVar.setD(str);
        }
    }

    static class TextViewManager extends GroupViewManager {
        TextViewManager() {
            super(c.RNSVGText);
        }

        TextViewManager(c cVar) {
            super(cVar);
        }

        @ReactProp(name = "textLength")
        public void setTextLength(aa aaVar, Dynamic dynamic) {
            aaVar.setTextLength(dynamic);
        }

        @ReactProp(name = "lengthAdjust")
        public void setLengthAdjust(aa aaVar, String str) {
            aaVar.setLengthAdjust(str);
        }

        @ReactProp(name = "alignmentBaseline")
        public void setMethod(aa aaVar, String str) {
            aaVar.setMethod(str);
        }

        @ReactProp(name = "baselineShift")
        public void setBaselineShift(aa aaVar, Dynamic dynamic) {
            aaVar.setBaselineShift(dynamic);
        }

        @ReactProp(name = "verticalAlign")
        public void setVerticalAlign(aa aaVar, String str) {
            aaVar.setVerticalAlign(str);
        }

        @ReactProp(name = "rotate")
        public void setRotate(aa aaVar, Dynamic dynamic) {
            aaVar.setRotate(dynamic);
        }

        @ReactProp(name = "dx")
        public void setDeltaX(aa aaVar, Dynamic dynamic) {
            aaVar.setDeltaX(dynamic);
        }

        @ReactProp(name = "dy")
        public void setDeltaY(aa aaVar, Dynamic dynamic) {
            aaVar.setDeltaY(dynamic);
        }

        @ReactProp(name = "x")
        public void setX(aa aaVar, Dynamic dynamic) {
            aaVar.setPositionX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(aa aaVar, Dynamic dynamic) {
            aaVar.setPositionY(dynamic);
        }

        @ReactProp(name = "font")
        public void setFont(aa aaVar, ReadableMap readableMap) {
            aaVar.setFont(readableMap);
        }
    }

    static class TSpanViewManager extends TextViewManager {
        TSpanViewManager() {
            super(c.RNSVGTSpan);
        }

        @ReactProp(name = "content")
        public void setContent(x xVar, String str) {
            xVar.setContent(str);
        }
    }

    static class TextPathViewManager extends TextViewManager {
        TextPathViewManager() {
            super(c.RNSVGTextPath);
        }

        @ReactProp(name = "href")
        public void setHref(y yVar, String str) {
            yVar.setHref(str);
        }

        @ReactProp(name = "startOffset")
        public void setStartOffset(y yVar, Dynamic dynamic) {
            yVar.setStartOffset(dynamic);
        }

        @ReactProp(name = "method")
        public void setMethod(y yVar, String str) {
            yVar.setMethod(str);
        }

        @ReactProp(name = "spacing")
        public void setSpacing(y yVar, String str) {
            yVar.setSpacing(str);
        }

        @ReactProp(name = "side")
        public void setSide(y yVar, String str) {
            yVar.setSide(str);
        }

        @ReactProp(name = "midLine")
        public void setSharp(y yVar, String str) {
            yVar.setSharp(str);
        }
    }

    static class ImageViewManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f2) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f2);
        }

        ImageViewManager() {
            super(c.RNSVGImage);
        }

        @ReactProp(name = "x")
        public void setX(k kVar, Dynamic dynamic) {
            kVar.setX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(k kVar, Dynamic dynamic) {
            kVar.setY(dynamic);
        }

        @ReactProp(name = "width")
        public void setWidth(k kVar, Dynamic dynamic) {
            kVar.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(k kVar, Dynamic dynamic) {
            kVar.setHeight(dynamic);
        }

        @ReactProp(name = "src")
        public void setSrc(k kVar, ReadableMap readableMap) {
            kVar.setSrc(readableMap);
        }

        @ReactProp(name = "align")
        public void setAlign(k kVar, String str) {
            kVar.setAlign(str);
        }

        @ReactProp(name = "meetOrSlice")
        public void setMeetOrSlice(k kVar, int i) {
            kVar.setMeetOrSlice(i);
        }
    }

    static class CircleViewManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f2) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f2);
        }

        CircleViewManager() {
            super(c.RNSVGCircle);
        }

        @ReactProp(name = "cx")
        public void setCx(b bVar, Dynamic dynamic) {
            bVar.setCx(dynamic);
        }

        @ReactProp(name = "cy")
        public void setCy(b bVar, Dynamic dynamic) {
            bVar.setCy(dynamic);
        }

        @ReactProp(name = "r")
        public void setR(b bVar, Dynamic dynamic) {
            bVar.setR(dynamic);
        }
    }

    static class EllipseViewManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f2) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f2);
        }

        EllipseViewManager() {
            super(c.RNSVGEllipse);
        }

        @ReactProp(name = "cx")
        public void setCx(f fVar, Dynamic dynamic) {
            fVar.setCx(dynamic);
        }

        @ReactProp(name = "cy")
        public void setCy(f fVar, Dynamic dynamic) {
            fVar.setCy(dynamic);
        }

        @ReactProp(name = "rx")
        public void setRx(f fVar, Dynamic dynamic) {
            fVar.setRx(dynamic);
        }

        @ReactProp(name = "ry")
        public void setRy(f fVar, Dynamic dynamic) {
            fVar.setRy(dynamic);
        }
    }

    static class LineViewManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f2) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f2);
        }

        LineViewManager() {
            super(c.RNSVGLine);
        }

        @ReactProp(name = "x1")
        public void setX1(l lVar, Dynamic dynamic) {
            lVar.setX1(dynamic);
        }

        @ReactProp(name = "y1")
        public void setY1(l lVar, Dynamic dynamic) {
            lVar.setY1(dynamic);
        }

        @ReactProp(name = "x2")
        public void setX2(l lVar, Dynamic dynamic) {
            lVar.setX2(dynamic);
        }

        @ReactProp(name = "y2")
        public void setY2(l lVar, Dynamic dynamic) {
            lVar.setY2(dynamic);
        }
    }

    static class RectViewManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f2) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f2);
        }

        RectViewManager() {
            super(c.RNSVGRect);
        }

        @ReactProp(name = "x")
        public void setX(t tVar, Dynamic dynamic) {
            tVar.setX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(t tVar, Dynamic dynamic) {
            tVar.setY(dynamic);
        }

        @ReactProp(name = "width")
        public void setWidth(t tVar, Dynamic dynamic) {
            tVar.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(t tVar, Dynamic dynamic) {
            tVar.setHeight(dynamic);
        }

        @ReactProp(name = "rx")
        public void setRx(t tVar, Dynamic dynamic) {
            tVar.setRx(dynamic);
        }

        @ReactProp(name = "ry")
        public void setRy(t tVar, Dynamic dynamic) {
            tVar.setRy(dynamic);
        }
    }

    static class ClipPathViewManager extends GroupViewManager {
        ClipPathViewManager() {
            super(c.RNSVGClipPath);
        }
    }

    static class DefsViewManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f2) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f2);
        }

        DefsViewManager() {
            super(c.RNSVGDefs);
        }
    }

    static class UseViewManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f2) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f2);
        }

        UseViewManager() {
            super(c.RNSVGUse);
        }

        @ReactProp(name = "href")
        public void setHref(ab abVar, String str) {
            abVar.setHref(str);
        }

        @ReactProp(name = "x")
        public void setX(ab abVar, Dynamic dynamic) {
            abVar.setX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(ab abVar, Dynamic dynamic) {
            abVar.setY(dynamic);
        }

        @ReactProp(name = "width")
        public void setWidth(ab abVar, Dynamic dynamic) {
            abVar.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(ab abVar, Dynamic dynamic) {
            abVar.setHeight(dynamic);
        }
    }

    static class SymbolManager extends GroupViewManager {
        SymbolManager() {
            super(c.RNSVGSymbol);
        }

        @ReactProp(name = "minX")
        public void setMinX(w wVar, float f2) {
            wVar.setMinX(f2);
        }

        @ReactProp(name = "minY")
        public void setMinY(w wVar, float f2) {
            wVar.setMinY(f2);
        }

        @ReactProp(name = "vbWidth")
        public void setVbWidth(w wVar, float f2) {
            wVar.setVbWidth(f2);
        }

        @ReactProp(name = "vbHeight")
        public void setVbHeight(w wVar, float f2) {
            wVar.setVbHeight(f2);
        }

        @ReactProp(name = "align")
        public void setAlign(w wVar, String str) {
            wVar.setAlign(str);
        }

        @ReactProp(name = "meetOrSlice")
        public void setMeetOrSlice(w wVar, int i) {
            wVar.setMeetOrSlice(i);
        }
    }

    static class PatternManager extends GroupViewManager {
        PatternManager() {
            super(c.RNSVGPattern);
        }

        @ReactProp(name = "x")
        public void setX(p pVar, Dynamic dynamic) {
            pVar.setX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(p pVar, Dynamic dynamic) {
            pVar.setY(dynamic);
        }

        @ReactProp(name = "width")
        public void setWidth(p pVar, Dynamic dynamic) {
            pVar.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(p pVar, Dynamic dynamic) {
            pVar.setHeight(dynamic);
        }

        @ReactProp(name = "patternUnits")
        public void setPatternUnits(p pVar, int i) {
            pVar.setPatternUnits(i);
        }

        @ReactProp(name = "patternContentUnits")
        public void setPatternContentUnits(p pVar, int i) {
            pVar.setPatternContentUnits(i);
        }

        @ReactProp(name = "patternTransform")
        public void setPatternTransform(p pVar, ReadableArray readableArray) {
            pVar.setPatternTransform(readableArray);
        }

        @ReactProp(name = "minX")
        public void setMinX(p pVar, float f2) {
            pVar.setMinX(f2);
        }

        @ReactProp(name = "minY")
        public void setMinY(p pVar, float f2) {
            pVar.setMinY(f2);
        }

        @ReactProp(name = "vbWidth")
        public void setVbWidth(p pVar, float f2) {
            pVar.setVbWidth(f2);
        }

        @ReactProp(name = "vbHeight")
        public void setVbHeight(p pVar, float f2) {
            pVar.setVbHeight(f2);
        }

        @ReactProp(name = "align")
        public void setAlign(p pVar, String str) {
            pVar.setAlign(str);
        }

        @ReactProp(name = "meetOrSlice")
        public void setMeetOrSlice(p pVar, int i) {
            pVar.setMeetOrSlice(i);
        }
    }

    static class MaskManager extends GroupViewManager {
        MaskManager() {
            super(c.RNSVGMask);
        }

        @ReactProp(name = "x")
        public void setX(n nVar, Dynamic dynamic) {
            nVar.setX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(n nVar, Dynamic dynamic) {
            nVar.setY(dynamic);
        }

        @ReactProp(name = "width")
        public void setWidth(n nVar, Dynamic dynamic) {
            nVar.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(n nVar, Dynamic dynamic) {
            nVar.setHeight(dynamic);
        }

        @ReactProp(name = "maskUnits")
        public void setMaskUnits(n nVar, int i) {
            nVar.setMaskUnits(i);
        }

        @ReactProp(name = "maskContentUnits")
        public void setMaskContentUnits(n nVar, int i) {
            nVar.setMaskContentUnits(i);
        }

        @ReactProp(name = "maskTransform")
        public void setMaskTransform(n nVar, ReadableArray readableArray) {
            nVar.setMaskTransform(readableArray);
        }
    }

    static class LinearGradientManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f2) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f2);
        }

        LinearGradientManager() {
            super(c.RNSVGLinearGradient);
        }

        @ReactProp(name = "x1")
        public void setX1(m mVar, Dynamic dynamic) {
            mVar.setX1(dynamic);
        }

        @ReactProp(name = "y1")
        public void setY1(m mVar, Dynamic dynamic) {
            mVar.setY1(dynamic);
        }

        @ReactProp(name = "x2")
        public void setX2(m mVar, Dynamic dynamic) {
            mVar.setX2(dynamic);
        }

        @ReactProp(name = "y2")
        public void setY2(m mVar, Dynamic dynamic) {
            mVar.setY2(dynamic);
        }

        @ReactProp(name = "gradient")
        public void setGradient(m mVar, ReadableArray readableArray) {
            mVar.setGradient(readableArray);
        }

        @ReactProp(name = "gradientUnits")
        public void setGradientUnits(m mVar, int i) {
            mVar.setGradientUnits(i);
        }

        @ReactProp(name = "gradientTransform")
        public void setGradientTransform(m mVar, ReadableArray readableArray) {
            mVar.setGradientTransform(readableArray);
        }
    }

    static class RadialGradientManager extends RenderableViewManager {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            RenderableViewManager.super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return RenderableViewManager.super.createShadowNodeInstance();
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return RenderableViewManager.super.createViewInstance(themedReactContext);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            RenderableViewManager.super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f2) {
            RenderableViewManager.super.setOpacity((VirtualView) view, f2);
        }

        RadialGradientManager() {
            super(c.RNSVGRadialGradient);
        }

        @ReactProp(name = "fx")
        public void setFx(s sVar, Dynamic dynamic) {
            sVar.setFx(dynamic);
        }

        @ReactProp(name = "fy")
        public void setFy(s sVar, Dynamic dynamic) {
            sVar.setFy(dynamic);
        }

        @ReactProp(name = "rx")
        public void setRx(s sVar, Dynamic dynamic) {
            sVar.setRx(dynamic);
        }

        @ReactProp(name = "ry")
        public void setRy(s sVar, Dynamic dynamic) {
            sVar.setRy(dynamic);
        }

        @ReactProp(name = "cx")
        public void setCx(s sVar, Dynamic dynamic) {
            sVar.setCx(dynamic);
        }

        @ReactProp(name = "cy")
        public void setCy(s sVar, Dynamic dynamic) {
            sVar.setCy(dynamic);
        }

        @ReactProp(name = "gradient")
        public void setGradient(s sVar, ReadableArray readableArray) {
            sVar.setGradient(readableArray);
        }

        @ReactProp(name = "gradientUnits")
        public void setGradientUnits(s sVar, int i) {
            sVar.setGradientUnits(i);
        }

        @ReactProp(name = "gradientTransform")
        public void setGradientTransform(s sVar, ReadableArray readableArray) {
            sVar.setGradientTransform(readableArray);
        }
    }

    private RenderableViewManager(c cVar) {
        this.svgClass = cVar;
        this.mClassName = cVar.toString();
    }

    public String getName() {
        return this.mClassName;
    }

    @ReactProp(name = "mask")
    public void setMask(VirtualView virtualView, String str) {
        virtualView.setMask(str);
    }

    @ReactProp(name = "clipPath")
    public void setClipPath(VirtualView virtualView, String str) {
        virtualView.setClipPath(str);
    }

    @ReactProp(name = "clipRule")
    public void setClipRule(VirtualView virtualView, int i) {
        virtualView.setClipRule(i);
    }

    @ReactProp(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(VirtualView virtualView, float f2) {
        virtualView.setOpacity(f2);
    }

    @ReactProp(name = "fill")
    public void setFill(RenderableView renderableView, Dynamic dynamic) {
        renderableView.setFill(dynamic);
    }

    @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
    public void setFillOpacity(RenderableView renderableView, float f2) {
        renderableView.setFillOpacity(f2);
    }

    @ReactProp(defaultInt = 1, name = "fillRule")
    public void setFillRule(RenderableView renderableView, int i) {
        renderableView.setFillRule(i);
    }

    @ReactProp(name = "stroke")
    public void setStroke(RenderableView renderableView, Dynamic dynamic) {
        renderableView.setStroke(dynamic);
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
    public void setStrokeOpacity(RenderableView renderableView, float f2) {
        renderableView.setStrokeOpacity(f2);
    }

    @ReactProp(name = "strokeDasharray")
    public void setStrokeDasharray(RenderableView renderableView, ReadableArray readableArray) {
        renderableView.setStrokeDasharray(readableArray);
    }

    @ReactProp(name = "strokeDashoffset")
    public void setStrokeDashoffset(RenderableView renderableView, float f2) {
        renderableView.setStrokeDashoffset(f2);
    }

    @ReactProp(name = "strokeWidth")
    public void setStrokeWidth(RenderableView renderableView, Dynamic dynamic) {
        renderableView.setStrokeWidth(dynamic);
    }

    @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
    public void setStrokeMiterlimit(RenderableView renderableView, float f2) {
        renderableView.setStrokeMiterlimit(f2);
    }

    @ReactProp(defaultInt = 1, name = "strokeLinecap")
    public void setStrokeLinecap(RenderableView renderableView, int i) {
        renderableView.setStrokeLinecap(i);
    }

    @ReactProp(defaultInt = 1, name = "strokeLinejoin")
    public void setStrokeLinejoin(RenderableView renderableView, int i) {
        renderableView.setStrokeLinejoin(i);
    }

    @ReactProp(name = "vectorEffect")
    public void setVectorEffect(RenderableView renderableView, int i) {
        renderableView.setVectorEffect(i);
    }

    @ReactProp(name = "matrix")
    public void setMatrix(VirtualView virtualView, Dynamic dynamic) {
        virtualView.setMatrix(dynamic);
    }

    @ReactProp(name = "transform")
    public void setTransform(VirtualView virtualView, Dynamic dynamic) {
        if (dynamic.getType() == ReadableType.Array) {
            ReadableArray asArray = dynamic.asArray();
            if (asArray == null) {
                resetTransformProperty(virtualView);
            } else {
                setTransformProperty(virtualView, asArray);
            }
            Matrix matrix = virtualView.getMatrix();
            virtualView.mTransform = matrix;
            virtualView.mTransformInvertible = matrix.invert(virtualView.mInvTransform);
        }
    }

    @ReactProp(name = "propList")
    public void setPropList(RenderableView renderableView, ReadableArray readableArray) {
        renderableView.setPropList(readableArray);
    }

    @ReactProp(name = "responsible")
    public void setResponsible(VirtualView virtualView, boolean z) {
        virtualView.setResponsible(z);
    }

    @ReactProp(name = "name")
    public void setName(VirtualView virtualView, String str) {
        virtualView.setName(str);
    }

    /* access modifiers changed from: private */
    public void invalidateSvgView(VirtualView virtualView) {
        SvgView svgView = virtualView.getSvgView();
        if (svgView != null) {
            svgView.invalidate();
        }
        if (virtualView instanceof aa) {
            ((aa) virtualView).k().clearChildCache();
        }
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(ThemedReactContext themedReactContext, VirtualView virtualView) {
        super.addEventEmitters(themedReactContext, virtualView);
        virtualView.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() {
            public void onChildViewAdded(View view, View view2) {
                if (view instanceof VirtualView) {
                    RenderableViewManager.this.invalidateSvgView((VirtualView) view);
                }
            }

            public void onChildViewRemoved(View view, View view2) {
                if (view instanceof VirtualView) {
                    RenderableViewManager.this.invalidateSvgView((VirtualView) view);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(VirtualView virtualView) {
        super.onAfterUpdateTransaction(virtualView);
        invalidateSvgView(virtualView);
    }

    /* renamed from: com.horcrux.svg.RenderableViewManager$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14800a = new int[ReadableType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(40:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|(2:37|38)|39|41|42|(3:43|44|46)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(41:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|41|42|(3:43|44|46)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(43:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|41|42|43|44|46) */
        /* JADX WARNING: Can't wrap try/catch for region: R(44:0|1|2|3|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|41|42|43|44|46) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0035 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00b6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00c2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00ce */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00ed */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002a */
        static {
            /*
                com.horcrux.svg.RenderableViewManager$c[] r0 = com.horcrux.svg.RenderableViewManager.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14801b = r0
                r0 = 1
                int[] r1 = f14801b     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.horcrux.svg.RenderableViewManager$c r2 = com.horcrux.svg.RenderableViewManager.c.RNSVGGroup     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f14801b     // Catch:{ NoSuchFieldError -> 0x001f }
                com.horcrux.svg.RenderableViewManager$c r3 = com.horcrux.svg.RenderableViewManager.c.RNSVGPath     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r2 = f14801b     // Catch:{ NoSuchFieldError -> 0x002a }
                com.horcrux.svg.RenderableViewManager$c r3 = com.horcrux.svg.RenderableViewManager.c.RNSVGCircle     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r2 = f14801b     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.horcrux.svg.RenderableViewManager$c r3 = com.horcrux.svg.RenderableViewManager.c.RNSVGEllipse     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4 = 4
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r2 = f14801b     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.horcrux.svg.RenderableViewManager$c r3 = com.horcrux.svg.RenderableViewManager.c.RNSVGLine     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r4 = 5
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r2 = f14801b     // Catch:{ NoSuchFieldError -> 0x004b }
                com.horcrux.svg.RenderableViewManager$c r3 = com.horcrux.svg.RenderableViewManager.c.RNSVGRect     // Catch:{ NoSuchFieldError -> 0x004b }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r4 = 6
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r2 = f14801b     // Catch:{ NoSuchFieldError -> 0x0056 }
                com.horcrux.svg.RenderableViewManager$c r3 = com.horcrux.svg.RenderableViewManager.c.RNSVGText     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r4 = 7
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                int[] r2 = f14801b     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.horcrux.svg.RenderableViewManager$c r3 = com.horcrux.svg.RenderableViewManager.c.RNSVGTSpan     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r4 = 8
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r2 = f14801b     // Catch:{ NoSuchFieldError -> 0x006e }
                com.horcrux.svg.RenderableViewManager$c r3 = com.horcrux.svg.RenderableViewManager.c.RNSVGTextPath     // Catch:{ NoSuchFieldError -> 0x006e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r4 = 9
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r2 = f14801b     // Catch:{ NoSuchFieldError -> 0x007a }
                com.horcrux.svg.RenderableViewManager$c r3 = com.horcrux.svg.RenderableViewManager.c.RNSVGImage     // Catch:{ NoSuchFieldError -> 0x007a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x007a }
                r4 = 10
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x007a }
            L_0x007a:
                int[] r2 = f14801b     // Catch:{ NoSuchFieldError -> 0x0086 }
                com.horcrux.svg.RenderableViewManager$c r3 = com.horcrux.svg.RenderableViewManager.c.RNSVGClipPath     // Catch:{ NoSuchFieldError -> 0x0086 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0086 }
                r4 = 11
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0086 }
            L_0x0086:
                int[] r2 = f14801b     // Catch:{ NoSuchFieldError -> 0x0092 }
                com.horcrux.svg.RenderableViewManager$c r3 = com.horcrux.svg.RenderableViewManager.c.RNSVGDefs     // Catch:{ NoSuchFieldError -> 0x0092 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0092 }
                r4 = 12
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0092 }
            L_0x0092:
                int[] r2 = f14801b     // Catch:{ NoSuchFieldError -> 0x009e }
                com.horcrux.svg.RenderableViewManager$c r3 = com.horcrux.svg.RenderableViewManager.c.RNSVGUse     // Catch:{ NoSuchFieldError -> 0x009e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x009e }
                r4 = 13
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x009e }
            L_0x009e:
                int[] r2 = f14801b     // Catch:{ NoSuchFieldError -> 0x00aa }
                com.horcrux.svg.RenderableViewManager$c r3 = com.horcrux.svg.RenderableViewManager.c.RNSVGSymbol     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r4 = 14
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                int[] r2 = f14801b     // Catch:{ NoSuchFieldError -> 0x00b6 }
                com.horcrux.svg.RenderableViewManager$c r3 = com.horcrux.svg.RenderableViewManager.c.RNSVGLinearGradient     // Catch:{ NoSuchFieldError -> 0x00b6 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b6 }
                r4 = 15
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00b6 }
            L_0x00b6:
                int[] r2 = f14801b     // Catch:{ NoSuchFieldError -> 0x00c2 }
                com.horcrux.svg.RenderableViewManager$c r3 = com.horcrux.svg.RenderableViewManager.c.RNSVGRadialGradient     // Catch:{ NoSuchFieldError -> 0x00c2 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c2 }
                r4 = 16
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00c2 }
            L_0x00c2:
                int[] r2 = f14801b     // Catch:{ NoSuchFieldError -> 0x00ce }
                com.horcrux.svg.RenderableViewManager$c r3 = com.horcrux.svg.RenderableViewManager.c.RNSVGPattern     // Catch:{ NoSuchFieldError -> 0x00ce }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ce }
                r4 = 17
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00ce }
            L_0x00ce:
                int[] r2 = f14801b     // Catch:{ NoSuchFieldError -> 0x00da }
                com.horcrux.svg.RenderableViewManager$c r3 = com.horcrux.svg.RenderableViewManager.c.RNSVGMask     // Catch:{ NoSuchFieldError -> 0x00da }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00da }
                r4 = 18
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00da }
            L_0x00da:
                com.facebook.react.bridge.ReadableType[] r2 = com.facebook.react.bridge.ReadableType.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f14800a = r2
                int[] r2 = f14800a     // Catch:{ NoSuchFieldError -> 0x00ed }
                com.facebook.react.bridge.ReadableType r3 = com.facebook.react.bridge.ReadableType.Number     // Catch:{ NoSuchFieldError -> 0x00ed }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ed }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x00ed }
            L_0x00ed:
                int[] r0 = f14800a     // Catch:{ NoSuchFieldError -> 0x00f7 }
                com.facebook.react.bridge.ReadableType r2 = com.facebook.react.bridge.ReadableType.String     // Catch:{ NoSuchFieldError -> 0x00f7 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f7 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x00f7 }
            L_0x00f7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.RenderableViewManager.AnonymousClass2.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public VirtualView createViewInstance(ThemedReactContext themedReactContext) {
        switch (this.svgClass) {
            case RNSVGGroup:
                return new j(themedReactContext);
            case RNSVGPath:
                return new o(themedReactContext);
            case RNSVGCircle:
                return new b(themedReactContext);
            case RNSVGEllipse:
                return new f(themedReactContext);
            case RNSVGLine:
                return new l(themedReactContext);
            case RNSVGRect:
                return new t(themedReactContext);
            case RNSVGText:
                return new aa(themedReactContext);
            case RNSVGTSpan:
                return new x(themedReactContext);
            case RNSVGTextPath:
                return new y(themedReactContext);
            case RNSVGImage:
                return new k(themedReactContext);
            case RNSVGClipPath:
                return new c(themedReactContext);
            case RNSVGDefs:
                return new e(themedReactContext);
            case RNSVGUse:
                return new ab(themedReactContext);
            case RNSVGSymbol:
                return new w(themedReactContext);
            case RNSVGLinearGradient:
                return new m(themedReactContext);
            case RNSVGRadialGradient:
                return new s(themedReactContext);
            case RNSVGPattern:
                return new p(themedReactContext);
            case RNSVGMask:
                return new n(themedReactContext);
            default:
                throw new IllegalStateException("Unexpected type " + this.svgClass.toString());
        }
    }
}
