package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

@DoNotStrip
public class YogaNodeJNIBatching extends YogaNodeJNIBase {
    private static final byte BORDER = 4;
    private static final byte DOES_LEGACY_STRETCH_BEHAVIOUR = 8;
    private static final byte HAS_NEW_LAYOUT = 16;
    private static final byte LAYOUT_BORDER_START_INDEX = 14;
    private static final byte LAYOUT_DIRECTION_INDEX = 5;
    private static final byte LAYOUT_EDGE_SET_FLAG_INDEX = 0;
    private static final byte LAYOUT_HEIGHT_INDEX = 2;
    private static final byte LAYOUT_LEFT_INDEX = 3;
    private static final byte LAYOUT_MARGIN_START_INDEX = 6;
    private static final byte LAYOUT_PADDING_START_INDEX = 10;
    private static final byte LAYOUT_TOP_INDEX = 4;
    private static final byte LAYOUT_WIDTH_INDEX = 1;
    private static final byte MARGIN = 1;
    private static final byte PADDING = 2;
    @DoNotStrip
    private float[] arr = null;
    private boolean mHasNewLayout = true;
    @DoNotStrip
    private int mLayoutDirection = 0;

    public YogaNodeJNIBatching() {
    }

    public YogaNodeJNIBatching(YogaConfig yogaConfig) {
        super(yogaConfig);
    }

    public void reset() {
        super.reset();
        this.arr = null;
        this.mHasNewLayout = true;
        this.mLayoutDirection = 0;
    }

    public float getLayoutX() {
        float[] fArr = this.arr;
        return fArr != null ? fArr[3] : BitmapDescriptorFactory.HUE_RED;
    }

    public float getLayoutY() {
        float[] fArr = this.arr;
        return fArr != null ? fArr[4] : BitmapDescriptorFactory.HUE_RED;
    }

    public float getLayoutWidth() {
        float[] fArr = this.arr;
        return fArr != null ? fArr[1] : BitmapDescriptorFactory.HUE_RED;
    }

    public float getLayoutHeight() {
        float[] fArr = this.arr;
        return fArr != null ? fArr[2] : BitmapDescriptorFactory.HUE_RED;
    }

    public boolean getDoesLegacyStretchFlagAffectsLayout() {
        float[] fArr = this.arr;
        return fArr != null && (((int) fArr[0]) & 8) == 8;
    }

    public float getLayoutMargin(YogaEdge yogaEdge) {
        float[] fArr = this.arr;
        if (fArr == null || (((int) fArr[0]) & 1) != 1) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        switch (yogaEdge) {
            case LEFT:
                return this.arr[6];
            case TOP:
                return this.arr[7];
            case RIGHT:
                return this.arr[8];
            case BOTTOM:
                return this.arr[9];
            case START:
                return getLayoutDirection() == YogaDirection.RTL ? this.arr[8] : this.arr[6];
            case END:
                return getLayoutDirection() == YogaDirection.RTL ? this.arr[6] : this.arr[8];
            default:
                throw new IllegalArgumentException("Cannot get layout margins of multi-edge shorthands");
        }
    }

    public float getLayoutPadding(YogaEdge yogaEdge) {
        float[] fArr = this.arr;
        if (fArr == null) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        int i = 0;
        if ((((int) fArr[0]) & 2) != 2) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        if ((((int) fArr[0]) & 1) != 1) {
            i = 4;
        }
        int i2 = 10 - i;
        switch (yogaEdge) {
            case LEFT:
                return this.arr[i2];
            case TOP:
                return this.arr[i2 + 1];
            case RIGHT:
                return this.arr[i2 + 2];
            case BOTTOM:
                return this.arr[i2 + 3];
            case START:
                return getLayoutDirection() == YogaDirection.RTL ? this.arr[i2 + 2] : this.arr[i2];
            case END:
                return getLayoutDirection() == YogaDirection.RTL ? this.arr[i2] : this.arr[i2 + 2];
            default:
                throw new IllegalArgumentException("Cannot get layout paddings of multi-edge shorthands");
        }
    }

    public float getLayoutBorder(YogaEdge yogaEdge) {
        float[] fArr = this.arr;
        if (fArr == null) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        int i = 0;
        if ((((int) fArr[0]) & 4) != 4) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        int i2 = 14 - ((((int) fArr[0]) & 1) == 1 ? 0 : 4);
        if ((((int) this.arr[0]) & 2) != 2) {
            i = 4;
        }
        int i3 = i2 - i;
        switch (yogaEdge) {
            case LEFT:
                return this.arr[i3];
            case TOP:
                return this.arr[i3 + 1];
            case RIGHT:
                return this.arr[i3 + 2];
            case BOTTOM:
                return this.arr[i3 + 3];
            case START:
                return getLayoutDirection() == YogaDirection.RTL ? this.arr[i3 + 2] : this.arr[i3];
            case END:
                return getLayoutDirection() == YogaDirection.RTL ? this.arr[i3] : this.arr[i3 + 2];
            default:
                throw new IllegalArgumentException("Cannot get layout border of multi-edge shorthands");
        }
    }

    public YogaDirection getLayoutDirection() {
        float[] fArr = this.arr;
        return YogaDirection.fromInt(fArr != null ? (int) fArr[5] : this.mLayoutDirection);
    }

    public boolean hasNewLayout() {
        float[] fArr = this.arr;
        if (fArr == null) {
            return this.mHasNewLayout;
        }
        if ((((int) fArr[0]) & 16) == 16) {
            return true;
        }
        return false;
    }

    public void markLayoutSeen() {
        float[] fArr = this.arr;
        if (fArr != null) {
            fArr[0] = (float) (((int) fArr[0]) & -17);
        }
        this.mHasNewLayout = false;
    }
}
