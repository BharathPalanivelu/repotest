package com.salesforce.android.service.common.utilities.spatial;

import android.graphics.Point;
import java.io.Serializable;

public class Coordinate implements Serializable {
    private final int mX;
    private final int mY;

    public static Coordinate create(int i, int i2) {
        return new Coordinate(i, i2);
    }

    public static Coordinate create(Point point) {
        return create(point.x, point.y);
    }

    public static Coordinate create(CoordinateF coordinateF) {
        return create(Math.round(coordinateF.getX()), Math.round(coordinateF.getY()));
    }

    private Coordinate(int i, int i2) {
        this.mX = i;
        this.mY = i2;
    }

    public int getX() {
        return this.mX;
    }

    public int getY() {
        return this.mY;
    }

    public Coordinate plus(int i, int i2) {
        return create(this.mX + i, this.mY + i2);
    }

    public Coordinate scale(Scale scale) {
        return create(Math.round(((float) this.mX) * scale.getXScale()), Math.round(((float) this.mY) * scale.getYScale()));
    }

    public Point toPoint() {
        return new Point(this.mX, this.mY);
    }

    public double distanceFrom(Coordinate coordinate) {
        int x = this.mX - coordinate.getX();
        int y = this.mY - coordinate.getY();
        return Math.sqrt((double) ((x * x) + (y * y)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Coordinate)) {
            return false;
        }
        Coordinate coordinate = (Coordinate) obj;
        if (this.mX == coordinate.mX && this.mY == coordinate.mY) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.mX * 31) + this.mY;
    }

    public String toString() {
        return "[" + this.mX + "," + this.mY + "]";
    }
}
