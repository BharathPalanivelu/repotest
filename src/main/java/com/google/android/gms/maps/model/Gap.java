package com.google.android.gms.maps.model;

public final class Gap extends PatternItem {
    public final float length;

    public Gap(float f2) {
        super(2, Float.valueOf(Math.max(f2, BitmapDescriptorFactory.HUE_RED)));
        this.length = Math.max(f2, BitmapDescriptorFactory.HUE_RED);
    }

    public final String toString() {
        float f2 = this.length;
        StringBuilder sb = new StringBuilder(29);
        sb.append("[Gap: length=");
        sb.append(f2);
        sb.append("]");
        return sb.toString();
    }
}
