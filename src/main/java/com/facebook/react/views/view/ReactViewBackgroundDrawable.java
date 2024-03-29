package com.facebook.react.views.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.FloatUtil;
import com.facebook.react.uimanager.Spacing;
import com.facebook.yoga.YogaConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Arrays;
import java.util.Locale;

public class ReactViewBackgroundDrawable extends Drawable {
    private static final int ALL_BITS_SET = -1;
    private static final int ALL_BITS_UNSET = 0;
    private static final int DEFAULT_BORDER_ALPHA = 255;
    private static final int DEFAULT_BORDER_COLOR = -16777216;
    private static final int DEFAULT_BORDER_RGB = 0;
    private int mAlpha = 255;
    private Spacing mBorderAlpha;
    private float[] mBorderCornerRadii;
    private Spacing mBorderRGB;
    private float mBorderRadius = Float.NaN;
    private BorderStyle mBorderStyle;
    private Spacing mBorderWidth;
    private Path mCenterDrawPath;
    private int mColor = 0;
    private final Context mContext;
    private PointF mInnerBottomLeftCorner;
    private PointF mInnerBottomRightCorner;
    private Path mInnerClipPathForBorderRadius;
    private RectF mInnerClipTempRectForBorderRadius;
    private PointF mInnerTopLeftCorner;
    private PointF mInnerTopRightCorner;
    private int mLayoutDirection;
    private boolean mNeedUpdatePathForBorderRadius = false;
    private Path mOuterClipPathForBorderRadius;
    private RectF mOuterClipTempRectForBorderRadius;
    private final Paint mPaint = new Paint(1);
    private PathEffect mPathEffectForBorderStyle;
    private Path mPathForBorder;
    private Path mPathForBorderRadiusOutline;
    private RectF mTempRectForBorderRadiusOutline;
    private RectF mTempRectForCenterDrawPath;

    public enum BorderRadiusLocation {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_RIGHT,
        BOTTOM_LEFT,
        TOP_START,
        TOP_END,
        BOTTOM_START,
        BOTTOM_END
    }

    private static int colorFromAlphaAndRGBComponents(float f2, float f3) {
        return ((((int) f2) << 24) & DEFAULT_BORDER_COLOR) | (((int) f3) & 16777215);
    }

    private static int fastBorderCompatibleColorOrZero(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = -1;
        int i10 = (i > 0 ? i5 : -1) & (i2 > 0 ? i6 : -1) & (i3 > 0 ? i7 : -1);
        if (i4 > 0) {
            i9 = i8;
        }
        int i11 = i9 & i10;
        if (i <= 0) {
            i5 = 0;
        }
        if (i2 <= 0) {
            i6 = 0;
        }
        int i12 = i5 | i6;
        if (i3 <= 0) {
            i7 = 0;
        }
        int i13 = i12 | i7;
        if (i4 <= 0) {
            i8 = 0;
        }
        if (i11 == (i13 | i8)) {
            return i11;
        }
        return 0;
    }

    public boolean onResolvedLayoutDirectionChanged(int i) {
        return false;
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    /* renamed from: com.facebook.react.views.view.ReactViewBackgroundDrawable$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$views$view$ReactViewBackgroundDrawable$BorderStyle = new int[BorderStyle.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.facebook.react.views.view.ReactViewBackgroundDrawable$BorderStyle[] r0 = com.facebook.react.views.view.ReactViewBackgroundDrawable.BorderStyle.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$views$view$ReactViewBackgroundDrawable$BorderStyle = r0
                int[] r0 = $SwitchMap$com$facebook$react$views$view$ReactViewBackgroundDrawable$BorderStyle     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.facebook.react.views.view.ReactViewBackgroundDrawable$BorderStyle r1 = com.facebook.react.views.view.ReactViewBackgroundDrawable.BorderStyle.SOLID     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$facebook$react$views$view$ReactViewBackgroundDrawable$BorderStyle     // Catch:{ NoSuchFieldError -> 0x001f }
                com.facebook.react.views.view.ReactViewBackgroundDrawable$BorderStyle r1 = com.facebook.react.views.view.ReactViewBackgroundDrawable.BorderStyle.DASHED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$facebook$react$views$view$ReactViewBackgroundDrawable$BorderStyle     // Catch:{ NoSuchFieldError -> 0x002a }
                com.facebook.react.views.view.ReactViewBackgroundDrawable$BorderStyle r1 = com.facebook.react.views.view.ReactViewBackgroundDrawable.BorderStyle.DOTTED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.view.ReactViewBackgroundDrawable.AnonymousClass1.<clinit>():void");
        }
    }

    private enum BorderStyle {
        SOLID,
        DASHED,
        DOTTED;

        public static PathEffect getPathEffect(BorderStyle borderStyle, float f2) {
            int i = AnonymousClass1.$SwitchMap$com$facebook$react$views$view$ReactViewBackgroundDrawable$BorderStyle[borderStyle.ordinal()];
            if (i == 1) {
                return null;
            }
            if (i == 2) {
                float f3 = f2 * 3.0f;
                return new DashPathEffect(new float[]{f3, f3, f3, f3}, BitmapDescriptorFactory.HUE_RED);
            } else if (i != 3) {
                return null;
            } else {
                return new DashPathEffect(new float[]{f2, f2, f2, f2}, BitmapDescriptorFactory.HUE_RED);
            }
        }
    }

    public ReactViewBackgroundDrawable(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        updatePathEffect();
        if (!hasRoundedBorders()) {
            drawRectangularBackgroundWithBorders(canvas);
        } else {
            drawRoundedBackgroundWithBorders(canvas);
        }
    }

    public boolean hasRoundedBorders() {
        if (!YogaConstants.isUndefined(this.mBorderRadius) && this.mBorderRadius > BitmapDescriptorFactory.HUE_RED) {
            return true;
        }
        float[] fArr = this.mBorderCornerRadii;
        if (fArr != null) {
            for (float f2 : fArr) {
                if (!YogaConstants.isUndefined(f2) && f2 > BitmapDescriptorFactory.HUE_RED) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mNeedUpdatePathForBorderRadius = true;
    }

    public void setAlpha(int i) {
        if (i != this.mAlpha) {
            this.mAlpha = i;
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public int getOpacity() {
        return ColorUtil.getOpacityFromColor(ColorUtil.multiplyColorAlpha(this.mColor, this.mAlpha));
    }

    public void getOutline(Outline outline) {
        if (Build.VERSION.SDK_INT < 21) {
            super.getOutline(outline);
        } else if ((YogaConstants.isUndefined(this.mBorderRadius) || this.mBorderRadius <= BitmapDescriptorFactory.HUE_RED) && this.mBorderCornerRadii == null) {
            outline.setRect(getBounds());
        } else {
            updatePath();
            outline.setConvexPath(this.mPathForBorderRadiusOutline);
        }
    }

    public void setBorderWidth(int i, float f2) {
        if (this.mBorderWidth == null) {
            this.mBorderWidth = new Spacing();
        }
        if (!FloatUtil.floatsEqual(this.mBorderWidth.getRaw(i), f2)) {
            this.mBorderWidth.set(i, f2);
            if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) {
                this.mNeedUpdatePathForBorderRadius = true;
            }
            invalidateSelf();
        }
    }

    public void setBorderColor(int i, float f2, float f3) {
        setBorderRGB(i, f2);
        setBorderAlpha(i, f3);
    }

    private void setBorderRGB(int i, float f2) {
        if (this.mBorderRGB == null) {
            this.mBorderRGB = new Spacing((float) BitmapDescriptorFactory.HUE_RED);
        }
        if (!FloatUtil.floatsEqual(this.mBorderRGB.getRaw(i), f2)) {
            this.mBorderRGB.set(i, f2);
            invalidateSelf();
        }
    }

    private void setBorderAlpha(int i, float f2) {
        if (this.mBorderAlpha == null) {
            this.mBorderAlpha = new Spacing(255.0f);
        }
        if (!FloatUtil.floatsEqual(this.mBorderAlpha.getRaw(i), f2)) {
            this.mBorderAlpha.set(i, f2);
            invalidateSelf();
        }
    }

    public void setBorderStyle(String str) {
        BorderStyle borderStyle;
        if (str == null) {
            borderStyle = null;
        } else {
            borderStyle = BorderStyle.valueOf(str.toUpperCase(Locale.US));
        }
        if (this.mBorderStyle != borderStyle) {
            this.mBorderStyle = borderStyle;
            this.mNeedUpdatePathForBorderRadius = true;
            invalidateSelf();
        }
    }

    public void setRadius(float f2) {
        if (!FloatUtil.floatsEqual(this.mBorderRadius, f2)) {
            this.mBorderRadius = f2;
            this.mNeedUpdatePathForBorderRadius = true;
            invalidateSelf();
        }
    }

    public void setRadius(float f2, int i) {
        if (this.mBorderCornerRadii == null) {
            this.mBorderCornerRadii = new float[8];
            Arrays.fill(this.mBorderCornerRadii, Float.NaN);
        }
        if (!FloatUtil.floatsEqual(this.mBorderCornerRadii[i], f2)) {
            this.mBorderCornerRadii[i] = f2;
            this.mNeedUpdatePathForBorderRadius = true;
            invalidateSelf();
        }
    }

    public float getFullBorderRadius() {
        return YogaConstants.isUndefined(this.mBorderRadius) ? BitmapDescriptorFactory.HUE_RED : this.mBorderRadius;
    }

    public float getBorderRadius(BorderRadiusLocation borderRadiusLocation) {
        return getBorderRadiusOrDefaultTo(Float.NaN, borderRadiusLocation);
    }

    public float getBorderRadiusOrDefaultTo(float f2, BorderRadiusLocation borderRadiusLocation) {
        float[] fArr = this.mBorderCornerRadii;
        if (fArr == null) {
            return f2;
        }
        float f3 = fArr[borderRadiusLocation.ordinal()];
        return YogaConstants.isUndefined(f3) ? f2 : f3;
    }

    public void setColor(int i) {
        this.mColor = i;
        invalidateSelf();
    }

    public int getResolvedLayoutDirection() {
        return this.mLayoutDirection;
    }

    public boolean setResolvedLayoutDirection(int i) {
        if (this.mLayoutDirection == i) {
            return false;
        }
        this.mLayoutDirection = i;
        return onResolvedLayoutDirectionChanged(i);
    }

    @VisibleForTesting
    public int getColor() {
        return this.mColor;
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void drawRoundedBackgroundWithBorders(android.graphics.Canvas r23) {
        /*
            r22 = this;
            r11 = r22
            r12 = r23
            r22.updatePath()
            r23.save()
            int r0 = r11.mColor
            int r1 = r11.mAlpha
            int r0 = com.facebook.react.views.view.ColorUtil.multiplyColorAlpha(r0, r1)
            int r1 = android.graphics.Color.alpha(r0)
            if (r1 == 0) goto L_0x002b
            android.graphics.Paint r1 = r11.mPaint
            r1.setColor(r0)
            android.graphics.Paint r0 = r11.mPaint
            android.graphics.Paint$Style r1 = android.graphics.Paint.Style.FILL
            r0.setStyle(r1)
            android.graphics.Path r0 = r11.mInnerClipPathForBorderRadius
            android.graphics.Paint r1 = r11.mPaint
            r12.drawPath(r0, r1)
        L_0x002b:
            android.graphics.RectF r13 = r22.getDirectionAwareBorderInsets()
            float r0 = r13.top
            r14 = 0
            int r0 = (r0 > r14 ? 1 : (r0 == r14 ? 0 : -1))
            if (r0 > 0) goto L_0x0048
            float r0 = r13.bottom
            int r0 = (r0 > r14 ? 1 : (r0 == r14 ? 0 : -1))
            if (r0 > 0) goto L_0x0048
            float r0 = r13.left
            int r0 = (r0 > r14 ? 1 : (r0 == r14 ? 0 : -1))
            if (r0 > 0) goto L_0x0048
            float r0 = r13.right
            int r0 = (r0 > r14 ? 1 : (r0 == r14 ? 0 : -1))
            if (r0 <= 0) goto L_0x01db
        L_0x0048:
            float r0 = r22.getFullBorderWidth()
            float r1 = r13.top
            int r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r1 != 0) goto L_0x008e
            float r1 = r13.bottom
            int r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r1 != 0) goto L_0x008e
            float r1 = r13.left
            int r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r1 != 0) goto L_0x008e
            float r1 = r13.right
            int r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r1 != 0) goto L_0x008e
            int r1 = (r0 > r14 ? 1 : (r0 == r14 ? 0 : -1))
            if (r1 <= 0) goto L_0x01db
            r1 = 8
            int r1 = r11.getBorderColor(r1)
            android.graphics.Paint r2 = r11.mPaint
            int r3 = r11.mAlpha
            int r1 = com.facebook.react.views.view.ColorUtil.multiplyColorAlpha(r1, r3)
            r2.setColor(r1)
            android.graphics.Paint r1 = r11.mPaint
            android.graphics.Paint$Style r2 = android.graphics.Paint.Style.STROKE
            r1.setStyle(r2)
            android.graphics.Paint r1 = r11.mPaint
            r1.setStrokeWidth(r0)
            android.graphics.Path r0 = r11.mCenterDrawPath
            android.graphics.Paint r1 = r11.mPaint
            r12.drawPath(r0, r1)
            goto L_0x01db
        L_0x008e:
            android.graphics.Paint r0 = r11.mPaint
            android.graphics.Paint$Style r1 = android.graphics.Paint.Style.FILL
            r0.setStyle(r1)
            android.graphics.Path r0 = r11.mOuterClipPathForBorderRadius
            android.graphics.Region$Op r1 = android.graphics.Region.Op.INTERSECT
            r12.clipPath(r0, r1)
            android.graphics.Path r0 = r11.mInnerClipPathForBorderRadius
            android.graphics.Region$Op r1 = android.graphics.Region.Op.DIFFERENCE
            r12.clipPath(r0, r1)
            r0 = 0
            int r1 = r11.getBorderColor(r0)
            r2 = 1
            int r15 = r11.getBorderColor(r2)
            r3 = 2
            int r3 = r11.getBorderColor(r3)
            r4 = 3
            int r16 = r11.getBorderColor(r4)
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 17
            if (r4 < r5) goto L_0x0119
            int r4 = r22.getResolvedLayoutDirection()
            if (r4 != r2) goto L_0x00c4
            r0 = 1
        L_0x00c4:
            r2 = 4
            int r4 = r11.getBorderColor(r2)
            r5 = 5
            int r6 = r11.getBorderColor(r5)
            com.facebook.react.modules.i18nmanager.I18nUtil r7 = com.facebook.react.modules.i18nmanager.I18nUtil.getInstance()
            android.content.Context r8 = r11.mContext
            boolean r7 = r7.doLeftAndRightSwapInRTL(r8)
            if (r7 == 0) goto L_0x00f6
            boolean r2 = r11.isBorderColorDefined(r2)
            if (r2 != 0) goto L_0x00e1
            goto L_0x00e2
        L_0x00e1:
            r1 = r4
        L_0x00e2:
            boolean r2 = r11.isBorderColorDefined(r5)
            if (r2 != 0) goto L_0x00e9
            goto L_0x00ea
        L_0x00e9:
            r3 = r6
        L_0x00ea:
            if (r0 == 0) goto L_0x00ee
            r2 = r3
            goto L_0x00ef
        L_0x00ee:
            r2 = r1
        L_0x00ef:
            if (r0 == 0) goto L_0x00f2
            goto L_0x00f3
        L_0x00f2:
            r1 = r3
        L_0x00f3:
            r17 = r1
            goto L_0x011c
        L_0x00f6:
            if (r0 == 0) goto L_0x00fa
            r7 = r6
            goto L_0x00fb
        L_0x00fa:
            r7 = r4
        L_0x00fb:
            if (r0 == 0) goto L_0x00fe
            goto L_0x00ff
        L_0x00fe:
            r4 = r6
        L_0x00ff:
            boolean r2 = r11.isBorderColorDefined(r2)
            boolean r5 = r11.isBorderColorDefined(r5)
            if (r0 == 0) goto L_0x010b
            r6 = r5
            goto L_0x010c
        L_0x010b:
            r6 = r2
        L_0x010c:
            if (r0 == 0) goto L_0x010f
            goto L_0x0110
        L_0x010f:
            r2 = r5
        L_0x0110:
            if (r6 == 0) goto L_0x0113
            r1 = r7
        L_0x0113:
            if (r2 == 0) goto L_0x0119
            r2 = r1
            r17 = r4
            goto L_0x011c
        L_0x0119:
            r2 = r1
            r17 = r3
        L_0x011c:
            android.graphics.RectF r0 = r11.mOuterClipTempRectForBorderRadius
            float r10 = r0.left
            android.graphics.RectF r0 = r11.mOuterClipTempRectForBorderRadius
            float r9 = r0.right
            android.graphics.RectF r0 = r11.mOuterClipTempRectForBorderRadius
            float r8 = r0.top
            android.graphics.RectF r0 = r11.mOuterClipTempRectForBorderRadius
            float r7 = r0.bottom
            float r0 = r13.left
            int r0 = (r0 > r14 ? 1 : (r0 == r14 ? 0 : -1))
            if (r0 <= 0) goto L_0x015f
            android.graphics.PointF r0 = r11.mInnerTopLeftCorner
            float r5 = r0.x
            android.graphics.PointF r0 = r11.mInnerTopLeftCorner
            float r6 = r0.y
            android.graphics.PointF r0 = r11.mInnerBottomLeftCorner
            float r4 = r0.x
            android.graphics.PointF r0 = r11.mInnerBottomLeftCorner
            float r3 = r0.y
            r0 = r22
            r1 = r23
            r18 = r3
            r3 = r10
            r19 = r4
            r4 = r8
            r20 = r7
            r7 = r19
            r19 = r8
            r8 = r18
            r18 = r9
            r9 = r10
            r21 = r10
            r10 = r20
            r0.drawQuadrilateral(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x0167
        L_0x015f:
            r20 = r7
            r19 = r8
            r18 = r9
            r21 = r10
        L_0x0167:
            float r0 = r13.top
            int r0 = (r0 > r14 ? 1 : (r0 == r14 ? 0 : -1))
            if (r0 <= 0) goto L_0x018d
            android.graphics.PointF r0 = r11.mInnerTopLeftCorner
            float r5 = r0.x
            android.graphics.PointF r0 = r11.mInnerTopLeftCorner
            float r6 = r0.y
            android.graphics.PointF r0 = r11.mInnerTopRightCorner
            float r7 = r0.x
            android.graphics.PointF r0 = r11.mInnerTopRightCorner
            float r8 = r0.y
            r0 = r22
            r1 = r23
            r2 = r15
            r3 = r21
            r4 = r19
            r9 = r18
            r10 = r19
            r0.drawQuadrilateral(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
        L_0x018d:
            float r0 = r13.right
            int r0 = (r0 > r14 ? 1 : (r0 == r14 ? 0 : -1))
            if (r0 <= 0) goto L_0x01b4
            android.graphics.PointF r0 = r11.mInnerTopRightCorner
            float r5 = r0.x
            android.graphics.PointF r0 = r11.mInnerTopRightCorner
            float r6 = r0.y
            android.graphics.PointF r0 = r11.mInnerBottomRightCorner
            float r7 = r0.x
            android.graphics.PointF r0 = r11.mInnerBottomRightCorner
            float r8 = r0.y
            r0 = r22
            r1 = r23
            r2 = r17
            r3 = r18
            r4 = r19
            r9 = r18
            r10 = r20
            r0.drawQuadrilateral(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
        L_0x01b4:
            float r0 = r13.bottom
            int r0 = (r0 > r14 ? 1 : (r0 == r14 ? 0 : -1))
            if (r0 <= 0) goto L_0x01db
            android.graphics.PointF r0 = r11.mInnerBottomLeftCorner
            float r5 = r0.x
            android.graphics.PointF r0 = r11.mInnerBottomLeftCorner
            float r6 = r0.y
            android.graphics.PointF r0 = r11.mInnerBottomRightCorner
            float r7 = r0.x
            android.graphics.PointF r0 = r11.mInnerBottomRightCorner
            float r8 = r0.y
            r0 = r22
            r1 = r23
            r2 = r16
            r3 = r21
            r4 = r20
            r9 = r18
            r10 = r20
            r0.drawQuadrilateral(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
        L_0x01db:
            r23.restore()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.view.ReactViewBackgroundDrawable.drawRoundedBackgroundWithBorders(android.graphics.Canvas):void");
    }

    private void updatePath() {
        if (this.mNeedUpdatePathForBorderRadius) {
            this.mNeedUpdatePathForBorderRadius = false;
            if (this.mInnerClipPathForBorderRadius == null) {
                this.mInnerClipPathForBorderRadius = new Path();
            }
            if (this.mOuterClipPathForBorderRadius == null) {
                this.mOuterClipPathForBorderRadius = new Path();
            }
            if (this.mPathForBorderRadiusOutline == null) {
                this.mPathForBorderRadiusOutline = new Path();
            }
            if (this.mCenterDrawPath == null) {
                this.mCenterDrawPath = new Path();
            }
            if (this.mInnerClipTempRectForBorderRadius == null) {
                this.mInnerClipTempRectForBorderRadius = new RectF();
            }
            if (this.mOuterClipTempRectForBorderRadius == null) {
                this.mOuterClipTempRectForBorderRadius = new RectF();
            }
            if (this.mTempRectForBorderRadiusOutline == null) {
                this.mTempRectForBorderRadiusOutline = new RectF();
            }
            if (this.mTempRectForCenterDrawPath == null) {
                this.mTempRectForCenterDrawPath = new RectF();
            }
            this.mInnerClipPathForBorderRadius.reset();
            this.mOuterClipPathForBorderRadius.reset();
            this.mPathForBorderRadiusOutline.reset();
            this.mCenterDrawPath.reset();
            this.mInnerClipTempRectForBorderRadius.set(getBounds());
            this.mOuterClipTempRectForBorderRadius.set(getBounds());
            this.mTempRectForBorderRadiusOutline.set(getBounds());
            this.mTempRectForCenterDrawPath.set(getBounds());
            float fullBorderWidth = getFullBorderWidth();
            if (fullBorderWidth > BitmapDescriptorFactory.HUE_RED) {
                float f2 = fullBorderWidth * 0.5f;
                this.mTempRectForCenterDrawPath.inset(f2, f2);
            }
            RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
            this.mInnerClipTempRectForBorderRadius.top += directionAwareBorderInsets.top;
            this.mInnerClipTempRectForBorderRadius.bottom -= directionAwareBorderInsets.bottom;
            this.mInnerClipTempRectForBorderRadius.left += directionAwareBorderInsets.left;
            this.mInnerClipTempRectForBorderRadius.right -= directionAwareBorderInsets.right;
            float fullBorderRadius = getFullBorderRadius();
            float borderRadiusOrDefaultTo = getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.TOP_LEFT);
            float borderRadiusOrDefaultTo2 = getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.TOP_RIGHT);
            float borderRadiusOrDefaultTo3 = getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.BOTTOM_LEFT);
            float borderRadiusOrDefaultTo4 = getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.BOTTOM_RIGHT);
            if (Build.VERSION.SDK_INT >= 17) {
                boolean z = getResolvedLayoutDirection() == 1;
                float borderRadius = getBorderRadius(BorderRadiusLocation.TOP_START);
                float borderRadius2 = getBorderRadius(BorderRadiusLocation.TOP_END);
                float borderRadius3 = getBorderRadius(BorderRadiusLocation.BOTTOM_START);
                float borderRadius4 = getBorderRadius(BorderRadiusLocation.BOTTOM_END);
                if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext)) {
                    if (!YogaConstants.isUndefined(borderRadius)) {
                        borderRadiusOrDefaultTo = borderRadius;
                    }
                    if (!YogaConstants.isUndefined(borderRadius2)) {
                        borderRadiusOrDefaultTo2 = borderRadius2;
                    }
                    if (!YogaConstants.isUndefined(borderRadius3)) {
                        borderRadiusOrDefaultTo3 = borderRadius3;
                    }
                    if (!YogaConstants.isUndefined(borderRadius4)) {
                        borderRadiusOrDefaultTo4 = borderRadius4;
                    }
                    float f3 = z ? borderRadiusOrDefaultTo2 : borderRadiusOrDefaultTo;
                    if (z) {
                        borderRadiusOrDefaultTo2 = borderRadiusOrDefaultTo;
                    }
                    float f4 = z ? borderRadiusOrDefaultTo4 : borderRadiusOrDefaultTo3;
                    if (z) {
                        borderRadiusOrDefaultTo4 = borderRadiusOrDefaultTo3;
                    }
                    borderRadiusOrDefaultTo3 = f4;
                    borderRadiusOrDefaultTo = f3;
                } else {
                    float f5 = z ? borderRadius2 : borderRadius;
                    if (!z) {
                        borderRadius = borderRadius2;
                    }
                    float f6 = z ? borderRadius4 : borderRadius3;
                    if (!z) {
                        borderRadius3 = borderRadius4;
                    }
                    if (!YogaConstants.isUndefined(f5)) {
                        borderRadiusOrDefaultTo = f5;
                    }
                    if (!YogaConstants.isUndefined(borderRadius)) {
                        borderRadiusOrDefaultTo2 = borderRadius;
                    }
                    if (!YogaConstants.isUndefined(f6)) {
                        borderRadiusOrDefaultTo3 = f6;
                    }
                    if (!YogaConstants.isUndefined(borderRadius3)) {
                        borderRadiusOrDefaultTo4 = borderRadius3;
                    }
                }
            }
            float max = Math.max(borderRadiusOrDefaultTo - directionAwareBorderInsets.left, BitmapDescriptorFactory.HUE_RED);
            float max2 = Math.max(borderRadiusOrDefaultTo - directionAwareBorderInsets.top, BitmapDescriptorFactory.HUE_RED);
            float max3 = Math.max(borderRadiusOrDefaultTo2 - directionAwareBorderInsets.right, BitmapDescriptorFactory.HUE_RED);
            float max4 = Math.max(borderRadiusOrDefaultTo2 - directionAwareBorderInsets.top, BitmapDescriptorFactory.HUE_RED);
            float max5 = Math.max(borderRadiusOrDefaultTo4 - directionAwareBorderInsets.right, BitmapDescriptorFactory.HUE_RED);
            float max6 = Math.max(borderRadiusOrDefaultTo4 - directionAwareBorderInsets.bottom, BitmapDescriptorFactory.HUE_RED);
            float max7 = Math.max(borderRadiusOrDefaultTo3 - directionAwareBorderInsets.left, BitmapDescriptorFactory.HUE_RED);
            float max8 = Math.max(borderRadiusOrDefaultTo3 - directionAwareBorderInsets.bottom, BitmapDescriptorFactory.HUE_RED);
            float f7 = borderRadiusOrDefaultTo3;
            float f8 = borderRadiusOrDefaultTo4;
            this.mInnerClipPathForBorderRadius.addRoundRect(this.mInnerClipTempRectForBorderRadius, new float[]{max, max2, max3, max4, max5, max6, max7, max8}, Path.Direction.CW);
            this.mOuterClipPathForBorderRadius.addRoundRect(this.mOuterClipTempRectForBorderRadius, new float[]{borderRadiusOrDefaultTo, borderRadiusOrDefaultTo, borderRadiusOrDefaultTo2, borderRadiusOrDefaultTo2, f8, f8, f7, f7}, Path.Direction.CW);
            Spacing spacing = this.mBorderWidth;
            float f9 = spacing != null ? spacing.get(8) / 2.0f : BitmapDescriptorFactory.HUE_RED;
            float f10 = borderRadiusOrDefaultTo + f9;
            float f11 = borderRadiusOrDefaultTo2 + f9;
            float f12 = f8 + f9;
            float f13 = f7 + f9;
            this.mPathForBorderRadiusOutline.addRoundRect(this.mTempRectForBorderRadiusOutline, new float[]{f10, f10, f11, f11, f12, f12, f13, f13}, Path.Direction.CW);
            Path path = this.mCenterDrawPath;
            RectF rectF = this.mTempRectForCenterDrawPath;
            float[] fArr = new float[8];
            fArr[0] = max + (borderRadiusOrDefaultTo > BitmapDescriptorFactory.HUE_RED ? f9 : BitmapDescriptorFactory.HUE_RED);
            fArr[1] = (borderRadiusOrDefaultTo > BitmapDescriptorFactory.HUE_RED ? f9 : BitmapDescriptorFactory.HUE_RED) + max2;
            fArr[2] = (borderRadiusOrDefaultTo2 > BitmapDescriptorFactory.HUE_RED ? f9 : BitmapDescriptorFactory.HUE_RED) + max3;
            fArr[3] = (borderRadiusOrDefaultTo2 > BitmapDescriptorFactory.HUE_RED ? f9 : BitmapDescriptorFactory.HUE_RED) + max4;
            fArr[4] = (f8 > BitmapDescriptorFactory.HUE_RED ? f9 : BitmapDescriptorFactory.HUE_RED) + max5;
            fArr[5] = (f8 > BitmapDescriptorFactory.HUE_RED ? f9 : BitmapDescriptorFactory.HUE_RED) + max6;
            fArr[6] = (f7 > BitmapDescriptorFactory.HUE_RED ? f9 : BitmapDescriptorFactory.HUE_RED) + max7;
            if (f7 <= BitmapDescriptorFactory.HUE_RED) {
                f9 = BitmapDescriptorFactory.HUE_RED;
            }
            fArr[7] = f9 + max8;
            path.addRoundRect(rectF, fArr, Path.Direction.CW);
            if (this.mInnerTopLeftCorner == null) {
                this.mInnerTopLeftCorner = new PointF();
            }
            this.mInnerTopLeftCorner.x = this.mInnerClipTempRectForBorderRadius.left;
            this.mInnerTopLeftCorner.y = this.mInnerClipTempRectForBorderRadius.top;
            getEllipseIntersectionWithLine((double) this.mInnerClipTempRectForBorderRadius.left, (double) this.mInnerClipTempRectForBorderRadius.top, (double) (this.mInnerClipTempRectForBorderRadius.left + (max * 2.0f)), (double) (this.mInnerClipTempRectForBorderRadius.top + (max2 * 2.0f)), (double) this.mOuterClipTempRectForBorderRadius.left, (double) this.mOuterClipTempRectForBorderRadius.top, (double) this.mInnerClipTempRectForBorderRadius.left, (double) this.mInnerClipTempRectForBorderRadius.top, this.mInnerTopLeftCorner);
            if (this.mInnerBottomLeftCorner == null) {
                this.mInnerBottomLeftCorner = new PointF();
            }
            this.mInnerBottomLeftCorner.x = this.mInnerClipTempRectForBorderRadius.left;
            this.mInnerBottomLeftCorner.y = this.mInnerClipTempRectForBorderRadius.bottom;
            getEllipseIntersectionWithLine((double) this.mInnerClipTempRectForBorderRadius.left, (double) (this.mInnerClipTempRectForBorderRadius.bottom - (max8 * 2.0f)), (double) (this.mInnerClipTempRectForBorderRadius.left + (max7 * 2.0f)), (double) this.mInnerClipTempRectForBorderRadius.bottom, (double) this.mOuterClipTempRectForBorderRadius.left, (double) this.mOuterClipTempRectForBorderRadius.bottom, (double) this.mInnerClipTempRectForBorderRadius.left, (double) this.mInnerClipTempRectForBorderRadius.bottom, this.mInnerBottomLeftCorner);
            if (this.mInnerTopRightCorner == null) {
                this.mInnerTopRightCorner = new PointF();
            }
            this.mInnerTopRightCorner.x = this.mInnerClipTempRectForBorderRadius.right;
            this.mInnerTopRightCorner.y = this.mInnerClipTempRectForBorderRadius.top;
            getEllipseIntersectionWithLine((double) (this.mInnerClipTempRectForBorderRadius.right - (max3 * 2.0f)), (double) this.mInnerClipTempRectForBorderRadius.top, (double) this.mInnerClipTempRectForBorderRadius.right, (double) (this.mInnerClipTempRectForBorderRadius.top + (max4 * 2.0f)), (double) this.mOuterClipTempRectForBorderRadius.right, (double) this.mOuterClipTempRectForBorderRadius.top, (double) this.mInnerClipTempRectForBorderRadius.right, (double) this.mInnerClipTempRectForBorderRadius.top, this.mInnerTopRightCorner);
            if (this.mInnerBottomRightCorner == null) {
                this.mInnerBottomRightCorner = new PointF();
            }
            this.mInnerBottomRightCorner.x = this.mInnerClipTempRectForBorderRadius.right;
            this.mInnerBottomRightCorner.y = this.mInnerClipTempRectForBorderRadius.bottom;
            getEllipseIntersectionWithLine((double) (this.mInnerClipTempRectForBorderRadius.right - (max5 * 2.0f)), (double) (this.mInnerClipTempRectForBorderRadius.bottom - (max6 * 2.0f)), (double) this.mInnerClipTempRectForBorderRadius.right, (double) this.mInnerClipTempRectForBorderRadius.bottom, (double) this.mOuterClipTempRectForBorderRadius.right, (double) this.mOuterClipTempRectForBorderRadius.bottom, (double) this.mInnerClipTempRectForBorderRadius.right, (double) this.mInnerClipTempRectForBorderRadius.bottom, this.mInnerBottomRightCorner);
        }
    }

    private static void getEllipseIntersectionWithLine(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, PointF pointF) {
        PointF pointF2 = pointF;
        double d10 = (d2 + d4) / 2.0d;
        double d11 = (d3 + d5) / 2.0d;
        double d12 = d6 - d10;
        double d13 = d7 - d11;
        double abs = Math.abs(d4 - d2) / 2.0d;
        double abs2 = Math.abs(d5 - d3) / 2.0d;
        double d14 = ((d9 - d11) - d13) / ((d8 - d10) - d12);
        double d15 = d13 - (d12 * d14);
        double d16 = abs2 * abs2;
        double d17 = abs * abs;
        double d18 = d16 + (d17 * d14 * d14);
        double d19 = abs * 2.0d * abs * d15 * d14;
        double d20 = (-(d17 * ((d15 * d15) - d16))) / d18;
        double d21 = d18 * 2.0d;
        double sqrt = ((-d19) / d21) - Math.sqrt(d20 + Math.pow(d19 / d21, 2.0d));
        double d22 = (d14 * sqrt) + d15;
        double d23 = sqrt + d10;
        double d24 = d22 + d11;
        if (!Double.isNaN(d23) && !Double.isNaN(d24)) {
            PointF pointF3 = pointF;
            pointF3.x = (float) d23;
            pointF3.y = (float) d24;
        }
    }

    public float getBorderWidthOrDefaultTo(float f2, int i) {
        Spacing spacing = this.mBorderWidth;
        if (spacing == null) {
            return f2;
        }
        float raw = spacing.getRaw(i);
        return YogaConstants.isUndefined(raw) ? f2 : raw;
    }

    private void updatePathEffect() {
        BorderStyle borderStyle = this.mBorderStyle;
        this.mPathEffectForBorderStyle = borderStyle != null ? BorderStyle.getPathEffect(borderStyle, getFullBorderWidth()) : null;
        this.mPaint.setPathEffect(this.mPathEffectForBorderStyle);
    }

    public float getFullBorderWidth() {
        Spacing spacing = this.mBorderWidth;
        return (spacing == null || YogaConstants.isUndefined(spacing.getRaw(8))) ? BitmapDescriptorFactory.HUE_RED : this.mBorderWidth.getRaw(8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x013a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void drawRectangularBackgroundWithBorders(android.graphics.Canvas r25) {
        /*
            r24 = this;
            r11 = r24
            int r0 = r11.mColor
            int r1 = r11.mAlpha
            int r0 = com.facebook.react.views.view.ColorUtil.multiplyColorAlpha(r0, r1)
            int r1 = android.graphics.Color.alpha(r0)
            if (r1 == 0) goto L_0x0028
            android.graphics.Paint r1 = r11.mPaint
            r1.setColor(r0)
            android.graphics.Paint r0 = r11.mPaint
            android.graphics.Paint$Style r1 = android.graphics.Paint.Style.FILL
            r0.setStyle(r1)
            android.graphics.Rect r0 = r24.getBounds()
            android.graphics.Paint r1 = r11.mPaint
            r12 = r25
            r12.drawRect(r0, r1)
            goto L_0x002a
        L_0x0028:
            r12 = r25
        L_0x002a:
            android.graphics.RectF r0 = r24.getDirectionAwareBorderInsets()
            float r1 = r0.left
            int r13 = java.lang.Math.round(r1)
            float r1 = r0.top
            int r14 = java.lang.Math.round(r1)
            float r1 = r0.right
            int r15 = java.lang.Math.round(r1)
            float r0 = r0.bottom
            int r16 = java.lang.Math.round(r0)
            if (r13 > 0) goto L_0x004e
            if (r15 > 0) goto L_0x004e
            if (r14 > 0) goto L_0x004e
            if (r16 <= 0) goto L_0x0137
        L_0x004e:
            android.graphics.Rect r0 = r24.getBounds()
            r1 = 0
            int r2 = r11.getBorderColor(r1)
            r10 = 1
            int r17 = r11.getBorderColor(r10)
            r3 = 2
            int r3 = r11.getBorderColor(r3)
            r4 = 3
            int r18 = r11.getBorderColor(r4)
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 17
            if (r4 < r5) goto L_0x00cb
            int r4 = r24.getResolvedLayoutDirection()
            if (r4 != r10) goto L_0x0074
            r4 = 1
            goto L_0x0075
        L_0x0074:
            r4 = 0
        L_0x0075:
            r5 = 4
            int r6 = r11.getBorderColor(r5)
            r7 = 5
            int r8 = r11.getBorderColor(r7)
            com.facebook.react.modules.i18nmanager.I18nUtil r9 = com.facebook.react.modules.i18nmanager.I18nUtil.getInstance()
            android.content.Context r10 = r11.mContext
            boolean r9 = r9.doLeftAndRightSwapInRTL(r10)
            if (r9 == 0) goto L_0x00a8
            boolean r5 = r11.isBorderColorDefined(r5)
            if (r5 != 0) goto L_0x0092
            goto L_0x0093
        L_0x0092:
            r2 = r6
        L_0x0093:
            boolean r5 = r11.isBorderColorDefined(r7)
            if (r5 != 0) goto L_0x009a
            goto L_0x009b
        L_0x009a:
            r3 = r8
        L_0x009b:
            if (r4 == 0) goto L_0x009f
            r5 = r3
            goto L_0x00a0
        L_0x009f:
            r5 = r2
        L_0x00a0:
            if (r4 == 0) goto L_0x00a3
            goto L_0x00a4
        L_0x00a3:
            r2 = r3
        L_0x00a4:
            r19 = r2
            r10 = r5
            goto L_0x00ce
        L_0x00a8:
            if (r4 == 0) goto L_0x00ac
            r9 = r8
            goto L_0x00ad
        L_0x00ac:
            r9 = r6
        L_0x00ad:
            if (r4 == 0) goto L_0x00b0
            goto L_0x00b1
        L_0x00b0:
            r6 = r8
        L_0x00b1:
            boolean r5 = r11.isBorderColorDefined(r5)
            boolean r7 = r11.isBorderColorDefined(r7)
            if (r4 == 0) goto L_0x00bd
            r8 = r7
            goto L_0x00be
        L_0x00bd:
            r8 = r5
        L_0x00be:
            if (r4 == 0) goto L_0x00c1
            goto L_0x00c2
        L_0x00c1:
            r5 = r7
        L_0x00c2:
            if (r8 == 0) goto L_0x00c5
            r2 = r9
        L_0x00c5:
            if (r5 == 0) goto L_0x00cb
            r10 = r2
            r19 = r6
            goto L_0x00ce
        L_0x00cb:
            r10 = r2
            r19 = r3
        L_0x00ce:
            int r9 = r0.left
            int r8 = r0.top
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r10
            r7 = r17
            r1 = r8
            r8 = r19
            r12 = r9
            r9 = r18
            int r2 = fastBorderCompatibleColorOrZero(r2, r3, r4, r5, r6, r7, r8, r9)
            if (r2 == 0) goto L_0x013a
            int r3 = android.graphics.Color.alpha(r2)
            if (r3 == 0) goto L_0x0137
            int r8 = r0.right
            int r0 = r0.bottom
            android.graphics.Paint r3 = r11.mPaint
            r3.setColor(r2)
            if (r13 <= 0) goto L_0x0106
            int r9 = r12 + r13
            float r3 = (float) r12
            float r4 = (float) r1
            float r5 = (float) r9
            int r2 = r0 - r16
            float r6 = (float) r2
            android.graphics.Paint r7 = r11.mPaint
            r2 = r25
            r2.drawRect(r3, r4, r5, r6, r7)
        L_0x0106:
            if (r14 <= 0) goto L_0x0117
            int r2 = r1 + r14
            int r9 = r12 + r13
            float r3 = (float) r9
            float r4 = (float) r1
            float r5 = (float) r8
            float r6 = (float) r2
            android.graphics.Paint r7 = r11.mPaint
            r2 = r25
            r2.drawRect(r3, r4, r5, r6, r7)
        L_0x0117:
            if (r15 <= 0) goto L_0x0127
            int r2 = r8 - r15
            float r3 = (float) r2
            int r1 = r1 + r14
            float r4 = (float) r1
            float r5 = (float) r8
            float r6 = (float) r0
            android.graphics.Paint r7 = r11.mPaint
            r2 = r25
            r2.drawRect(r3, r4, r5, r6, r7)
        L_0x0127:
            if (r16 <= 0) goto L_0x0137
            int r1 = r0 - r16
            float r3 = (float) r12
            float r4 = (float) r1
            int r8 = r8 - r15
            float r5 = (float) r8
            float r6 = (float) r0
            android.graphics.Paint r7 = r11.mPaint
            r2 = r25
            r2.drawRect(r3, r4, r5, r6, r7)
        L_0x0137:
            r0 = r11
            goto L_0x01cb
        L_0x013a:
            android.graphics.Paint r2 = r11.mPaint
            r3 = 0
            r2.setAntiAlias(r3)
            int r20 = r0.width()
            int r21 = r0.height()
            if (r13 <= 0) goto L_0x016e
            float r9 = (float) r12
            float r4 = (float) r1
            int r0 = r12 + r13
            float r7 = (float) r0
            int r8 = r1 + r14
            float r6 = (float) r8
            int r8 = r1 + r21
            int r0 = r8 - r16
            float r5 = (float) r0
            float r8 = (float) r8
            r0 = r24
            r3 = r1
            r1 = r25
            r2 = r10
            r10 = r3
            r3 = r9
            r22 = r5
            r5 = r7
            r23 = r8
            r8 = r22
            r11 = r10
            r10 = r23
            r0.drawQuadrilateral(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x016f
        L_0x016e:
            r11 = r1
        L_0x016f:
            if (r14 <= 0) goto L_0x018a
            float r3 = (float) r12
            float r10 = (float) r11
            int r9 = r12 + r13
            float r5 = (float) r9
            int r8 = r11 + r14
            float r8 = (float) r8
            int r9 = r12 + r20
            int r0 = r9 - r15
            float r7 = (float) r0
            float r9 = (float) r9
            r0 = r24
            r1 = r25
            r2 = r17
            r4 = r10
            r6 = r8
            r0.drawQuadrilateral(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
        L_0x018a:
            if (r15 <= 0) goto L_0x01a6
            int r9 = r12 + r20
            float r5 = (float) r9
            float r4 = (float) r11
            int r8 = r11 + r21
            float r6 = (float) r8
            int r9 = r9 - r15
            float r9 = (float) r9
            int r8 = r8 - r16
            float r8 = (float) r8
            int r0 = r11 + r14
            float r10 = (float) r0
            r0 = r24
            r1 = r25
            r2 = r19
            r3 = r5
            r7 = r9
            r0.drawQuadrilateral(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
        L_0x01a6:
            if (r16 <= 0) goto L_0x01c3
            float r3 = (float) r12
            int r8 = r11 + r21
            float r6 = (float) r8
            int r9 = r12 + r20
            float r5 = (float) r9
            int r9 = r9 - r15
            float r7 = (float) r9
            int r8 = r8 - r16
            float r10 = (float) r8
            int r9 = r12 + r13
            float r9 = (float) r9
            r0 = r24
            r1 = r25
            r2 = r18
            r4 = r6
            r8 = r10
            r0.drawQuadrilateral(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x01c5
        L_0x01c3:
            r0 = r24
        L_0x01c5:
            android.graphics.Paint r1 = r0.mPaint
            r2 = 1
            r1.setAntiAlias(r2)
        L_0x01cb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.view.ReactViewBackgroundDrawable.drawRectangularBackgroundWithBorders(android.graphics.Canvas):void");
    }

    private void drawQuadrilateral(Canvas canvas, int i, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        if (i != 0) {
            if (this.mPathForBorder == null) {
                this.mPathForBorder = new Path();
            }
            this.mPaint.setColor(i);
            this.mPathForBorder.reset();
            this.mPathForBorder.moveTo(f2, f3);
            this.mPathForBorder.lineTo(f4, f5);
            this.mPathForBorder.lineTo(f6, f7);
            this.mPathForBorder.lineTo(f8, f9);
            this.mPathForBorder.lineTo(f2, f3);
            canvas.drawPath(this.mPathForBorder, this.mPaint);
        }
    }

    private int getBorderWidth(int i) {
        Spacing spacing = this.mBorderWidth;
        if (spacing == null) {
            return 0;
        }
        float f2 = spacing.get(i);
        if (YogaConstants.isUndefined(f2)) {
            return -1;
        }
        return Math.round(f2);
    }

    private boolean isBorderColorDefined(int i) {
        Spacing spacing = this.mBorderRGB;
        float f2 = Float.NaN;
        float f3 = spacing != null ? spacing.get(i) : Float.NaN;
        Spacing spacing2 = this.mBorderAlpha;
        if (spacing2 != null) {
            f2 = spacing2.get(i);
        }
        return !YogaConstants.isUndefined(f3) && !YogaConstants.isUndefined(f2);
    }

    private int getBorderColor(int i) {
        Spacing spacing = this.mBorderRGB;
        float f2 = spacing != null ? spacing.get(i) : BitmapDescriptorFactory.HUE_RED;
        Spacing spacing2 = this.mBorderAlpha;
        return colorFromAlphaAndRGBComponents(spacing2 != null ? spacing2.get(i) : 255.0f, f2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005b, code lost:
        if (r1 != false) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0072, code lost:
        if (com.facebook.yoga.YogaConstants.isUndefined(r4) == false) goto L_0x0074;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.RectF getDirectionAwareBorderInsets() {
        /*
            r9 = this;
            r0 = 0
            r1 = 8
            float r0 = r9.getBorderWidthOrDefaultTo(r0, r1)
            r1 = 1
            float r2 = r9.getBorderWidthOrDefaultTo(r0, r1)
            r3 = 3
            float r3 = r9.getBorderWidthOrDefaultTo(r0, r3)
            r4 = 0
            float r5 = r9.getBorderWidthOrDefaultTo(r0, r4)
            r6 = 2
            float r0 = r9.getBorderWidthOrDefaultTo(r0, r6)
            int r6 = android.os.Build.VERSION.SDK_INT
            r7 = 17
            if (r6 < r7) goto L_0x0075
            com.facebook.react.uimanager.Spacing r6 = r9.mBorderWidth
            if (r6 == 0) goto L_0x0075
            int r6 = r9.getResolvedLayoutDirection()
            if (r6 != r1) goto L_0x002c
            goto L_0x002d
        L_0x002c:
            r1 = 0
        L_0x002d:
            com.facebook.react.uimanager.Spacing r4 = r9.mBorderWidth
            r6 = 4
            float r4 = r4.getRaw(r6)
            com.facebook.react.uimanager.Spacing r6 = r9.mBorderWidth
            r7 = 5
            float r6 = r6.getRaw(r7)
            com.facebook.react.modules.i18nmanager.I18nUtil r7 = com.facebook.react.modules.i18nmanager.I18nUtil.getInstance()
            android.content.Context r8 = r9.mContext
            boolean r7 = r7.doLeftAndRightSwapInRTL(r8)
            if (r7 == 0) goto L_0x005e
            boolean r7 = com.facebook.yoga.YogaConstants.isUndefined((float) r4)
            if (r7 == 0) goto L_0x004e
            r4 = r5
        L_0x004e:
            boolean r5 = com.facebook.yoga.YogaConstants.isUndefined((float) r6)
            if (r5 == 0) goto L_0x0055
            goto L_0x0056
        L_0x0055:
            r0 = r6
        L_0x0056:
            if (r1 == 0) goto L_0x005a
            r5 = r0
            goto L_0x005b
        L_0x005a:
            r5 = r4
        L_0x005b:
            if (r1 == 0) goto L_0x0075
            goto L_0x0074
        L_0x005e:
            if (r1 == 0) goto L_0x0062
            r7 = r6
            goto L_0x0063
        L_0x0062:
            r7 = r4
        L_0x0063:
            if (r1 == 0) goto L_0x0066
            goto L_0x0067
        L_0x0066:
            r4 = r6
        L_0x0067:
            boolean r1 = com.facebook.yoga.YogaConstants.isUndefined((float) r7)
            if (r1 != 0) goto L_0x006e
            r5 = r7
        L_0x006e:
            boolean r1 = com.facebook.yoga.YogaConstants.isUndefined((float) r4)
            if (r1 != 0) goto L_0x0075
        L_0x0074:
            r0 = r4
        L_0x0075:
            android.graphics.RectF r1 = new android.graphics.RectF
            r1.<init>(r5, r2, r0, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.view.ReactViewBackgroundDrawable.getDirectionAwareBorderInsets():android.graphics.RectF");
    }
}
