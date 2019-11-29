package com.salesforce.android.service.common.utilities.spatial;

import android.graphics.PointF;
import java.io.Serializable;

public class SizeF implements Serializable {
    private final float mHeight;
    private final float mWidth;

    public static SizeF create(float f2, float f3) {
        return new SizeF(f2, f3);
    }

    public static SizeF create(PointF pointF) {
        return create(pointF.x, pointF.y);
    }

    public SizeF(float f2, float f3) {
        this.mWidth = f2;
        this.mHeight = f3;
    }

    public float getWidth() {
        return this.mWidth;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public SizeF plus(float f2, float f3) {
        return create(this.mWidth + f2, this.mHeight + f3);
    }

    public SizeF scale(Scale scale) {
        return create(this.mWidth * scale.getXScale(), this.mHeight * scale.getYScale());
    }

    public boolean isHorizontal() {
        return this.mWidth > this.mHeight;
    }

    public SizeF rotate() {
        return create(this.mHeight, this.mWidth);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SizeF)) {
            return false;
        }
        SizeF sizeF = (SizeF) obj;
        if (this.mWidth == sizeF.mWidth && this.mHeight == sizeF.mHeight) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Float.valueOf((this.mWidth * 31.0f) + this.mHeight).hashCode();
    }

    public String toString() {
        return "[" + this.mWidth + "," + this.mHeight + "]";
    }
}
