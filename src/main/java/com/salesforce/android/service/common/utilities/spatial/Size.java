package com.salesforce.android.service.common.utilities.spatial;

import android.graphics.Point;
import android.graphics.Rect;
import java.io.Serializable;

public class Size implements Serializable {
    private final int mHeight;
    private final int mWidth;

    public static Size create(int i, int i2) {
        return new Size(i, i2);
    }

    public static Size create(Point point) {
        return create(point.x, point.y);
    }

    public static Size create(Rect rect) {
        return create(rect.width(), rect.height());
    }

    public static Size create(SizeF sizeF) {
        return create(Math.round(sizeF.getWidth()), Math.round(sizeF.getHeight()));
    }

    private Size(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public Size plus(int i, int i2) {
        return create(this.mWidth + i, this.mHeight + i2);
    }

    public Size scale(Scale scale) {
        return create(Math.round(((float) this.mWidth) * scale.getXScale()), Math.round(((float) this.mHeight) * scale.getYScale()));
    }

    public boolean isHorizontal() {
        return this.mWidth > this.mHeight;
    }

    public Size rotate() {
        return create(this.mHeight, this.mWidth);
    }

    public Size rotate(Orientation orientation) {
        boolean isHorizontal = isHorizontal();
        return isHorizontal != (isHorizontal ? Orientation.LANDSCAPE : Orientation.PORTRAIT).plus(orientation).isLandscape() ? rotate() : this;
    }

    public float getRatio() {
        return ((float) this.mWidth) / ((float) this.mHeight);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        if (this.mWidth == size.mWidth && this.mHeight == size.mHeight) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.mWidth * 31) + this.mHeight;
    }

    public String toString() {
        return "[" + this.mWidth + "," + this.mHeight + "]";
    }
}
