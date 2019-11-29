package com.salesforce.android.service.common.utilities.spatial;

import java.io.Serializable;

public class Scale implements Serializable {
    private final float mXScale;
    private final float mYScale;

    public static Scale create(float f2) {
        return create(f2, f2);
    }

    public static Scale create(float f2, float f3) {
        return new Scale(f2, f3);
    }

    private Scale(float f2, float f3) {
        this.mXScale = f2;
        this.mYScale = f3;
    }

    public float getXScale() {
        return this.mXScale;
    }

    public float getYScale() {
        return this.mYScale;
    }

    public Scale invert() {
        return create(1.0f / this.mXScale, 1.0f / this.mYScale);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scale)) {
            return false;
        }
        Scale scale = (Scale) obj;
        if (this.mXScale == scale.mXScale && this.mYScale == scale.mYScale) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Float.valueOf((this.mXScale * 31.0f) + this.mYScale).hashCode();
    }

    public String toString() {
        return "[" + this.mXScale + "," + this.mYScale + "]";
    }
}
