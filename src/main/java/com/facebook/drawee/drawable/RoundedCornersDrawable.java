package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Arrays;

public class RoundedCornersDrawable extends ForwardingDrawable implements Rounded {
    private int mBorderColor = 0;
    private final Path mBorderPath = new Path();
    @VisibleForTesting
    final float[] mBorderRadii = new float[8];
    private float mBorderWidth = BitmapDescriptorFactory.HUE_RED;
    private final RectF mBounds = new RectF();
    private RectF mInsideBorderBounds;
    private Matrix mInsideBorderTransform;
    private boolean mIsCircle = false;
    private int mOverlayColor = 0;
    private float mPadding = BitmapDescriptorFactory.HUE_RED;
    @VisibleForTesting
    final Paint mPaint = new Paint(1);
    private boolean mPaintFilterBitmap = false;
    private final Path mPath = new Path();
    private final float[] mRadii = new float[8];
    private boolean mScaleDownInsideBorders = false;
    private final RectF mTempRectangle = new RectF();
    @VisibleForTesting
    Type mType = Type.OVERLAY_COLOR;

    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) Preconditions.checkNotNull(drawable));
    }

    public void setType(Type type) {
        this.mType = type;
        invalidateSelf();
    }

    public void setCircle(boolean z) {
        this.mIsCircle = z;
        updatePath();
        invalidateSelf();
    }

    public boolean isCircle() {
        return this.mIsCircle;
    }

    public void setRadius(float f2) {
        Arrays.fill(this.mRadii, f2);
        updatePath();
        invalidateSelf();
    }

    public void setRadii(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.mRadii, BitmapDescriptorFactory.HUE_RED);
        } else {
            Preconditions.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.mRadii, 0, 8);
        }
        updatePath();
        invalidateSelf();
    }

    public float[] getRadii() {
        return this.mRadii;
    }

    public void setOverlayColor(int i) {
        this.mOverlayColor = i;
        invalidateSelf();
    }

    public int getOverlayColor() {
        return this.mOverlayColor;
    }

    public void setBorder(int i, float f2) {
        this.mBorderColor = i;
        this.mBorderWidth = f2;
        updatePath();
        invalidateSelf();
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public void setPadding(float f2) {
        this.mPadding = f2;
        updatePath();
        invalidateSelf();
    }

    public float getPadding() {
        return this.mPadding;
    }

    public void setScaleDownInsideBorders(boolean z) {
        this.mScaleDownInsideBorders = z;
        updatePath();
        invalidateSelf();
    }

    public boolean getScaleDownInsideBorders() {
        return this.mScaleDownInsideBorders;
    }

    public void setPaintFilterBitmap(boolean z) {
        if (this.mPaintFilterBitmap != z) {
            this.mPaintFilterBitmap = z;
            invalidateSelf();
        }
    }

    public boolean getPaintFilterBitmap() {
        return this.mPaintFilterBitmap;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        updatePath();
    }

    private void updatePath() {
        float[] fArr;
        this.mPath.reset();
        this.mBorderPath.reset();
        this.mTempRectangle.set(getBounds());
        RectF rectF = this.mTempRectangle;
        float f2 = this.mPadding;
        rectF.inset(f2, f2);
        this.mPath.addRect(this.mTempRectangle, Path.Direction.CW);
        if (this.mIsCircle) {
            this.mPath.addCircle(this.mTempRectangle.centerX(), this.mTempRectangle.centerY(), Math.min(this.mTempRectangle.width(), this.mTempRectangle.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.mTempRectangle, this.mRadii, Path.Direction.CW);
        }
        RectF rectF2 = this.mTempRectangle;
        float f3 = this.mPadding;
        rectF2.inset(-f3, -f3);
        RectF rectF3 = this.mTempRectangle;
        float f4 = this.mBorderWidth;
        rectF3.inset(f4 / 2.0f, f4 / 2.0f);
        if (this.mIsCircle) {
            this.mBorderPath.addCircle(this.mTempRectangle.centerX(), this.mTempRectangle.centerY(), Math.min(this.mTempRectangle.width(), this.mTempRectangle.height()) / 2.0f, Path.Direction.CW);
        } else {
            int i = 0;
            while (true) {
                fArr = this.mBorderRadii;
                if (i >= fArr.length) {
                    break;
                }
                fArr[i] = (this.mRadii[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                i++;
            }
            this.mBorderPath.addRoundRect(this.mTempRectangle, fArr, Path.Direction.CW);
        }
        RectF rectF4 = this.mTempRectangle;
        float f5 = this.mBorderWidth;
        rectF4.inset((-f5) / 2.0f, (-f5) / 2.0f);
    }

    /* renamed from: com.facebook.drawee.drawable.RoundedCornersDrawable$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$drawee$drawable$RoundedCornersDrawable$Type = new int[Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.facebook.drawee.drawable.RoundedCornersDrawable$Type[] r0 = com.facebook.drawee.drawable.RoundedCornersDrawable.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$drawee$drawable$RoundedCornersDrawable$Type = r0
                int[] r0 = $SwitchMap$com$facebook$drawee$drawable$RoundedCornersDrawable$Type     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.facebook.drawee.drawable.RoundedCornersDrawable$Type r1 = com.facebook.drawee.drawable.RoundedCornersDrawable.Type.CLIPPING     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$facebook$drawee$drawable$RoundedCornersDrawable$Type     // Catch:{ NoSuchFieldError -> 0x001f }
                com.facebook.drawee.drawable.RoundedCornersDrawable$Type r1 = com.facebook.drawee.drawable.RoundedCornersDrawable.Type.OVERLAY_COLOR     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.drawable.RoundedCornersDrawable.AnonymousClass1.<clinit>():void");
        }
    }

    public void draw(Canvas canvas) {
        this.mBounds.set(getBounds());
        int i = AnonymousClass1.$SwitchMap$com$facebook$drawee$drawable$RoundedCornersDrawable$Type[this.mType.ordinal()];
        if (i == 1) {
            int save = canvas.save();
            this.mPath.setFillType(Path.FillType.EVEN_ODD);
            canvas.clipPath(this.mPath);
            super.draw(canvas);
            canvas.restoreToCount(save);
        } else if (i == 2) {
            if (this.mScaleDownInsideBorders) {
                RectF rectF = this.mInsideBorderBounds;
                if (rectF == null) {
                    this.mInsideBorderBounds = new RectF(this.mBounds);
                    this.mInsideBorderTransform = new Matrix();
                } else {
                    rectF.set(this.mBounds);
                }
                RectF rectF2 = this.mInsideBorderBounds;
                float f2 = this.mBorderWidth;
                rectF2.inset(f2, f2);
                this.mInsideBorderTransform.setRectToRect(this.mBounds, this.mInsideBorderBounds, Matrix.ScaleToFit.FILL);
                int save2 = canvas.save();
                canvas.clipRect(this.mBounds);
                canvas.concat(this.mInsideBorderTransform);
                super.draw(canvas);
                canvas.restoreToCount(save2);
            } else {
                super.draw(canvas);
            }
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mOverlayColor);
            this.mPaint.setStrokeWidth(BitmapDescriptorFactory.HUE_RED);
            this.mPaint.setFilterBitmap(getPaintFilterBitmap());
            this.mPath.setFillType(Path.FillType.EVEN_ODD);
            canvas.drawPath(this.mPath, this.mPaint);
            if (this.mIsCircle) {
                float width = ((this.mBounds.width() - this.mBounds.height()) + this.mBorderWidth) / 2.0f;
                float height = ((this.mBounds.height() - this.mBounds.width()) + this.mBorderWidth) / 2.0f;
                if (width > BitmapDescriptorFactory.HUE_RED) {
                    Canvas canvas2 = canvas;
                    canvas2.drawRect(this.mBounds.left, this.mBounds.top, this.mBounds.left + width, this.mBounds.bottom, this.mPaint);
                    canvas2.drawRect(this.mBounds.right - width, this.mBounds.top, this.mBounds.right, this.mBounds.bottom, this.mPaint);
                }
                if (height > BitmapDescriptorFactory.HUE_RED) {
                    Canvas canvas3 = canvas;
                    canvas3.drawRect(this.mBounds.left, this.mBounds.top, this.mBounds.right, this.mBounds.top + height, this.mPaint);
                    canvas3.drawRect(this.mBounds.left, this.mBounds.bottom - height, this.mBounds.right, this.mBounds.bottom, this.mPaint);
                }
            }
        }
        if (this.mBorderColor != 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            this.mPath.setFillType(Path.FillType.EVEN_ODD);
            canvas.drawPath(this.mBorderPath, this.mPaint);
        }
    }
}
