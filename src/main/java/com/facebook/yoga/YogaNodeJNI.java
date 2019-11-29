package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

@DoNotStrip
public class YogaNodeJNI extends YogaNodeJNIBase {
    @DoNotStrip
    private float mBorderBottom = BitmapDescriptorFactory.HUE_RED;
    @DoNotStrip
    private float mBorderLeft = BitmapDescriptorFactory.HUE_RED;
    @DoNotStrip
    private float mBorderRight = BitmapDescriptorFactory.HUE_RED;
    @DoNotStrip
    private float mBorderTop = BitmapDescriptorFactory.HUE_RED;
    @DoNotStrip
    private boolean mDoesLegacyStretchFlagAffectsLayout = false;
    @DoNotStrip
    private boolean mHasNewLayout = true;
    @DoNotStrip
    private float mHeight = Float.NaN;
    @DoNotStrip
    private int mLayoutDirection = 0;
    @DoNotStrip
    private float mLeft = Float.NaN;
    @DoNotStrip
    private float mMarginBottom = BitmapDescriptorFactory.HUE_RED;
    @DoNotStrip
    private float mMarginLeft = BitmapDescriptorFactory.HUE_RED;
    @DoNotStrip
    private float mMarginRight = BitmapDescriptorFactory.HUE_RED;
    @DoNotStrip
    private float mMarginTop = BitmapDescriptorFactory.HUE_RED;
    @DoNotStrip
    private float mPaddingBottom = BitmapDescriptorFactory.HUE_RED;
    @DoNotStrip
    private float mPaddingLeft = BitmapDescriptorFactory.HUE_RED;
    @DoNotStrip
    private float mPaddingRight = BitmapDescriptorFactory.HUE_RED;
    @DoNotStrip
    private float mPaddingTop = BitmapDescriptorFactory.HUE_RED;
    @DoNotStrip
    private float mTop = Float.NaN;
    @DoNotStrip
    private float mWidth = Float.NaN;

    public YogaNodeJNI() {
    }

    public YogaNodeJNI(YogaConfig yogaConfig) {
        super(yogaConfig);
    }

    public void reset() {
        super.reset();
        this.mHasNewLayout = true;
        this.mWidth = Float.NaN;
        this.mHeight = Float.NaN;
        this.mTop = Float.NaN;
        this.mLeft = Float.NaN;
        this.mMarginLeft = BitmapDescriptorFactory.HUE_RED;
        this.mMarginTop = BitmapDescriptorFactory.HUE_RED;
        this.mMarginRight = BitmapDescriptorFactory.HUE_RED;
        this.mMarginBottom = BitmapDescriptorFactory.HUE_RED;
        this.mPaddingLeft = BitmapDescriptorFactory.HUE_RED;
        this.mPaddingTop = BitmapDescriptorFactory.HUE_RED;
        this.mPaddingRight = BitmapDescriptorFactory.HUE_RED;
        this.mPaddingBottom = BitmapDescriptorFactory.HUE_RED;
        this.mBorderLeft = BitmapDescriptorFactory.HUE_RED;
        this.mBorderTop = BitmapDescriptorFactory.HUE_RED;
        this.mBorderRight = BitmapDescriptorFactory.HUE_RED;
        this.mBorderBottom = BitmapDescriptorFactory.HUE_RED;
        this.mLayoutDirection = 0;
        this.mDoesLegacyStretchFlagAffectsLayout = false;
    }

    public boolean hasNewLayout() {
        return this.mHasNewLayout;
    }

    public void markLayoutSeen() {
        this.mHasNewLayout = false;
    }

    public float getLayoutX() {
        return this.mLeft;
    }

    public float getLayoutY() {
        return this.mTop;
    }

    public float getLayoutWidth() {
        return this.mWidth;
    }

    public float getLayoutHeight() {
        return this.mHeight;
    }

    public boolean getDoesLegacyStretchFlagAffectsLayout() {
        return this.mDoesLegacyStretchFlagAffectsLayout;
    }

    public float getLayoutMargin(YogaEdge yogaEdge) {
        switch (yogaEdge) {
            case LEFT:
                return this.mMarginLeft;
            case TOP:
                return this.mMarginTop;
            case RIGHT:
                return this.mMarginRight;
            case BOTTOM:
                return this.mMarginBottom;
            case START:
                return getLayoutDirection() == YogaDirection.RTL ? this.mMarginRight : this.mMarginLeft;
            case END:
                return getLayoutDirection() == YogaDirection.RTL ? this.mMarginLeft : this.mMarginRight;
            default:
                throw new IllegalArgumentException("Cannot get layout margins of multi-edge shorthands");
        }
    }

    public float getLayoutPadding(YogaEdge yogaEdge) {
        switch (yogaEdge) {
            case LEFT:
                return this.mPaddingLeft;
            case TOP:
                return this.mPaddingTop;
            case RIGHT:
                return this.mPaddingRight;
            case BOTTOM:
                return this.mPaddingBottom;
            case START:
                return getLayoutDirection() == YogaDirection.RTL ? this.mPaddingRight : this.mPaddingLeft;
            case END:
                return getLayoutDirection() == YogaDirection.RTL ? this.mPaddingLeft : this.mPaddingRight;
            default:
                throw new IllegalArgumentException("Cannot get layout paddings of multi-edge shorthands");
        }
    }

    public float getLayoutBorder(YogaEdge yogaEdge) {
        switch (yogaEdge) {
            case LEFT:
                return this.mBorderLeft;
            case TOP:
                return this.mBorderTop;
            case RIGHT:
                return this.mBorderRight;
            case BOTTOM:
                return this.mBorderBottom;
            case START:
                return getLayoutDirection() == YogaDirection.RTL ? this.mBorderRight : this.mBorderLeft;
            case END:
                return getLayoutDirection() == YogaDirection.RTL ? this.mBorderLeft : this.mBorderRight;
            default:
                throw new IllegalArgumentException("Cannot get layout border of multi-edge shorthands");
        }
    }

    public YogaDirection getLayoutDirection() {
        return YogaDirection.fromInt(this.mLayoutDirection);
    }
}
