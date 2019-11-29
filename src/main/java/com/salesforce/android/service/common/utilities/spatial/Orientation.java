package com.salesforce.android.service.common.utilities.spatial;

public class Orientation {
    public static Orientation EAST = create(90);
    public static Orientation LANDSCAPE = EAST;
    private static final int MAX_ORIENTATION = 360;
    public static Orientation NORTH = create(0);
    private static final int ORIENTATION_0 = 0;
    private static final int ORIENTATION_180 = 180;
    private static final int ORIENTATION_270 = 270;
    private static final int ORIENTATION_90 = 90;
    public static Orientation PORTRAIT = NORTH;
    public static Orientation SOUTH = create(180);
    public static Orientation WEST = create(270);
    private final int mValue;

    public static Orientation create(int i) {
        return new Orientation(i);
    }

    public static Orientation wrap(int i) {
        int i2 = i % MAX_ORIENTATION;
        if (i2 < 0) {
            i2 += MAX_ORIENTATION;
        }
        return new Orientation(i2);
    }

    private Orientation(int i) {
        this.mValue = i;
    }

    public int getValue() {
        return this.mValue;
    }

    public Orientation plus(int i) {
        return wrap(this.mValue + i);
    }

    public Orientation plus(Orientation orientation) {
        return wrap(this.mValue + orientation.getValue());
    }

    public Orientation subtract(Orientation orientation) {
        return wrap(this.mValue - orientation.getValue());
    }

    public Orientation invert() {
        return wrap(360 - this.mValue);
    }

    public boolean isPortrait() {
        int i = this.mValue;
        return i == 0 || i == 180;
    }

    public boolean isLandscape() {
        int i = this.mValue;
        return i == 90 || i == 270;
    }

    public boolean equals(Orientation orientation) {
        return this.mValue == orientation.getValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Orientation) || this.mValue != ((Orientation) obj).mValue) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Integer.valueOf(this.mValue).hashCode();
    }

    public String toString() {
        return "[" + this.mValue + "]";
    }
}
