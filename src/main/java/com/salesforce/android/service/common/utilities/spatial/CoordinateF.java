package com.salesforce.android.service.common.utilities.spatial;

import android.graphics.Point;
import android.graphics.PointF;
import java.io.Serializable;

public class CoordinateF implements Serializable {
    private final float mX;
    private final float mY;

    public static CoordinateF create(float f2, float f3) {
        return new CoordinateF(f2, f3);
    }

    public static CoordinateF create(PointF pointF) {
        return create(pointF.x, pointF.y);
    }

    public static CoordinateF create(Point point) {
        return create((float) point.x, (float) point.y);
    }

    public static CoordinateF circumference(float f2, float f3) {
        double d2 = (double) f2;
        double cos = Math.cos(Math.toRadians(d2));
        double d3 = (double) f3;
        Double.isNaN(d3);
        double sin = Math.sin(Math.toRadians(d2));
        Double.isNaN(d3);
        return create((float) (cos * d3), (float) (sin * d3));
    }

    private CoordinateF(float f2, float f3) {
        this.mX = f2;
        this.mY = f3;
    }

    public float getX() {
        return this.mX;
    }

    public float getY() {
        return this.mY;
    }

    public CoordinateF plus(float f2, float f3) {
        return create(this.mX + f2, this.mY + f3);
    }

    public CoordinateF plus(SizeF sizeF) {
        return create(this.mX + sizeF.getWidth(), this.mY + sizeF.getHeight());
    }

    public CoordinateF scale(Scale scale) {
        return create(this.mX * scale.getXScale(), this.mY * scale.getYScale());
    }

    public PointF toPoint() {
        return new PointF(this.mX, this.mY);
    }

    public double distanceFrom(CoordinateF coordinateF) {
        float x = this.mX - coordinateF.getX();
        float y = this.mY - coordinateF.getY();
        return Math.sqrt((double) ((x * x) + (y * y)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CoordinateF)) {
            return false;
        }
        CoordinateF coordinateF = (CoordinateF) obj;
        if (this.mX == coordinateF.mX && this.mY == coordinateF.mY) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Float.valueOf((this.mX * 31.0f) + this.mY).hashCode();
    }

    public String toString() {
        return "[" + this.mX + "," + this.mY + "]";
    }
}
